/**
 * 离职员工申请表
 */
tableout(1);

function tableout(current) {
    $.ajax({
        url: server_url + employee_out_query,
        async: true,
        type: "post",
        contentType: "application/x-www-form-urlencoded",
        timeout: 10000,
        dataType: 'json',
        data: {
            current: current,
            adminUsername:localStorage.getItem('adminUsername'),
        },
        success: function (data) {
            if (data.status === 10) {
                create_tableout(data);
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

}

function create_tableout(data) {
    let employee = data.data;
    page=data.totalPage;
    $("#table-out tbody").remove();
    let temp = '';
    temp += '<tbody id="employee_out">';
    for (let i = 0; i < data.data.length; i++) {
        let employeesex = Sex(employee[i].employeeSex);
        temp +=
            '<tr  id="check_out' + i + '">' +
            '<td>' + employee[i].employeeId + '</td>' +
            '<td>' + employee[i].employeeName + '</td>' +
            '<td>' + employee[i].employeeUsername + '</td>' +
            '<td>' + employee[i].employeePhone + '</td>' +
            '<td>' + employeesex + '</td>' +
            '<td>' + employee[i].resignReason + '</td>' +
            // '<td>' + '<input type="checkbox" name="items" oninput="Checkbox()" class="i-checks">' + '</td>' +
            '</tr>';
    }
    temp += '</tbody>';
    $("#table-out").append(temp);
}

