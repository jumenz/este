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
				<jsp:param name="nav" value="linkname1"/>
				<jsp:param name="ref" value="#" />
				<jsp:param name="nav" value="linkname2"/>
				<jsp:param name="ref" value="#" />
				<jsp:param name="nav" value="linkname3"/>
				<jsp:param name="ref" value="#" />
			</jsp:include>
        
			<div id="..." class="content-list">
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
													<th class="first">Erster Schlüßel:</th>
													<td class="last">Wert</td>
												</tr>
												<tr>
													<th class="first">Zweiter Schlüßel:</th>
													<td class="last">Wert</td>
												</tr>
												</tbody>
											</table>
										</div>
										<div class="left half-width">
											<table class="last">
												<tbody>
												<tr>
													<th class="first">Erster Schlüßel:</th>
													<td class="last">Wert</td>
												</tr>
												<tr>
													<th class="first">Zweiter Schlüßel:</th>
													<td class="last">Wert</td>
												</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="box-body">
										<p>${entry.text}</p>
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
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

