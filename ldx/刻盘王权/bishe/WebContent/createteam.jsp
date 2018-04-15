<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>创建新的团队</title>
</head>
<body>
<form action="createteam.do" method="post">
团队名称<input type="text" name="team_name"><br/>
描述<input type="text" name="team_desc"><br/>
介绍<input type="text" name="team_js"><br/>
招收人数<input type="text" name="team_usernum"><br/>
服务方向
<input type="checkbox" name="team_shuxing" value="1">
<input type="checkbox" name="team_shuxing" value="2">
<input type="checkbox" name="team_shuxing" value="3">
<input type="checkbox" name="team_shuxing" value="4">
<input type="checkbox" name="team_shuxing" value="5">
<input type="checkbox" name="team_shuxing" value="6">
<input type="checkbox" name="team_shuxing" value="7">
<input type="checkbox" name="team_shuxing" value="8">
<br/>
<input type="button" value="提交">
</form>
</body>
</html>