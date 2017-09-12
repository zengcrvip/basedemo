package demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("freemarketLabelDemo")
public class FreemarketLabelDemo {
	
	@RequestMapping("/getListInfo")
	public ModelAndView getListInfo(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		map1.put("key3", "value3");
		list.add(map1);
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("key1", "top1");
		map2.put("key2", "top2");
		map2.put("key3", "top3");
		list.add(map2);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("list", list);
		model.put("amap", map1);
		return new ModelAndView("freemarkerLabelDemo/listDemo.ftl",model);
	}

}
