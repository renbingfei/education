var xmlHttp;
var a = ["","","","","","","","","","","","","","","","",""];
var b = [0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1];
var m = ["","top-item2","top-item1","top-item2","top-item3","top-item3","top-item2","top-item2",
 "top-item2","top-item2","top-item2","top-item2","top-item2","top-item1","top-item1","top-item2"]
var sa = new Array();
var fsa = new Array();
//var schools,enterprises;
 
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function all_info(){
	createXmlHttp();
	xmlHttp.open("GET", "info_all.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function type_info(){
	createXmlHttp();
	xmlHttp.open("GET", "info_type.action",true);			
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.send(null);
}
function id_info(){
	createXmlHttp();
	xmlHttp.open("GET", "info_id.action",true);			
	xmlHttp.onreadystatechange = responseTo3;
	xmlHttp.send(null);
}
function get_enterprise(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_valid_enterprise.action",true);			
	xmlHttp.onreadystatechange = responseTo4;
	xmlHttp.send(null);
}
function responseTo4(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		enterprises = obj.result;
		get("enterprise").innerHTML = "";
		for(var i=enterprises.length;i>0;i--){
			get("enterprise").innerHTML+="<li><a class=\"normal\" href='endetail_en_get.action?id="+enterprises[i-1].id+"'>"+enterprises[i-1].name+"</a></li>";
		}
	}
}
function get_school(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_list_school.action",true);			
	xmlHttp.onreadystatechange = responseTo5;
	xmlHttp.send(null);
}
function responseTo5(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		schools = obj.result;
		get("school").innerHTML="";
		for(var i=schools.length;i>0;i--){			
			get("school").innerHTML+="<li><a class=\"normal\" href='schdetail_sch_get.action?schoolid="+schools[i-1].id+"'>"+schools[i-1].name+"</a></li>";
		}
		get_enterprise();
	}
}

function get_top(){
	createXmlHttp();
	xmlHttp.open("GET", "info_get_tops.action",true);			
	xmlHttp.onreadystatechange = responseTo6;
	xmlHttp.send(null);
}
function responseTo6(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var tops = obj.result;
		for(var i=0; i<tops.length; i++){
			if(tops[i].type!=5){
				if(tops[i].type!=3&&tops[i].type!=2&&tops[i].type!=13&&tops[i].type!=14){
					var contentdetail=tops[i].content.replace(/<[^>]+>/g,"");
					var contentstr = "";
					if(contentdetail.length>50){
						contentstr = contentdetail.substring(0,50);
					}else{
						contentstr = contentdetail;
					}
					a[tops[i].type] = "<div class='"+m[tops[i].type]+"'><img src='"+tops[i].pic+"' /><div class=\"desc\"><div class=\"toptitle\"><a href=\"detail.action?id="+tops[i].id+"\">"+tops[i].title.split(";")[0]+"</a></div><li>"+contentstr+"...</li></div></div>"+a[tops[i].type];
					
				}else
					a[tops[i].type] = "<li><a class=\"top\" href=\"detail.action?id="+tops[i].id+"\">"+tops[i].title.split(";")[0]+"</a></li>"+a[tops[i].type];
			}
			else{
				var vediostr="<object class id=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"300\" height=\"240\">"
					 +"<param name=\"movie\" value=\"flvplayer.swf\">"
					 +"<param name=\"quality\" value=\"high\">"
					 +"<param name=\"allowFullScreen\" value=\"true\">" 
					 +"<param name=\"FlashVars\" value=\"vcastr_file="+tops[i].pic+"&LogoText=www.xdzyjy.cn&BufferTime=3&IsAutoPlay=0\">"
					 +"<embed src=\"flvplayer.swf\" allowfullscreen=\"true\" flashvars=\"vcastr_file="+tops[i].pic+"&LogoText=www.xdzyju.cn&IsAutoPlay=0\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\"></embed>"
					 +"</object><li><a href=\"detail.action?id="+tops[i].id+"\">"+tops[i].title.split(";")[0]+"</a></li>";
				a[tops[i].type] = "<div class='"+m[tops[i].type]+"'>"+vediostr+"</div>"+a[tops[i].type];
			}
		}
		all_info();
	}
}
function get(id){
	return document.getElementById(id);
}
function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var is = obj.result;
		var sindex = 1;
		var findex = 1;
		for(var i=is.length-1;i>=0;i--){
			
			if(is[i].type==1&&sindex<=6){
				get("simg"+sindex).src=is[i].pic;
				var isa = new Array();
				isa["title"] =is[i].title.split(";")[0];
				if(is[i].title.split(";").length>1){
					isa["href"] = is[i].title.split(";")[1]
				}else{
					isa["href"] = "detail.action?id="+is[i].id;
				}
				sa.push(isa);
				if(sindex==1){
					get('sa').innerHTML = sa[0].title;
					get('sa').setAttribute("href",sa[0].href);
					get('sa6').setAttribute("href",sa[0].href);
				}
				sindex++;		
			}
			if(is[i].type==4&&findex<=5){
				get("fsimg"+findex).src=is[i].pic;
				var isa = new Array();
				isa["title"] =is[i].title.split(";")[0];
				isa["href"] = "detail.action?id="+is[i].id;
				fsa.push(isa);
				if(findex==1){
					get('fsa').innerHTML = fsa[0].title;
					get('fsa').setAttribute("href",fsa[0].href);
					get('fsa5').setAttribute("href",fsa[0].href);
				}
				findex++;		
			}
//			if(b[is[i].type]==0){
//				if(is[i].type!=5)
//					a[is[i].type] += "<div class='"+m[is[i].type]+"'><img src='"+is[i].pic+"' /></div>"
//				else{
//					var vediostr="<object class id=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"300\" height=\"240\">"
//						 +"<param name=\"movie\" value=\"flvplayer.swf\">"
//						 +"<param name=\"quality\" value=\"high\">"
//						 +"<param name=\"allowFullScreen\" value=\"true\">" 
//						 +"<param name=\"FlashVars\" value=\"vcastr_file="+is[i].pic+"&LogoText=www.xdzyjy.cn&BufferTime=3&IsAutoPlay=0\">"
//						 +"<embed src=\"flvplayer.swf\" allowfullscreen=\"true\" flashvars=\"vcastr_file="+is[i].pic+"&LogoText=www.xdzyju.cn&IsAutoPlay=0\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\"></embed>"
//						 +"</object>";
//					a[is[i].type] += "<div class='"+m[is[i].type]+"'>"+vediostr+"</div>"
//				}
//			}
			if(is[i].top!=true){
				a[is[i].type] += "<li><a class=\"normal\" href='detail.action?id="+is[i].id+"'>"+/*"["+is[i].date+"]"+*/is[i].title.split(";")[0]+"</a></li>";
				b[is[i].type]++;
			}
		}
		for(var j=2;j<a.length;j++){
			if(get('f'+j)&&j!=4)
				get('f'+j).innerHTML = a[j];
		}
		//if(photos.length>6)
		//	get("listMore").style.display = 'block';
		get_school();
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var result = obj.result;
	}
}
get_top();
cur = 1;
fcur = 1;
finterval = setInterval(fscroll,5000);
interval = setInterval(scroll,5000);

function scroll() {
	for(i = 1;i<=6;i++){
		get('slider'+i).style.opacity = 0;
		get('item'+i).className = "slider-control-item";
	}
	get('slider'+cur).style.opacity = 1;
	get('item'+cur).className = "slider-control-item active";
	if(sa[cur]){
		get('sa').innerHTML = sa[cur-1].title;
		get('sa').setAttribute("href",sa[cur-1].href);
		get('sa6').setAttribute("href",sa[cur-1].href);
	}		
	cur = (cur+1)==7?1:(cur+1);
}
function slide(id){
	clearInterval(interval);
	cur = id;
	scroll();
	interval = setInterval(scroll,5000);
}

function fscroll() {
	for(i = 1;i<=5;i++){
		get('fslider'+i).style.opacity = 0;
		get('fitem'+i).className = "fslider-control-item";
	}
	get('fslider'+fcur).style.opacity = 1;
	get('fitem'+fcur).className = "fslider-control-item active";
	if(fsa[fcur]){
		get('fsa').innerHTML = fsa[fcur-1].title;
		get('fsa').setAttribute("href",fsa[fcur-1].href);
		get('fsa5').setAttribute("href",fsa[fcur-1].href);
	}		
	fcur = (fcur+1)==6?1:(fcur+1);
}
function fslide(id){
	clearInterval(finterval);
	fcur = id;
	fscroll();
	finterval = setInterval(fscroll,5000);
}


//设为首页
function SetHome(obj,vrl){
    try{
    	
        obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
    }
    catch(e){
       if(window.netscape) {
         try {
           netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
         }
         catch (e) {
        	 alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
         }
         var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
         	prefs.setCharPref('browser.startup.homepage',vrl);
         }
    }
}
//function adjust_login_form(id){
//	var login_note = document.getElementById(id);
//	var login_form_width = login_note.clientWidth;
//	var login_form_height = login_note.clientHeight;
//	var left = (window.innerWidth/2 - login_form_width/2) + 'px';
//	var top = (window.innerHeight/2 - login_form_height/2) + 'px';
//	login_note.style.left = left;
//	login_note.style.top = top;
//}
//$(document).ready(function(){	
//	
//	$("#cover").click(function(){
//		var cover_note = document.getElementById('cover');
//		cover_note.style.background = 'rgba(0,0,0,0)'
//		setTimeout(function(){
//			cover_note.style.display = 'none';
//		},500);
//		document.getElementById('schelement').style.top = '-500px';
//		document.getElementById('enelement').style.top = '-500px';
//	})
	

//	window.onresize = function(){
//		if(document.getElementById('cover').style.display == 'block')
//			adjust_login_form();
//	}
	
//}
//);
//function show_school(id,schindex){
//	var cover_note = get('cover');
//	cover_note.style.display = 'block';
//	setTimeout(function(){
//		cover_note.style.background = 'rgba(0,0,0,0.8)'
//	},0);
//	adjust_login_form("schelement");
//	get("schicon").src = schools[schindex].icon;
//	get("schname").innerHTML = schools[schindex].name;
//	get("schdesc").innerHTML = schools[schindex].descs;
//}
//function show_enterprise(id,enindex){
//	var cover_note = get('cover');
//	cover_note.style.display = 'block';
//	setTimeout(function(){
//		cover_note.style.background = 'rgba(0,0,0,0.8)'
//	},0);
//	adjust_login_form("enelement");
//	get("enicon").src = enterprises[enindex].url;
//	get("enname").innerHTML = enterprises[enindex].name;
//	get("enaddress").innerHTML = enterprises[enindex].address;
//	get("endesc").innerHTML = enterprises[enindex].info;
//}