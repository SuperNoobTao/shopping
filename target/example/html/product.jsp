<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>product</title>
</head>
<link href="../css/style1.css"  rel="stylesheet" type="text/css" />
<body>
<!--nav-->
<header class="samebg">
    <div class="nav same clearfix">
        <a href="index.jsp"><span>首页</span></a>
        <a href="shoppingcart.html"><span>购物车</span></a>
        <a href="user.jsp"><span>个人信息</span></a>
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

<!--商品信息-->
<section class="product">
    <div class="productmain  same clearfix">
        <div class="product-left">
            <ul class="bigimg clearfix">
                <li class="currentbigimg">
                    <img src="${product.imgurl}">
                </li>

            </ul>
        </div>
        <div class="product-right">
            <h3>${product.productname}</h3>
            <dl><dt>${product.description}
                </dd>
            </dl>
            <p>${product.price}</p>
            <a href="order.html"><input class="buyatone"   type="button"  value="立即购买" /></a>
            <a href="shoppingcart.html"><input class="putincart"   type="button"  value="加入购物车" /></a>
        </div>
    </div>
</section>

<!--用户评价-->
<section class="content">
    <div class="content-main same ">
        <h3>用户评价:</h3>
       <ul class="contentlist   clearfix">
           <c:forEach items="${contents}" var="c"  >
               <li>

               <i>${c.username}</i>
               <p>${c.contentmain}
               </p>

           </li>
               </c:forEach>
       </ul>
    </div>
</section>



<!--footer-->
<footer id="footer" >
    <div class="f-bottom same">
        <p>杭州XXXXX有限公司  © 2015 Taobao.com 版权所有</p>
    </div>
</footer>



<script src="../js/jquery-1.8.3.min.js"></script>

</body>
</html>