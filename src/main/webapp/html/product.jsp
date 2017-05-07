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

<!--商品信息-->
<section class="product">
    <div class="productmain  same clearfix">
        <div class="product-left">
            <ul class="bigimg clearfix">
                <li class="currentbigimg">
                    <img id="imgurl"  src="${product.imgurl}">
                </li>

            </ul>
        </div>
        <div class="product-right">
            <h3 hidden id="productid">${product.productid}</h3>
            <h3 id="productname">${product.productname}</h3>
            <dl><dd id="description">${product.description}
            </dd>
            </dl>

            <div class="salenum">
                <span class="decnum">-</span>
                <input name="txtNum" value="1" type="text" id="txtNum"  placeholder="0"/>
                <span class="incnum">+</span>
            </div>


            <p id="price">${product.price}</p>
            <input class="buyatone"   type="button"  value="立即购买" />
            <input class="putincart" type="button" value="加入购物车" />
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
<%--<footer id="footer" >--%>
    <%--<div class="f-bottom same">--%>
        <%--<p>杭州XXXXX有限公司  © 2015 Taobao.com 版权所有</p>--%>
    <%--</div>--%>
<%--</footer>--%>



<script src="../js/jquery-1.8.3.min.js"></script>
<script>
    //    购买数量
    $(document).ready(function(){
        var curVal = $("#txtNum");
        var temp; //得到文本框当前的数据
        $(".decnum").click(function(){
            temp = curVal.val();
            if(temp<=0){
                return false;
            }
            if(testNum(temp)){
                curVal.val(--temp); //数量减1
            }else{
                curVal.val(0)
            }
        });
        $(".incnum").click(function(){
            temp = curVal.val()
            if(testNum(temp)){
                curVal.val(++temp); //数量加1

            }else{
                curVal.val(0)
            }
        });
        doDashed();
//得到购买数量，并判断是否是正确格式
        function testNum(tempNum){
            if(/^[0-9]+$/.test(tempNum)){
                console.log("亲，输入正确哦 *_*")
                return true;
            }
            console.log("亲，你输入的不是正确数字啦 ^_^");
            return false;
        }
    });
    //处理点击链接时的虚线框
    function doDashed(){
        $('#txtNum').focus(function(){
            if(this.blur){
                this.blur();
            }
        });
    }



   console.log($('#imgurl').attr('src'));

    $(".buyatone").click(function () {
            console.log($('#txtNum').val());//交易数量
            $.ajax({
                type:"POST",
                datatype:"json",
                url:"/order",
                data:{
                    productid:$('#productid').text(),
                    productname:$('#productname').text(),
                    price:$("#price").text(),
                    num:$('#txtNum').val()},
                success:function (data) {
                    if(data.code =="true"){
                        window.location.href="/order/detail"
                    }

                }
            })
    })

    $(".putincart").click(function () {
        $.ajax({
            type:"post",
            datatype:"json",
            url:"/cart/add",
            data:{
                productid:$('#productid').text(),
                productname:$('#productname').text(),
                imgurl:$('#imgurl').attr('src'),
                price:$("#price").text()},
            success:function (data) {
                console.log(data)
                if(data.code =="false"){
                    var html="";
                    html+="<span style='margin-top: 33px;float:left;color: red;font-size: 15px;'>已存在</span>";
                    $(".product-right").append(html);
                }else if (data.code =="true") {
                    window.location.href="/cart";
                }

            },

        })
    })







</script>
</body>
</html>