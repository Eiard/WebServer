//对多选框进行操作
var resert = document.getElementById("resert");
var array = [];
resert.onclick = function () {
    $('input[type=checkbox]').each(function () { //遍历checkbox的选择状态
        if ($(this).prop("checked")) { //如果值为checked表明选中了
            var data = $(this).closest('tr').find('td').eq(2).text();
            array.push(data);
            console.log(array);
            array.length=0;//清空array历史
        }
    })

    $.ajax({
        url: server_url + employee_resetPassword,
        async: true,
        type: "post",
        contentType: "application/x-www-form-urlencoded",
        timeout: 10000,
        dataType: 'json',
        data: {
            employeeUsernameList: array,
        },
        success: function (data) {
            alert(data)
            if (data.status === 6) {
                alert("重置成功！！！")
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

};
