<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Spielberichte"/>
		<jsp:param name="description" value="Startseite der Frauen des Este 06/70"/>
	</jsp:include>
		
	<body>
		<%-- header --%>
		<jsp:include page="./includes/header.jsp"/>

		<%-- content --%>
        <div class="main-container">
        <%-- Content --%>
        <div class="container">
        <div class="main">
        <div class="main-inner">
        	<%-- Sidebar --%>
        	<security:authorize access="hasRole('USER_GROUP_ADMIN')">
	        	<jsp:include page="./includes/sidebar.jsp">
					<jsp:param name="sidebarTitle" value="Spielberichte"/>
					<jsp:param name="search" value="include" />
					<jsp:param name="searchLink" value="${linkReportsSearch}"/>
					<jsp:param name="nav" value="Startseite"/>
					<jsp:param name="ref" value="${linkWelcome}"/>
					<jsp:param name="nav" value="Bericht verfassen"/>
					<jsp:param name="ref" value="${linkReportsNew}" />
				</jsp:include>
			</security:authorize>
			<security:authorize access="hasRole('USER_GROUP_NO_ADMIN') or not isAuthenticated()">
	        	<jsp:include page="./includes/sidebar.jsp">
					<jsp:param name="sidebarTitle" value="Spielberichte"/>
					<jsp:param name="search" value="include" />
					<jsp:param name="nav" value="Startseite"/>
					<jsp:param name="ref" value="${linkWelcome}"/>
				</jsp:include>
			</security:authorize>
       
			<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<ul>
					<%-- Spielberichte --%>
					<%-- <c:forEach var="entry" items="${reportModel.entries}" varStatus="status"> --%>
					<c:forEach var="entry" items="${reportPage.pageItems}" varStatus="status">
						<li class="one-col">
							<%-- einzelner Bericht --%>
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="address-name" >${entry.topic}</h2>
								<div id="submit-${status.index}" class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<%-- Kurzangeben --%>
									<div class="box-info clearfix light-bg">
										<div class="left half-width">
											<table class="first">
												<tbody>
												<tr class="first">
													<th class="first">Name des Gegners:</th>
													<td class="last"><c:out value="${entry.opponent}"></c:out></td>
												</tr>
												<tr>
													<th class="first">Halbzeit:</th>
													<td class="last">
														<c:out value="${entry.scoreFirstHalfHome}"></c:out>:
														<c:out value="${entry.scoreFirstHalfGuest}"></c:out>
													</td>
												</tr>
												</tbody>
											</table>
										</div>
										<div class="left half-width">
											<table class="last">
												<tbody>
												<tr>
													<th class="first">Datum:</th>
													<td class="last">${entry.date}</td>
												</tr>
												<tr>
													<th class="first">Endstand:</th>
													<td class="last">
														<c:out value="${entry.scoreSecondHalfHome}"></c:out>:
														<c:out value="${entry.scoreSecondHalfGuest}"></c:out>
													</td>
												</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="box-body">
										<%-- Text --%>
										<p>${entry.text}</p>
										
										<%-- Bearbeiten und löschen, wenn ein Admin angemeldet ist --%>
										<security:authorize access="hasRole('USER_GROUP_ADMIN')">
											<sf:form style="display: inline-block" action="${linkReportsEdit}${entry.id}/" method="get">
												<button class="dark-bg" type="submit"><div class="forward-raquo menu-link right"></div>Bearbeiten</button>
											</sf:form>
											<sf:form style="display: inline-block" action="${linkReportsDelete}${entry.id}/" method="post">
												<button class="dark-bg"><div class="forward-raquo menu-link right"></div>Löschen</button>
											</sf:form>
										</security:authorize>
										
									</div>
								</div>
							</div>
							<%-- reports --%>
						</li>
					</c:forEach>
				</ul>
				<%-- end Contentbox One-Col --%>
			
				<table class="pagination">
					<tr>
						<td class="pagination-previous">
							<c:if test="${reportPage.pageNumber > 1}">
								<a href="${linkForumPage}${reportPage.prevPage}/">vorherige</a>
							</c:if>
						</td>
						<td class="pagination-info">
							Seite <c:out value="${reportPage.pageNumber}"></c:out> von <c:out value="${reportPage.pagesAvailable}"></c:out>
						</td>
						<td class="pagination-next">
							<c:if test="${reportPage.pageNumber < reportPage.pagesAvailable}">
								<a href="${linkForumPage}${reportPage.nextPage}/">weitere</a>
							</c:if>
						</td>
					</tr>
				</table>
				
			</div>
			</div>
			</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
		<%-- javascript, das nach Laden ausgeführt werden soll --%>
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>