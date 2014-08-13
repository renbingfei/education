var xmlHttp;
listfriend();
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
	xmlHttp.open("POST", "stuphoto_listfour.action" ,true);
	xmlHttp.send(null);
}
function responseTo(){
	var photocontainer = get("photocontainer");
	if(xmlHttp.readyState==4){
		if(xmlHttp.status == 200){
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var result = obj.result;
			if(result == "null"){
				photocontainer.innerHTML = "您的相册还没有照片哦！"
			}else{
				photocontainer.innerHTML = "";
				for(i=0;i<result.length;i++){
					photocontainer.innerHTML += "<div class=\"photo\"><img src=\""+result[i].url+"\" /></div>"
				}
			}
			}else
				photocontainer.innerHTML = "获取相册出现错误！";
	}
	
}
function listfriend(){
	createXmlHttp();
	xmlHttp.open("GET", "listfriend.action",true);			
	xmlHttp.onreadystatechange = responseTo3;
	xmlHttp.send(null);
}
function get(id){
	return document.getElementById(id);
}

function responseTo3(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		console.log(obj);
		console.log("...........");
		var info = obj.friendinfo.friendinfo;
		for(var index=0;index<info.length&&index<7;index++){
			html +='<div id="'+info[index].studentid;
			console.log("=======================");
			html +='" class="friend" onmouseover="this.style.cursor=\'hand\'" onclick="window.location.href=\'student_friendphoto.action?studentid='+info[index].studentid;
			console.log("========================");
			html +='\'"><img src="'+info[index].avatar;
			html +='"/><span>'+info[index].name;
			html +='</span></div>';
		}
		if(html==""){
			html = "您的好友还没有上传照片！";
		}
		get("friendlist").innerHTML = html;
		listfour();
	}
}

function update_avatar(){
	var cover_note = document.getElementById('cover');
	cover_note.style.display = 'block';
	setTimeout(function(){
		cover_note.style.background = 'rgba(0,0,0,0.8)'
	},0);
	adjust_share_form();
}
function upload_avatar(){
	//document.updateAvatar.submit();
	get("uploadStatus").setAttribute("src","submitting.jsp");
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			get('element').style.top = '-500px';
			setTimeout(function(){
				window.history.go(0);
			},500);
}
function adjust_share_form(){
	var login_note = document.getElementById('element');
	var login_form_width = login_note.clientWidth;
	var login_form_height = login_note.clientHeight;
	var left = (window.innerWidth/2 - login_form_width/2) + 'px';
	var top = (window.innerHeight/2 - login_form_height/2) + 'px';
	login_note.style.left = left;
	login_note.style.top = top;
}
function dismiss(){
	var cover_note = document.getElementById('cover');
	cover_note.style.background = 'rgba(0,0,0,0)'
	setTimeout(function(){
		cover_note.style.display = 'none';
		window.history.go(0);
	},500);
	document.getElementById('element').style.top = '-500px';
}
