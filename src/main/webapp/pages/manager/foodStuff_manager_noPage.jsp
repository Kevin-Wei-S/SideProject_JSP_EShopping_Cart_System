<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.backymeter.service.FoodStuffService" %>
<%@ page import="com.backymeter.service.impl.FoodStuffServiceImpl" %>
<%@ page import="com.backymeter.pojo.FoodStuff" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百米食品 - 食品管理系統</title>
<%@ include file="/pages/common/head.jsp" %>
<link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-foodstuff-manager.css">
</head>
<body>
	
	<div id="title">食品管理系統</div>
	<%@ include file="/pages/common/manager_menu.jsp" %>
       <div id="stuffborder">
          <table>
              <tr id="thead">
                  <th>食品編號</th>
                  <th>名稱</th>
                  <th>價格</th>
                  <th>銷售量</th>
                  <th>庫存量</th>
                  <th>成分</th>
                  <th colspan="2" ><a href="http://localhost:8080/BM02/pages/manager/foodStuff_edit.jsp" id="add">新增品項</a></th> 
              </tr>
              
              <c:forEach items="${ requestScope.foodStuffList }" var="foodStuff">
              	
              	<tr>
              		<td>${ foodStuff.id }</td>
              		<td>${ foodStuff.name }</td>
              		<td>${ foodStuff.price }</td>
              		<td>${ foodStuff.sales }</td>
              		<td>${ foodStuff.stock }</td>
              		<td>${ foodStuff.ingredient }</td>
              		<td><a href="http://localhost:8080/BM02/manager/foodStuffServlet?action=getFoodStuff&id=${ foodStuff.id }" class="update">更改</a></td>
              		<td><a href="http://localhost:8080/BM02/manager/foodStuffServlet?action=delete&id=${ foodStuff.id }" class="delete">刪除</a></td>	
              	</tr>
              
              </c:forEach>

          </table>
       </div>
	<script src="http://localhost:8080/BM02/scripts/script-foodStuff-manager.js"></script>
</body>
</html>