<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta content="telephone=no" name="format-detection" />
	<title>公共组件</title>
	<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/webstatic/js/zepto.min.js"></script>
<style type="text/css">
    @media screen and (min-width: 360px) {
	  body{
	    font-size: 12px;
	   }
     }
     body,div,p{padding:0px;margin:0px}
     body{min-width:320px;max-width:640px;background:#F2F2F2;line-height:1.5;font-family:Arial,Helvetica,STHeiTi,sans-serif}
     .info{text-align:center;color:#f60;margin:10px;font-size:16px;text-shadow:0 2px 1px #fff}
     .pdlayout{background-color:#fff;padding:5px 5px;}
     
     .choose{
	    position: relative;
	    height: 1.2rem;
	    margin: 0.2rem 0.4rem 0 0;
	    max-width: 2.5rem;
     }
     
     .choose input{position: absolute;
	    top: 0;
	    left: 0;
	    width: 100%;
	    height: 1.2rem;
	    border: 1px solid #DCDCDC;
	    z-index: 10;
	    background: #FFF;
	    padding: 0 0.2rem;
	    -webkit-appearance:none
	  }
	  
	  .choose span{
	    position: relative;
	    height: 1.2rem;
	    padding:0 0.2rem;
	    top:3px;
	    z-index: 11;
	  }
	  
	  .loagMask{position:fixed;top:120px;left:0;width:100%;height:100%;z-index:1000;background:rgba(0,0,0,0.4)}
	  .hide{display:none}
	  .sel-box{width:100%;position:relative;z-index:9999;background:#ddd;}
	   dt,dd,span,a{display:inline-block}
	  .sel-wrap{margin-bottom:1.5rem;padding-top:0.5rem}
	  .sel-item dt{width:4.5rem;text-indent:1.5rem}
	  .w-btn{border:1px solid #ddd; border-radius:0.5rem;width:3.5rem;height:2rem;line-height:2rem;text-align:center;margin-right:1.2rem;background:#fff}
      .sel-btn{border-top:1px solid #aaa;width:100%;line-height:3rem;text-align:right;margin-right:1rem}
      .t-btn{text-decoration:none;color:#16B273}
</style>
</head>
<body>
    <p class="info">类型选中checkbox版</p>
    <div class="pdlayout">
       <div class="type-choose">
          <label class="choose">
             <input type="radio" name="typechoose"></input>
             <span>飞利浦</span>
          </label>
          <label class="choose">
             <input type="radio" name="typechoose"></input>
             <span>三星</span>
          </label>
       </div>
    </div>
    
    <input type="button" value="提交" id="submit"/>
    
    <div class="sel-box hide">
       <div class="sel-wrap">
          <dl class="sel-item">
            <dt>渠道：</dt>
            <dd>
              <span class="w-btn">全部</span>
              <span class="w-btn">10</span>
              <span class="w-btn">20</span>
            </dd>
          </dl>
          <dl class="sel-item">
            <dt>商品组：</dt>
            <dd>
              <span class="w-btn">全部</span>
              <span class="w-btn">手机</span>
              <span class="w-btn">配件</span>
            </dd>
          </dl>
       </div>
       <div class="sel-btn">
           <a href="#" class="w-btn t-btn">取消</a>
           <a href="#" class="w-btn t-btn sure">确定</a>
       </div>
    </div>
    
    <div class="loagMask hide"></div>
       
    <script>
        $(function(){
           $("#submit").click(function(){
              $(".sel-box").toggle();
              $(".loagMask").toggle();
           });
           
           $(".sure").click(function(){
              alert("aaa");
           })
        })
    </script>
    
</body>
</html>