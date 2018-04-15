<%@ page language="java"  pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>完善个人信息</title>
    <%@include file="../../common/common.jspf" %>
    <link rel="stylesheet" href="${basePath }css/userInfoUI.css">
</head>
<body>
		<%@include file="../../common/top.jspf" %>
		<%@include file="../../common/nav.jspf" %>

<div class="main">
	<form action="signUp.action" method="post"  enctype="multipart/form-data" id="form1">
    <div class="ti">
        <h2>四六级报名信息
        
        <c:choose>
        		<c:when test="${!empty CANDIDATEINFO}">
        			<span style="color:red;font-size:14px;">(已报名四六级)</span>
        		</c:when>
        		<c:otherwise>
				<span style="color:red;font-size:14px;">(未报名四六级)</span>
			</c:otherwise>
        </c:choose>
       
      	
        </h2>
        
        <c:choose>
        		<c:when test="${!empty CANDIDATEINFO}">
        			 <a href="${basePath }view/admissionInfo.html">打印准考证信息</a>
        		</c:when>
        		<c:otherwise>
				 <a href="javascript:alert('未进行四六级报名');" style="color:gray;">打印准考证信息</a>
			</c:otherwise>
        </c:choose>
        <a href="userPwdUI.action" style="background-color: #F76030;border:1px solid #F76030">修改个人密码</a>
        
        
    </div>
    <div class="bo bb">
        <div class="to">
            <div class="xx">
                <span></span><em>用户详细信息</em>
            </div>
            <div class="cr">
                <h2>完善信息</h2>
                <div class="bt">
                    <div class="xm">用户帐号：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="account"  name="account" type="text" value="${USERINFO.account }"  readonly="readonly">
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">手机号码：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="mobile" name="phone" type="text" value="${USERINFO.mobile }"   readonly="readonly">
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">邮箱：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="email" name="email" type="text" value="${USERINFO.email }"  readonly="readonly">
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">姓名：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="name"  type="text" value="${CANDIDATEINFO.name }" name="name">
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">性别：</div>
                    <div class="wbk">
                        <select name="sex" class="wbk_01" style="width: 100px;" >
                        	<option value="男" <%="${CANDIDATEINFO.sex}".equals("男") ? "selected":"" %>>男</option>
                        	<option value="女" <%="${CANDIDATEINFO.sex}".equals("女") ? "selected":"" %>>女</option>
                        </select>
                    </div>
                </div>
                <div class="bt">
                    <div class="xm">身份证号：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="bodycode" type="text" value="${CANDIDATEINFO.idcard }" placeholder="请输入身份证" name="idcard">
                    </div>
                </div>
                
                <div class="bt">
                    <div class="xm">CET类型：</div>
                    <div class="wbk">
                        <select name="cetType" class="wbk_01" style="width: 100px;" >
                        	<option value="CET-4"  <%="${CANDIDATEINFO.cetType}".equals("CET-4") ? "selected":"" %>>CET-4</option>
                        	<option value="CET-6"  <%="${CANDIDATEINFO.cetType}".equals("CET-6") ? "selected":"" %>>CET-6</option>
                        </select>
                    </div>
                </div>
                
                <div class="bt">
                    <div class="xm">通讯住址：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="bodycode" type="text" value="${CANDIDATEINFO.commAdress }" placeholder="请输入家庭住址" name="commAdress">
                    </div>
                </div>
              
                <div class="_headImg">
                	<img src="${CANDIDATEINFO.personImg }" alt="个人照片" style="width:100%;height:100%;" />
                </div>
                <div class="bt">
                    <div class="xm">个人照片上传：</div>
                    <div class="wbk">
                        <input class="wbk_01" id="bodycode" type="file" name="file">
                    </div>
                </div>
                <input type="hidden" name=personImg value="${CANDIDATEINFO.personImg }" />
            </div>
        </div>

        <div class="xdd">
            <div class="xdd_ri">
                <div class="cc">
                
                <c:choose>
		        		<c:when test="${!empty CANDIDATEINFO}">
		        			
		        		</c:when>
		        		<c:otherwise>
						<input class="cc_01" type="button" id="subtn" value="报  名" onclick="doSubmit()">
					</c:otherwise>
       			</c:choose>
                        
                </div>
            </div>
        </div>
    </div>
    
    	<input name="id"  type="hidden" value="${USERINFO.id }"/>
    </form>
</div>
		
		<%@include file="../../common/bottom.jspf" %>
		
		
		<script type="text/javascript">
		
			function doSubmit(){
				document.forms[0].submit();
			}
			
		</script>
</body>
</html>
