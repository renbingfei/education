<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>日志</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style_1.css">
	<link rel="stylesheet" type="text/css" href="css/student-blog.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/tinymce.min.js"></script>
	<script type="text/javascript" src="js/plugins/emoticons/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/anchor/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/paste/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/pagebreak/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/searchreplace/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/spellchecker/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/visualblocks/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/visualchars/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/fullscreen/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/insertdatetime/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/nonbreaking/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/table/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/directionality/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/hr/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/preview/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/print/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/fullpage/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/contextmenu/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/layer/plugin.min.js"></script>
	<script type="text/javascript" src="js/plugins/lists/plugin.min.js"></script>
	<script type="text/javascript" src="js/themes/modern/theme.min.js"></script>"
	<script type="text/javascript" src="js/blog.js"></script>

  </head>
  
  	<body>
  		<div id="cover"></div>
	  	<div id="element" class="element">
	  		<div class="uploadHeader">上传照片</div>
	  		<form action="pic_save.action" method="post" enctype="multipart/form-data" target="uploadStatus">
	  		<input id="picfile" type="file" name="file" />
	  		<div class="important">请上传图片格式的文件</div>
	  		<input type="text" id="infotag" name="infotag" class="invisible"/>
	  		<input id="picup" type="submit" onclick="doing()" value="上传" />
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
				<a href="student_person.action">个人中心</a>
				<a href="student_friend.action">我的好友</a>
				<a href="student_photo.action">相册</a>
				<a class="active">日志</a>
				<a href="student_resume.action">我的应聘</a>
				<a href="student_find.action">逛逛企业</a>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div id="fun1">
					<h1 class="sub-title">我的日志</h1>
					<div id="blog">
						<div id="bloglist" class="clearfix"></div>
						<div id="RJ-pagebar" class="RU-pagebar"></div>
					</div>
				</div>
				<div id="fun2">
					<form action="uploadblog.action" method="get" target="_top">
					<h1 class="sub-title">写日志</h1>
					<div class="row">
						<div class="span1">标题：</div>
						<div class="span11">
							<input type="text" name="title" id="title" />
						</div>
					</div>
					<div class="row">
						<div class="span1">正文：</div>
						<div id="mceu_150" class="mce-container mce-first mce-last mce-btn-group" role="group">
							<div id="mceu_150-body">
								<div id="mceu_151" class="mce-widget mce-btn mce-first mce-last" tabindex="-1" aria-labelledby="mceu_151" role="button" aria-label="Insert/edit image">
								<button id="displayCover" role="presentation" type="button" tabindex="-1">
									<i class="mce-ico mce-i-image"></i>
								</button>
								</div>
							</div>
						</div>
						<div class="span11">
							<textarea class="editme"></textarea>
							<input type="text" name="content" id="conup" class="invisible" />			
						</div>
					</div>
					<div class="row">
						<input type="button" value="发表日志" class="submit" onclick="blog_up()"/>
					</div>
					</form>
				</div>
			</div>
			<div id="right">
				<div id="avatar">
					<img src="${session.user.avatar}" />
					<span>${session.user.name }</span>
				</div>
				<div class="counter">
					您当前共有0分日志
				</div>
				<a href="javascript:writeblog()" id="writeBlog">写日志</a>
				<a href="javascript:myblog()" id="myBlog">我的日志</a>
				<!--  <a href="#" id="listBlog">写日志</a>-->
				<div class="hotBlog">
					<h1>热门日志</h1>
				</div>
			</div>
		</div>
	</body>
</html>
