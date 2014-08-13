var xmlHttp;
var request_url = "admin_login.action";
var response_url = "admin-index.jsp";
var role=0;
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function login(){
	var id = document.getElementById("id").value;
	var password = document.getElementById("password").value;
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("POST", request_url+"?userid="+id+"&password="+password ,true);
	xmlHttp.send(null);
}
function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		if(obj.success==true)
			window.location.href = response_url;
		else{
			document.getElementById("tip").style.display="block";
			document.getElementById("tip").innerHTML = "用户名或密码有误！";
		}
	}
}