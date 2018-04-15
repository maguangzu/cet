<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="../common.jspf" %>		
		<title>用户列表</title>
		<link rel="stylesheet" href="${basePath }acss/userList.css" />
	</head>
	<body>
		<div class="_BigBox">
			<p>用户列表</p>
			<div class="_table">
			
				<form action="userList.action" id="form1" method="get">
			
					<table border="" cellspacing="" cellpadding="">
						<tr>
							<th>account</th>
							<th>mobile</th>
							<th>email</th>
							<th>role</th>
							<th>操作</th>
						</tr>
						<c:forEach var="user" items="${page.items}">
							<tr>
								<td>${user.account}</td>
								<td>${user.mobile }</td>
								<td>${user.email}</td>
								<td>${user.role==true?'系统管理员':'系统用户'}</td>
								<td><a href="userDetailUI.action?uid=${user.id }">查看</a>
								<a href="javascript:if(confirm('删除该记录会同时删除四六级报名信息?')){location='removeUser.action?uid=${user.id }'}" >删除</a>
								</td>
							</tr>
						</c:forEach>
						
						<input type="hidden" name="currentPage" id="indexPage" value="${page.pageNo}"/>
						
						<tr>
						<td colspan="5">
						<span class="total_page">${page.totalSize } 条记录 ${page.pageNo}/${page.totalPage} 页</span> 
						
						
						<!-- 判断是否存在上一页 -->
						<c:choose>
							<c:when test="${page.pageNo <= 1 }">
							</c:when>
							<c:otherwise>
								 <span class="page-start"><a href="javascript:frontPage()" >上一页</a></span> 
							</c:otherwise>
						</c:choose>
						
						<!-- 判断是否存在下一页 -->
						
						<c:choose>
							<c:when test="${page.pageNo >= page.totalPage }">
							
							</c:when>
							<c:otherwise>
								 <span class="page-start"><a href="javascript:nextPage()">下一页</a></span> 
							</c:otherwise>
						</c:choose>
						
					
						<c:choose>
							
							<c:when test="${page.totalPage < 10}">
								<c:set var="begin" value="1"/>
								<c:set var="end" value="${page.totalPage}"/>
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${page.pageNo - 4}"/>
								<c:set var="end" value="${page.pageNo + 5}"/>
							</c:otherwise>
						</c:choose>
		
						<c:if test="${begin < 1 }">
							<c:set var="begin" value="1"/>
							<c:set var="end" value="10"/>
						</c:if>
							
						<c:if test="${end > page.totalPage }">
							<c:set var="begin" value="${page.totalPage - 9}"/>
							<c:set var="end" value="${page.totalPage }"/>
						</c:if>
					
						
						<!-- 输出页码 -->
						<c:forEach var="i" begin="${begin }" end="${end }" varStatus="status">
							<c:choose>
								<c:when test="${page.pageNo == i }">
									<span class='current page-cur'><a href="javascript:currentPage()" id="currentPage">${i }</a></span>
								</c:when>
								<c:otherwise>
									<span class="page-start"><a href="javascript:gotoPage(${i })" id="goto_page_${i }">${i }</a></span> 
								</c:otherwise>
							
							</c:choose>
						</c:forEach>
						</td>
						</tr>
						
					</table>
				
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	function gotoPage(i){
		var pageGoto=$("#goto_page_"+i).text();
		$("#indexPage").val(pageGoto);
		$("#form1").submit();
	}
	
	function currentPage(){
		$("#indexPage").val('${page.pageNo}');
		$("#form1").submit();
	}
	
	function nextPage(){
		$("#indexPage").val('${page.pageNo + 1}');
		$("#form1").submit();
	}
	
	function frontPage(){
		
		$("#indexPage").val('${page.pageNo - 1}');
		$("#form1").submit();
	}
	</script>
</html>