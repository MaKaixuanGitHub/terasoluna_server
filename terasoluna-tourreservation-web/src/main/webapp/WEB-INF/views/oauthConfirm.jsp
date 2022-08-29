<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body>
    <div id="wrapper">
        <h1>OAuth Approval</h1>
        <p>Do you authorize ${f:h(authorizationRequest.clientId)} to access your protected resources?</p>  <!-- (1) -->
        <form id="confirmationForm" name="confirmationForm" action="${pageContext.request.contextPath}/oauth/authorize" method="post">
            <c:forEach var="scope" items="${scopes}">  <!-- (2) -->
                <li>
                    ${f:h(scope.key)}
                    <input type="radio" name="${f:h(scope.key)}" id="${f:h(scope.key)}_approve" value="true"/><label for="${f:h(scope.key)}_approve">Approve</label>
                    <input type="radio" name="${f:h(scope.key)}" id="${f:h(scope.key)}_deny" value="false"/><label for="${f:h(scope.key)}_deny">Deny</label>
                </li>
            </c:forEach>
            <input type="hidden" name="user_oauth_approval" value="true"/>  <!-- (3) -->
            <sec:csrfInput />  <!-- (4) -->
            <label>
                <input type="submit" id="authorize" value="Authorize"/>
            </label>
        </form>
    </div>
</body>