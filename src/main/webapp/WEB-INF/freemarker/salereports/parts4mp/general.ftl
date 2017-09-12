<#-- 宏定义 -->
<#macro tongbi bqval=0 tqval=0>
	<#if bqval?? && tqval?? && tqval != 0>
		<#local tbval=(bqval - tqval) * 100 / mabs(tqval)>
		<#if tbval gt 0>
			+${tbval?string("#.##")} %<span style="color:#FF0000;font-weight:bold;">↑</span>
		<#elseif tbval == 0>
			${tbval?string("#.##")} %
		<#else>
			${tbval?string("#.##")} %<span style="color:#009000;font-weight:bold;">↓</span>		
		</#if>
	<#else>
		<span>--%</span>
	</#if>
</#macro>

<#macro wanyuan val=0>
	<#if val??>
		<#local val1=val / 10000>
		<span>${val1?string("#.##")}万元</span>
	<#else>
		<span>--</span>
	</#if>
</#macro>

<#macro yuan val=0>
	<#if val??>
		<span>${val?string("#.##")}元</span>
	<#else>
		<span>--</span>
	</#if>
</#macro>

<#macro percent val=0>
	<#if val??>
		<span>${val?string("#.##")}%</span>
	<#else>
		<span>--%</span>
	</#if>
</#macro>

<#macro number val=0>
	<#if val??>
		<span>${val?string("#.##")}</span>
	<#else>
		<span>--</span>
	</#if>
</#macro>

<#macro gridcell data={} option={}>
	<div class="name">&nbsp;</div>
	<div class="number">&nbsp;</div>
	<#if orgType != 'head'>
	  <div class="number">&nbsp;</div>
    </#if>
	
</#macro>

<#macro gridcellMG data={}>
	<div class="name"></div>
	<div class="number"></div>
	<div class="number"></div>
	<div class="number"></div>
	<#if orgType != 'head'>
	  <div class="number">&nbsp;</div>
  </#if>
</#macro>


<#-- 函数定义 -->
<#function mabs val=0>
	<#if val gt 0>
		<#return val>
	<#else>
		<#return 0 - val>
	</#if>
</#function>

<#function rate mole=0 deno=0>
	<#if mole?? && deno?? && deno != 0>
		<#local value=mole * 100 / deno>
		<#return value>
	<#else>
		<#return 0>
	</#if>
</#function>

<div id="ML_PANEL" class="part-content general normal">
	<div id="ML_CHART" class="chart"></div>
	<div id="ML_LEFT"  class="chart-detail">
		<div class="name"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
	<#if orgType != 'head'>
		<div class="number"></div>
	</#if>
	</div>
	<div id="ML_RIGHT" style="display:inline-block;vertical-align: top;">
		<div class="grid-row left right bottom">
			<div id="ML_INDEX_1" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_2" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_3" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_4" class="cell">
				<@gridcell data={} option={}/>
			</div>
		</div>
	
		<div class="grid-row left right bottom">
			<div id="ML_INDEX_5" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_6" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_7" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="ML_INDEX_8" class="cell">
				<@gridcell data={} option={}/>
			</div>
		</div>
			
		<div class="grid-row left right">
			<div class="colspan4">
				<div class="name">TIPS:</div>
			</div>
		</div>
	</div>
</div>
<div id="XS_PANEL" class="part-content general normal">
	<div id="XS_CHART" class="chart"></div>
	<div id="XS_LEFT"  class="chart-detail">
		<div class="name"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
	<#if orgType != 'head'>
		<div class="number"></div>
	</#if>
	</div>
	<div id="XS_RIGHT" style="display:inline-block;vertical-align:top;">
		<div class="grid-row left right bottom">
			<div id="XS_INDEX_1" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_2" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_3" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_4" class="cell">
				<@gridcell data={} option={}/>
			</div>
		</div>
			
		<div class="grid-row left right bottom">
			<div id="XS_INDEX_5" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_6" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_7" class="cell right">
				<@gridcell data={} option={}/>
			</div>
			<div id="XS_INDEX_8" class="cell">
				<@gridcell data={} option={}/>
			</div>
		</div>
			
		<div class="grid-row left right">
			<div class="colspan4">
				<div class="name">TIPS:</div>
			</div>
		</div>
	</div>
</div>
<div id="ZT_PANEL" class="part-content general tall">
	<div id="ZT_CHART" class="chart"></div>
	<div id="ZT_LEFT"  class="chart-detail">
		<div class="name"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
	<#if orgType != 'head'>
		<div class="number"></div>
	</#if>
	</div>
	<div id="ZT_RIGHT" style="display:inline-block;vertical-align:top;">
		<div class="grid-row left right bottom" style="height:148px;">
			<div id="ZT_INDEX_1" class="rowspan2 right">
				<@gridcellMG data={} />
			</div>
			<div id="ZT_INDEX_2" class="rowspan2 right">
				<@gridcellMG data={} />
			</div>
			<div id="ZT_INDEX_3" class="rowspan2 right">
				<@gridcellMG data={} />
			</div>
			<div id="ZT_INDEX_4" class="rowspan2">
				<@gridcellMG data={} />
			</div>
		</div>
		
		<div class="grid-row left right" style="height:122px;">
			<div class="colspan4" style="height:106px;">
				<div class="name">TIPS:</div>
			</div>
		</div>
	</div>
</div>
<script language="javascript">
$(function(){
	var period = '${period}';
	var params = report.queryParams();
	params.period = period;
	loadMaoLiData(params);//毛利总览
	loadXSData(params);//销售总览
	loadZTData(params);//主推总览   
	   
})


/**
 * 加载毛利数据
 */
function loadMaoLiData(params){
	var url = '/BaseDemo/SaleOverview4mp/common/getMAOLIData.htm?';
	var ajax = datasource(url, params);
	ajax.before(function(){
		$("#ML_CHART").parent().block(maskOption);
	}).then(function(data){
		if(data.returnCode == '0000'){
			var MAOLI = data.list;
			var index = 1;
			$.each(MAOLI,function(idx,val){
				if(val.viewType == '0'){
					$("#ML_LEFT div").eq(0).html(val.kpiName);
					$("#ML_LEFT div").eq(1).html("月度目标："+val.task);
					$("#ML_LEFT div").eq(2).html("实际完成："+val.sale);
					$("#ML_LEFT div").eq(3).html("同比："+val.an);
					$("#ML_LEFT div").eq(4).html("排名："+val.rank);
					$.gauge('ML_CHART', {title: '毛利额', value: val.completionRate});
				}else{
					$("#ML_INDEX_"+index +" div").eq(0).html(val.kpiName+"："+val.sale);
					$("#ML_INDEX_"+index +" div").eq(1).html("同比："+getTongBiVal(val.an));
					$("#ML_INDEX_"+index +" div").eq(2).html("排名："+val.rank);
					index++;
				}
			});
		}else{
			showMessage('#ML_PANEL','毛利总览数据加载失败，失败原因:【'+data.returnMsg+'】');
		}
	}).error(function(status, ex){
		showMessage('#ML_PANEL','毛利总览数据加载失败');
	}).complete(function(){
		$("#ML_CHART").parent().unblock();
	})();
}

/**
 * 加载销售数据
 */
function loadXSData(params){
	var url = '/BaseDemo/SaleOverview4mp/common/getXSData.htm?';
	var ajax = datasource(url, params);
	
	ajax.before(function(){
		$("#XS_CHART").parent().block(maskOption);
	}).then(function(data){
           if(data.returnCode == '0000'){
        	   var xsData = data.list;
    		   var xsIndex = 1;
    		   $.each(xsData,function(idx,val){
    			   if(val.viewType == '0'){
    					$("#XS_LEFT div").eq(0).html(val.kpiName);
    					$("#XS_LEFT div").eq(1).html("月度目标："+val.task);
    					$("#XS_LEFT div").eq(2).html("实际完成："+val.sale);
    					$("#XS_LEFT div").eq(3).html("同比："+getTongBiVal(val.an));
    					$("#XS_LEFT div").eq(4).html("排名："+val.rank);
    					$.gauge('XS_CHART', {title: '销售额', value: val.completionRate});
    				}else{
    					$("#XS_INDEX_"+xsIndex +" div").eq(0).html(val.kpiName+"："+val.sale);
    					$("#XS_INDEX_"+xsIndex +" div").eq(1).html("同比："+getTongBiVal(val.an));
    					$("#XS_INDEX_"+xsIndex +" div").eq(2).html("排名："+val.rank);
    					xsIndex++;
    				}
    		   });
           }else{
        	   showMessage('#XS_PANEL','销售总览数据加载失败，失败原因:【'+data.returnMsg+'】');
           }			   
	
	}).error(function(status, ex){
		showMessage('#XS_PANEL','销售总览数据加载失败');
	}).complete(function(){
		$("#XS_CHART").parent().unblock();
	})();
}

/**
 * 加载主推数据总览
 */
function loadZTData(params){
	var url = '/BaseDemo/SaleOverview4mp/common/getZTData.htm?';
	var ajax = datasource(url, params);
	
	ajax.before(function(){
		$("#ZT_CHART").parent().block(maskOption);
	}).then(function(data){
		if(data.returnCode == '0000'){
		   var ztData = data.list;
		   var ztIndex = 1;
		   $.each(ztData,function(idx,val){
			   if(val.viewType == '0'){
					$("#ZT_LEFT div").eq(0).html(val.kpiName);
					$("#ZT_LEFT div").eq(1).html("月度目标："+val.task);
					$("#ZT_LEFT div").eq(2).html("实际完成："+val.sale);
					$("#ZT_LEFT div").eq(3).html("同比："+getTongBiVal(val.an));
					$("#ZT_LEFT div").eq(4).html("排名："+val.rank);
					$.gauge('ZT_CHART', {title: '主推销售量', value: val.completionRate});
				}else{
					$("#ZT_INDEX_"+ztIndex +" div").eq(0).html(val.kpiName);
					$("#ZT_INDEX_"+ztIndex +" div").eq(1).html("销售量："+val.sale);
					$("#ZT_INDEX_"+ztIndex +" div").eq(2).html("完成率："+getTongBiVal(val.an));
					$("#ZT_INDEX_"+ztIndex +" div").eq(3).html("销量占比："+val.saleRate);
					$("#ZT_INDEX_"+ztIndex +" div").eq(4).html("排名："+val.rank);
					ztIndex++;
				}
		   });
		}else{
			showMessage('#ZT_PANEL','主推总览数据加载失败，失败原因:【'+data.returnMsg+'】');
		}
		
	}).error(function(status, ex){
		showMessage('#ZT_PANEL','主推总览数据加载失败');
	}).complete(function(){
		$("#ZT_CHART").parent().unblock();
	})();
}	   
		   
</script>