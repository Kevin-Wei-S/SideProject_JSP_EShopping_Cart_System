<%@ page import="com.backymeter.pojo.FoodStuff" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 更改品項內容</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	<div id="title">更改品項內容</div>
	<%@ include file="/pages/common/manager_menu.jsp" %>
	<form action="http://localhost:8080/BM02/manager/foodStuffServlet" method="post">
		<div id="editBorder">
			<div id="updateStuff">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="preId" value="${ requestScope.foodStuff.id }">
				<input type="hidden" name="page" value="${ param.page }">
				<input type="text" placeholder="更改-編號" id="id" name="id" class="text" value="${ requestScope.foodStuff.id }">
				<input type="text" placeholder="更改-名稱" name="name" class="text" value="${ requestScope.foodStuff.name }">
				<input type="text" placeholder="更改-價格" name="price" class="text" value="${ requestScope.foodStuff.price }">
				<input type="text" placeholder="更改-銷售量" name="sales" class="text" value="${ requestScope.foodStuff.sales }">
				<input type="text" placeholder="更改-庫存量" name="stock" class="text" value="${ requestScope.foodStuff.stock }">
				<input type="text" placeholder="更改-內容成分" name="ingredient" class="text" value="${ requestScope.foodStuff.ingredient }">
				<input type="submit" value="更新" id="submit">
			</div>
			<div id="updateInfoD"><span id="updateInfoS">${ requestScope.updateInfo }</span></div>
		</div>
	</form>
	<script src="http://localhost:8080/BM02/scripts/script-foodStuff-edit.js"></script>
</body>
</html>