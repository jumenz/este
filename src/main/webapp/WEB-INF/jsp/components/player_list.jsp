<%@include file="../includes/taglibs_variables.jspf" %>

		<h2><c:out value="${headline }"/></h2>
		<c:forEach var="topPlayer" items="${players}">
			<c:out value="${topPlayer.firstName} ${topPlayer.lastName}"/>
			<br>
		</c:forEach>
		
		
		<!-- <c:set var="players" value="${topPlayers.players}" scope="request"/>
		<jsp:include page="./components/player_list.jsp">
			<jsp:param name="headline" value="Unsere Besten"/>
		</jsp:include>
		<c:remove var="players"/> -->