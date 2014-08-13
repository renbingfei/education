var xmlHttp;
var currentindex,total;		//分页当前显示的页码和总页数
var lastindex=1;		//删除照片所在页的页码;
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function list(id){
	createXmlHttp();
	switch(id){
	case 1:{
		xmlHttp.open("GET", "friend_list.action" ,true);
		xmlHttp.onreadystatechange = responseTo1;
		break;
	}
	case 2:{
		var studentid = get("search1").value;
		xmlHttp.open("GET", "friend_findS.action?studentid="+studentid ,true);			
		xmlHttp.onreadystatechange = responseTo2;
		break;
	}
	case 3:{
		var studentid = get("search2").value;
		xmlHttp.open("GET", "friend_findF.action?studentid="+studentid ,true);			
		xmlHttp.onreadystatechange = responseTo3;
		break;
	}
	}
	xmlHttp.send(null);
}
function add(studentid){
	alert(studentid);
	createXmlHttp();
	xmlHttp.open("GET", "friend_add.action?studentid="+studentid ,true);
	xmlHttp.onreadystatechange = responseTo4;
	xmlHttp.send(null);
}
function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var friendlist = get("friendlist");	//分页所在的div，id为friendlist
		var html = "";
		
		var students = obj.result;
		total = Math.ceil(students.length/6);
		friendlist.innerHTML = "";
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
			for(var i=0;i<6;i++){
				if(6*tempindex+i>=students.length)break;	//此时说明所有图片都添加完毕
				html += '<div class="friend-item '+(i%2==0?'odd':'even')+'"'
				+ 'onmouseover="this.style.cursor=\'hand\'" onclick="window.location.href=\'student_friendphoto.action?studentid='+students[6*tempindex+i].studentid +'\'">'
				+'<div class="avatar"><img src="'+students[6*tempindex+i].avatar+'"/></div>'
				+'<div class="friend-item-cell">'+students[6*tempindex+i].studentid+'</div><div class="friend-item-cell">'+students[6*tempindex+i].name+'</div>'
				+'<div class="friend-item-cell">'+students[6*tempindex+i].sex+'</div><div class="friend-item-cell">'+students[6*tempindex+i].contact+'</div></div>';
			}
			html+='</div>';
			friendlist.innerHTML += html;
		}
		
//		for(var i=0;i<students.length;i++){
//			html += '<div class="friend-item '+(i%2==0?'odd':'even')+'"'
//			+ 'onmouseover="this.style.cursor=\'hand\'" onclick="window.location.href=\'student_friendphoto.action?studentid='+students[i].studentid +'\'">'
//			+'<div class="avatar"><img src="'+students[i].avatar+'"/></div>'
//			+'<div class="friend-item-cell">'+students[i].studentid+'</div><div class="friend-item-cell">'+students[i].name+'</div>'
//			+'<div class="friend-item-cell">'+students[i].sex+'</div><div class="friend-item-cell">'+students[i].contact+'</div></div>';
//		}
		if(html==""){
			friendlist.innerHTML = "<div style='margin:20px auto;width:600px'>您还么有好友，去添加好友吧！</div>";
		}else{
			friendlist.innerHTML = html;
		}
		
		if((students.length/6)<=7){
			creatPageBar("RJ-pagebar", Math.ceil(students.length/6),lastindex,Math.ceil(students.length/6),show_page);
		}else{
			creatPageBar("RJ-pagebar", students.length/6,lastindex,7,show_page);
		}
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var status = obj.status;
		var student = obj.student;
		if(status==-1){
			get("searchResult1").innerHTML = "对不起，没有你所要查询的学生信息！";							
		}
		else if(status==1){
			html += '<div class="searchAvatar"><img src="'+student.avatar+'"/></div>'
			+'<div class="searchInfo"><ul><li class="special">个人档案</li><li>学号：'+student.studentid
			+'</li><li>姓名：'+student.name+'</li><li>性别：'+student.sex+'</li><li>专业：'+student.major+'</li>'
			+'<li><a href="javascript:add(\''+student.studentid+'\')" class="button">加为好友</a></li></ul></div>';
			get("searchResult1").innerHTML = html;
		}else{
			html += '<div class="searchAvatar"><img src="'+student.avatar+'"/></div>'
			+'<div class="searchInfo"><ul><li class="special">个人档案</li><li>学号：'+student.studentid
			+'</li><li>姓名：'+student.name+'</li><li>性别：'+student.sex+'</li><li>专业：'+student.major+'</li>'
			+'<li><a href="javascript:void(0)" class="button">对方已经是您的好友</a></li></ul></div>';
			get("searchResult1").innerHTML = html;
		}
		
	}
}
function responseTo3(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		var html = "";
		var student = obj.result;
		if(student == null){
			get("searchResult2").innerHTML = "对不起，您的好友列表里没有这个人！";								
		}else{
			html += '<div class="searchAvatar"><img src="'+student.avatar+'"/></div>'
			+'<div class="searchInfo"><ul><li class="special">个人档案</li><li>学号：'+student.studentid
			+'</li><li>姓名：'+student.name+'</li><li>性别：'+student.sex+'</li><li>专业：'+student.major+'</li>'
			+'<li><a href="#" class="button">访问他的空间</a></li></ul></div>';
			get("searchResult2").innerHTML = html;
		}
	}
}
function responseTo4(){
	if(xmlHttp.readyState==4){
		alert("添加成功！");
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

