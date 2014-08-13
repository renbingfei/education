var xmlHttp;
var flag=0;
var currentindex,total;		//分页当前显示的页码和总页数
var lastindex=1;		//删除照片所在页的页码;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function get_valid(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_valid_enterprise.action",true);			
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.send(null);
}
function get_invalid(){
	if(flag==0){
		flag=1;
		createXmlHttp();
		xmlHttp.open("GET", "adop_invalid_enterprise.action",true);			
		xmlHttp.onreadystatechange = responseTo2;
		xmlHttp.send(null);
	}
}

function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var enterprises = obj.result;
		//var table = get("encontainer");
		var enlist = get("enlist");
		total = Math.ceil(enterprises.length/6);		//计算分页的总页数
		var html = "";
		enlist.innerHTML="";
		
		var calc = 0;
		var size = enterprises.length;
		
		for(var tempindex=0; tempindex<total; tempindex++){
			html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
		
			for(var i=0;i<6;i++){
				if(calc == size)
					break;
				
				
				html+="<div id=\""+enterprises[calc].id+"\" class=\"enclause\"><div class=\"column1\" ><a href=\"enterprise.action?eid="+enterprises[calc].id+"\">"+enterprises[calc].name+"</a></div><div class=\"column2\" ><a>"+enterprises[calc].address+"</a></div><div class=\"column3\" ><a href=\""+enterprises[calc].material+"\">下载</a></div><div class=\"column5\" ><a href=\"javascript:del("+enterprises[calc].id+")\">删除</a></div></div>"
				
				calc += 1;
			}
			
			html+='</div>';
			
			enlist.innerHTML += html;
		}
		
		if((enterprises.length/6)<=7){
			creatPageBar("RJ-pagebar", Math.ceil(enterprises.length/6),lastindex,Math.ceil(enterprises.length/6),show_page);
		}else{
			creatPageBar("RJ-pagebar", enterprises.length/6,lastindex,7,show_page);
		}
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var enterprises = obj.result;
		var table = get("tbody2");

		var html = "";
		for(var i=0;i<enterprises.length;i++){
//			html="<tr id=\""+enterprises[i].id+"\"><td>"+enterprises[i].name+"</td><td>"+enterprises[i].address+"</td><td><a href=\""+enterprises[i].material+"\">下载</a></td><td><a href=\"javascript:adm("+enterprises[i].id+")\">通过</a></td></tr>";
			html="<div id=\""+enterprises[i].id+"\" class=\"enclause\"><div class=\"column1\" ><a>"+enterprises[i].name+"</a></div><div class=\"column2\" ><a>"+enterprises[i].address+"</a></div><div class=\"column3\" ><a href=\""+enterprises[i].material+"\">下载</a></div><div class=\"column4\" ><a href=\"javascript:adm("+enterprises[i].id+")\">通过</a></div><div class=\"column5\" ><a href=\"javascript:del("+enterprises[i].id+")\">拒绝</a></div>";
			table.innerHTML+=html;
		}
	}
}

function del(id){
	if(confirm("该公司将在系统中删除！")){		
		createXmlHttp();
		xmlHttp.open("GET", "adop_delete_enterprise.action?id="+id,true);			
		xmlHttp.onreadystatechange = responseTo3(id);
		xmlHttp.send(null);
	}
}

function adm(id){
	createXmlHttp();
	xmlHttp.open("GET", "adop_agree_enterprise.action?id="+id,true);			
	xmlHttp.onreadystatechange = responseTo3(id);
	xmlHttp.send(null);
}

function responseTo3(id){
	get(id).parentNode.removeChild(get(id));
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

get_valid();
