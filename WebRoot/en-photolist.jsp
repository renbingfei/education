<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student-photo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="css/en-style.css" rel="stylesheet">
	<link type="text/css" href="css/en-photo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/cover.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/ephotolist.js"></script>
</head>
<body>
	<div id="header">
		<div class="header-content">
			<h1>企业简介</h1><h1>${enterprise.name}</h1>
		</div>
	</div>
	<div id="nav">
		<a href="enterprise.action?eid=${enterprise.id}">企业中心</a>
		<a class="active">企业相册</a>
	</div>
	<div id="section" class="clearfix">
		
		<div id="right">
			<div id="photolist" class="clearfix">
				
			</div>
		</div>	
	</div>
	<div id="footer">
		<div class="footer-content">
			
		</div>
	</div>
</body>
</html>