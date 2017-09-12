<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>table data download demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/webstatic/js/mbmUtils.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	 .bi-table-fix{position:relative;width:100%;margin-top:15px;overflow:hidden;}
	 .bi-table-header{
		width:100%;
		background:-webkit-linear-gradient(top,#f0f0f0 0,#e5e5e5 100%);
		background:-moz-linear-gradient(top,#f0f0f0 0,#e5e5e5 100%);
		background:-o-linear-gradient(top,#f0f0f0 0,#e5e5e5 100%);
		background:linear-gradient(to bottom,#f0f0f0 0,#e5e5e5 100%);
		filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#f0f0f0,endColorstr=#e5e5e5,GradientType=0);
	}
	 .bi-table-header .tops th{height:0px!important;line-height:0;border-bottom:0 none!important;}
     .bi-table-header{border:1px solid #bbb;border-bottom:0 none;border-radius:5px 5px 0 0;overflow:hidden;font-size:12px;}
     .bi-table-header th{padding:0 10px;font-family:Simsun!important;border-right:1px solid #bbb;border-bottom:1px solid #bbb;height:20px;line-height:18px;}
	
	.bi-table-body{width:100%;border:1px solid #dedede;border-top-color:#f8f8f8;overflow:auto;}
	.bi-table-body .bi-table-body-con{overflow:hidden;}
	.bi-table-body td{padding:3px 10px;line-height:16px;border-bottom:1px dotted #dedede;border-right:1px solid #dedede;font-family:Arial,simsun;font-size:12px;text-align: right;}
	.bi-table-body .left-data-head{text-align: left;}
	
	
	 
	</style>

  </head>
  
  <body>
    This is table data download demo<br>
    <div>
       <table border="1" style="border-collapse: collapse" >
         <tr>
            <th>姓名</th>
            <th>年龄</th>
         </tr>
         <tr>
            <td>张三</td>
            <td>20</td>
         </tr>
         <tr>
            <td>李四</td>
            <td>30</td>
         </tr>
       </table>
    </div>
    
    <!--报表头，第一行为空行可以给定初始化宽度-->
		<div class="bi-table-fix">
			<div class="bi-table-header">
				<table width="100%" cellpadding="0" cellspacing="0" id="head_tableId">
				    <tr class="tops">
						<th width="50"></th>
						<th width="50"></th>
						
					</tr>
					<tr >
					    <th   rowspan="2">品牌</th>
					    <th   colspan="2">整体实货</th>
					  </tr>
					  <tr >
					    <th   colspan="1">库存数量</th>
					    <th   colspan="1">库存金额</th>
					    
					  </tr>
					  
				</table>
			</div>
		</div>
		<!--报表头结束-->
    <!--报表体，第一行给定初始化宽度-->
		<div class="bi-table-body">
			<div class="bi-table-body-con">
				<table width="100%" id="data_tableId">
					<tbody id="id_tabTbodyList">
					<tr>
					   <td>1</td><td>2</td><td>3</td>
					</tr>
					<tr>
					   <td>q</td><td>f</td><td>r</td>
					</tr>
					<tr>
					   <td>a</td><td>s</td><td>d</td>
					</tr>
				     </tbody>
				</table>
			</div>
		</div>
    
    <input type="button" value="导出一" id="submit">
    <br/><br/>
    <input type="button" value="导出二" id="submit2">
    <br/><br/>
    <input type="button" value="导出三" id="submit3">
  
<script type="text/javascript">
$(function(){
   $("#submit").click(function(){
       exportData("${base}/tableDownDemo/getDataDown.htm",getParams());
   });
   
   $("#submit2").click(function(){
       exportData("${base}/tableDownDemo/getDataDown2.htm",getParams());
   });
   
   $("#submit3").click(function(){
       _exportExcel();
   });
   
 
function getParams(){
  var paramList = [["queryDate","20160330"],["name","张三"]];
  return paramList;
}
         
//导出数据,方式一
function exportData(url,params) 
{
	var tempForm = document.createElement("form"); 
    tempForm.id="tempForm"; 
    tempForm.method="POST"; 
    tempForm.action=url; 
    
    $.each(params, function(idx, value){
        input = document.createElement("input"); 
        input.type="hidden";
        input.name= value[0];
        input.value= value[1];
        tempForm.appendChild(input);
    });
    document.body.appendChild(tempForm); 
    tempForm.submit();
    document.body.removeChild(tempForm);
};

var _exportExcel = function() {
			$.mbmUtils.exportExcel({
				headTableId:'head_tableId',
				dataTableId:'data_tableId',
				title : {
					text : 'demo3',
					colSpan : 3
				},
				smallTitles:[
							 '日期：2016-03-30',
							 '单位：数量（台），金额（万元）'
							]
			});
		};

})
      
</script>
  
    
  </body>

</html>
