import Base64 from 'crypto-js/enc-base64'
import sha256 from 'crypto-js/256'

function login(){

    var username = document.getElementById("username");
    var password = document.getElementById("password").value;


    if(username.value===""){
        alert("请输入用户名");
    }else if(password.value===""){
        alert("请输入密码");
    }


    var salt1 = "ja";
    var salt2 = "yc";
    var salt3 = "hou";

    var pwdWithSalt = salt1+password.substring(0,password.length/2)
        +salt2+password.substring(password.length/2,password.length)
        +salt3;

    alert(pwdWithSalt);

    alert(Base64.stringify(sha256(pwdWithSalt)));
}

function signUp(){
    alert("注册并登录");
}