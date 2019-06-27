<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddGoodsTypeservlet" method="post">
<div style="width: 400px; margin: auto; border: 2px gray solid; text-align: center;">
  <p>类别名称：
    <input type="text" name="name" id="name">
    
  </p>
  <p>类别描述：
    <textarea name="desc" id="desc"></textarea>
  </p>
  <p>
    <input type="submit" name="submit" id="submit" value="提交">
    
  </p>
  </div>
</form>

</body>
</html>