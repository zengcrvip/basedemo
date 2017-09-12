<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta content="telephone=no" name="format-detection" />
	<title>公共组件</title>
	<link rel="stylesheet" href="${base}/webstatic/css/commonDemo.css">
	<script type="text/javascript" src="${base}/webstatic/js/zepto.min.js"></script>
</head>
<body style="padding-bottom:2.2rem;">

<!-- 公用头部导航 -->
<div class="sn-block" style="background:#272822;height:1.76rem;line-height:1.76rem;font-size:.6rem;">
	<div class="sn-title tc bold">
		<div class="sn-nav-title of sn-txt-positive" style="color:#fff;">3.0 公用组件</div>
	</div>
</div>


<!-- <p class="info">下载客户端浮层上</p> -->
<p class="info">下载客户端浮层上</p>
<div  class="sn-client-t detail-fixed">
    <i class="del-ete a-dd-cl-ose01"></i>
    <div class="sn-client-div">
        <p id="cBlue">下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端</p>
    </div>
    <a href="#" class="sn-client-a sn-client-top a-dds-btn01">去下载</a>
</div>
<xmp>
    <div  class="sn-client-t">
        <i class="del-ete"></i>
        <div class="sn-client-div">
            <p>下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端</p>
        </div>
        <a href="#" class="sn-client-a sn-client-top">去下载</a>
    </div>
</xmp>
<!-- <p class="info">通用导航</p> -->
<p class="info">通用导航</p>
<div class="sn-nav sn-block">
	<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
	<div class="sn-nav-title of">导航标题</div>
</div>
<xmp>
	<div class="sn-nav">
		<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
		<div class="sn-nav-title of">导航标题</div>
	</div>
</xmp>

<!-- <p class="info">通用导航右边有内容</p> -->
<p class="info">通用导航右边有内容</p>
<div class="sn-nav sn-block">
	<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
	<div class="sn-nav-title of">导航标题</div>
	<div class="sn-nav-right tr pr">
		<a href="#" style="right:auto;margin-right:.2rem;">编辑</a>
		<img onclick="$('#sub-title').toggle();$('#screenIfmNav').toggle();" src="http://sale.suning.com/images/advertise/cdn/images/more.png" style="width:1rem;">
		<ul class="nav-more-list" id="sub-title">
			<li><a class="nav-more-icon home-icon" href="#">首页</a></li>
			<li><a class="nav-more-icon cart-icon" href="#">购物车</a></li>
			<li><a class="nav-more-icon search-icon" href="#">全部分类</a></li>
			<li><a class="nav-more-icon cate-icon" href="#">搜索</a></li>
			<li><a class="nav-more-icon ebuy-icon" href="#">我的易购</a></li>
		</ul>
	</div>
	<div id="screenIfmNav" class="screenIfm" onclick="$('#sub-title').toggle();$(this).hide();" style="opacity:0;"></div>
</div>
<xmp>
	<div class="sn-nav sn-block">
		<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
		<div class="sn-nav-title of">导航标题</div>
		<div class="sn-nav-right tr pr">
			<a href="#">编辑</a>
			<img onclick="$('#sub-title').toggle();$('#screenIfmNav').toggle();" src="http://sale.suning.com/images/advertise/cdn/images/more.png" style="width:1rem;">
			<ul class="nav-more-list" id="sub-title">
				<li><a class="nav-more-icon home-icon" href="#">首页</a></li>
				<li><a class="nav-more-icon cart-icon" href="#">购物车</a></li>
				<li><a class="nav-more-icon search-icon" href="#">全部分类</a></li>
				<li><a class="nav-more-icon cate-icon" href="#">搜索</a></li>
				<li><a class="nav-more-icon ebuy-icon" href="#">我的易购</a></li>
			</ul>
		</div>
		<div id="screenIfmNav" class="screenIfm" onclick="$('#sub-title').toggle();$(this).hide();" style="opacity:0;"></div>
	</div>
</xmp>

<!-- <p class="info">通用导航右边有内容</p> -->
<p class="info">通用导航右边有内容</p>
<div class="sn-nav sn-block">
	<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
	<div class="sn-nav-title of">导航标题</div>
	<div class="sn-nav-right">
		<a href="#">右边</a>
	</div>
</div>
<xmp>
	<div class="sn-nav">
		<div class="sn-nav-back"><a class="sn-iconbtn" href="#">返回</a></div>
		<div class="sn-nav-title of">导航标题</div>
		<div class="sn-nav-right">
			<a href="#">右边</a>
		</div>
	</div>
</xmp>

<!-- <p class="info">loading效果</p> -->
<p class="info">loading效果</p>
<div class="sn-html5-loading"><div class="blueball"></div><div class="orangeball"></div></div>
<p class="info">整体loading</p>
<div class="sn-mask-loading"></div>
<p class="info">局部loading</p>
<div class="sn-local-loading"><span class="shape"></span><span>努力加载中...</span></div>
<xmp>
	<div class="sn-html5-loading"><div class="blueball"></div><div class="orangeball"></div></div>
	<div class="sn-mask-loading"></div>
</xmp>



<!-- <p class="info">通用选项卡</p> -->
<p class="info">通用选项卡和城市选择基础样式</p>
<div class="sn-tab">
	<ul class="sn-tab-nav wbox">
	    <li class="current">江苏省</li>
	    <li>南京市</li>
	    <li>玄武区</li>
	    <li class="disabled">街道/乡</li>
	</ul>

	<div class="sn-tab-content wbox">
		<div class="sn-tab-box wbox-flex">
			<ul class="city-list">
				<li class="cur">江苏省</li>
				<li>浙江省</li>
				<li>安徽省</li>
				<li>上海市</li>
			</ul>
		</div>
		<div class="sn-tab-box wbox-flex">
			<ul class="city-list">
				<li class="cur">南京市</li>
				<li>徐州市</li>
				<li>苏州市</li>
				<li>常州市</li>
			</ul>
		</div>
		<div class="sn-tab-box wbox-flex">
			<ul class="city-list">
				<li class="cur">玄武区</li>
				<li>栖霞区</li>
				<li>安徽省</li>
				<li>上海市</li>
			</ul>
		</div>
		<div class="sn-tab-box wbox-flex">
			<ul class="city-list">
				<li class="cur">金马路</li>
				<li>银马路</li>
				<li>铜马路</li>
				<li>神马路</li>
				<li>神马路</li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
// 下面代码只描述了基本思路，具体细节需要根据需求定制
// 城市选择跳转可以 li.eq(next).trigger("click");
	$(".sn-tab-content").width($(".sn-tab-nav").find("li").length * 100 + "%");

	$(".sn-tab-nav").find("li").on("click", function(){
		var index = $(this).index();
		$(this).addClass("current").siblings().removeClass("current");
		var width = $(".sn-tab-content").find(".sn-tab-box").width();
		$(".sn-tab-content").css({
			"-webkit-transform": "translate(" + (-width*index) + "px, 0px) translateZ(0px)"
		})
	});
</script>
<xmp>
	<div class="sn-tab">
		<ul class="sn-tab-nav wbox">
		    <li class="current">江苏省</li>
		    <li>南京市</li>
		    <li>玄武区</li>
		    <li class="disabled">街道/乡</li>
		</ul>
		<div class="sn-tab-content wbox">
			<div class="sn-tab-box wbox-flex">
				<ul class="city-list">
					<li class="cur">江苏省</li>
					<li>浙江省</li>
					<li>安徽省</li>
					<li>上海市</li>
				</ul>
			</div>
			<div class="sn-tab-box wbox-flex">
				<ul class="city-list">
					<li class="cur">南京市</li>
					<li>徐州市</li>
					<li>苏州市</li>
					<li>常州市</li>
				</ul>
			</div>
			<div class="sn-tab-box wbox-flex">
				<ul class="city-list">
					<li class="cur">玄武区</li>
					<li>栖霞区</li>
					<li>安徽省</li>
					<li>上海市</li>
				</ul>
			</div>
			<div class="sn-tab-box wbox-flex">
				<ul class="city-list">
					<li class="cur">金马路</li>
					<li>银马路</li>
					<li>铜马路</li>
					<li>神马路</li>
					<li>神马路</li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	// 下面代码只描述了基本思路，具体细节需要根据需求定制
	// 城市选择跳转可以 li.eq(next).trigger("click");
		$(".sn-tab-content").width($(".sn-tab-nav").find("li").length * 100 + "%");

		$(".sn-tab-nav").find("li").on("click", function(){
			var index = $(this).index();
			$(this).addClass("current").siblings().removeClass("current");
			var width = $(".sn-tab-content").find(".sn-tab-box").width();
			$(".sn-tab-content").css({
				"-webkit-transform": "translate(" + (-width*index) + "px, 0px) translateZ(0px)"
			})
		});
	</script>
</xmp>

<!-- <p class="info">通栏标题</p> -->
<p class="info">通栏标题</p>
<div class="sn-block pr">
	<div class="sn-title border-tb wbox">
		<div class="wbox-flex">
			<p class="of">苏宁自营</p>
		</div>
	</div>
</div>
<xmp>
	<div class="sn-block">
		<div class="sn-title border-tb wbox">
			<div class="wbox-flex" >
				<p class="of">苏宁自营</p>
			</div>
		</div>
	</div>
</xmp>
<!-- <p class="info">通栏标题右边</p> -->
<p class="info">通栏标题右边</p>
<div class="sn-block pr">
	<div class="sn-title border-tb wbox">
		<div class="wbox-flex">
			<p class="of">订单号：1234567890</p>
		</div>
		<div class="title-right"><span class="f12 sn-txt-muted fhalf">实付款</span><span>￥99999.99</span></div>
	</div>
</div>
<xmp>
	<div class="sn-block">
		<div class="sn-title border-tb wbox">
			<div class="wbox-flex">
				<p class="of">订单号：1234567890</p>
			</div>
			<div class="title-right"><span class="f12 sn-txt-muted fhalf">实付款</span><span>￥99999.99</span></div>
		</div>
	</div>
</xmp>

<!-- <p class="info">虚线分割线</p> -->
<p class="info">虚线分割线</p>
<div class="dashed"></div>
<xmp>
	<div class="dashed"></div>
</xmp>

<!-- <p class="info">自适应高度链接</p> -->
<p class="info">自适应高度链接</p>
<div class="sn-block sn-list-div mt10">
	<a href="#">易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付</a>
</div>
<xmp>
	<div class="sn-block sn-list-div mt10">
		<a href="#">易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付</a>
	</div>
</xmp>

<!-- <p class="info">固定最大宽度</p> -->
<p class="info">固定最大宽度</p>
<div class="sn-block sn-title mt10 w">
	固定最大宽度
</div>
<xmp>
	<div class="sn-block sn-title mt10 w">
		固定最大宽度
	</div>
</xmp>

<!-- <p class="info">分隔的 input</p> -->
<p class="info">分隔的 input</p>
<div class="sn-block sn-title wbox mt10">
	<p>发票抬头：</p>
	<div class="wbox-flex">
		<input class="sn-input-text-a" type="text" placeholder="张三">
	</div>
	<div class="clo-se-input"></div>
</div>
<div class="sn-block sn-title wbox mt10">
	<p>发票抬头：</p>
	<div class="wbox-flex">
		<input class="sn-input input-reset" type="text" placeholder="张三">
	</div>
</div>
<div class="sn-block pdlayout sn-txt-tips">注：非苏宁自营商品的发票</div>
<xmp>
	<div class="sn-block sn-title wbox mt10">
		<p>发票抬头：</p>
		<div class="wbox-flex">
			<input class="sn-input-text-a" type="text" placeholder="张三">
		</div>
		<div class="clo-se-input"></div>
	</div>
	<div class="sn-block sn-title wbox mt10">
		<p>发票抬头：</p>
		<div class="wbox-flex">
			<input class="sn-input input-reset" type="text" placeholder="张三">
		</div>
	</div>
	<div class="sn-block pdlayout sn-txt-tips">注：非苏宁自营商品的发票</div>
</xmp>

<!-- <p class="info">表单列表</p> -->
<p class="info">表单列表</p>
<div class="sn-block mt10">
	<ul class="sn-list-input">
		<li>
			<label class="input-text">发票抬头：</label>
			<div class="wbox-flex sn-input-box">
				<input class="sn-input input-reset" type="text" placeholder="张三">
			</div>
		</li>
		<li>
			<label>发票抬头：</label>
			<div class="wbox-flex">
				易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付
			</div>
		</li>
		<li>
			<label>支付方式：</label>
			<div class="wbox-flex">
				<label for="#" class="sn-switch">
		            <input type="checkbox" checked="true" class="checkbox-switch">
		        </label>
			</div>
		</li>
		<li>
			<label>支付方式：</label>
			<div class="wbox-flex tr">
				<a href="#" class="block sn-txt-muted arrow">网上支付 </a>
			</div>
		</li>
		<li>
			<label>支付方式：</label>
			<div class="wbox-flex tr">
				<div class="sn-select">
					<select class="sn-select">
						<option value="1">网上支付</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
			</div>
		</li>
	</ul>
</div>
<xmp>
	<div class="sn-block mt10">
		<ul class="sn-list-input">
			<li>
				<label class="input-text">发票抬头：</label>
				<div class="wbox-flex sn-input-box">
					<input class="sn-input input-reset" type="text" placeholder="张三">
				</div>
			</li>
			<li>
				<label>发票抬头：</label>
				<div class="wbox-flex">
					易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付易付宝在线支付
				</div>
			</li>
			<li>
				<label>支付方式：</label>
				<div class="wbox-flex">
					<label for="#" class="sn-switch">
			            <input type="checkbox" checked="true" class="checkbox-switch">
			        </label>
				</div>
			</li>
			<li>
				<label>支付方式：</label>
				<div class="wbox-flex tr">
					<a href="#" class="block sn-txt-muted arrow">网上支付 </a>
				</div>
			</li>
			<li>
				<label>支付方式：</label>
				<div class="wbox-flex tr">
					<div class="sn-select">
						<select class="sn-select">
							<option value="1">网上支付</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
				</div>
			</li>
		</ul>
	</div>
</xmp>

<!-- <p class="info">展示列表</p> -->
<p class="info">展示列表</p>
<ul class="sn-list-common sn-block">
	<li>
		<div class="wbox-flex">
			<a class="pro-list" href="#">
				<div class="wbox">
					<div class="pro-img"><img src="http://image1.suning.cn/content/catentries/00000000010443/000000000104430622/000000000104430622_ls.jpg" alt=""></div>
					<div class="pro-info wbox-flex">
						<div class="pro-name">苹果 手机 iPhone5S (16GB) (金)移动版苹果首款 4G移动版手机，支持TD-LTE 4G网络，带你全速进入4G时代！完美机身，引领潮流！苏宁同步首发！！！</div>
						<div class="snPrice">&yen;4899.00</div>
					</div>
				</div>
			</a>
		</div>
	</li>
	<li>
		<div class="wbox-flex">
			<div class="wbox pro-list">
				<div class="pro-img"><img src="http://image1.suning.cn/content/catentries/00000000010443/000000000104430622/000000000104430622_ls.jpg" alt=""></div>
				<div class="pro-info wbox-flex">
					<div class="pro-name">苹果 手机 iPhone5S (16GB) (金)移动版苹果首款 4G移动版手机，支持TD-LTE 4G网络，带你全速进入4G时代！完美机身，引领潮流！苏宁同步首发！！！</div>
					<div class="snPrice">&yen;4899.00</div>
					<div class="list-opra sn-txt-muted">数量：12</div>
				</div>
			</div>
		</div>
	</li>
</ul>
<xmp>
	<ul class="sn-list-common sn-block">
		<li>
			<div class="wbox-flex">
				<a class="pro-list" href="#">
					<div class="wbox">
						<div class="pro-img"><img src="http://image1.suning.cn/content/catentries/00000000010443/000000000104430622/000000000104430622_ls.jpg" alt=""></div>
						<div class="pro-info wbox-flex">
							<div class="pro-name">苹果 手机 iPhone5S (16GB) (金)移动版苹果首款 4G移动版手机，支持TD-LTE 4G网络，带你全速进入4G时代！完美机身，引领潮流！苏宁同步首发！！！</div>
							<div class="snPrice">&yen;4899.00</div>
						</div>
					</div>
				</a>
			</div>
		</li>
		<li>
			<div class="wbox-flex">
				<div class="wbox pro-list">
					<div class="pro-img"><img src="http://image1.suning.cn/content/catentries/00000000010443/000000000104430622/000000000104430622_ls.jpg" alt=""></div>
					<div class="pro-info wbox-flex">
						<div class="pro-name">苹果 手机 iPhone5S (16GB) (金)移动版苹果首款 4G移动版手机，支持TD-LTE 4G网络，带你全速进入4G时代！完美机身，引领潮流！苏宁同步首发！！！</div>
						<div class="snPrice">&yen;4899.00</div>
						<div class="list-opra sn-txt-muted">数量：12</div>
					</div>
				</div>
			</div>
		</li>
	</ul>
</xmp>

<!-- 横向滚动 -->
<p class="info">横向滚动</p>
<div class="app-scroller" style="height:6rem">
	<div class="app-scroller-wp" >
		<ul>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			<li>
				<div style="width:5rem" >
					<img src="http://image1.suning.cn/uimg/MTS/Prodisplay/143064047646883674.jpg" alt="" >
				</div>
			</li>
			
		</ul>
	</div>
</div>
<script src="http://res.m.suning.com/common/script/module/iscroll-lite/5.1.3/iscroll-lite.js"></script>
<script>
$('.app-scroller').each(function(){
	//注意：初始化之前 <li> 下面的容器要有宽度 不然不能滑动
	new IScroll(this, {
		scrollX: true,
		scrollY: false,
		click: true,
		eventPassthrough: true
	});
});
</script>

<!-- <p class="info">边框</p> -->
<p class="info">边框</p>
<div class="pr">
	<div class="sn-title sn-block mt10 border-t">上边框 .border-t</div>
	<div class="sn-title sn-block mt10 border-b">下边框 .border-b</div>
	<div class="sn-title sn-block mt10 border-tb">上下边框 .border-tb</div>
</div>
	
<xmp>
	<div class="sn-title sn-block mt10 border-t">上边框 .border-t</div>
	<div class="sn-title sn-block mt10 border-b">下边框 .border-b</div>
	<div class="sn-title sn-block mt10 border-tb">上下边框 .border-tb</div>
</xmp>

<!-- <p class="info">类型选中checkbox版</p> -->
<p class="info">类型选中checkbox版</p>
<div class="sn-block pdlayout">
	<div class="type-choose fix">
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" type="radio" checked>
			<span class="value">飞利浦</span>
		</label>
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" type="radio">
			<span class="value">三星手机</span>
		</label>
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" type="radio">
			<span class="value">尾单/点单</span>
		</label>
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" type="radio">
			<span class="value">标签</span>
		</label>
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" type="radio">
			<span class="value">标签</span>
		</label>
		<label class="choose">
			<input name="typechoose1" class="input-reset sn-input-radio-filter" disabled="true" type="radio">
			<span class="value">不可点击</span>
		</label>
	</div>
</div>

<!-- <p class="info">数字微调</p> -->
<p class="info">数字微调</p>
<div class="sn-count">
	<a href="javascript:void(0);" class="count-min"></a>
	<input type="tel" value="1" class="input-reset count-num" />
	<a href="javascript:void(0);" class="count-add"></a>
</div>
<xmp>
	<div class="sn-count">
		<a href="javascript:void(0);" class="count-min"></a>
		<input type="tel" value="1" class="input-reset count-num" />
		<a href="javascript:void(0);" class="count-add"></a>
	</div>
</xmp>

<!-- <p class="info">checkbox</p> -->
<p class="info">checkbox</p>
<div class="sn-block pdlayout">
	<input type="checkbox" class="input-reset sn-checkbox" checked="checked">
	<input type="checkbox" class="input-reset sn-checkbox">
</div>
<xmp>
	<div class="sn-block pdlayout">
		<input type="checkbox" class="input-reset sn-checkbox" checked="checked">
		<input type="checkbox" class="input-reset sn-checkbox">
	</div>
</xmp>

<!-- <p class="info">radio</p> -->
<p class="info">radio</p>
<div class="sn-block pdlayout">
	<input type="radio" name="cradio" class="input-reset sn-radio" checked="checked">
	<input type="radio" name="cradio" class="input-reset sn-radio">
</div>
<xmp>
	<div class="sn-block pdlayout">
		<input type="radio" class="input-reset sn-radio" checked="checked">
		<input type="radio" class="input-reset sn-radio">
	</div>
</xmp>


<!-- <p class="info">送货状态</p> -->
<p class="info">送货状态</p>
<div class="arrive-state">
	<div class="state on a3 sn-txt-positive">
		<span class="icon"></span>
		<p>您的商品已到达北京中心仓！</p>
        <p class="">2013-10-28  07:25</p>
    </div>
	<div class="state gray">
		<span class="icon"></span>
		<p>您的商品已到达北京中心仓！</p>
        <p class="">2013-10-28  07:25</p>
	</div>
	<div class="state gray">
		<span class="icon"></span>
		<p>您的商品已到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓！</p>
        <p class="">2013-10-28  07:25</p>
	</div>
</div>

<xmp>
	<div class="arrive-state">
		<div class="state on a3 sn-txt-positive">
			<span class="icon"></span>
			<p>您的商品已到达北京中心仓！</p>
	        <p class="">2013-10-28  07:25</p>
	    </div>
		<div class="state gray">
			<span class="icon"></span>
			<p>您的商品已到达北京中心仓！</p>
	        <p class="">2013-10-28  07:25</p>
		</div>
		<div class="state gray">
			<span class="icon"></span>
			<p>您的商品已到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓到达北京中心仓！</p>
	        <p class="">2013-10-28  07:25</p>
		</div>
	</div>
</xmp>

<!-- <p class="info">所有按钮</p> -->
<p class="info">所有按钮</p>
<div class="sn-block pdlayout">
	<a href="#" class="sn-btn sn-btn-assertive sn-btn-outline">红色空心按钮</a>
	<a href="#" class="sn-btn sn-btn-assertive">红色实心按钮</a>
	<a href="#" class="sn-btn sn-btn-assertive sn-btn-big">红色大实心按钮</a>
	<a href="#" class="sn-btn sn-btn-dark sn-btn-outline">灰色空心按钮</a>
	<a href="#" class="sn-btn sn-btn-dark">灰色实心按钮</a>
	<a href="#" class="sn-btn sn-btn-dark sn-btn-big">灰色实心大按钮</a>
	<a href="#" class="sn-btn sn-btn-positive sn-btn-outline">蓝色空心按钮</a>
	<a href="#" class="sn-btn sn-btn-positive">蓝色实心按钮</a>
	<a href="#" class="sn-btn sn-btn-positive sn-btn-big">蓝色实心大按钮</a>
</div>
<a href="#" class="sn-btn sn-btn-assertive sn-btn-big sn-btn-block">红色大实心自适应按钮</a>
<a href="#" class="sn-btn sn-btn-positive sn-btn-big sn-btn-block">蓝色大实心自适应按钮</a>
<a href="javascript:;" class="sn-btn sn-btn-positive sn-btn-big sn-btn-block" id="alertbox1">调用弹出层</a>
<a href="#" class="sn-btn sn-btn-dark sn-btn-big sn-btn-block">灰色大实心自适应按钮</a>
<script type="text/javascript" src="http://res.mpre.cnsuning.com/common/script/module/alertBox/2.0.0/alertBox.js"></script>
<script type="text/javascript">
$("#alertbox1").on("click", function(){
	AlertBox({
		type:'doubleBtn',
		title:'温馨提示'
	});
});
	
</script>
<xmp>
	<div class="sn-block pdlayout">
		<a href="#" class="sn-btn sn-btn-assertive sn-btn-outline">红色空心按钮</a>
		<a href="#" class="sn-btn sn-btn-assertive">红色实心按钮</a>
		<a href="#" class="sn-btn sn-btn-assertive sn-btn-big">红色大实心按钮</a>
		<a href="#" class="sn-btn sn-btn-dark sn-btn-outline">灰色空心按钮</a>
		<a href="#" class="sn-btn sn-btn-dark">灰色实心按钮</a>
		<a href="#" class="sn-btn sn-btn-dark sn-btn-big">灰色实心大按钮</a>
		<a href="#" class="sn-btn sn-btn-positive sn-btn-outline">蓝色空心按钮</a>
		<a href="#" class="sn-btn sn-btn-positive">蓝色实心按钮</a>
		<a href="#" class="sn-btn sn-btn-positive sn-btn-big">蓝色实心大按钮</a>
	</div>
	<a href="#" class="sn-btn sn-btn-assertive sn-btn-big sn-btn-block">红色大实心自适应按钮</a>
	<a href="#" class="sn-btn sn-btn-positive sn-btn-big sn-btn-block">蓝色大实心自适应按钮</a>
	<a href="#" class="sn-btn sn-btn-dark sn-btn-big sn-btn-block">灰色大实心自适应按钮</a>
</xmp>

<!-- <p class="info">字体颜色</p> -->
<p class="info">字体颜色</p>
<div class="sn-block pdlayout">
	<span class="sn-txt-muted">灰色</span>
	<span class="sn-txt-assertive">红色</span>
	<span class="sn-txt-positive">蓝色</span>
	<span class="sn-txt-tips">淡灰色</span>
</div>
<xmp>
	<div class="sn-block pdlayout">
		<span class="sn-txt-muted">灰色</span>
		<span class="sn-txt-assertive">红色</span>
		<span class="sn-txt-positive">蓝色</span>
		<span class="sn-txt-tips">淡灰色</span>
	</div>
</xmp>

<!-- <p class="info">星星</p> -->
<p class="info">星星</p>
<div class="sn-block pdlayout">
	<div class="starBar pr">
		<div class="starBarMask" style="width:50%;"></div>
	</div>
</div>
<xmp>
	<div class="sn-block pdlayout">
		<div class="starBar pr">
			<div class="starBarMask" style="width:50%;"></div>
		</div>
	</div>
</xmp>
<!-- <p class="info">标签</p> -->
<p class="info">标签</p>
<div class="sn-block pdlayout">
	<span class="sn-tag sn-tag-a">橙色</span>
	<span class="sn-tag sn-tag-b">红色</span>
	<span class="sn-tag sn-tag-c">粉红</span>
	<span class="sn-tag sn-tag-d">紫色</span>
	<span class="sn-tag sn-tag-e">黄色</span>
	<span class="sn-tag sn-tag-f">灰色</span>
</div>

<xmp>
	<div class="sn-block pdlayout">
		<span class="sn-tag sn-tag-a">橙色</span>
		<span class="sn-tag sn-tag-b">红色</span>
		<span class="sn-tag sn-tag-c">粉红</span>
		<span class="sn-tag sn-tag-d">紫色</span>
		<span class="sn-tag sn-tag-e">黄色</span>
		<span class="sn-tag sn-tag-f">灰色</span>
	</div>
</xmp>

<!-- <p class="info">通用弹出导航</p> -->
<p class="info">通用弹出导航</p>
<!-- 通用弹出导航 [[-->
	<div id="snIbar" class="sn-ibar close">
		<div id="snIbarMask" class="sn-ibar-mask hide" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');"></div>
		<div id="snIbarToggle" class="sn-ibar-toggle" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');">
			<div class="hline"></div>
			<div class="vline"></div>
		</div>
		<div class="sn-ibar-wrap" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');">
			<a class="item" href="#">
				<div class="icon"></div>
				<div class="title">首页</div>
			</a>
			<a class="item" href="#">
				<div class="icon"></div>
				<div class="title">购物车</div>
			</a>
			<a class="item" href="#">
				<div class="icon"></div>
				<div class="title">搜索</div>
			</a>
			<a class="item" href="#">
				<div class="icon"></div>
				<div class="title">分类</div>
			</a>
			<a class="item" href="#">
				<div class="icon"></div>
				<div class="title">我的易购</div>
			</a>
		</div>
	</div>
	<!-- 通用弹出导航 ]]-->
	<xmp>
		<div id="snIbar" class="sn-ibar close">
			<div id="snIbarMask" class="sn-ibar-mask hide" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');"></div>
			<div id="snIbarToggle" class="sn-ibar-toggle" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');">
				<div class="hline"></div>
				<div class="vline"></div>
			</div>
			<div class="sn-ibar-wrap" onclick="this.parentNode.className.indexOf('open')>-1? this.parentNode.className = this.parentNode.className.replace('open','close'):this.parentNode.className = this.parentNode.className.replace('close','open');">
				<a class="item" href="#">
					<div class="icon"></div>
					<div class="title">首页</div>
				</a>
				<a class="item" href="#">
					<div class="icon"></div>
					<div class="title">购物车</div>
				</a>
				<a class="item" href="#">
					<div class="icon"></div>
					<div class="title">搜索</div>
				</a>
				<a class="item" href="#">
					<div class="icon"></div>
					<div class="title">分类</div>
				</a>
				<a class="item" href="#">
					<div class="icon"></div>
					<div class="title">我的易购</div>
				</a>
			</div>
		</div>

	</xmp>
<!-- <p class="info">底部</p> -->
<p class="info">底部</p>
<div class="footer">
	<ul class="wbox">
		<li><a href="#">登陆</a></li>
		<li><a href="#">注册</a></li>
		<li><a href="#">购物车</a></li>
		<li><a href="#">电脑版</a></li>
	</ul>
</div>
<div class="footer">
	<ul class="wbox">
		<li><a href="#">1865166****</a></li>
		<li><a href="#">注册</a></li>
		<li><a href="#">购物车</a></li>
		<li><a href="#">电脑版</a></li>
	</ul>
</div>
<div class="copyright sn-block tc pdlayout sn-txt-muted">
	Copyright © 2002 -<script type="text/javascript">document.write(new Date().getFullYear())</script> 苏宁 suning.com 版权所有
</div>
<xmp>
	<div class="footer">
		<ul class="wbox">
			<li><a href="#">登陆</a></li>
			<li><a href="#">注册</a></li>
			<li><a href="#">购物车</a></li>
			<li><a href="#">电脑版</a></li>
		</ul>
	</div>
</xmp>


<!-- <p class="info">返回顶部</p> -->
<p class="info">返回顶部</p>
<div id="Top" onclick="$(window).scrollTop(0);"></div>
<xmp>
	<div id="Top" onclick="$(window).scrollTop(0);"></div>
</xmp>

<!-- <p class="info">公用背景图</p> -->
<!-- <p class="info">公用背景图</p> -->
<!-- <div style="background:#484F55;"><img src="http://res.mpre.cnsuning.com/common/style/base/2.0/images/sprites.png"></div> -->

<!-- <p class="info">下载客户端浮层下</p> -->
<p class="info">下载客户端浮层底</p>
<div  class="sn-client-b">
    <span>下载客户端，享受手机专享价下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端</span>
    <a href="#" class="sn-client-a">去下载</a>
</div>
<xmp>
    <div  class="sn-client-b">
        <span>下载客户端，享受手机专享价下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端下载客户端</span>
        <a href="#" class="sn-client-a">去下载</a>
    </div>
</xmp>

<!-- <p class="info">页面底部加载更多样式</p> -->
<p class="info">页面底部加载更多样式</p>
<div class="sn-loading-type">
    <span class="sn-click-loading">点击加载更多</span>
    <span class="sn-pull-loading">上拉精彩无限</span>
    <div class="sn-end-loading"><span>DUANG~到底了</span></div>
</div>
<xmp>
    <div class="sn-loading-type">
        <span class="sn-click-loading">点击加载更多</span>
        <span class="sn-pull-loading">上拉精彩无限</span>
        <div class="sn-end-loading"><span>DUANG~到底了</span></div>
    </div>
</xmp>

<!-- <p class="info">滚动加载</p> -->
<p class="info">滚动加载数据</p>
<div class="loadmore2"></div>
<div class="loadmore"></div>
<script type="text/javascript" src="http://res.mpre.cnsuning.com/common/script/module/lazyload/1.0.0/lazyload.js"></script>

<script type="text/javascript">
	var total = 10;
	$(".loadmore").lazyload(function(el){
		console.log('loadmore')
		if(total <= 0){
			// 已经最后一页，阻止再次执行
			el.attr("data-loaded","done");
			return;
		}
		// 此处 ajax 方法调用数据
		$('.loadmore2').append('<div style="height:2rem;line-height:2rem;background:#ccc;margin:10px 0;">加载的内容</div>');
		total--;
	});
</script>


<script type="text/javascript" src="${base}/webstatic/js/geo.js"></script>
<script type="text/javascript">
;(function(){
	var sn = sn || {};
    // 首页地理定位方法
    var defaultCity={};
    defaultCity.cityNo= $.cookie("cityId") || "9173";
    defaultCity.provinceCode= $.cookie("provinceCode") || '100';
    defaultCity.distNo= $.cookie("districtId") || "11365";
    //cookie 过期时间
    var date = new Date();
    date.setTime(date.getTime() + (12*60*60*1000));
    // 第一次获取位置，有弹窗
    if(!$.cookie("cityId")){

var pos = {"location":{"longi":116.911468,"lati":34.700648},"formatted_address":"江苏省南京市玄武区","business":"","addressComponent":{"city":"南京市","district":"玄武区","province":"江苏省","street":"","street_number":""},"cityCode":316};

    	


        Wap.Geo(function(meta){
        	console.log(meta);
            $.cookie("cityId",meta.cityNo,{path: '/',domain:sn['cookieDomain'],expires: date});
            $.cookie("provinceCode",meta.provinceCode,{path: '/',domain:sn['cookieDomain'],expires: date});
            $.cookie("districtId",meta.distNo,{path: '/',domain:sn['cookieDomain'],expires: date});
        });
    }
})();
    

</script>


<style type="text/css">
	xmp{position:relative;background:#f9f9f9;padding:0 0 15px;margin:10px;overflow-x:auto;}
	xmp:after{content:"双击选中代码";text-shadow:-1px 0 1px #333;color:#fff;position:absolute;right:10px;bottom:10px;}
	p.info{margin:10px;text-shadow:0 2px 1px #fff;font-size:16px;text-align:center;color:#f60;}
	@media screen and (max-width:750px){
		xmp{display:none;}
	}
</style>
<script type="text/javascript">
	var sel = window.getSelection();
	sel.removeAllRanges();
	Array.prototype.slice.call(document.getElementsByTagName("xmp")).forEach(function(item,index){
		var range = document.createRange();
		range.selectNodeContents(item);
		item.addEventListener("dblclick", function(){
			sel.addRange(range);
		}, false);

	});

</script>


</body>
</html>