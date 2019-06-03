window.onload = function () {
    var url = '/user/getUserData?';
    var suburl = "/tutor/admin/operationTeacher";
    var content = document.getElementById('mainbody');
    var tmp = '';
    var list = 0;
    ajax({
        url: '/user/getUserDataCount', //和下面的url不一样
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
                    tmp += '<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;"><td><input type="checkbox" value="" editable="false" name="checkbox"></td><td name="id" style="display:none;">' + context.id + '</td><td name="cardId">' + context.cardId + '</td><td name="phoneNumber">' + context.phoneNumber + '</td><td name="name">' + context.name + '</td><td name="gender">' + context.gender + '</td><td name="status">' + context.status + '</td><td name="pharmacyId">' + context.pharmacyId + '</td><td name="integral">' + context.integral + '</td><td name="signTime">' + context.signTime + '</td><td><button type="button" class="btn btn-warning btnSubmit" onclick="submitmessage(this,\'' + suburl + '\')">提交 </button></td><tr>';
                    // tmp += '<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;"><td><input type="checkbox" value="" editable="false" name="checkbox"></td><td name="tid" style="display:none;">' + context.tid + '</td><td name="phoneNumber">' + context.phone_number + '</td><td name="school">' + context.school + '</td><td name="name">' + context.name + '</td><td name="describes">' + context.describes + '</td><td name="achievement">' + context.achievement + '</td><td name="subjects">' + context.subjects + '</td><td name="statusId">' + context.status - id + '</td><td name="count">' + context.count + '</td><td><button type="button" class="btn btn-warning btnSubmit" onclick="submitmessage(this,' + suburl + ')">提交 </button></td><tr>';
                });
                content.innerHTML = tmp;
                tmp = '';
            },
            error: function (err) {
                alert('请求数据失败');
            }
        })
    }


    //示例化分页组件，指定条数
    //         new myPagination({
    //		        id: 'pagination',
    //		        curPage: 1, //初始页码
    //		        pageTotal: 5,//总共多少页
    //		        pageAmount: 10, //每页多少条
    //		        dataTotal: 50, //总共多少条数据
    //		        pageSize: 5, //可选,分页个数
    //		        showPageTotalFlag: true, //是否显示数据统计
    //		        showSkipInputFlag: true, //是否支持跳转
    //		        getPage: function(page) {
    //		          // 点击分页按钮请求数据
    //		            getData(page);
    //		        }
    //		    })
    //计算过条数
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