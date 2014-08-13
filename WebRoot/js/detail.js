
function get(id){
	return document.getElementById(id);
}

$(document).ready(function(){
	document.getElementsByTagName("iframe")[0].id="detail";
	var idocument =document.getElementsByTagName("iframe")[1].contentWindow.document;
	var ibody = idocument.getElementsByTagName("body")[0];
	var idiv = idocument.createElement("div");
	idiv.innerHTML = get("info_detail").innerHTML;
	ibody.appendChild(idiv);
}
);
