<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'UploadVideoInterface.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/upload_video_interface.js"></script>

	</head>

	<body>
		<div id="upload">
			<form id="upload_video" action="update_video_interface.action"
				method="post" enctype="multipart/form-data" target="_top">


				<table border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td>
								<input id="input_video" type="file" name="file"
									style="width: 200px; border: 1px solid #666666;"
									onkeypress=returnfalse;>
							</td>
							<td>
								<input type="button" name="Submit" value="上传"
									style="border: 1px solid #666666; margin-left: 5px"
									onclick="this.disabled=true;this.value='稍候';upload()"
								>
							</td>
						</tr>
					</tbody>
				</table>


			</form>
		</div>
	</body>
</html>
