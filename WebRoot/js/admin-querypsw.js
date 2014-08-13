var xmlHttp;
var flag=0;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function resetEnterprisePSW(){
	
	createXmlHttp();
	
	xmlHttp.open("POST", "resetEnPSW.action?enterpriseemail="+get("eid").value,true);
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}

function resetStudentPSW(){

	createXmlHttp();

	xmlHttp.open("POST", "resetStuPSW.action?studentid="+get("sid").value,true);
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}


function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var result = obj.result;
		if(result==true){
			alert("成功");
		}
	
		else{
			alert("重置失败，请检查输入的用户名是否正确");
		}
	}
}


function select(i){
	get("page"+i).style.display="block";
	get("sch"+i).style.opacity="1";
	if(i==1)i=2;
	else i=1;
	get("page"+i).style.display="none";
	get("sch"+i).style.opacity="0.5";
	
}

function get(id){
	return document.getElementById(id);
}

