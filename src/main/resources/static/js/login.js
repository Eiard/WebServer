// 要操作到的元素
let go_login = document.getElementById('gologin');
let go_register = document.getElementById('goregister');
let form_box = document.getElementsByClassName('form-box')[0];
let register_box = document.getElementsByClassName('register-box')[0];
let login_box = document.getElementsByClassName('login-box')   [0];
// 去注册按钮点击事件
go_register.addEventListener('click', () => {
    form_box.style.transform = 'translateX(80%)';
    login_box.classList.add('hidden');
    register_box.classList.remove('hidden');
})
// 去登录按钮点击事件
go_login.addEventListener('click', () => {
    form_box.style.transform = 'translateX(0%)';
    register_box.classList.add('hidden');
    login_box.classList.remove('hidden');
})

//登录
$('input[type=radio][name=select]').change(function () {
    var rdo_select = $(this).val();
    if (rdo_select == 1) {
        //登录
        $('#login-btn').click(function () {
            var adminUsername = $('#login-account').val()
            var adminPassword = $('#login-password').val()
            if (!accountCheck(adminUsername)) {
                alert('账号输入错误！')
                return;
            }
            if (!passwordCheck(adminPassword)) {
                alert('密码输入错误！')
                return;
            }
            $.post(
                server_url + netStation_login,
                {
                    adminUsername: adminUsername,
                    adminPassword: adminPassword
                },
                //异步ajax回调函数
                function (data, status) {
                    if (status === 'success') {
                        data = JSON.parse(data)
                        if (data.status === 0) {    //这是后端定义的登录状态码。到这步说明ajax请求本身是没有问题的
                            if (sessionStorage.getItem('adminUsername') !== undefined) {
                                sessionStorage.removeItem('adminUsername')
                            }
                            // 用户名cookie
                            sessionStorage.setItem('adminUsername', adminUsername)

                            // 跳转页面
                            window.location.href = "admin.html"
                        } else if (data.status === 1)
                            alert("账号或密码错误");
                        else if (data.status === 2)
                            alert("审核未通过，暂不能登录！");
                        else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                            alert(data.msg)
                        }
                    } else {    // 如果ajax请求本身失败了，则提示ajax请求异常
                        alert('登录请求发送失败')
                    }
                }
            )
        })
    } else if (rdo_select == 2) {
        $('#login-btn').click(function () {
            var employeeUsername = $('#login-account').val()
            var employeePassword = $('#login-password').val()
            if (!accountCheck(employeeUsername)) {
                alert('账号输入错误！')
                return;
            }
            if (!passwordCheck(employeePassword)) {
                alert('密码输入错误！')
                return;
            }
            $.post(
                server_url + employee_login,
                {
                    employeeUsername: employeeUsername,
                    employeePassword: employeePassword
                },
                //异步ajax回调函数
                function (data, status) {
                    if (status === 'success') {
                        data = JSON.parse(data)
                        if (data.status === 0) {    //这是后端定义的登录状态码。到这步说明ajax请求本身是没有问题的
                            if (sessionStorage.getItem('employeeUsername') !== undefined) {
                                sessionStorage.removeItem('employeeUsername')
                            }
                            // 用户名cookie
                            sessionStorage.setItem('employeeUsername', employeeUsername)

                            // 跳转页面
                            window.location.href = "admin.html"
                        } else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                            alert(data.msg)
                        }
                    } else {    // 如果ajax请求本身失败了，则提示ajax请求异常
                        alert('登录请求发送失败')
                    }
                }
            )
            //
            // $.ajax({
            //     url: server_url + employee_login,
            //     async: true,
            //     type: "Post",
            //     contentType: "application/json; charset=utf-8",
            //     dataType: 'json',//json 返回值类型
            //     data: 'employeeUsername='+employeeUsername+'&employeePassword='+employeePassword,
            //     // :'name='+name+'&pwd='+pwd,
            //     success: function (data) {
            //         if (data.status === 2) {
            //             alert("登录成功!");
            //             window.location.href = "admin.html";
            //         } else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
            //             alert(data.msg);
            //         }
            //     },
            //     error: function () {
            //         //请求出错处理
            //         // 如果ajax请求本身失败了，则提示ajax请求异常
            //         alert('登录请求发送失败');
            //     }
            // })
        })
    }
});
