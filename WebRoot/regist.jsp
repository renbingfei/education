<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="css/style.css" rel="stylesheet">
		<link type="text/css" href="css/regist.css" rel="stylesheet">
	</head>
	<body>
		<div id="header">
			<div id="logo"></div>
		</div>
		<div id="section">
			<form action="regist.action" method="post" enctype="multipart/form-data">
				<div class="regist-header">企业注册</div>
				<div class="regist-content">
					<div class="form-item clearfix">
						<label>企业名称</label>
						<input id="name" type="text" name="name"/>
					</div>
					<div class="form-item clearfix">
						<label>电子邮箱</label>
						<input id="email" type="text" name="email"/>
					</div>
					<div class="form-item clearfix">
						<label>密码</label>
						<input id="password" type="text" name="password"/>
					</div>
					<div class="form-item clearfix">
						<label>密保问题1</label>
						<input id="question1" type="text" name="question1"/>
					</div>
					<div class="form-item clearfix">
						<label>密保答案1</label>
						<input id="answer1" type="text" name="answer1"/>
					</div>
					<div class="form-item clearfix">
						<label>密保问题2</label>
						<input id="question2" type="text" name="question2"/>
					</div>
					<div class="form-item clearfix">
						<label>密保答案2</label>
						<input id="answer2" type="text" name="answer2"/>
					</div>
					<div class="form-item clearfix">
						<label>密保问题3</label>
						<input id="question3" type="text" name="question3"/>
					</div>
					<div class="form-item clearfix">
						<label>密保答案3</label>
						<input id="answer3" type="text" name="answer3"/>
					</div>
					<div class="form-item clearfix">
						<label>联系方式</label>
						<input id="contact" type="text" name="contact"/>
					</div>
					<div class="form-item clearfix">
						<label>地址</label>
						<input id="address" type="text" name="address"/>
					</div>
					<div class="form-item clearfix">
						<label>简介</label>
						<textarea id="description" name="info"></textarea>
					</div>
					<div class="form-item clearfix">
						<label>上传资料</label>
						<input type="file" name="material" onchange="change()"/>
					</div>
				</div>
				<div class="regist-header">
					<input id="warning" type="button" value="注册" onclick="warn()" />	
					<input id="register" type="submit" value="注册" />				
				</div> 
			</form>
		</div>
		<script>
			var exist = 0;
			function change(){
				exist=1;			
			}
			function warn(){
				if(get("name").value==""||get("email").value==""||get("contact").value==""||get("address").value==""||get("description").value=="")
				{
					alert("所有内容不能为空!");
				}else{
					if(exist==0){
						alert("必须上传相关证明资料!");
					}
				}				
			}
			function get(id){
				return document.getElementById(id);
			}
			setInterval(function(){
				if(get("name").value==""||get("email").value==""||get("contact").value==""||get("address").value==""||get("description").value==""||exist==0);
				else {
					get("warning").style.display="none";
					get("register").style.display="block";
				}
			},500);
		</script>
	</body>
</html>
