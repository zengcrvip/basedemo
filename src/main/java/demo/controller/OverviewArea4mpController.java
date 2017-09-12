package demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/SaleOverview4mp/area")
public class OverviewArea4mpController {

	@Autowired
//	private ReportCommonService commonService;
	
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
//		Map<String, Object> objs = commonService.getUserObjects(account);
		Map<String, Object> objs = new HashMap<String,Object>();
		Map<String, Object> sector = new HashMap<String,Object>();
		List<Map<String,Object>> sectorList = new ArrayList<Map<String,Object>>();
		sector.put("ID", "00006");
		sector.put("NAME", "通讯");
		objs.put("SECTOR", sector);
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
			}else if(objs.get("AREA_ID") == null){
				objs.put("CHECKERR", "用户无大区权限");
			}
		}
		return objs;
	}
	
	/**
	 * 大区销售总览报表
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
	  		model.put("adminScope", "admin"); // 管理范围：区域
	  		model.put("sector", usrObjs.get("SECTOR"));	        // 负责事业部，默认第一个
	  		model.put("areaId", usrObjs.get("AREA_ID"));        // 所属大区
	  		model.put("areaName", usrObjs.get("AREA_NAME"));
	  		model.put("sectors", usrObjs.get("SECTORS"));       // 负责事业部
	  		// 对比区域：所有大区及大区下所有门店
	  		List<Map<String,Object>> areaList = new ArrayList<Map<String,Object>>();
	  		Map<String,Object> area1 = new HashMap<String,Object>();
	  		area1.put("ID", "10001");area1.put("NAME", "南京");areaList.add(area1);
	  		Map<String,Object> area2 = new HashMap<String,Object>();
	  		area2.put("ID", "10039");area2.put("NAME", "苏州");areaList.add(area2);
	  		Map<String,Object> area3 = new HashMap<String,Object>();
	  		area3.put("ID", "10002");area3.put("NAME", "无锡");areaList.add(area3);
	  		Map<String,Object> area4 = new HashMap<String,Object>();
	  		area4.put("ID", "10031");area4.put("NAME", "徐州");areaList.add(area4);
	  		
//	  		model.put("areas", commonService.getAreas());
	  		model.put("areas", areaList);
	  		
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
	  		
//	  		model.put("stores", commonService.getStores(areaId));
	  		model.put("stores", storeList);
	  	    return new ModelAndView("salereports/areaReport4mp.ftl", model); 
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
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
        return new ModelAndView("salereports/parts4mp/general.ftl", model); 
    }
	
	/**
	 * 通讯:运营商概况
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/telcom")
    public ModelAndView telcomPart(@RequestParam String period, String sectorId, String currDate, String compDate) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
        return new ModelAndView("salereports/parts4mp/telcom.ftl", model); 
    }
	
	/**
	 * 排名概况:品牌
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ranking/brand")
    public ModelAndView brandRanking(@RequestParam String period, String sectorId, String currDate, String compDate, String compArea, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/ranking-brand.ftl", model); 
    }
	
	/**
	 * 排名概况:商品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ranking/goods")
    public ModelAndView goodsRanking(@RequestParam String period, String sectorId, String currDate, String compDate, String compArea, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/ranking-goods.ftl", model); 
    }
	
	/**
	 * 排名概况:主推商品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ranking/maingoods")
    public ModelAndView maingoodsRanking(@RequestParam String period, String sectorId, String currDate, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/ranking-maingoods.ftl", model); 
    }
	
	/**
	 * 排名概况:渠道分布
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ranking/channel")
    public ModelAndView channelRanking(@RequestParam String period, String sectorId, String currDate, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/ranking-channel.ftl", model); 
    }
	
	/**
	 * 销售明细
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/details")
    public ModelAndView detailsPart(@RequestParam String period, String sectorId, String areaId, String currDate) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");                       // 组织类别
  		model.put("period", period);
  		model.put("isDrill", areaId != null);               // 是否钻取
        return new ModelAndView("salereports/parts4mp/details.ftl", model); 
    }
    
	/**
	 * 品牌门店销售排名
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/brand/details")
    public ModelAndView detailsBrand(@RequestParam String period, String sectorId, String areaId, String brandId, String currDate, String compDate, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/details-brand.ftl", model); 
    }
    
	/**
	 * 主推门店销售排名
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/maingoods/details")
    public ModelAndView detailsMaingoods(@RequestParam String period, String sectorId, String areaId, String modelId, String currDate, String compDate, String index) throws Exception{
  		Map<String, Object> model = new HashMap<String, Object>();
  		model.put("orgType", "area");     // 组织类别
  		model.put("period", period);
  		model.put("index", index);
        return new ModelAndView("salereports/parts4mp/details-maingoods.ftl", model); 
    }
    
}
