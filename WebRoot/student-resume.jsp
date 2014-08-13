<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的应聘</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link type="text/css" href="css/style.css" rel="stylesheet">
	<link type="text/css" href="css/student-resume.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/cover.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/cover.js"></script>
	<script type="text/javascript" src="js/resume-student.js"></script>
	</head>
	<body>
		<div id="cover"></div>
	  	<div id="element" class="element">
	  		<div class="uploadHeader">上传简历</div>
	  		<form action="resume.action" method="post" enctype="multipart/form-data" target="uploadStatus">
	  		<input type="file" name="resume" />
	  		<div class="important">请上传doc格式的文件</div>
	  		<input type="submit" onclick="doing()" value="上传" />
	  		</form>
	  		<iframe id="uploadStatus"></iframe>
	  	</div>
		<div id="header">
			<h1>学生园地</h1><h1>${info.school}</h1>
			<div id="exit">
				<span>${session.user.name}</span>
				<a href="student_exit.action">退出</a>
			</div>
		</div>
		<div id="nav">
			<div class="nav-content">
				<a href="student_person.action">个人中心</a>
				<a href="student_friend.action">我的好友</a>
				<a href="student_photo.action">相册</a>
				<a href="student_blog.action">日志</a>
				<a class="active">我的应聘</a>
				<a href="student_find.action">逛逛企业</a>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div id="avatar">
					<img src="${session.user.avatar}" /> 
					<span class="username">云淡风轻</span>
				</div>
				<a href="#" id="displayCover" class="updateResume" >更新简历</a>
				<span id="num">您当前共投递了0份简历</span>
			</div>
			<div id="right">
			<div id="resumelist" class="clearfix">
				
			</div>
				
			<div id="RJ-pagebar" class="RU-pagebar"></div>
				
			</div>	
		</div>
		<div id="footer">
			<div class="footer-content">
				
			</div>
		</div>
	</body>
</html>