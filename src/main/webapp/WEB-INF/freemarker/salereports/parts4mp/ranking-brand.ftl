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

<#macro blockrender data=[] title="" measure="none" isarea=false isGM=false>
	<div class="rblock">
		<div class="ritem">
			<span class="rcell flag"><b/></span>
			<span class="rcell rtitle"><#if isarea>对比区域品牌<#else>${ORGTYPES[orgType]}品牌</#if></span>
			<span class="rcell rbar">&nbsp;</span>
			<span class="rcell rval">${title}</span>
			<span class="rcell rzb"><#if isGM>&nbsp;<#else>占比</#if></span>
			<span class="rcell rtb">同比</span>
		</div>
		<div class="rbox">
	<#if data?size gt 0>
	<#local MAX=0>
	<#list data?sort_by("rankSort") as item>
			<#if item_index == 0>
				<#local MAX=item["value"]>
			<#elseif item_index gt 29>
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
				<span class="rcell rname"<#if isarea || orgType == "store"> title="${item.name!}"<#else> title="点击查看详情" onclick="toBrandDialog('${item.code!}', '${item.name!}');"</#if>>${item.name!}</span>
				<div class="rcell rbar"><@jindu val=item["value"] max=MAX/></div>
			<#if !isarea>
				<#if measure == "money">
				<span class="rcell rval"><@money val=item["value"]/></span>
				<#elseif measure == "rate">
				<span class="rcell rval"><@percent val=item["value"]/></span>
				<#else>
				<span class="rcell rval"><@number val=item["value"]/></span>		
				</#if>
			<#else>
				<span class="rcell rval">--</span>	
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

<#-- 测试数据 -->
<#assign store=[
	{"rankSort": 1, "code": "1001", "name": "测试品牌1", "value": 1323, "proportion": 15, "an": 15},
	{"rankSort": 2, "code": "1002", "name": "测试品牌2", "value": 1123, "proportion": 15, "an": -13},
	{"rankSort": 3, "code": "1003", "name": "测试品牌3", "value": 923, "proportion": 15, "an": 15},
	{"rankSort": 4, "code": "1004", "name": "测试品牌4", "value": 823, "proportion": 15, "an": -33},
	{"rankSort": 5, "code": "1005", "name": "测试品牌5", "value": 723, "proportion": 15, "an": 15},
	{"rankSort": 6, "code": "1006", "name": "测试品牌6", "value": 623, "proportion": 15, "an": 15},
	{"rankSort": 7, "code": "1002", "name": "测试品牌7", "value": 1123, "proportion": 15, "an": -13},
	{"rankSort": 8, "code": "1003", "name": "测试品牌8", "value": 923, "proportion": 15, "an": 15},
	{"rankSort": 9, "code": "1004", "name": "测试品牌9", "value": 823, "proportion": 15, "an": -33},
	{"rankSort": 10, "code": "1005", "name": "测试品牌10", "value": 723, "proportion": 15, "an": 15},
	{"rankSort": 11, "code": "1006", "name": "测试品牌11", "value": 623, "proportion": 15, "an": 15}

]>
<#assign area=[	
	{"rankSort": 1, "code": "1001", "name": "对比品牌1", "value": 1323, "proportion": 15, "an": 15},
	{"rankSort": 2, "code": "1002", "name": "对比品牌2", "value": 1123, "proportion": 15, "an": 15},
	{"rankSort": 3, "code": "1003", "name": "对比品牌3", "value": 923, "proportion": 15, "an": 15},
	{"rankSort": 4, "code": "1004", "name": "对比品牌4", "value": 823, "proportion": 15, "an": -66},
	{"rankSort": 5, "code": "1005", "name": "对比品牌5", "value": 723, "proportion": 15, "an": 15},
	{"rankSort": 6, "code": "1006", "name": "对比品牌6", "value": 623, "proportion": 15, "an": 15}
]>

<div class="ranking-block">
<#switch index>   
	<#case "GP">   
		<@blockrender data=store title="毛利额" measure="money" />
		<@blockrender data=area title="毛利额" measure="money" isarea=true />
		<#break>
	<#case "GM">   
		<@blockrender data=store title="毛利率" measure="rate" isGM=true />
		<@blockrender data=area title="毛利率" measure="rate" isarea=true isGM=true />
		<#break>
	<#case "AMT">   
		<@blockrender data=store title="销售额" measure="money" />
		<@blockrender data=area title="销售额" measure="money" isarea=true />
		<#break>
	<#case "NUM">   
		<@blockrender data=store title="销售量" />
		<@blockrender data=area title="销售量" isarea=true />
		<#break>
	<#default>
</#switch>
</div>
