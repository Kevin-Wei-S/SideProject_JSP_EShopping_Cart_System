<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client_Menu</title>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	<div id="menu">
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<a href="http://localhost:8080/BM02/pages/user/login.jsp" class="menuItem">登入/註冊</a> 	
			</c:when>                                                
           	<c:otherwise>
           		<a href="http://localhost:8080/BM02/pages/user/login_success.jsp" id="greetUser">${ sessionScope.user.userName }</a>
           	</c:otherwise>							  
        </c:choose>    
           <a href="http://localhost:8080/BM02/pages/cart/cart.jsp" class="menuItem">
           		購物車
           		<c:if test="${ not empty sessionScope.cart.items && sessionScope.cart.idTotalCount>0 }">
           			<span class="parentheses">(</span><span id="cartCount">${ sessionScope.cart.idTotalCount }</span><span class="parentheses">)</span>
           		</c:if>
           </a>
           <a href="http://localhost:8080/BM02/pages/client/search_foodStuff.jsp" class="menuItem">搜尋食品</a>
           <a href="http://localhost:8080/BM02/index.jsp" class="menuItem">首頁</a>
    </div>
</body>
</html>