<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat,cn.xuhe.entity.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/image.css">
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.rollGallery_yeso.js"></script>
    <script type="text/javascript" src="js/info.js"></script>
	</head>
<body>
	<div class="top-header">
		<div id="logo"></div>
		<div class="top-right-content">
			<div class="clearfix">
				<div id="date"><%=new SimpleDateFormat("yyyy-MM-dd E").format(new Date())%></div>
				<div class="login">
					<a href="#" style="color:rgb(144,31,30)" onclick="SetHome(this,window.location)" >设为首页</a>
					<a href="regist.jsp" style="color:#aaa">注册</a>
					<%
					if(session.getAttribute("user")!=null){
					%>
					<a href="javascript:void(0)" style="background:rgb(144,31,30);color:#fff">已登录</a>
					<%}else{%>
					<a href="login.jsp" style="background:rgb(144,31,30);color:#fff">登录</a>
					<%}%>
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
	<div id="slider">
		<div id="slider1" class="slider-image">
			<img id="simg1" src="image/loading.gif" />
		</div>
		<div id="slider2" class="slider-image">
			<img id="simg2" src="image/loading.gif" />			
		</div>
		<div id="slider3" class="slider-image">
			<img id="simg3" src="image/loading.gif" />
		</div>
		<div id="slider4" class="slider-image">
			<img id="simg4" src="image/loading.gif" />
		</div>
		<div id="slider5" class="slider-image">
			<img id="simg5" src="image/loading.gif" />
		</div>
		<div id="slider6" class="slider-image">
			<img id="simg6" src="image/loading.gif" />
			<a id="sa6"></a>
		</div>
		
		<div class="slider-control-bg">
			<a id="sa"></a>
			<div class="slider-control">
				<a id="item1" href="javascript:slide(1)" class="slider-control-item active"></a>
				<a id="item2" href="javascript:slide(2)" class="slider-control-item"></a>
				<a id="item3" href="javascript:slide(3)" class="slider-control-item"></a>
				<a id="item4" href="javascript:slide(4)" class="slider-control-item"></a>
				<a id="item5" href="javascript:slide(5)" class="slider-control-item"></a>
				<a id="item6" href="javascript:slide(6)" class="slider-control-item"></a>
			</div>		
		</div>	
	</div>
	<div class="content clearfix">
		<div class="content-span200">
			<div id="content-frame-17" class="content-frame-17">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=17">院校</a><a href="more.action?type=17" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="school">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li>
					<div class="top-item1">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div>
					</li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					
				</ul>
			</div>
			<div id="content-frame-18"  class="content-frame-17">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=18">企业</a><a href="more.action?type=18" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="enterprise">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item1">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					
				</ul>
			</div>
			<div id="content-frame-2"  class="content-frame-2">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=2">联合会</a><a href="more.action?type=2" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f2">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item1">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-14" class="content-frame-14">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=14">国际交流</a><a href="more.action?type=14" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f14">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item1">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-13" class="content-frame-13">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=13">政策法规</a><a href="more.action?type=13" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f13">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item1">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
		</div>
		<div class="content-span400">
			<div id="content-frame-3" class="content-frame-realnew">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=3">新闻</a><a href="more.action?type=3" class="more">more</a></h1>
				</div>
			            <ul class="content-frame-item" id="f3">
				</ul>
			</div>
			<div id="content-frame-6" class="content-frame-6">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=6">人物访谈</a><a href="more.action?type=6" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f6">
					<li><div class="top-item3">
						<img src="image/slider1.jpg" />
						<h1>本期访谈人物——延揽</h1>
						<div class="text">是快餐店打三袋鼠杰克风尘女大蒜可了才发大煞风景可能是</div>
					</div></li>
				</ul>
			</div>
			<div id="content-frame-7" class="content-frame-7">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=7">招生</a><a href="more.action?type=7" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f7">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-9" class="content-frame-9">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=9">培训认证</a><a href="more.action?type=9" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f9">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-11" class="content-frame-11">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=11">职场风华</a><a href="more.action?type=11" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f11">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
		</div>
		<div class="content-span400">
			<div id="content-frame-4"  class="content-frame-4">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=4">焦点</a><a href="more.action?type=4" class="more">more</a></h1>
				</div>
				<div id="fslider">
							<div id="fslider1" class="fslider-image">
								<img id="fsimg1" src="image/loading.gif" />
							</div>
							<div id="fslider2" class="fslider-image">
								<img id="fsimg2" src="image/loading.gif" />				
							</div>
							<div id="fslider3" class="fslider-image">
								<img id="fsimg3" src="image/loading.gif" />
							</div>
							<div id="fslider4" class="fslider-image">
								<img id="fsimg4" src="image/loading.gif" />
							</div>
							<div id="fslider5" class="fslider-image">
								<img id="fsimg5" src="image/loading.gif" />
								<a id="fsa5"></a>
							</div>
							
							<div class="fslider-control-bg">
								
								<div class="fslider-control">
									<a id="fitem1" href="javascript:fslide(1)" class="fslider-control-item active"></a>
									<a id="fitem2" href="javascript:fslide(2)" class="fslider-control-item"></a>
									<a id="fitem3" href="javascript:fslide(3)" class="fslider-control-item"></a>
									<a id="fitem4" href="javascript:fslide(4)" class="fslider-control-item"></a>
									<a id="fitem5" href="javascript:fslide(5)" class="fslider-control-item"></a>
								</div>		
							</div>								
						</div>
				<ul class="content-frame-item" id="f4">
					<a id="fsa"></a>
				</ul>
				<!-- 视频专题 -->
			</div>
			<div id="content-frame-5" class="content-frame-5">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=5">视频专题</a><a href="more.action?type=5" class="more">more</a></h1></div>
					<ul class="content-frame-item" id="f5">
						
					</ul>
					
				
			</div>
			
			<div id="content-frame-8" class="content-frame-8">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=8">创业</a><a href="more.action?type=8" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f8">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-10" class="content-frame-10">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=10">继续教育</a><a href="more.action?type=10" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f10">
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
			<div id="content-frame-12" class="content-frame-12">
				<div class="content-frame-header light-border">
					<h1><a href="more.action?type=12">职校奇葩</a><a href="more.action?type=12" class="more">more</a></h1>
				</div>
				<ul class="content-frame-item" id="f12">
					<li><a href="#" title="使用 Unicode 编码来写字体名称可">正在加载，请稍候...</a></li>
					<li><div class="top-item2">
						<img src="image/slider1.jpg" />
						新华网北京5月14日电（记者刘华）国家主席习近平14日在人民大会堂会见巴基斯坦参议院主席布哈里。
					</div></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
					<li><a href="#" title="正在加载，请稍候...">正在加载，请稍候...</a></li>
				</ul>
			</div>
		</div>
		
		</div>
	<div class="bottom-row clearfix">
			<div class="bottom-row-title">明星企业</div>
			<div class="scrollbox" style="height:90px;">
		<ul id="leftlist">
			<li>
				<a href="#" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
		</ul>
	</div>
	</div>
		<div class="bottom-row clearfix">
			<div class="bottom-row-title">示范学校</div>
			<div class="scrollbox" style="height:90px;">
		<ul id="leftlist1">
			<li>
				<a href="#" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
		</ul>
	</div>
	</div>
		<div class="bottom-row clearfix">
			<div class="bottom-row-title">合作单位</div>
			<div class="scrollbox" style="height:90px;">
		<ul id="leftlist2">
			<li>
				<a href="#" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
		</ul>
	</div>
	</div>
		<div class="bottom-row clearfix">
			<div class="bottom-row-title">友情链接</div>
			<div class="scrollbox" style="height:90px;">
		<ul id="leftlist3">
			<li>
				<a href="#" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
			<li>
					<a href="" target="_blank"><img
				 src="image/6.png" alt="三信国际电器（上海）有限公司" /></a>
				<a href="#" target="_blank"><img src="image/1.png" alt="浙江龙盛集团有限公司" /></a>
				<a href="#" target="_blank"><img src="image/2.png" alt="浙江市下控股有限公司" /></a>
				<a href="#" target="_blank"><img src="image/3.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/4.png" alt="钱江摩托" /></a>
				<a href="#" target="_blank"><img src="image/5.png" alt="钱江摩托" /></a>
			</li>
		</ul>
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
<script type="text/javascript">
$(document).ready(function($){
	
	
	$("#leftlist").rollGallery({
		direction:"left",
		speed:4000,
		showNum:1
	});
	
});
</script>
</html>
