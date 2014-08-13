var xmlHttp;
var currentindex,total;		//分页当前显示的页码和总页数
var lastindex=1;		//删除照片所在页的页码;

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
//		var response = xmlHttp.responseText;
//		var obj = eval('(' + response + ')');
//		var html = "";
//		var es = obj.result;
//		if(es.length==0)
//			html = "一个企业也没有啊，呜呜~";			
//		else{
//			html+="<caption>共有条"+es.length+"招聘消息</caption>";
//			for(var i=(es.length-1);i>=0;i--){
//			html += "<tr><td>"+es[i].date+"</td><td><a href='enterprise.action?eid="
//				+es[i].enterpriseid+"' class='detail' target='_blank'>"+es[i].ename+"</td><td>"
//				+es[i].title+"</td><td>"+es[i].deadline+"</td><td><a href='javascript:employ_info("
//				+es[i].id+")' class='detail'>查看招聘信息</a></td></tr>";
//			}
//		}
//		get("find").innerHTML = html;
		
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var enlist = get("enlist");
		var records = obj.result;
		
		total = Math.ceil(records.length/7);		//计算分页的总页数
		
		var size = records.length;
		var calc = size - 1;
		
		//if(records.length==0){
			//get("resume").innerHTML = "您还没有投递简历！";			
		//}else{
		
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html+='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
		
			html += "<table id=\"resume\">";
			html += "<caption>共有条"+records.length+"招聘消息<br>发布日期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;企业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;招聘主题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;截止日期 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;招聘详情</caption>";
	//	html += "<caption><tr><td>"+日期+"</td><td>"+企业+"</td><td>"+招聘主题+"</td><td>"+招聘详情+"</td>/tr></caption>";
			//html += "<tr><th>简历投递编号</th><th>投递时间</th><th>企业名称</th><th>企业详情</th></tr>";
			for(var i=6;i>=0;i--){
				if(calc == -1)
					break;
				
				html += "<tr><td>"+records[calc].date+"</td><td><a href='enterprise.action?eid="
				+records[calc].enterpriseid+"' class='detail' target='_blank'>"+records[calc].ename+"</td><td>"
				+records[calc].title+"</td><td>"+records[calc].deadline+"</td><td><a href='javascript:employ_info("
				+records[calc].id+")' class='detail'>查看招聘信息</a></td></tr>";
//				
//				html += "<tr><td>"+records[calc].id+"</td><td>"+records[calc].date+"</td>" +
//				"<td>"+records[calc].ename+"</td><td><a href='enterprise.action?eid=" + records[calc].enid
//				+ "' class='detail' target='_blank'>查看企业</a></td><tr>";
				
				
				calc --;
			}
			html += "</table>";
			
			html+='</div>';
			enlist.innerHTML = html;
		}
		
		//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
		if((records.length/7)<=8){
			creatPageBar("RJ-pagebar", Math.ceil(records.length/7),lastindex,Math.ceil(records.length/7),show_page);
		}else{
			creatPageBar("RJ-pagebar", records.length/7,lastindex,8,show_page);
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
			;
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
