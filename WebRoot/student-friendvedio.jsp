<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student-status.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/student-status.css">
	<script type="text/javascript" src="js/status.js"></script>

  </head>
  
  <body>
		<div id="header">
			<h1>好友空间</h1>
			<div id="exit">
				<a href="student_person.action">返回</a>
			</div>
		</div>
		<div id="nav">
			<div class="nav-content">
				<a href="student_friendphoto.action">相册</a>
				<a href="student_friendblog.action">日志</a>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div id="avatar">
					<img src="${session.user.avatar}" /> 
					<span class="username">${session.user.name}</span>
				</div>
				<div id="banner">
					<h1>动态</h1>
					<a href="javascript:list_friends_status()">好友动态</a>
					<a href="javascript:list_my_status()">我的动态</a>
					<a href="#">与我相关</a>
				</div>
			</div>
			<div id="right">
				<div class="status">
					<div class="status-header clearfix">
						<div class="status-avatar">
							<img src="image/123.jpg" />
						</div>
						<div class="status-message">
							<div class="status-content-name">云淡风轻</div>
							<div class="status-content-description">在2014.2.15发表了标题为“ABC”的日志</div>
						</div>
					</div>
					<div class="status-content">
						1233453534534534653464346346<br>wetwetewtewtwetwe<br>eterterterte<br>
					</div>
					<div class="status-comment-control">
						<a href="#" id="comment">展开评论</a>
					</div>
					<div class="status-bottom clearfix">
						<div class="status-avatar">
							<img src="image/123.jpg" />
						</div>
						<div class="status-message">
							<div class="status-content-name">云淡风轻评论了我的日志</div>
							<div class="status-content-description">在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志</div>
						</div>
					</div>
				</div>
				<div class="status">
					<div class="status-header clearfix">
						<div class="status-avatar">
							<img src="image/123.jpg" />
						</div>
						<div class="status-message">
							<div class="status-content-name">云淡风轻</div>
							<div class="status-content-description">在2014.2.15发表了标题为“ABC”的日志</div>
						</div>
					</div>
					<div class="status-content">
						1233453534534534653464346346<br>wetwetewtewtwetwe<br>eterterterte<br>
					</div>
					<div class="status-bottom clearfix">
						<div class="status-avatar">
							<img src="image/123.jpg" />
						</div>
						<div class="status-message">
							<div class="status-content-name">云淡风轻评论了我的日志</div>
							<div class="status-content-description">在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志在2014.2.15发表了标题为“ABC”的日志</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="footer-content">
			
			</div>
		</div>
	</body>
</html>

</html>
