/**
 * 在职员工信息查询
 */
tablein(1);

function tablein(current) {
    $.ajax({
        url: server_url + employee_in_query,
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
                create_tablein(data);
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


function create_tablein(data) {
    let employee = data.data;
    page=data.totalPage;
    $("#table-in tbody").remove();
    let temp = '';
    temp += '<tbody id="employee_in">';
    for (let i = 0; i < data.data.length; i++) {
        let employeesex = Sex(employee[i].employeeSex);
        temp +=
            '<tr id="check_in' + i + '">' +
            '<td>' + employee[i].employeeId + '</td>' +
            '<td>' + employee[i].employeeName + '</td>' +
            '<td>' + employee[i].employeeUsername + '</td>' +
            '<td>' + employee[i].employeePhone + '</td>' +
            '<td>' + employeesex + '</td>' +
            '<td>' + employee[i].orderAmount + '</td>' +
            '<td>' + employee[i].createDate + '</td>' +
            '<td>' + '<input type="checkbox" name="items" class="i-checks">' + '</td>' +
            '</tr>';
    }
    temp += '</tbody>';
    $("#table-in").append(temp);
}










