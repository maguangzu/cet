<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="addactive.do" method="post">
 <input type="text"  name="activename" placeholder="请输入活动名称">
 <input type="text"  name="begintime" placeholder="开始时间">
 <input type="text"  name="endtime" placeholder="结束时间">
 <input type="text"  name="activeshichang" placeholder="累计时长">
 <input type="text"  name="actvievolnum" placeholder="活动人数">
 <input type="text"  name="activeaddrees" placeholder="活动地点">
 <input type="text"  name="activemajor" placeholder="活动介绍">
 <input type="submit"value="提交">
</form>
</body>
</html>