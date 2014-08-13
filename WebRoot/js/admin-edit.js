var xmlHttp;
var infotag;
var inspector;
var selector=0;
var resultList = new Array();

listTopEnterprise();

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function select(){
	selector = get("selector").value;
	if(selector == "0")
//		list_all_enterprise();
		listTopEnterprise();
	else
		get_list();
		
}

function get_list(){
	createXmlHttp();
	xmlHttp.open("GET", "get_list.action?type="+selector,true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}

function listfour(){
	createXmlHttp();
	xmlHttp.onreadystatechange = getOtherEn;
	xmlHttp.open("GET", "get_rec_en_false.action?" ,true);
	xmlHttp.send(null);
}

function getOtherEn(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status == 200){
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var html = "";
			var result = obj.en_list_false;
			
			for(var i = 0; i < result.length; i++){
				resultList.push(result[i]);
			}	
			
			for(var i = 0; i<resultList.length; i++){
				html += '<a class="title" href="enterprise.action?eid='+resultList[i].id+'">'+resultList[i].name+'</a>'
					+'<a class="top" href="javascript:setTopEnterprise('+resultList[i].id+')">置顶</a>';
				if(!resultList[i].recommend)
					html += '<a class="top" href="javascript:setRecEnterprise('+resultList[i].id+')">推荐</a>';
				else
					html += '<a class="top" href="javascript:unSetRecEnterprise('+resultList[i].id+')">取消推荐</a>';
			}
			
			get("newslist").innerHTML=html;
		}else
			get("newslist").innerHTML = "";
	}
}

function listTopEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = getTopEn;
	xmlHttp.open("POST", "get_top_en.action?top=true" ,true);
	xmlHttp.send(null);
}
function getTopEn() {
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

function listRecEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = getRecEn;
	xmlHttp.open("POST", "get_rec_en.action?recommend=true" ,true);
	xmlHttp.send(null);
}
function getRecEn() {
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

function list_all_enterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo4;
	xmlHttp.open("GET", "listAllEnterprise.action?" ,true);
	xmlHttp.send(null);
}

function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		console.log(response);
		var obj = eval('('+response+')');
		var informations = obj.result;
		var html = "";
		for(var i=informations.length; i>0; i--){
			html += "<a class=\"title\" href=\"javascript:neededit("+informations[i-1].id+")\">"+informations[i-1].title.split(";")[0]+"&nbsp&nbsp&nbsp&nbsp"+informations[i-1].date+"</a><a class=\"top\" href=\"infoup_top.action?id="+informations[i-1].id+"&type="+informations[i-1].type+"\">置顶</a><a class=\"del\" href=\"infoup_delete.action?id="+informations[i-1].id+"&type="+informations[i-1].type+"\">删除</a>";
		}
		get("newslist").innerHTML=html;
	}
}

function responseTo4(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		console.log(response);
		var obj = eval('('+response+')');
		var informations = obj.enlist;
		var html = "";
		for(var i = 0; i<informations.length; i++){
			html += '<a class="title" href="enterprise.action?eid='+informations[i].id+'">'+informations[i].name+'</a>'
				+'<a class="top" href="javascript:setTopEnterprise('+informations[i].id+')">置顶</a>';
			if(!informations[i].recommend)
				html += '<a class="top" href="javascript:setRecEnterprise('+informations[i].id+')">推荐</a>';
			else
				html += '<a class="top" href="javascript:unSetRecEnterprise('+informations[i].id+')">取消推荐</a>';
		}
		get("newslist").innerHTML=html;
	}
}

function setTopEnterprise(id){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo5;
	xmlHttp.open("GET", "set_top_en.action?eid="+id ,true);
	xmlHttp.send(null);
}

function setRecEnterprise(id){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo5;
	xmlHttp.open("GET", "set_rec_en.action?eid="+id+"&rec=true" ,true);
	xmlHttp.send(null);
}

function unSetRecEnterprise(id){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo5;
	xmlHttp.open("GET", "set_rec_en.action?eid="+id+"&rec=false" ,true);
	xmlHttp.send(null);
}

function responseTo5(){
//	window.history.go(0);
//	list_all_enterprise();

	if(xmlHttp.readyState==4){
		if(xmlHttp.status == 200){
			alert("操作成功");
			location.reload(true);	
		}
	}
}

function neededit(id){
	createXmlHttp();
	xmlHttp.open("GET", "need_edit.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.send(null);
}

function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var information = obj.result;
		var titlelink = information.title.split(";");
		get("part1").style.display="none";
		get("part2").style.display="block";
		get("title").setAttribute("value",titlelink[0]);	
		if(selector==1){
			get("mceu_150").style.top="221px";
			if(titlelink.length>1){
				get("linkdiv").style.display="inline-block";				
				get("link").setAttribute("value",titlelink[1]);
			}		
		}else{
			get("linkdiv").style.display="none";
		}
		get("idup").setAttribute("value",information.id);
		var idocument =document.getElementsByTagName("iframe")[1].contentWindow.document;
		var ibody = idocument.getElementsByTagName("body")[0];
		var idiv = idocument.createElement("div");
		idiv.innerHTML = information.content;
		ibody.appendChild(idiv);
	}
}

function get_pic(){
	createXmlHttp();
	xmlHttp.open("GET", "pic_get.action?infotag="+infotag,true);			
	xmlHttp.onreadystatechange = responseTo3;
	xmlHttp.send(null);
}

function responseTo3(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		console.log(response);
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
}

$(document).ready(function(){
	select();
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
	},1000)

}
);

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
