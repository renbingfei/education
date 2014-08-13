$(document).ready(function(){
		$("#displayCover").click(function(){
			var cover_note = document.getElementById('cover');
			cover_note.style.display = 'block';
			setTimeout(function(){
				cover_note.style.background = 'rgba(0,0,0,0.8)'
			},0);
			adjust_login_form();
			return false;
		});
		$("#cover").click(function(){
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
				window.history.go(0);
			},500);
			document.getElementById('element').style.top = '-500px';
		})
		function adjust_login_form(){
			var login_note = document.getElementById('element');
			var login_form_width = login_note.clientWidth;
			var login_form_height = login_note.clientHeight;
			var left = (window.innerWidth/2 - login_form_width/2) + 'px';
			var top = (window.innerHeight/2 - login_form_height/2) + 'px';
			login_note.style.left = left;
			login_note.style.top = top;
		}

		window.onresize = function(){
			if(document.getElementById('cover').style.display == 'block')
				adjust_login_form();
		}

	}
);
function doing(){
	get("uploadStatus").setAttribute("src","submitting.jsp");
	inspector = setInterval(function(){
		var status_text=get("uploadStatus").contentWindow.document.getElementsByTagName("body")[0].innerHTML;
		if(status_text.search(/成功/)>=0){
			window.clearInterval(inspector);
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			get('element').style.top = '-500px';
			setTimeout(function(){
				window.history.go(0);
			},500);
			
		}
	},1000)
	
}
