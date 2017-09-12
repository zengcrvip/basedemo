<#-- 宏定义 -->
<#macro toarray data=[]>
[	
	<#list data as item>
		"${item?string}"<#if item_index+1 lt data?size>,</#if>
	</#list>
]
</#macro>

<#macro pievals data=[] axis=[]>
[
	<#list axis as item>
	[
		<#list data as item1>
			<#local map=tomap(item1["list"],"dateValue","channelValue")>
			{value: ${map[item]!0}, name: "${item1["channelName"]!}"}<#if item1_index+1 lt data?size>,</#if>
		</#list>
	]<#if item_index+1 lt axis?size>,</#if>
	</#list>
]
</#macro>

<#macro linevals data=[] axis=[]>
[
	<#list data as item>
	<#local map=tomap(item["list"],"dateValue","channelValue")>
	{
		name: "${item["channelName"]!}",
		data: [
		<#list axis as item1>
			${map[item1]!0?string("#.##")}<#if item1_index+1 lt axis?size>,</#if>
		</#list>
		]
	}<#if item_index+1 lt data?size>,</#if>
	</#list>
]
</#macro>

<#-- 函数定义 -->
<#function tomap data=[] keyField="" valField="">
	<#local map={}>
	<#list data as item>
		<#if item[keyField]?? && item[valField]??>
			<#local map=map+{item[keyField]?string: item[valField]}>
		</#if>
	</#list>
	<#return map>
</#function>

<#-- 测试数据 -->
<#assign timeline=["201601", "201602", "201603", "201604", "201605"]>

<#assign details=[{
	"channelName": "10(线下)",
	"list": [
		{"channelValue": 234,  "dateValue": "201601"},
		{"channelValue": 345,  "dateValue": "201602"},
		{"channelValue": 123,  "dateValue": "201603"},
		{"channelValue": 88,  "dateValue": "201604"},
		{"channelValue": 223,  "dateValue": "201605"}
	]
}, {
	"channelName": "20(线上)",
	"list": [
		{"channelValue": 341,  "dateValue": "201601"},
		{"channelValue": 122,  "dateValue": "201602"},
		{"channelValue": 78,  "dateValue": "201603"},
		{"channelValue": 344,  "dateValue": "201604"},
		{"channelValue": 162,  "dateValue": "201605"}
	]
}, {
	"channelName": "50(其他)",
	"list": [
		{"channelValue": 34,  "dateValue": "201601"},
		{"channelValue": 77,  "dateValue": "201602"},
		{"channelValue": 123,  "dateValue": "201603"},
		{"channelValue": 444,  "dateValue": "201604"},
		{"channelValue": 87,  "dateValue": "201605"}
	]
}, {
	"channelName": "60(其他)",
	"list": [
		{"channelValue": 34,  "dateValue": "201601"},
		{"channelValue": 77,  "dateValue": "201602"},
		{"channelValue": 123,  "dateValue": "201603"},
		{"channelValue": 444,  "dateValue": "201604"},
		{"channelValue": 87,  "dateValue": "201605"}
	]
}]>

<!-- 毛利额 -->
<div class="ranking-block">
	<div id="CHNL_CHART1" class="chart1"></div>
	<div id="CHNL_CHART2" class="chart2"></div>
</div>
<script language="javascript">
	var timeline = <@toarray data=timeline />;
	
	var piedata = [
		<@pievals data=details axis=timeline/>, 
		<@pievals data=details axis=timeline/>, 
		<@pievals data=details axis=timeline/>, 
		<@pievals data=details axis=timeline/>
	];
	
	var lindata = [
		<@linevals data=details axis=timeline/>,
		<@linevals data=details axis=timeline/>,
		<@linevals data=details axis=timeline/>,
		<@linevals data=details axis=timeline/>
	];
	
	if(timeline.length > 0){
<#switch index>   
	<#case "GP">   
		<#if period=="month">	
		$.pies('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: ￥', timeline: timeline, series: piedata[0]});
		<#else>
		$.pie('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: ￥', name: '毛利额', series: piedata[0][0]});
		</#if>
		$.lines('CHNL_CHART2', {title: '销售渠道趋势图', subtitle: '单位: ￥', timeline: timeline, series: lindata[0]});
		<#break>
	<#case "GM">   
		<#if period=="month">	
		$.pies('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: %', timeline: timeline, series: piedata[0]});
		<#else>
		$.pie('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: %', name: '毛利率', series: piedata[0][0]});
		</#if>
		$.lines('CHNL_CHART2', {title: '销售渠道趋势图', subtitle: '单位: %', timeline: timeline, series: lindata[0]});
		<#break>
	<#case "AMT">   
		<#if period=="month">	
		$.pies('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: ￥', timeline: timeline, series: piedata[0]});
		<#else>
		$.pie('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: ￥', name: '销售额', series: piedata[0][0]});
		</#if>
		$.lines('CHNL_CHART2', {title: '销售渠道趋势图', subtitle: '单位: ￥', timeline: timeline, series: lindata[0]});
		<#break>
	<#case "NUM">   
		<#if period=="month">	
		$.pies('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: 台', timeline: timeline, series: piedata[0]});
		<#else>
		$.pie('CHNL_CHART1', {title: '销售渠道分布图', subtitle: '单位: 台', name: '销售量', series: piedata[0][0]});
		</#if>
		$.lines('CHNL_CHART2', {title: '销售渠道趋势图', subtitle: '单位: 台', timeline: timeline, series: lindata[0]});
		<#break>
	<#default>
</#switch>
	}else{
		$('#CHNL_CHART1').html('<div class="rnodata">暂无数据, 敬请期待</div>');
		$('#CHNL_CHART2').html('<div class="rnodata">暂无数据, 敬请期待</div>');
	}
</script>