define([], function() {
	function _barModule(params, divId) {
		var option = _getOption(params);
		var myChart = echarts.init(document.getElementById(divId));
		myChart.setOption(option);
		myChart.setTheme("macarons");
		return myChart;
	}

	function getMultiTitle(str)
	{
		var result= "";
		var size= 15;
		var len1= str.length;
		var len2= str.replace(/[^\x00-\xff]/g, '**').length;
		if(len2<=size)
		{
			return str;
		}	
		
		
		var chartemp;
		var lentemp= 0;
		
		for(var i=0; i<len1; i++)
		{
			chartemp= str.charAt(i)+ "";
			lentemp++;
			if(chartemp.match(/[^\x00-\xff]/g)!= null)
			{
				lentemp++;
			}
			
			if(lentemp>size)
			{
				result= str.substring(0, i+ 1)+ "...";
				return result;
			}	
		}
	}
	
	function _getOption(params) {
		var xAxisData = [],
		    data = [],
		    series = [];
		var dataName = "";
		if(params.featureCode == "1" || params.featureCode == "4" ){
			dataName = "activeUser";
		}else{
			dataName = "bootingCount";
		}
		if( params.data.length > 0 ){
			var dataarr= params.data;
			if(params.data.length>=params.topsize)
			{
				dataarr= params.data.reverse().slice(0, params.topsize).reverse();
			}	
			$.each(dataarr,function(i,v){
				
				xAxisData.push(eval("v.dimension"));
				data.push(eval("v."+dataName));
			});
			series.push({
	            name: params.featureText,
	            type:'bar',
	            data:data,
	            barWidth:20,
	            itemStyle: {
                    normal:{
                        barBorderRadius:[0,15,15,0],
                        label: {
                            show: true,
                        }
                    }
                },
                markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        });
		} 
		var option = {
				grid:{
					y:30,
					x: 120
				},
			    title : {
			        text: $.trim(params.featureText),
			        x:'right',
			        y: 430,
			        textStyle:{
			        	fontSize: 15
			        }
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			    	show:true,
			        data:[params.featureText],
			        y:'bottom'
			    },
			    toolbox: {
			    	show : true,
			        feature : {
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						},
						saveAsImage : {
							show : true
						}
					}
			    },
			    calculable : false,
			    xAxis : [
			        {

			            type : 'value'
			        }
			    ],
			    yAxis : [
			        {
			            type : 'category',
				        data : xAxisData,
				        axisLabel:{
				        	
				        	formatter: function (value){return getMultiTitle(value+"");}
				        }
			        }
			    ],
			    series : series
			};
		return option;
	}

	return {
		showSnseChart : _barModule
	};
});