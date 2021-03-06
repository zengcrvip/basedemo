package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * 一些相关组件的demo
 * @author 14111638
 *
 */
@Controller
@RequestMapping("/someElementDemo")
public class SomeElementDemo {
	
	/**
	 * 遮盖层的样式
	 * @return
	 */
	@RequestMapping("/blockUIDemo")
	public String blockUIDemo(){
		return "elementDemo/blockUIDemo.ftl";
	}
	
	/**
	 * 下拉框样式
	 * @return
	 */
	@RequestMapping("/selectDemo")
	public  ModelAndView selectDemo(){
		Map<String, Object> model = new HashMap<String, Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("code", 3);map1.put("value", "南京");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("code", 4);map2.put("value", "苏州");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("code", 5);map3.put("value", "无锡");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("code", 6);map4.put("value", "镇江");
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("code", 7);map5.put("value", "常州");
		list.add(map1);list.add(map2);list.add(map3);list.add(map4);list.add(map5);
		model.put("selectOption", list);
		return new ModelAndView("elementDemo/selectDemo.ftl", model); 
	}

	@RequestMapping("/searchCardListByDesc")
	@ResponseBody
	public Map<String,String> getData(HttpServletResponse response) throws Exception {
		Map<String,String> result = new HashMap<String, String>();
		result.put("1","南京");
		result.put("2","苏州");
		result.put("3","无锡");
		result.put("4","上海");
		result.put("5","扬州");
		result.put("6", "镇江");
//		String s = JsonUtils.toJsonUseObjectMapper(result);
//		PrintWriter writer = response.getWriter();
//		writer.print(s);
		return  result;
	}
	
	
	/**
	 * 手机移动端相关元素样式
	 * @return
	 */
	@RequestMapping("/commonDemo")
	public String commonDemo(){
		return "elementDemo/commonDemo.ftl";
	}
	
	
	@RequestMapping("/lianxiDemo")
	public String lianxiDemo(){
		return "elementDemo/lianxiDemo.ftl";
	}

}
