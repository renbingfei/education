<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/cover.css">
	<link rel="stylesheet" type="text/css" href="css/student-person.css">
	<link rel="stylesheet" type="text/css" href="css/window.css">
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/window.js"></script>
	<script type="text/javascript" src="js/friendphoto.js"></script>
	<script type="text/javascript" src="js/stu-person.js"></script>
	<script type="text/javascript" src="js/cover.js"></script>

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
		<form action="changepassword.action" method="post" enctype="multipart/form-data" target="changeStatus">
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
  
  
   <div id="cover"></div>
  	<div id="element" class="element">
  		<div class="uploadHeader">上传头像</div>
  		<form id="updateAvatar" action="stu_update_avatar.action" method="post" enctype="multipart/form-data" target="uploadStatus">
  		<input type="file" name="file" />
  		<div class="uploadState">
  		</div>
  		<div class="important">请上传图片格式的文件</div>
  		<input type="submit" onclick="upload_avatar()" value="上传" />
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
				<a class="active">个人中心</a>
				<a href="student_friend.action">我的好友</a>
				<a href="student_photo.action">相册</a>
				<a href="student_blog.action">日志</a>
				<a href="student_resume.action">我的应聘</a>
				<a href="student_find.action">逛逛企业</a>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<h1 class="sub-title"><a href="student_friend.action">我的好友</a></h1>
				<div id="friendlist" class="sub-content clearfix">
				您当前共拥有${info.friend}名好友
					<div class="friend" onmouseover="this.style.cursor='hand'" onclick="window.location.href= 'student_friendphoto.action?userid=10212040@1001'">
						<img src="image/stu.jpg" />
						<span>dfadsdfsdf</span>
					</div>
				</div>
				<h1 class="sub-title"><a href="student_photo.action">我的相册</a></h1>
				<div id="photocontainer" class="sub-content clearfix">
				</div>
				<h1 class="sub-title"><a href="student_blog.action">我的日志</a></h1>
				<div class="sub-content">
				当前共拥有日志${info.blog}篇，请进入我的日志仔细查看
				</div>
				<h1 class="sub-title">投递简历</h1>
				<div class="sub-content">
				您共投递了${info.record }份简历
				</div>
			</div>
			<div id="right">
				<div id="avatar">
					<img src="${session.user.avatar}" />
					<span>${session.user.name}</span>
				</div>
				<div id="user" class="clearfix">
					<div class="user-info">
						<a href="student_friend.action">${info.friend}</a>
						<span>好友</span>
					</div>
					<div class="user-info">
						<a href="student_photo.action">${info.photo}</a>
						<span>照片</span>
					</div>
					<div class="user-info">
						<a href="student_blog.action">${info.blog}</a>
						<span>日志</span>
					</div>
				</div>
				<div class="person-header">个人档案</div>
				<ul class="person-info">
					<li id="stid">学号：</li>
					<li>姓名：${session.user.name}</li>
					<li>专业：${session.user.major}</li>
					<li>性别：${session.user.sex}</li>
					<li>联系方式：${session.user.contact }</li>
				</ul>
				<button id="show" class="changepassword">修改密码</button>
				<button id="update_avatar" onClick="update_avatar()">修改头像</button>
			</div>
		</div>
		<div id="footer">
			<div class="footer-content">
			
			</div>
		</div>
		<script>
		 	var stid = "${session.user.studentid }";
		 	document.getElementById("stid").innerHTML+=stid.split("@")[0];
		</script>
	</body>
</html>
