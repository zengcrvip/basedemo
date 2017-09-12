package demo.utils;

import java.io.InputStream;
import java.text.MessageFormat;

import org.xml.sax.InputSource;

import freemarker.ext.dom.NodeModel;

/**
 * 销售报表配置
 * @author 15050873
 *
 */
public class ReportConfig {
	
	private static NodeModel generalCommon = null;
	
	private static NodeModel detailsCommon = null;
	
	private static NodeModel generalTelcom = null;
	
	private static NodeModel detailsTelcom = null;
	
	static{
		// 加载销售概览，销售明细指标配置
  		try {
  			// 通用事业部配置
  			InputStream confIs2 = ReportConfig.class.getResourceAsStream("/conf/report/general-common.xml");
			InputSource ins2 = new InputSource(confIs2);
			generalCommon = NodeModel.parse(ins2);
			InputStream confIs3 = ReportConfig.class.getResourceAsStream("/conf/report/details-common.xml");
			InputSource ins3 = new InputSource(confIs3);
			detailsCommon = NodeModel.parse(ins3);
			// 通讯事业部配置
  			InputStream confIs = ReportConfig.class.getResourceAsStream("/conf/report/general-00006.xml");
			InputSource ins = new InputSource(confIs);
			generalTelcom = NodeModel.parse(ins);
			InputStream confIs1 = ReportConfig.class.getResourceAsStream("/conf/report/details-00006.xml");
			InputSource ins1 = new InputSource(confIs1);
			detailsTelcom = NodeModel.parse(ins1);
		} catch (Exception e) {
			// TODO: handle exception
			
		}  		
	}
	
	/**
	 * 根据事业部加载配置
	 * @param sectorId
	 * @return
	 */
	public static NodeModel general(String sectorId){
		if("00006".equals(sectorId)){
			return generalTelcom;
		}else{
			return generalCommon;
		}
	}
	
	/**
	 * 根据事业部加载配置
	 * @param sectorId
	 * @return
	 */
	public static NodeModel details(String sectorId){
		if("00006".equals(sectorId)){
			return detailsTelcom;
		}else{
			return detailsCommon;
		}
	}
	
	public static NodeModel capsule(String group, String name) throws Exception{
		String filePath = MessageFormat.format("/conf/report4ph/{0}/{1}.xml", group, name);
		InputStream confIs = ReportConfig.class.getResourceAsStream(filePath);
		InputSource ins = new InputSource(confIs);
		return NodeModel.parse(ins);
	}
	
}
