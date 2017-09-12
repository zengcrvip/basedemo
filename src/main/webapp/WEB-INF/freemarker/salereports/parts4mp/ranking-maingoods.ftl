<#-- 宏定义 -->
<#macro money val=0>
	<#if val??>
		<span>￥${val?string("#.##")}</span>
	<#else>
		<span>--</span>
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

<#macro blockrender data=[] title="" measure="none">
<div class="swiper-slide" style="text-align:center;">
	<div class="rblock shadow">
		<div class="ritem">
			<span class="mtitle">${title} 类主推</span>
		</div>
	<#if data?size gt 0>
	<#local MAX=0>
	<#list data?sort_by("rankSort") as item>
		<#if item_index == 0>
			<#local MAX=item["sale"]>
		<#elseif item_index gt 9>
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
			<span class="rcell rsname"<#if orgType == "store"> title="${item.goodsModeName!}"<#else> title="点击查看详情" onclick="toMainGoodsDialog('${item.goodsModeCode!}', '${item.goodsModeName!}');"</#if>>${item.goodsModeName}</span>
			<div class="rcell rbar"><@jindu val=item["sale"] max=MAX/></div>
		<#if measure == "money">
			<span class="rcell rval"><@money val=item["sale"]/></span>	
		<#elseif measure == "rate">
			<span class="rcell rval"><@percent val=item["sale"]/></span>
		<#else>
			<span class="rcell rval"><@number val=item["sale"]/></span>		
		</#if>
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

<#assign details=[{
	"mainPushTypeName": "A",
	"list": [
		{"rankSort": 1, "goodsModeCode": "1001", "goodsModeName": "主推型号1", "sale": 87, "completionRate": 56},
		{"rankSort": 2, "goodsModeCode": "1002", "goodsModeName": "主推型号2", "sale": 67, "completionRate": 56},
		{"rankSort": 3, "goodsModeCode": "1003", "goodsModeName": "主推型号3", "sale": 45, "completionRate": 56},
		{"rankSort": 4, "goodsModeCode": "1004", "goodsModeName": "主推型号4", "sale": 34, "completionRate": 56},
		{"rankSort": 5, "goodsModeCode": "1005", "goodsModeName": "主推型号5", "sale": 28, "completionRate": 56}
	]
}, {
	"mainPushTypeName": "B",
	"list": [
		{"rankSort": 1, "goodsModeCode": "1001", "goodsModeName": "B主推型号1", "sale": 87, "completionRate": 56},
		{"rankSort": 2, "goodsModeCode": "1002", "goodsModeName": "B主推型号2", "sale": 67, "completionRate": 56},
		{"rankSort": 3, "goodsModeCode": "1003", "goodsModeName": "B主推型号3", "sale": 45, "completionRate": 56},
		{"rankSort": 4, "goodsModeCode": "1004", "goodsModeName": "B主推型号4", "sale": 34, "completionRate": 56},
		{"rankSort": 5, "goodsModeCode": "1005", "goodsModeName": "B主推型号5", "sale": 28, "completionRate": 56}
	]
}, {
	"mainPushTypeName": "C",
	"list": [
		{"rankSort": 1, "goodsModeCode": "1001", "goodsModeName": "C主推型号1", "sale": 87, "completionRate": 56},
		{"rankSort": 2, "goodsModeCode": "1002", "goodsModeName": "C主推型号2", "sale": 67, "completionRate": 56},
		{"rankSort": 3, "goodsModeCode": "1003", "goodsModeName": "C主推型号3", "sale": 45, "completionRate": 56},
		{"rankSort": 4, "goodsModeCode": "1004", "goodsModeName": "C主推型号4", "sale": 34, "completionRate": 56},
		{"rankSort": 5, "goodsModeCode": "1005", "goodsModeName": "C主推型号5", "sale": 28, "completionRate": 56}
	]
}, {
	"mainPushTypeName": "D",
	"list": [
		{"rankSort": 1, "goodsModeCode": "1001", "goodsModeName": "C主推型号1", "sale": 87, "completionRate": 56},
		{"rankSort": 2, "goodsModeCode": "1002", "goodsModeName": "C主推型号2", "sale": 67, "completionRate": 56},
		{"rankSort": 3, "goodsModeCode": "1003", "goodsModeName": "C主推型号3", "sale": 45, "completionRate": 56},
		{"rankSort": 4, "goodsModeCode": "1004", "goodsModeName": "C主推型号4", "sale": 34, "completionRate": 56}
	]
}, {
	"mainPushTypeName": "E",
	"list": [
		{"rankSort": 1, "goodsModeCode": "1001", "goodsModeName": "C主推型号1", "sale": 87, "completionRate": 56},
		{"rankSort": 2, "goodsModeCode": "1002", "goodsModeName": "C主推型号2", "sale": 67, "completionRate": 56},
		{"rankSort": 3, "goodsModeCode": "1003", "goodsModeName": "C主推型号3", "sale": 45, "completionRate": 56},
		{"rankSort": 4, "goodsModeCode": "1004", "goodsModeName": "C主推型号4", "sale": 34, "completionRate": 56}
	]
}]>

<div class="ranking-block swiper-container" style="width:100%;height:360px;">
	<div class="swiper-wrapper">
<#switch index>
	<#case "GP">   
		<#list details as item>
			<@blockrender data=item.list title=item.mainPushTypeName measure="money" />
		</#list>
		<#break>
	<#case "GM">   
		<#list details as item>
			<@blockrender data=item.list title=item.mainPushTypeName measure="rate" />
		</#list>
		<#break>
	<#case "AMT">   
		<#list details as item>
			<@blockrender data=item.list title=item.mainPushTypeName measure="money" />
		</#list>
		<#break>
	<#case "NUM">   
		<#list details as item>
			<@blockrender data=item.list title=item.mainPushTypeName measure="none" />
		</#list>
		<#break>
	<#default>
</#switch>
	</div>
    <div class="swiper-pagination"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>
<script language="javascript">
    var swiper = new Swiper('.swiper-container', {
		pagination: '.swiper-pagination',
        slidesPerView: 3,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true,
		grabCursor: true,
		nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev'
    });
</script>