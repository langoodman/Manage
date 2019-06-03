function delect(url) {
	var oid = [];
	$(":checked").each(function () {
		var tds = $(this).parent().parent().find('td');
		var td = tds[1].innerHTML;
		oid.push(td);
	});
	//alert(selectedData);查看数据形式
	$.ajax({
		type: "POST",
		url: url + oid,
		data: oid,
		success: function (data) {
			if (data == 1) {
				alert("操作成功");
			} else {
				alert("操作失败");
			}
		}
	});
	$(":checked").parent().parent().remove();
}