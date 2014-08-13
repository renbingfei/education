var xmlHttp;
var lastindex=1;
var currentindex,total;	
var resultList = new Array();  //所有记录的集合，包括置顶、推荐、普通三种类型的企业

listTopEnterprise();
//listfour();

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function listfour(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("GET", "get_rec_en_false.action?" ,true);
	xmlHttp.send(null);
}
function listTopEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo1;
	xmlHttp.open("POST", "get_top_en.action?top=true" ,true);
	xmlHttp.send(null);
}
function listRecEnterprise(){
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo2;
	xmlHttp.open("POST", "get_rec_en.action?recommend=true" ,true);
	xmlHttp.send(null);
}
//function responseTo(){
//	var encontainer = get("allenlist");
//	if(xmlHttp.readyState==4){
//		if(xmlHttp.status == 200){
//			var response = xmlHttp.responseText;
//			var obj = eval('(' + response + ')');
//			var html = "";
//			var result = obj.enlist;
//			
//			var split_num = 10;	
//			encontainer.innerHTML = "";	
//			total = Math.ceil(result.length/split_num);		//计算分页的总页数
//
//			for(var tempindex=0; tempindex<total; tempindex++){
//				html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
//				html += '<ul class="fontNone xw " style="width:680px">';
//				for(var i=0;i<split_num;i++){
//					if(split_num*tempindex+i>=result.length)break;	//此时说明所有图片都添加完毕
//					html += '<li><a href="enterprise.action?eid='
//						  +result[split_num*tempindex+i].id+'" target="_blank">'+result[split_num*tempindex+i].name+'</a></li>';
//				}
//				html += '</ul>';
//				html+='</div>';
//				encontainer.innerHTML += html;
//			}
//			if(html==""){
//				encontainer.innerHTML = "您还没有写过日志哦！点击写日志，轻松上传！";
//			}
//			//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
//			if((result.length/split_num)<=(split_num+1)){
//				creatPageBar("RJ-pagebar", Math.ceil(result.length/split_num),lastindex,Math.ceil(result.length/split_num),show_page);
//			}else{
//				creatPageBar("RJ-pagebar", result.length/split_num,lastindex,7,show_page);
//			}
//		}else
//			encontainer.innerHTML = "";
//	}
//}

function responseTo(){
	var encontainer = get("allenlist");
	if(xmlHttp.readyState==4){
		if(xmlHttp.status == 200){
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			var html = "";
			var result = obj.en_list_false;
			
			for(var i = 0; i < result.length; i++){
				resultList.push(result[i]);
			}	
			
			var split_num = 10;	
			encontainer.innerHTML = "";	
			total = Math.ceil(resultList.length/split_num);		//计算分页的总页数

			for(var tempindex=0; tempindex<total; tempindex++){
				html='<div id="plist'+tempindex+'">';	//每页的id为“plist+页码”
				html += '<ul class="fontNone xw " style="width:680px">';
				for(var i=0;i<split_num;i++){
					if(split_num*tempindex+i>=resultList.length)break;	//此时说明所有图片都添加完毕
					html += '<li><a href="http://www.xdzyjy.cn:8080/education/enterprise.action?eid='
						  +resultList[split_num*tempindex+i].id+'" target="_blank">'+resultList[split_num*tempindex+i].name+'</a></li>';
				}
				html += '</ul>';
				html+='</div>';
				encontainer.innerHTML += html;
			}
			if(html==""){
				encontainer.innerHTML = "";
			}
			//在id为RJ-pagebar的div中创建页码条，总页数不大于7的时候显示页数和总页数相等，大于7时显示页数为7
			if((resultList.length/split_num)<=(split_num+1)){
				creatPageBar("RJ-pagebar", Math.ceil(resultList.length/split_num),lastindex,Math.ceil(resultList.length/split_num),show_page);
			}else{
				creatPageBar("RJ-pagebar", resultList.length/split_num,lastindex,7,show_page);
			}
		}else
			encontainer.innerHTML = "";
	}
}

function responseTo1() {
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

function responseTo2() {
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

function get(id){
	return document.getElementById(id);
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
	listresult();
}
