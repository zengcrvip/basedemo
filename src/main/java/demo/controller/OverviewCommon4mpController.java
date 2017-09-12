package demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import demo.dto.OverviewDTO;
import demo.dto.ReportResultDTO;
import demo.dto.TelecomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/SaleOverview4mp/common")
public class OverviewCommon4mpController {
	
	@Autowired
//	private CommonService commonService;
	
	/**
	 * 装载入参
	 * @param params
	 * @return
	 */
	private Map<String,Object>  loadParams(HttpServletRequest request,Map<String,Object> params){
		Map<String,Object> queryParams = new HashMap<String,Object>();
//		Cookie cookieAccount = CommonUtils.getCookieByName(request, "account");
//		UserBaseInfo info = commonService.getUserBaseInfo(cookieAccount.getValue()); //当前登录员工信息
		queryParams.put("orgType", "1");                  //组织维度类型
		queryParams.put("orgCode", "10001");					 //组织维度编码
		queryParams.put("deptCode", params.get("sectorId"));                         //事业部编码
		queryParams.put("channelCode", "10,20");                                     //渠道编码，目前只有10,20渠道，写死
		
		if("days".equals((String)params.get("period"))){
			//日报
			String[] currDate = ((String)params.get("currDate")).split("|");
			String[] compDate = ((String)params.get("compDate")).split("|");
			queryParams.put("originalStartDate", currDate[0]);                       //原开始时间
			queryParams.put("originalEndDate", currDate[1]);                         //原结束时间
			queryParams.put("targetStartDate", compDate[0]);                         //比对开始时间
			queryParams.put("targetEndDate", compDate[1]);                           //比对结束时间
		}else if("month".equals((String)params.get("period"))){
			//月报
			queryParams.put("originalMonth", params.get("currDate"));                //原月份
			queryParams.put("targetMonth", params.get("compDate"));                  //比对月份
		}
		
		return queryParams;
	}
	
	/**
     * 获取销售概况-毛利总览数据
     * @param params
     * @return
     */
    @RequestMapping("/getMAOLIData")
    @ResponseBody
    public ReportResultDTO getMAOLIData(HttpServletRequest request,@RequestParam Map<String,Object> params){
    	//查询入参
    	Map<String,Object> queryParams = loadParams(request,params);
    	
    	ReportResultDTO result = new ReportResultDTO("0000","数据加载成功");
    	List<Object> list = new ArrayList<Object>();
    	
    	OverviewDTO dto1 = null;
    	if(queryParams.containsKey("originalMonth")){
    		 dto1 = new OverviewDTO("月毛利额","456789","123456","16.34","45","4","","0");
    	}else if(queryParams.containsKey("originalStartDate")){
    		 dto1 = new OverviewDTO("天毛利额","456789","123456","16.34","45","4","","0");
    	}
    	
    	OverviewDTO dto2 = new OverviewDTO("毛利率1","","12345678","","45","4","","1");
    	OverviewDTO dto3 = new OverviewDTO("毛利率2","","2558","","-45","8","","1");
    	OverviewDTO dto4 = new OverviewDTO("毛利率3","","656","","0.00","4","","1");
    	OverviewDTO dto5 = new OverviewDTO("毛利率4","","8888","","45","7","","1");
    	OverviewDTO dto6 = new OverviewDTO("毛利率5","","12345","","-58","4","","1");
    	OverviewDTO dto7 = new OverviewDTO("毛利率6","","5668","","45","5","","1");
    	OverviewDTO dto8 = new OverviewDTO("毛利率7","","12345","","47","4","","1");
    	OverviewDTO dto9 = new OverviewDTO("毛利率8","","86333","","45","4","","1");
    	OverviewDTO dto10 = new OverviewDTO("毛利率9","","7779666","","","4","","1");
    	list.add(dto1);list.add(dto2);list.add(dto3);list.add(dto4);list.add(dto5);
    	list.add(dto6);list.add(dto7);list.add(dto8);list.add(dto9);list.add(dto10);
    	result.setList(list);
    	return result;
    }
    
    /**
     * 获取销售概况-销售总览数据
     * @param params
     * @return
     */
    @RequestMapping("/getXSData")
    @ResponseBody
    public ReportResultDTO getXSData(HttpServletRequest request,@RequestParam Map<String,Object> params){
    	//查询入参
    	Map<String,Object> queryParams = loadParams(request,params);
    	
    	ReportResultDTO result = new ReportResultDTO("0000","数据加载成功");
    	List<Object> list = new ArrayList<Object>();
    	OverviewDTO dto1 = new OverviewDTO("销售额","456789","123456","16.34","45%","4","","0");
    	OverviewDTO dto2 = new OverviewDTO("销售量1","","12345","","45%","4","","1");
    	OverviewDTO dto3 = new OverviewDTO("销售量2","","2558","","-45%","8","","1");
    	OverviewDTO dto4 = new OverviewDTO("销售量3","","656","","0.00%","4","","1");
    	OverviewDTO dto5 = new OverviewDTO("销售量4","","8888","","45%","7","","1");
    	OverviewDTO dto6 = new OverviewDTO("销售量5","","12345","","58%","4","","1");
    	list.add(dto1);list.add(dto2);list.add(dto3);list.add(dto4);list.add(dto5);list.add(dto6);
    	result.setList(list);
    	return result;
    }
    
    /**
     * 获取销售概况-主推总览数据
     * @param params
     * @return
     */
    @RequestMapping("/getZTData")
    @ResponseBody
    public ReportResultDTO getZTData(HttpServletRequest request,@RequestParam Map<String,Object> params){
    	//查询入参
    	Map<String,Object> queryParams = loadParams(request,params);
    	
    	ReportResultDTO result = new ReportResultDTO("0000","数据成功");
    	List<Object> list = new ArrayList<Object>();
    	OverviewDTO dto1 = new OverviewDTO("主推商品销售量","45678","12345","88.34","45%","4","","0");
    	OverviewDTO dto2 = new OverviewDTO("A类主推","","12345","22.31","45","4","26.25%","1");
    	OverviewDTO dto3 = new OverviewDTO("B类主推","","12345","21.14","45","4","26.25%","1");
    	OverviewDTO dto4 = new OverviewDTO("C类主推","","12345","14.25","45","4","26.25%","1");
    	OverviewDTO dto5 = new OverviewDTO("D类主推","","12345","21.25","-45","4","26.25%","1");
    	OverviewDTO dto6 = new OverviewDTO("E类主推","","12345","14.55","-45","4","26.25%","1");
    	OverviewDTO dto7 = new OverviewDTO("F类主推","","12345","12.25","45","4","26.25%","1");
    	list.add(dto1);list.add(dto2);list.add(dto3);list.add(dto4);list.add(dto5);list.add(dto6);list.add(dto7);
    	result.setList(list);
    	return result;
    }
    
    /**
     * 获取销售概况-运营商总览数据
     * @param params
     * @return
     */
    @RequestMapping("/getTeleComData")
    @ResponseBody
    public  ReportResultDTO getTelecomData(HttpServletRequest request,@RequestParam Map<String,Object> params){
    	//查询入参
    	Map<String,Object> queryParams = loadParams(request,params);
    	
    	ReportResultDTO result = new ReportResultDTO("0000","数据成功");
    	List<Object> list = new ArrayList<Object>();
    	TelecomDTO dto1 = new TelecomDTO("代理用户发展数","123456","36.24","4","0","DL");
    	TelecomDTO dto2 = new TelecomDTO("联通","123",null,null,"1","DL");
    	TelecomDTO dto3 = new TelecomDTO("电信","456",null,null,"1","DL");
    	TelecomDTO dto4 = new TelecomDTO("移动","789",null,null,"1","DL");
    	TelecomDTO dto5 = new TelecomDTO("转售用户发展数","456789","36.24","5","0","ZS");
    	TelecomDTO dto6 = new TelecomDTO("联通","12",null,null,"1","ZS");
    	TelecomDTO dto7 = new TelecomDTO("电信","34",null,null,"1","ZS");
    	TelecomDTO dto8 = new TelecomDTO("移动","90",null,null,"1","ZS");
    	list.add(dto1);list.add(dto2);list.add(dto3);list.add(dto4);list.add(dto5);list.add(dto6);list.add(dto7);list.add(dto8);
    	result.setList(list);
    	return result;
    }

}
