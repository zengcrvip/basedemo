<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
<script src="${base}/webstatic/js/echarts/echarts.js" type="text/javascript"></script>
<script src="${base}/webstatic/js/common-charts.js" type="text/javascript"></script>
</head>
<body>
	<div id="id-div-chart" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	<div id="mainMap" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

<script>
	jQuery(document).ready(function() {
	  //1、初始化
	  require.config({paths: {echarts: '${base}/webstatic/js/echarts'}});
	  //定义仪表盘
	  $.gauge('id-div-chart', {title: '毛利额', value: 88.99});
	   
		
	});
  </script>
</body>
</html>