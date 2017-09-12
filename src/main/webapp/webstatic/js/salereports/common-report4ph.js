// 保存查询参数
var savedParams = null;

// 加载遮罩选项
var maskOption = {  
    message:'正在加载数据，请等待...',
    overlayCSS:  {
		backgroundColor: '#DDD',
		opacity: 0.2,
		cursor: 'wait'
	},
	css: {
		color: '#000',
		opacity: 0.3,
		background: '#AAA', 
        'border-radius': '10px'
	}
};

/**
 * 销售概览报表初始化
 */
$(document).ready(function() {
	// 初始化图表
	require.config({paths: {echarts: '/BaseDemo/webstatic/js/echarts'}});
	// 初始化对话框
	$(document.body).append('<div class="rct-modal-mask"></div>');
	$('.rct-modal-close').click(function(){
		$('.rct-modal-mask').hide();
		$(this).closest('.rct-modal').hide('slow');
	});
	$('.rct-modal-footer .rct-button').click(function(){
		$('.rct-modal-mask').hide();
		$(this).closest('.rct-modal').hide('slow');
	});
	$('#queryBtn').click(function(){
		doQueryReport(report.queryParams());
	});
	// 初始化查询条件
	report.initQuery();
	// 初始化菜单面板
	$('.menu-panel').hide();
	$('input[name="sector"]').click(function(){
		// 选择事业部显示查询
		showMenuPanel(1);
	});
	// 初始化销售明细
	$('input[name="detailType"]').click(function(){
		savedParams.type = $(this).val();
		$('#CAPSULE_PANEL').block(maskOption);
		$('#CAPSULE_PANEL .part-content').load(report.capsuleUrl, savedParams, function(){
			$('#CAPSULE_PANEL').unblock();
		});
	});
	// 加载报表数据
	doQueryReport(report.queryParams());
	// 设置页面缩放
	$(window).resize(resizeReportPanel);
	// 浮动标题设置
	$('.report-region').scroll(function(){
		debugger;
		var scroll = $(this).scrollTop();
		if(scroll == 0){
			$('.fixed-panel').removeData('POSITION');
		}else{
			var parts = $('.report-region').children(':visible:gt(0)');
			var position = $('.fixed-panel').data('POSITION');
			var height = 0;
			$.each(parts, function(idx, part){
				 var nextHeight = height + $(part).height() - 31 * (idx + 1);
				 if(scroll > height && scroll <= nextHeight){
					 if(position != idx){
						 if(idx == 0){
							 $('.fixed-panel').empty();
						 }else{
							 $('.fixed-panel .part-header:gt('+(idx-1)+')').remove();
						 }
						 var header = $(part).find('.part-header').clone(false);
						 // 销售明细-明细类型按钮组
						 if(idx == 2){
							 bindFixedDetailType(header);
						 }
						 header.attr('title', '点击转到该区域');
						 header.data('HEIGHT', height);
						 header.addClass('fixed');
						 header.click(function(){
							 $(this).nextAll().remove();
							 $('.report-region').scrollTop($(this).data('HEIGHT'));
						 });
						 $('.fixed-panel').append(header);
						 $('.fixed-panel').data('POSITION', idx);
					 }
				 }
				 height = height + $(part).height() - 31;
			});
		}
	});
});

/**
 * 显示菜单面板
 */
function showMenuPanel(idx){
	$('#menuPanels .menu-panel').hide();
	$("#menuBar a").removeClass('active');
	if($("#menuPanels").data('index') != idx){
		$('#menuPanels .menu-panel').eq(idx).show();
		$("#menuPanels").data('index', idx);
		$("#menuBar a").eq(idx).addClass('active');
	}else{
		$("#menuPanels").removeData('index');
	}
	resizeReportPanel();
}

/**
 * 隐藏菜单面板
 */
function hideMenuPanel(){
	$('#menuPanels .menu-panel').hide();
	$("#menuPanels").removeData('index');
	$("#menuBar a").removeClass('active');
	resizeReportPanel();
}

/**
 * 查询报表数据
 */
function doQueryReport(params){
	// 查询前执行
	if(report.beforeQuery != null && (typeof report.beforeQuery) == 'function'){
		var result = report.beforeQuery(params);
		if(!result){
			return;
		}
	}
	// 销售概况
	$('#GENERAL_PANEL').block(maskOption);
	$('#GENERAL_PANEL .general-box').load(report.generalUrl, params, function(){
		$(this).removeClass('part-content');
		$('#GENERAL_PANEL').unblock();
	});
	if(params.sectorId == '00006'){
		// 通讯专有运营商概况
		$('#TELCOM_PANEL').show();
		$('#TELCOM_PANEL').block(maskOption);
		$('#TELCOM_PANEL .part-content').load(report.telcomUrl, params, function(){
			$('#TELCOM_PANEL').unblock();
		});
	}else{
		$('#TELCOM_PANEL').hide();
	}
	// 销售明细
	$('#CAPSULE_PANEL').block(maskOption);
	$('#CAPSULE_PANEL .part-content').load(report.capsuleUrl, params, function(){
		$('#CAPSULE_PANEL').unblock();
	});
	
	// 保存查询参数
	savedParams = params;
	// 隐藏菜单面板
	hideMenuPanel();
	// 设置报表区域
	resizeReportPanel();
	// 设置浮动标题
	$('.report-region').scrollTop(0);
	$('.fixed-panel').empty();
	$('.fixed-panel').removeData('POSITION');
}

/**
 * 打开消息对话框
 */
function messageBox(type, message){
	if(type == 'INFO'){
		openDialog('#MESSAGE_DLG', '消息');
	}else if(type == 'WARN'){
		openDialog('#MESSAGE_DLG', '警告');		
	}else if(type == 'ERROR'){
		openDialog('#MESSAGE_DLG', '错误');		
	}else{
		openDialog('#MESSAGE_DLG', '消息');
	}
	$('#MESSAGE_DLG .dialog-panel').html(message);
}

/**
 * 打开公告栏
 */
function toNoticeDialog(){
	openDialog('#NOTICE_DLG');
	hideMenuPanel();
	// 加载公告信息
	var url = "/BaseDemo/SaleOverview/notices.htm";
	$('#NOTICE_DLG').block(maskOption);
	$('#NOTICE_DLG .dialog-panel').load(url, {}, function(){
		$('#NOTICE_DLG').unblock();
	});
}

/**
 * 打开打印预览
 */
function toPrintDialog(){
	openDialog('#PRINT_DLG');
	hideMenuPanel();
	// 创建页面截图
}

/**
 * 绑定销售类型按钮
 * @param header
 */
function bindFixedDetailType(header){
	$.each(header.find("input[type='radio']"), function(idx, input){
		$(input).attr('name', 'detailType1');
		$(input).attr('id', 'idx1'+idx);
		$(input).click(function(){
			$('input[name="detailType"]').eq(idx).trigger('click');
		});
		$(input).next().attr('for', 'idx1'+idx);
	});
}

/**------------------------- 公共函数区域 ------------------------- */
/**
* 返回同比增加向上向下箭头样式
* @param str
* @returns
*/
function getTongBiVal(str){
	if(str == null || str == undefined || str == ''){
		return '--%';
	}else{
		if(str == '0.00'){
			return str; 
		}else{
			if(str.indexOf('-') == 0){
				return str + '%<span style="color:#009000;font-weight:bold;">↓</span>';
			}else{
				return str + '%<span style="color:#FF0000;font-weight:bold;">↑</span>';
			} 
		}
	}
}

/**
 * 设置报表区域
 */
function resizeReportPanel(){
	var topHeight = $('#headPanel').height();
	topHeight = topHeight + $('.report-title').height();
	topHeight = topHeight + $('.report-subtitle').height();
	var reportHeight = $(window).height() - topHeight - 20;
	$('.report-region').height(reportHeight);
	$('.fixed-panel').css({top: (topHeight + 19) + 'px'});
	$('.fixed-panel').width($('.report-region').width() - 17);
}

/**
 * 初始化月报查询
 */
function initMonthQuery(){
	initMonthSelect('#currDate', moment('2015-08-01'), moment());
	initMonthSelect('#compDate', moment('2015-08-01'), moment());
	$('#compArea').chosen({disable_search_threshold: 10});
}

/**
 * 初始化日报查询
 */
function initDaysQuery(){
	var begin = moment().format('YYYY-MM-01');
	var end = moment().format('YYYY-MM-DD');
	$('#currDate').val(begin + ' 至 ' + end);
	$('#compDate').val(begin + ' 至 ' + end);
	$('#currDate').dateRangePicker({language: 'cn', separator: ' 至 '});
	$('#compDate').dateRangePicker({language: 'cn', separator: ' 至 '});
	$('#compArea').chosen({disable_search_threshold: 10});
}

/**
 * 获取月报参数
 */
function getMonthParams(){
	return {
		sectorId: $('input[name="sector"]:checked').val(),
		sectorTxt: $('input[name="sector"]:checked').next('label').html(),
		currDate: $('#currDate option:selected').val().replace(/[年|月]/g, ''),
		currDateTxt: $('#currDate option:selected').text(),
		compDate: $('#compDate option:selected').val().replace(/[年|月]/g, ''),
		compDateTxt: $('#compDate option:selected').text(),
		compArea: $('#compArea option:selected').val(),
		compAreaTxt: $('#compArea option:selected').text(),
		type:  $('input[name="detailType"]:checked').val()
	};
}

/**
 * 获取日报参数
 */
function getDaysParams(){
	return {
		sectorId: $('input[name="sector"]:checked').val(),
		sectorTxt: $('input[name="sector"]:checked').next('label').html(),
		currDate: $('#currDate').val().replace(/-/g, '').replace(/ 至 /g, '|'),
		currDateTxt: $('#currDate').val(),
		compDate: $('#compDate').val().replace(/-/g, '').replace(/ 至 /g, '|'),
		compDateTxt: $('#compDate').val(),
		compArea: $('#compArea option:selected').val(),
		compAreaTxt: $('#compArea option:selected').text(),
		type:  $('input[name="detailType"]:checked').val()
	};
}

/**
 * 验证日报
 * @param params
 * @returns {Boolean}
 */
function checkDaysParams(params){
	var currMonth = params.currDate.substr(0, 6);
	var compMonth = params.compDate.substr(0, 6);
	if(currMonth != params.currDate.substr(9, 6)){
		messageBox('INFO', '查看日期应选择同一月份！');
		return false;
	}else if(compMonth != params.compDate.substr(9, 6)){
		messageBox('INFO', '对比日期应选择同一月份！');
		return false;
	}else{
		updateCondtionLabel(params);
		return true;
	}
}

/**
 * 更新条件标签
 */
function updateCondtionLabel(params){
	$('#L_SECTOR').html(params.sectorTxt);
	$('#L_DATE').html(params.currDateTxt);
	$('#L_CDATE').html(params.compDateTxt);
	$('#L_CAREA').html(params.compAreaTxt);
}

/**
 * 初始化月份选择
 */
function initMonthSelect(selId, begin, end){
	while(end.format('YYYYMM') != begin.format('YYYYMM')){
		var monthId = end.format('YYYYMM');
		var monthText = end.format('YYYY年MM月');
		var option = $('<option value="'+monthId+'">'+monthText+'</option>');
		$(selId).append(option);
		end = end.subtract(1, 'months');
	}
}

/**
 * 打开模式对话框
 */
function openDialog(dlgId, title){
	$('.rct-modal-mask').show();
	var top = ($('.rct-modal-mask').height() - $(dlgId).height()) / 2;
	var left = ($('.rct-modal-mask').width() - $(dlgId).width()) / 2;
	$(dlgId).find('.rct-modal-header div').html(title);
	$(dlgId).css({top: top - 10, left: left});
	$(dlgId).show();
}

/**
 * 打开模式对话框
 */
function showMessage(dlgId, message){
	var nodata = $('<div class="nodata">暂无数据, 敬请期待</div>');
	nodata.css({"line-height": ($(dlgId).height() - 40) + 'px'});	
	if(message != null){
		nodata.html(message);
	}
	$(dlgId).html(nodata);
}

/**
 * 提交表单
 * @param url
 * @param params
 */
function submitForm(url, params) {
	var form = document.createElement("form"); 
	form.id="tempForm1"; 
	form.method="POST"; 
	form.action=url;
    $.each(params, function(idx, value){
        input = document.createElement("input"); 
        input.type="hidden";
        input.name= idx;
        input.value= value;
        form.appendChild(input);
    });
    document.body.appendChild(form); 
    form.submit();
    document.body.removeChild(form);
}