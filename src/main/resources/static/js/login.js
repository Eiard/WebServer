// 滑动窗效果
let go_login = document.getElementById('gologin');
let go_register = document.getElementById('goregister');
let form_box = document.getElementsByClassName('form-box')[0];
let register_box = document.getElementsByClassName('register-box')[0];
let login_box = document.getElementsByClassName('login-box')   [0];
go_register.addEventListener('click', () => {
    form_box.style.transform = 'translateX(80%)';
    login_box.classList.add('hidden');
    register_box.classList.remove('hidden');
})
go_login.addEventListener('click', () => {
    form_box.style.transform = 'translateX(0%)';
    register_box.classList.add('hidden');
    login_box.classList.remove('hidden');
})

//登录网点管理员 或 员工
$('input[type=radio][name=select]').change(function () {
    var rdo_select = $(this).val();
    if (rdo_select == 0) {
        //登录网点管理员
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

            $.ajax({
                url: server_url + netStation_login,
                async: true,
                type: "post",
                contentType: "application/x-www-form-urlencoded",
                timeout: 10000,
                dataType: 'json',
                data: {
                    adminUsername: adminUsername,
                    adminPassword: adminPassword
                },
                success: function (data) {
                    if (data.status === 0) {
                        // 删除之前存的cookie
                        if (localStorage.getItem('adminUsername') !== undefined) {
                            localStorage.removeItem('adminUsername')
                        }
                        // 设置新的用户名cookie
                        localStorage.setItem('adminUsername', adminUsername)
                        // 跳转页面
                        window.location.href = "../public/netStation/admin.html"
                    } else if (data.status === 1)
                        alert("账号或密码错误");
                    else if (data.status === 2)
                        alert("审核未通过，暂不能登录！");
                    else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                        alert(data.msg)
                    }
                },
                error: function () {
                    alert('注册请求发送失败');
                }
            })
        })
    }
    // 员工登录
    else if (rdo_select == 1) {

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
            $.ajax({
                url: server_url + employee_login,
                async: true,
                type: "post",
                contentType: "application/x-www-form-urlencoded",
                timeout: 10000,
                dataType: 'json',
                data: {
                    employeeUsername: employeeUsername,
                    employeePassword: employeePassword
                },
                success: function (data) {
                    if (data.status === 0) {
                        // 删除之前存的cookie
                        if (localStorage.getItem('employeeUsername') !== undefined) {
                            localStorage.removeItem('employeeUsername')
                        }
                        // 设置新的用户名cookie
                        localStorage.setItem('employeeUsername', employeeUsername)
                        alert("登陆成功");
                        // 跳转页面
                        window.location.href = "../public/employee/employee_in.html"
                    } else if (data.status === 1)
                        alert("账号或密码错误");
                    else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                        alert(data.msg)
                    }
                },
                error: function () {
                    alert('登录请求发送失败');
                }

            })
        })
    }


    // 注册网点管理员
    $('#register-btn').click(function () {
        var adminName = $('#register-name').val();
        var adminPassword = $('#register-password').val();
        var adminPhone = $('#register-phone').val();
        var adminSex = $('input:radio[name="selectsex"]:checked').val();
        var adminUsername = $('#register-account').val();
        var stationName = $('#register-addressname').val();
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
            alert('密码输入错误！')
            return;
        }
        if (!accountCheck(adminUsername)) {
            alert('用户账号输入错误！')
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
            url: server_url + netStation_register,
            async: true,
            type: "post",
            contentType: "application/x-www-form-urlencoded",
            timeout: 10000,
            dataType: 'json',
            data: {
                netStation: JSON.stringify({
                    adminName: adminName,
                    adminPassword: adminPassword,
                    adminPhone: adminPhone,
                    adminSex: adminSex,
                    adminUsername: adminUsername,
                    stationAddress: stationAddress,
                    stationName: stationName,
                }),
            },

            success: function (data) {
                if (data.status === 3) {
                    alert("注册成功!请去登录!");
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
})


