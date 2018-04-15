<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>四六级考试管理后台</title>
  <%@include file="../../common/common.jspf" %>
  <link rel="stylesheet" href="${basePath }/acss/index.css" />
</head>
<body>
	<div class="_top">
		<div class="_logo">
			<p>四六级网</p>
		</div>
		<div class="_user">
			<p><a href="javascript:alert('只有超级管理员才有增加,修改信息的权利')">帮助</a></p>
			<p><a href="quit.action">退出</a></p>
			<p>${ADMININFO.account }</p>
			<img class="_user_img" src="${basePath }/aimg/adminImg.png"/>
		</div>
	</div>
	<div class="_container">
		<div id="_left" class="_left">
			<ul class="_menu">
			
				<li>
					<a class="_menuItem" href="#"><span class="_circleIcon"></span>用户信息管理</a>
					<ul class="_menuItemMenu">
						<li><a class="_menuItemMenuItem" target="main" href="userList.action" ><span class="_circleIconSmall"></span>用户信息</a></li>
					</ul>
				</li>
				<li>
					<a class="_menuItem" href="#"><span class="_circleIcon"></span>考生信息管理</a>
					<ul class="_menuItemMenu">
						<li ><a class="_menuItemMenuItem" target="main" href="candidateList.action"><span class="_circleIconSmall"></span>考生信息</a></li>
					</ul>
				</li>
				<li>
					<a class="_menuItem" href="#"><span class="_circleIcon"></span>报考信息管理</a>
					<ul class="_menuItemMenu">
						<li ><a class="_menuItemMenuItem" target="main" href="testListUI.action" ><span class="_circleIconSmall"></span>报考列表</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="_main" class="_main">
			<iframe id="main" name="main" scrolling="no" frameborder="0"></iframe>
		</div>
	</div>
	<script language="JavaScript">
		(function(){
				//拿到一级菜单项
				var lis = $('._menu > li');
				//添加鼠标单击添加样式事件,改变一级和二级菜单项样式
				$.each(lis, function(i,v) {
					//一级菜单项
					v.onclick = function(){
						$(v).toggleClass('active');
					}
					//对应的子菜单项
					var lilis = $(v).find("li");
					for(var i=0;i<lilis.length;i++){
						lilis[i].onclick =  function(){
							$(v).toggleClass('active');
							
							//去除之前选中元素的样式
							var _as = $('._active');
							_as.removeClass("_active");
							//为自身添加选择样式
							$(this).addClass("_active");
						}
					}
				});
			})();
			
			function changeDivSize(){
			   	var ifm= document.getElementById("main"); 
			    ifm.width= document.documentElement.clientWidth-230;
			    var left = document.getElementById("_left");
			    left.style.height = document.documentElement.clientHeight;
			}
			changeDivSize();
			window.onresize=function(){  
			     changeDivSize();  
			} 
	</script>
	
</body>
</html>
