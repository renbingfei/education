var xmlHttp;
var encurrentindex,entotal;
var emcurrentindex,emtotal;
var currentindex,total;		//分页当前显示的页码和总页数
var lastindex=1;		//删除照片所在页的页码;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function get_accept(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_en_aem.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function get_naccept(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_en_nem.action",true);			
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.send(null);
}

function responseTo1(){
//	if(xmlHttp.readyState==4){
//		var response = xmlHttp.responseText;
//		var obj = eval('('+response+')');
//		var enterprises = obj.enterprises;		
//		var num = obj.num;
//		var container = get("container1");
//		container.innerHTML="";
//		for(var i=0;i<enterprises.length;i++){
//			container.innerHTML += "<a href=\"javascript:list_aem(\'"+enterprises[i]+"\')\" class=\"ename\">"+enterprises[i].split("@")[0]+"</a><a class=\"renum\">"+num[i]+"个职位</a>";
//		}
//	}
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var enterprises = obj.enterprises;		
		var num = obj.num;
		//var container = get("container1");
		var employlist = get("employlist1");
		employlist.innerHTML="";
		total = Math.ceil(enterprises.length/6);		//计算分页的总页数
		//container.style.display = "block";
		//get("container2").style.display = "none";
		var html = "";
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
		
		
			for(var i=0;i<6;i++){
				if(6*tempindex+i>=enterprises.length)break;	//此时说明所有图片都添加完毕
				html += "<a href=\"javascript:list_aem(\'"+enterprises[6*tempindex+i]+"\')\" class=\"ename\">"+enterprises[6*tempindex+i].split("@")[0]+"</a><a class=\"renum\">"+num[6*tempindex+i]+"个职位</a>";
			}
			html+='</div>';
			employlist.innerHTML += html;

		}
		
		//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
		if((enterprises.length/6)<=7){
			creatPageBar("RJ-pagebar1", Math.ceil(enterprises.length/6),lastindex,Math.ceil(enterprises.length/6),show_page);
		}else{
			creatPageBar("RJ-pagebar1", enterprises.length/6,lastindex,7,show_page);
		}
	}
}
function responseTo2(){
//	if(xmlHttp.readyState==4){
//		var response = xmlHttp.responseText;
//		var obj = eval('('+response+')');
//		var enterprises = obj.enterprises;		
//		var num = obj.num;
//		var container = get("container2");
//		container.innerHTML="";
//		for(var i=0;i<enterprises.length;i++){
////			for(var j=0;j<enterprises.length;j++){
//				container.innerHTML += "<a href=\"javascript:list_nem(\'"+enterprises[i]+"\')\" class=\"ename\">"+enterprises[i].split("@")[0]+"</a><a class=\"renum\">"+num[i]+"个职位</a>";
////				if(employments[j].enterpriseid==enterprises[i].id){
//////					html+="<div id=\""+employments[j].id+"\" class=\"block\"><table class=\"entable1\"><tr><td>"+employments[j].title+"</td><td>"+employments[j].date+"</td><td>至"+employments[j].deadline+"</td><td><a href=\"javascript:adm("+employments[j].id+")\">通过</a></td></tr></table><div class=\"employ\">"+employments[j].content+"</div></div>";
//////					html+="<div id=\""+employments[j].id+"\" class=\"block\"><a href=\"javascript:show_detail(\'emdetail"+employments[j].id+"\')\" class=\"atitle\">"+employments[j].title+"</a><div class=\"sdate\">"+employments[j].date+"</div><div class=\"sdeadline\">至"+employments[j].deadline+"</div><a href=\"javascript:adm("+employments[j].id+")\" class=\"hdel\">通过</a><a href=\"javascript:del("+employments[j].id+")\" class=\"hdel\">拒绝</a>"
//////					    +"<div id=\"emdetail"+employments[j].id+"\" class=\"emdetail\"><div class=\"emtitle\">职位："+employments[j].title+"</div><div class=\"emcontent\">"+employments[j].content+"</div></div></div>"
////				}				
//			}
////			if(html!=""){
////				container.innerHTML+="<div class=\"enter\">"+enterprises[i].name;
////				container.innerHTML+=html;
////			}
////		}
//	}
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var enterprises = obj.enterprises;		
		var num = obj.num;
		//var container = get("container2");
		//container.innerHTML="";
		//container.style.display = "block";
		//get("container1").style.display = "none";
		var employlist = get("employlist2");
		employlist.innerHTML="";
		total = Math.ceil(enterprises.length/6);		//计算分页的总页数
		var html = "";
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist_'+tempindex+'">';	//每页的id为“plist+页码”
		
			
			for(var i=0;i<6;i++){
				if(6*tempindex+i>=enterprises.length)break;	//此时说明所有图片都添加完毕
//			for(var j=0;j<enterprises.length;j++){
				html += "<a href=\"javascript:list_nem(\'"+enterprises[6*tempindex+i]+"\')\" class=\"ename\">"+enterprises[6*tempindex+i].split("@")[0]+"</a><a class=\"renum\">"+num[6*tempindex+i]+"个职位</a>";
//				if(employments[j].enterpriseid==enterprises[i].id){
////					html+="<div id=\""+employments[j].id+"\" class=\"block\"><table class=\"entable1\"><tr><td>"+employments[j].title+"</td><td>"+employments[j].date+"</td><td>至"+employments[j].deadline+"</td><td><a href=\"javascript:adm("+employments[j].id+")\">通过</a></td></tr></table><div class=\"employ\">"+employments[j].content+"</div></div>";
////					html+="<div id=\""+employments[j].id+"\" class=\"block\"><a href=\"javascript:show_detail(\'emdetail"+employments[j].id+"\')\" class=\"atitle\">"+employments[j].title+"</a><div class=\"sdate\">"+employments[j].date+"</div><div class=\"sdeadline\">至"+employments[j].deadline+"</div><a href=\"javascript:adm("+employments[j].id+")\" class=\"hdel\">通过</a><a href=\"javascript:del("+employments[j].id+")\" class=\"hdel\">拒绝</a>"
////					    +"<div id=\"emdetail"+employments[j].id+"\" class=\"emdetail\"><div class=\"emtitle\">职位："+employments[j].title+"</div><div class=\"emcontent\">"+employments[j].content+"</div></div></div>"
//				}				
			}
			html+='</div>';
			employlist.innerHTML += html;

		}
		//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
		if((enterprises.length/6)<=7){
			creatPageBar("RJ-pagebar2", Math.ceil(enterprises.length/6),lastindex,Math.ceil(enterprises.length/6),show_page_);
		}
		else{
			creatPageBar("RJ-pagebar2", enterprises.length/6,lastindex,7,show_page_);
		}
//			if(html!=""){
//				container.innerHTML+="<div class=\"enter\">"+enterprises[i].name;
//				container.innerHTML+=html;
//			}
//		}
	}
}

function select(i){
	get("page"+i).style.display="block";
	get("sch"+i).style.opacity="1";
	if(i==1)i=2;
	else i=1;
	get("page"+i).style.display="none";
	get("sch"+i).style.opacity="0.5";
	
}
function get(id){
	return document.getElementById(id);
}

function del(id){
	if(confirm("该招聘将被删除！")){		
		createXmlHttp();
		xmlHttp.open("GET", "adop_delete_employment.action?employmentid="+id,true);			
		xmlHttp.onreadystatechange = responseTo3(id);
		xmlHttp.send(null);
	}
}

function adm(id){
	createXmlHttp();
	xmlHttp.open("GET", "adop_accept.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo3(id);
	xmlHttp.send(null);
}

function show_detail(id){
	if(get(id).style.display=="block"){
		get(id).style.display="none";
	}
	else{
		get(id).style.display="block";
	}
}
function responseTo3(id){
	get(id).parentNode.removeChild(get(id));
}

function list_aem(id){
	get("enterprisename").innerHTML = id.split("@")[0];
	createXmlHttp();
	xmlHttp.open("GET", "adop_em_accepted?id="+id.split("@")[1],true);
	xmlHttp.onreadystatechange = responseTo4;
	xmlHttp.send(null);
}

function list_nem(id){
	get("enterprisename").innerHTML = id.split("@")[0];
	createXmlHttp();
	xmlHttp.open("GET", "adop_em_naccepted?id="+id.split("@")[1],true);			
	xmlHttp.onreadystatechange = responseTo5;
	xmlHttp.send(null);
}

function responseTo4(){
	console.log(xmlHttp.readyState);
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var employments = obj.employments;
		var container = get("emlist");
		container.innerHTML="";
		for(var j=employments.length-1; j>=0; j--){
			container.innerHTML+="<div id=\""+employments[j].id+"\" class=\"block\"><a href=\"javascript:show_detail(\'emdetail"+employments[j].id+"\')\" class=\"atitle\">"+employments[j].title+"</a><div class=\"sdate\">"+employments[j].date+"</div><div class=\"sdeadline\">至"+employments[j].deadline+"</div><a href=\"javascript:del("+employments[j].id+")\" class=\"hdel\">删除</a>"
		    +"<div id=\"emdetail"+employments[j].id+"\" class=\"emdetail\"><div class=\"emtitle\">职位："+employments[j].title+"</div><div class=\"emcontent\">"+employments[j].content+"</div></div></div>";
		}
		 displayCover();
	}else{
//		alert("error");
	}
}

function responseTo5(){
	console.log(xmlHttp.readyState);
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var employments = obj.employments;
		var container = get("emlist");
		container.innerHTML="";
		for(var j=employments.length-1; j>=0; j--){
			container.innerHTML+="<div id=\""+employments[j].id+"\" class=\"block\"><a href=\"javascript:show_detail(\'emdetail"+employments[j].id+"\')\" class=\"atitle\">"+employments[j].title+"</a><div class=\"sdate\">"+employments[j].date+"</div><div class=\"sdeadline\">至"+employments[j].deadline+"</div><a href=\"javascript:adm("+employments[j].id+")\" class=\"hdel\">通过</a><a href=\"javascript:del("+employments[j].id+")\" class=\"hdel\">拒绝</a>"
		    +"<div id=\"emdetail"+employments[j].id+"\" class=\"emdetail\"><div class=\"emtitle\">职位："+employments[j].title+"</div><div class=\"emcontent\">"+employments[j].content+"</div></div></div>";
		}
		 displayCover();
	}else{
//		alert("error");
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

function displayCover(){
	var cover_note = document.getElementById('cover');
	cover_note.style.display = 'block';
	setTimeout(function(){
		cover_note.style.background = 'rgba(0,0,0,0.8)'
	},0);
	adjust_login_form();
}

get_accept();
$(document).ready(function(){
	$("#cover").click(function(){
		var cover_note = document.getElementById('cover');
		cover_note.style.background = 'rgba(0,0,0,0)'
		setTimeout(function(){
			cover_note.style.display = 'none';
			get_accept();
			get_naccept();
		},500);
		document.getElementById('element').style.top = '-500px';
	})
	window.onresize = function(){
		if(document.getElementById('cover').style.display == 'block')
			adjust_login_form();
	}

}
);


//显示第num页，隐藏其他页
function show_page(num){
	currentindex=num;
	for(var i=0; i<total; i++){
		if(i==num-1)
			get("plist"+i).style.display="block";
		else get("plist"+i).style.display="none";
	}
}
function show_page_(num){
	currentindex=num;
	for(var i=0; i<total; i++){
		if(i==num-1)
			get("plist_"+i).style.display="block";
		else get("plist_"+i).style.display="none";
	}
}
function list_refresh(){
	lastindex = currentindex;
	listphotos();
//	if(lastindex<=total)
//		show_page(lastindex);
//	else show_page(total);
}
//在id为Pagebar的div中创建页码条，PageCount为分页的总页数，
//由于页码条可完全显示的页码数有限,第四个参数SingleCount指定页码条上显示页码的按键个数，
//CurrentPage指页码条上表示的当前页码，show_fnnc为显示当前页、隐藏其他页时所调用的方法
function  creatPageBar(Pagebar, PageCount, CurrentPage, SingleCount, show_func) 
{
	var RJPageBar=document.getElementById(Pagebar);
	RJPageBar.innerHTML="";
	RJ_Pagebar({
		id:Pagebar, //容器ID : 必选参数
		CurrentPage:CurrentPage>PageCount?PageCount:CurrentPage,   //当前页 ： 可选参数，默认值为1
		SingleCount:SingleCount,   //显示数目： 可选参数，只能为奇数，默认值为7，
		PageCount:PageCount,   //必选参数
		callback : function(pagenow,pagecount){		
				show_func(pagenow);
			}
		})
}
//RJ_Pagebar是页码条对象
function RJ_Pagebar(opt){
	if(!opt.id){ return false};
	if(!opt.PageCount){return false};
	var _obj = document.getElementById(opt.id);
	var _cp = parseInt(opt.CurrentPage)>parseInt(opt.PageCount)?1:parseInt(opt.CurrentPage)||1;
	var _sc = parseInt(opt.SingleCount)>parseInt(opt.PageCount)?7:parseInt(opt.SingleCount)||7;
	var _pc = parseInt(opt.PageCount);
	if(_sc%2==0){_sc=_sc-1};
	var callback = opt.callback || function(){};
	
	if(_cp!=1)
	{
		var oA=document.createElement('a');
		oA.href="#"+(_cp-1);
		oA.innerHTML="上一页";
		_obj.appendChild(oA);
	}
	else
	{
		var oS=document.createElement('span');
		oS.className="RU-pagedisabled";
		oS.innerHTML="上一页";
		_obj.appendChild(oS);
	}
	
	if(_cp<=(_sc-1)/2)
	{
		for(i=1;i<=_sc;i++)
		{
			if(i==_cp)
			{
				var oS=document.createElement('span');
				oS.className='RU-pagenow';
				oS.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oS);
			}
			else
			{
				var oA=document.createElement('a');
				oA.href="#"+i;
				oA.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oA);
			}
		}
		var oS=document.createElement('span');
		oS.innerHTML="…";
		_obj.appendChild(oS);
	}
	else if(_cp<=_pc&&_cp>=_pc-(_sc-1)/2)
	{
		var oS=document.createElement('span');
		oS.innerHTML="…";
		_obj.appendChild(oS);
		for(i=_pc-_sc+1;i<=_pc;i++)
		{
			if(i==_cp)
			{
				var oS=document.createElement('span');
				oS.className='RU-pagenow';
				oS.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oS);
			}
			else
			{
				var oA=document.createElement('a');
				oA.href="#"+i;
				oA.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oA);
			}
		}
	}
	else
	{
		var oS=document.createElement('span');
		oS.innerHTML="…";
		_obj.appendChild(oS);
		
		for(i=_cp-(_sc-1)/2;i<(parseInt(_cp)+parseInt(_sc)-(_sc-1)/2);i++)
		{
			if(i==_cp)
			{
				var oS=document.createElement('span');
				oS.className='RU-pagenow';
				oS.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oS);
			}
			else
			{
				var oA=document.createElement('a');
				oA.href="#"+i;
				oA.innerHTML=i.toString().length==1?"0"+i:i;
				_obj.appendChild(oA);
			}
		}
		var oS=document.createElement('span');
		oS.innerHTML="…";
		_obj.appendChild(oS);
	}
	
	if(_cp!=_pc)
	{
		var oA=document.createElement('a');
		oA.href="#"+(_cp+1);
		oA.innerHTML="下一页";
		_obj.appendChild(oA);
	}
	else
	{
		var oS=document.createElement('span');
		oS.className="RU-pagedisabled";
		oS.innerHTML="下一页";
		_obj.appendChild(oS);
	}
	
	callback(_cp,_pc);
	
	var cA=_obj.getElementsByTagName('a');
	for (var i=0;i<cA.length;i++)
	{
		cA[i].onclick=function(){
			var pagenum=parseInt(this.getAttribute('href').substring(1));
			_obj.innerHTML="";
			RJ_Pagebar({
				id:opt.id, //容器ID : 必选参数
				CurrentPage:pagenum,   //当前页 ： 可选参数，默认值为1
				SingleCount:opt.SingleCount,   //显示数目： 可选参数，只能为奇数，默认值为7，
				PageCount:opt.PageCount,   //必选参数
				callback:callback
				})
				return false;
			}
	}
}

