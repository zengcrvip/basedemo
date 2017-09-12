<#--测试数据-->
<#assign details=[
	{"brand": "测试品牌1", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌2", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌3", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌4", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌5", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌6", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌7", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌8", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌9", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌10", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌11", "goodsModel": "测试型号1", "isMainPush": "是", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"},
	{"brand": "测试品牌12", "goodsModel": "测试型号2", "isMainPush": "否", "profit": "1233", "profitRate": "54%", "saleAmount": "238328", "saleNumber": "8000", "goodsTypeName": "PHONE"}
]>

<table id="DETAILS_TABLE" class="display" cellspacing="0" style="width:100%;">
	<thead>
		<tr>
			<th rowspan="2">品牌</th>
			<th rowspan="2">型号</th>
			<th rowspan="2">是否主推</th>
			<th colspan="2">毛利额</th>
			<th colspan="2">销售额</th>
		</tr>
		<tr>
			<th>毛利额</th>
			<th>毛利率</th>
			<th>销售额</th>
			<th>销售量</th>
		</tr>
	</thead>
	<tbody>
<#list details as item>
		<tr>
			<td>${item.brand!}</td>
			<td>${item.goodsModel!}</td>
			<td>${item.isMainPush!}</td>
			<td>${item.profit!"--"}</td>
			<td>${item.profitRate!"--"}</td>
			<td>${item.saleAmount!"--"}</td>
			<td>${item.saleNumber!"--"}</td>
		</tr>
</#list>
	</tbody>
</table>
<script language="javascript">
	var otable = $('#DETAILS_TABLE').DataTable({
		"scrollX": false,
		"scrollY": 235,
        "scrollCollapse": true,
		"pageLength" : 10,
		"lengthChange" : false,
		"ordering" : false,
		"language": {
			"url": "/BaseDemo/webstatic/js/lang/dataTables.zh_CN.txt"
	    },
        "dom": 'Bfrtip',
	    "buttons": [
		    {
		        extend: 'print',
		        text: '打印'
		    }
	    ]
    });
</script>