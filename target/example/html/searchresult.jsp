<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>searchresult</title>

</head>
<link href="../css/style1.css"  rel="stylesheet" type="text/css" />
<body>
<header class="samebg">
    <div class="nav same clearfix">
        <a href="/"><span>首页</span></a>
        <a href="/cart"><span>购物车</span></a>
        <a href="/user"><span>个人信息</span></a>
        <c:if test="${user.username == null}">
            <div class="loginbtn">
                <a href="/login"><input id="loginbtn1" class="btn" type="submit" value="登陆" /></a>
            </div>
        </c:if>
        <c:if test="${user.username != null}">
            <div class="loginbtn">
                <input id="loginbtn" class="btn" type="submit" value="欢迎" />
            </div>
        </c:if>
        <div class="search">
            <form  action="/search" method="post">
                <input class="text" type="text" name="name" placeholder="请输入搜索内容"/>
                <input class="btn1" type="submit" value="" />
            </form>
        </div>
    </div>
</header>


<!--搜索结果-->
<section class="hotsell ">
    <div class="hotsellmain same">
        <h3>相关商品</h3>
        <ul class="clearfix">

            <c:forEach items="${product}" var="c"  >
                <li>
                    <img src="${c.imgurl}"/>
                    <p>${c.productname}</p>
                    <p class="price">${c.price}</p>
                </li>
            </c:forEach>


        </ul>
    </div>
</section>

<!--定位footer-->
<footer id="footer" class="footer">
    <div class="f-bottom same">
        <p>杭州XXXXX有限公司  © 2015 Taobao.com 版权所有</p>
    </div>
</footer>
</body>
</html>