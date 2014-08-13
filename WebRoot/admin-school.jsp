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
	<script type="text/javascript" src="js/admin-school.js"></script>
	<link rel="stylesheet" type="text/css" href="css/admin-school.css">

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
				<a class="active">学校信息管理</a>
				<a href="admin_enterprise.action">企业信息管理</a>
				<a href="admin_employ.action">招聘信息管理</a>				
				<a href="admin_resume.action">简历投递统计</a>				
				<a href="admin_querypsw.action">重置密码</a>
				<a href="admin_exit.action">退出系统</a>
			</div>
			<div id="content">
			<div class="tab3">
				<div>
					<h1 class="topHeadr2">学校信息管理</h1>
				</div>
				<div id="select">
					<a id="sch1" href="javascript:select(1)" class="select-item">所有学校</a>
					<a id="sch2" href="javascript:select(2)" class="select-item">添加</a>
				</div>
				<div >
					<div id="page1">
					<div class="row2">
					<div id="schoollist" class="clearfix">
				
					</div>
				
					<div id="RJ-pagebar" class="RU-pagebar"></div>
					
					<!--
					<table id="schooltable">
					<tbody id="tbody">
						<tr>
							<th>学校编号</th>
							<th>学校校徽</th>
							<th>学校名称</th>
							<th>&nbsp;</th>
						</tr>
					</tbody>
					</table>
					-->
					</div>
					</div>
					<div id="page2">
						<form action="adop_add_school.action" method="post" enctype="multipart/form-data" target="_self">	<!-- target="status" -->									
							<div class="row2">
								<div class="span1">学校编号：</div>
								<div class="span11">
									<input type="text" name="schoolid" id="title" onkeyup="value=value.replace(/[^\d]/g,'') "   
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
								</div>
							</div>
							<div class="row2">
								<div class="span1">名称：</div>
								<div class="span11">
									<input type="text" name="name" id="title" />
								</div>
							</div>
							<div class="row3">
								<div class="span1">学校描述：</div>
								<div class="span11">
									<textarea name="description" id="detail" >
									</textarea>
								</div>
							</div>
							<div class="row4">
							<div class="span1">学校校徽：</div>
							<p><input id="schoolfile" type="file" name="file"/></p>					
							<p><input id="schoolsubmit" type="submit" value="上传" class="submit"/></p>
							</div>
						</form>
					</div>
				</div>
				</div>
				<iframe id="status" class="tab3">
				</iframe>
			</div>
		</div>
		<div id="footer">

		</div>
  </body>
</html>