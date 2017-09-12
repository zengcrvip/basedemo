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

<div class="telecom_panel">
  <div id="DL_CHART" class="chart"></div>
  <div id="DL_ZL" style="width:120px;display:inline-block;padding:6px;vertical-align:top;">
    <div class="name"></div>
	<div class="number"></div>
	<div class="number"></div>
	<div class="number"></div>
  </div>
</div>

<div class="telecom_panel">
	<div id="ZS_CHART" class="chart"></div>
	<div id="ZS_ZL" style="width:120px;display:inline-block;padding:6px;vertical-align:top;">
		<div class="name"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
	</div>
</div>


<script language="javascript">
$(function(){
	var period = '${period}';
	var params = report.queryParams();
	params.period = period;
	loadTelecomData(params);//运营商总览
	   
})

/**
 * 初始化运营商数据
 */
function initTelecomData(divId,obj,chartData){
	if(obj.viewType == '0'){
		$(divId).eq(0).html(obj.kpiName);
		$(divId).eq(1).html("发展数："+obj.kpiValue);
		$(divId).eq(2).html("同比："+getTongBiVal(obj.an));
		$(divId).eq(3).html("排名："+obj.rank);
	}else{
		chartData.legend.push(obj.kpiName);
		chartData.series.push({name:obj.kpiName,value:obj.kpiValue});
	}
}

/**
 * 加载运营商数据
 */
function loadTelecomData(params){
	var url = '/BaseDemo/SaleOverview4mp/common/getTeleComData.htm?';
	var ajax = datasource(url, report.queryParams());
	ajax.before(function(){
		$(".telcom").block(maskOption);
	}).then(function(data){
		if(data.returnCode == '0000'){
			var telecom = data.list;
			var dlData = {legend:[],series:[],name:'代理用户发展数'};
			var zsData = {legend:[],series:[],name:'转售用户发展数'};
			$.each(telecom,function(idx,val){
				if(val.telecomType == 'DL'){
					initTelecomData("#DL_ZL div",val,dlData);
				}else if(val.telecomType == 'ZS'){
					initTelecomData("#ZS_ZL div",val,zsData);
				}
			});
			$.circular('DL_CHART', dlData);
			$.circular('ZS_CHART', zsData);
		}else{
			
		}
	
	}).error(function(status, ex){
		
	}).complete(function(){
		$(".telcom").unblock();
	})();
}
</script>