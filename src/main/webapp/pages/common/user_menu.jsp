<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User_Menu</title>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	<div id="menu">
		   <div><span id="userText">${ sessionScope.user.userName }</span> </div>                                                
           <c:if test="${ not empty sessionScope.user }">
           <a href="http://localhost:8080/BM02/orderServlet?action=showUserOrders" class="menuItem">個人訂單</a>
           </c:if>
           <c:if test="${ not empty sessionScope.user }"> 									  
              <a href="http://localhost:8080/BM02/userServlet?action=logout" class="menuItem">登出</a>
           </c:if>
           <a href="http://localhost:8080/BM02/pages/mart/foodStuffMart.jsp" class="menuItem">食品廣場</a>
    </div>
</body>
</html>