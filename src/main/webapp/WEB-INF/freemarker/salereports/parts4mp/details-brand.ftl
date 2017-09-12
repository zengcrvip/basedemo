<#-- 宏定义 -->
<#macro tongbi val=0>
	<#if val??>
		<#if val gt 0>
			+${val?string("#.##")} %<span style="color:#FF0000;font-weight:bold;">↑</span>
		<#elseif val == 0>
			${val?string("#.##")} %		
		<#else>
			${val?string("#.##")} %<span style="color:#009000;font-weight:bold;">↓</span>		
		</#if>
	<#else>
		<span>--%</span>
	</#if>
</#macro>

<#macro jindu val=0 max=0>
	<#if val?? && max?? && max != 0>
		<#local jdval=val * 100 / mabs(max)>
		<#if jdval gt 0>
			<div style="width:${jdval}%;height:16px;background:#87CEFF;"></div>
		<#else>
			<div style="width:${mabs(jdval)}%;height:16px;background:#87CE45;" title="当前品牌值为负数"></div>		
		</#if>
	<#else>
		<div style="width:0%;height:16px;background:#87CEFF;"></div>
	</#if>
</#macro>

<#macro money val=0>
	<#if val??>
		<span>￥${val?string("#.##")}</span>
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

<#macro blockrender data=[] title="" measure="none" isGM=false>
	<div class="rblock">
		<div class="ritem">
			<span class="rcell flag"><b/></span>
			<#if orgType=="head">
			<span class="rcell rtitle">大区销售排名</span>
			<#elseif orgType=="area">
			<span class="rcell rtitle">
				<div title="点击返回大区排名" class="ranking-back">
					<img src="/BaseDemo/webstatic/images/back.png" width="12px" height="12px"/>
				</div>
				门店销售排名
			</span>
			</#if>
			<span class="rcell rbar">&nbsp;</span>
			<span class="rcell rval">${title}</span>
			<span class="rcell rzb"><#if isGM>&nbsp;<#else>占比</#if></span>
			<span class="rcell rtb">同比</span>
		</div>
		<div class="rsbox">
	<#if data?size gt 0>
	<#local MAX=0>
	<#list data?sort_by("rankSort") as item>
			<#if item_index == 0>
				<#local MAX=item["value"]>
			<#elseif item_index gt 20>
				<#break>
			</#if>
			<div class="ritem">
				<div class="rcell rno">
			<#if item["rankSort"] lt 4>
					<em class="sort top3">${item["rankSort"]}</em>
			<#else>
					<em class="sort">${item["rankSort"]}</em>
			</#if>
				</div>
				<span class="rcell rname"<#if orgType=="head"> title="点击查看门店排名" onclick="toLoadStores('${item.orgCode!}', '${item.orgName!}');"<#else> title="${item.orgName!}"</#if>>${item.orgName!}</span>
				<div class="rcell rbar"><@jindu val=item["value"] max=MAX/></div>
				<#if measure == "money">
				<span class="rcell rval"><@money val=item["value"]/></span>
				<#elseif measure == "rate">
				<span class="rcell rval"><@percent val=item["value"]/></span>
				<#else>
				<span class="rcell rval"><@number val=item["value"]/></span>		
				</#if>
			<#if isGM>
				<span class="rcell rzb">&nbsp;</span>
			<#else>
				<span class="rcell rzb"><@percent val=item["proportion"]/></span>
			</#if>
				<span class="rcell rtb"><@tongbi val=item["an"]/></span>			
			</div>
	</#list>
	<#else>
			<div class="rnodata">
				暂无数据, 敬请期待
			</div>
	</#if>
		</div>
	</div>
</#macro>

<#-- 函数定义 -->
<#function mabs val=0>
	<#if val gt 0>
		<#return val>
	<#else>
		<#return 0 - val>
	</#if>
</#function>

<#-- 测试数据 -->
<#assign details=[
{"orgCode": "10001", "orgName": "组织名称1", "rankSort": 1, "value": 34, "proportion": 34.33, "an": 34},
{"orgCode": "10002", "orgName": "组织名称2", "rankSort": 2, "value": 34, "proportion": 34.33, "an": -12},
{"orgCode": "10003", "orgName": "组织名称3", "rankSort": 3, "value": 34, "proportion": 34.33, "an": -9},
{"orgCode": "10004", "orgName": "组织名称4", "rankSort": 4, "value": 34, "proportion": 34.33, "an": 34},
{"orgCode": "10001", "orgName": "组织名称1", "rankSort": 1, "value": 34, "proportion": 34.33, "an": 34},
{"orgCode": "10002", "orgName": "组织名称2", "rankSort": 2, "value": 34, "proportion": 34.33, "an": -12},
{"orgCode": "10003", "orgName": "组织名称3", "rankSort": 3, "value": 34, "proportion": 34.33, "an": -9},
{"orgCode": "10004", "orgName": "组织名称4", "rankSort": 4, "value": 34, "proportion": 34.33, "an": 34},
{"orgCode": "10001", "orgName": "组织名称1", "rankSort": 1, "value": 34, "proportion": 34.33, "an": 34},
{"orgCode": "10002", "orgName": "组织名称2", "rankSort": 2, "value": 34, "proportion": 34.33, "an": -12},
{"orgCode": "10003", "orgName": "组织名称3", "rankSort": 3, "value": 34, "proportion": 34.33, "an": -9},
{"orgCode": "10004", "orgName": "组织名称4", "rankSort": 4, "value": 34, "proportion": 34.33, "an": 34}
]>

<div class="ranking-block">
<#switch index>   
	<#case "GP">   
		<@blockrender data=details title="毛利额" measure="money"/>
		<#break>
	<#case "GM">   
		<@blockrender data=details title="毛利率" measure="rate" isGM=true/>
		<#break>
	<#case "AMT">   
 		<@blockrender data=details title="销售额" measure="money"/>
		<#break>
	<#case "NUM">   
 		<@blockrender data=details title="销售量" measure="none"/>
		<#break>
	<#default>
</#switch>
</div>
<script language="javascript">
<#if orgType=="head">
	function toLoadStores(areaId, areaName){
		$('#RANKING_DLG').data('title', $('#RANKING_DLG').find('.rct-modal-header div').text());
		$('#RANKING_DLG').data('areaRank', $('#RANKING_DLG .dialog-panel').html());
		// 加载区域销售
		savedParams.areaId = areaId;
		$('#RANKING_DLG').block(maskOption);
		$('#RANKING_DLG .dialog-panel').load(report.brandUrl1, savedParams, function(){
			$('#RANKING_DLG').unblock();
			var title = $('#RANKING_DLG').data('title');
			$('#RANKING_DLG').find('.rct-modal-header div').html(title + " - " + areaName);
		});
	}
<#elseif orgType=="area">
	if(report.brandUrl1 != null){
		$('.ranking-back').click(function(){
			var title = $('#RANKING_DLG').data('title');
			$('#RANKING_DLG').find('.rct-modal-header div').html(title);
			var areaRank = $('#RANKING_DLG').data('areaRank');
			$('#RANKING_DLG .dialog-panel').html(areaRank);
		});
	}else{
		$('.ranking-back').hide();
	}
</#if>
</script>