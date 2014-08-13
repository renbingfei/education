var xmlHttp;
var request_url = ["stu_login.action","en_login.action","admin_login.action"];
var response_url = ["student_person.action","en-person.jsp","admin-index.jsp"];
var role=0;
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function select(id){
	for(var i=0;i<3;i++)
		document.getElementById("role"+i).className = "negative";
	document.getElementById("role"+id).className="positive";
	role = id;
}
function login(){
	var id = document.getElementById("id").value;
	var password = document.getElementById("password").value;
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("POST", request_url[role]+"?userid="+id+"&password="+password ,true);
	xmlHttp.send(null);
}
function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		if(obj.success==true)
			window.location.href = response_url[role];
		else{
			document.getElementById("tip").style.display="block";
			document.getElementById("tip").innerHTML = "用户名或密码有误！";
		}
	}
}

function get_notice(){
	createXmlHttp();
	xmlHttp.open("GET", "showNotice.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		notice = obj.result;
		var noticecontent = get("noticecontent");
		html = "";
		html += notice[0].title + ":\n";
		html += notice[0].content;
		
		noticecontent.innerHTML = html;
	}
}
function get(id){
	return document.getElementById(id);
}
get_notice();