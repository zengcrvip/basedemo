package demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.utils.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * execl导出demo
 * @author 14111638
 *
 */
@Controller
@RequestMapping("tableDownDemo")
public class ExeclDownDemo {
	private Logger logger = Logger.getLogger(getClass());
	
	 /**
     * 数据字段
     */
  private static String[] fields=new String[]{"NAME","AGE"};
	
	/**
	 * table主页
	 * @return
	 */
   @RequestMapping("/table")
    public String hello(){        
        return "execlDemo/table.ftl";
    }
   
   
   /**
    *  导出方式一，通过execl模板导出
    * @param param
    * @param request
    * @param response
    */
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/getDataDown", method = RequestMethod.POST)
   public void getGoodStockDown(@RequestParam Map<String,Object> param,HttpServletRequest request,
           HttpServletResponse response){
       String headInfo = MessageFormat.format("查询时间：{0}","2016-03-30");           
       List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
       Map<String,Object> map1 = new HashMap<String,Object>();
       map1.put("NAME", "张三");
       map1.put("AGE", "20");
       datas.add(map1);
       Map<String,Object> map2 = new HashMap<String,Object>();
       map2.put("NAME", "李四");
       map2.put("AGE", "30");
       datas.add(map2);
       ExcelTemplate template;
	try {
		template = ReportUtils.genMultRowsExcel("DEMO.xls", headInfo, datas);
		template.saveToHttpResponse(response, "DEMO");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   @RequestMapping(value = "/getDataDown2", method = RequestMethod.POST)
   public void downloadAllData(HttpServletRequest request,
           HttpServletResponse response) {
	   List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
       Map<String,Object> map1 = new HashMap<String,Object>();
       map1.put("NAME", "张三");
       map1.put("AGE", "20");
       datas.add(map1);
       Map<String,Object> map2 = new HashMap<String,Object>();
       map2.put("NAME", "李四");
       map2.put("AGE", "30");
       datas.add(map2);
       List<ExcelRowEntity> excelDataList = getExcelData(datas);
       ExportUtils.getInstance().exportData("demotable", excelDataList, request, response);
   }
   
   
   private List<ExcelRowEntity> getExcelData(List<Map<String, Object>> dataList) {
       List<ExcelRowEntity> result = new ArrayList<ExcelRowEntity>();

       // 表头处理-----------------------------------------------
       ExcelRowEntity header = new ExcelRowEntity();
       result.add(header);
       header.setRowType(2);
       List<ExcelCellEntity> cellEntityList1 = new ArrayList<ExcelCellEntity>();
       header.setCellEntityList(cellEntityList1);
       cellEntityList1.add(new ExcelCellEntity(2, 1, "姓名"));
       cellEntityList1.add(new ExcelCellEntity(2, 1, "年龄"));
       cellEntityList1.add(new ExcelCellEntity(1, 2, "爱好"));
       
       ExcelRowEntity header2 = new ExcelRowEntity();
       result.add(header2);
       header2.setRowType(2);
       List<ExcelCellEntity> cellEntityList2 = new ArrayList<ExcelCellEntity>();
       header2.setCellEntityList(cellEntityList2);

       cellEntityList2.add(new ExcelCellEntity(1, 1, "任务"));
       cellEntityList2.add(new ExcelCellEntity(1, 1, "完成"));

       // ----------------数据行--------------------------------------------
       if (null != dataList && dataList.size() > 0) {
           for (int i = 0; i < dataList.size(); i++) {
               Map<String, Object> rowData = dataList.get(i);
               ExcelRowEntity excelRow = new ExcelRowEntity();
               List<ExcelCellEntity> cellEntityList = new ArrayList<ExcelCellEntity>();
               excelRow.setCellEntityList(cellEntityList);
               excelRow.setRowType(-1);
               for (int j = 0; j < fields.length; j++) {
                   String value = "";
                   if (null != rowData.get(fields[j])) {
                       value = ""+rowData.get(fields[j]);
                   }
                   cellEntityList.add(new ExcelCellEntity(1, 1, value));
               }
               result.add(excelRow);
           }
       }

       return result;
   }
   
   
   @RequestMapping(value = "/getDataDown3", method = RequestMethod.POST)
   public void exportExcel(@RequestParam String[] datas, @RequestParam String fileName, HttpServletResponse response) {
       OutputStream ops = null;
       try {
       	fileName = Base64Util.decode(fileName, "UTF-8");
       	String srcFileName = fileName;
           response.setContentType("application/vnd.ms-excel;");
           fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
           response.setHeader("Content-Disposition", "attachment;filename=" +fileName+".xls");

           //把BASE64编码的json解码转换成需要的 List<List<ExcelCellEntity>> 列表
           List<ExcelRowEntity> toList = new ArrayList<ExcelRowEntity>();
           for(String data : datas){
               String decData = null;
               ExcelRowEntity excelRow = null;
               try{
                   decData = Base64Util.decode(data, "UTF-8");
                   excelRow = JsonUtils.fromJsonUseObjectMapper(decData,ExcelRowEntity.class);
                   toList.add(excelRow);
               }catch(Exception e){
                   logger.error("导出Excel行解析异常：" + e.getMessage() + " 数据是: " + data);
                   ExcelCellEntity cell = new ExcelCellEntity();
                   cell.setColSpan(1);
                   cell.setRowSpan(1);
                   cell.setText(decData);
                   ExcelCellEntity cell1 = new ExcelCellEntity();
                   cell1.setColSpan(1);
                   cell1.setRowSpan(1);
                   cell1.setText(e.getMessage());
                   List<ExcelCellEntity> cells = new ArrayList<ExcelCellEntity>();
                   cells.add(cell);
                   cells.add(cell1);
                   excelRow = new ExcelRowEntity();
                   excelRow.setRowType(-1);
                   excelRow.setCellEntityList(cells);
                   toList.add(excelRow);
               }
           }
           //导出excel
           ops =  response.getOutputStream(); 
           ops.flush();
           ExcelUtil.getInstance().exportExcel(toList, ops,srcFileName);
           ops.flush();
       } catch (Exception e) {
       	 e.printStackTrace();
       	logger.info(e.getMessage());
       	logger.debug(e.getStackTrace().toString());
       } finally {
           if(ops !=null) {
               try {
               	ops.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

}
