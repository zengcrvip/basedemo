package demo.dto;

public class OverviewDTO {
	String kpiName;
	String task;
	String sale;
	String completionRate;
	String an;
	String rank;
	String saleRate;
	String viewType;
	
	public OverviewDTO() {
		super();
	}
	
	public OverviewDTO(String kpiName, String task, String sale,
			String completionRate, String an, String rank, String saleRate,
			String viewType) {
		super();
		this.kpiName = kpiName;
		this.task = task;
		this.sale = sale;
		this.completionRate = completionRate;
		this.an = an;
		this.rank = rank;
		this.saleRate = saleRate;
		this.viewType = viewType;
	}
	
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getCompletionRate() {
		return completionRate;
	}
	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}
	public String getAn() {
		return an;
	}
	public void setAn(String an) {
		this.an = an;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSaleRate() {
		return saleRate;
	}
	public void setSaleRate(String saleRate) {
		this.saleRate = saleRate;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	
 

}
