<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat,cn.xuhe.entity.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/detail.js"></script>
	<link rel="stylesheet" type="text/css" href="css/detail.css">
	</head>
<body>
	<div class="top-header">
		<div id="logo"></div>
		<div class="top-right-content">
			<div class="clearfix">
				<div id="date"><%=new SimpleDateFormat("yyyy-MM-dd E").format(new Date())%></div>
				<div class="login">
					<a href="#" style="color:rgb(144,31,30)">设为首页</a>
					<a href="regist.jsp" style="color:#aaa">注册</a>
					<a href="login.jsp" style="background:rgb(144,31,30);color:#fff">登录</a>
				</div>
			</div>
			<div class="search">
				<input type="text" name="search" id="s_input"/>
				<input type="submit" value="搜索" id="s_submit" />
			</div>
		</div>
		<div id="weather">
			<iframe width="190" scrolling="no" height="50" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe>
		</div>
		<div id="over"></div>
	</div>
	<div id="nav">
		<div class="nav-content clearfix">
			<ul class="nav-part">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="more.action?type=2">联合会</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=3">新闻</a></li>
				<li><a href="more.action?type=4">焦点</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=17">院校</a></li>
				<li><a href="more.action?type=18">企业</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=5">视频专题</a></li>
				<li><a href="more.action?type=6">人物访谈</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=7">招生</a></li>
				<li><a href="more.action?type=8">创业</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=9">培训认证</a></li>
				<li><a href="more.action?type=10">继续教育</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=11">职场风华</a></li>
				<li><a href="more.action?type=12">职校奇苑</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=13">政策法规</a></li>
				<li><a href="more.action?type=14">国际交流</a></li>
			</ul>
			<ul class="nav-part">
				<li><a href="more.action?type=15">网站服务</a></li>
				<li><a href="more.action?type=16">关于我们</a></li>
			</ul>
		</div>
	</div>
	</div>
	<div class="content">
		<h1>${information.title}</h1>
		<div id="info">
		<div id="info_detail" class="invisible">
			${information.content}
		</div>
			<iframe id="contentdetail">			
			</iframe>
		</div>
	</div>
	
	<div id="footer-bg">
		<div>
			<p>会员服务 | 广告服务 | 项目合作 | 网站公告</p>
 			<p>中国现代职业教育网版权所有 津ICP备14003256号-1</p>  
  			<p>【免责声明】本网站所提供的信息资源，如有侵权违规请及时告知  联系邮箱：zggzgz123@163.com</p>
  		</div>
	</div>
</body>
</html>