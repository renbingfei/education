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
	<link rel="stylesheet" type="text/css" href="css/en-person.css">
	<script type="text/javascript" src="js/jquery.js"></script>"
	<script type="text/javascript" src="js/en-info.js"></script>
	<link rel="stylesheet" type="text/css" href="css/cover.css">
	<script type="text/javascript" src="js/cover2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/all-en-list.css">
	<link type="text/css" href="css/en-info.css" rel="stylesheet">
	

	
  	</head>
  	<body>
  	<div id="cover"></div>
	  	<div id="element" class="element">
	  		<div class="uploadHeader">招聘信息详情</div>
	  		<table id="info">
	  		
	  		</table>
	  	</div>
		<div id="header">
			<div class="header-content">
				<h1>企业简介</h1><h1>${enterprise.name}</h1>
				<input id="enterpriseid" type="text" class="invisible" value="${enterprise.id}" />"
			</div>
		</div>
		<div id="section" class="clearfix">
			<div id="left">
				<div class="left-part">
					<h1 class="sub-title">企业档案</h1>
					<div class="sub-content clearfix">
						<div id="avatar">
							<img src="${enterprise.url}" />
						</div>
						<div id="info">
							<ul class="person-info">
								<li><b>名称：</b>${enterprise.name}</li>
								<li><b>简介：</b>${enterprise.info}</li>
								<li><b>地址：</b>${enterprise.address}</li>
								<li><b>联系方式：</b>${enterprise.contact}</li>
							</ul>			
						</div>
					</div>
				</div>
				<div class="left-part">
					<h1 class="sub-title">企业相册</h1>
					<div id="photocontainer" class="sub-content clearfix">
						<div class="photo">
							<img src="image/123.jpg" />
						</div>
						<div class="photo">
							<img src="image/123.jpg" />
						</div>
						<div class="photo">
							<img src="image/123.jpg" />
						</div>
						<div class="photo">
							<img src="image/123.jpg" />
						</div>
					</div>
					<a id="moreinfo" href="en_photo_list.action?eid=${enterprise.id}">查看更多</a>
				</div>
				<div class="left-part">
				<h1 class="sub-title">企业招聘信息</h1>
				<div id="enone-list" class="clearfix">
				
			</div>
				
			<div id="RJ-pagebar" class="RU-pagebar"></div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="footer-content">
			
			</div>
		</div>
	</body>
</html>
