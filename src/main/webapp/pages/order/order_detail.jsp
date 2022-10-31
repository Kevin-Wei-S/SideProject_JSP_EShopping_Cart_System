<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 訂單明細</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-manager.css">
</head>
<body>
	<div id="title">訂單明細</div>	
	<c:if test="${ fn:contains(header.referer, 'showAllOrder') }">
		<%@ include file="/pages/common/manager_menu.jsp" %>
	</c:if>
	<c:if test="${ fn:contains(header.referer, 'showUserOrder') }">
		<%@ include file="/pages/common/user_menu.jsp" %>
	</c:if>
	<div id="border">
			<div id="detailUserId">會員編號: ${ requestScope.order.user_id }</div>
			<div id="detailOrderId">訂單編號: ${ requestScope.order.order_id }</div>
			<div id="detailCreateTime">訂單-創建時間: ${ requestScope.order.create_time }</div>
			<%-- 判斷訂單貨運狀態 --%>
			<c:if test="${ order.status==0 }">
				<div id="detailOrderStatus">訂單貨運狀態: <span id="detailStatus0">未出貨</span></div>
			</c:if>
			<c:if test="${ order.status==1 }">
				<div id="detailOrderStatus">訂單貨運狀態: <span id="detailStatus1">已出貨</span></div>
			</c:if>
			<c:if test="${ order.status==2 }">
				<div id="detailOrderStatus">訂單貨運狀態: <span id="detailStatus2">已簽收</span></div>
			</c:if>
			
			<table border="1" id="cartTable">
			<thead>
				<tr>
					<%-- <th>品項-示意圖</th> --%>
					<th>品項-名稱</th>
					<th>品項-數量(單位)</th>
					<th>品項-價格(元)</th>
					<th>單品項-總價格(元)</th>
				</tr >
			</thead>	
			<tbody>
				<c:forEach items="${ requestScope.detailList }" var="orderItem">
					<tr>
						<%-- <td id="img"><img src="http://localhost:8080/BM02/${ entry.value.img_path }" alt="${ entry.value.name }"></td> --%>
						<td>${ orderItem.name }</td>
						<td>${ orderItem.count }</td>
						<td>${ orderItem.price }</td>
						<td>${ orderItem.total_price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div align="center" id="billInfo"><span>商品 - 合計數量: ${ requestScope.orderCount }(單位) - 總金額: ${ requestScope.order.price }(元)</span></div>
			
	</div>
	<script src="http://localhost:8080/BM02/scripts/script-cart.js"></script>
</body>
</html>