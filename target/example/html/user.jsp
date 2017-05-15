<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user</title>
    <link href="../css/style1.css"  rel="stylesheet" type="text/css" />
</head>
<body>
<!--nav-->
<header class="samebg">
    <div class="nav same clearfix">
        <a href="/"><span>首页</span></a>
        <a href="/cart"><span>购物车</span></a>
        <a href="/info"><span>个人信息</span></a>
        <div class="loginbtn">
            <a href="##"><input id="loginbtn" class="btn" type="submit" value="欢迎" /></a>
        </div>
        <div class="search">
            <form >
                <input class="text" type="text" placeholder="请输入搜索内容"/>
                <input class="btn1" type="submit" value="" />
            </form>
        </div>
    </div>
</header>

<!--个人信息-->
<section class="user">
    <div class="usermain same">
        <div>
            <h4>您的基础信息</h4>
            <ul>
                <li><span>用户名：</span><i>${userinfo.username}</i></li>
                <li><span>邮箱：</span><i>${userinfo.email}</i></li>
                <li><span>联系方式：</span><i>${userinfo.tel}</i></li>
                <li><span>地址：</span><i>${userinfo.address}</i></li>
            </ul>
            <h4>您已买到的商品</h4>
            <ul>
                <c:forEach items="${order}" var="o"  >
                    <li>

                    <li>${o.productname}</li>

                    </li>
                </c:forEach>

            </ul>
            <div class="threebtns clearfix">
                <input  class="modify"  type="button" value="修改信息"/>
                <input class="check" type="button" value="确认"/>
            </div>
        </div>
    </div>
</section>



</body>
</html>