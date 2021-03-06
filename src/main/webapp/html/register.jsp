<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link href="../css/style1.css"  rel="stylesheet" type="text/css" />
    <style>
        .login-box{border: 0 none;margin-top: 10px;}
        .login-box h2{padding-left: 18px;}
    </style>
    <script src="../js/jquery-1.8.3.min.js"></script>
</head>
<body>

<header class="login-header">
    <div class="same">
        <img class="logo-img" src="../images/logo.jpg"/>
    </div>
</header>



<!--注册-->
<section class="login-main">
    <div class="same clearfix">

        <div class="login-box">
            <h2>用户注册</h2>
        <form>
            <ul class="register-form">
                <li><span>用户名：</span><input type="text" id="username" placeholder="请输入用户名"  /></li>
                <li><span>密码：</span><input type="password" id="password"  placeholder="请输入密码"  /></li>
                <li><span>确认密码：</span><input type="password" id="password2"  placeholder="确认密码"  /></li>
                <li><span>联系方式：</span><input type="text" id="tel"  placeholder="联系方式"  /></li>
                <li><span>邮箱：</span><input type="text" id="email"  placeholder="请输入邮箱"  /></li>
                <li><span>地址：</span><input type="text" id="address"  placeholder="请输入地址"  /></li>
            </ul>
             <div class="subres">
                 <input class="regsub" type="button" value="提交" />
                 <input  class="regres" type="reset" value="重置"  >
             </div>
        </form>
        </div>
    </div>
</section>
</body>

<script>
    $(".regsub").click(function () {
        var username =$('#username').val();
        var password =$('#password').val();
        var password2 =$('#password2').val();
        var tel =$('#tel').val();
        var email =$('#email').val();
        var address =$('#address').val();
        if (username=="") {
            alert("用户名不许为空");
            return;
        }
        else if (password=="") {
            alert("密码不许为空");
            return;
        }
        else if (password2=="") {
            alert("确认密码不许为空");
            return;
        }
        else if (tel=="") {
            alert("电话不许为空");
            return;
        }
        else if (email=="") {
            alert("邮箱不许为空");
            return;
        }else if (address=="")
        {
            alert("地址不许为空");
            return;
        }else if (password !== password2) {
            alert("两次密码输入不一致");
            return;
        }
        else{
        $.ajax({
            type:"POST",
            datatype:"json",
            url:"/register",
            data:{
                username:$('#username').val(),
                password:$('#password').val(),
                tel:$("#tel").val(),
                email:$('#email').val(),
                address:$("#address").val(),},
            success:function (data) {
                console.log(data);
                if(data.code =="00000"){
                    alert("注册成功");
                    window.location.href="/login";
                }else if(data.code =="10000"){
                    alert("用户名已存在");
                    window.location.href="/register";
                }else{
                    alert("添加失败");
                    window.location.href="/register";
                }

            }
        })
        }
    })

</script>
</html>