<#list notices as item>
<div class="notice">
	<div class="ntitle" title="${item.TITLE}">${item_index+1}. ${item.TITLE}</div>
	<div class="ndate">[${item.DATE}]</div>
	<div style="float: right; margin: 6px 10px;">
	<#if item.STATUS=="N"> 
		<a href="javascript:clickNotice(${item_index});void(0);" class="nstatus unread">未阅读↓</a>
	<#else> 
		<a href="javascript:clickNotice(${item_index});void(0);" class="nstatus readed">已阅读↓</a></#if>
	</div>
	<div class="ncontent">${item.CONTENT}</div>
</div>
</#list>
<script type="text/javascript">
	/**
	 * 阅读公告
	 * @param idx
	 */
	function clickNotice(idx){
		if($(".ncontent").eq(idx).is(":hidden")){
			$(".ncontent").eq(idx).show();
			$(".ncontent").eq(idx).data('readed', true);
			$(".nstatus").eq(idx).removeClass('unread').addClass('readed');
			$(".nstatus").eq(idx).html('已阅读↑');
		}else{
			$(".ncontent").eq(idx).hide();
			$(".nstatus").eq(idx).html('已阅读↓');
		}
	}
</script>
