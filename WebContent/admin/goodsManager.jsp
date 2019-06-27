<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="com.cn.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<!--  <link rel="stylesheet" type="text/css" href="admin/public.css">
	-->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/admin/pager.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/css/order/list.css'/>" />
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<style type="text/css">
a{ color: blue;}
.close{
 text-align: center; margin-top:-20px;
float:right;
cursor: pointer;
}
.close:hover{background: red;}
#editGoods{
	background-color: white;
	width: 400px;
	height: 200px;
	
	
	margin-left:auto;
	margin-right:auto;
	z-index: 2;
	
	top: 196px;
	border: #000 2px solid;
	padding-top: 20px;
	padding-left: 50px;
}
.inp{ border:1px #F60 soid; outline:none; width:200px; height:30px; margin-top:10px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inp:focus{ border-color:#F00;}
.but{margin-bottom:20px; border:1px #F60 soid; outline:none; width:80px; height:40px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
}
</style>
	
  </head>
<body>
<%List<Goods> goodslist = (List<Goods>)session.getAttribute("Goodslist"); %>
<div class="divMain">
	<div style="width:400px; margin: auto;">
		
		<form action="GoodsServlet" method="post">
			<input class="but" type="button" value="添加商品" onclick="addGoods()">
			<input class="inp" name = "goods" type ="text" id = "goods"><input type = "submit" value="查询" class="but">
		</form>
	</div>
	<div class="title">
		</a><div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>|
			<span style="margin-left: 40px;margin-right: 100px;">单价</span>|
			<span style="margin-left: 50px;margin-right: 53px;">库存</span>|
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<div id="editGoods"><span class="close" onclick="close_div()" >✖</span>
修改商品信息
<hr>
<form action="UpdateGoodsServlet" method="post">
<input type="hidden"  id = "id" name = "id">
<p>商品名：<input type="text" name="name" id="name"></p>
<p>库存：<input type="text" name="qty" id = "qty"></p>
<p>单价：<input type="text" name = "price" id = "price"></p>
<p>商品描述：<textarea name="desc" id="desc"></textarea></p>

<input type="submit" value="修改">
<input type="reset" value="重置">

</form>

</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
<%Goods goods = new Goods();
if( goodslist !=null) 	

	for(int j = 0;j < goodslist.size();j++){
		
		goods = goodslist.get(j);
		
	
	%>
	
		<tr class="tt">
			<td width="320px">商品名：<%=goods.getGoods_name() %></td>
			<td width="200px">供货商：<%=goods.getSupplier() %></td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>	
		

		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">
				<a href="">
				<div style="float:left; padding-top: 10px; padding-bottom:10px; center; margin-left: 0;">
				<img src="../<%=goods.getGoods_pic() %>" alt="" width="201" height="155">
				
				</div>
				<div class="left" style=" width:220px; line-height:180px; text-align:center; color: black;"><%=goods.getGoods_desc() %></div>
				</a>
				<div class="clears"></div>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;<%=goods.getGoods_price() %></span>
			</td>
			<td>
			<%=goods.getQty()
				
			%>
			
			</td>
						
			<td>
			<a href="#" onclick="editGoods(<%=goods.getGoods_id()%>)">编辑</a><br/>
			</td>
		</tr>

<%} %>
	</table>
	<br/>
</div>

<script type="text/javascript">
$("#editGoods").hide();

function editGoods(id){
	
	$.post("UpdateQurygoodsServlet",{"id":id},function(data){
		
		$("#editGoods").show();
		$("#id").val(data.id);
		$("#qty").val(data.qty);
		$("#price").val(data.price);
		$("#name").val(data.name);
		$("#desc").val(data.desc);
	});
}
function close_div(){
	$("#editGoods").hide();

}
function addGoods(){
	window.location.href="addGoods.jsp";
}
</script>   
</body>
</html>