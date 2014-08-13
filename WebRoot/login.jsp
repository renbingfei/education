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
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
  		<div id="header">
  			<h1>中国现代职业教育</h1><h1>登录</h1>
			<a href="http://www.xdzyjy.cn" id="index">主页</a>
  		</div>
  		<div id="section">
  			<div id="center">
  			<table>
  			<tr>
  			<td width="380" style="text-align:top">
  			<div id="noticelist">
			<h2>布告栏</h2><br>
			<article id="noticecontent">
			
			
			</article>
			</div>
  			</td>
  			<td><div id="login" >
  					<div class="login-header">登录</div>
  					<div id="tip"></div>
  					<input type="text" id="id" placeholder="用户名"/>
    				<input type="password" id="password" placeholder="密码"/>
    				<div class="role">
    					<a href="javascript:select(0)" id="role0" class="positive">学生</a>
    					<a href="javascript:select(1)" id="role1" class="negative">企业</a>
    					<a href="findPassword.jsp" id="role2" class="negative">忘记密码</a>
    				</div>
    				<a class="login" href="javascript:login()">登录</a>
  				</div></td>
  			</tr>
  			</table>
  				
  			</div>
  		</div>
  </body>
</html>
