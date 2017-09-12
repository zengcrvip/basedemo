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

<#macro gridcell data={} option={}>
	<#local name=option["@name"]>
	<#local type=option["@type"]>
	<#local field=option["@field"]>
	<#local tqfield=option["@tqfield"]>
	<#local rankfield=option["@rankfield"]>
	<#if name?? && name != "">
		<#if type == 'money'>
		<div class="name">${name!}: <@money val=data[field] /></div>
		<#elseif type == 'yuan'>
		<div class="name">${name!}: <@money val=data[field] /></div>
		<#elseif type == 'percent'>
		<div class="name">${name!}: <@percent val=data[field] /></div>
		<#else>
		<div class="name">${name!}: <@number val=data[field] /></div>
		</#if>
		<div class="number">同比: <@tongbi bqval=data[field] tqval=data[tqfield] /></div>
		<#if orgType != 'head'>
		<div class="number">排名: ${data[rankfield]!}</div>
		</#if>
	<#else>
		<div class="name">&nbsp;</div>
		<div class="number">&nbsp;</div>
		<div class="number">&nbsp;</div>
	</#if>
</#macro>

<#macro gridcellMG data={}>
	<#if data.MAIN_LEVEL??>
		<#local compRate=rate(data.NUM_SALE, data.NUM_TASK)>
		<#local propRate=rate(data.NUM_SALE, sales.NUM_MAINGOODS)>
		<div class="name">${data.MAIN_LEVEL!}类主推</div>
		<div class="number">任务: <@number val=data.NUM_TASK /></div>
		<div class="number">完成: <@number val=data.NUM_SALE /></div>
		<div class="number">完成率: <@percent val=data.RATE_COMP /></div>
		<div class="number">占比: <@percent val=data.RATE_PROP /></div>
	<#else>
		<div class="name"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
		<div class="number"></div>
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

<div class="part-content general">
	<div id="ML_CHART" class="chart"></div>
	<div class="chart-detail">
		<div class="name">毛利额</div>
		<div class="number">任务: <@money val=task.AMT_GP /></div>
		<div class="number">完成: <@money val=grossprofit.GP_TOTAL /></div>
		<div class="number">同比: <@tongbi bqval=grossprofit.GP_TOTAL tqval=grossprofit.GP_TOTAL_TQ /></div>
	<#if orgType != 'head'>
		<div class="number">排名: ${grossprofit.GP_TOTAL_RANK!}</div>
	</#if>
	</div>
	<div style="display:inline-block;vertical-align: top;">
		<div class="grid-row left right bottom">
			<#assign ML_ROW0=config.sector.group[0].row[0]>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW0.index[0]/>
			</div>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW0.index[1]/>
			</div>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW0.index[2]/>
			</div>
			<div class="cell">
				<@gridcell data=general option=ML_ROW0.index[3]/>
			</div>
		</div>
	
		<div class="grid-row left right">
			<#assign ML_ROW1=config.sector.group[0].row[1]>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW1.index[0]/>
			</div>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW1.index[1]/>
			</div>
			<div class="cell right">
				<@gridcell data=grossprofit option=ML_ROW1.index[2]/>
			</div>
			<div class="cell">
				<@gridcell data=grossprofit option=ML_ROW1.index[3]/>
			</div>
		</div>
	</div>
</div>
<div class="part-content general">
	<div id="XS_CHART" class="chart"></div>
	<div class="chart-detail">
		<div class="name">销售额</div>
		<div class="number">任务: <@money val=task.AMT_SALE /></div>
		<div class="number">完成: <@money val=sales.AMT_TOTAL /></div>
		<div class="number">同比: <@tongbi bqval=sales.AMT_TOTAL tqval=sales.AMT_TOTAL_TQ /></div>
	<#if orgType != 'head'>
		<div class="number">排名: ${sales.AMT_TOTAL_RANK!}</div>
	</#if>
	</div>
	<div style="display:inline-block;vertical-align:top;">
		<div class="grid-row left right bottom">
			<#assign SL_ROW0=config.sector.group[1].row[0]>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW0.index[0]/>
			</div>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW0.index[1]/>
			</div>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW0.index[2]/>
			</div>
			<div class="cell">
				<@gridcell data=sales option=SL_ROW0.index[3]/>
			</div>
		</div>
			
		<div class="grid-row left right">
			<#assign SL_ROW1=config.sector.group[1].row[1]>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW1.index[0]/>
			</div>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW1.index[1]/>
			</div>
			<div class="cell right">
				<@gridcell data=sales option=SL_ROW1.index[2]/>
			</div>
			<div class="cell">
				<@gridcell data=sales option=SL_ROW1.index[3]/>
			</div>
		</div>
	</div>
</div>
<div class="part-content general">
	<div id="ZT_CHART" class="chart"></div>
	<div class="chart-detail">
		<div class="name">主推销售量</div>
		<div class="number">任务: <@number val=task.NUM_MGDS /></div>
		<div class="number">完成: <@number val=sales.NUM_MAINGOODS /></div>
	<#if orgType != 'head'>
		<div class="number">排名: ${sales.NUM_MAINGOODS_RANK!}</div>
	</#if>
	</div>
	<div style="display:inline-block;vertical-align:top;">
		<div class="grid-row right bottom" style="height:148px;">
			<div class="rowspan2 left right">
				<@gridcellMG data={"MAIN_LEVEL": "A", "NUM_TASK": 4323, "NUM_SALE": 754, "RATE_COMP": 42, "RATE_PROP": 32} />
			</div>
			<div class="rowspan2 right">
				<@gridcellMG data={"MAIN_LEVEL": "B", "NUM_TASK": 4323, "NUM_SALE": 754, "RATE_COMP": 42, "RATE_PROP": 32} />
			</div>
			<div class="rowspan2 right">
				<@gridcellMG data={"MAIN_LEVEL": "C", "NUM_TASK": 4323, "NUM_SALE": 754, "RATE_COMP": 42, "RATE_PROP": 32} />
			</div>
			<div class="rowspan2">
				<@gridcellMG data={} />
			</div>
		</div>
		<div class="grid-row left right" style="height:40px;">
		</div>
	</div>
</div>
<script language="javascript">
	var mlValue = ${rate(grossprofit.GP_TOTAL, task.AMT_GP)?string("#.##")};
	var xsValue = ${rate(sales.AMT_TOTAL, task.AMT_SALE)?string("#.##")};
	var ztValue = ${rate(sales.NUM_MAINGOODS, task.NUM_MGDS)?string("#.##")};
	$.gauge('ML_CHART', {title: '毛利额', value: mlValue});
	$.gauge('XS_CHART', {title: '销售额', value: xsValue});
	$.gauge('ZT_CHART', {title: '主推销售量', value: ztValue});
</script>