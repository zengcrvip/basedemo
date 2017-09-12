package demo.resolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageBean {
	
	private int page;
	
	private int limit;
	
	private int total;
	
	private List rows = new ArrayList();
	
	/**
	 * 
	 * key String 查询的字段名，以filter开头
	 * 
	 */
	private Map<String,String> condition = new HashMap<String,String>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}
	
	public int getOffset() {
		return (this.page - 1) * this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Map<String,String> getCondition() {
		return condition;
	}

	public void setCondition(Map<String,String> condition) {
		this.condition = condition;
	}
	
	public void addCondition(String key,String value) {
		condition.put(key, value);
	}
}
