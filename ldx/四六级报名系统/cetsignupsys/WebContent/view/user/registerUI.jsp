<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<%@include file="../../common/common.jspf" %>
		<link rel="stylesheet"  href="${basePath }css/registerUI.css"/>
	</head>
	<body>
		<%@include file="../../common/top.jspf" %>
	
		<div class="logo">
		    <a href="/"><img src="${basePath }img/logo2.jpg"></a><span>会员登录</span>
		</div>
		
		
		<div id="_container" class="_container">
			<div class="_BigBox">
				<form id="form" action="register.action" method="POST">
					<div class="_left">
						<p>注册新用户</p>
						<div class="_left_info">
							<div class="_info_from">
								<div class="_from_text">
									帐号 : <input type="text"  id="account" name="account" placeholder="请输入您的用户名"/>
								</div>
								<img class="_errorIcon" id="accountIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							<div class="_info_from">
								<div class="_from_text">
									密码 : <input id="password"  type="password" name="password" placeholder="输入密码(6-16位数字,字母组成)"/>
								</div>
								<img id="passwordIcon" class="_errorIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							<div class="_info_from">
								<div class="_from_text">
									确认密码 : <input id="repwd" type="password" id="repwd" placeholder="请确保和输入密码一致"/>
								</div>
								<img id="repwdIcon" class="_errorIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							
							<div class="_info_from">
								<div class="_from_text">
									Email : <input id="email" type="text" name="email" placeholder="请输入邮箱"/>
								</div>
								<img id="emailIcon" class="_errorIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							
							<div class="_info_from">
								<div class="_from_text">
									Phone : <input id="mobile" type="text" name="mobile" placeholder="请输入手机号"/>
								</div>
								<img id="mobileIcon" class="_errorIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							
							<div class="_info_from">
								<div class="_from_validate">
									验证码 : <input id="valideCode" type="text" name="valideCode" placeholder="请输入验证码"/>
								</div>
								<div class="_validate_img">
									<img src='<c:url value="/VerifyCodeServlet"/>' alt="这里是验证码"/>
								</div>
								<img id="valideCodeIcon" class="_errorIcon" src="${basePath }img/errorIcon.png" alt="" />
							</div>
							
							<div class="_Btn">
								<div class="_submitBtn">
									<input type="button" value="注册"  onclick="doSubmit()"/>
								</div>
								
								<div class="_returnBtn">
									<a href="javascript:history.go(-1)">返回</a>
								</div>
								
							</div>
						</div>
						
						<input type="hidden" id="errorMsg" value="${errorIdx }"/>
					</div>
				</form>
				<div class="_right">
					<p><a href="loginUI.action">已有帐号？立即登录</a></p>
					<div class="_img">
						<img src="${basePath }img/loginImg.png" alt="" />
					</div>
				</div>
			</div>
		</div>
		
		<%@include file="../../common/bottom.jspf" %>
		
		<script>
			window.onresize=function(){  
			     changeDivSize();  
			}
			
			function changeDivSize(){
				var cont = document.getElementById("_container");
				cont.style.height = document.documentElement.clientHeight;
			}
			changeDivSize();
			
			/*
				时间所限,只是弄了点简单校验
			*/
			function doSubmit(){
				var account = $("#account").val();
				if(account.length<4 || account.length >10){
					$("#account").focus();
					$("#account").val("");
					$("#account").attr("placeholder","请确保帐号长度在4到10个之间");
					$("#accountIcon").css({"display":"block"});	
					return;
				}
				var password = $("#password").val();
				if(password.length<4 || password.length >10){
					$("#password").focus();
					$("#password").val("");
					$("#password").attr("placeholder","密码长度在4到10个之间");
					$("#passwordIcon").css({"display":"block"});	
					return;
				}
				var repwd = $("#repwd").val();
				if(repwd!=password){
					$("#repwd").focus();
					$("#repwd").val("");
					$("#repwd").attr("placeholder","请确保两次密码输入一致啊");
					$("#repwdIcon").css({"display":"block"});	
					return;
				}
				var email = $("#email").val();
				if(email.length <1){
					$("#email").focus();
					$("#email").val("");
					$("#email").attr("placeholder","邮箱输错啦,重新输入一遍吧");
					$("#emailIcon").css({"display":"block"});	
					return;
				}
				var mobile = $("#mobile").val();
				if(mobile.length <6){
					$("#mobile").focus();
					$("#mobile").val("");
					$("#mobile").attr("placeholder","没手机你租个毛车啊");
					$("#mobileIcon").css({"display":"block"});	
					return;
				}
				
				document.forms[0].submit();
			}
			
			$(":input:lt(6)").each(function(e,v){
		    	 v.onclick =function(){
					var id = $(v).attr("id");	    	
					var error = $("#"+id+"Icon");
					error.css({"display":"none"});
		    	 }
		     });
		    	 
			 var error = $("#errorMsg").val();
			 if(error != ''){
				$("#"+error).focus();
				$("#"+error+"Icon").css({"display":"block"});				 
			 }
		</script>
	</body>
</html>
