<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业相册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="css/en-style.css" rel="stylesheet">
	<link type="text/css" href="css/en-photo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/student-photo.css">
	<link rel="stylesheet" type="text/css" href="css/cover.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/cover.js"></script>
	<script type="text/javascript" src="js/ephoto.js"></script>
	<script type="text/javascript" src="js/cover2.js"></script>
	<script type="text/javascript" src="js/showphoto.js"></script>
</head>
<body>
  	<div id="cover"></div>
  	<div id="cover1"></div>
  	<div id="photoshow" class="photoshow">
  	<img id ="oldphoto"/>
  	</div>
  	<div id="element" class="element">
  		<div class="uploadHeader">上传照片</div>
  		<form action="uploadephoto.action" method="post" enctype="multipart/form-data" target="uploadStatus">
  		<input type="file" name="file" />
  		<div class="important">请上传图片格式的文件</div>
  		<input type="submit" value="上传" onclick="doing()" />
  		</form>
  		<iframe id="uploadStatus"></iframe>
  	</div>
	<div id="header">
		<div class="header-content">
			<h1>企业中心</h1><h1>${session.user.name}</h1>
			<a href="enterprise_exit.action" id="exit">退出</a>
		</div>
	</div>
	<div id="nav">
		<a href="enterprise_person.action">企业中心</a>
		<a class="active">企业相册</a>
		<a href="enterprise_resume.action">收到的简历</a>
		<a href="enterprise_establish.action">发布招聘信息</a>
		<a href="enterprise_published_resume.action">已发布的招聘信息</a>
	</div>
	<div id="section" class="clearfix">
		<div id="left">
			<div id="avatar">
				<img src="${session.user.url}" /> 
				<span class="username">${session.user.name}</span>
			</div>
			<div id="banner">
				<h1>企业相册</h1>
				<a href="javascript:listEPhoto()">企业照片</a>
				<a id="displayCover" href="#">上传照片</a>
			</div>
		</div>
        <div id="right">
			<div id="photolist" class="clearfix">
			</div>
			<div id="RJ-pagebar" class="RU-pagebar"></div>
			<a href="#" id="listMore">加载更多</a>
		</div>	
	</div>
	<div id="footer">
		<div class="footer-content">
			
		</div>
	</div>
</body>
</html>