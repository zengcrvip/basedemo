<#-- 宏定义 -->
<#macro toarray data=[]>
[	
	<#list data as item>
		'${item?string}'<#if item_index+1 lt data?size>,</#if>
	</#list>
]
</#macro>

<#macro pievals data=[] months=[] field="">
[
	<#list timeline as item>
		<#if item_index gt 0>,</#if>
		<#local offline=data['线下'][item?string]!{}>
		<#local online=data['线上'][item?string]!{}>	
	[
		<#local value1=offline[field]!0>
		<#local value2=online[field]!0>
		<#if field=='GP' || field=='AMT'>
		{value: ${(value1/10000)?string('#.##')}, name:'10(线下)'},
		{value: ${(value2/10000)?string('#.##')}, name:'20(线上销售,线下开单)'}
		<#else>
		{value: ${value1?string('#.##')}, name:'10(线下)'},
		{value: ${value2?string('#.##')}, name:'20(线上销售,线下开单)'}		
		</#if>
	]
	</#list>
]
</#macro>

<#macro linevals data=[] months=[] field="">
[{
	name: "10(线下)",
	data: [
	<#list timeline as item>
		<#local node=data['线下'][item?string]!{}>
		<#if item_index gt 0>,</#if>
		<#local value=node[field]!0>
		<#if field=='GP' || field=='AMT'>
		${(value/10000)?string('#.##')}
		<#else>
		${value?string('#.##')}
		</#if>
	</#list>
	]
}, {
	name: "20(线上销售,线下开单)",
	data: [
	<#list timeline as item>
		<#local node=data['线上'][item?string]!{}>
		<#if item_index gt 0>,</#if>
		<#local value=node[field]!0>
		<#if field=='GP' || field=='AMT'>
		${(value/10000)?string('#.##')}
		<#else>
		${value?string('#.##')}
		</#if>
	</#list>
	]
}]
</#macro>

<#-- 函数定义 -->
<#function grouping data=[]>
	<#local offline={}>	
	<#local online={}>
	<#list data as item>
		<#if item.CHNL_TYPE_ID == '10'>
			<#local offline=offline+{item.MONTH_ID?string: item}>
		<#elseif item.CHNL_TYPE_ID == '20'>
			<#local online=online+{item.MONTH_ID?string: item}>
		</#if>
	</#list>
	<#return {'线下': offline, '线上': online}>
</#function>

<#assign timeline=["201601", "201602", "201603", "201604", "201605"]>
<#assign GROUPS=grouping(channel)>

<!-- 毛利额 -->
<div class="ranking-block">
	<div id="CHNL_CHART1" class="chart1"></div>
	<div id="CHNL_CHART2" class="chart2"></div>
</div>
<script language="javascript">
	var timeline = <@toarray data=timeline />;
	
	var piedata = [
		<@pievals data=GROUPS months=timeline field="GP"/>, 
		<@pievals data=GROUPS months=timeline field="GM"/>, 
		<@pievals data=GROUPS months=timeline field="AMT"/>, 
		<@pievals data=GROUPS months=timeline field="NUM"/>
	];
	
	var lindata = [
		<@linevals data=GROUPS months=timeline field="GP"/>,
		<@linevals data=GROUPS months=timeline field="GM"/>,
		<@linevals data=GROUPS months=timeline field="AMT"/>,
		<@linevals data=GROUPS months=timeline field="NUM"/>
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