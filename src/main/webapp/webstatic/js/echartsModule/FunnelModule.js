define([], function() {
	function _funnelModule(params, divId) {
		var option = _getOption(params);
		var myChart = echarts.init(document.getElementById(divId));
		myChart.setOption(option);
		myChart.setTheme("macarons");
		return myChart;
	}
	
	var itemStyles = [{
        normal: {
            label: {
                formatter: '{b}\n上一步'
            },
            labelLine: {
                show : false
            }
        },
        emphasis: {
            label: {
                position:'inside',
                formatter: '{b}\n上一步转化率 : {c}%'
            }
        }
    }, {
        normal: {
            borderColor: '#fff',
            borderWidth: 2,
            label: {
                position: 'inside',
                formatter: '{c}%',
                textStyle: {
                    color: '#fff'
                }
            }
        },
        emphasis: {
            label: {
                position:'inside',
                formatter: '{b}\n总体转化率 : {c}%'
            }
        }
    } ];

	function _getOption(params) {
		var option = {
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c}"
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    xAxis: [{
			    	type : 'value',
			    	axisLabel : {
						formatter : function(value) {
							if (value > 1000) {
								return value / 1000 + "K";
							} else {
								return value;
							}
						}
					}
			    }],
			    yAxis: [{
			    	type : 'category'
			    }],
			    grid: {
		            y: '10%',
		            x: '10%',
		            x2: '60%',
		            y2: '11%',
			    },
			    series : []
		};
		if (typeof (params) == "undefined" || params == null) {
			return option;
		}
		option.yAxis[0].data = params.yAxisData.reverse();
		$.each(params.barData, function(idx, value){
			option.series.push({
	            name: value.name,
	            type: 'bar',
	            barWidth: 20,
	            data: value.data.reverse()
	        });
		});
		$.each(params.funnelData, function(idx, value){
			option.series.push({
	            name: value.name,
	            type: 'funnel',
	            y: '10%',
	            y2: '10%',
	            x: '50%',
	            width: '36%',
	            itemStyle: itemStyles[idx],
	            data: value.data
	        });
		});
		return option;
	}
	
	return {
		showSnseChart : _funnelModule
	};
});