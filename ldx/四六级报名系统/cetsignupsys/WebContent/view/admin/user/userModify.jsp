<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../common.jspf" %>
		<link rel="stylesheet" type="text/css" href="${basePath }acss/carModify.css"/>
	</head>
	<body>
		<div class="_BigBox">
			<form action="modifyUserRight.action" method="post" enctype="multipart/form-data">
				<a class="_aBtn" href="javascript:history.go(-1)">返回</a>	
				<div class="_clearFloat"></div>
				<p class="_title">用户资料</p>
				<div class="_infoBox">
					
					<div class="_info_l">
						编号:<input id="" readonly="readonly" name="id" value="${user.id }">
					</div>
					
					<div class="_info_l">
						账号:<input  type="text" name="account" readonly="readonly"  value="${user.account }">
					</div> 
					<div class="_info_l">
						密码:<input type="text" name="password" value="${user.password }" readonly="readonly"/>
					</div>
					<div class="_info_l">
						手机:<input type="text" name="mobile" value="${user.mobile }" readonly="readonly"/>
					</div>
					<div class="_info">
						邮箱:<input type="text" name="email" value="${user.email }" readonly="readonly"/>
					</div>
					<div class="_info">
						权限:<select  name="role">
							<option value="0" ${user.role ? '':'selected' }>系统用户</option>
							<option value="1" ${user.role ? 'selected':'' }>系统管理员</option>
						</select>
					</div>
					<input type="button" name="" id="" value="保存修改" class="_bBtn" onclick="doSubmit();"/>
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