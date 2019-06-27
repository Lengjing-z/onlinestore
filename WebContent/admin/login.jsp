<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
body{
background:url("images/bg.png");
}
h4{ font-size:30px; margin-bottom:20px;}/*标题*/
.inputs{ border:1px #F60 soid; background-color:transparent; outline:none; width:200px; height:30px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inputs:focus{ border-color:#F00;}/*聚焦时属性*/
p{ margin-bottom:20px;}/*p标签间距*/
input{ outline:none; margin-top: 30px; margin-left: 30px}
.red{ border:1px #0000FF solid;}
.content{ margin-top:50px; margin-left:100px;}/*界面位置*/
.dl{ background:transparent; border:1px #F60 soid; border-radius:5px; width:100px; height:30px; margin-left:80px; color:#FFF;}/*登录按钮属性*/

.tab{
	width:500px;
	height:400px;
	background:url("images/pic3.jpg");
	border-radius:20px;
	margin: auto;
	position:absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	
}

.tab_title{
	height:30px;
	border-bottom:1px #333 solid;
}
.tab_title ul li{
	float:left;
	height:30px;
	line-height:30px;
	text-align:center;
	border-right:1px #ccc solid;
	
	cursor:pointer;
	}
.tab_title ul li span{
	display:inline-block;
	padding-left:30px;
	padding-right:30px;
}
.current{
	border:1px #F60 soid; 
	border-radius:5px;
	background:transparent;
	color: white;
}
.tab_block{
	height:300px;
}
.hide{
	display:none;
}
</style>
</head>
<body>

<div class="tab">
	<div class="tab_title">
    	<ul id="tabUL"  >
        	<li style="margin-left:20px;" onclick="tabFun('sh','ty',this)" class="current"><span>SING IN</span></li>
            <li onclick="tabFun('ty','sh',this)" ><span>SING UP</span></li>
        </ul>
    </div>
    <div class="tab_content"  id="tabC">
    	<div class="tab_block" id="sh">
    		<form name="login" method="post" action="LoginServlet">
			  <div class="content">
			   <input class="inputs" id="username" name="username" type="text" placeholder="Username">
			   <input id="password" class="inputs" name="password" placeholder="Password" type="password">
			  
			    <p>
			        <input class="dl"type="submit" value="SING IN">
			    </p>
			</div>
			</form>
    	</div>
        <div class="tab_block hide" id="ty">
        	<form name="register" method="post" action="RegisterServlet">
			  <div class="content">
			   <input style="margin-top: 0;" class="inputs" id="username" name="username" type="text" placeholder="Username">
			   <input id="password" class="inputs" name="password" placeholder="Password" type="password">
			   <input id="RepeatPassword" class="inputs" name="RepeatPassword" placeholder="RepeatPassword" type="password">
			   <input class="inputs" id="EmailAddress" name="EmailAddress" type="text" placeholder="EmailAddress">
			    <p>
			        <input class="dl"type="submit" value="SING UP">
			    </p>
			</div>
			</form>
        
        
        
        </div>
    </div>
</div>

<script type="text/javascript">
function tabFun(a,b,t){
	var tabUL = document.getElementById("tabUL");
	var li = tabUL.getElementsByTagName("li");
	var i = 0;
	for(i = 0;i<=li.length-1;i++){
		li[i].className = "";
		}
		t.className = "current";
		document.getElementById(a).className = "tab_block";
		document.getElementById(b).className = "tab_block hide";
		document.getElementById(c).className = "tab_block hide";
	}
	
function check() {
	var pass = document.getElementById("password").value;
	var repass = document.getElementById("RepeatPassword").value;
	if(pass.length<6||pass.length>18){
		alert("密码必须在6到18位");
	}else if(password!=RepeatPassword){
		alert("两次输入密码不一致");
	}else{
		
		document.getElementById("subm").submit();
	}
	
}
</script>
</body>
</html>