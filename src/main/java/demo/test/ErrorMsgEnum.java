package demo.test;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 11:26 2018/1/19 .
 */
public enum ErrorMsgEnum {
    CRETERROR("1001","配置信息错误"),
    WEICHATERROR("1002","微信证书已过期"),
    IPERROR("1003","IP地址不合法"),

    ORDERNULL("2001","merchantOrder字段必填,并且少于28个字符"),
    MEMBERCODENULL("2002","memberCode字段必填"),
    RECHARGETYPENULL("2003","rechargeType字段必填"),
    WALLETTYPENULL("2004","walletType字段必填"),
    OPENIDNULL("2005","openId字段必填"),
    PAYMENTAMTNULL("2006","paymentAmt字段必填"),
    PAYMENTNUMNULL("2007","paymentNum字段必填"),
    WISHINGNULL("2008","wishing字段必填，并且少于128个字符"),
    ACTIVITYNAMENULL("2009","activityName字段必填，并且少于32个字符"),
    REMARKNULL("2010","remark字段必须少于256个字符"),
    SCENEIDNULL("2011","红包金额大于200时，sceneId字段必填"),
    QUERYTYPENULL("2012","queryType字段必填"),

    ORDERERROR("3001","merchantOrder字段格式错误"),
    RECHARGETYPEERROR("3002","rechargeType字段当前版本只支持1"),
    WALLETTYPEERROR("3003","walletType字段当前版本只支持1"),
    PAYMENTNUMERROR("3004","paymentNum字段当前版本只支持1"),
    QUERYTYPEERROR("3005","queryType字段当前版本只支持1");

    private String errorCode;
    private String errorMsg;

    ErrorMsgEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
