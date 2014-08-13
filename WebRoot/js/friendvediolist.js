var xmlHttp;
var deleteid;
friendphotos();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function friendphotos(){
	createXmlHttp();
	xmlHttp.open("GET", "listphoto.action",true);			
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
		console.log(obj);
		var photos = obj.result;
		for(var i=0;i<photos.length;i++){
			html += '<div id="photo'+photos[i].id+'" class="photo"><img src="'+photos[i].url+'"><div class="description">'
			+photos[i].date+'<a href="javascript:deletephoto('+photos[i].id+')">删除</a></div></div>';
		}
		if(html==""){
			html = "您的相册还没有照片哦！点击上传照片，轻松上传！";
		}
		get("photolist").innerHTML = html;
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
			get("photolist").removeChild(note);
		}
	}
}
