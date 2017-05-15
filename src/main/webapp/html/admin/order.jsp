<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>seller Order</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../../i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../../i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../../css/amazeui.min.css"/>
  <link rel="stylesheet" href="../../css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>智能家电</strong> <small>后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
        <li><a href="/admin/pro"><span class="am-icon-table"></span> 商品管理</a></li>
        <li><a href="/admin/order"><span class="am-icon-table"></span>订单管理</a></li>
        <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>

      <%--<div class="am-panel am-panel-default admin-sidebar-panel">--%>
        <%--<div class="am-panel-bd">--%>
          <%--<p><span class="am-icon-bookmark"></span> 公告</p>--%>
          <%--<p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>--%>
        <%--</div>--%>
      <%--</div>--%>

      <%--<div class="am-panel am-panel-default admin-sidebar-panel">--%>
        <%--<div class="am-panel-bd">--%>
          <%--<p><span class="am-icon-tag"></span> wiki</p>--%>
          <%--<p>Welcome to the Amaze UI wiki!</p>--%>
        <%--</div>--%>
      <%--</div>--%>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">表格</strong> / <small>Table</small></div>
      </div>

      <hr>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
          <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" onclick="window.location.href='/admin/pro/add'" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
              <%--<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>--%>
              <%--<button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>--%>
              <%--<button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>--%>
            </div>
          </div>
        </div>


      </div>

      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-check"><input type="checkbox" /></th>
                <th class="table-id" hidden>ID</th>
                <th class="table-title">用户</th>
                <th class="table-type">产品</th>
                <th class="table-author am-hide-sm-only">收货地址</th>
                <th class="table-type">价格</th>
                <th class="table-type">数量</th>
                <th class="table-type">电话</th>
                <th class="table-type">状态</th>
              </tr>
              </thead>
              <tbody>
<c:forEach items="${orderList}" var="p"  >
              <tr>
                <td><input type="checkbox" /></td>
                <td hidden>${p.orderid}</td>
                <td>${p.username}</td>
                <td>${p.productname}</td>
                <td>${p.orderaddress}</td>
                <td>${p.orderprice}</td>
                <td>${p.ordernum}</td>
                <td>${p.ordertel}</td>
                <c:if test="${p.orderstate==1}">
                  <td>未确认</td>
                </c:if>
                <c:if test="${p.orderstate==2}">
                  <td>已确认</td>
                </c:if>

                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="del('${p.orderid}')"><span class="am-icon-trash-o"></span> 删除</button>
                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="reconfirm('${p.orderid}')"><span class="am-icon-trash-o"></span> 确认</button>
                    </div>
                  </div>
                </td>
              </tr>
</c:forEach>
              </tbody>
            </table>

            <hr />

          </form>
        </div>

      </div>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>



  </div>
  <!-- content end -->





</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<section class="cuxiao">

</section>



<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="../../js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../../js/jquery.min.js"></script>
<!--<![endif]-->
<script src="../../js/amazeui.min.js"></script>
<script src="../../js/app.js"></script>

<script>

    /**
     * 删除商品
     * @param id
     */
    function del(id){

        if(confirm("您确认要删除编号为"+id+"的订单吗?")) {

            $.ajax({
                type: "post",
                url: "/admin/order/"+id+"/del",
                dataType: "json",
                timeout: 2000,
                data: {
                    id:id,
                },
                success: function (data) {

                    if (data.state == '00000') {
                        alert("操作成功");
                        location.reload(false);
                    }
                    else{
                        alert("操作失败");
                    }


                }
            });

        }
    }


    function reconfirm(id) {
      $.ajax({
        type: "post",
        url: "/admin/order/"+id+"/comfirm",
        dataType: "json",
        data: {
          id:id,
        },
        success: function (data) {

          if (data.state == '00000') {
            alert("操作成功");
            location.reload(false);
          }
          else{
            alert("操作失败");
          }


        }
      });
    }




//    促销模块
    $("#cuxiao").click(function () {

    })



</script>

</body>
</html>
