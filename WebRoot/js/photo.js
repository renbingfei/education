var xmlHttp;
var deleteid;
var currentindex,total;		//分页当前显示的页码和总页数
var lastindex=1;		//删除照片所在页的页码;
listphotos();
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listphotos(){
	createXmlHttp();
	xmlHttp.open("GET", "listphoto.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function deletephoto(id){
	createXmlHttp();
	deleteid = id;
	xmlHttp.open("GET", "deletephoto.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.send(null);
}
function get(id){
	return document.getElementById(id);
}

function doing(){
	get("uploadStatus").setAttribute("src","submitting.jsp");
	inspector = setInterval(function(){
		var status_text=get("uploadStatus").contentWindow.document.getElementsByTagName("body")[0].innerHTML;
		if(status_text.search(/成功/)>=0){
			window.clearInterval(inspector);
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			get('element').style.top = '-500px';
			window.history.go(0);
		}
	},1000)
	
}

function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var photolist = get("photolist");	//分页所在的div，id为photolist
		var photos = obj.result;
		var html = "";
		photolist.innerHTML = "";	
		total = Math.ceil(photos.length/6);		//计算分页的总页数
		//为每页添加6个照片
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
			for(var i=0;i<6;i++){
				if(6*tempindex+i>=photos.length)break;	//此时说明所有图片都添加完毕
				html += '<div id="photo'+photos[6*tempindex+i].id+'" class="photo"><img onclick="showphoto(\''+photos[6*tempindex+i].url+'\')" src="'+photos[6*tempindex+i].url+'"><div class="description">'
				+photos[6*tempindex+i].statement +'<a href="javascript:deletephoto('+photos[6*tempindex+i].id+')">删除</a></div></div>';
			}
			html+='</div>';
			photolist.innerHTML += html;
		}
		if(html==""){
			photolist.innerHTML = "您的相册还没有照片哦！点击上传照片，轻松上传！";
		}
		//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
		if((photos.length/6)<=7){
			creatPageBar("RJ-pagebar", Math.ceil(photos.length/6),lastindex,Math.ceil(photos.length/6),show_page);
		}else{
			creatPageBar("RJ-pagebar", photos.length/6,lastindex,7,show_page);
		}
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
//			var note = get("photo"+deleteid);
//			note.parentNode.removeChild(note);
			//删除图片后调用list_refresh()重新加载，生成分页，并跳到删除的照片所在的页，
			//如果最后一页只有一张照片，则删除后显示前一页
			list_refresh();
		}
	}
}

//显示第num页，隐藏其他页
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

