<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 訂單管理系統</title>
<%@ include file="/pages/common/head.jsp" %>
</head>
<body>
	
	
	<div id="title">訂單管理系統</div>	
	<%@ include file="/pages/common/manager_menu.jsp" %>
	
	<%-- 視窗選單 --%>
	<div id="updateContent"></div>
	
	<div id="orderborder">
		
		<table border="1" id="managerOrderTable">
		
			<thead>
				<tr>
					<th>訂單編號</th>
					<th>創建時間</th>
					<th>總額</th>
					<th>貨品狀態</th>
					<th>客戶編號</th>
					<th>訂單詳情</th>
				<tr>
			</thead>
		
			<tbody>
				<c:forEach items="${ requestScope.orders }" var="order">
					<tr>
						<td class="orderId">${ order.order_id }</td>
						<td>${ order.create_time }</td>
						<td>${ order.price }</td>
						
						<%-- 判斷貨品目前運送狀態 --%>
						<c:if test="${ order.status == 0 }">
							<td class="ready">未出貨</td>
						</c:if>
						<c:if test="${ order.status == 1 }">
							<td class="forward">已出貨</td>
						</c:if>
						<c:if test="${ order.status == 2 }">							
							<td class="receive">已簽收</td>									
						</c:if>
						
							
						
						<td>${ order.user_id }</td>
						<td><a href="http://localhost:8080/BM02/orderServlet?action=showOrderDetails&orderId=${ order.order_id }" class="orderDetail">訂單詳情</a></td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
	<script src="http://localhost:8080/BM02/scripts/script-manager_order.js"></script>
</body>
</html>