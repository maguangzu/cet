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
		document.forms[0].action="activesl.do?page="+num;
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
<h1>活动管理</h1>
<form action="#" method="post">
	活动编号：<input type="text" placeholder="活动编号" name="active_id" value="">
	<input type="submit" value="查询活动信息" />
</form>

<table width="100%" cellpadding="0" cellspafindmyactivecing="0" border="1">
	<tr>
		<th>序号</th>
		<th>活动编号</th>
		<th>活动名称</th>
	    <th>开始时间</th>
	    <th>结束时间</th>
	    <th>活动时长</th>
	    <th>活动人数</th>
	    <th>活动地址</th>
	    <th>活动介绍</th>
	    <th>进度(0审核 1通过 2结束)</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.allactivepage.list}" var="at" varStatus="aa">
		<tr>
			<td>${aa.count}</td>		
			<td>${at.activeid}</td>
			<td>${at.activename }</td>
			<td>${at.begintime}</td>
			<td>${at.endtime }</td>
			<td>${at.activeshichang}</td>
			<td>${at.activevolnum}</td>
			<td>${at.activeaddrees}</td>
			<td>${at.activemajor}</td>
			<td>${at.activezhtai}</td>
			<td><a href="activeshenhe.do?activeid=${at.activeid}">通过  </a>&nbsp;<a href="endactive.do?activeid=${at.activeid}">结束  </a></td>
		</tr>
	</c:forEach>
	<tr style="text-align:center">
		<td colspan="11">
		<c:if test="${allactivepage.currentPage != 1 }">
			<a onclick="goToPage(${allactivepage.currentPage-1 })">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${allactivepage.totalPage }" varStatus="bb">
			<c:choose>
				<c:when test="${bb.index==allactivepage.currentPage }">
					<a href="#" style="color:red ">${bb.index }</a>
				</c:when>
				<c:otherwise>
					<a onclick="goToPage(${bb.index })">${bb.index }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${allactivepage.currentPage!=allactivepage.totalPage }">
			<a onclick="goToPage(${allactivepage.currentPage+1})">下一页</a>
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>