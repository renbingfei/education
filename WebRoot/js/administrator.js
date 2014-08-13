var xmlHttp;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function get_info(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_get_info.action",true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}

function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		
		var result = obj.result;
		var numbers = result.split("#");
		get("stn").innerHTML = numbers[0];
		get("rsn").innerHTML = numbers[1];
		get("epn").innerHTML = numbers[2];
		get("rcn").innerHTML = numbers[3];
	}
}

function get(id){
	return document.getElementById(id);
}

get_info();