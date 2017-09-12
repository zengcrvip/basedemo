<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>cookieDemo</title>

  </head>
  
  <body>
    <form action="${base}/cookieDemo/login.htm?action=login" method="post">
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
  </body>
</html>
