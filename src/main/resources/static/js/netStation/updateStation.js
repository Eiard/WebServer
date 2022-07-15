//管理员修改账户信息
$('#save_btn').click(function () {
    var adminPassword = $("#old_password").val();
    var newPassword = $("#new_password").val();
    var adminName = $('#manage_name').val();
    var adminPhone = $('#manager_tel').val();
    var adminSex = $('input:radio[name="sex"]:checked').val();
    var stationName = $('#net_name').val();
    var station_province = $("#province option:selected").text();
    var station_city = $("#city option:selected").text();
    var station_district = $("#district option:selected").text();
    var stationAddress = station_province + '-' + station_city + '-' + station_district;

    if (!chineseCheck(adminName)) {
        alert("姓名输入错误！");
        return;
    }

    if (!phoneCheck(adminPhone)) {
        alert('电话号码输入错误！')
        return;
    }
    if (!passwordCheck(adminPassword)) {
        alert('旧密码输入错误！')
        return;
    }
    if (!passwordCheck(newPassword)) {
        alert('新密码输入错误！')
        return;
    }
    if (!chineseCheck(station_province) || !chineseCheck(station_city) || !chineseCheck(station_district)) {
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
        url: server_url + netStation_update,
        async: true,
        type: "post",
        contentType: "application/x-www-form-urlencoded",
        timeout: 10000,
        dataType: 'json',
        data: {
            netStation: JSON.stringify({
                stationName: stationName,
                stationAddress: stationAddress,
                adminName: adminName,
                adminPhone: adminPhone,
                adminPassword: adminPassword,
                adminSex: adminSex,
                adminUsername: localStorage.getItem('adminUsername'),
            }),
            newPassword: newPassword,
        },
        success: function (data) {
            if (data.status === 6) {
                alert("修改成功！请重新登录！");
                top.location.href = "../../login.html";
            } else if (data.status === 7)
                alert("旧密码错误！");
            else if (data.status === 8)
                alert("手机号已存在");
            else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                alert(data.msg);
            }
        },
        error: function () {
            //请求出错处理
            // 如果ajax请求本身失败了，则提示ajax请求异常
            alert('修改请求发送失败');
        }
    })
})
