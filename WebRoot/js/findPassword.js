window.onload = function(){
	step = 1;
	username = "";
	type= 0;
	get("step"+step).style.display = "block";
	get("status1").onfocus = function(){
		get("status1").style.display = "none";		
	}
}
function get(id){
	return document.getElementById(id);
}
function select(t){
	for(i=0;i<2;i++){
		get("role"+i).style="role negative";
	}
	get("role"+t).style="role positive";		
}
function createXmlHttp(){
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
	    xmlHttp = new ActiveXObject("Microsoft.XMLHttp");	
	}
}
function getQuestion(){
	username = get("username").value;
	console.log(username);
	if(username==""){
		get("status1").innerHTML = "您还没有填写用户名！";
		get("status1").style.display = "block";
	}else{
		createXmlHttp();
		xmlHttp.open("GET","password_question?username="+username+"&type="+type,true);			
		xmlHttp.onreadystatechange = responseTo1;
		xmlHttp.send(null);
	}
}
function checkAnswer(){
	var answer1 = get("answer1").value;
	var answer2 = get("answer2").value;
	var answer3 = get("answer3").value;
	if(answer1==""||answer2==""||answer3==""){
		get("status2").innerHTML = "您还有问题没有回答！";
		get("status2").style.display = "block";
	}else{
		createXmlHttp();
		xmlHttp.open("GET","password_check?username="+username+"&answer1="+answer1+"&answer2="+answer2+"&answer3="+answer3,true);			
		xmlHttp.onreadystatechange = responseTo2;
		xmlHttp.send(null);
	}
}
function setPassword(){
	var password = get("password").value;
	if(password==""){
		get("status2").innerHTML = "请输入密码！";
		get("status2").style.display = "block";
	}else{
		createXmlHttp();
		xmlHttp.open("GET","password_set?username="+username+"&type="+type+"&password="+password,true);			
		xmlHttp.onreadystatechange = responseTo3;
		xmlHttp.send(null);
	}
}
function responseTo1(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		console.log(obj);
		a = obj.result
		if(a==null){
			get("status1").innerHTML = "该用户名不存在！"
			get("status1").style.display = "block";	
		}else{
			get("step"+step).style.display = "none";
			step++;
			get("question1").innerHTML = a.question1;
			get("question2").innerHTML = a.question2;
			get("question3").innerHTML = a.question3;
			get("step"+step).style.display = "block";
		}
	}
}
function responseTo2(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		console.log(obj);
		a = obj.result;
		console.log(a);
		if(!a){
			get("status2").innerHTML = "回答错误！"
			get("status2").style.display = "block";	
		}else{
			get("step"+step).style.display = "none";
			step++;
			get("step"+step).style.display = "block";
		}
	}
}
function responseTo3(){
	if(xmlHttp.readyState==4){
		var response = xmlHttp.responseText;
		var obj = eval('(' + response + ')');
		console.log(obj);
		a = obj.result;
		if(a){
			alert("设置成功！");
			window.location.href="login.jsp";
		}
	}
}