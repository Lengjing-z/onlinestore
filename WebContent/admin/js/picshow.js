// JavaScript Document
var ctrl = document.getElementById("ctrl");
var imgUl = document.getElementById("imgUl");
var a = ctrl.getElementsByTagName("a");
for(var i = 0; i <= a.length-1; i++){
	a[i].onclick = function(){
		for(var j = 0; j <= a.length - 1;j++){
			a[j].className = "";
			
			}
			this.className = "current";
		var index = this.getAttribute("index");
		imgUl.style.marginLeft = -700 * index + "px"
		}
	}

