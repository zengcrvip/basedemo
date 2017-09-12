 /**
  * @author 15020105
  * @Date 2015-03-11
  */
jQuery.extend({
	validateUtil:{
		getClassType:function(obj){
			if(obj===null) return "Null";
		    if(obj===undefined) return "Undefined";
		    return Object.prototype.toString.call(obj).slice(8,-1);
		},
		isExists:function(obj){
			return !(null == obj || typeof obj == 'undefined');
		},
		isFunction:function(func){
			return typeof func == 'function';
		},
		isIntegerNumber:function(num){
			return /^[0-9\-]+$/.test(num);
		},
		isFloatNumber:function(num){
			return /^[0-9\-]+\.\d+$/.test(num);
		},
		isNumber:function(num){
			return  typeof num == 'number';
		},
		round:function(num,digit){
			if(num == 0) {return num;}
			digit = !!digit?digit:2;
			if(this.isFloatNumber(num)) {
				return parseFloat(parseFloat(num).toFixed(digit));
			}
			return num;
		},
		isString:function(str){
			return  this.getClassType(str) == 'String';
		},
		isArray:function(arr) {
			return  this.getClassType(arr) == 'Array';
		},
		isObject:function(obj) {
			return  this.getClassType(obj) == 'Object';
		},
		clone : function (obj){
		    var result,oClass=this.getClassType(obj);
		        //确定result的类型
		    if(oClass==="Object"){
		        result={};
		    }else if(oClass==="Array"){
		        result=[];
		    }else{
		        return obj;
		    }
		    for(key in obj){
		        var copy=obj[key];
		        if(this.getClassType(copy)=="Object"){
		            result[key]=arguments.callee(copy);//递归调用
		        }else if(this.getClassType(copy)=="Array"){
		            result[key]=arguments.callee(copy);
		        }else{
		            result[key]=obj[key];
		        }
		    }
		    return result;
		}
	},
	formateUtils:{
		thousandsFormat : function(num, digit) {
			num = num!=null?num:'--';
			digit = digit!=null?digit:2;
			if($.validateUtil.isNumber(num)) {
				if($.validateUtil.isIntegerNumber(num)){
				    return (num + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}else{
				    return (num.toFixed(digit) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}
			}
			return num;
		},
		rateFormat : function(num, digit) {
			num = num!=null?num:'--';
			digit = digit!=null?digit:0;
			if($.validateUtil.isNumber(num)) {
				if($.validateUtil.isIntegerNumber(num)){
				    return (num + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,') + '%';
				}else{
				    return (num.toFixed(digit) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,') + '%';
				}
			}
			return num + '%';
		},
		thousandsFormats : function(num, digit) {
			if(num == 0) {return num;}
			digit = !!digit?digit:2;
			if($.validateUtil.isNumber(num)) {
				if($.validateUtil.isIntegerNumber(num)){
				    return (num + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}else{
				    return (num.toFixed(digit) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}
			}
			return num;
		}
	},
	/**
	 * BASE64编码解码，支持UNICODE字符集
	 */
	base64: {
		is_unicode : true, //是否使用 Unicode

		base64EncodeChars : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",

		base64DecodeChars : [ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1,
				63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
				-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28,
				29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
				46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 ],

		encode : function(str) {
			if (this.is_unicode) str = this.utf16to8(str);
			var out, i, len;
			var c1, c2, c3;
			len = str.length;
			i = 0;
			out = "";
			while (i < len) {
				c1 = str.charCodeAt(i++) & 0xff;
				if (i == len) {
					out += this.base64EncodeChars.charAt(c1 >> 2);
					out += this.base64EncodeChars.charAt((c1 & 0x3) << 4);
					out += "==";
					break;
				}
				c2 = str.charCodeAt(i++);
				if (i == len) {
					out += this.base64EncodeChars.charAt(c1 >> 2);
					out += this.base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
					out += this.base64EncodeChars.charAt((c2 & 0xF) << 2);
					out += "=";
					break;
				}
				c3 = str.charCodeAt(i++);
				out += this.base64EncodeChars.charAt(c1 >> 2);
				out += this.base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
				out += this.base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6));
				out += this.base64EncodeChars.charAt(c3 & 0x3F);
			}
			return out;
		},
		
		decode : function(str) {
			var c1, c2, c3, c4;
			var i, len, out;
			len = str.length;
			i = 0;
			out = "";
			while (i < len) {
				/* c1 */
				do {
					c1 = this.base64DecodeChars[str.charCodeAt(i++) & 0xff];
				} while (i < len && c1 == -1);
				if (c1 == -1)
					break;
				/* c2 */
				do {
					c2 = this.base64DecodeChars[str.charCodeAt(i++) & 0xff];
				} while (i < len && c2 == -1);
				if (c2 == -1)
					break;
				out += String.fromCharCode((c1 << 2) | ((c2 & 0x30) >> 4));
				/* c3 */
				do {
					c3 = str.charCodeAt(i++) & 0xff;
					if (c3 == 61)return out;
					c3 = this.base64DecodeChars[c3];
				} while (i < len && c3 == -1);
				if (c3 == -1)
					break;
				out += String.fromCharCode(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));
				/* c4 */
				do {
					c4 = str.charCodeAt(i++) & 0xff;
					if (c4 == 61)return out;
					c4 = this.base64DecodeChars[c4];
				} while (i < len && c4 == -1);
				if (c4 == -1)break;
				out += String.fromCharCode(((c3 & 0x03) << 6) | c4);
			}
			if (this.is_unicode) out = this.utf8to16(out);
			return out;
		},
		
		utf16to8 : function(str) {
			var out, i, len, c;
			out = "";
			len = str.length;
			for (i = 0; i < len; i++) {
				c = str.charCodeAt(i);
				if ((c >= 0x0001) && (c <= 0x007F)) {
					out += str.charAt(i);
				} else if (c > 0x07FF) {
					out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
					out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
					out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
				} else {
					out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
					out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
				}
			}
			return out;
		},

		utf8to16 : function(str) {
			var out, i, len, c;
			var char2, char3;
			out = "";
			len = str.length;
			i = 0;
			while (i < len) {
				c = str.charCodeAt(i++);
				switch (c >> 4) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					// 0xxxxxxx
					out += str.charAt(i - 1);
					break;
				case 12:
				case 13:
					// 110x xxxx 10xx xxxx
					char2 = str.charCodeAt(i++);
					out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
					break;
				case 14:
					// 1110 xxxx 10xx xxxx 10xx xxxx
					char2 = str.charCodeAt(i++);
					char3 = str.charCodeAt(i++);
					out += String.fromCharCode(((c & 0x0F) << 12) | ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0));
					break;
				}
			}
			return out;
		}
	},
	mbmUtils:{
		/**获取TABLE中的行列用于导出EXCEL
		 * 参数：{tableId:tabId【必选】,title:标题【可选】,conditions:报表查询条件值【可选】}
		 * 返回 的格式为：{rowType:行类型参见[rowTypeConstant]
		 * cellEntityList:[{rowSpan:合并的行数,colSpan:合并的列数,text:td中的值}]}
		 */
		getExcelTableList:function(excelParam) {
			//行类型常量
			var rowTypeConstant = {
					TITLE_ROW:0,//是大标题行行类型
					SMALL_TITLE_ROW:1,//行类型是小标题行
					HEAD_ROW:2, //行类型是报表头行
					SPLIT_ROW:3 //行类型是分割行
				};
			var util = {
					getClassType:function(obj){
						if(obj===null) return "Null";
					    if(obj===undefined) return "Undefined";
					    return Object.prototype.toString.call(obj).slice(8,-1);
					},
					isExists:function(obj){
						return !(null == obj || typeof obj == 'undefined');
					},
					isString:function(str){
						return  this.getClassType(str) == 'String';
					},
					isArray:function(arr) {
						return  this.getClassType(arr) == 'Array';
					},
					isObject:function(obj) {
						return  this.getClassType(obj) == 'Object';
					}
			};

	 	    var tabTrList = new Array(),//TABLE中所有的行的列表
	 	    	headTableId = excelParam.headTableId,
	 	    	dataTableId = excelParam.dataTableId,
	 	    	isMinusHeadFirstTr = excelParam.isMinusHeadFirstTr,
	 	    	title = excelParam.title,
	 	    	smallTitles = excelParam.smallTitles;
	 	    
	 	    if(util.isExists(title) && util.isObject(title)) {
	 	    	title.rowSpan = util.isExists(title.rowSpan)?title.rowSpan:1;
	 	    	title.colSpan = util.isExists(title.colSpan)?title.colSpan:1;
	 	    	title.text    = util.isExists(title.text)?title.text:'';
	 	    	
	 	    	tabTrList.push({rowType:rowTypeConstant.TITLE_ROW,
	 	    					cellEntityList:[{rowSpan:title.rowSpan,colSpan:title.colSpan,text:title.text}]});
	 	    }
	 	    
	 	   if(util.isExists(smallTitles)) {
	 		   var smallRowSpan=1,smallColSpan=1;
	 		   
	 		   if(util.isExists(title) && util.isObject(title)) {
	 				 smallColSpan = title.colSpan;
	 		   }
	 		   
	 		   if(util.isString(smallTitles)) {//如果只是字符串
	 			  if(util.isExists(title) && util.isObject(title)) {
	 				 tabTrList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
	    					cellEntityList:[{rowSpan:smallRowSpan,colSpan:smallColSpan,text:smallTitles}]});
	 			  }
	 		   } else if(util.isArray(smallTitles)) {//如果是个数组
	 			   for(var i=0;i<smallTitles.length;i++) {
	 				   if(util.isString(smallTitles[i])) {
	 					  tabTrList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
		    					cellEntityList:[{rowSpan:smallRowSpan,colSpan:smallColSpan,text:smallTitles[i]}]});
	 				   } else if(util.isObject(smallTitles[i])) {
	 					  tabTrList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
		    					cellEntityList:[{rowSpan:util.isExists(smallTitles[i].rowSpan)?smallTitles[i].rowSpan:smallRowSpan,
		    							         colSpan:util.isExists(smallTitles[i].colSpan)?smallTitles[i].colSpan:smallColSpan,
		    									 text:util.isExists(smallTitles[i].text)?smallTitles[i].text:''}]});
	 				   }
	 			   }
	 		   } else if(util.isObject(smallTitles)) {//如果是对象
	 			  tabTrList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
  					cellEntityList:[{rowSpan:util.isExists(smallTitles.rowSpan)?smallTitles.rowSpan:smallRowSpan,
  							         colSpan:util.isExists(smallTitles.colSpan)?smallTitles.colSpan:smallColSpan,
  									 text:util.isExists(smallTitles.text)?smallTitles.text:''}]}); 
			   }
	 	    }
	 	   
	 	   /**添加报表头*/
	 	  var headTableTrs = $('#'+headTableId).find('tr');
	 	  for(var i=0;i<headTableTrs.length;i++) {
	 		  if(i==0 && isMinusHeadFirstTr) {
	 			  continue;
	 		  }
	 		  var trObject = $(headTableTrs.get(i)),
				 tds =trObject.children(),
				 trTdList = new Array();
				 
				for(var k=0;k<tds.length;k++) {
					var tdobj = $(tds.get(k)),
					    excelEntity = {};
					var rowSpan = tdobj.attr('rowspan');
					excelEntity.rowSpan = util.isExists(rowSpan)?rowSpan:1;
					var colSpan = tdobj.attr('colspan');
					excelEntity.colSpan = util.isExists(colSpan)?colSpan:1;
					var text = tdobj.text();
					excelEntity.text = util.isExists(text)?text:'';
					trTdList.push(excelEntity);
				}
				tabTrList.push({rowType:rowTypeConstant.HEAD_ROW,cellEntityList:trTdList});
	 	  }
	 	 /**添加报表数据*/
	 	  var dataTableTrs = $('#'+dataTableId).find('tr');
	 	  for(var i=0;i<dataTableTrs.length;i++) {
	 		  var trObject = $(dataTableTrs.get(i)),
	 		  	  rowType = -1;//行类型，默认无类型
	 		  
				if(new RegExp('bordertopbottom').test(trObject.attr('class'))) {
					rowType = rowTypeConstant.SPLIT_ROW;
				}
				
				var tds =trObject.children();
				var trTdList = new Array();
				for(var k=0;k<tds.length;k++) {
					var tdobj = $(tds.get(k)),
					    excelEntity = {};
					var rowSpan = tdobj.attr('rowspan');
					excelEntity.rowSpan = util.isExists(rowSpan)?rowSpan:1;
					var colSpan = tdobj.attr('colspan');
					excelEntity.colSpan = util.isExists(colSpan)?colSpan:1;
					var text = tdobj.text();
					excelEntity.text = util.isExists(text)?text:'';
					trTdList.push(excelEntity);
				}
				tabTrList.push({rowType:rowType,cellEntityList:trTdList});
	 	  }
			return tabTrList;
		},
		getTableData:function(param){
			//行类型常量
			var rowTypeConstant = {
					DEFAULT_ROW:-1,
					TITLE_ROW:0,//是大标题行行类型
					SMALL_TITLE_ROW:1,//行类型是小标题行
					HEAD_ROW:2, //行类型是报表头行
					SPLIT_ROW:3 //行类型是分割行
			};
			var util = {
					getClassType:function(obj){
						if(obj===null) return "Null";
					    if(obj===undefined) return "Undefined";
					    return Object.prototype.toString.call(obj).slice(8,-1);
					},
					isExists:function(obj){
						return !(null == obj || typeof obj == 'undefined');
					},
					isString:function(str){
						return  this.getClassType(str) == 'String';
					},
					isArray:function(arr) {
						return  this.getClassType(arr) == 'Array';
					},
					isObject:function(obj) {
						return  this.getClassType(obj) == 'Object';
					}
			};
			
			var columnsAry;
			var formalcolumnsAry = $('#'+param.tableId).datagrid("options").columns;
			var frozenColumnsAry = $('#'+param.tableId).datagrid("options").frozenColumns;
			if(!!frozenColumnsAry){
				for(var i = 0;i < frozenColumnsAry.length; i++) {
				  var columns = frozenColumnsAry[i].concat(formalcolumnsAry[i]);
				  formalcolumnsAry[i] = columns
				}
				
			}
			
			columnsAry = formalcolumnsAry;
			var rows = $('#'+param.tableId).datagrid('getRows');
			
			
			var tabList = new Array();//TABLE中所有的行的列表
			var smallTitles = param.smallTitles;
			var title = param.title;
			if(util.isExists(smallTitles)) {
		 		   var smallRowSpan=2,smallColSpan=2;
		 		   
		 		   if(util.isExists(title) && util.isObject(title)) {
		 				 smallColSpan = title.colSpan;
		 				 tabList.push({rowType:rowTypeConstant.TITLE_ROW,
		    					cellEntityList:[{rowSpan:smallRowSpan,colSpan:smallColSpan,text:title.text}]});
		 		   }
		 		   
		 		   if(util.isString(smallTitles)) {//如果只是字符串
		 			  if(util.isExists(title) && util.isObject(title)) {
		 				 tabList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
		    					cellEntityList:[{rowSpan:1,colSpan:smallColSpan,text:smallTitles}]});
		 			  }
		 		   } else if(util.isArray(smallTitles)) {//如果是个数组
		 			   smallRowSpan = smallTitles.length;
		 			   for(var i=0;i<smallTitles.length;i++) {
		 				   if(util.isString(smallTitles[i])) {
		 					  tabList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
			    					cellEntityList:[{rowSpan:1,colSpan:smallColSpan,text:smallTitles[i]}]});
		 				   } else if(util.isObject(smallTitles[i])) {
		 					  tabList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
			    					cellEntityList:[{rowSpan:util.isExists(smallTitles[i].rowSpan)?smallTitles[i].rowSpan:smallRowSpan,
			    							         colSpan:util.isExists(smallTitles[i].colSpan)?smallTitles[i].colSpan:smallColSpan,
			    									 text:util.isExists(smallTitles[i].text)?smallTitles[i].text:''}]});
		 				   }
		 			   }
		 		   } else if(util.isObject(smallTitles)) {//如果是对象
		 			  tabList.push({rowType:rowTypeConstant.SMALL_TITLE_ROW,
	  					cellEntityList:[{rowSpan:util.isExists(smallTitles.rowSpan)?smallTitles.rowSpan:smallRowSpan,
	  							         colSpan:util.isExists(smallTitles.colSpan)?smallTitles.colSpan:smallColSpan,
	  									 text:util.isExists(smallTitles.text)?smallTitles.text:''}]}); 
				   }
		 	    }
			
			//拼裝表头
			for(var i = 0;i < columnsAry.length; i++) {
				var columns = columnsAry[i];
				var headerList = new Array();
				for(var j = 0;j < columns.length; j++) {
					var column = columns[j];
					var excelEntity = {};
					var rowSpan = column.rowspan;
					excelEntity.rowSpan = rowSpan;
					var colSpan = column.colspan;
					excelEntity.colSpan = colSpan;
					var text = column.title;
					excelEntity.text = text;
					headerList.push(excelEntity);
				}
				tabList.push({rowType:rowTypeConstant.HEAD_ROW,cellEntityList:headerList});
			}
			
			var fieldAry = new Array();
			// 销售额--手机+穿戴+配件（每日销售）/通讯品牌类各渠道销售量情况日报 导出特殊处理
			if (param.tableId == "id_table_amount" || param.tableId == "id_table_quatity")
			{
				for(var i = 0;i < 56; i++) {
					fieldAry.push('d'+i);
				}
			}
			else
			{
				for(var i = 0;i < columnsAry.length; i++) {
					var columns = columnsAry[i];
					for(var k = 0; k < columns.length; k++) {
						if(columns[k].field){
							fieldAry.push(columns[k].field);
						}
					}
				}
			}
				
			
			//拼装数据行
			for(var i = 0; i < rows.length; i++) {
				//动态获取每一行每一列的数据值
				var row  = rows[i];
				var excelEntityList = new Array();
				for(var j = 0;j < fieldAry.length; j++) {
					 var excelEntity = new Object();
					 var rowSpan = 1;
			         excelEntity.rowSpan = rowSpan;
			         var colSpan = 1;
			         excelEntity.colSpan = colSpan;
			         var text = row[fieldAry[j]];
			         text = (text==null || text==undefined)?"":text;
			         excelEntity.text = text;
			         excelEntityList.push(excelEntity);
				}
				tabList.push({rowType:rowTypeConstant.DEFAULT_ROW,cellEntityList:excelEntityList});
			}
			return tabList;
		},
		/**
		 * 使用示例：
		 * $.mbmUtils.exportExcel({
				headTableId:'head_tableId',//报表头的TABLEID
				dataTableId:'data_tableId',//报表数据的TABLEID
				isMinusHeadFirstTr:true,//是否去掉报表头TABLE中的第一行(有空行的情况下),默认为true
				title:{text:'公司费用构成',colSpan:12}, //报表标题，colSpan是此标题合并的单元格数【可选】
				smallTitles:[
							 '本期日期：2015年01月，组织：财务中心',
							 '单位：台（销售量），万元（销售金额）'
							]//查询的条件串，单位等都作为小标题，数组中的每一项目都独占一行
			});
		*/
		exportExcel:function(excel){
			excel = jQuery.extend({isMinusHeadFirstTr:true}, jQuery.ajaxSettings, excel);
			var form1 = $('<form method="POST" enctype="multipart/form-data"></form>');
			form1.attr("action","/BaseDemo/tableDownDemo/getDataDown3.htm");
			var _ddata = excel.data ? excel.data : jQuery.mbmUtils.getExcelTableList(excel);
			if(jQuery.validateUtil.isArray(_ddata)) {
				for(var i=0;i<_ddata.length;i++) {
					var rowJson = $.base64.encode(JSON.stringify(_ddata[i]));
					var datas = $('<input type="text" name="datas"/>');
					datas.val(rowJson);
					form1.append(datas);
				}
			}
			if(excel.title) {
				var fileNameInput = $('<input name="fileName" value="" />');
				fileNameInput.val($.base64.encode(excel.title.text));
		  		form1.append(fileNameInput);
			}
			$('body').append(form1);
			form1.submit();
			form1.remove();
		},
		/**
		 * 使用示例：
		 * $.mbmUtils.exportCharts({
				charts : [myChart1, null, null, myChart2],  // 图表排列矩阵的数组， 元素可为null,
				title : "管理制式手机销售额情况统计图表",     		// 标题
				head : "日期: 2015-05-12    任务类型: 销售",		// 图表信息
				rowsize : 2,               					// 行图表个数
				colspan : 8, 								// 每个图表区域跨EXCEL列数 
				rowspan : 20, 								// 每个图表区域跨EXCEL行数
				resize : 0.8 								// 图表缩放系数， <1 缩小
				});
		*/
		exportCharts:function(option){
			var form = $('<form method="POST"></form>');
			form.attr("action","/smoc-pc-web/common/exportCharts.htm");
			for(var i in option.charts){
				var chart = $('<input name="charts"/>');
				if(option.charts[i] != null){
					chart.val(option.charts[i].getDataURL("png"));
				}else{
					chart.val("");
				}
				form.append(chart);
			}
			var input = $('<input name="charts"/>');
			form.append(input);
			input = $('<input name="title"/>');
			input.val(option.title);
			form.append(input);
			input = $('<input name="head"/>');
			input.val(option.head);
			form.append(input);
			input = $('<input name="rowsize"/>');
			input.val(option.rowsize);
			form.append(input);
			input = $('<input name="colspan"/>');
			input.val(option.colspan);
			form.append(input);
			input = $('<input name="rowspan"/>');
			input.val(option.rowspan);
			form.append(input);
			input = $('<input name="resize"/>');
			input.val(option.resize);
			form.append(input);
			$('body').append(form);
			form.submit();
			form.remove();
		},
		/**注册对象命名空间
		 * 示例：$.mbmUtils.regNameSpace("com.company.report");
		 * 下面即可 直接使用com.company.report此对象
		 * */
		regNameSpace:function(){
			var args = arguments, o = null, nameSpaces;
			for (var i = 0; i < args.length; i++) {
				nameSpaces = args[i].split(".");
				o = window;
				for (var j = 0; j < nameSpaces.length; j++) {
					o[nameSpaces[j]] = o[nameSpaces[j]] || {};
					o = o[nameSpaces[j]];
				}
			}
			return o;
		},
		
		loading:function(){
			$.blockUI({css:{ 
	            border: 'none', 
	            padding: '15px', 
	            backgroundColor: '#dddddd', 
	            '-webkit-border-radius': '10px', 
	            '-moz-border-radius': '10px', 
	            opacity: 0.2, 
	            color: '#000000' 
	        },overlayCSS:  {
				backgroundColor:	'#999999',
				opacity:			0.2,
				cursor:				'wait'
			} }); 
		},
		unLoading:function(){
			$.unblockUI();
		},
		ajaxLoading:function(){
			$("<div class='datagrid-mask div_no_select'></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body"); 
	 		$("<div class='datagrid-mask-msg div_no_select'></div>").html("正在加载，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
		},
		unAjaxLoading:function(){
			$("body").children("div.datagrid-mask-msg").remove();
			$("body").children("div.datagrid-mask").remove();
		},
		parseJson:function(jsonStr){
			if(!$.validateUtil.isExists(jsonStr)) {
				return '';
			}
			return JSON.parse(jsonStr);
		},
		//选择框 
		selection:function(setting){
			var _select = $("#"+setting.id),
				_default = {disable_search_threshold: 10};//结果小于10不显示搜索
			
			if($.validateUtil.isArray(setting.data)) {
				var vFName = $.validateUtil.isExists(setting.valueField)?setting.valueField:'value',
					tFName = $.validateUtil.isExists(setting.textField)?setting.textField:'text';
				$.each(setting.data,function(i,n) {
					_select.append($('<option value="'+n[vFName]+'">'+n[tFName]+'</option>'));
				});
			}
			
			if($.validateUtil.isExists(setting.chosen)) {
				_default = setting.chosen;
			} else {
				if(setting.isSearch) {
					_default.no_results_text="没有查询到结果...";
				}
				if(setting.isEmpty)  {
					_default.allow_single_deselect = true;
				}
			}
			
			if($.validateUtil.isFunction(setting.change)) {
				_select.chosen(_default).change(function(e){
					setting.change(e,$(this).val(),$(this).find("option:selected").text());
				});
			} else {
				_select.chosen(_default);
			}
		},
		//树型结构
		initZTree:function(setting,treeSetting){
			treeSetting = jQuery.extend({data: {
				simpleData: {
					enable: true
				}
			}}, jQuery.ajaxSettings, treeSetting);
			
			var tools = {
					setSelectedChecked : function(treeData){
						if(!!treeSetting && !!treeSetting.check) {
							if(!!treeSetting.check.chkStyle && treeSetting.check.chkStyle == 'checkbox')  {
							
								var val = $('#'+setting.id).val();
								var selectedArr = [],selectedObj = {};
								//选中后输入框中的选中值
								if(val != '') {
									selectedArr = JSON.parse(val);
								} 
								
								for(var i=0;i<selectedArr.length;i++) {
									selectedObj[selectedArr[i].value] = selectedArr[i];
								}
							
								
								for(var i=0;i<treeData.length;i++) {
									if(!!selectedObj[treeData[i].id]) {
										treeData[i].checked=true;
									} else {
										treeData[i].checked=false;
									}
								}
								if(selectedArr.length > 0) {
									treeData.sort(function(a,b) {
										if(!a.checked && !b.checked) {
											return 0;
										} else if(a.checked && b.checked){
											return 1;
										} else if(a.checked && !b.checked){
											return -1;
										} else if(!a.checked && b.checked){
											return 1;
										} else {
											return 0;
										}
									});
								}
						
							}
						}
						
					}
			};
			
			var input = $('#'+setting.nameId),
				inputhide = $('#'+setting.id),
				showBtn = $('<span class="ui-notext-button"></span>'),
				box = $('<div id="'+setting.id+'BoxDiv" style="display:none;position:absolute;border:1px solid #000000;max-height:300px;min-height:100px;min-width:150px;overflow:auto;background-color:#FFFFFF;"></div>');
			
			   showBtn.append('<img src="/smoc-pc-web/webstatic/images/combo_arrow.png" style="vertical-align:middle;margin:0 auto;text-align:center;"/>');
			   if($.browser.mozilla) {
				   input.css({'paddingTop':'1px','paddingBottom':'2px','height':'19px'});
			   }
			   var pubObj = {
				showTreeMenu:function(){//展示树菜单
					var areaOffset = input.offset();
					box.css('width',input.css('width'));
					box.css({left:areaOffset.left + "px", top:areaOffset.top + input.outerHeight() + "px","z-index":'1500'}).slideDown("fast");
					box.css('display','');
					$("body").bind("mousedown",function(event){
						if (!(event.target.id == setting.id+'BoxDiv'|| $(event.target).parents('#'+setting.id+'BoxDiv').length>0)) {
							box.css('display','none');
			    			$("body").unbind("mousedown");
						}
					});
				}	
			};
			showBtn.click(function(){//展示
				if(setting.initTree && typeof setting.initTree == 'function') {//优先执行initTree
					 setting.initTree(input,$('#'+setting.id+'BoxDiv'),function(datas){
						 	tools.setSelectedChecked(datas);
							$.fn.zTree.init(_sign, treeSetting, datas);
							pubObj.showTreeMenu();
						});
				 } else {//否则每次初始化都显示全量数据
					 if(setting.treeData) {
						 tools.setSelectedChecked(setting.treeData);
						 $.fn.zTree.init(_sign, treeSetting, setting.treeData);
						 pubObj.showTreeMenu();
					 }
				 }
			});
		
			var _sign = $('<ul class="ztree" id="'+setting.id+'_treeId"></ul>');
			box.append(_sign);
			if(!treeSetting.callback) {
				treeSetting.callback = {};
			}
			treeSetting.callback = jQuery.extend(treeSetting.callback, {
				onClick:function(event, treeId, treeNode, clickFlag){
					setting.isInputTextFromKeyboard = false;//标识输入框中的字符变化是否来自键盘的输入
					if(!!treeSetting && !!treeSetting.check) {
						if(!!treeSetting.check.chkStyle && treeSetting.check.chkStyle == 'checkbox')  {
							return;
						}
					}
					if(treeNode){
						input.val(treeNode.name);
						inputhide.val(JSON.stringify([{value:treeNode.id,name:treeNode.name}]));
					}
				},
				onDblClick:function(event, treeId, treeNode){
					
					setting.isInputTextFromKeyboard = false;
					if(!!treeSetting && !!treeSetting.check) {
						if(!!treeSetting.check.chkStyle && treeSetting.check.chkStyle == 'checkbox')  {
							return;
						}
					}
					if(treeNode){
						input.val(treeNode.name);
						inputhide.val(JSON.stringify([{value:treeNode.id,name:treeNode.name}]));
						$('#'+setting.id+'BoxDiv').css('display','none');
					}
					
				},
				onCheck:function(event, treeId, treeNode){
					setting.isInputTextFromKeyboard = false;
					var treeObj = $.fn.zTree.getZTreeObj(treeId);
					var nodes = treeObj.getCheckedNodes(true);
					var showName = '',values = [];
					
					for(var i=0;i<nodes.length;i++) {
						showName = showName+nodes[i].name+',';
						values[i] = {value:nodes[i].id,name:nodes[i].name};
					}
					input.val(showName.substring(0, showName.length -1));
					inputhide.val(JSON.stringify(values));
				}
			});
			
			
			 if(setting.treeData) {
				 var showName = '',values = [],nodes = setting.treeData;
				 for(var i=0;i<nodes.length;i++) {
					 if(nodes[i].checked){
						 showName = showName+nodes[i].name+',';
						 values.push({value:nodes[i].id,name:nodes[i].name});
					 }
				}
				 if(showName.length >0) {
					 input.val(showName.substring(0, showName.length -1));
					 inputhide.val(JSON.stringify(values));
				 }
				
			 }
			
			input.bind('input propertychange',function(){
				if(setting.isInputTextFromKeyboard){
					if(setting.queryByRealtime && typeof setting.queryByRealtime == 'function') {
						 setting.queryByRealtime(input,$('#'+setting.id+'BoxDiv'),function(datas){
							 	if(input.val() == '') {
									$('#'+setting.id).val('');
								}
							    tools.setSelectedChecked(datas);
								$.fn.zTree.init(_sign, treeSetting, datas);
								pubObj.showTreeMenu();
							});
					 }
				}
			});
			input.keydown(function(event) {
				setting.isInputTextFromKeyboard = true;
        		   event = event || window.event || arguments.callee.caller.arguments[0];
        		   if(event.keyCode == 13) {
        			   if(setting.queryByEnter && typeof setting.queryByEnter == 'function') {
        				   setting.queryByEnter(input,$('#'+setting.id+'BoxDiv'),function(datas){
        					   if(input.val() == '') {
	       							$('#'+setting.id).val('');
	       						}
        					   tools.setSelectedChecked(datas);
		   						$.fn.zTree.init(_sign, treeSetting, datas);
		   						pubObj.showTreeMenu();
		   					});
        			   }
        		   }
        	   });
			
			input.parent().append(box).append(showBtn).append(inputhide);
			
			if(setting && setting.callbackFunc) {
				if(typeof setting.callbackFunc == 'function') {
					setting.callbackFunc([input,inputhide,box,showBtn,clearBtn]);
				}
			}
		},
		
		
		reportComponents :{
			setting :{
				cols:3//默认列数
				
			},
			getParams:function(cpnts){
				var params = {},
					i=0;
				for( i=0;i<cpnts.length;i++) {
					var type = cpnts[i].type;
					switch(type) {
					case 'date':
					case 'input':
					case 'select':
						params[cpnts[i].id] = $('#'+cpnts[i].id).val();
						break;
					case 'ztree':
						var _value = $('#'+cpnts[i].id).val();
						if(_value==''){
							params[cpnts[i].id] = [];
						} else {
							params[cpnts[i].id] = JSON.parse($('#'+cpnts[i].id).val());
						}
						break;
					default:
						continue;
					}
				}
				return params;
			},
			register:function(divId,cpnts){
				var colsNum = jQuery.mbmUtils.reportComponents.setting.cols,
				    btnArr = [],//所有的BTN单独出来作为一行
				    otherArr = [];
				for(var i=0;i<cpnts.length;i++) {
					if(cpnts[i].type == 'button') {
						btnArr[btnArr.length] = cpnts[i].btn;
						continue;
					} else {
						otherArr[otherArr.length] = cpnts[i];
					}
				}
				cpnts = otherArr;
				var _table = $('<table cellpadding="2" cellspacing="1"></table>');
				var rowNum = (cpnts.length%colsNum)==0?cpnts.length/colsNum:Math.floor(cpnts.length/colsNum)+1;
				
				for(var i=0;i<rowNum;i++) {
					var _tr = $('<tr></tr>'),
					    len = cpnts.length>(i+1)*colsNum?(i+1)*colsNum:cpnts.length;
					for(var k=i*colsNum;k<len;k++) {
						if(cpnts[k].type == 'button') {
							btnArr[btnArr.length] = cpnts[k];
							continue;
						}
						_tr.append(cpnts[k].th).append(cpnts[k].td);
					}
					_table.append(_tr);
				}
				
				var _tdBtns = $('<td class="btntd"></td>');
				for(var j=0;j<btnArr.length;j++) {
					_tdBtns.append(btnArr[j]);
				}
				//取每一行加一个TD放BUTTON
				var tabTrArrs = _table.find('tr');
				$.each(tabTrArrs,function(kk,trobj) {
					if(kk < tabTrArrs.length-1) {
						$(trobj).append('<td class="btntd"></td>');
					} else {
						$(trobj).append(_tdBtns);
					}
				});
				//_table.append($('<tr></tr>').append(_tdBtns));
				$('#'+divId).append(_table);
			},
			dateCpnt:function(dateobj,setting){
				setting = jQuery.extend({skin:'whyGreen',dateFmt:'yyyyMM'} , setting);
				var dateFmtStr = "";
				for(var fmattr in setting) {
					if(fmattr == 'callbackFunc' || fmattr == 'style') {
						continue;
					}
					dateFmtStr +=fmattr+":'"+setting[fmattr]+"',";
				}
				dateFmtStr = dateFmtStr.substring(0, dateFmtStr.length -1);
				var _dateSign = $('<input type="text" id="'+dateobj.id+'" class="Wdate" onFocus="WdatePicker({'+dateFmtStr+'})" readonly="readonly"/>');
				/*_dateSign.focus(function(){
					WdatePicker(setting);
				});*/
				var _th = $('<th>'+dateobj.title+'</th>'),
				    _td = $('<td></td>');
				_td.append(_dateSign);
				if(setting && setting.callbackFunc) {
					if(typeof setting.callbackFunc == 'function') {
						setting.callbackFunc(_dateSign);
					}
				}
				if(setting && setting.style) {
					_dateSign.attr('style',setting.style);
				}
				
				return {
					type:'date',
					id:dateobj.id,
					th:_th,
					td:_td
				};
			},
			buttonCpnt:function(obj,setting) {
				setting = jQuery.extend({}, jQuery.ajaxSettings, setting);
				//var _sign = $('<button id="'+obj.id+'" class="ui-button">'+obj.value+'</button>');
				var _sign = $('<input type="button" id="'+obj.id+'" value="&nbsp;'+obj.value+'&nbsp;" class="ui-button"/>');
				if(setting && setting.callbackFunc) {
					if(typeof setting.callbackFunc == 'function') {
						setting.callbackFunc(_sign);
					}
				}
				if(setting && setting.style) {
					_sign.attr('style',setting.style);
				}
				return {
					type:'button',
					id:obj.id,
					btn:_sign
				};
			},
			selectCpnt:function(obj,setting){
				setting = jQuery.extend({}, jQuery.ajaxSettings, setting);
				var _sign = $('<select id="'+obj.id+'" class="cpnt"></select>'),
				    data = obj.data,
				    i=0;
				for(i=0;i<data.length;i++) {
					_sign.append('<option value="'+data[i][obj.valueField]+'">'+data[i][obj.textField]+'</option>');
				}
				var _th = $('<th>'+obj.title+'</th>'),
				    _td = $('<td></td>');
				_td.append(_sign);
				if(setting && setting.callbackFunc) {
					if(typeof setting.callbackFunc == 'function') {
						setting.callbackFunc(_sign);
					}
				}
				if(setting && setting.style) {
					_sign.attr('style',setting.style);
				}
				return {
					type:'select',
					id:obj.id,
					th:_th,
					td:_td
				};
			},
			zTreeCpnt:function(obj,setting,treeSetting){
				treeSetting = jQuery.extend({data: {
					simpleData: {
						enable: true
					}
				}}, jQuery.ajaxSettings, treeSetting);
				
				var tools = {
						setSelectedChecked : function(treeData){
							var val = $('#'+obj.id).val();
							var selectedArr = [],selectedObj = {};
							if(val != '') {
								selectedArr = JSON.parse(val);
							} 
							for(var i=0;i<selectedArr.length;i++) {
								selectedObj[selectedArr[i].value] = selectedArr[i];
							}
							for(var i=0;i<treeData.length;i++) {
								if(!!selectedObj[treeData[i].id]) {
									treeData[i].checked=true;
								} else {
									treeData[i].checked=false;
								}
							}
							if(selectedArr.length > 0) {
								treeData.sort(function(a,b) {
									if(!a.checked && !b.checked) {
										return 0;
									} else if(a.checked && b.checked){
										return 1;
									} else if(a.checked && !b.checked){
										return -1;
									} else if(!a.checked && b.checked){
										return 1;
									} else {
										return 0;
									}
								});
							}
						}
				};
				
				var input = $('<input type="text" id="'+obj.id+'Text" style="width:130px;height:18px;brder-right:0px;"/>'),
					inputhide = $('<input type="hidden" id="'+obj.id+'"  />'),
				  //showBtn = $('<input type="button" style="float:left;"/>'),
					showBtn = $('<span class="ui-notext-button"></span>'),
					//clearBtn = $('<span class="ui-notext-button">-</span>'),
					box = $('<div id="'+obj.id+'BoxDiv" style="display:none;position:absolute;border:1px solid #000000;max-height:300px;min-height:100px;min-width:150px;overflow:auto;background-color:#FFFFFF;"></div>');
				
				   showBtn.append('<img src="/smoc-pc-web/webstatic/images/combo_arrow.png" style="vertical-align:middle;margin:0 auto;text-align:center;"/>');
				   if($.browser.mozilla) {
					   input.css({'paddingTop':'1px','paddingBottom':'2px','height':'19px'});
				   }
				   var pubObj = {
					showTreeMenu:function(){//展示树菜单
						var areaOffset = input.offset();
						box.css('width',input.css('width'));
						box.css({left:areaOffset.left + "px", top:areaOffset.top + input.outerHeight() + "px","z-index":'1500'}).slideDown("fast");
						box.css('display','');
						$("body").bind("mousedown",function(event){
							if (!(event.target.id == obj.id+'BoxDiv'|| $(event.target).parents('#'+obj.id+'BoxDiv').length>0)) {
								box.css('display','none');
				    			$("body").unbind("mousedown");
							}
						});
					}	
				};
				showBtn.click(function(){//展示
					if(setting.initTree && typeof setting.initTree == 'function') {//优先执行initTree
						 setting.initTree(input,$('#'+obj.id+'BoxDiv'),function(datas){
							 	tools.setSelectedChecked(datas);
								$.fn.zTree.init(_sign, treeSetting, datas);
								pubObj.showTreeMenu();
							});
					 } else {//否则每次初始化都显示全量数据
						 if(setting.treeData) {
							 tools.setSelectedChecked(setting.treeData);
							 $.fn.zTree.init(_sign, treeSetting, setting.treeData);
							 pubObj.showTreeMenu();
						 }
					 }
				});
				/**
				clearBtn.click(function(){
					input.val('');
					inputhide.val('');
				});
				*/
				var _sign = $('<ul class="ztree" id="'+obj.id+'_treeId"></ul>');
				box.append(_sign);
				if(!treeSetting.callback) {
					treeSetting.callback = {};
				}
				treeSetting.callback = jQuery.extend(treeSetting.callback, {
					onClick:function(event, treeId, treeNode, clickFlag){
						setting.isInputTextFromKeyboard = false;//标识输入框中的字符变化是否来自键盘的输入
						if(!!treeSetting && !!treeSetting.check) {
							if(!!treeSetting.check.chkStyle && treeSetting.check.chkStyle == 'checkbox')  {
								return;
							}
						}
						if(treeNode){
							$('#'+obj.id+'Text').val(treeNode.name);
							$('#'+obj.id).val(JSON.stringify([{value:treeNode.id,name:treeNode.name}]));
						}
					},
					onDblClick:function(event, treeId, treeNode){
						
						setting.isInputTextFromKeyboard = false;
						if(!!treeSetting && !!treeSetting.check) {
							if(!!treeSetting.check.chkStyle && treeSetting.check.chkStyle == 'checkbox')  {
								return;
							}
						}
						if(treeNode){
							$('#'+obj.id+'Text').val(treeNode.name);
							$('#'+obj.id).val(JSON.stringify([{value:treeNode.id,name:treeNode.name}]));
						}
						$('#'+obj.id+'BoxDiv').css('display','none');
					},
					onCheck:function(event, treeId, treeNode){
						setting.isInputTextFromKeyboard = false;
						var treeObj = $.fn.zTree.getZTreeObj(treeId);
						var nodes = treeObj.getCheckedNodes(true);
						var showName = '',values = [];
						
						for(var i=0;i<nodes.length;i++) {
							showName = showName+nodes[i].name+',';
							values[i] = {value:nodes[i].id,name:nodes[i].name};
						}
						$('#'+obj.id+'Text').val(showName.substring(0, showName.length -1));
						$('#'+obj.id).val(JSON.stringify(values));
					}
				});
				
				input.bind('input propertychange',function(){
					if(setting.isInputTextFromKeyboard){
						if(setting.queryByRealtime && typeof setting.queryByRealtime == 'function') {
							 setting.queryByRealtime(input,$('#'+obj.id+'BoxDiv'),function(datas){
								 	if(input.val() == '') {
										$('#'+obj.id).val('');
									}
								    tools.setSelectedChecked(datas);
									$.fn.zTree.init(_sign, treeSetting, datas);
									pubObj.showTreeMenu();
								});
						 }
					}
				});
				input.keydown(function(event) {
					setting.isInputTextFromKeyboard = true;
	        		   event = event || window.event || arguments.callee.caller.arguments[0];
	        		   if(event.keyCode == 13) {
	        			   if(setting.queryByEnter && typeof setting.queryByEnter == 'function') {
	        				   setting.queryByEnter(input,$('#'+obj.id+'BoxDiv'),function(datas){
	        					   if(input.val() == '') {
		       							$('#'+obj.id).val('');
		       						}
	        					   tools.setSelectedChecked(datas);
			   						$.fn.zTree.init(_sign, treeSetting, datas);
			   						pubObj.showTreeMenu();
			   					});
	        			   }
	        		   }
	        	   });
				
				var _th = $('<th>'+obj.title+'</th>'),
				    _td = $('<td></td>');
				_td.append(input).append(box).append(showBtn).append(inputhide);//.append(clearBtn)
				
				if(setting && setting.callbackFunc) {
					if(typeof setting.callbackFunc == 'function') {
						setting.callbackFunc([input,inputhide,box,showBtn,clearBtn]);
					}
				}
				
				return {
					type:'ztree',
					id:obj.id,
					th:_th,
					td:_td
				};
			}
			
		}
		
	}
});