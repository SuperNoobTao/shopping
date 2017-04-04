<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>order</title>
    <link href="../css/style1.css"  rel="stylesheet" type="text/css" />
    <script src="../js/jquery-1.8.3.min.js"></script>
</head>
<body>
<!--nav-->
<header class="samebg">
    <div class="nav same clearfix">
        <a href="/"><span>首页</span></a>
        <a href="/cart"><span>购物车</span></a>
        <a href="/user"><span>个人信息</span></a>
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

<!--确认订单信息-->
<section class="orderlist">
    <form>
    <div class="orderlistmian same">
        <h3>确认订单信息</h3>
        <table border="1px">
            <tr>
                <td>用户名</td>
                <td>商品名</td>
                <td>收货地址</td>
                <td>电话</td>
                <td>数量</td>
                <td>总价</td>
            </tr>
            <tr>
                <td>${order.username}</td>
                <td>${order.productname}</td>
                <td>${order.orderaddress}</td>
                <td>${order.ordertel}</td>
                <td>${order.ordernum}</td>
                <td>${order.orderprice}</td>
            </tr>
        </table>
        <div class="threebtns clearfix">
            <input type="button" value="修改信息"/>
            <input class="buttomsec" type="button" value="确认订单"/>
            <a href="product.jsp"><input class="buttomrthr" type="button" value="取消"/></a>
        </div>
    </div>

</section>


<!--定位footer-->
<footer id="footer" class="footer">
    <div class="f-bottom same">
        <p>杭州XXXXX有限公司  © 2015 Taobao.com 版权所有</p>
    </div>
</footer>
</body>
<script>
    $(".buttomsec").click(function () {

        $.ajax({
            type:"GET",
            datatype:"json",
            url:"/order/detail/add",
            success:function (data) {
                console.log(data);
                if(data.code =="true"){
                    alert("购买成功");
                    window.location.href="/info";
                }else if(data.code =="false"){
                    alert("用户余额不足");
                    window.location.href="/info";
                }

            }
        })
    })

</script>

</html>