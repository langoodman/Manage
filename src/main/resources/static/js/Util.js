// 格式化时间：将毫秒转为年-月-日
function dateFormat(time) {
    var timestamp = new Date(time);
    return timestamp.getFullYear()+"-"+(timestamp.getMonth() + 1) + "-"+timestamp.getDate();
}
//格式化时间：将毫秒转为年-月-日 时:分:秒
function datetimeFormat(time) {
    var timestamp = new Date(time);
    return timestamp.getFullYear()+"-"+(timestamp.getMonth() + 1) + "-"+timestamp.getDate()
    + " " + timestamp.getHours()+":"+timestamp.getMinutes()+":"+timestamp.getSeconds();
}

// 在当前界面打开url
function locationHref(url){
    window.location.href = url;
}
// 在新窗口打开url
function locationOpen(url){
    window.open(url);
}
// 自动构造Ajax所需data（后台专用）
function adminDataFormat(obj){
    $tr = $(obj).parent().parent();
    $tds = $tr.find("td[name]");
    var data={};
    $tds.each(function(index,td){
        var  $td = $(td).text();
        var flag = 1;
        if($td.indexOf(".")!=-1){
            flag = 0;
        }
        if($(td).attr("ignore") != undefined){
        	;
        }
        else if(!isNaN($td) && parseInt($td)< 100){
            if( flag != 0 ) data[$(td).attr("name")]=parseInt($td);
            else data[$(td).attr("name")]=parseFloat($td);
    	}
    	else{
    		data[$(td).attr("name")]=$(td).text();
    	}
    });
//    console.log(data);
    return data;
}