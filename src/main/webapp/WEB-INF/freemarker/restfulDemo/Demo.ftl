<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>云迹(cloudytrace)</title>	
<script type="text/javascript" src="${base}/webstatic/js/jquery/jquery-1.8.3.js"></script>
</head>
<body>
<div
    style="width:800px;margin-top:10px;margin-left: auto;margin-right: auto;text-align: center;">
    <h2>Uikit Test</h2>
</div>
<div style="width:800px;margin-left: auto;margin-right: auto;">
    <fieldset class="uk-form">
        <legend>Uikit表单渲染测试</legend>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1 uk-form-success">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1 uk-form-danger">
        </div>
        <div class="uk-form-row">
            <input type="text" class="uk-width-1-1">
        </div>
        <div class="uk-form-row">
            <select id="form-s-s">
                <option>---请选择---</option>
                <option>是</option>
                <option>否</option>
            </select>
        </div>
        <div class="uk-form-row">
            <input type="date" id="form-h-id" />
        </div>
    </fieldset>
    <fieldset class="uk-form">
        <legend>基于Restful架构风格的资源请求测试</legend>
        <button class="uk-button uk-button-primary uk-button-large" id="btnGet">获取人员GET</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnAdd">添加人员POST</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnUpdate">更新人员PUT</button>
        <button class="uk-button uk-button-danger uk-button-large" id="btnDel">删除人员DELETE</button>
        <button class="uk-button uk-button-primary uk-button-large" id="btnList">查询列表PATCH</button>
    </fieldset>
</div>
 
<script type="text/javascript">
    $(function(){
       var ctx = '${base}';
       var url = ctx + '/restfulDemo/';
       
       $("#btnGet").click(function(){
           $.ajax({
                    url: url + 'person/101.htm',
                    type: 'GET',
                    dataType: 'json'
                }).done(function(data, status, xhr) {
                    console.log("获取人员信息成功", {status:'success',name:data.name,age:data.age});
                }).fail(function(xhr, status, error) {
                    console.log("请求失败！", {status:'danger',timeout:2000});
                });
       });
       
       
       $("#btnAdd").click(function(){
           $.ajax({
                    url: url + 'person.htm',
                    type: 'POST',
                    dataType: 'json',
                    data: {id: 1,name:'张三',sex:'男',age:23}
                }).done(function(data, status, xhr) {
                    console.log(data.msg, {status:'success',msg:data.msg});
                }).fail(function(xhr, status, error) {
                    console.log("请求失败！", {status:'danger',timeout:2000});
                });
       });
       
       
       $("#btnDel").click(function(){
           $.ajax({
                    url: url + 'person/109.htm',
                    type: 'DELETE',
                    dataType: 'json'
                }).done(function(data, status, xhr) {
                    console.log(data.msg, {status:'success',msg:data.msg});
                }).fail(function(xhr, status, error) {
                    console.log("请求失败！", {status:'danger',timeout:2000});
                });
       });
       
       $("#btnUpdate").click(function(){
           $.ajax({
                    url: url + 'person.htm',
                    type: 'PUT',//注意在传参数时，加：_method:'PUT'　将对应后台的PUT请求方法
                    dataType: 'json',
                    data: {id: 221,name:'王五',sex:'男',age:23}
                }).done(function(data, status, xhr) {
                    console.log(data.msg, {status:'success',timeout:1000});
                }).fail(function(xhr, status, error) {
                    console.log("请求失败！", {status:'danger',timeout:2000});
                });
       });
       
       
       $("#btnList").click(function(){
           $.ajax({
                    url: url + 'person.htm',
                    type: 'PATCH',//注意在传参数时，加：_method:'PATCH'　将对应后台的PATCH请求方法
                    dataType: 'json',
                    data: {_method:'PATCH',name: '张三'}
                }).done(function(data, status, xhr) {
                    console.log("查询人员信息成功", {status:'success',timeout:1000});
                }).fail(function(xhr, status, error) {
                    console.log("请求失败！", {status:'danger',timeout:2000});
                });
       });
    
    })



    
</script>
</body>
	
</html>