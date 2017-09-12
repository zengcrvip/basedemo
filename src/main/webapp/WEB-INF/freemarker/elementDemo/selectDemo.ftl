<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>select下拉框</title>	
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/jquery.chosen.css"></link>
<link rel="stylesheet" type="text/css" href="${base}/webstatic/css/rct-common.css"></link>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.chosen.js"></script>
<#include "/WEB-INF/ftl_macro/select.ftl">
<style type="text/css">
  
</style>
</HEAD>
<body>

<div style="margin:60px">
      <select id="compArea"  style="width:180px;">
		<option value="STORE:3" selected>3 南京</option>
		<optgroup label="(大区)门店">
		<option value="STORE:3">3 南京</option>
		<option value="STORE:4">4 苏州</option>
		<option value="STORE:5">5 无锡</option>
		<option value="STORE:6">6 常州</option>
		<option value="STORE:7">7 泰州</option>
		</optgroup>
	  </select>
</div>
   
<div style="margin:60px" id="single">
       <@singleSelect option=selectOption/>
</div>
   
   <div style="margin: 10px;">
		<label class="rct-label">销售指标:</label>
		<select id="slIndexs" data-placeholder="选择显示指标,最多选择8个" style="min-width: 500px;" multiple>
			<option>销售额</option>
			<option>销售量</option>
			<optgroup label="通讯">
			   <option>手机</option>
			   <option>配件</option>
			</optgroup>
			<optgroup label="超市"></optgroup>
			<optgroup label="黑电"></optgroup>					
		</select>
	</div>
	
	<div style="margin: 10px;">
			<label class="rct-label">明细指标:</label>
			<select id="detailsIndexs" data-placeholder="选择显示指标" style="min-width: 500px;" multiple>
				<optgroup label="销售额">
					<option>任务</option>
					<option>销售</option>
					<option>手机</option>
					<option>配件</option>
					<option>完成率</option>
          			</optgroup>
				<optgroup label="主推商品">
					<option>任务</option>
					<option>销售</option>
					<option>完成率</option>
          			</optgroup>
				<optgroup label="毛利">
					<option>毛利额</option>
					<option>毛利率</option>
          			</optgroup>
				<optgroup label="销售量">
					<option>手机</option>
					<option>配件</option>
          			</optgroup>
				<optgroup label="运营商">
					<option>代理用户</option>
					<option>转售用户</option>
          			</optgroup>
			</select>
	</div>
    

 
<script type="text/javascript">
$(function(){
    $('#compArea').chosen({disable_search_threshold: 5});  //disable_search_threshold 当option超过5个时显示查询框，默认一直显示
    $('#slIndexs').chosen({allow_single_deselect: true, max_selected_options: 8});//max_selected_options 当select为多选时，最多选择的个数
	$('#detailsIndexs').chosen({allow_single_deselect: true}); //allow_single_deselect 是否允许取消选择
    
     $('#single select').chosen(); 
})
</script>


</body>
</html>