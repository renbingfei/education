<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/en-style.css">
	<link rel="stylesheet" type="text/css" href="css/all-en-list.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/allEnList.js"></script>
  	</head>
  	<body>
  	<!-- 
		<div id="header">
			<div class="header-content">
				<h1>企业列表</h1>
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div class="left-part">
					<h1 class="sub-title">所有企业</h1>
					<div class="sub-content clearfix">
					 -->
						<div id="allenlist" class="clearfix"></div>
						<div id="RJ-pagebar" class="RU-pagebar"></div>
						<!-- 
					</div>
				</div>
				
			</div>
		</div>
		<div id="footer">
			<div class="footer-content">
			
			</div>
		</div>
		 -->
	</body>
</html>
