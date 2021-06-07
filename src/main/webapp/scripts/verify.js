//验证密码
function verify() {
    var a = $(".password1").val();
    //console.log(a=='')
    var b = $(".password2").val();
    //console.log(b)
    if (a == '' || a != b) {
        alert("输入有误，请重试！")
        return false;
    }
}