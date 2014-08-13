var xmlHttp;

listEmployments();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listEmployments(){
	createXmlHttp();
	xmlHttp.open("GET", "find.action",true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}
function get(id){
	return document.getElementById(id);
}
function employ_info(id){
	createXmlHttp();
	xmlHttp.open("GET", "employ_info.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.send(null);
}
function employ_join(id){
	createXmlHttp();
	xmlHttp.open("GET", "record_add.action?employid="+id,true);			
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState==4){
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			if(obj.result){
				alert("简历投递成功！");
				window.history.go(0);
			}
			else{
				alert("您已经投递过该简历！");
				window.history.go(0);
			}
		}
	};
	xmlHttp.send(null);
}
function responseTo(){
	if(xmlHttp.readyState==4){
		
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var enlist = get("wanted-list");
		var records = obj.result;
		var calc = 0;
		var size = records.length;
		var html = '';

		if(records=="null"){
			enlist.innerHTML = "";
		}else{
			html = '<ul class="fontNone xw " style="width:680px">';
			var itemNum = (records.length > 10)?10:records.length;
			for(i=0;i<itemNum;i++){
				html += '<li><a href="http://www.xdzyjy.cn:8080/education/enterprise.action?eid='
									  +records[i].enterpriseid+'" target="_blank">'+records[i].ename+'</a><br>'+records[i].title+'</br></li>';
			}
			html += '</ul>';
			enlist.innerHTML += html;
		}
				
				
		
		
	}	
		
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var es = obj.result;
		var cover_note = document.getElementById('cover');
		cover_note.style.display = 'block';
		setTimeout(function(){
			cover_note.style.background = 'rgba(0,0,0,0.8)'
		},0);
		adjust_login_form();
		if(es.length==0)
			html = "信息出错喽！！";			
		else{
			html += "<tr><td>日期：</td><td colspan='4'>"+es.date+"</td></tr>"
			+"<tr><td>公司名称：</td><td colspan='4'>"+es.ename+"</td></tr>"
			+"<tr><td>标题：</td><td colspan='4'>"+es.title+"</td></tr>"
			+"<tr><td>内容：</td><td colspan='4' style='height:156px'>"+es.content+"</td></tr>"
			+"<tr><td>截止日期：</td><td colspan='4'>"+es.deadline+"</td></tr>"
			+"<tr><td colspan='4' style='border:0'><a href='javascript:employ_join("+es.id
			+")' class='join'>投递简历</a></td></tr>";
		}
		get("info").innerHTML = html;
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
	}
}
function adjust_login_form(){
	var login_note = document.getElementById('element');
	var login_form_width = login_note.clientWidth;
	var login_form_height = login_note.clientHeight;
	var left = (window.innerWidth/2 - login_form_width/2) + 'px';
	var top = (window.innerHeight/2 - login_form_height/2) + 'px';
	login_note.style.left = left;
	login_note.style.top = top;
}

window.onresize = function(){
	if(document.getElementById('cover').style.display == 'block')
		adjust_login_form();
}




