var xmlHttp;
var deleteid;

var lastindex=1;
var currentindex,total;	

listblogs();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listblogs(){
	createXmlHttp();
	xmlHttp.open("GET", "blog_list.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function deleteblog(id){
	createXmlHttp();
	deleteid = id;
	xmlHttp.open("GET", "blog_delete.action?id="+id,true);			
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
		var blogs = obj.result;
		
		var split_num = 3;	
		var bloglist = get("bloglist");
		bloglist.innerHTML = "";	
		total = Math.ceil(blogs.length/split_num);		//计算分页的总页数

		var calc = blogs.length - 1;
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
			for(var i=0;i<split_num;i++){
				if(split_num*tempindex+i>=blogs.length)break;	//此时说明所有图片都添加完毕
//				html += '<div id="blog'+blogs[split_num*tempindex+i].id+'" class="blog-item"><div class="blog-header">'+blogs[split_num*tempindex+i].title
//					+'<a href="javascript:deleteblog('+blogs[split_num*tempindex+i].id+')" class="delete">删除</a>'
//					+'<span class="date">'+blogs[split_num*tempindex+i].date+'</span></div><div class="blog-content">'+blogs[split_num*tempindex+i].content+'</div></div>';
				html += '<div id="blog'+blogs[calc].id+'" class="blog-item"><div class="blog-header">'+blogs[calc].title
				+'<a href="javascript:deleteblog('+blogs[calc].id+')" class="delete">删除</a>'
				+'<span class="date">'+blogs[calc].date+'</span></div><div class="blog-content">'+blogs[calc].content+'</div></div>';

				calc--;
			}
			html+='</div>';
			bloglist.innerHTML += html;
		}
		if(html==""){
			bloglist.innerHTML = "您还没有写过日志哦！点击写日志，轻松上传！";
		}
		//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
		if((blogs.length/split_num)<=7){
			creatPageBar("RJ-pagebar", Math.ceil(blogs.length/split_num),lastindex,Math.ceil(blogs.length/split_num),show_page);
		}else{
			creatPageBar("RJ-pagebar", blogs.length/split_num,lastindex,7,show_page);
		}
		
		var blogcount = get("blogcount");
		var blog_num = blogs.length;
		blogcount.innerHTML = "您当前共有"+blog_num+"份日志";
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var result = obj.result;
		if(result){
			alert("删除成功！");
			var note = get("blog"+deleteid);
			get("plist"+(currentindex-1)).removeChild(note);
		}
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

function writeblog(){
	get("fun1").style.display="none";
	get("fun2").style.display="block";
}

function myblog(){
	get("fun2").style.display="none";
	get("fun1").style.display="block";
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

function blog_up(){
	createXmlHttp();
	xmlHttp.open("GET", "uploadblog.action?title="+get("title").value+"&content="+get("conup").value,true);			
	xmlHttp.onreadystatechange = responseTo4;
	xmlHttp.send(null);
}
function responseTo4(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		if(obj.result)window.history.go(0);
		else alert("日志提交失败！")
	}
}

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
		get("conup").setAttribute("value",document.getElementsByTagName("iframe")[1].contentWindow.document.getElementsByTagName("body")[0].innerHTML);
	},500);
	
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
function show_page(num){
	currentindex=num;
	for(var i=0; i<total; i++){
		if(i==num-1)
			get("plist"+i).style.display="block";
		else get("plist"+i).style.display="none";
	}
}
function list_refresh(){
	lastindex = currentindex;
	listblogs();
}