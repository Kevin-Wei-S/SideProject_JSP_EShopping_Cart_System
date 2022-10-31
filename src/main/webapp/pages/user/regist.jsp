<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <title>加入會員 - 百米會員</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
    <link
    href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@100;400&family=Noto+Serif+TC:wght@200&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Shalimar&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/BM02/styles/style-register.css">
    <script src="https://code.jQuery.com/jQuery-3.6.0.min.js"></script>
</head>
<body>
    <form method="post" action="http://localhost:8080/BM02/userServlet" name="form" id="form">
        <input type="hidden" name="action" value="regist">
        <div class="title">
            <span id="chTitle">百米食品</span><br>
            <span id="enTitle">BACKYMETER</span><br>
            <span id="joinMsg">會員資料</span>
        </div>
        <div class="inputGroup">
            <div class="combine">
                <div class="leftgroup">
                    <input type="text" placeholder="姓名" maxlength="12" size="25" name="userName" id="userName" class="lblock" value="${param.userName}">
                    <input type="text" placeholder="帳號 <英數字5-12碼>" maxlength="12" name="account" id="account" class="lblock" value="${ param.account }">
                    <input type="text" placeholder="E-mail" maxlength="120" name="email" id="email" class="lblock" value="${ param.email }">
                    <input type="text" placeholder="手機號碼" maxlength="10" name="phone" id="phone" class="lblock" value="${ param.phone }">
                    <input type="hidden" name="salt" value="">
                    </div>
                <div class="rightgroup">
                    <span class="story" id="frontstory">百米小故事</span>
                    <img src="http://localhost:8080/BM02/static/img/Delicious.png" id="black">
                    <span class="story" id="backstory"><span id="actor">黑仔</span>必須很小心...大家都想吃他QQ</span>
                </div>
            </div>
            <div id="genderErrorGroup">
                <div class="gendergroup">
                    <input type="radio" name="gender" value="M" id="male" <%=request.getParameter("gender")==null ? "checked" : "" %> <%="M".equals(request.getParameter("gender")) ? "checked" : "" %> class="gender"><label for="male">男性</label>
                    <input type="radio" name="gender" value="F" id="female" <%="F".equals(request.getParameter("gender")) ? "checked" : "" %> class="gender"><label for="female">女性</label>
                    <input type="radio" name="gender" value="E" id="else" <%="E".equals(request.getParameter("gender")) ? "checked": "" %> class="gender"><label for="else">其他</label>
                </div> 
                <span id="error">${ requestScope.registError }</span>
            </div>
            <div class="passwdgroup">
                <input type="password" placeholder="密碼 <5-12碼>" maxlength="12" name="password" id="password" class="block" >
                <input type="password" placeholder="確認密碼" maxlength="12" name="checked" id="checked" class="block" >
            </div>
            <div id="confirmGroup">
            <%-- 
            	應用Google驗證碼 KaptchaServlet	 
             --%>
                <img src="http://localhost:8080/BM02/kaptcha.jpg" id="token">
                <input type="button" value="刷新" id="refresh">
                <input type="text" placeholder="驗證碼" maxlength="5" name="code" id="code" >
            	
            </div>
            <input type="submit" value="加入" name="register" id="register">
        </div>
    </form>
    <script src="http://localhost:8080/BM02/scripts/script-register.js"></script>
</body>
</html>