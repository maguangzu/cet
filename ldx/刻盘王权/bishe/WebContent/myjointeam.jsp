<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>我的团队信息</title>  
     <link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="js/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
    <script src="js/lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="js/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
  </head>
  
  <body>
  <table width="70%" cellpadding="0" cellspacing="0" border="1">
	
	<tr><td>团队编号</td><td>${myteaminfo.teamid}</td></tr>
	<tr><td>团队名称</td><td>${myteaminfo.teamname}</td></tr>
	<tr><td>团队人数</td><td>${myteaminfo.teamusernum}</td></tr>
    <tr><td>团队创建者</td><td>${myteaminfo.teamusername}</td></tr>
    <tr><td>团队创建时间</td><td>${myteaminfo.teammadetime}</td></tr>
    <tr><td>团队介绍</td><td>${myteaminfo.teamdesc}</td></tr>
    <tr><td>团队状态</td><td>${myteaminfo.teamzhtai}</td></tr>
	<tr><td>操作</td><td><a href="exittm.do?id=${myteaminfo.teamid }">退出</a></td></tr>

	</table>	
  </body>
</html>
