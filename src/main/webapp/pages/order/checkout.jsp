<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 訂單結果</title>
<%@ include file="/pages/common/head.jsp" %>
</head>
<body>
	
	<c:if test="${ not empty sessionScope.orderId }">
		<div id="title">完成訂單</div>
	</c:if>
	
	<c:if test="${ empty sessionScope.orderId }">
		<div id="title">尚未完成訂單</div>
	</c:if>
	
	<%@ include file="/pages/common/user_menu.jsp" %>
	
	<div id="border">
		
		<c:if test="${ not empty sessionScope.orderId }">
			<div id="checkoutInfo">
				您好! &nbsp;
				<span id="checkoutUserName">${ sessionScope.user.userName }</span>
				&nbsp; 剛已完成訂單 &nbsp; 訂單編號為: &nbsp;
				<span id="checkoutOrderId">${ sessionScope.orderId }</span>	
			</div>
		</c:if>
		
		<c:if test="${ empty sessionScope.orderId }">
			<div id="shortageInfo">
				<div id="sorryText">很抱歉! &nbsp;以下品項目前庫存不足 &nbsp;如有其他商品急需 &nbsp;請先調整購物車  &nbsp;將會盡快補貨 &nbsp;謝謝您!</div>	
				<c:forEach items="${ sessionScope.shortageMap }" var="entry">
					<div class="shortageItem">品項: <span class="shortageName">${ entry.key }</span> - 目前庫存: <span class="shortageCount">${ entry.value }</span> (單位)</div>
				</c:forEach>
			</div>
		</c:if>
	
	</div>

</body>
</html>