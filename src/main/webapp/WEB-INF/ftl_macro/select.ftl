<#macro singleSelect option=[]>
	<select style="width:180px">
	   <#list option as opt>
	     <option value=${opt.code!}>${opt.code!} ${opt.value!}</option>
	   </#list>
	</select>
</#macro>