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
	xmlHttp.open("GET", "ephoto_list.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function deleteEPhoto(id){
	createXmlHttp();
	deleteid = id;
	xmlHttp.open("GET", "ephoto_delete.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo2;
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
			html += '<div id="photo'+photos[i].id+'" class="photo"><img src="'+photos[i].url+'"></img></div>';
		}
		if(html==""){
			html = "您的相册还没有照片哦！点击上传照片，轻松上传！";
		}
		get("enterprise_photo").innerHTML = html;
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var result = obj.result;
		if(result){
			alert("删除成功！");
			var note = get("photo"+deleteid);
			get("enterprise_photo").removeChild(note);
		}
	}
}