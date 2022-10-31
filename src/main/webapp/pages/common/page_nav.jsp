<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page_Nav</title>

<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-client.css">

</head>
<body>
	<%-- 頁碼部分 --%>
	<div id="pageBorder">
	<%-- 如果當前頁面為首頁 即不顯示上一頁及首頁 --%>
       <c:if test="${ requestScope.page.pageNo > 1 }">
       	    <%-- 
	       	    <a href="http://localhost:8080/BM02/client/foodStuffServlet?action=page&page=1" class="pageSupClass">首頁</a>
	       	    <a href="http://localhost:8080/BM02/client/foodStuffServlet?action=page&page=${ requestScope.page.pageNo-1 }" class="pageSupClass">上一頁</a>
       	     --%>
       		<a href="${ requestScope.page.url }&page=1" class="pageSupClass">首頁</a>
       		<a href="${ requestScope.page.url }&page=${ requestScope.page.pageNo-1 }" class="pageSupClass">上一頁</a>
       </c:if>	  
       	  &nbsp;
	   <c:set var="begin" value="1" />
       <c:set var="end" value="${ requestScope.page.pageTotal }" />
       <c:choose>
       		<c:when test="${ requestScope.page.pageTotal > 10 }">
       			<c:choose>
       				<c:when test="${ requestScope.page.pageNo > 6 }">
       					<c:choose>
       						<c:when test="${ (requestScope.page.pageNo + 4) <= requestScope.page.pageTotal }">
       							<c:set var="begin" value="${ requestScope.page.pageNo + 4 - 9 }" />
       							<c:set var="end" value="${ requestScope.page.pageNo + 4 }"/>
       						</c:when>
       						<c:otherwise>
       							<c:set var="begin" value="${ requestScope.page.pageTotal - 9 }"/>
       							<c:set var="end" value="${ requestScope.page.pageTotal }"/>
       						</c:otherwise>
       					</c:choose>
       				</c:when>
       				<c:otherwise>
       					<c:set var="begin" value="1" />
       					<c:set var="end" value="10" />
       				</c:otherwise>
       			</c:choose>
       		</c:when>
       </c:choose>
       <%-- 遍歷設置頁面超連結 --%>
       <c:forEach begin="${ begin }" end="${ end }" var="page" >
       		
       		<c:if test="${ page != requestScope.page.pageNo }">
       			<%-- 
       				<a href="http://localhost:8080/BM02/client/foodStuffServlet?action=page&page=${ page }" class="pageClass">${ page }</a>
       			 --%>
       			 <a href="${ requestScope.page.url }&page=${ page }" class="pageClass">${ page }</a>
       		</c:if>
       		
       		<c:if test="${ page == requestScope.page.pageNo }">
       			<span class="pageClass" id="pageNo">${ page }</span>
       		</c:if>
       
       </c:forEach>
       	  &nbsp;
       <%-- 如果當前頁面為末頁 即不顯示下一頁及末頁 --%>
       <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
       	    <%-- 
       	    	<a href="http://localhost:8080/BM02/client/foodStuffServlet?action=page&page=${ requestScope.page.pageNo+1 }" class="pageSupClass">下一頁</a>
       	    	<a href="http://localhost:8080/BM02/client/foodStuffServlet?action=page&page=${ requestScope.page.pageTotal }" class="pageSupClass">末頁</a>
       	     --%>
       	    <a href="${ requestScope.page.url }&page=${ requestScope.page.pageNo+1 }" class="pageSupClass">下一頁</a>
       	    <a href="${ requestScope.page.url }&page=${ requestScope.page.pageTotal }" class="pageSupClass">末頁</a>
       </c:if>
       </div>
</body>
</html>