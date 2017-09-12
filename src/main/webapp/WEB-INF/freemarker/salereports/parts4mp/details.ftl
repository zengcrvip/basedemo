<#--测试数据-->
<#assign total={"orgCode": "10000", "orgName": "总计", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"}>
<#if orgType=="store">
	<#assign details=[
		{"orgCode": "10001", "orgName": "员工1", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10002", "orgName": "员工2", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10003", "orgName": "员工3", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10004", "orgName": "员工4", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10005", "orgName": "员工5", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10006", "orgName": "员工6", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10007", "orgName": "员工7", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"}
	]>
<#else>
	<#assign details=[
		{"orgCode": "10001", "orgName": "组织名称1", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10002", "orgName": "组织名称2", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10003", "orgName": "组织名称3", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10004", "orgName": "组织名称4", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10005", "orgName": "组织名称5", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10006", "orgName": "组织名称6", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10007", "orgName": "组织名称7", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10001", "orgName": "组织名称8", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10002", "orgName": "组织名称9", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10003", "orgName": "组织名称10", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10004", "orgName": "组织名称11", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10005", "orgName": "组织名称12", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10006", "orgName": "组织名称13", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"},
		{"orgCode": "10007", "orgName": "组织名称14", "saleTask": "123", "saleAmount": "456", "saleRate": "34%", "mainPushTask": "32423", "mainPushSale": "3443", "mainPushRate": "234%", "totalSaleNumber": "24233", "profitSale": "433", "profitRate": "87%"}
	]>
</#if>

<table id="${orgType}_${isDrill?string('DRILL','DETAILS')}_TABLE" class="display" cellspacing="0" style="width:${isDrill?string('140%;','100%;')}">
	<thead>
		<tr>
			<th rowspan="2">
				<#if isDrill && orgType=="store"><a id="DRILL_BACK" href="#" title="点击返回大区销售明细" class="rct-href">返回 | </a></#if>
				<#if orgType="store">员工/总计<#elseif orgType="area">门店/总计<#elseif orgType="head">大区/总计</#if>
			</th>
			<th colspan="3">销售额</th>
			<th colspan="2">销售量</th>
			<th colspan="2">毛利额</th>
			<th colspan="3">主推商品</th>
			<th colspan="2">运营商</th>
		</tr>
		<tr>
			<th>任务</th>
			<th>完成</th>
			<th>完成率</th>
			<th>完成</th>
			<th>手机</th>
			<th>毛利额</th>
			<th>毛利率</th>
			<th>任务</th>
			<th>完成</th>
			<th>完成率</th>
			<th>转售用户</th>
			<th>代理用户</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>总计</td>
			<td>${total.saleTask!"--"}</td>
			<td>${total.saleAmount!"--"}</td>
			<td>${total.saleRate!"--"}</td>
			<td>${total.totalSaleNumber!"--"}</td>
			<td>--</td>
			<td>${total.profitSale!"--"}</td>
			<td>${total.profitRate!"--"}</td>
			<td>${total.mainPushTask!"--"}</td>
			<td>${total.mainPushSale!"--"}</td>
			<td>${total.mainPushRate!"--"}</td>
			<td>--</td>
			<td>--</td>
		</tr>
<#list details as item>
		<tr>
			<td>
	<#if isDrill>
		<#if orgType=="area">
			<a href="javascript:toLoadStore('${item.orgCode!}', '${item.orgName!}');void(0);" class="rct-href">${item.orgName!}</a>	
		<#else>
			${item.orgName!}
		</#if>
	<#else>
			<a href="javascript:toDetailsDialog('${orgType}', '${item.orgCode!}', '${item.orgName!}');void(0);" class="rct-href">${item.orgName!}</a>
	</#if>
			</td>
			<td>${total.saleTask!"--"}</td>
			<td>${total.saleAmount!"--"}</td>
			<td>${total.saleRate!"--"}</td>
			<td>${total.totalSaleNumber!"--"}</td>
			<td>--</td>
			<td>${total.profitSale!"--"}</td>
			<td>${total.profitRate!"--"}</td>
			<td>${total.mainPushTask!"--"}</td>
			<td>${total.mainPushSale!"--"}</td>
			<td>${total.mainPushRate!"--"}</td>
			<td>--</td>
			<td>--</td>
		</tr>
</#list>
	</tbody>
</table>
<script language="javascript">
<#if isDrill>
	<#if orgType=="area">
	function toLoadStore(storeId, storeName){
		dotable.destroy();
		$('#DRILL_DLG').data('title', $('#DRILL_DLG').find('.rct-modal-header div').text());
		$('#DRILL_DLG').data('areaDetails', $('#DRILL_DLG .dialog-panel').html());
		$('#DRILL_DLG .dialog-panel').empty();
		// 加载门店销售
		savedParams.storeId = storeId;
		$('#DRILL_DLG').block(maskOption);
		$('#DRILL_DLG .dialog-panel').load(report.drillUrl1, savedParams, function(){
			$('#DRILL_DLG').unblock();
			var title = $('#DRILL_DLG').data('title');
			$('#DRILL_DLG').find('.rct-modal-header div').html(title + " - " + storeName);
		});
	}
	<#elseif orgType=="store">	
	if(report.drillUrl1 != null){
		$('#DRILL_BACK').click(function(){
			var title = $('#DRILL_DLG').data('title');
			$('#DRILL_DLG').find('.rct-modal-header div').html(title);
			var areaDetails = $('#DRILL_DLG').data('areaDetails');
			$('#DRILL_DLG .dialog-panel').html(areaDetails);
		});
	}else{
		$('#DRILL_BACK').hide();
	}
	</#if>
</#if>
	var dotable = $('#${orgType}_${isDrill?string('DRILL','DETAILS')}_TABLE').DataTable({
<#if isDrill>
		"scrollX": true,
		"scrollY": 235,
        "scrollCollapse": true,
		"fixedColumns": {
            leftColumns: 1
        },
</#if>
		"pageLength" : 10,
		"lengthChange" : false,
		"ordering" : false,
		"language": {
			"url": "/BaseDemo/webstatic/js/lang/dataTables.zh_CN.txt"
	    }
<#if isDrill==false>
        ,
		"dom": 'Bfrtip',
	    "buttons": [
	    	{
	            extend: 'collection',
	            text: '保存',
	            buttons: [
	                'excel',
					{
                		text: 'JSON',
                		action: function ( e, dt, button, config ) {
                    		var data = dt.buttons.exportData();
                    		$.fn.dataTable.fileSave(
		                        new Blob( [ JSON.stringify( data ) ] ),
		                        'Export.json'
		                	);
                		}
            		}
	            ]
	        }, 
		    {
		        extend: 'print',
		        text: '打印'
		    }
	    ]
</#if>
    });
</script>