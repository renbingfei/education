var xmlHttp;

function createXmlHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
	}
}

function upload() {
	createXmlHttp();
	xmlHttp.onreadystatechange = responseTo;
	xmlHttp.open("POST", "update_video_interface.action", true);

	var form = new FormData();
	form.append("file",get("input_video").files[0]);

	xmlHttp.send(form);		
}

function responseTo() {
	var encontainer = get("upload");
	var html = "";
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var response = xmlHttp.responseText;
			var obj = eval('(' + response + ')');
			
			var result = obj.result;
//			alert(""+result);
			
			html += '<form id="upload_video" action="update_video_interface.action" method="post" enctype="multipart/form-data" target="_top">';
			html += '<input id="input_video" type="text" name="file" style="width: 200px; border: 1px solid #666666;" readonly="readonly"'
				+' value="'+result+'"'+'/>';
			html += '<a href="UploadVideoInterface.jsp">新上传</a>';
			html += '</form>';
			encontainer.innerHTML = html;
		} else
			encontainer.innerHTML = "";
	}
}
function get(id) {
	return document.getElementById(id);
}
