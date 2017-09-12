package demo.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;

/**
 * BASE64编码工具
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 15050873
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Base64Util {
    private static Logger logger = Logger.getLogger(Base64Util.class);

    public static String encode(String data){
        byte[] enbs = Base64.encodeBase64(data.getBytes());
        return new String(enbs);
    }
    
    public static String decode(String data, String charencoding){
        String result = null;
        try {
            byte[] enbs = Base64.decodeBase64(data.getBytes(charencoding));
            result = new String(enbs, charencoding);
        } catch (UnsupportedEncodingException e) {
            logger.error("Base64 decode error: UnsupportedEncodingException");
        }
        return result;
    }
    
    public static String toCharset(String data, String charencoding){
        String result = null;
        try {
            result = new String(data.getBytes(), charencoding);
        } catch (UnsupportedEncodingException e) {
            logger.error("String change Charencoding errror: UnsupportedEncodingException");
        }
        return result;
    }
}
