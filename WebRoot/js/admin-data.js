var xmlHttp;
var flag = -1;
var exist = 0;

function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}

function get_schools(){
	createXmlHttp();
	xmlHttp.open("GET", "adop_list_school.action",true);			
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.send(null);
}

function responseTo(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('('+response+')');
		var schools = obj.result;
		var table = get("schoolcontainer");
		var html = "";
		for(var i=0;i<schools.length;i++){
			html="<label id=\"sc"+schools[i].id+"\" class=\"normal\" onclick=\"select("+ schools[i].id +")\">"+schools[i].name+"</label>";
			table.innerHTML += html;
		}
	}
}

function select(num){
	var label1=get("sc"+num);
	if(flag!=-1){
		var label2=get("sc"+flag);
		label2.className="normal";
	}
	flag = num;
	label1.className="chosen";
	var sc = get("chosen");
	var st = get("chosentext");
	sc.innerHTML=label1.innerHTML;
	st.setAttribute("value",num);
	if(exist!=0){
		get("uplabel").style.display = "none";
		get("datasubmit").style.display = "block";
	}
}

function change(sender){
	exist = 1;
	if(flag!=-1){
		get("uplabel").style.display = "none";
		get("datasubmit").style.display = "block";
	}
}

function doing(){
	inspector = setInterval(function(){
		var status_text=get("status").contentWindow.document.getElementsByTagName("body")[0].innerHTML;
		if(status_text.search(/成功/)>=0){
			alert("上传成功！");
			window.clearInterval(inspector);
			window.history.go(0);
		}else if(status_text.search(/ferror/)>=0){
			alert("文件格式有问题！");
			window.clearInterval(inspector);
		}else if(status_text.search(/error/)>=0){
			alert("上传失败，请重新上传！");
			window.clearInterval(inspector);
		}
	},1000)
};

function get(id){
	return document.getElementById(id);
}
get_schools();