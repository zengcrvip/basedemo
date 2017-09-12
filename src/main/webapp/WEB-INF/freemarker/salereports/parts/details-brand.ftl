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

<#macro wanyuan val=0>
	<#if val??>
		<#local val1=val / 10000>
		<span>${val1?string("#.##")}</span>
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

<#macro blockrender data=[] field="" title="" measure="none">
	<div class="rblock">
		<div class="ritem">
			<span class="rcell rname" style="width:168px;font-weight:bold;">
				<#if orgType=="area"><a id="RANK_BRAND_BACK" href="#" title="点击返回大区排名" class="rct-href">返回 | </a></#if>
				<#if orgType=="head">大区<#elseif orgType=="area">门店</#if>销售排名
			</span>
			<span class="rcell rbar">&nbsp;</span>
			<span class="rcell rval">${title}</span>
			<span class="rcell rzb"><#if field=="GM">&nbsp;<#else>占比</#if></span>
			<span class="rcell rtb">同比</span>
		</div>
		<div class="rbox">
	<#if data?size gt 0>
	<#local MAX=0>
	<#list data?sort_by(field) as item>
			<#if item_index == 0>
				<#local MAX=item[field]>
			<#elseif item_index gt 15>
				<#break>
			</#if>
			<div class="ritem">
				<div class="rcell rno">
			<#if item_index lt 3>
					<em class="sort top3">${item_index+1}</em>
			<#else>
					<em class="sort">${item_index}</em>
			</#if>
				</div>
				<span class="rcell rname"<#if orgType=="head"> title="点击查看门店排名" onclick="toLoadStores('${item.ID!}', '${item.NAME!}');"<#else> title="${item.NAME!}"</#if>>${item.NAME!}</span>
				<div class="rcell rbar"><@jindu val=item[field] max=MAX/></div>
				<#if measure == "money">
				<span class="rcell rval"><@wanyuan val=item[field]/></span>
				<#elseif measure == "rate">
				<span class="rcell rval"><@percent val=item[field]/></span>
				<#else>
				<span class="rcell rval"><@number val=item[field]/></span>		
				</#if>
			<#if field=="GM">
				<span class="rcell rzb">&nbsp;</span>
			<#else>
				<span class="rcell rzb">--%</span>
			</#if>
				<span class="rcell rtb"><@tongbi bqval=item[field] tqval=item[field+"_TQ"]/></span>			
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

<#assign details=[
{"NAME": "北京大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "南京大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "上海大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "长春大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "北京大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "南京大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "上海大区", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676}
]>

<#assign details1=[
{"NAME": "新街口店", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "山西路店", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "大厂店", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "江宁店", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"NAME": "镇江店", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676}
]>

<div class="ranking-block">
<#if orgType=="head">
	<@blockrender data=details field="GM" title="毛利率" measure="rate"/>
<#elseif orgType=="area">
	<@blockrender data=details1 field="GP" title="毛利额" measure="money"/>
</#if>
</div>
<script language="javascript">
<#if orgType=="head">
	function toLoadStores(areaId, areaName){
		$('#RANKING_DLG').data('areaRank', $('#RANKING_DLG .dialog-panel').html());
		// 加载区域销售
		savedParams.areaId = areaId;
		$('#RANKING_DLG').block(maskOption);
		$('#RANKING_DLG .dialog-panel').load(report.brandUrl1, savedParams, function(){
			$('#RANKING_DLG').unblock();
		});
	}
<#elseif orgType=="area">
	if(report.brandUrl1 != null){
		var areaRank = $('#RANKING_DLG').data('areaRank');
		$('#RANK_BRAND_BACK').click(function(){
			$('#RANKING_DLG .dialog-panel').html(areaRank);
		});
	}else{
		$('#RANK_BRAND_BACK').hide();
	}
</#if>
</script>