<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager_Menu</title>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	   <div id="menu">                                                 <%-- action=list為總覽 目前使用分頁 --%>
           <a href="http://localhost:8080/BM02/manager/foodStuffServlet?action=page" class="menuItem">食品管理</a> 									  
           <a href="http://localhost:8080/BM02/orderServlet?action=showAllOrders" class="menuItem">訂單管理</a>
           <a href="http://localhost:8080/BM02/pages/mart/foodStuffMart.jsp" class="menuItem">前往商城</a>
           <a href="http://localhost:8080/BM02/index.jsp" class="menuItem">首頁</a>
       </div>
</body>
</html>