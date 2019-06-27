<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="com.cn.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    <link rel="stylesheet" type="text/css" href="css/order/desc.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
<body>
<% List<order> orderlist = (List<order>)session.getAttribute("orderlist");
List<Goods> goodslist = (List<Goods>)session.getAttribute("Goodslist");
String id = request.getParameter("id");
order o = orderlist.get(Integer.parseInt(id));
Goods goods = new Goods();
for(int j = 0;j < goodslist.size();j++){
	if(o.getGoodsid() ==  goodslist.get(j).getGoods_id()){
		goods = goodslist.get(j);
	}
}
%>
	<div class="divOrder">
		<span>订单号：<%=o.getMum() %>
<%
			int status = o.getStatus();
			switch(status){
				case 1: out.print("(等待付款)"); break; 
				case 2: out.print("(准备发货)"); break; 
				case 3: out.print("(等待确认)"); break; 
				case 4: out.print("(交易完成)"); break; 
				case 5: out.print("(已取消)"); }
				
			%>
		　　　下单时间：<%=o.getOrderdate() %>
		</span>
	</div>
	<div class="divRow">
		<div class="divContent">
			<dl>
				<dt>收货人信息</dt>
				<dd><%="收货人："+o.getPerson()+"    收货地址："+o.getAddress() %></dd>
			</dl>
		</div>
		<div class="divContent">
			<dl>
				<dt>商品清单</dt>
				<dd>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<th class="tt">商品名称</th>
							<th class="tt" align="left">单价</th>
							<th class="tt" align="left">数量</th>
							<th class="tt" align="left">小计</th>
						</tr>





						<tr style="padding-top: 20px; padding-bottom: 20px;">
							<td class="td" width="400px">
								<div class="bookname" style="text-align: center;">
								  <img src="../<%=goods.getGoods_pic() %>" width="94" height="94" align="middle"/>
								  <%=goods.getGoods_name() %>
							  </div>
							</td>
							<td class="td" >
								<span>&yen;<%=goods.getGoods_price() %></span>
							</td>
							<td class="td">
								<span><%=o.getQty() %></span>
							</td>
							<td class="td">
								<span>&yen;<%=o.getOrdersum() %></span>
							</td>			
						</tr>


							
							
							
					</table>
				</dd>
			</dl>
		</div>
		<div class="divBtn">
			<span class="spanTotal">合　　计：</span>
			<span class="price_t">&yen;<%=o.getOrdersum() %></span><br/>

<% if(status == 1){%>
				<a href="UpdateOrderServlet?status=5&id=<%=o.getOrderid()%>">取消</a><br/>						
<% }else if(status == 2){%>

				<a href="UpdateOrderServlet?status=3&id=<%=o.getOrderid()%>">发货</a><br/>
<% }%>			
		</div>
	</div>
</body>
</html>

