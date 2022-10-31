<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 購物車</title>
<%@ include file="/pages/common/head.jsp" %>
</head>
<body>
	<div id="title">購物車</div>
	<%@ include file="/pages/common/user_menu.jsp" %>
	
	<div id="border">
		<%-- 如果購物車為空 --%>
		<c:if test="${ empty sessionScope.cart.items }">
			<div id="cartEmpty"><a href="http://localhost:8080/BM02/pages/mart/foodStuffMart.jsp">購物車肚子很餓QQ&nbsp; 請幫忙餵飽購物車&nbsp; 感謝您!</a></div>
		</c:if>
		
		<%-- 購物車內有品項 --%>
		<c:if test="${ not empty sessionScope.cart.items }">
			<table border="1" id="cartTable">
			<thead>
				<tr>
					<th>品項-示意圖</th>
					<th>品項-名稱</th>
					<th>品項-數量(單位)</th>
					<th>品項-價格(元)</th>
					<th>單品項-總價格(元)</th>
					<th></th>
				</tr >
			</thead>	
			<tbody>
				<c:forEach items="${ sessionScope.cart.items }" var="entry">
					<tr>
						<td id="img"><img src="http://localhost:8080/BM02/${ entry.value.img_path }" alt="${ entry.value.name }"></td>
						<td>${ entry.value.name }</td>
						<td >
							<input foodStuffId="${ entry.value.id }" type="text" 
								value="${ entry.value.count }" class="cartCount">
						</td>
						<td>${ entry.value.price }</td>
						<td>${ entry.value.totalPrice }</td>
						<td><a href="http://localhost:8080/BM02/cartServlet?action=deleteItem&id=${ entry.value.id }" class="cartDelete">刪除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div align="center" id="billInfo"><span>商品 - 合計數量: ${ sessionScope.cart.totalCount }(單位) - 總金額: ${ sessionScope.cart.totalPrice }(元)</span></div>
			<div align="center" id="cartFunction">
				<a href="http://localhost:8080/BM02/cartServlet?action=clear" id="cartClear">清空購物車</a> &nbsp;&nbsp;
				<a href="http://localhost:8080/BM02/orderServlet?action=createOrder" id="cartBill">結帳</a>
			</div>		
	  </c:if>
	</div>
	<script src="http://localhost:8080/BM02/scripts/script-cart.js"></script>
</body>
</html>