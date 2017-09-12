package demo.resolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;



public class PageMethodArgumentProcessor extends ServletModelAttributeMethodProcessor {

	public PageMethodArgumentProcessor(){  
        super(false);   
    }

	public PageMethodArgumentProcessor(boolean annotationNotRequired) {
		super(annotationNotRequired); 
	}

	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.hasParameterAnnotation(PageArgument.class)) {
			return true;
		}
		return false;
	}

	protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
		ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder; 
		super.bindRequestParameters(servletBinder, request);
		Object obj = servletBinder.getTarget();
		if (obj instanceof PageBean) {
			PageBean pageBean = (PageBean)obj;
			
			String rowsStr = request.getParameter("rows");
			if(StringUtils.isNotBlank(rowsStr)){
				pageBean.setLimit(Integer.valueOf(rowsStr));
			}
			
			pageBean.setRows(new ArrayList());
			Map<String,String> condition = genCondition(request);
			pageBean.setCondition(condition);
			
		}
		
	}
	
	private Map<String,String> genCondition(NativeWebRequest request) {
		Map<String,String> condition = new HashMap<String,String>();
		Map<String,String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String,String[]> entry : parameterMap.entrySet()) {
			String sourceKey = entry.getKey();
			if (sourceKey.startsWith("filter.")) {
				String targetKey = sourceKey.substring(sourceKey.indexOf(".")+1);
				String[] value = (String[])entry.getValue();

				if (value.length > 0 && StringUtils.isNotBlank(value[0]) && !"-1".equals(value[0])) {
					condition.put(targetKey, value[0]);
				}
			}
		}
		return condition;
	}
}
