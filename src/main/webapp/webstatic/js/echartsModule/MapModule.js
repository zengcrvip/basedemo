define([], function() {
	function _mapModule(params, divId) {
		var option = _getOption(params);
		var myChart = echarts.init(document.getElementById(divId));
		myChart.setOption(option);
		myChart.setTheme("macarons");
		return myChart;
	}

	function _getOption(params) {
		var max = 0;
		if(params != undefined && params != null){
			for ( var int = 0; int < params.seriesData.length; int++) {
				var obj = params.seriesData[int];
				if(obj.value>max){
					max = obj.value;
				}
			}
		}
		
		//避免最大数相互折叠的问题
		max = max+'';
		
		var maxNum = 0;
		var start = max.substring(0, 1);
		if(max.length==1){
			maxNum = 10;
		}else if(max.length==2){
			maxNum = (parseInt(start)+1)*10;
		}else if(max.length==3){
			maxNum = (parseInt(start)+1)*100;
		}else if(max.length==4){
			maxNum = (parseInt(start)+1)*1000;
		}else if(max.length==5){
			maxNum = (parseInt(start)+1)*10000;
		}else if(max.length==6){
			maxNum = (parseInt(start)+1)*100000;
		}else if(max.length==7){
			maxNum = (parseInt(start)+1)*1000000;
		}else if(max.length==8){
			maxNum = (parseInt(start)+1)*10000000;
		}else if(max.length==9){
			maxNum = (parseInt(start)+1)*100000000;
		}
		
		var option = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		    	show : false,
		        data:[]
		    },
		    dataRange: {
		        min: 0,
		        max: maxNum,
		        x: 'left',
		        y: 'bottom',
		        text:['高','低'], // 文本，默认为数值文本
		        calculable : true
		    },
		    toolbox: {
		        show: false
		    },
		    roamController: {
		        show: true,
		        x: 'right',
		        mapTypeControl: {
		            'china': true
		        }
		    },
		    series : []
		};
		if (typeof (params) == "undefined" || params == null) {
			return option;
		}
		option.legend.data = [ params.legend ];
		option.series = [ {
			            name: params.legend,
			            type: 'map',
			            mapType: 'china',
			            roam: false,
			            itemStyle:{
			                normal:{label:{show:true}},
			                emphasis:{label:{show:true}}
			            },
			            data:params.seriesData
		} ];	                    
		return option;
	}

	return {
		showSnseChart : _mapModule
	};
});
