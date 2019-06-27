<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
a{ color: blue;}
.close{
 text-align: center; margin-top:-20px;
float:right;
cursor: pointer;
}
.close:hover{background: red;}
.add{ width:100px; text-align: center; margin-left: auto; margin-right: auto; margin-bottom: 20px; margin-top: 30px;}
td{ text-align:center; border:1px #F60 soid; outline:none; border-radius: 5px;}
table{ margin-left: auto; margin-right: auto;}
h2{ width:120px; margin-left: auto; margin-right: auto; text-align: center; margin-top: 20px;}
#editType{
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
p{margin-top: 15px; margin-bottom: 15px;}
</style>
</head>
<body>
<%
	List<GoodsType> list = (List<GoodsType>)session.getAttribute("classifylist");
%>
<h2>分类列表</h2>
<div class="add"><a href="addType.jsp">添加分类</a></div>
<table  border="1">
	<tr>
		<td width="120">分类名称</td>
		<td width="200">描述</td>
		<td width="120">操作</td>
	</tr>
	<%if(list !=null)
		for(int i = 0;i<list.size();i++){%>
			<tr>
			<td width="120"><%=list.get(i).getName() %></td>
			<td width="200"><%=list.get(i).getDesc() %></td>
			<td width="120">
			<a href="#" onclick="edittype(this)">编辑</a>
			<a href="delTypeServlet?id=<%=list.get(i).getId() %>">删除</a>
			</td>
		</tr>
		<% }%>
	
	
</table>
<div id="editType"><span class="close" onclick="close_div()" >✖</span>
编辑商品分类
<hr>
<form action="UpdateTypeServlet" method="post">
<input type="hidden"  id = "id" name = "id">
<p>商品类型：<input type="text" name="name" id="name"></p>
<p>商品描述：<textarea name="desc" id="desc"></textarea></p>

<input type="submit" value="修改">
<input type="reset" value="重置">

</form>

</div>
<script type="text/javascript">
$("#editType").hide();

function edittype(t){
	var node = t.parentNode.parentNode;//获取当前行
	var a=node.children[0].innerHTML;
	$.post("UpdateQurytypeServlet",{"name":a},function(data){
		
		$("#editType").show();
		$("#id").val(data.id);
		$("#name").val(data.name);
		$("#desc").val(data.desc);
	});
}
function close_div(){
	$("#editType").hide();

}
</script>
</body>
</html>