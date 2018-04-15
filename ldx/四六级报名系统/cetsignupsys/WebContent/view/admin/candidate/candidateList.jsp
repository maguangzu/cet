<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>考生信息 列表</title>
		<%@include file="../../../common/common.jspf" %>		
		<link rel="stylesheet" href="${basePath }/acss/carList.css"/>	
			
	</head>
	<body>
		<div class="_BigBox">
			<p>考生信息列表</p>
			
			<form action="candidateList.action" id="form1" method="get">
			<div class="_clearFloat"></div>
			<div class="_table">
				<table id="carTable" border="" cellspacing="" cellpadding="">
					<tr>
						<th>准考证号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>身份证号</th>
						<th>报考类型</th>
						<th>电话</th>
						<th>通讯地址</th>
						<th>操作</th>
						
					</tr>
					<c:forEach var="candidate" items="${page.items}">
						<tr>
							<td>${candidate.admissionCard }</td>
							<td>${candidate.name }</td>
							<td>${candidate.sex }</td>
							<td>${candidate.idcard }</td>
							<td>${candidate.cetType }</td>
							<td>${candidate.phone }</td>
							<td>${candidate.commAdress }</td>
							
							
							<td><a href="candidateDetailUI.action?id=${candidate.id }">查看</a>&nbsp;
								<c:if test="${ADMININFO.role }">
									<a href="candidateModifyUI.action?id=${candidate.id }">修改</a>
								</c:if>	
							</td>
						</tr>
					</c:forEach>
					
					<input type="hidden" name="currentPage" id="indexPage" value="${page.pageNo}"/>
					
					<tr>
					<td colspan="8">
					
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
			</div>
		</div>
		</form>
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
	</body>
</html>
