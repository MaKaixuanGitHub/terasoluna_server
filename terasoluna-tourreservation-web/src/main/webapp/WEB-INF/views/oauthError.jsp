<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>OAuth Error!</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>OAuth Error!</h1>
        <c:if test="${not empty error}">
            <p>${f:h(error.oAuth2ErrorCode)}</p> <!-- (1) -->
            <p>${f:h(error.message)}</p> <!-- (2) -->
        </c:if>
    <br>
    </div>
</body>
</html>