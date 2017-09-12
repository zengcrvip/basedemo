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

<div class="chart" id="TELCOM_CHART"></div>
<div class="chart-detail">
	<table class="display telcom-table" cellspacing="0" style="width:100%;">
		<thead>
			<tr>
				<th>运营商</th>
				<th>发展数</th>
				<th>占比</th>
				<th>环比</th>
				<th>任务</th>
				<th>完成率</th>
			</tr>
		</thead>
		<tbody>
<#list ["移动", "联通", "电信", "互联"] as item>
			<tr>
				<td>${item}</td>
				<td class="align-right"><@number val=item_index*10 + 120/></td>
				<td class="align-right"><@percent val=item_index*10 + 12/></td>
				<td class="align-right"><@percent val=item_index*10 + 42/></td>
				<td class="align-right"><@number val=item_index*10 + 54/></td>
				<td class="align-right"><@percent val=item_index*10 + 43/></td>
			</tr>
</#list>
		</tbody>
	</table>
</div>
<script language="javascript">
	$.circular('TELCOM_CHART', {title: '用户发展数分布图', name:'用户发展数', series:[{name: '移动', value: 221}, {name: '联通', value: 78}, {name: '电信', value: 123}, {name: '互联', value: 45}]});
	var dotable = $('.telcom-table').DataTable({
		"scrollX": true,
		"scrollY": false,
        "scrollCollapse": false,
		"fixedColumns": {
            leftColumns: 1
        },
        "pageLength" : 5,
		"lengthChange" : false,
		"ordering" : false,
		"language": {
			"url": "/BaseDemo/webstatic/js/lang/dataTables.zh_CN.txt"
	    },
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
    });
    
    $('.telcom .DTFC_LeftWrapper tbody').on('click', 'tr', function(){
        if (!$(this).hasClass('selected')) {
            $('.telcom tbody tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
</script>