// 注册网点管理员
$('#addEmployee_btn').click(function () {
    var employeeName = $('#add_employeeName').val();
    var employeePassword = $('#add_employeePassword').val();
    var employeePhone = $('#add_employeePhone').val();
    var employeeSex = $('input:radio[name="add_sex"]:checked').val();
    var employeeUsername = $('#add_employeeUsername').val();
    var stationId = $('#add_stationId').val();

    if (!chineseCheck(employeeName)) {
        alert("姓名输入错误！");
        return;
    }

    if (!phoneCheck(employeePhone)) {
        alert('电话号码输入错误！')
        return;
    }
    if (!passwordCheck(employeePassword)) {
        alert('密码输入错误！')
        return;
    }
    if (!accountCheck(employeeUsername)) {
        alert('用户账号输入错误！')
        return;
    }
    if (!accountCheck(stationId)) {
        alert('站点ID输入错误！')
        return;
    }
    if (employeeSex === undefined) {
        alert('性别不得为空！')
        return;
    }

    $.ajax({
        url: server_url + employee_sign,
        async: true,
        type: "post",
        contentType: "application/x-www-form-urlencoded",
        timeout: 10000,
        dataType: 'json',
        data: {
            employee: JSON.stringify({
                employeeName: employeeName,
                employeePassword: employeePassword,
                employeePhone: employeePhone,
                employeeSex: employeeSex,
                employeeUsername: employeeUsername,
                stationId: stationId
            }),
        },

        success: function (data) {
            if (data.status === 3) {
                alert("派送员注册成功！");
                window.location.href = "../../public/employee/add_employee.html";
            } else if (data.status === 4)
                alert("用户名已存在！");
            else if (data.status === 5)
                alert("手机号已存在！");
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

