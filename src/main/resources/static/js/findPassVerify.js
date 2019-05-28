    function fun(id){
    	return document.getElementById(id);
	}
	var flag = 0;//看是否输入都合法
	var mark = 0;//看是否可以提交
	var verify = "";//验证码
    function getVerify(){
        var $button = fun("sendVerifyCode");
		var number = 60;
		var countdown = function(){
			if (number == 0) {
			    $button.disabled = false;
			    $button.innerHTML="发送验证码";
	            number = 60;
	            return;
	        }
	        else {
	        	$button.setAttribute("disabled", "disabled");
	        	$button.innerHTML=number + "秒重新发送";
	        	number--;
	        }
			setTimeout(countdown,1000);
		}
		setTimeout(countdown,1000);

        var msg = fun("msg");
        var $phoneNumber = fun("phoneNumber");
        var $email = fun("email");
		var data = {};
		data.phoneNumber = $phoneNumber.value;
		data.email = $email.value;
		if( data.email == '' ){
		    msg.innerHTML="请输入邮箱";
            flag = 0;
		}
		else{
		    msg.innerHTML="";
		    flag = 1;
		}
		if(data.phoneNumber == ''){
		    msg.innerHTML="请输入手机号码";
            flag = 0;
		}
		else{
		    flag = 1;
		    msg.innerHTML="";
	    }
		var reg = /^1(3|4|5|7|8|9)\d{9}$/;
		if(!reg.test(data.phoneNumber)){
		    msg.innerHTML="请输入合法的手机号码";
            flag = 0;
		}
		else{
		    flag = 1;
		    msg.innerHTML="";
		}
		if( flag == 1 ){
//		    console.log(data);
		    $.ajax({
        	    url: "admin/getVerify",
        	    async : true,
                type: "post",
                contentType:"application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify(data),
      	        success: function (data) {
      	            console.log(data);
        	        if(data.verify != "error"){
        	            alert("验证码已经发送到邮箱,请注意查收!");
        	            verify = data.verify;
        	            mark = 1;
        	        }
        	        else{
        	            alert("验证码发送失败!请检查你的电话号码或者邮箱!");
        	            mark = 0;
        	        }
        	    },
        	    error: function(XMLHttpRequest, textStatus, errorThrown){
        	        alert("验证码发送失败!");
        	        console.error(XMLHttpRequest);
                    mark = 0;
        	    }
            });
		}
    }
    function checkSubmit(){
           if( mark == 1 && flag == 1 ){
                var verification = fun("verification");
                if( verification.value == verify ){
                    msg.innerHTML="";
                    return true;
                 }
                 else{
                    msg.innerHTML="验证码不正确";
                    return false;
                 }
           }
           else{
                msg.innerHTML="信息不正确!";
                return false;
           }
    }