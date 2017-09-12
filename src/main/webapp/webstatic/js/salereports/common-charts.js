/**
 * 图表扩展
 */
jQuery.extend({
	/**
	 * 单仪表盘
	 */
	gauge : function(divId, data) {
		var options = {
			tooltip : {
				formatter : "{a} <br/>{b} : {c}%"
			},
			toolbox : {
				show : false
			},
			series : [ {
				name : data.title,
				type : 'gauge',
				startAngle : 210,
				endAngle : -30,
				center : [ '50%', '60%' ],
				radius : 100,
				splitNumber : 10,
				axisLine : {
					lineStyle : {
						width : 8
					}
				},
				axisTick : {
					splitNumber : 10,
					length : 12,
					lineStyle : {
						color : 'auto'
					}
				},
				axisLabel : {
					textStyle : {
						color : 'auto'
					}
				},
				splitLine : {
					show : true,
					length : 30,
					lineStyle : {
						color : 'auto'
					}
				},
				pointer : {
					width : 6
				},
				title : {
					show : true,
					offsetCenter : [ 0, '-25%' ],
					textStyle : {
						fontWeight : 'bolder'
					}
				},
				detail : {
					formatter : '{value}%',
					textStyle : {
						color : 'auto',
						fontWeight : 'bolder'
					}
				},
				data : [ {
					value : data.value,
					name : '完成率'
				} ]
			} ]
		};
		require([ 'echarts', 'echarts/chart/gauge' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption(options, true);
		});
	},

	/**
	 * 圆环图
	 */
	circular : function(divId, data) {
		var options = {
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'horizontal',
				x : data.title == null ? 'left' : 'right',
				y : data.title == null ? '15px' : '10px',
				data : []
			},
			title : {
				text : data.title,
				subtext : data.subtitle,
				x : 'left'
			},
			calculable : true,
			series : [ {
				name : data.name,
				type : 'pie',
				center : [ '50%', '55%' ],
				radius : [ '40%', '60%' ],
				itemStyle : {
					normal : {
						label : {
							show : false
						},
						labelLine : {
							show : false
						}
					},
					emphasis : {
						label : {
							show : true,
							position : 'center',
							textStyle : {
								fontSize : '30',
								fontWeight : 'bold'
							}
						}
					}
				},
				data : data.series
			} ]
		};
		$.each(data.series, function(idx, val) {
			options.legend.data.push(val.name);
		});
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption(options, true);
		});
	},
	/**
	 * 圆环图(多)
	 */
	circulars : function(divId, data) {
		var labelTop = {
			normal : {
				label : {
					show : true,
					position : 'center',
					formatter : '{b}',
					textStyle : {
						baseline : 'bottom'
					}
				},
				labelLine : {
					show : false
				}
			}
		};
		var labelFromatter = {
			normal : {
				label : {
					formatter : function(params) {
						return (100 - params.percent).toFixed(2) + '%';
					},
					textStyle : {
						baseline : 'top'
					}
				}
			}
		};
		var labelBottom = {
			normal : {
				color : '#ccc',
				label : {
					show : true,
					position : 'center'
				},
				labelLine : {
					show : false
				}
			},
			emphasis : {
				color : 'rgba(0,0,0,0)'
			}
		};
		var options = {
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				x : 'center',
				y : 'bottom',
				data : [ data.series[0].name, data.series[1].name,
						data.series[2].name ]
			},
			title : {
				text : data.title,
				subtext : data.subtitle,
				x : 'center'
			},
			toolbox : {
				show : false
			},
			series : [ {
				type : 'pie',
				center : [ '21%', '50%' ],
				radius : [ 40, 55 ],
				x : '0%', // for funnel
				itemStyle : labelFromatter,
				data : [ {
					name : '其他',
					value : data.total - data.series[0].value,
					itemStyle : labelBottom
				}, {
					name : data.series[0].name,
					value : data.series[0].value,
					itemStyle : labelTop
				} ]
			}, {
				type : 'pie',
				center : [ '51%', '50%' ],
				radius : [ 40, 55 ],
				x : '20%', // for funnel
				itemStyle : labelFromatter,
				data : [ {
					name : '其他',
					value : data.total - data.series[1].value,
					itemStyle : labelBottom
				}, {
					name : data.series[1].name,
					value : data.series[1].value,
					itemStyle : labelTop
				} ]
			}, {
				type : 'pie',
				center : [ '81%', '50%' ],
				radius : [ 40, 55 ],
				x : '40%', // for funnel
				itemStyle : labelFromatter,
				data : [ {
					name : '其他',
					value : data.total - data.series[2].value,
					itemStyle : labelBottom
				}, {
					name : data.series[2].name,
					value : data.series[2].value,
					itemStyle : labelTop
				} ]
			} ]
		};
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption(options, true);
		});
	},
	/**
	 * 圆饼图(带时间轴，多)
	 */
	pies : function(divId, data) {
		var options = [ {
			title : {
				text : data.title,
				subtext : data.subtitle
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				data : [],
				x : 200,
				y : 10
			},
			toolbox : {
				show : false
			},
			series : [ {
				name : data.name,
				type : 'pie',
				center : [ '48%', '50%' ],
				radius : '55%',
				data : data.series[0]
			} ]
		} ];
		$.each(data.series[0], function(idx, val) {
			options[0].legend.data.push(val.name);
		});
		$.each(data.series, function(idx, val) {
			if (idx > 0) {
				options.push({
					series : [ {
						name : data.name,
						type : 'pie',
						data : val
					} ]
				});
			}
		});
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption({
				timeline : {
					data : data.timeline,
					currentIndex : data.series.length - 1,
					x : 35
				},
				options : options
			}, true);
		});
	},
	/**
	 * 单圆饼图
	 */
	pie : function(divId, data) {
		var options = {
			title : {
				text : data.title,
				subtext : data.subtitle
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				data : [],
				x : 200,
				y : 10
			},
			toolbox : {
				show : false
			},
			calculable : true,
			series : [ {
				name : data.name,
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : []
			} ]
		};
		$.each(data.series, function(idx, val) {
			options.legend.data.push(val.name);
			options.series[0].data.push(val);
		});
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption(options, true);
		});
	},
	/**
	 * 折线图(多)
	 */
	lines : function(divId, data) {
		var options = {
			title : {
				text : data.title,
				subtext : data.subtitle
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [],
				x : 220,
				y : 10
			},
			toolbox : {
				show : false
			},
			grid : {
				x : 50,
				y : 65,
				x2 : 50,
				y2 : 30
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : data.timeline
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : []
		};
		$.each(data.series, function(idx, val) {
			options.legend.data.push(val.name);
			options.series.push({
				name : val.name,
				type : 'line',
				data : val.data,
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			});
		});
		require([ 'echarts', 'echarts/chart/line' ], function(ec) {
			var chart = ec.init(document.getElementById(divId));
			chart.setOption(options, true);
		});
	}
});