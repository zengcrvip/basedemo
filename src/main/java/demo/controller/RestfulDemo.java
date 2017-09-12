package demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
@RequestMapping("/restfulDemo")
public class RestfulDemo {
	private static Logger logger = Logger.getLogger(RestfulDemo.class);
	
	
	@RequestMapping("/demo")
    public ModelAndView loginToIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/restfulDemo/Demo.ftl");
    	return model;
    }
	
	@ResponseBody
	@RequestMapping(value="/employees/{id}", method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public String info(@PathVariable String id){
		String returnStr = "";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "zhangsan");
		map.put("2", "lisi");
		
		if(null == id || "".equals(id)){
			returnStr = "";
			return returnStr;
		}
		
		returnStr = map.get(id).toString();
		return returnStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/employees.json/{id}.json", method=RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		String returnStr = "false";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "zhangsan");
		map.put("2", "lisi");
		
		if(null == id || "".equals(id)){
			returnStr = "false";
			return returnStr;
		}
		
		map.remove(id);
		returnStr = "true";
		return returnStr;
	}
	
	
	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String hello() {
        return "你好！hello";
    }
 
    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String say(@PathVariable(value = "msg") String msg) {
        return "{\"msg\":\"you say:'" + msg + "'\"}";
    }
 
    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
    public @ResponseBody
    Person getPerson(@PathVariable("id") int id) {
        logger.info("获取人员信息id=" + id);
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(30);
        person.setId(id);
        return person;
    }
 
    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
    public @ResponseBody
    Object deletePerson(@PathVariable("id") int id) {
        logger.info("删除人员信息id=" + id);
        Gson gson=new Gson();
        Map<String,String> jsonObject = new HashMap<String,String>();
        jsonObject.put("msg", "删除人员信息成功");
        return gson.toJson(jsonObject);
    }
 
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public @ResponseBody
    Object addPerson(Person person) {
        logger.info("注册人员信息成功id=" + person.getId());
        Gson gson=new Gson();
        Map<String,String> jsonObject = new HashMap<String,String>();
        jsonObject.put("msg", "注册人员信息成功");
        logger.info("name:"+person.getName()+",age:"+person.getAge());
        return gson.toJson(jsonObject);
    }
 
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public @ResponseBody
    Object updatePerson(Person person) {
        logger.info("更新人员信息id=" + person.getId());
        Gson gson=new Gson();
        Map<String,String> jsonObject = new HashMap<String,String>();
        jsonObject.put("msg", "更新人员信息成功");
        return gson.toJson(jsonObject);
    }
 
//    @RequestMapping(value = "/person", method = RequestMethod.PATCH)
//    public @ResponseBody
//    List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
// 
//        logger.info("查询人员name like " + name);
//        List<Person> lstPersons = new ArrayList<Person>();
// 
//        Person person = new Person();
//        person.setName("张三");
//        person.setSex("男");
//        person.setAge(25);
//        person.setId(101);
//        lstPersons.add(person);
// 
//        Person person2 = new Person();
//        person2.setName("李四");
//        person2.setSex("女");
//        person2.setAge(23);
//        person2.setId(102);
//        lstPersons.add(person2);
// 
//        Person person3 = new Person();
//        person3.setName("王五");
//        person3.setSex("男");
//        person3.setAge(27);
//        person3.setId(103);
//        lstPersons.add(person3);
// 
//        return lstPersons;
//    }
	
	
	

}
