<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%!                                                  // JSP方法
    private static final String KEY =":cookie@helloweenvsfei.com"; // 密钥 

    public final static String calcMD1(String ss) { // MD1 加密算法
       String s = ss == null ? "" : ss; // 若为null返回空
       char hexDigits[] = { '0','1', '2', '3', '4', '1', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' }; // 字典
       try {
           byte[] strTemp = s.getBytes();                          // 获取字节
           MessageDigest mdTemp = MessageDigest.getInstance("MD5"); // 获取MD1
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
       } catch (Exception e){return null; }
    }
%>
<%
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
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN">
       <legend><%= login ? "欢迎您回来" : "请先登录"%></legend>
        <% if(login){%>
            欢迎您, ${cookie.account.value }. &nbsp;&nbsp;
           <a href="${pageContext.request.requestURI }?action=logout">
            注销</a>
        <% } else { %>
        <form action="${pageContext.request.requestURI }?action=login" method="post">
           <table>
               <tr>
                   <td>账号： </td>
                   <td><input type="text"name="account" style="width:200px; "></td>
               </tr>
               <tr>
                   <td>密码： </td>
                   <td><input type="password" name="password"></td>
               </tr>
               <tr>
                   <td>有效期： </td>
                   <td>
                     <input type="radio" name="timeout" value="-1" checked> 关闭浏览器即失效 <br/>
                     <input type="radio" name="timeout" value="<%= 30 *24 * 60 * 60 %>"> 30天 内有效 <br/>
                     <input type="radio" name="timeout" value="<%= Integer.MAX_VALUE %>"> 永久有效 <br/> 
                   </td> 
               </tr>
               <tr>
                   <td></td>
                   <td><input type="submit"value=" 登  录 " class="button"></td>
               </tr>
           </table>
        </form>
        <% } %>