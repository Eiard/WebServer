/**
 * 管理员查询账户信息
 */
// var Name = $('#manager-name').val();
$.ajax({
    url: server_url + netStation_queryAll,
    async: true,
    type: "post",
    contentType: "application/x-www-form-urlencoded",
    timeout: 10000,
    dataType: 'json',
    data: {
        adminUsername: localStorage.getItem('adminUsername'),
    },
    success: function (data) {
        if (data.status === 10) {
            let res = data.data;
            $("#net_name").val(res[0].stationName);
            stationAddress = res[0].stationAddress;
            decodeAddress(stationAddress);
            $('#manage_name').val(res[0].adminName);
            $("#manager_tel").val(res[0].adminPhone);
            $("#manage_account").val(res[0].adminUsername);
            $("#orders_number").val(res[0].orderAmount);
            adminSex=res[0].adminSex;
            SexSelect(adminSex);
            stationName=res[0].stationName;
            adminName=res[0].adminName;
            adminPhone=res[0].adminPhone;
        } else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
            alert(data.msg);
        }
    },
    error: function () {
        //请求出错处理
        // 如果ajax请求本身失败了，则提示ajax请求异常
        alert('查询请求发送失败');
    }
})
