<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
 <link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="js/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
    <script src="js/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
<script type="text/javascript">
$(function ()
        {
            //限定为数字类型：
            $("#txt1").ligerTextBox({ digits: true });

            //限定为浮点数格式输入框：
            $("#txt2").ligerTextBox({ number: true });
        }); 
</script>
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<c:if test="${newmyselfinfo!=null}">
		<input type="button" value="志愿者编号"><input type="text" value="${newmyselfinfo.volid}"readonly="readonly"><br/>
		<input type="button" value="团队编号"><input type="text"  value="${newmyselfinfo.teamid}"readonly="readonly"><br/>
		<input type="button" value="身份证号码"><input type="text" value="${newmyselfinfo.volidnumber}"readonly="readonly"><br/>
		<input type="button" value="电话号码"><input type="text" value="${newmyselfinfo.voltel}"readonly="readonly"><br/>
		<input type="button" value="用户名"><input type="text" value="${newmyselfinfo.volname}"readonly="readonly"><br/>
		<input type="button" value="密码"><input type="text" value="${newmyselfinfo.password}"readonly="readonly"><br/>
		<input type="button" value="志愿时长"><input type="text" value="${newmyselfinfo.volshichang}"readonly="readonly">
		</c:if>
</body>
</html>