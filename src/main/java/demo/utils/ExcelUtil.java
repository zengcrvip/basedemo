package demo.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;



/**
 * 导出excel工具类
 * @author 15020105
 *
 */
public class ExcelUtil {
    
	/**excel标题样式*/
    private static final String SKEY_TITLE = "title";
    /**excel小标题样式*/
    private static final String SKEY_SMALL_TITLE = "smallTitle";
    /**excel报表头样式*/
    private static final String SKEY_HEAD = "head";
    /**excel数据样式*/
    private static final String SKEY_DATA = "data";
    /**excel标题样式*/
    private static final String SKEY_ROW_SPLIT = "rowSplit";
    /**excel合并单元格样式*/
    private static final String SKEY_MERGE = "merge";
    /**excel默认最大列宽*/
    private static final short MAX_COLUMN_WIDTH = 20;
    /**excel默认最小列宽*/
    private static final short MIN_COLUMN_WIDTH = 11;
    /**excel默认支持最大列数*/
    private static final short MAX_COLUMN_NUMBER = 200;
    
    
    
    private static ExcelUtil excelUtil = null;
    private ExcelUtil(){}
    
    public static ExcelUtil getInstance(){
    	if(excelUtil == null) {
    		excelUtil = new ExcelUtil();
    	}
    	return excelUtil;
    }
    
    /**
     * 默认样式导出
     * @param  dataList数据列表
     * @param out 输出流
     * @throws IOException
     */
    public  void exportExcel(List<ExcelRowEntity> dataList,OutputStream out) throws IOException{
    	writeToExcel(dataList,out,null,null,MAX_COLUMN_NUMBER);
    }
    
    /**
     * 给定样式导出
     * @param dataList 数据列表
     * @param out 输出流
     * @param sheetName sheet名称
     * @param styleMap样式列表，键为ExcelUtil.SKEY_TITLE等，可单独填某一种样式，其它默认
     * @throws IOException
     */
    public  void exportExcel(List<ExcelRowEntity> dataList,OutputStream out,String sheetName) throws IOException{
    	writeToExcel(dataList,out,sheetName,null,MAX_COLUMN_NUMBER);
    }
    
    /**
     * 给定样式导出
     * @param dataList 数据列表
     * @param out 输出流
     * @param styleMap样式列表，键为ExcelUtil.SKEY_TITLE等，可单独填某一种样式，其它默认
     * @throws IOException
     */
    public  void exportExcel(List<ExcelRowEntity> dataList,OutputStream out,Map<String,HSSFCellStyle> newStyleMap) throws IOException{
    	writeToExcel(dataList,out,null,newStyleMap,MAX_COLUMN_NUMBER);
    }
    
    /**
     * 给定样式导出
     * @param dataList 数据列表
     * @param out 输出流
     * @param sheetName sheet名称
     * @param styleMap样式列表，键为ExcelUtil.SKEY_TITLE等，可单独填某一种样式，其它默认
     * @throws IOException
     */
    public  void exportExcel(List<ExcelRowEntity> dataList,OutputStream out,String sheetName,Map<String,HSSFCellStyle> newStyleMap) throws IOException{
    	writeToExcel(dataList,out,sheetName,newStyleMap,MAX_COLUMN_NUMBER);
    }
    
    /**
     * 给定样式导出
     * @param dataList 数据列表
     * @param out 输出流
     * @param sheetName sheet名称
     * @param styleMap样式列表，键为ExcelUtil.SKEY_TITLE等，可单独填某一种样式，其它默认
     * @throws IOException
     */
    public  void exportExcel(List<ExcelRowEntity> dataList,OutputStream out,String sheetName,
    		Map<String,HSSFCellStyle> newStyleMap,int maxColumnNumber) throws IOException{
    	writeToExcel(dataList,out,sheetName,newStyleMap,maxColumnNumber);
    }
    
    
    /**
     * 把数据写入excel
     * @param dataList
     * @param out
     * @param sheetName
     * @param newStyleMap
     * @throws IOException
     */
    private void writeToExcel(List<ExcelRowEntity> dataList,OutputStream out,String sheetName,
    		Map<String,HSSFCellStyle> newStyleMap,int maxColumnNumber)
    		throws IOException{
    	
    	if(dataList == null) {return;}
    	 // 声明一个工作薄  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        /**excel默认样式*/
        Map<String,HSSFCellStyle> styleMap = initDefaultStyleMap(workbook);
        // 生成一个虚拟表格  
        HSSFSheet sheet = workbook.createSheet(sheetName==null?"sheet1":sheetName);  
        short [][]juge = new short[dataList.size()+1000][maxColumnNumber];
        for(int row=0;row<juge.length;row++) {
            for(int col=0;col<juge[row].length;col++) {
                juge[row][col] = 0;
            }
        }
        
        for(int rowidx=0;rowidx<dataList.size();rowidx++) {
            ExcelRowEntity excelRow = dataList.get(rowidx);
            //取行类型
            int rowType = excelRow.getRowType();
            //取行中包含的cell列表
            List<ExcelCellEntity> colList = excelRow.getCellEntityList();
            
            int readRow = 0;
            uploop:
            for(int row1=rowidx;row1<=1000;row1++) {
            	short []colBoArr = juge[row1];
            	for(short colBo:colBoArr) {
            		 if(colBo == 2) {
            			 continue uploop;
            		 } else if(colBo == 0) {
            			 readRow = row1;
            			 break uploop;
            		 }
            	}
            }
            
            //创建新行
            HSSFRow row = sheet.createRow(readRow);
            row.setHeight(excelRow.getRowHeight());
            row.setHeightInPoints(excelRow.getRowHeight());
            
            //填充每个列
            for(int colidx=0,collen = colList.size();colidx<collen;colidx++) {
                ExcelCellEntity data = colList.get(colidx);
                int rowSpan = data.getRowSpan();
                int colSpan = data.getColSpan();
                String text = data.getText();
                int readCol = 0;
                for(int col1=colidx;col1<=1000;col1++) {
                    if(juge[readRow][col1] == 0){
                        readCol = col1;
                        break;
                    }
                }
                if(rowSpan*colSpan >1) {
                    for(int row1=readRow;row1<=readRow+rowSpan-1;row1++) {
                        for(int col=readCol;col<=readCol+colSpan-1;col++) {
                        	juge[row1][col] = 1;
                        }
                        //修改最后一个元素为2
                        if(colidx == collen-1) {
                    		juge[row1][readCol+colSpan] = 2;
                    	}
                    }
                    //被合并的单元格式设置样式，保持统一
                    for(int kk = readCol+1;kk<=readCol+colSpan-1;kk++) {
                        HSSFCell cellMerge = row.createCell(kk);
                        cellMerge.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_MERGE));
                    }
                    sheet.addMergedRegion(new CellRangeAddress(readRow,readRow+rowSpan-1,readCol,readCol+colSpan-1));
                } else {
                	juge[readRow][readCol] = 1;
                	//修改最后一个元素为2
                	if(colidx == collen-1) {
                		juge[readRow][readCol+1] = 2;
                	}
                	
                }
                HSSFCell cell = row.createCell(readCol);
                if(text != null){
                    cell.setCellValue(text.replaceAll("\r\n", "\n").replaceAll("<br/>", "\n"));
                }
               
                //设置excel样式
                switch(rowType) {
                case ExcelRowEntity.TITLE_ROW ://大标题行
                    cell.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_TITLE));
                    break;
                case ExcelRowEntity.SMALL_TITLE_ROW ://小标题行
                    cell.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_SMALL_TITLE));
                    break;
                case ExcelRowEntity.HEAD_ROW ://表头行
                    cell.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_HEAD));
                    sheet.setColumnWidth(readCol, getStrLenth(text)* 256);
                    break;
                case ExcelRowEntity.SPLIT_ROW ://分割行
                    cell.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_ROW_SPLIT));
                    break;
                default ://默认是数据行
                    cell.setCellStyle(nvlStyle(newStyleMap,styleMap,ExcelUtil.SKEY_DATA));
                }
            }
        }
        workbook.write(out);  
    }
    
    /**
     * 初始化样式
     * @param workbook
     */
    private Map<String,HSSFCellStyle> initDefaultStyleMap(HSSFWorkbook workbook) {
    	    Map<String,HSSFCellStyle> styleMap = new HashMap<String,HSSFCellStyle>();
            String fontName = "宋体";
            short HEAD_BACK_COLOR = 9,SPLIT_BACK_COLOR = 10;
            //可以自定义颜色，然后在下面直接引用即可，颜色的索引还必须是 0x08 ~ 0x40 (8 ~ 64) 的数字
            HSSFPalette palette = workbook.getCustomPalette();
            palette.setColorAtIndex(HEAD_BACK_COLOR,(byte)(0xff&135),(byte)(0xff&206),(byte)(0xff&235));
            palette.setColorAtIndex(SPLIT_BACK_COLOR,(byte)(0xff&176),(byte)(0xff&224),(byte)(0xff&230));
            
            HSSFCellStyle style = workbook.createCellStyle(); 
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);     //左边框
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);    //右边框
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);    //顶边框
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);    //顶边框
            HSSFFont font = workbook.createFont();
            font.setFontName(fontName);
            font.setColor(HSSFColor.BLACK.index);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setFontHeightInPoints((short)10);//字体
            style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            style.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);    //填充的背景颜色
            style.setFont(font);
            style.setWrapText(true);
            styleMap.put(ExcelUtil.SKEY_TITLE, style);
            
            HSSFCellStyle style1 = workbook.createCellStyle();
            style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);    //设置边框样式
            style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);     //左边框
            style1.setBorderRight(HSSFCellStyle.BORDER_THIN);    //右边框
            HSSFFont font1 = workbook.createFont();
            font1.setFontName(fontName);
            font1.setColor(HSSFColor.BLACK.index);
            font1.setFontHeightInPoints((short)10);//字体
            style1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            style1.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
            style1.setFont(font1);
            style1.setWrapText(true);
            styleMap.put(ExcelUtil.SKEY_SMALL_TITLE, style1);
            
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);    //设置边框样式
            style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);     //左边框
            style2.setBorderRight(HSSFCellStyle.BORDER_THIN);    //右边框
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); // 填充单元格
            style2.setFillForegroundColor(HEAD_BACK_COLOR);    //填充的背景颜色
            HSSFFont font2 = workbook.createFont();
            font2.setFontName(fontName);
            font2.setColor(HSSFColor.BLACK.index);
            font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font2.setFontHeightInPoints((short)10);//字体
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style2.setFont(font2);
            style2.setWrapText(true);
            styleMap.put(ExcelUtil.SKEY_HEAD, style2);
            
            HSSFCellStyle style3 = workbook.createCellStyle();
            HSSFFont font3 = workbook.createFont();
            //font3.setFontName(fontName);
            font3.setColor(HSSFColor.BLACK.index);
            font3.setFontHeightInPoints((short)10);//字体
            style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style3.setFont(font3);
            style3.setWrapText(true);
            styleMap.put(ExcelUtil.SKEY_DATA, style3);
            
            HSSFCellStyle style5 = workbook.createCellStyle();
            style5.setBorderBottom(HSSFCellStyle.BORDER_THIN);    //设置边框样式
            style5.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style5.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style5.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFFont font5 = workbook.createFont();
            //font5.setFontName(fontName);
            font5.setColor(HSSFColor.BLACK.index);
            font5.setFontHeightInPoints((short)10);//字体
            style5.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            style5.setVerticalAlignment(HSSFCellStyle.ALIGN_RIGHT);
            style5.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); // 填充单元格
            style5.setFillForegroundColor(SPLIT_BACK_COLOR);    //填充的背景颜色
            style5.setFont(font5);
            style5.setWrapText(true);
            styleMap.put(ExcelUtil.SKEY_ROW_SPLIT, style5);
            
            HSSFCellStyle style6 = workbook.createCellStyle();
            style6.setBorderBottom(HSSFCellStyle.BORDER_THIN);    //设置边框样式
            style6.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style6.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style6.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            styleMap.put(ExcelUtil.SKEY_MERGE, style6);
            
            return styleMap;
    }
    
    /**
     * 动态计算列宽
     * @param str 列表内容字符串
     * @return
     */
    private int getStrLenth(String str) {
        int len = Math.round(str.getBytes().length*1.2f);
        len = len<ExcelUtil.MIN_COLUMN_WIDTH?ExcelUtil.MIN_COLUMN_WIDTH:len;
        len = len>ExcelUtil.MAX_COLUMN_WIDTH?ExcelUtil.MAX_COLUMN_WIDTH:len;
        return len;
    }
    
    /**
     * 取样式，如果第一个样式为空则取第二个，否则取第一个
     * @param first
     * @param second
     * @return
     */
    private HSSFCellStyle nvlStyle(Map<String,HSSFCellStyle> firstMap,Map<String,HSSFCellStyle> secondMap,String key){
    	if(firstMap == null){ 
    		return secondMap.get(key);
    	}
    	HSSFCellStyle cs = firstMap.get(key);
    	if(cs == null) {
    		return secondMap.get(key);
    	}
    	return cs;
    }
    
    
    
    
     public static void main(String[] args) {  
        try {
             OutputStream out = new FileOutputStream("E://ss.xls");
             List<ExcelRowEntity> dataList = new ArrayList<ExcelRowEntity>();
             ExcelRowEntity er = new ExcelRowEntity();
             er.setRowType(ExcelRowEntity.HEAD_ROW);
             
             
             
             List<ExcelCellEntity> tabList = new ArrayList<ExcelCellEntity>();
             tabList.add(new ExcelCellEntity(2,1,"第一行第一列"));
             tabList.add(new ExcelCellEntity(2,1,"第一行第二列"));
             tabList.add(new ExcelCellEntity(1,3,"第一行第三列"));
             tabList.add(new ExcelCellEntity(1,2,"第一行第四列"));
             tabList.add(new ExcelCellEntity(1,2,"第一行第五列"));
             er.setCellEntityList(tabList);
             dataList.add(er);
             
             er = new ExcelRowEntity();
             er.setRowType(ExcelRowEntity.HEAD_ROW);
             tabList = new ArrayList<ExcelCellEntity>();
             tabList.add(new ExcelCellEntity(1,1,"第二行第一列"));
             tabList.add(new ExcelCellEntity(1,1,"第二行第二列"));
             tabList.add(new ExcelCellEntity(1,1,"第二行"));
             tabList.add(new ExcelCellEntity(1,1,"第二"));
             tabList.add(new ExcelCellEntity(1,1,"第二行第五"));
             tabList.add(new ExcelCellEntity(1,1,"第二行第六列"));
             tabList.add(new ExcelCellEntity(1,1,"第二行第"));
             er.setCellEntityList(tabList);
             dataList.add(er);
             
             ExcelUtil ep = new ExcelUtil();
             ep.exportExcel(dataList,out);
             
        } catch (Exception e) {
            e.printStackTrace();
        }  
     }
     
    
    
}
