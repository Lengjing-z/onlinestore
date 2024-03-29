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

  </head>
  
  <body>
  <% List<order> orderlist = (List<order>)session.getAttribute("orderlist"); 
  	List<Goods> goodslist = (List<Goods>)session.getAttribute("Goodslist");
  %>
<p class="pLink" style="line-height: 40px;">
  <a href="OrderServlet?status=1">未付款</a>  | 
  <a href="OrderServlet?status=2">已付款</a>  | 
  <a href="OrderServlet?status=3">已发货</a>  | 
  <a href="OrderServlet?status=4">交易成功</a> | 
  <a href="OrderServlet?status=5">已取消</a>	|
  <a href="QueryOrderServlet">所有订单</a>
</p>
<div class="divMain">
	<div class="title">
		</a><div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
<%Goods goods = new Goods();
if(orderlist != null && goodslist !=null) 	
for(int i = 0;i<orderlist.size();i++){ 
	
	order o = orderlist.get(i);
	for(int j = 0;j < goodslist.size();j++){
		if(o.getGoodsid() ==  goodslist.get(j).getGoods_id()){
			goods = goodslist.get(j);
		}
	}
	%>
	
		<tr class="tt">
			<td width="320px">订单号：<a  href="desc.jsp?id=<%=i %>"><%=o.getMum() %></a></td>
			<td width="200px">下单时间：<%=o.getOrderdate() %></td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>	
		

		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">
				<a href="desc.jsp?id=<%=i %>">
				<div style="float:left; padding-top: 10px;text-align: center; margin-left: 0;">
				<img src="../<%=goods.getGoods_pic() %>" alt="" width="201" height="155">
				<p><%=goods.getGoods_name() %></p>
				</div></a>
				<div class="clears"></div>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;<%=o.getOrdersum() %></span>
			</td>
			<td>
			<%
			int status = o.getStatus();
			switch(status){
				case 1: out.print("(等待付款)"); break; 
				case 2: out.print("(准备发货)"); break; 
				case 3: out.print("(等待确认)"); break; 
				case 4: out.print("(交易完成)"); break; 
				case 5: out.print("(已取消)"); }
				
			%>
			
			</td>
						
			<td>
			<a href="desc.jsp?id=<%=i %>">查看</a><br/>
<% if(status == 1){%>
				<a href="UpdateOrderServlet?status=5&id=<%=o.getOrderid()%>">取消</a><br/>						
<% }else if(status == 2){%>

				<a href="UpdateOrderServlet?status=3&id=<%=o.getOrderid()%>">发货</a><br/>
<% }%>			

			</td>
		</tr>

<%} %>
	</table>
	<br/>
</div>
  </body>
</html>
