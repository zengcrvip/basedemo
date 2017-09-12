<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
<script src="${base}/webstatic/js/require.js" type="text/javascript"></script>
<script src="${base}/webstatic/js/echarts-all.js" type="text/javascript"></script>
</head>
<body>
	<div id="id-div-chart" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	<div id="mainMap" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

<script>
	jQuery(document).ready(function() {
	
	   //1、定义echarts加载路径
	    var base = "${base}";
		requirejs.config({
			baseUrl : base+'/webstatic/js/echartsModule/'
		});
		
		//2、漏斗图
		var yAxisData = ['登录','购买','支付'];
		var barData = [{
			name : '流程',
			data : [120,30,5]
		}];
		var funnelData = [{
			name: '上一步转化率',
			data: [{name:'登录',value:100.00},{name:'购买',value:25.00},{name:'支付',value:30.45}]
		}, {
			name: '总体转化率',
			data: [{name:'登录',value:100.00},{name:'购买',value:25.00},{name:'支付',value:4.65}]
		}];
		
		require([ "FunnelModule" ], (function(params, divId) {
			return function(module) {
				module.showSnseChart(params, divId);
			};
		})({yAxisData: yAxisData, barData: barData, funnelData: funnelData}, "id-div-chart"));
		
		//3、柱状图
		var paramsData = {};
		paramsData = {
			data : [{"activeUser":100,"dimension":"电信"},{"activeUser":200,"dimension":"联通"}],
			topsize:10,
			featureCode : '1',
			featureText : '启动次数'
		};
		require([ "CrossBarModule" ], (function(params, divId) {
				return function(module) {
					module.showSnseChart(params, divId);
				};
			})(paramsData, "main"));
			
		//4、地图
		var params = {legend:'数量',seriesData:[{name:'北京',value:100},{name:'上海',value:200},{name:'江苏',value:300},{name:'湖南',value:400},{name:'浙江',value:500},{name:'湖北',value:600},{name:'广东',value:700}]};
		require([ "MapModule" ], (function(params, divId) {
			return function(module) {
				module.showSnseChart(params, divId);
			}
		})(params, "mainMap"));	
		
	});
  </script>
</body>
</html>