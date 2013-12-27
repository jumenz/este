<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Home"/>
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
        	<!-- sidebar -->
			<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="Forum"/>
				<jsp:param name="timer" value="include"/>
				<jsp:param name="abc" value="include"/>
				<jsp:param name="nav" value="linkname1"/>
				<jsp:param name="ref" value="link1"/>
				<jsp:param name="nav" value="linkname2"/>
				<jsp:param name="ref" value="link2"/>
				<jsp:param name="nav" value="linkname3"/>
				<jsp:param name="ref" value="link3"/>
			</jsp:include>
			
			
        
			<div id="..." class="content-list">
				<ul>
					<c:forEach var="entry" items="${forumModel.entries}" varStatus="status">		<!-- TODO anders befüllen -->
						<li class="one-col">
							<!-- reports -->
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="address-name" ><c:out value="${entry.topic }"></c:out></h2>
								<div id="submit-${status.index}xxx" class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-info clearfix light-bg">
										Beschreibung des Themas
										
									</div>
									<div class="box-body">
										<p>Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr! Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr!Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr!Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr! Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr! Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr!Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr!Zweiter Absatz mit ein wenig mehr Text und Informationen für alle. Und noch viel mehr!</p>
									</div>
									<!-- Contentbox Comments -->
									<div>
										<div  class="comment-content-box box-borders-top bg clearfix further-toggle-item">
											<h2 class="box-title link further-toggle" id="address-name" >Kommentare: X</h2>
											<div class="box-link down-raquo toggle-link further-toggle right">
											</div>
											<div class="further-toggle-content" style="display: none">
													<div class="box-body box-borders-bottom">
														<div class="comments">
															<div class="comment">
																<p class="comment-name">Name</p>
																<p class="comment-content">Ein Kommentar zu diesem Thema.</p>
																<div class="button-delete online-only"></div>
															</div>
															<div class="comment">
																<p class="comment-name">Name</p>
																<p class="comment-content">Ein Kommentar zu diesem Thema. Ein Kommentar zu diesem Thema.Ein Kommentar zu diesem Thema.Ein Kommentar zu diesem Thema.Ein Kommentar zu diesem Thema.Ein Kommentar zu diesem Thema.Ein Kommentar zu diesem Thema.</p>
																<div class="button-delete online-only"></div>
															</div>
														</div>
													</div>
												</div>
										</div>
									<div>
									<!-- end Comment Box -->
								</div>
							</div>
							<!-- reports -->
						</li>
						
						</c:forEach>
						
					</ul>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

