var xmlHttp;
var request_url = "findPassword.action";
var response_url = "student_person.action";
var role=0;
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function setPassword(){
	var password = document.getElementById("question1").value;
	var comfirm = document.getElementById("question2").value;
	if(password.equals(comfirm)){
		
	}
	else{
		document.getElementById("tip").style.display="block";
		document.getElementById("tip").innerHTML = "两次密码不匹配，请重试";
		document.getElementById("question1").value = "";
		document.getElementById("question2").value = "";
	}
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("POST", request_url+"?password="+password,true);
	xmlHttp.send(null);
}
function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		if(obj.success==true)
			window.location.href = response_url;
	}
}