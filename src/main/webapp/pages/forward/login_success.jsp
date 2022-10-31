<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品-BackyMeter-百米會員</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	<div id="title">百米會員</div>
	<%@ include file="/pages/common/user_menu.jsp" %>
	<div id="border">
		<div id="welcomeBorder">
			<span id="welcomeText" class="welcomeLine">歡迎
			&nbsp;<span id="welcomeName" class="welcomeLine">${ sessionScope.user.userName }</span>&nbsp;
			蒞臨百米食品</span>
			<a href="http://localhost:8080/BM02/index.jsp" class="welcomeLine">前往首頁</a>
		</div>
	</div>
</body>
</html>