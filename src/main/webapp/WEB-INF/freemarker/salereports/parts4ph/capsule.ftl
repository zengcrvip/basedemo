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

<#macro blockrender option={} index=0 hasNext=true>
<div class="swiper-slide block">
	<div class="title">
		<span></span>
		<span>${option["@title"]!}</span>
	</div>
	<div class="detail" data-index="${index}" data-type="${option["@type"]!}">
		<table class="display capsule-table" cellspacing="0" style="width:100%;">
			<thead>
				<tr>
	<#list option.th as item>
					<th>${item["@name"]!}</th>
	</#list>
				</tr>
			</thead>
			<tbody>
<#if index == 0>
<#list [1,2,3,4,5,6,7,8,9,10,11,12,13,14] as index>
				<tr>
	<#list option.th as item>
		<#if item_index gt 0>
			<#if item["@type"]=="money">
					<td class="align-right"><@money val=index*10 + item_index/></td>
			<#elseif item["@type"]=="percent">
					<td class="align-right"><@percent val=index*10 + item_index/></td>
			<#elseif item["@type"]=="number">
					<td class="align-right"><@number val=index*10 + item_index/></td>
			<#else>
					<td>${index*10 + item_index}</td>
			</#if>
		<#else>
			<#if hasNext>
					<td class="fixed-title" title="点击穿透">
						<a href="#" class="rct-href" data-code="100${index}" onclick="drillCapsule(this);">${item["@name"]!}${index}</a>
					</td>
			<#else>
					<td class="fixed-title">${item["@name"]!}${index}</td>
			</#if>
		</#if>
	</#list>
				</tr>
</#list>
</#if>
			</tbody>
		</table>
	</div>
</div>
</#macro>

<div class="swiper-container">
	<div class="swiper-wrapper">
<#list config.capsule.block as item>
	<@blockrender option=item index=item_index hasNext=item_hasNext/>
</#list>
	</div>
    <div class="swiper-pagination"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>
<script language="javascript">
	var dotables = [];

    var swiper = new Swiper('.swiper-container', {
		pagination: '.swiper-pagination',
        slidesPerView: 3,
        paginationClickable: true,
        spaceBetween: 30,
        freeMode: true,
		grabCursor: true,
		nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev'
    });
    
	$.each($('.capsule-table'), function(idx, tab){
		dotables.push($(tab).DataTable({
			"scrollX": true,
			"scrollY": false,
	        "scrollCollapse": false,
			"fixedColumns": {
	            leftColumns: 1
	        },
	        "pageLength" : 10,
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
	    }));
    });
    
    $('.capsule .DTFC_LeftWrapper tbody').on('click', 'tr', function(){
        if (!$(this).hasClass('selected')) {
            $(this).closest('.dataTables_wrapper').find('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    
    /**
    * 销售明细穿透
    */
    function drillCapsule(dom){
    	var index = $(dom).closest('.detail').data('index');
    	var type = $(dom).closest('.detail').data('type');
   		var code = $(dom).data('code');
   		var name = $(dom).text();
   		
   		// 设置穿透表标题
   		$.each($('.capsule .block'), function(idx, blk){
   			if(idx == index + 1){
   				$(blk).find('.title span:nth-child(1)').html('(' + name + ')');
   			}else if(idx > index + 1){
				$(blk).find('.title span:nth-child(1)').html('');
   			}
   		});
   		
   		// 清空下级穿透表
   		$.each(dotables, function(idx, otab){
   			if(idx > index){
   			   	otab.rows().remove();
   			   	otab.draw();
   			}
   		});
   		
   		// AJAX加载数据
   		$.each([1, 2, 3, 4, 5, 6], function(item){
   			if(index + 1 < dotables.length - 1){
	   			var first = '<a href="#" class="rct-href" data-code="'+(index * 100 + item)+'" onclick="drillCapsule(this);">next'+item+'</a>';
	   		   	dotables[index + 1].row.add([first, 123, 343, 54, 233, 43]);
   		   	}else{
   		   		dotables[index + 1].row.add(['next'+item, 123, 343, 54, 233, 43]);
   		   	}
   		});
   		   	
   		dotables[index + 1].draw();
   		
   		$('.capsule .DTFC_LeftWrapper tbody').on('click', 'tr', function(){
        if (!$(this).hasClass('selected')) {
            $(this).closest('.dataTables_wrapper').find('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    }
</script>