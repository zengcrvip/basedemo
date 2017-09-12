<#-- 宏定义 -->
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

<#macro blockrender data=[] field="" title="" measure="none">
<div class="swiper-slide" style="text-align:center;">
	<div class="rblock shadow">
		<div class="ritem">
			<span class="mtitle">${title}</span>
		</div>
	<#if data?size gt 0>
	<#local MAX=0>
	<#list data?sort_by(field)?reverse as item>
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
				<em class="sort">${item_index+1}</em>
		</#if>
			</div>
			<span class="rcell rsname"<#if orgType == "store"> title="${item.NAME!}"<#else> title="点击查看详情" onclick="toMainGoodsDialog('${item.ID!}', '${item.NAME!}');"</#if>>${item.NAME}</span>
			<div class="rcell rbar"><@jindu val=item[field] max=MAX/></div>
		<#if measure == "money">
			<span class="rcell rval"><@money val=item[field]/></span>	
		<#elseif measure == "rate">
			<span class="rcell rval"><@percent val=item[field]/></span>
		<#else>
			<span class="rcell rval"><@number val=item[field]/></span>		
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

<#function grouping data=[]>
	<#local levela=[]>
	<#local levelb=[]>
	<#local levelc=[]>
	<#list data as item>
		<#if item.MAIN_LEVEL == "A">
			<#local levela=levela + [item]>
		<#elseif item.MAIN_LEVEL == "B">
			<#local levelb=levelb + [item]>
		<#elseif item.MAIN_LEVEL == "C">
			<#local levelc=levelc + [item]>
		</#if>
	</#list>
	<#return {'A': levela, 'B': levelb, 'C': levelc}>
</#function>

<#assign maingoods=[
{"MAIN_LEVEL": "A", "NAME": "测试型号1", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"MAIN_LEVEL": "B", "NAME": "测试型号2", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"MAIN_LEVEL": "C", "NAME": "测试型号3", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676},
{"MAIN_LEVEL": "A", "NAME": "测试型号4", "GP": 12323, "GP_TQ": 5676, "GM": 17.34, "GM_TQ": 13.34, "AMT": 12323, "AMT_TQ": 5676, "NUM": 12323, "NUM_TQ": 5676}
]>
<#assign GROUPS=grouping(maingoods)>

<div class="ranking-block swiper-container" style="width:100%;height:360px;">
	<div class="swiper-wrapper">
<#switch index>
	<#case "GP">   
		<@blockrender data=GROUPS.A field="GP" title="A类主推" measure="money" />
		<@blockrender data=GROUPS.B field="GP" title="B类主推" measure="money" />
		<@blockrender data=GROUPS.C field="GP" title="C类主推" measure="money" />
		<#break>
	<#case "GM">   
		<@blockrender data=GROUPS.A field="GM" title="A类主推" measure="rate" />
		<@blockrender data=GROUPS.B field="GM" title="B类主推" measure="rate" />
		<@blockrender data=GROUPS.C field="GM" title="C类主推" measure="rate" />
		<#break>
	<#case "AMT">   
		<@blockrender data=GROUPS.A field="AMT" title="A类主推" measure="money" />
		<@blockrender data=GROUPS.B field="AMT" title="B类主推" measure="money" />
		<@blockrender data=GROUPS.C field="AMT" title="C类主推" measure="money" />
		<#break>
	<#case "NUM">   
		<@blockrender data=GROUPS.A field="NUM" title="A类主推" />
		<@blockrender data=GROUPS.B field="NUM" title="B类主推" />
		<@blockrender data=GROUPS.C field="NUM" title="C类主推" />
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