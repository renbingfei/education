var xmlHttp;
var resultList = new Array();  //所有记录的集合，包括置顶、推荐、普通三种类型的企业

listTopEnterprise();

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listfour(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("GET", "get_rec_en_false.action?" ,true);
	xmlHttp.send(null);
}
function listTopEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.open("POST", "get_top_en.action?top=true" ,true);
	xmlHttp.send(null);
}
function listRecEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.open("POST", "get_rec_en.action?recommend=true" ,true);
	xmlHttp.send(null);
}

//function responseTo(){
//	var encontainer = get("en-list");
//	if(xmlHttp.readyState==4){
//		if(xmlHttp.status == 200){
//		var response = xmlHttp.responseText;
////		console.log(response);
//		var obj = eval('(' + response + ')');
//		var result = obj.enlist;
//		var html = '';
//		if(result=="null"){
//			html = "";
//		}else{
//			html = "";
//			var itemNum = (result.length > 10)?10:result.length;
//			html += '<ul class="fontNone xw " style="width:680px">';
//			for(i=0;i<itemNum;i++){
//				html += '<li><a href="http://125.39.151.18:8080/education/enterprise.action?eid='
//									  +result[i].id+'" target="_blank">'+result[i].name+'</a></li>';
//			}
//			html += '</ul>';
//		}
//		encontainer.innerHTML = html;
//		}else
//			encontainer.innerHTML = "";
//	}
//}

function responseTo(){
	var encontainer = get("en-list");
	if(xmlHttp.readyState==4){
		if(xmlHttp.status == 200){
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var html = "";
			var result = obj.en_list_false;
			
			for(var i = 0; i < result.length; i++){
				resultList.push(result[i]);
			}	
			
			html = "";
			var itemNum = (resultList.length > 10)?10:resultList.length;
			html += '<ul class="fontNone xw " style="width:680px">';
			for(i=0;i<itemNum;i++){
				html += '<li><a href="http://www.xdzyjy.cn:8080/education/enterprise.action?eid='
									  +resultList[i].id+'" target="_blank">'+resultList[i].name+'</a></li>';
			}
			html += '</ul>';
			
			if(html==""){
				encontainer.innerHTML = "";
			}
			encontainer.innerHTML = html;
		}else
			encontainer.innerHTML = "";
	}
}

function responseTo1() {
	var encontainer = get("allenlist");
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var html = "";
			var result = obj.top_en;
			for(var i = 0; i < result.length; i++){
				resultList.push(result[i]);
			}

			listRecEnterprise();
		}
	} else{
//		encontainer.innerHTML = "";
	}
}

function responseTo2() {
//	var encontainer = get("allenlist");
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var html = "";
			var result = obj.rec_en;
			for(var i = 0; i < result.length; i++){
				resultList.push(result[i]);
			}	

			listfour();
		}
	} else{
//		encontainer.innerHTML = "";
	}
}

function get(id){
	return document.getElementById(id);
}
