<table id="DETAILS_TABLE" class="display" cellspacing="0">
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
		<tr>
			<td>商品1</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343</td>
		</tr>
		<tr>
			<td>商品2</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343</td>
		</tr>
		<tr>
			<td>商品3</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343</td>
		</tr>
				<tr>
			<td>商品3</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343</td>
		</tr>
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
			"url": "/pmc-pc-web/webstatic/js/lang/dataTables.zh_CN.txt"
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