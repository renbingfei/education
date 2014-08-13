var xmlHttp;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function list(){
	createXmlHttp();
	xmlHttp.open("GET", "info_list.action?type="+type,true);
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}
function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var results = obj.result;
		var html = "";
		for(var i=results.length;i>0;i--){
			html="<li><a href=\"detail.action?id="+results[i-1].id+"\">"+results[i-1].title.split(";")[0]+"</a></li>"
			document.getElementById("list").innerHTML+=html;
		}
	}
}