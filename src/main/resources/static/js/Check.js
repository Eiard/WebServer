//用户名正则检查
var accountCheck = function (admin_username) {
    admin_username = admin_username.replaceAll(' ', '')
    var pattern = /^[A-Za-z0-9]+$/
    return pattern.test(admin_username)
}
//正则检查 只能输入中文
var chineseCheck=function(name){
    name=name.replaceAll(' ',' ')
    var pattern=/^[\u4E00-\u9FA5]+$/
    return pattern.test(name);
}
//电话号码正则检查
var phoneCheck = function (phone) {
    phone = phone.replaceAll(' ', ' ')
    var pattern=/^[1-9][0-9]{10}$/
    return pattern.test(phone)
}
//密码正则检查
var passwordCheck = function (password) {
    password = password.replaceAll(' ', ' ')
    var pattern = /^[A-Za-z0-9]{6,10}$/
    return pattern.test(password)
}