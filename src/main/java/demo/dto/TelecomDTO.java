package demo.dto;
/**
 * 运营商概览对象
 * @author 14111638
 *
 */
public class TelecomDTO {
	String kpiName;
	String kpiValue;
	String an;
	String rank;
	String viewType;
	String telecomType;
	
	public TelecomDTO() {
		super();
	}
	public TelecomDTO(String kpiName, String kpiValue, String an,String rank,
			String viewType, String telecomType) {
		super();
		this.kpiName = kpiName;
		this.kpiValue = kpiValue;
		this.an = an;
		this.rank = rank;
		this.viewType = viewType;
		this.telecomType = telecomType;
	}
	
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getKpiValue() {
		return kpiValue;
	}
	public void setKpiValue(String kpiValue) {
		this.kpiValue = kpiValue;
	}
	public String getAn() {
		return an;
	}
	public void setAn(String an) {
		this.an = an;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public String getTelecomType() {
		return telecomType;
	}
	public void setTelecomType(String telecomType) {
		this.telecomType = telecomType;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	

}
