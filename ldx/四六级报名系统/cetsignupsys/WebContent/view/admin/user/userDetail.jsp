<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../common.jspf" %>		
		<title>用户列表</title>
		<link rel="stylesheet" href="${basePath }acss/userDetail.css" />
	</head>
	<body>
		<div class="_BigBox">
			<a class="_aBtn" href="javascript:history.go(-1)">返回</a>	
			<c:if test="${ADMININFO.role }">
				<a class="_bBtn"  href="modifyUserUI.action?id=${user.id }">修改权限</a>
			</c:if>
			
			<div class="_clearFloat"></div>
			<p class="_title">用户资料</p>
			<div class="_infoBox">
				<div class="_info">
					帐号:<span>${user.account }</span>
				</div>
				<div class="_info">
					密码:<span>${user.password }</span>
				</div>
				<div class="_info">
					手机:<span>${user.mobile }</span>
				</div>
				<div class="_info">
					邮箱:<span>${user.email }</span>
				</div>
				<div class="_info_l">
					系统类别:<span>${user.role ==true ? '系统管理员':'系统用户' }</span>
				</div> 
			</div>
		</div>
	</body>
</html>
