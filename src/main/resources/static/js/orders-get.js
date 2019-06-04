window.onload = function () {
    var url = '/orders/getOrdersData?';
    var suburl = "/orders/operationOrders";
    var content = document.getElementById('mainbody');
    var tmp = '';
    var list = 0;
    ajax({
        url: '/orders/getOrdersDataCount', //和下面的url不一样
        type: "get",
        dataType: "json",
        success: function (data) {
            list = parseInt(data); //计算后台有多少条数据
            getData(1);
            buildPagination();
        },
        error: function (err) {
            alert('请求数据失败');
        }
    })

    // 使用ajax函数请求数据并渲染到页面
    function getData(page) {
        content.innerHTML = '正在加载...';
        ajax({
            url: url + 'startPage=' + page + '&PageSize=10',
            // url: url + 'Page=' + page + '&PageSize=10',
            type: "get",
            dataType: "json",
            success: function (data) {
                var list = data;
                // var list = data.data;
                list.forEach(function (context) {
                    tmp += '<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;"><td><input type="checkbox" value="" editable="false" name="checkbox"></td><td name="id" style="display:none;">' + context.id + '</td><td name="staffName">' + context.staffName + '</td><td name="pharmacyName">' + context.pharmacyName + '</td><td name="userCardId">' + context.userCardId + '</td><td name="shouldMoney">' + context.shouldMoney + '</td><td name="reallyMoney">' + context.reallyMoney + '</td><td name="integral">' + context.integral + '</td><td><button type="button" class="btn btn-warning btnSubmit" onclick="submitmessage(this,\'' + suburl + '\')">提交 </button></td><tr>';
                });
                content.innerHTML = tmp;
                tmp = '';
            },
            error: function (err) {
                alert('请求数据失败');
            }
        })
    }

    function buildPagination(){
		   new myPagination({
			   id: 'pagination',
			   curPage: 1, //初始页码
			   pageTotal: Math.ceil(list/10),//总共多少页
			   pageAmount: 10, //每页多少条
			   dataTotal: list, //总共多少条数据
			   pageSize: 5, //可选,分页个数
			   showPageTotalFlag: true, //是否显示数据统计
			   showSkipInputFlag: true, //是否支持跳转
			   getPage: function(page) {
				   // 点击分页按钮请求数据
				   getData(page);
			   }
		   });
	   }

}