function showphoto(imgname){
			var cover_note = document.getElementById('cover1');
			cover_note.style.display = 'block';
			setTimeout(function(){
				cover_note.style.background = 'rgba(0,0,0,0.8)'
			},0);
			document.getElementById('oldphoto').src = imgname;
			adjust_photo_form();
			return false;
		};
$(document).ready(function(){
		$("#cover1").click(function(){
			var cover_note = document.getElementById('cover1');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			document.getElementById('photoshow').style.top = '-500px';
		})
})
		function adjust_photo_form(){
			var login_note = document.getElementById('photoshow');
			var login_form_width = login_note.clientWidth;
			var login_form_height = login_note.clientHeight;
			var left = (window.innerWidth/2 - login_form_width/2) + 'px';
			var top = (window.innerHeight/2 - login_form_height/2) + 'px';
			login_note.style.left = left;
			login_note.style.top = top;
		}

		window.onresize = function(){
			if(document.getElementById('cover1').style.display == 'block')
				adjust_photo_form();
		}

	

