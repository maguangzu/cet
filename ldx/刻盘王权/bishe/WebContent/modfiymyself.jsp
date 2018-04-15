<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modfiymyself.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <form action="myself.do" method="post">
    <c:if test="${newmyselfinfo!=null}">
		<input type="button" value="志愿者编号"><input type="text" name="vol_id" value="${newmyselfinfo.volid}" readonly="readonly"><br/>
		<input type="button" value="身份证号码"><input type="text" name="volidnumber" value="${newmyselfinfo.volidnumber}"><br/>
		<input type="button" value="电话号码"><input type="text" name="voltel" value="${newmyselfinfo.voltel}"><br/>
		<input type="button" value="用户名"><input type="text" name="volname" value="${newmyselfinfo.volname}"readonly="readonly"><br/>
		<input type="button" value="密码"><input type="text" name="password" value="${newmyselfinfo.password}"><br/>
		</c:if>
		<input type="submit" value="确认">
		</form>
  </body>
</html>
