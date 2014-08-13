<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/findPassword.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/findPassword.js"></script>
  </head>
  
  <body>
  		<div id="header">
  			<h1>中国现代职业教育</h1><h1>找回密码</h1>
  		</div>
  		<div id="section">
  			<div id="center">
  				<div id="step1" class="step">
  					<h1 class="ht">验证用户名</h1>
  					<span class="hs">输入用户名，选择用户类型并提交</span>
  					<div id="status1" class="status">1234</div>
  					<div class="operationArea">
  						<span class="as">您的用户名是：</span>
  						<input type="text" class="username" name="username" id="username" autocomplete="off"/>
   						<span class="as">您的身份是：</span><br/>
  						<a href="javascript:select(0)" id="role0" class="role negative">学生</a>
  						<a href="javascript:select(1)" id="role1" class="role positive">企业</a>
  						<a href="javascript:getQuestion()"class="submit">提交</a>
  					</div>
  				</div>
  				<div id="step2" class="step">
  					<h1 class="ht">验证密保</h1>
  					<span class="hs">请回答三个密保问题，回答正确后可以重置密码</span>
  					<div id="status2" class="status">与错误</div>
  					<div class="operationArea">
  						<span class="as">问题一：<span id="question1"></span></span>
  						<input type="text" class="answer" name="answer1" id="answer1" autocomplete="off" placeholder="请回答"/>
  						<span class="as">问题二：<span id="question2"></span></span>
  						<input type="text" class="answer" name="answer2" id="answer2" autocomplete="off" placeholder="请回答"/>
  						<span class="as">问题三：<span id="question3"></span></span>
  						<input type="text" class="answer" name="answer3" id="answer3" autocomplete="off" placeholder="请回答"/>
   						<a href="javascript:checkAnswer()" class="submit">提交</a>
  					</div>
  				</div>
  				<div id="step3" class="step">
  					<h1 class="ht">重置密码</h1>
  					<span class="hs">请输入您的新密码</span>
  					<div id="status3" class="status"></div>
  					<div class="operationArea">
  						<span class="as">请输入您的新密码：</span>
  						<input type="text" class="answer" id="password" autocomplete="off"/>
   						<a href="javascript:setPassword()" class="submit">提交</a>
  					</div>
  				</div>
  			</div>
  		</div>
  </body>
</html>
