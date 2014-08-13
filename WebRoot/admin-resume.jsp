<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin-data.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/administrator.css">
	<script type="text/javascript" src="js/admin-resume.js"></script>
	<link rel="stylesheet" type="text/css" href="css/admin-resume.css">

  </head>
  
  <body>
    	<div id="header">
			<h1 class="topHeader1">中国职业教育网后台管理系统</h1>
		</div>
		<div id="section">
			<div id="nav">
				<a href="admin_index.action">主页</a>
				<a href="admin_main.action">首页信息上传</a>
				<a href="admin_edit.action">首页信息编辑</a>
				<a href="admin_data.action">导入学生数据</a>
				<a href="admin_school.action">学校信息管理</a>
				<a href="admin_enterprise.action">企业信息管理</a>
				<a href="admin_employ.action">招聘信息管理</a>				
				<a class="active">简历投递统计</a>				
				<a href="admin_querypsw.action">重置密码</a>
				<a href="admin_exit.action">退出系统</a>
			</div>
			<div id="content">
				<div class="tab3">
				<div>
					<h1 class="topHeadr2">简历投递统计</h1>
				</div>
				
					<div id="resumelist" class="clearfix">
					</div>
					<div id="RJ-pagebar" class="RU-pagebar"></div>
				
			</div>
			</div>
		</div>
		<div id="footer">

		</div>
  </body>
</html>
