var xmlHttp;
var deleteid;
listEPhoto();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listEPhoto(){
	createXmlHttp();
	xmlHttp.open("GET", "ephoto_list1.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function get(id){
	return document.getElementById(id);
}
function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var photos = obj.result;
		for(var i=0;i<photos.length;i++){
			html += '<div id="photo'+photos[i].id+'" class="photo"><img src="'+photos[i].url+'"><div class="description">'
			+photos[i].date+'</div></div>';
		}
		if(html==""){
			html = "企业相册中没有相片！";
		}
		get("photolist").innerHTML = html;
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
	}
}