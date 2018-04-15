<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="js/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
    <script src="js/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>

<script>
	function goToPage(num)
	{
		document.forms[0].action="volsl.do?page="+num;
		document.forms[0].submit();
	}
	 $(function ()
		        {
		            //限定为数字类型：
		            $("#txt1").ligerTextBox({ digits: true });

		            //限定为浮点数格式输入框：
		            $("#txt2").ligerTextBox({ number: true });
		        }); 
		    </script>
</script>
<style>
	a{
		color:blue;
		text-decoration: underline;
		cursor:pointer;
	}
</style>
</head>
<body>
<h1>已注册志愿者人员管理</h1>
<form action="volsl.do" method="post">
	用户名称：<input type="text" placeholder="用户名" name="volName" value="">
	<input type="submit" value="查询用户信息" />
</form>

<table width="100%" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<th>序号</th>
		<th>编号</th>
		<th>用户名</th>
	    <th>身份证号码</th>
	    <th>电话号</th>
	    <th>时长</th>
	    <th>所属团队编号</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.p.list}" var="r" varStatus="aa">
		<tr>
			<td>${aa.count}</td>		
			<td>${r.volid}</td>
			<td>${r.volname }</td>
			<td>${r.volidnumber }</td>
			<td>${r.voltel}</td>
			<td>${r.volshichang }</td>
			<td>${r.teamid}</td>
			<td><a href="delvol.do?id=${r.volid }">删除</a></td>
		</tr>
	</c:forEach>
	<tr style="text-align:center">
		<td colspan="8">
		<c:if test="${p.currentPage != 1 }">
			<a onclick="goToPage(${p.currentPage-1 })">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${p.totalPage }" varStatus="bb">
			<c:choose>
				<c:when test="${bb.index==p.currentPage }">
					<a href="#" style="color:red ">${bb.index }</a>
				</c:when>
				<c:otherwise>
					<a onclick="goToPage(${bb.index })">${bb.index }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${p.currentPage!=p.totalPage }">
			<a onclick="goToPage(${p.currentPage+1})">下一页</a>
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>