<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge;charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>门店销售总览<#if period!='month'>日报<#else>月报</#if></title>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/jquery.chosen.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/jquery.daterangepicker.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/buttons.dataTables.min.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/fixedColumns.dataTables.min.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/jquery.swiper.min.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/rct-common.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/sale-reports4ph.css"></link>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/moment.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.chosen.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.daterangepicker.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/dataTables-extends/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/dataTables-extends/buttons.flash.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/dataTables-extends/buttons.html5.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/dataTables-extends/buttons.print.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/dataTables-extends/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.swiper.min.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/datasource.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/echarts/echarts.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/salereports/common-charts.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/salereports/common-report4ph.js"></script>
<script type="text/javascript">
// 报表选项
var report = {
<#if period!='month'>
	// 初始化查询
	initQuery : function(){
		initDaysQuery();
	},
	// 查询前执行
	beforeQuery : function(params){
		return checkDaysParams(params);
	},
	// 查询参数
	queryParams : function(){
		return getDaysParams();
	},
	// 销售概览URL
	generalUrl : '/BaseDemo/SaleOverview4ph/store/general.htm?period=days',
	// 运营商概览URL
	telcomUrl : '/BaseDemo/SaleOverview4ph/store/telcom.htm?period=days',
	// 各维度分析URL
	capsuleUrl : '/BaseDemo/SaleOverview4ph/store/capsule.htm?period=days',
<#else>
	// 初始化查询
	initQuery : function(){
		initMonthQuery();
	},
	// 查询前执行
	beforeQuery : function(params){
		updateCondtionLabel(params);
		return true;
	},
	// 查询参数
	queryParams : function(){
		return getMonthParams();
	},
	// 排名类型
	rankType : 'BRAND',
	// 销售概览URL
	generalUrl : '/BaseDemo/SaleOverview4ph/store/general.htm?period=month',
	// 运营商概览URL
	telcomUrl : '/BaseDemo/SaleOverview4ph/store/telcom.htm?period=month',
	// 各维度分析URL
	capsuleUrl : '/BaseDemo/SaleOverview4ph/store/capsule.htm?period=month',
</#if>
};
</script>
</head>
<body>
	<div id="headPanel" style="background: #F4F4F4;">
		<div id="menuBar" class="menu-bar">
			<a href="javascript:showMenuPanel(0);void(0);" class="rct-button">事业部</a>
			<a href="javascript:showMenuPanel(1);void(0);" class="rct-button">查询</a>
<#if adminScope == 'admin'>
</#if>
			<a href="javascript:toNoticeDialog();void(0);" class="rct-button">公告</a>
			<a href="javascript:toPrintDialog();void(0);" class="rct-button">打印</a>
		</div>
		<div id="menuPanels">
			<div class="menu-panel">
<#list sectors as item>
				<input type="radio" id="sct${item_index}" name="sector" value="${item.ID}"<#if item.ID == sector.ID> checked</#if>> 
				<label class="sector-label" for="sct${item_index}">${item.NAME}</label>
</#list>
			</div>
			<div class="menu-panel">
<#if period!='month'>
				<label class="rct-label">查看日期:</label> 
				<input type="text" id="currDate" class="rct-control" style="cursor:pointer;" size="24"></input> 
				<label class="rct-label">对比日期:</label> 
				<input type="text" id="compDate" class="rct-control" style="cursor:pointer;" size="24"></input> 
<#else>
				<label class="rct-label">查看年月:</label> 
				<select id="currDate" class="rct-control"></select>
				<label class="rct-label">对比年月:</label> 
				<select id="compDate" class="rct-control"></select>
</#if>				
				<label class="rct-label">对比区域:</label>
				<select id="compArea" class="rct-control" style="width:180px;">
					<option value="AREA:${areaId}" selected>${areaName}(大区)</option>
					<optgroup label="${areaName}(大区)门店">
<#list stores as item>
						<option value="STORE:${item.ID}">${item.ID} ${item.NAME}</option>
</#list>
					</optgroup>
				</select>
				<a id="queryBtn" href="#" class="rct-button" style="margin-left: 10px;">查 询</a>
			</div>
<#if adminScope == 'admin'>
</#if>
		</div>
	</div>

	<div id="reportPanel">
		<div class="report-title">
			<span>${storeName} 销售总览<#if period!='month'>(日)<#else>(月)</#if></span>
		</div>
		<div class="report-subtitle">
			<label class="rct-label">事业部:</label> <span id="L_SECTOR"></span> 
			<label class="rct-label">查看日期:</label> <span id="L_DATE"></span> 
			<label class="rct-label">对比日期:</label> <span id="L_CDATE"></span> 
			<label class="rct-label">对比区域:</label> <span id="L_CAREA"></span>
			<div class="right">
				<span>单位: ${(period=="month")?string("万元","元")}(金额)</span> 
			</div>
		</div>
		<div class="report-region">
			<div class="fixed-panel">
			</div>
			<div id="GENERAL_PANEL">
				<div class="part-header">
					<span class="title">销售总览</span>
				</div>
				<div class="part-content general-box"></div>
			</div>
			<div id="TELCOM_PANEL">
				<div class="part-header">
					<span class="title">运营商概览</span>
				</div>
				<div class="part-content telcom"></div>
			</div>
			<div id="CAPSULE_PANEL">
				<div class="part-header">
					<span class="title">门店销售明细</span>&nbsp;&nbsp;
					<input type="radio" id="idx1" name="detailType" value="staff" checked> 
					<label for="idx1">员工</label> 
					<input type="radio" id="idx2" name="detailType" value="brand"> 
					<label for="idx2">品牌</label>
					<input type="radio" id="idx3" name="detailType" value="goods">
					<label for="idx3">单品</label>
					<input type="radio" id="idx4" name="detailType" value="maingoods">
					<label for="idx4">主推</label>
					<input type="radio" id="idx5" name="detailType" value="channel">
					<label for="idx5">渠道</label>
				</div>
				<div class="part-content capsule">
				</div>
			</div>
		</div>
		<!-- 消息对话框 -->
		<div id="MESSAGE_DLG" class="rct-modal">
			<a href="#" class="rct-modal-close">×</a>
			<div class="rct-modal-header">
				<div class="title"></div>
			</div>
			<div class="rct-modal-content">
				<div class="dialog-panel message"></div>
			</div>
			<div class="rct-modal-footer">
				<a href="#" class="rct-button">确定</a> 
				<a href="#" class="rct-button">关闭</a>
			</div>
		</div>
		<!-- 公告对话框 -->
		<div id="NOTICE_DLG" class="rct-modal">
			<a href="#" class="rct-modal-close">×</a>
			<div class="rct-modal-header">
				<div class="bigtitle">公告栏</div>
			</div>
			<div class="rct-modal-content">
				<div class="dialog-panel noticebox"></div>
			</div>
			<div class="rct-modal-footer">
				<a href="#" class="rct-button">确定</a> 
				<a href="#" class="rct-button">关闭</a>
			</div>
		</div>
		<!-- 打印对话框 -->
		<div id="PRINT_DLG" class="rct-modal">
			<a href="#" class="rct-modal-close">×</a>
			<div class="rct-modal-header">
				<div class="title">打印报表</div>
			</div>
			<div class="rct-modal-content">
				<div class="dialog-menus">
					<a href="#" class="rct-button">打印</a> 
					<a href="#" class="rct-button">放大</a> 
					<a href="#" class="rct-button">缩小</a> 
					<a href="#" class="rct-button">下一页</a> 
					<a href="#" class="rct-button">上一页</a>
				</div>
				<div class="dialog-panel printview"></div>
			</div>
			<div class="rct-modal-footer">
				<a href="#" class="rct-button">打印</a> 
				<a href="#" class="rct-button">取消</a>
			</div>
		</div>
	</div>
</body>
</html>