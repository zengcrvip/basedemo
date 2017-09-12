package demo.dto;

import java.util.List;

public class ReportResultDTO {
	String returnCode;
	String returnMsg;
	List<Object> list;
	
	public ReportResultDTO() {
		super();
	}
	public ReportResultDTO(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
}
