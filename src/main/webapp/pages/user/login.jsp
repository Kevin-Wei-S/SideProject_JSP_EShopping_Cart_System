<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <title>會員登入 百米食品-BackyMeter</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
    <link
    href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@100;400&family=Noto+Serif+TC:wght@200&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Shalimar&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-login.css">
</head>
<body>
    <form method="post" action="http://localhost:8080/BM02/userServlet" >
        <input type="hidden" name="action" value="login">
        <div id="title">
        <span id="chTitle">百米食品</span>
        <span id="enTitle">BACKYMETER</span>
        <span id="memberTitle">會員登入</span>
        </div>
        <div id="middle">
            <img src="http://localhost:8080/BM02/static/img/MeatActor.png" id="meatActor">
            <div>
                <input type="text" placeholder="會員帳號" name="account" id="account" class="block" value="${ cookie.account.value }" >
                <input type="password" placeholder="會員密碼" name="password" id="password" class="block" >  
            </div>
        </div>
        <div id="error">${ requestScope.loginError }</div>
        <input type="submit" value="登入" id="login">
        <div id="footer">
            <a href="http://localhost:8080/BM02/pages/user/regist.jsp" id="memberHref">加入會員</a>
            <a href="http://localhost:8080/BM02/index.jsp" id="indexHref">回首頁</a>
        </div>
    </form>
    <script src="http://localhost:8080/BM02/scripts/script-login.js"></script>
</body>
</html>