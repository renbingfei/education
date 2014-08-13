<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/en-style.css">
	<link rel="stylesheet" type="text/css" href="css/en-person.css">
	<link rel="stylesheet" type="text/css" href="css/window.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/window.js"></script>
	<script type="text/javascript" src="js/enterprise_photo.js"></script>

  	</head>
  	<body>
  	  	<!-- 密码弹窗部分-->
  
  <div class="box">
	<div class="box_content">
		<div class="title">
			<h3>修改密码</h3>
			<h2 id="close">×</h2>
		</div>
		<div class="content">
		<form action="enchangepassword.action" method="post" enctype="multipart/form-data" target="changeStatus">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr height="60px">
					<td colspan="2">
						<p class="prompt" id="username_p">请输入原密码</p>
						<input type="text" class="inputstyle ins" id="username" name="oldpassword"/>
					</td>
				</tr>
				<tr height="60px">
					<td colspan="2">
						<p class="prompt" id="pwd_p">请输入密码</p>
						<input type="password" class="inputstyle ins" id="pwd" name="newpassword"/>
					</td>
				</tr>
				<tr height="60px">
					<td colspan="2">
						<p class="prompt" id="pwd_temp">请确认密码</p>
						<input type="password" class="inputstyle ins" id="pwd" name="temppassword"/>
					</td>
				</tr>
				<tr height="60px">
					<td colspan="2"><input type="submit" value="确定" class="inputstyle login" id="login"/></td>
				</tr>
			</table>
			</form>
			<iframe id="changeStatus"></iframe>
		</div>
	</div>
  </div>
		<div id="header">
			<div class="header-content">
				<h1>企业中心</h1><h1>${session.user.name}</h1>
				<a href="enterprise_exit.action" id="exit">退出</a>
				<button id="show" class="alter" width="100px">修改密码</button>
			</div>
		</div>
		<div id="nav">
			<a class="active">企业中心</a>
			<a href="enterprise_photo.action">企业相册</a>
			<a href="enterprise_resume.action">收到的简历</a>
			<a href="enterprise_establish.action">发布招聘信息</a>
			<a href="enterprise_published_resume.action">已发布的招聘信息</a>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div class="left-part">
					<h1 class="sub-title">企业档案</h1>
					<div class="sub-content clearfix">
						<div id="avatar">
							<img src="${session.user.url}" />
						</div>
						<div id="info">
							<ul class="person-info">
								<li><b>名称：</b>${session.user.name}</li>
								<li><b>简介：</b>${session.user.info}</li>
								<li><b>地址：</b>${session.user.address}</li>
								<li><b>联系方式：</b>${session.user.contact}</li>
							</ul>			
						</div>
					</div>
				</div>
				<div class="left-part">
					<h1 class="sub-title">企业相册</h1>
					<div id="enterprise_photo" class="sub-contentX clearfix">						
					</div>
				</div>
				<!-- 
				<div class="left-part">
					<h1 class="sub-title">查看简历</h1>
					<div class="sub-content">
						<div style="margin-left:20px">niejwfnewk</div>
					</div>
				</div>
				-->
			</div>
			<div id="right">
				
			</div>
		</div>
		<div id="footer">
			<div class="footer-content">
			
			</div>
		</div>
	</body>
</html>
