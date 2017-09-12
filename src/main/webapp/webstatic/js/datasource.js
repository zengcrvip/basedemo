/**
 * 基于jQuery的Ajax数据源, Author: WXQ
 * 接口返回一个方法，then成功回调，error失败回调，complete成功与失败都会调用
 * 调用方法：
 * var datasource = datasource(url, {....}, {....});
 * 
 * datasource.before(function callback(){...})  			// 获取数据成功, 可定义多个
 * 			 .then(function callback(data){...})  			// 获取数据成功, 可定义多个
 * 			 .error(function callback(status, ex){...})		// 获取数据异常, 可定义多个
 * 			 .complete(function callback(status){...})      // 获取完成（总会执行）, 可定义多个
 * 			 ();											// 调用数据源
 */
function datasource(url, data, options){
	var stacks = {
		'before': [],
		'then': [],
	    'error': [],
	    'complete': []
	};
	
	var promises = ['before', 'then', 'error', 'complete'];
	
	var defaultOpts = {
		url : url,
		data : data,
		dataType : "json",
		beforeSend: function(req){
			$.each(stacks['before'], function(index, func) {
				func();
			});
		},
		success : function(data) {
			$.each(stacks['then'], function(index, func) {
				func(data);
			});
		},
		error : function(req, status, ex) {
			$.each(stacks['error'], function(index, func) {
				func(status, ex);
			});
		},
		complete : function(req, status) {
			$.each(stacks['complete'], function(index, func) {
				func(status);
			});
		}
	};
	
	var request = function () {
		if(!!options){
			var ajaxOptions = $.extend({}, options, defaultOpts);
			$.ajax(ajaxOptions);
		}else{
			$.ajax(defaultOpts);
		}
		return request;
	};
	
    $.each(promises, function(index, item){
    	request[item] = function(func){
    		stacks[item].push(func);
    		return request;
    	};
    });
    
	return request;
}