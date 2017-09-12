<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<title>Jquery Block遮盖层</title>	
	<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery.blockUI.js"></script>
	<style type="text/css">
	   .panel{height:200px;width:100%;border:1px solid black}
	   .panel-title{height:50px;width:100%;border-bottom:1px solid black}
	   .button{ display: inline-block;
			    background-color: #008CBA;
			    color: #fff;
			    padding: 4px 8px;
			    font-size: 12px;
			    margin: 10px;}
	</style>
</head>
<body>

<div class="panel">
   <div class="panel-title">
      <a id="block" class="button">Block</a>
      <a id="blockmsg" class="button">Block with Message</a>
      <a id="unblock" class="button">UnBlock</a>
      
   </div>
   <div id="content" class="panel-content">
       
   </div> 
</div>
 
<script type="text/javascript">
$(function(){
    // 加载遮罩选项
	var maskOption = {  
	    message:'正在加载数据，请等待...',
	    overlayCSS:  {
			backgroundColor: '#DDD',
			opacity: 0.2,
			cursor: 'wait'
		},
		css: {
			color: '#000',
			opacity: 0.3,
			background: '#AAA', 
	        'border-radius': '10px'
		}
	};
	
	
    
     $('#block').click(function() {
            $('#content').block(maskOption);
        });
        
        
     $('#unblock').click(function(){
        $('#content').unblock();
     });   
})
</script>
</body>
</html>