<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
    <script type="text/javascript" src="<c:url value="/resources/jquery/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/home.js" />"></script>
</head>

<body>
	<h3>Welcome to Twitter Craft Demo</h3>
	<div class="containerBody" id="containerBody">
	aaaaaaaa
		<div class="main-container" id="main-container">
			<div class="title" id="healthchecks"></div>
			<div id="sub-container"  class="sub-container"></div>
		</div>
	</div>	

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
</body>
</html>