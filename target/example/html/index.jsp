<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
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
            <a href=""><input id="loginbtn" class="btn" type="submit" value="登陆" /></a>
        </div>
        <div class="search">
            <form >
                <input class="text" type="text" placeholder="请输入搜索内容"/>
                <input class="btn1" type="submit" value="" />
        </form>
        </div>
    </div>
</header>

<!--轮播图-->
<section class="flash" id="flash">

        <a class="flash-left" href="javascript:void(0);">左</a>
        <ul class="flashImg">
            <li><a href="##"><img src="../images/images1.jpg" /><span></span></a></li>
            <li style="display:none;"><a href="##"><img src="../images/images2.jpg" /><span></span></a></li>
            <li style="display:none;"><a href="##"><img src="../images/images3.jpg" /><span></span></a></li>
        </ul>
        <a class="flash-right" href="javascript:void(0);">右</a>
        <div class="flashBtn">
            <span class="current">1</span>
            <span>2</span>
            <span>3</span>
        </div>

</section>



<!--热门销售-->
<section class="hotsell ">
    <div class="hotsellmain same">
    <h3>热门销售</h3>
    <ul class="clearfix">
        <c:forEach items="${productList}" var="p1"  >

        <a href="/${p1.productid}">

            <li>
            <img src="${p1.imgurl}"  />
            <p>${p1.productname}</p>
            <p class="price">￥${p1.price}</p>
        </li>

        </a>

        </c:forEach>

    </ul>
    </div>
</section>

<!--智能生活-->
<section class="hotsell ">
    <div class="hotsellmain same">
        <h3>智能生活</h3>
        <ul class="clearfix">
            <c:forEach items="${productList}" var="p2"  >

                <a href="product.jsp">

                    <li>
                        <img src="${p2.imgurl}"  />
                        <p>${p2.productname}</p>
                        <p class="price">￥${p2.price}</p>
                    </li>

                </a>

            </c:forEach>

        </ul>
    </div>
</section>

<!--限时促销-->
<section class="hotsell ">
    <div class="hotsellmain same">
        <h3>限时促销</h3>
        <ul class="clearfix">
            <c:forEach items="${productList}" var="p3"  >

                <a href="product.jsp">

                    <li>
                        <img src="${p3.imgurl}"  />
                        <p>${p3.productname}</p>
                        <p class="price">￥${p3.price}</p>
                    </li>

                </a>

            </c:forEach>

        </ul>
    </div>
</section>

<!--footer-->
<footer id="footer">
    <div class="f-main same   clearfix">
        <div class="fm-address">
            <img src="../images/dyf1.png" />
            <ul class="fmc-nav clearfix">
                <li class="fmc-nav-check">杭州(总部)</li>
                <li>杭州</li>
                <li>杭州</li>
                <li>杭州</li>
            </ul>
            <p class="fmc-text">浙江省杭州市拱墅区湖州街51号</p>
        </div>

        <div class="fm-contain">
            <img src="../images/dyf2.png" />
            <ul class="fm-contain-phone">
                <li>电话：0571-8888888</li>
                <li>传真：0571-8888888-8888</li>
            </ul>
        </div>

        <div class="fm-contain">
            <img src="../images/dyf3.png" />
            <ul class="fm-contain-coor">
                <li>合作电话：0571-8888888-8888</li>
                <li>0571-8888888-9999</li>
            </ul>
        </div>
    </div>
    <div class="f-bottom same">
        <p>杭州XXXXX有限公司  © 2015 Taobao.com 版权所有</p>
    </div>
</footer>

<!--蒙层-->
<div id="shade" style="display:none;">
    <div class="shadeMain">
        <div class="shadeMain_top">
            <h3>登录</h3>
            <span>关闭<b>×</b></span>
        </div>
        <div class="shadeMain_main clearfix">
            <form class="shadeMain_left">
                <div class="shadeMain_input">
                    <span class="shadeMain_name"><label for="text">用户名：</label></span>
                    <input id="text" class="shadeMain_text" type="text" value="" />
                </div>
                <div class="shadeMain_input">
                    <span class="shadeMain_name"><label for="pass">密码：</label></span>
                    <input id="pass" class="shadeMain_text" type="password" value="" />
                </div>
                <div class="shadeMain_submit">
                    <input class="loginReg_login" type="submit" value="登录" />
                    <a href="##" target="_blank">忘记密码</a>
                </div>
            </form>
            <dl class="shadeMain_right">
                <dt>还没有注册账号？</dt>
                <dd><a class="loginReg_reg" href="register.html" target="_blank">注册</a></dd>
            </dl>
        </div>
    </div>
</div>








<script src="../js/jquery-1.8.3.min.js"></script>
<script src="../js/js.js"></script>
</body>
</html>