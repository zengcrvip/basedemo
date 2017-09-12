<#-- 函数定义 -->
<#function mabs val=0>
	<#if val gt 0>
		<#return val>
	<#else>
		<#return 0 - val>
	</#if>
</#function>

<#function tongbi bqval=0 tqval=0>
	<#if bqval?? && tqval?? && tqval != 0>
		<#local tbval=(bqval - tqval) * 100 / mabs(tqval)>
		<#if tbval gt 0>
			<#return '+${tbval?string("#.##")} % ↑'>
		<#elseif tbval == 0>
			<#return '${tbval?string("#.##")} %'>
		<#else>
			<#return '${tbval?string("#.##")} % ↓'>		
		</#if>
	<#else>
		<#return '--%'>
	</#if>
</#function>

<#function groupby data type>
	<#local MBL=0, UNC=0, TLC=0>
	<#list data as item>
		<#switch item.TELECOM>
	        <#case 'MBL'>
				<#local MBL=item[type]!0>
	        	<#break>
	        <#case 'UNC'>
				<#local UNC=item[type]!0>
	        	<#break>
	        <#case 'TLC'>
				<#local TLC=item[type]!0>
	        	<#break>      
        </#switch>
	</#list>
	<#local TTL=MBL + UNC + TLC>
	<#return {'移动': MBL, '联通': UNC ,'电信': TLC, '总计': TTL}>
</#function>

<#assign DL_BQ_DATA=groupby(telcom, 'USRNUM_DL')>
<#assign DL_TQ_DATA=groupby(telcom, 'USRNUM_DL_TQ')>
<#assign ZS_BQ_DATA=groupby(telcom, 'USRNUM_ZS')>
<#assign ZS_TQ_DATA=groupby(telcom, 'USRNUM_ZS_TQ')>	

<div id="DL_CHART" class="chart"></div>
<div id="ZS_CHART" class="chart"></div>
<script language="javascript">
	var dlTotal = ${DL_BQ_DATA['总计']};
	var dlTongbi = '${tongbi(DL_BQ_DATA['总计'], DL_TQ_DATA['总计'])}';
	var dlSeries = [
		{name: '移动', value: ${DL_BQ_DATA['移动']}},
		{name: '联通', value: ${DL_BQ_DATA['联通']}},
		{name: '电信', value: ${DL_BQ_DATA['电信']}}
	];
	var zsTotal = ${ZS_BQ_DATA['总计']};
	var zsTongbi = '${tongbi(ZS_BQ_DATA['总计'], ZS_TQ_DATA['总计'])}';
	var zsSeries = [
		{name: '移动', value: ${ZS_BQ_DATA['移动']}},
		{name: '联通', value: ${ZS_BQ_DATA['联通']}},
		{name: '电信', value: ${ZS_BQ_DATA['电信']}}
	];
	var dlSubtitle = '总计: '+ dlTotal +' 同比: '+ dlTongbi;
	var zsSubtitle = '总计: '+ zsTotal +' 同比: '+ zsTongbi;
	$.circulars('DL_CHART', {title: '代理用户发展数', subtitle: dlSubtitle, total: dlTotal, series: dlSeries});
	$.circulars('ZS_CHART', {title: '转售用户发展数', subtitle: zsSubtitle, total: zsTotal, series: zsSeries});
</script>