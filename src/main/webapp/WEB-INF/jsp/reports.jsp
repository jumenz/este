<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Spielberichte"/>
		<jsp:param name="description" value="Startseite der Frauen des Este 06/70"/>
	</jsp:include>
		
	<body>
		<!-- header -->
		<jsp:include page="./includes/header.jsp"/>

		<!-- content -->
        <div class="main-container">
        <!-- Content -->
        <div class="container">
        <div class="main">
        <div class="main-inner">
        	<!-- Sidebar -->
        	<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="Spielberichte"/>
				<jsp:param name="abc" value="include" />
				<jsp:param name="timer" value="include"/>
				<jsp:param name="nav" value="Weitere"/>
				<jsp:param name="ref" value="${linkReportsNext}" />
				<jsp:param name="nav" value="Vorherige"/>
				<jsp:param name="ref" value="${linkReportsPrev}" />
				<jsp:param name="nav" value="Bericht verfassen"/>
				<jsp:param name="ref" value="${linkReportsNew}" />
			</jsp:include>
       
			<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<ul>
					<c:forEach var="entry" items="${reportModel.entries}" varStatus="status">
						<li class="one-col">
							<!-- reports -->
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="address-name" >${entry.topic}</h2>
								<div id="submit-${status.index}" class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
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
										<p>${entry.text}</p>
										<!-- TODO nur wenn Admin -->
										<sf:form style="display: inline-block" action="${linkReportsEdit}${entry.id}/" method="get">
											<button type="submit">Bearbeiten</button>
										</sf:form>
										<sf:form style="display: inline-block" action="${linkReportsDelete}${entry.id}/" method="post">
											<button type="submit">Löschen</button>
										</sf:form>
									</div>
								</div>
							</div>
							<!-- reports -->
						</li>
					</c:forEach>
				</ul>
				<!-- end Contentbox One-Col -->
			</div>
			</div>
			</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
		<!-- javascript, das nach Laden ausgeführt werden soll -->
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>