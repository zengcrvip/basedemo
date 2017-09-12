<table id="${orgType}_${isDrill?string('DRILL','DETAILS')}_TABLE" class="display" cellspacing="0" style="width:${isDrill?string('140%;','100%;')}">
	<thead>
		<tr>
			<th rowspan="2">
				<#if isDrill && orgType=="store"><a id="DRILL_BACK" href="#" title="点击返回大区销售明细" class="rct-href">返回 | </a></#if>
				<#if orgType="store">员工/总计<#elseif orgType="area">门店/总计<#elseif orgType="head">大区/总计</#if>
			</th>
			<th colspan="3">销售额</th>
			<th colspan="3">销售量</th>
			<th colspan="2">毛利额</th>
			<th colspan="3">主推商品</th>
			<th colspan="2">运营商</th>
		</tr>
		<tr>
			<th>任务</th>
			<th>完成</th>
			<th>完成率</th>
			<th>总计</th>
			<th>手机</th>
			<th>配件</th>
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
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">徐州</a>	
	<#else>
			徐州
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">徐州</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
		<tr>
			<td>
<#if isDrill>
	<#if orgType=="area">
			<a href="javascript:toLoadStore('id', 'name');void(0);" class="rct-href">南京</a>	
	<#else>
			南京
	</#if>
<#else>
			<a href="javascript:toDetailsDialog('${orgType}', 'id', 'name');void(0);" class="rct-href">南京</a>
</#if>
			</td>
			<td>13213</td>
			<td>23423</td>
			<td>61</td>
			<td>23</td>
			<td>2343</td>
			<td>2343e</td>
			<td>23423</td>
			<td>2343</td>
			<td>61</td>
			<td>534</td>
			<td>5434</td>
			<td>53443</td>
			<td>5455</td>
		</tr>
	</tbody>
</table>
<script language="javascript">
<#if isDrill>
	<#if orgType=="area">
	function toLoadStore(storeId, storeName){
		dotable.destroy();
		$('#DRILL_DLG').data('areaDetails', $('#DRILL_DLG .dialog-panel').html());
		$('#DRILL_DLG .dialog-panel').empty();
		// 加载门店销售
		savedParams.storeId = storeId;
		$('#DRILL_DLG').block(maskOption);
		$('#DRILL_DLG .dialog-panel').load(report.drillUrl1, savedParams, function(){
			$('#DRILL_DLG').unblock();
		});
	}
	<#elseif orgType=="store">
	if(report.drillUrl1 != null){
		$('#DRILL_BACK').click(function(){
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
			"url": "/pmc-pc-web/webstatic/js/lang/dataTables.zh_CN.txt"
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