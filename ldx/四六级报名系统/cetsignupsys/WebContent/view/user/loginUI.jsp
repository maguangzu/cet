<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>会员登录</title>
    <%@include file="../../common/common.jspf" %>
    <link rel="stylesheet" href="${basePath }css/loginUI.css" />
</head>
<body>
    <%@include file="../../common/top.jspf" %>
	
<div class="logo">
    <a href="${basePath }/view/index.jsp"><img src="${basePath }/img/logo.jpeg"></a><span>会员登录</span>
</div>

<div class="main">
    <div class="main_le"><img src="${basePath }/img/loginImg2.jpeg"></div>
    <form action="login.action" id="form" method="post">
    <div class="main_ri">
        <div class="mima">
            <span class="ma"></span>
            <label><em>∗</em>账 号：</label>
            <input class="mi" type="text" placeholder="请输入帐号" id="account" name="account" value="">
        </div>
        <div class="mima">
            <span class="ma"></span>
            <label><em>∗</em>密 码：</label>
            <input class="me" type="password" placeholder="请输入密码" id="password" name="password" value="">
        </div>
        <input type="hidden" />
        <div class="dl">
        <a href="javascript:;" id="sub">登&nbsp;陆</a>
        </div>
        <div class="wjmm">
            <div class="wjmm_01">
				<span style="color: red;">${msg }</span>
            </div>
            <div class="wjmm_02">
                <a href="registerUI.action">免费注册</a>
            </div>
        </div>
    </div>
    </form>
</div>

	<%@include file="../../common/bottom.jspf" %>

<script>
    $(function(){
       $("#sub").click(function(){
           var account   = $("#account").val();
           var password = $("#password").val();
           
           if(account.length<4 || account.length >10){
				$("#account").focus();
				$("#account").val("");
				$("#account").attr("placeholder","帐号格式错误,请重新输入！");
				return;
			}
           if(password.length<4 || password.length >10){
				$("#password").focus();
				$("#password").val("");
				$("#password").attr("placeholder","密码也输错啦！");
				return;
			}
           $("#form").submit();
       }) ;
    });
</script>
</body>
</html>
