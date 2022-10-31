<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="utf-8">
    <title>百米食品 - BackyMeter</title>  
    <meta name="description" content="老麵手工包子饅頭肉包菜包壽桃">
    <link rel="stylesheet" href="https://raw.githubusercontent.com/filipelinhares/ress/master/ress.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@100;400&family=Noto+Serif+TC:wght@200&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Shalimar&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-index.css">
</head>

<body>
    <div class="header wrapper">
        <div class="header-group"> 
        	<div>
        		<c:if test="${ not empty sessionScope.admin}">
        			<a href="http://localhost:8080/BM02/pages/manager/manager.jsp"><img id="admin-icon" src="http://localhost:8080/BM02/static/img/admin-icon.png" alt="admin-icon"></a>       
        		</c:if>
        	</div>
            <div class="logoText"> 
                <a href="http://localhost:8080/BM02/index.jsp"><img id="logo" src="http://localhost:8080/BM02/static/img/BMR.png" alt="BM-Logo"></a>
                <h1 id="chText"><a href="http://localhost:8080/BM02/index.jsp">百米食品</a></h1>
            </div>
            <div class="asis-group">               
               <c:choose>
               		<c:when test="${ empty sessionScope.user }">
               			<a href="http://localhost:8080/BM02/pages/user/login.jsp"><img id="member-icon" src="http://localhost:8080/BM02/static/img/member-icon.png" alt="member-icon"></a>
               		</c:when>
               		<c:otherwise>
               			<a href="http://localhost:8080/BM02/pages/user/login_success.jsp" id="greetUser">${ sessionScope.user.userName }</a>
               		</c:otherwise>
               </c:choose>
                <a href="http://localhost:8080/BM02/pages/cart/cart.jsp"><img id="mart-icon" src="http://localhost:8080/BM02/static/img/mart-icon2.png" alt="mart-icon"></a>
                <a href="http://localhost:8080/BM02/pages/client/search_foodStuff.jsp"><img id="search-icon" src="http://localhost:8080/BM02/static/img/search-icon2.png" alt="search-icon"></a>
            </div>
        </div>
        <h1 id="engText"><a href="http://localhost:8080/BM02/index.jsp">BACKYMETER</a></h1>
        <div>
            <ul class="headerMenu">
                <li class="item"><a href="#" id="i1">發燒消息</a></li>
                <li class="item"><a href="#" id="i2">百米小故事</a></li>
                <li class="item"><a href="http://localhost:8080/BM02/pages/mart/foodStuffMart.jsp" id="i3">賀呷菜單</a></li>
                <li class="item"><a href="#" id="i4">下單須知</a></li>
                <li class="item"><a href="#" id="i5">聯絡我們</a></li>
            </ul>
        </div>
    </div>

    <div class="intro-bg wrapper">
    </div>
    <div class="intro-text wrapper">
        <h2>百米 - 饅頭肉包為何會如此美味!</h2>
        <div id="boundLine"></div>
        <p>剛出爐的鮮肉包, &nbsp;&nbsp;令人食指大動, &nbsp;&nbsp;口水直流 ~</p>
    </div>
        
</body>

</html>