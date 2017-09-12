<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8;charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>报表提示页面</title>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/report-warn.css"></link>
</head>
<body>
	<div id="content">
	  <h1 class="warning">该报表已被阻止！！！</h1>
	  <div class="partition"> 
	  	<span class="partition_left" style="width:150px;"></span> 
	  </div>
	  <div class="b_distance">
	  	根据三级利润系统的权限管理规定, 您不具备访问的此报表的权限。如有疑问, 请联系系统管理人员。<br>
	  	------------------------------------------------------------------------------------------------<br> 
	 	提示: ${CHECKERR}<br>
	  </div>
	  <br>
	  <h1 class="organ">用户对象&gt;&gt;&gt;</h1>
	  <div class="partition"> 
	  	<span class="partition_left" style="width:150px;"></span> 
	  </div>
	  <div class="b_distance">
		<div class="title">事业部: </div>
<#if SECTORS?? && SECTORS?size gt 0>
	<#list SECTORS as item>
		<#if item_index gt 0>, </#if>${item.NAME} 
	</#list>
<#else>
		<span style='color:red;'>&lt;无权限&gt;</span>
</#if>
		<br>
	  	------------------------------------------------------------------------------------------------<br> 
	 	<div class="title">总部: </div>
	 	${HEAD_ADMIN!"<span style='color:red;'>&lt;无权限&gt;</span>"}<br>
	  	------------------------------------------------------------------------------------------------<br> 
	 	<div class="title">大区: </div>
	 	${AREA_NAME!"<span style='color:red;'>&lt;无权限&gt;</span>"}<br>
	  	------------------------------------------------------------------------------------------------<br> 
	 	<div class="title">分公司: </div>
	 	${BRANCH_NAME!"<span style='color:red;'>&lt;无权限&gt;</span>"}<br>
	  	------------------------------------------------------------------------------------------------<br> 
	 	<div class="title">门店: </div>
	 	${STORE_NAME!"<span style='color:red;'>&lt;无权限&gt;</span>"}<br>
	  </div>
	</div>
</body>
</html>