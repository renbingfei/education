var xmlHttp;
var hasVideo = false;
var content;
var array_video_id = new Array();
var wrap = '<div id="sharedContent">';

var array_video = new Array();

//list_friends_status();
list_my_videos();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function list_friends_status(){
	createXmlHttp();
	xmlHttp.open("GET", "status_friend.action",true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}
function get(id){
	return document.getElementById(id);
}
function list_my_status(){
	createXmlHttp();
	xmlHttp.open("GET", "status_my.action",true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);	
}
function list_my_videos(){	
	getVideo();
}
/*
function get_comments(id){
	if(get("comment").innerHTML == ""){
		createXmlHttp();
		xmlHttp.open("GET", "comment_list.action?id="+id,true);			
		xmlHttp.onreadystatechange = responseTo2;
		xmlHttp.send(null);
	}
	flag = get("comment").style.display;
	if(flag=="none"){
		get("comment").style.display = "block";
		get("control").innerHTML = "收起评论";
	}
	else{
		get("comment").style.display = "none";
		get("control").innerHTML = "展开评论";
	}
}*/
function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var ss = obj.result;
		for(var i=0;i<ss.length;i++){
			html += '<div class="status"><div class="status-header clearfix"><div class="status-avatar">'
			+'<img src="'+ss[i].url+'" /></div><div class="status-message"><div class="status-content-name">'
			+ss[i].name+'</div><div class="status-content-description">在'+ss[i].date+'发表了标题为“'
			+ss[i].title+'”的日志</div></div></div><div class="status-content">'+ss[i].content+'</div>'
			+'<div class="status-comment-control"><a href="javascript:void(0)" id="control">'
			+'暂不支持评论功能</a></div><div id="comment" style="display:block"></div>';
		}
		if(html==""){
			html = "没有新状态！！！";
		}
		get("right").innerHTML = html;
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
	}else{
		
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var ss = obj.result;
		for(var i=0;i<ss.length;i++){
			html += '<div class="status-bottom clearfix"><div class="status-avatar"><img src="'
				+'image/123.jpg'+'" /></div><div class="status-message"><div class="status-content-name">'
			    +'云淡风轻'+'评论了我的日志</div><div class="status-content-description">'
			    +'content'+'</div></div></div>';
		}
		if(html==""){
			html = "没有收到任何评论！！！";
		}
		get("comment").innerHTML = html;
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
	}
}
function responseTo3(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var result = obj.result;
		if(result){
			alert("删除成功！");
			var note = get("video"+deleteid);
			get("sharedContent").removeChild(note);
		}
	}
}
function setVideo(){
	//content = '<embed src="http://player.youku.com/player.php/Type/Folder/Fid/22433128/Ob/1/sid/XNzI5MDg5ODY0/v.swf" quality="high" width="480" height="400" align="middle" allowScriptAccess="always" allowFullScreen="true" mode="transparent" type="application/x-shockwave-flash"></embed>';
	if(xmlHttp.readyState==4){
		hasVideo = true;
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		content = "";
		var ss = obj.result;

		if(ss==""){
			hasVideo = false;
			initialVideoContent();
			return;
		}
		
		content += wrap;
		for(var i=0;i<ss.length;i++){
			content += '<div id="video'+ss[i].id+'">';
			content += ss[i].url;
			content += '<div class="description"><a href="javascript:deletephoto('+ss[i].id+')">删除'+'</a></div></div>';
			array_video_id.push(ss[i].id);
			array_video.push(ss[i].url);
		}
		content += '</div>';
		get("right").innerHTML = content;
	}
}
function getVideo(){
	createXmlHttp();
	xmlHttp.open("GET", "listvideo.action",true);			
	xmlHttp.onreadystatechange = setVideo;
	xmlHttp.send(null);	
}
function initialVideoContent(){
	var cover_note = document.getElementById('cover');
	cover_note.style.display = 'block';
	setTimeout(function(){
		cover_note.style.background = 'rgba(0,0,0,0.8)'
	},0);
	adjust_share_form();
	return false;
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
function shareVideo(){
	val = document.getElementById("shareContent").value;
	if(!testReg(val)){
		alert("不正确的视频分享代码");
		return;
	}

	document.video_content_form.submit();

	document.getElementById("shareContent").value = "";
	hasVideo = true;
	
	//隐藏分享框
	var cover_note = document.getElementById('cover');
	cover_note.style.background = 'rgba(0,0,0,0)'
	setTimeout(function(){
		cover_note.style.display = 'none';
		//window.history.go(0);
	},500);
	document.getElementById('element').style.top = '-500px';
	sleep(1000);
	getVideo();
}
function testReg(str){
	re1 = new RegExp("(^<embed)", "g");
	re2 = new RegExp("(embed>)$", "g");
	re3 = new RegExp("^<iframe", "g");
	re4 = new RegExp("(iframe>)$", "g");
	result1 = str.match(re1);
	result2 = str.match(re2);
	result3 = str.match(re3);
	result4 = str.match(re4);
	return ((result1&&result2) || (result3&&result4));
}
function deletephoto(id){
	createXmlHttp();
	deleteid = id;
	xmlHttp.open("GET", "deletephoto.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo3;
	xmlHttp.send(null);
}