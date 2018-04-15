<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>管理员登录页面</title>
		<%@include file="common.jspf"  %>
		<link rel="stylesheet" href="${basePath }acss/loginUI.css"/>
	</head>
	<body>
		<div class="_box">
			<form action="login.action" method="post">
				<div class="_boxUp">
					<img src="${basePath }img/logo.jpeg"/>
				</div>
				<div class="_boxDown">
					
						<div class="_info">
							<div class="_info_left">
								帐号
							</div>
							<div class="_info_right">
								<input type="text" name="account" value="admin"/>
							</div>
						</div>
						<div class="_info">
							<div class="_info_left" style="background-color: #FFB848;">
								密码
							</div>
							<div class="_info_right">
								<input type="password" name="password" value="admin"/>
							</div>
						</div>
						<p>${msg}</p>
				</div>
				<div class="_btn">
					<input type="button" value="登录" onclick="doSubmit();"/>
				</div>
			</form>
		</div>
		
		<script type="text/javascript">
			function doSubmit(){
				document.forms[0].submit();				
			}
		</script>
	</body>
</html>
