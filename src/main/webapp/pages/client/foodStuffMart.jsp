<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 食品廣場</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-client.css">
</head>
<body>
	<div id="title">食品廣場</div>
	<%@ include file="/pages/common/client_menu.jsp" %>
	
	<div id="martBorder">
		
		<%-- 提示-剛剛新添加的品項 如果session域中有newAdd即顯示 --%>
		<c:if test="${ not empty sessionScope.cart.items && not empty sessionScope.newAdd }">
			<div id="newAddInfo">購物車-新添加 <span id="newAddName">&lt;${ sessionScope.newAdd }&gt;</span> 品項</div>
		</c:if>
	
			<%-- 遍歷Page中items --%>
		<div id="cartItemsBorder">
			<c:forEach items="${ requestScope.page.items }" var="foodStuff">
				<form action="http://localhost:8080/BM02/cartServlet" method="post" class="stuffItem">
					<input type="hidden" name="action" value="addItem">
					<input type="hidden" name="foodStuffId" value=${ foodStuff.id }>
					<input type="hidden" name="page" value=${ requestScope.page.pageNo }>
					<img src="http://localhost:8080/BM02/${ foodStuff.img_path }" alt="${ foodStuff.name }">
		            <span>品名: ${ foodStuff.name }</span>
		            <span>價格: ${ foodStuff.price }</span>
		            <span>銷售: ${ foodStuff.sales }</span>
		            <span>庫存: ${ foodStuff.stock }</span>
		            <c:if test="${ foodStuff.stock > 0 }">
		            	<input name="${ foodStuff.name }" type="submit" value="&oplus;加入購物車&oplus;" class="btn">
		        	</c:if>
		        	<c:if test="${ foodStuff.stock <= 0 }">
		            	<div class="shortage">&oplus;全力補貨中&oplus;</div>
		        	</c:if>
		        </form>
			</c:forEach>
		</div>
	</div>
	<%-- 靜態包含分頁條 --%>
	<%@ include file="/pages/common/page_nav.jsp" %>
	
	<script src="http://localhost:8080/BM02/scripts/script-foodStuffMart.js"></script>

</body>
</html>