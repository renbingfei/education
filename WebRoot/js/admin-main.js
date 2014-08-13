var xmlHttp;
var infotag;
var inspector;
var exist = 0;
var flag = 0;

function change(sender){
	exist = 1;
}

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function get_pic(){
	createXmlHttp();
	xmlHttp.open("GET", "pic_get.action?infotag="+infotag,true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}

function select(sender){
	//get("titleinput").disabled = "value";
	if(sender.selectedIndex==4){
		document.getElementById("coverpic").innerHTML="添加视频";
	}else{
		document.getElementById("coverpic").innerHTML="封面图片";
	}
	if(sender.selectedIndex==1||sender.selectedIndex==2||sender.selectedIndex==12||sender.selectedIndex==13||sender.selectedIndex==16){
		get("picdiv").style.display = "none";
		get("linkdiv").style.display="none";
		get("mceu_150").style.top="254px";
		flag = 1;		
	}else{
		get("picdiv").style.display = "block";
		if(sender.selectedIndex==0){
			get("linkdiv").style.display="inline-block";
			get("mceu_150").style.top="356px";
		}else{
			get("linkdiv").style.display="none";
			get("mceu_150").style.top="310px";
		}
		flag = 0;
	}
	if(sender.selectedIndex!=0&&sender.selectedIndex!=3&&sender.selectedIndex!=4){
		exist=1;
	}else exist=0;
	//登录界面
//	if(sender.selectedIndex==16){
//		get("picdiv").style.display = "none";
//		get("linkdiv").style.display="none";
//		//get("titleinput").value = "公告";
//		get("mceu_150").style.top="254px";
//	}
	
}

function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var pic = obj.result[0];
		var idocument =document.getElementsByTagName("iframe")[1].contentWindow.document;
		var ibody = idocument.getElementsByTagName("body")[0];
		var iimg = idocument.createElement("img");
		iimg.setAttribute("src",pic.detail);
		iimg.setAttribute("class","dimg");
		iimg.setAttribute("style","float:center;width:400px;height:200px")
		ibody.appendChild(iimg);
	}
}

function doing(){
	get("uploadStatus").setAttribute("src","submitting.jsp");
	inspector = setInterval(function(){
		var status_text=get("uploadStatus").contentWindow.document.getElementsByTagName("body")[0].innerHTML;
		if(status_text.search(/成功/)>=0){
			window.clearInterval(inspector);
			get_pic();
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			get('element').style.top = '-500px';
		}
	},1000)
	
};

$(document).ready(function(){	
	
	$("#cover").click(function(){
		var cover_note = document.getElementById('cover');
		cover_note.style.background = 'rgba(0,0,0,0)'
		setTimeout(function(){
			cover_note.style.display = 'none';
		},500);
		document.getElementById('element').style.top = '-500px';
	})
	

	window.onresize = function(){
		if(document.getElementById('cover').style.display == 'block')
			adjust_login_form();
	}
	
	setInterval(function(){
		get("conup").setAttribute("value",document.getElementsByTagName("iframe")[1].contentWindow.document.getElementsByTagName("body")[0].innerHTML)
		if((exist==1||flag==1)&&get("title").value!=""&&get("conup").value!=""){
			get("uplabel").style.display = "none";
			get("newsup").style.display = "block";
		}else{
			get("newsup").style.display = "none";
			get("uplabel").style.display = "block";		
		}
	},500);
	
}
);

//function checkhttp(){
//	var linkstr = get("link").value;
//	if(linkstr!=""){
//		if(linkstr.split(":")[0]!="http"){
//			alert("请填写完整链接地址\n例如：http://www.baidu.com")
//			return false;
//		}
//	}
//	return true;
//}

function adjust_login_form(){
	var login_note = document.getElementById('element');
	var login_form_width = login_note.clientWidth;
	var login_form_height = login_note.clientHeight;
	var left = (window.innerWidth/2 - login_form_width/2) + 'px';
	var top = (window.innerHeight/2 - login_form_height/2) + 'px';
	login_note.style.left = left;
	login_note.style.top = top;
}

function setTag(){
	return new Date().getTime();
}


function get(id){
	return document.getElementById(id);
}

tinymce.init({
	selector:'textarea.editme',
	language:'zh_CN',
	menubar : false,
	statusbar : false,
	width : 610,
	height : 282,
	theme: "modern",
	plugins: "emoticons, anchor, charmap, paste, pagebreak, searchreplace,spellchecker, visualblocks, visualchars, fullscreen, insertdatetime, nonbreaking, table, directionality, textcolor, hr, preview, print, fullpage, layer, lists",
	paste_data_images: false,
	pagebreak_separator: "<!-- my page break -->",
	insertdatetime_formats: ["%Y.%m.%d", "%H:%M"],
	toolbar1: "fontselect ,|, fontsizeselect ,|, styleselect ,|, table ,|, emoticons charmap ,|, insertlayer ,|, ltr rtl ",
	toolbar2:  "bold italic underline strikethrough ,|, forecolor backcolor ,|, alignleft aligncenter alignright alignjustify ,|, bullist numlist outdent indent ,|, print",
	toolbar3: " undo redo ,|, cut,copy,pasteword,pastetext ,|, insertdatetime, preview,|, searchreplace, spellchecker,|, visualblocks, visualchars ,|, anchor, hr,  pagebreak, nonbreaking",
//	toolbar4: " , fullpage",
	init_instance_callback : function(editor) {
        $("#displayCover").click(function(){
    		infotag = setTag();
    		var cover_note = get('cover');
    		cover_note.style.display = 'block';
    		setTimeout(function(){
    			cover_note.style.background = 'rgba(0,0,0,0.8)'
    		},0);
    		adjust_login_form();
    		get('infotag').setAttribute("value",""+infotag);
    		return false;
    	});
	}
});
