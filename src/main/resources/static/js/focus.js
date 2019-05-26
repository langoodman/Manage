var focus_id = 1;
var focus_time = 0;
var focus_bg = "";
var focus_begin = true;
var focus_interval;
var focus_count;
var focus_url = "";
var focus_title = "";
if(navigator.appName == "Microsoft Internet Explorer")
{
	focus_count = document.getElementById("focus_img").childNodes.length;
}else{
	focus_count = document.getElementsByName("focus_img").length;
}
function func_focus()
{
	if(focus_id > focus_count) focus_id = 1;
	if(!focus_begin) clearInterval(focus_interval);
	focus_interval = setInterval("focus_show(" + focus_id + ")",50);
}
function focus_show(id)
{
	if(focus_time < 20 && focus_bg != "")
	{
		var v = 100 / 20;
		if(navigator.appName=="Microsoft Internet Explorer")
		{
			document.getElementById("focus_show").style.filter = "Alpha(Opacity=" + (v * focus_time) + ")";
		}else{
			document.getElementById("focus_show").style.opacity = v * focus_time / 100;
		}
		focus_time ++;
	}else if(focus_count > 0){
		if(!focus_begin)
		{
			document.getElementById("focus_bg").innerHTML = "<img src='" + focus_bg + "' />";
			focus_time = 0;
			clearInterval(focus_interval);
		}
		var val = document.getElementById("focus_" + focus_id).innerHTML;
		var arr = val.split("|");
		if(navigator.appName=="Microsoft Internet Explorer")
		{
			document.getElementById("focus_show").style.filter = "Alpha(Opacity=0)";
		}else{
			document.getElementById("focus_show").style.opacity = 0;
		}
		document.getElementById("focus_show").innerHTML = "<a href='" + focus_url + "' target='_blank' title='" + focus_title + "'><img src='" + arr[0] + "' /></a>";
		focus_url = arr[1];
		focus_title = arr[2];
		if(focus_count > 1) focus_id ++;
		if(!focus_begin) focus_interval = setInterval("func_focus()",1000); else focus_begin = false;
		focus_bg = arr[0];
	}
}
func_focus();

