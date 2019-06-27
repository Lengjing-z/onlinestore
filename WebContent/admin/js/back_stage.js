// JavaScript Document
function tabFun(a,b,c,t){
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