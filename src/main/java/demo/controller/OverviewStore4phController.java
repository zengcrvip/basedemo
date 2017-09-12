package demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import demo.utils.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * 销售总览报表
 * @author 15050873
 *
 */
@Controller
@RequestMapping("/SaleOverview4ph/store")
public class OverviewStore4phController {

//	@Autowired
//	private ReportCommonService commonService;
//	
//	@Autowired
//	private OverviewStoreService overviewService;
	
	/**
	 * 获取用户账号, 从会话信息取得
	 * @return
	 */
	private String getUserAccount(HttpServletRequest request){
		return "14111638";
	}
	
	/**
	 * 获取账户对象
	 * @param usrObjs
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getUserObjects(String account){
		Map<String, Object> objs = new HashMap<String,Object>();
		Map<String, Object> sector = new HashMap<String,Object>();
		List<Map<String,Object>> sectorList = new ArrayList<Map<String,Object>>();
		sector.put("ID", "00006");
		sector.put("NAME", "通讯");
		objs.put("SECTOR", sector);
		objs.put("STORE_ID", "7611");
		objs.put("STORE_NAME", "南京山西路店");
		objs.put("AREA_ID", "10001");
		objs.put("AREA_NAME", "南京大区");
		sectorList.add(sector);
		objs.put("SECTORS",sectorList );
		if(objs == null){
			objs = new HashMap<String, Object>();
			objs.put("CHECKERR", "用户不存在于系统");
		}else{
			List<Map<String, Object>> sectors = (List<Map<String, Object>>) objs.get("SECTORS");
			if(sectors.size() == 0){
				objs.put("CHECKERR", "用户无事业部权限");
			}else if(objs.get("STORE_ID") == null){
				objs.put("CHECKERR", "用户无门店权限");
			}
		}
		return objs;
	}

	/**
	 * 门店销售总览报表
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/report")
    public ModelAndView storeReport(HttpServletRequest request,@RequestParam String period) throws Exception{
		String account = getUserAccount(request);
		Map<String, Object> usrObjs = getUserObjects(account);
  		Map<String, Object> model = new HashMap<String, Object>();
		if(!usrObjs.containsKey("CHECKERR")){
	  		model.put("period", period);      // 日报月报
	  		model.put("account", account);    // 账号
	  		model.put("adminScope", "admin"); // 管理范围：门店
	  		model.put("sector", usrObjs.get("SECTOR"));	        // 负责事业部，默认第一个
	  		model.put("areaId", usrObjs.get("AREA_ID"));        // 所属大区
	  		model.put("areaName", usrObjs.get("AREA_NAME"));
	  		model.put("storeId", usrObjs.get("STORE_ID"));      // 所属门店
	  		model.put("storeName", usrObjs.get("STORE_NAME"));
	  		model.put("sectors", usrObjs.get("SECTORS"));       // 负责事业部
	  		// 对比区域：所属大区及所属大区下所有门店
	  		String areaId = String.valueOf(usrObjs.get("AREA_ID"));
	  		List<Map<String,Object>> storeList = new ArrayList<Map<String,Object>>();
	  		Map<String,Object> store1 = new HashMap<String,Object>();
	  		store1.put("ID", "10001");store1.put("NAME", "南京");storeList.add(store1);
	  		Map<String,Object> store2 = new HashMap<String,Object>();
	  		store2.put("ID", "10039");store2.put("NAME", "苏州");storeList.add(store2);
	  		Map<String,Object> store3 = new HashMap<String,Object>();
	  		store3.put("ID", "10002");store3.put("NAME", "无锡");storeList.add(store3);
	  		Map<String,Object> store4 = new HashMap<String,Object>();
	  		store4.put("ID", "10031");store4.put("NAME", "徐州");storeList.add(store4);
	  		
	  		
	  		model.put("stores", storeList);
	  	    return new ModelAndView("salereports/storeReport4ph.ftl", model); 
		}else{
	  	    return new ModelAndView("salereports/reportWarn.ftl", usrObjs); 
		}
    }
	
	/**
	 * 销售概况
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/general")
    public ModelAndView generalPart(@RequestParam String period, String sectorId, String currDate, String compDate) throws Exception{
		String storeId = "7611";
		boolean isMonth = "month".equals(period);
		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "store");                       // 组织类别
  		model.put("period", period);
  		model.put("config", ReportConfig.general(sectorId)); // 显示指标配置
  		
  		Map<String,Object> taskMap = new HashMap<String,Object>();
  		taskMap.put("NUM_MGDS", 100);taskMap.put("AMT_GP", 200);taskMap.put("AMT_SALE", 300);
  		model.put("task", taskMap);
  		Map<String,Object> grossprofitMap = new HashMap<String,Object>();
  		model.put("grossprofit",grossprofitMap);
  		Map<String,Object> salesMap = new HashMap<String,Object>();
  		model.put("sales", salesMap);
  		List<Map<String,Object>> mainList = new ArrayList<Map<String,Object>>();
  		Map<String,Object> mainMapA = new HashMap<String,Object>();
  		mainMapA.put("MAIN_LEVEL", "A");mainMapA.put("NUM_SALE", null);mainMapA.put("NUM_TASK", null);mainList.add(mainMapA);
  		Map<String,Object> mainMapB = new HashMap<String,Object>();
  		mainMapB.put("MAIN_LEVEL", "B");mainMapB.put("NUM_SALE", null);mainMapB.put("NUM_TASK", null);mainList.add(mainMapB);
  		Map<String,Object> mainMapC = new HashMap<String,Object>();
  		mainMapC.put("MAIN_LEVEL", "C");mainMapC.put("NUM_SALE", null);mainMapC.put("NUM_TASK", null);mainList.add(mainMapC);
  		model.put("maingoods", mainList);
        return new ModelAndView("salereports/parts4ph/general.ftl", model); 
    }
	
	/**
	 * 通讯:运营商概况
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/telcom")
    public ModelAndView telcomPart(@RequestParam String period, String sectorId, String currDate, String compDate) throws Exception{	
		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "store");                       // 组织类别
  		model.put("period", period);
  		model.put("telcom", new ArrayList<Map<String, Object>>());
        return new ModelAndView("salereports/parts4ph/telcom.ftl", model); 
    }
	
	/**
	 * 维度分析
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/capsule")
    public ModelAndView capsulePart(@RequestParam String type, @RequestParam String period) throws Exception{	
		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "store");                       // 组织类别
  		model.put("period", period);
  		model.put("config", ReportConfig.capsule("store", type));
        return new ModelAndView("salereports/parts4ph/capsule.ftl", model); 
    }
	
}
