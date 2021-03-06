<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../css/style1.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<header class="login-header">
    <div class="same">
        <img class="logo-img" src="../images/logo.jpg"/>
    </div>
</header>

<section class="login-main">
    <div class="same clearfix">

        <div class="login-box">
            <h2>用户登录</h2>
            <form action="/login" method="post">
                <div class="login-username">
                    <div class="username-icon"></div>
                    <input id="username" class="username-input" name="username" type="text" placeholder="请输入用户名"/>
                </div>
                <div class="login-pwd">
                    <div class="pwd-icon"></div>
                    <input id="pwd" class="username-input" name="password" type="password" placeholder="请输入密码"/>
                </div>


                <input class="login-btn" type="button" value="登  录"/>
                <div class="span-two">
                    <a href="/register"><span class="span-fir">免费注册</span></a>
                    <a href="##"><span class="span-sec">忘记密码</span></a>
                </div>
            </form>

        </div>
    </div>
</section>

<script src="../js/jquery-1.8.3.min.js"></script>
<script>
    $('.login-btn').click(function () {
        $.ajax({
            type:"POST",
            datatype:"json",
            url: '/login',
            data: {
                'username': $('#username').val(),
                'password': $('#pwd').val()
            },
            success: function (data) {
                console.log(2);
                if (data.code == "false") {
                    alert("输入不合法");

//                    window.location.href = "/login";
                }
                else {
                    window.location.href = "/"
                }
            }
        })
    })
</script>
</body>
</html>