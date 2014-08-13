<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student-blog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/student-blog.css">
	<script type="text/javascript" src="js/friendbloglist.js"></script>

  </head>
  
  	<body>
		<div id="header">
			<h1>学生空间</h1>
		</div>
		<div id="nav">
			<div class="nav-content">
				<a href="en_look_stu_photo.action">相册</a>
				<a class="active">日志</a>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div id="fun1">
					<h1 class="sub-title">我的日志</h1>
					<div id="blog"></div>
				</div>
			</div>
			<%--<div id="right">
				<div id="avatar">
					<img src="${session.user.avatar}" />
					<span>云淡风轻</span>
				</div>
				<div class="counter">
					您当前共有0分日志
				</div>
				
			</div>
		--%></div>
	</body>
</html>
