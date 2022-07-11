//注册
$("#register-city").change(function () {
    var pro = $(this).val();
    //选择荆州市
    if (pro == 2) {
        var jz = "<option value=' '>请选择...</option>";
        jz += "<option value='3'>荆州区</option>";
        jz += "<option value='4'>沙市区</option>";
        $("#register-district").html(jz);

    } else if (pro == 3) {
        var wh = "<option value=' '>请选择...</option>";
        wh += "<option value='5'>江汉区</option>";
        wh += "<option value='6'>武昌区</option>";
        $("#register-district").html(wh);
    }
})


$('#register-btn').click(function () {
    var adminName = $('#register-name').val();
    var adminPassword = $('#register-password').val();
    var adminPhone = $('#register-phone').val();
    var adminSex = $('input:radio[name="selectsex"]:checked').val();
    var adminUsername = $('#register-account').val();
    var stationName = $('#register-addressname').val();
    var station_city = $("#register-city option:selected").text();
    var station_district = $("#register-district option:selected").text();
    var stationAddress = '湖北省-' + station_city + '-' + station_district;

    if (!chineseCheck(adminName)) {
        alert("姓名输入错误！");
        return;
    }

    if (!phoneCheck(adminPhone)) {
        alert('电话号码输入错误！')
        return;
    }
    if (!passwordCheck(adminPassword)) {
        alert('密码输入错误！')
        return;
    }
    if (!accountCheck(adminUsername)) {
        alert('用户账号输入错误！')
        return;
    }
    if (!chineseCheck(station_city) || !chineseCheck(station_district)) {
        alert('地址输入错误！')
        return;
    }
    if (!chineseCheck(stationName)) {
        alert('站点输入错误！')
        return;
    }
    if (adminSex === undefined) {
        alert('性别不得为空！')
        return;
    }

    $.ajax({
        url: server_url + netStation_register,
        async: true,
        type: "post",
        contentType: "application/x-www-form-urlencoded",
        timeout: 10000,
        dataType: 'json',
        
        data: {
            netStation: JSON.stringify(
                {
                    adminName: adminName,
                    adminPassword: adminPassword,
                    adminPhone: adminPhone,
                    adminSex: adminSex,
                    adminUsername: adminUsername,
                    stationAddress: stationAddress,
                    stationName: stationName,
                }
            )
            ,
            str: 123,
        },


        success: function (data) {
            if (data.status === 3) {
                alert("注册成功!请重新登录!");
                window.location.href = "login.html";
            } else if (data.status === 4)
                alert("用户名已存在！");
            else if (data.status === 5)
                alert("手机号已存在");
            else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                alert(data.msg);
            }
        },
        error: function () {
            //请求出错处理
            // 如果ajax请求本身失败了，则提示ajax请求异常
            alert('注册请求发送失败');
        }
    })
})
