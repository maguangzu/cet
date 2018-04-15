<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../common.jspf" %>
		<link rel="stylesheet" type="text/css" href="${basePath }acss/carModify.css"/>
	</head>
	<body>
		<div class="_BigBox">
			<form action="modifyCandidate.action" method="post" enctype="multipart/form-data">
				<a class="_aBtn" href="javascript:history.go(-1)">返回</a>	
				<div class="_clearFloat"></div>
				<p class="_title">用户资料</p>
				<div class="_infoBox">
					<div class="_img">
						<img src="${candidate.personImg }" alt="个人没有图片" />
					</div>
					<div class="_info_l">
						准考证号:<input id="" readonly="readonly" name="id" value="${candidate.admissionCard }">
					</div>
					<div class="_info_l">
						姓名:<input  name="name" value="${candidate.name }">
					</div> 
					<div class="_info_l">
						性别:<select name="sex" style="" class="wbk_01">
								<option value="男" <%="${candidate.sex}".equals("男") ? "selected":"" %>>男</option>
                        			<option value="女" <%="${candidate.sex}".equals("女") ? "selected":"" %>>女</option>
							</select>
					</div>
					<div class="_info_l">
						身份证号:<input type="text" name="idcard" value="${candidate.idcard }"/>
					</div>
					<div class="_info_l">
						报考类型:<select name="cetType" style="">
								<option value="CET-4"  <%="${candidate.cetType}".equals("CET-4") ? "selected":"" %>>CET-4</option>
                        			<option value="CET-6"  <%="${candidate.cetType}".equals("CET-6") ? "selected":"" %>>CET-6</option>
							</select>
					</div>
					<div class="_info_l">
						电话:<input type="text" name="phone" value="${candidate.phone }"/>
					</div>
					<div class="_info_l">
						通讯地址:<input type="text" name="commAdress" value="${candidate.commAdress }" />
					</div>
					
					
					<div class="_info_l" style="width: 201px;height: 25px;">
						<input style="width: 200px;border: none;" type="file" name="file" id="" />
					</div>
					<input type="hidden" name="personImg" value="${candidate.personImg }"/>
					<input type="hidden" name="uid" value="${candidate.user.id }"/>
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