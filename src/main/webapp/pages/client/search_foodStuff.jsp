<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search_FoodStuff</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-client.css">
</head>
<body>
	<div id="title">搜尋食品</div>
	<%@ include file="/pages/common/client_menu.jsp" %>
		<div id="serchBorder">
			<span class="searchItems" id="priceText">價格區間:</span>
			<input type="text" placeholder="起始價格(元)" class="searchItems" id="beginPrice" name="beginPrice">
			<span class="searchItems" id="symbol">==&gt;&gt;</span>
			<input type="text" placeholder="最終價格(元)" class="searchItems" id="endPrice" name="endPrice">
			<button id="searchBtn">查詢</button>
		</div>		
	
	<script>
		$(function(){
			$("#beginPrice").focus();
			
			$("#searchBtn").click(function(){
				
				var beginPrice = $(this).parent().find("input").eq(0).val();
				var endPrice = $(this).parent().find("input").eq(1).val();
				location.href = "http://localhost:8080/BM02/client/foodStuffServlet?action=pageByPrice&beginPrice=" + beginPrice + "&endPrice=" + endPrice; 
			})
		})
	</script>
</body>
</html>