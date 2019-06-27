<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<link rel="stylesheet" type="text/css" href="css/back_stage.css">
</head>

<body>
<div class="banner">
<h2 class="title">后台管理系统</h2>
<div>管理员：${user.username}
<a href="login.jsp" target="_top">退出</a>
<a href="QueryclassifyServlet" target="mainFrame">分类管理</a>
<a href="QueryGoodsServlet" target="mainFrame">商品管理</a>
<a href="QueryOrderServlet" target="mainFrame">订单管理</a>
</div>
</div>
</body>
</html>
