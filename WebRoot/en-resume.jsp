<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收到的简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="css/en-style.css" rel="stylesheet">
	<link type="text/css" href="css/en-resume.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/resume-enterprise.js"></script>
	</head>
	<body>
	
	<div id="cover"></div>
  	<div id="element" class="element">
  		<div id="school_resume_list" class="clearfix">
		</div>
				
		<div id="RJ2-pagebar" class="RU-pagebar"></div>
  	</div>
  	
		<div id="header">
			<div class="header-content">
				<h1>企业中心</h1><h1>${session.user.name}</h1>
				<a href="enterprise_exit.action" id="exit">退出</a>
			</div>
		</div>
		<div id="nav">
			<a href="enterprise_person.action">企业中心</a>
			<a href="enterprise_photo.action">企业相册</a>
			<a class="active">收到的简历</a>
			<a href="enterprise_establish.action">发布招聘信息</a>
			<a href="enterprise_published_resume.action">已发布的招聘信息</a>
		</div>
		<div id="section">
			<div id="resumelist" class="clearfix">
				
			</div>
				
			<div id="RJ-pagebar" class="RU-pagebar"></div>
				
		</div>
		<div id="footer">
			<div class="footer-content">
				
			</div>
		</div>
		<div id="enterpriseId">${session.user.id}</div>
	</body>
</html>