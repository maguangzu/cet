<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../common.jspf" %>
		<link rel="stylesheet" type="text/css" href="${basePath }acss/carDetail.css"/>
	</head>
	<body>
		<div class="_BigBox">
			<a class="_aBtn" href="javascript:history.go(-1)">返回</a>	
			<c:if test="${ADMININFO.role }">
				<a class="_bBtn"  href="candidateModifyUI.action?id=${candidate.id }">修改</a>
			</c:if>
			<div class="_clearFloat"></div>
			<p class="_title">考生详细资料</p>
			<div class="_infoBox">
				<div class="_img">
					<img src="${candidate.personImg }" alt="" />
				</div>
				<div class="_info_l">
					准考证号:<span>${candidate.admissionCard }</span>
				</div>
				<div class="_info_l">
					姓名:<span>${candidate.name }</span>
				</div>
				
				<div class="_info_l">
					性别:<span>${candidate.sex }</span>
				</div>
				<div class="_info_l">
					身份证号:<span>${candidate.idcard }</span>
				</div>
				<div class="_info_l">
					报考类型:<span>${candidate.cetType }</span>
				</div> 
				<div class="_info">
					电话:<span>${candidate.phone }</span>
				</div>
				<div class="_info_l">
					通讯地址:<span>${candidate.commAdress }</span>
				</div>
				
				
			</div>
		</div>
	</body>
</html>
