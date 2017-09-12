package demo.dto;

public class UserBaseInfo {

	//员工工号
	private String account;
	//员工姓名
	private String name;
	//通讯公司归属组织类型
	private String communicationOrgType;
	//通讯公司归属组织CD
	private String communicationOrgCd;
	//通讯公司归属组织名称
	private String communicationOrgName;
	//苏宁云商归属组织ID
	private String snCloudOrgId;
	//苏宁云商归属组织CD
	private String snCloudOrgCd;
	//通讯公司归属组织名称
	private String snCloudOrgName;
	//手機號碼
	private String mobileNum;
	//單位號碼
	private String phoneNum;
	//郵箱地址
	private String email;
		
	public String getAccount() {
		return account;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommunicationOrgType() {
		return communicationOrgType;
	}

	public void setCommunicationOrgType(String communicationOrgType) {
		this.communicationOrgType = communicationOrgType;
	}

	public String getCommunicationOrgName() {
		return communicationOrgName;
	}

	public void setCommunicationOrgName(String communicationOrgName) {
		this.communicationOrgName = communicationOrgName;
	}

	public String getSnCloudOrgId() {
		return snCloudOrgId;
	}

	public void setSnCloudOrgId(String snCloudOrgId) {
		this.snCloudOrgId = snCloudOrgId;
	}

	public String getSnCloudOrgName() {
		return snCloudOrgName;
	}

	public void setSnCloudOrgName(String snCloudOrgName) {
		this.snCloudOrgName = snCloudOrgName;
	}

	public String getCommunicationOrgCd() {
		return communicationOrgCd;
	}

	public void setCommunicationOrgCd(String communicationOrgCd) {
		this.communicationOrgCd = communicationOrgCd;
	}

	public String getSnCloudOrgCd() {
		return snCloudOrgCd;
	}

	public void setSnCloudOrgCd(String snCloudOrgCd) {
		this.snCloudOrgCd = snCloudOrgCd;
	}
	
}
