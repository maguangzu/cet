<%@ page language="java"  pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <%@include file="../../common/common.jspf" %>
    <title>修改密码</title>
</head>
<body>
		<%@include file="../../common/top.jspf" %>
		<%@include file="../../common/nav.jspf" %>
	<link href="${basePath }css/userPwdUI.css" rel="stylesheet" type="text/css">

<div class="main">
    <div class="ti">
        <h2>修改个人密码</h2>
        <a href="userInfoUI.action">返回</a>
    </div>
    
    <form action="modifyPwd.action" method="post">
    <div class="bo bb">
        <div class="to">
            <div class="xx">
                <span></span><em>密码修改</em>
            </div>
            <div class="cr">
                <h2></h2>
                <div class="bt">
                    <div class="xm">旧密码：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="oldPwd" type="text"  name="oldPwd">
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">新密码：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="newPwd" type="password"  name="newPwd" >
                    </div>
                </div>
                <div class="bt">
                    <div class="wbk" style="margin-left: 120px;color: red;">${msg }</div>
                </div>
            </div>
        </div>

        <div class="xdd">
            <div class="xdd_ri">
                <div class="cc">
                    <input class="cc_01" type="button"  value="保存修改" onclick="doSubmit();">
                </div>
            </div>
        </div>
        
        </form>
    </div>
</div>
	
	<%@include file="../../common/bottom.jspf" %>
	
	<script type="text/javascript">
		function doSubmit(){
			var oldPwd = $("#oldPwd").val();
			if(oldPwd == ''){
				alert("旧密码不能为空");
				$("#oldPwd").focus();
				return;
			}
			var newPwd = $("#newPwd").val();
			if(newPwd == ''){
				alert("新密码不能为空");
				$("#newPwd").focus();
				return;
			}
			document.forms[0].submit();
		}
	</script>	
</body>
</html>