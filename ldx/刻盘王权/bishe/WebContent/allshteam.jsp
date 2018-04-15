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
		document.forms[0].action="findallteam.do?page="+num;
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
<h1>目前已经成立的团队如下：</h1>
<form action="findallteam.do" method="post">
	团队编号：<input type="text" placeholder="团队编号" name="team_id" value="">
	<input type="submit" value="查询团队信息" />
</form>

<table width="85%" cellpadding="0" cellspafindmyactivecing="0" border="1">
	<tr>
		<th>序号</th>
		<th>团队编号</th>
		<th>团队名称</th>
	    <th>团队人数</th>
	    <th>团队创建者用户名</th>
	    <th>团队创建时间</th>
	    <th>团队介绍</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.shteampage.list}" var="shtm" varStatus="aa">
		<tr>
			<td>${aa.count}</td>		
			<td>${shtm.teamid}</td>
			<td>${shtm.teamname}</td>
			<td>${shtm.teamusernum}</td>
			<td>${shtm.teamusername}</td>
			<td>${shtm.teammadetime}</td>
			<td>${shtm.teamdesc}</td>
			<td><a href="#">通过</a></td>
		</tr>
	</c:forEach>
	<tr style="text-align:center">
		<td colspan="9">
		<c:if test="${shteampage.currentPage != 1 }">
			<a onclick="goToPage(${shteampage.currentPage-1 })">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${shteampage.totalPage }" varStatus="bb">
			<c:choose>
				<c:when test="${bb.index==shteampage.currentPage }">
					<a href="#" style="color:red ">${bb.index }</a>
				</c:when>
				<c:otherwise>
					<a onclick="goToPage(${bb.index })">${bb.index }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${shteampage.currentPage!=shteampage.totalPage }">
			<a onclick="goToPage(${shteampage.currentPage+1})">下一页</a>
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>