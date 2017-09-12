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

<#macro blockrender data=[] field="" title="" measure="none" isarea=false>
	<div class="rblock">
		<div class="ritem">
			<span class="rcell flag">&nbsp;</span>
			<span class="rcell rname" style="font-weight:bold;"><#if isarea>对比区域品牌<#else>${ORGTYPES[orgType]}品牌</#if></span>
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
			<#elseif item_index gt 9>
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
				<span class="rcell rname"<#if isarea || orgType == "store"> title="${item.NAME!}"<#else> title="点击查看详情" onclick="toBrandDialog('${item.ID!}', '${item.NAME!}');"</#if>>${item.NAME!}</span>
				<div class="rcell rbar"><@jindu val=item[field] max=MAX/></div>
			<#if !isarea>
				<#if measure == "money">
				<span class="rcell rval"><@money val=item[field]/></span>
				<#elseif measure == "rate">
				<span class="rcell rval"><@percent val=item[field]/></span>
				<#else>
				<span class="rcell rval"><@number val=item[field]/></span>		
				</#if>
			<#else>
				<span class="rcell rval">--</span>	
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
	<#if isarea==false>
	<div class="rblank"></div>
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

<#assign ORGTYPES={"store": "门店", "area": "大区", "head": "总部"}>
<#assign store=[{"NAME": "测试品牌1", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676}]>
<#assign area=[{"NAME": "测试品牌1", "GP": 6843, "GP_TQ": 6576, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676}]>

<div class="ranking-block">
<#switch index>   
	<#case "GP">   
		<@blockrender data=store field="GP" title="毛利额" measure="money" />
		<@blockrender data=area field="GP" title="毛利额" measure="money" isarea=true />
		<#break>
	<#case "GM">   
		<@blockrender data=store field="GM" title="毛利率" measure="rate" />
		<@blockrender data=area field="GM" title="毛利率" measure="rate" isarea=true />
		<#break>
	<#case "AMT">   
		<@blockrender data=store field="AMT" title="销售额" measure="money" />
		<@blockrender data=area field="AMT" title="销售额" measure="money" isarea=true />
		<#break>
	<#case "NUM">   
		<@blockrender data=store field="NUM" title="销售量" />
		<@blockrender data=area field="NUM" title="销售量" isarea=true />
		<#break>
	<#default>
</#switch>
</div>
