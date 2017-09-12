package demo.controller;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cookieDemo")
public class CookieDemo {
	private static final String KEY =":cookie@helloweenvsfei.com"; // 密钥 
	
	@RequestMapping("/demo")
	public String demo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
        return "cookieDemo/cookieDemo.ftl";
    }
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		    request.setCharacterEncoding("UTF-8");          // 设置request编码
		   response.setCharacterEncoding("UTF-8");        // 设置response编码

		   String action =request.getParameter("action"); // 获取action参数

		   if("login".equals(action)) {                       // 如果为login动作
		        String account =request.getParameter("account"); // 获取account参数
		        String password =request.getParameter("password"); // 获取password参数
		        int timeout = new Integer(request.getParameter("timeout")); // 获取timeout参数

		        String ssid =calcMD1(account + KEY); // 把账号、密钥使用MD1加密后保存

		        Cookie accountCookie = new Cookie("account", account); // 新建Cookie
		        accountCookie.setMaxAge(timeout);              // 设置有效期

		        Cookie ssidCookie =new Cookie("ssid", ssid);   // 新建Cookie
		       ssidCookie.setMaxAge(timeout);                 // 设置有效期

		       response.addCookie(accountCookie);             // 输出到客户端
		       response.addCookie(ssidCookie);            // 输出到客户端

		       // 重新请求本页面，参数中带有时间戳，禁止浏览器缓存页面内容
		       response.sendRedirect(request.getRequestURI() + "?" + System.currentTimeMillis());
		       return;
		      
		    } else if("logout".equals(action)) {                  // 如果为logout动作
		       Cookie accountCookie = new Cookie("account", ""); // 新建Cookie，内容为空
		       accountCookie.setMaxAge(0); // 设置有效期为0，删除

		       Cookie ssidCookie =new Cookie("ssid", ""); // 新建Cookie，内容为空
		       ssidCookie.setMaxAge(0);                   // 设置有效期为0，删除
		       response.addCookie(accountCookie);         // 输出到客户端
		       response.addCookie(ssidCookie);         // 输出到客户端
		       
		    // 重新请求本页面，参数中带有时间戳，禁止浏览器缓存页面内容
		       response.sendRedirect(request.getRequestURI() + "?" + System.currentTimeMillis());
		       return;
		    }
		    boolean login = false;                        // 是否登录
		    String account = null;                        // 账号
		    String ssid = null;                           // SSID标识

		    if(request.getCookies() !=null) {               // 如果Cookie不为空
		        for(Cookie cookie : request.getCookies()) {  // 遍历Cookie
		           if(cookie.getName().equals("account"))  // 如果Cookie名为 account
		               account = cookie.getValue();       // 保存account内容
		           if(cookie.getName().equals("ssid")) // 如果为SSID
		               ssid = cookie.getValue();          // 保存SSID内容
		        }
		    }
		    if(account != null && ssid !=null) {    // 如果account、SSID都不为空
		        login = ssid.equals(calcMD1(account + KEY)); // 如果加密规则正确, 则视为已经登录
		    }
		    
		 
	}
	
	/**
	 *   MD1 加密算法
	 * @param ss
	 * @return
	 */
	public final static String calcMD1(String ss) {
	       String s = ss == null ? "" : ss; // 若为null返回空
	       char hexDigits[] = { '0','1', '2', '3', '4', '1', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' }; // 字典
	       try {
	           byte[] strTemp = s.getBytes();                          // 获取字节
	           MessageDigest mdTemp = MessageDigest.getInstance("MD5"); // 获取MD5
	           mdTemp.update(strTemp);                                // 更新数据
	           byte[] md =mdTemp.digest();                        // 加密
	           int j =md.length;                                 // 加密后的长度
	           char str[] = new char[j * 2];                       // 新字符串数组
	           int k =0;                                         // 计数器k
	           for (int i = 0; i< j; i++) {                       // 循环输出
	               byte byte0 = md[i];
	               str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	               str[k++] = hexDigits[byte0 & 0xf];
	           }
	           return new String(str);                             // 加密后字符串
	       } catch (Exception e){
	    	   e.printStackTrace();
	    	   return null; 
	       }
	    }
	
	
	public  static void main(String[] args){
		String ss = "14111638";
		String msg = calcMD1(ss);
		System.out.println("msg="+msg);
	}

}
