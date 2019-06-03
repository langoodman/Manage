function submitmessage(btn,turl) {
    $.ajax({
        type: "POST",
        url: turl,
        data: adminDataFormat(btn),
        success: function (data) {
            if (data == "1") {
                alert("操作成功");
            } else {
                alert("操作失败");
            }
        }
    });
}