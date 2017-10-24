<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
    <script type="text/javascript" src="<c:url value="/resources/jquery/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/home.js" />"></script>
</head>

<body>
	<h3>Welcome to Twitter Craft Demo</h3>
	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:out value="${pageContext.request.userPrincipal.name}"></c:out>
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<div class="containerBody" id="containerBody">
	<form id="tweetForm">
		<div class="main-container" id="main-container">
			<div id="post-container" class="post-container">
					<table>
						<tr>
							<td>What is in your mind</td>
							
						</tr>
						<tr>
							<td><textarea id="tweetarea" name="tweetarea" rows="4" cols="50"></textarea></td>
							<td id="tddd" class="tddd">
								<input type="text" size="30" id="followbox" name="followbox" />
								<a id="followlink" class="followlink" href="#">Follow</a>
							</td>
						</tr>
						
					</table>
				</div>
				<div class="post-message">
					<input type="submit"  value="Post" style="height: 23px; width: 65px;"  id="postMessage"></input>
				</div>
			<div id="sub-container"  class="sub-container"></div>
		</div>
	</form>
	</div>	

	
</body>
</html>