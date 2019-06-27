<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.* ,com.cn.vo.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 800px; margin: auto; border: 2px solid blue; padding-left: 30px;">
<form action="AddGoodsServlet" enctype="multipart/form-data" id="form" name="form" method="post" >
  <p align="justify">商品名称：
    	<input type="text" name="goods_name" id="goods_name">
  </p>
  <p align="justify">商品类别：
  <select name="type_id" id="type">
    <%
			List<GoodsType> list = (List<GoodsType>)session.getAttribute("classifylist");
			for (int i = 0;i < list.size();i++) {
				GoodsType goodsType = list.get(i);
			%>
			
    <option value="<%=goodsType.getId()%>"><%=goodsType.getName()%></option>
    <%
			}
			%>
  </select>
  </p>
  <p align="justify">商品图片：<input type="file" name="goods_pic" id="goods_pic"></p>
  <p align="justify">供应商：<input type="text" name="supplier" id="supplier"></p>
  <p align="justify">商品描述：<textarea name="goods_desc" cols="50" rows="5" id="goods_desc"></textarea></p>
  <p align="justify">商品价格：<input type="text" name="goods_price" id="goods_price"></p>
  <p align="justify">库存数量：<input type="text" name="qty" id="qty"></p>

  <p align="justify">
    <input type="button" name="button" id="button" value="提交" onclick="check()">
    <input type="reset" name="button2" id="button2" value="重置">
    <input type="button" name="button3" id="button3" value="返回" onclick="fanhui()">
  </p>
</form>  
</div>
<script type="text/javascript">
function check()
{	var goods_name=document.getElementById("goods_name").value;
	var supplier=document.getElementById("supplier").value;
	var goods_pic=document.getElementById("goods_pic").value;
	var goods_desc=document.getElementById("goods_desc").value;
	var goods_price=document.getElementById("goods_price").value;
	var qty=document.getElementById("qty").value;

	
		if(goods_name==null||goods_name==''){
		alert("商品名不能为空！");
		return ;
		}
		else if(supplier==null||supplier==''){
		alert("生产厂家不能为空！");
		return ;
		}
		else if(goods_pic==null||goods_pic==''){
		alert("商品图片不能为空！");
		return ;
		}
		else if(goods_desc==null||goods_desc==''){
		alert("商品描述不能为空！");
		return ;
		}
		else if(goods_price==null||goods_price==''){
		alert("商品价格不能为空！");
		return ;
		}
		else if(qty==null||qty==''){
		alert("库存数量不能为空！");
		return ;
		}else{
			document.getElementById("form").submit();
		}
		
}
function fanhui(){
	history.go(-1);
}
</script>

</body>
</html>