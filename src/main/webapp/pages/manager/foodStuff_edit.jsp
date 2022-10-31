<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<title>百米食品 - 新增品項</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>

<body>
	<div id="title">新增食品項目</div>
	<%@ include file="/pages/common/manager_menu.jsp" %>
	<form action="http://localhost:8080/BM02/manager/foodStuffServlet" method="post">
		<div id="editBorder">
			<div id="addStuff">
				<input type="hidden" name="action" value="add">
				<input type="text" placeholder="新增食品-名稱" id="name" name="name" class="text">
				<input type="text" placeholder="新增食品-價格" name="price" class="text">
				<input type="text" placeholder="新增食品-銷售量" name="sales" class="text">
				<input type="text" placeholder="新增食品-庫存量" name="stock" class="text">
				<input type="text" placeholder="新增食品-內容成分" name="ingredient" class="text">
				<input type="submit" value="新增" id="submit">
			</div>
			<div id="addInfoD"><span id="addInfoS">${ requestScope.addInfo }</span></div>
		</div>
	</form>
	<script src="http://localhost:8080/BM02/scripts/script-foodStuff-edit.js"></script>
</body>

</html>
