$(document).ready(function(){
		$("#cover").click(function(){
			var cover_note = document.getElementById('cover');
			cover_note.style.background = 'rgba(0,0,0,0)'
			setTimeout(function(){
				cover_note.style.display = 'none';
			},500);
			document.getElementById('element').style.top = '-500px';
		})

	}
);
