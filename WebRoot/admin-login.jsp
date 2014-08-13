<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/admin-login.js"></script>
  </head>
  
  <body>
  		<div id="header">
  			<h1>中国现代职业教育</h1><h1>管理员登录</h1>
			<a href="http://www.xdzyjy.cn" id="index">主页</a>
  		</div>
  		<div id="section">
  			<div id="center">
  				<div id="login">
  					<div class="login-header">管理员登录</div>
  					<div id="tip"></div>
  					<input type="text" id="id" placeholder="用户名"/>
    				<input type="password" id="password" placeholder="密码"/>
    				<a class="login" href="javascript:login()">登录</a>
  				</div>
  			</div>
  		</div>
  </body>
</html>
