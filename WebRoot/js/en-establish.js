function show_datepicker(){
	document.getElementById("datepicker").style.top = "330px";
}
function establish(){
	if(document.getElementById("emtitle").value=="")
		alert("标题不能为空！");
	else if(document.getElementById("emcontent").value=="")
		alert("内容不能为空！");
	else if(document.getElementById("dateup").value=="")
		alert("请选择截止时间！");
	else if(!date_cmp(document.getElementById("dateup").value))
		alert("请选择有效日期！");	
	else
		document.getElementById("establishform").submit();
}

function date_cmp(sdate){
	var dates = sdate.split("-");
	var now = new Date();
	if(dates[0]<now.getFullYear())
		return false;
	else if(dates[0]>=now.getFullYear()&&dates[1]<(now.getMonth()+1))
		return false;
	else if(dates[0]>=now.getFullYear()&&dates[1]>=(now.getMonth()+1)&&dates[2]<now.getDate())
		return false;
	else return true;
}

$(document).ready(function(){
	$( "#datepicker" ).datepicker({
		inline: true,
		numberOfMonths:1,//显示几个月  
	    showButtonPanel:true,//是否显示按钮面板  
	    dateFormat: 'yy-mm-dd',//日期格式  
	    clearText:"清除",//清除日期的按钮名称  
	    closeText:"关闭",//关闭选择框的按钮名称  
	    yearSuffix: '年', //年的后缀  
	    showMonthAfterYear:true,//是否把月放在年的后面  
	    monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],  
	    dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
	    dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
	    dayNamesMin: ['日','一','二','三','四','五','六'],  
	    onSelect: function(selectedDate) {//选择日期后执行的操作  
	                document.getElementById("datepicker").style.top = "1280px";
	                document.getElementById("dateup").setAttribute("value",selectedDate);
	            }        
	});	
});