<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>table data download demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/webstatic/js/mbmUtils.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	   
	</style>
	
	<script type="text/javascript">
	   var size = ${list?size};
	   //alert(size);
	
	</script>

  </head>
  
  <body>

      <#list list as li>
         <#if li_index == 0>
             <div>
	             <span>${li.key1}</span>
	             <span>${li.key2}</span>
	             <span>${li.key3}</span>
             </div>
         <#else>
             <div>
	            <a>${li.key1}</a>
	            <a>${li.key2}</a>
	            <a>${li.key3}</a>
	         </div>
         </#if>
         
      </#list>
      
      <#list amap?keys as k>
         <a id="${k}">${amap[k]}</a>
      </#list>

  
    
  </body>

</html>
