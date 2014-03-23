<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Forum"/>
		<jsp:param name="description" value="Hier kannst du Spielberichte zu den Spielen der Frauen des Este 06/70 verfolgen."/>
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
				<jsp:param name="nav" value="Weitere Einträge"/>
				<jsp:param name="ref" value="${linkForumNext}"/>
				<jsp:param name="nav" value="vorherige Einträge"/>
				<jsp:param name="ref" value="${linkForumPrev}"/>
				<jsp:param name="nav" value="Eintrag verfassen"/>
				<jsp:param name="ref" value="${linkForumNewEntry}"/>
			</jsp:include>

			<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<ul>
					<c:forEach var="entry" items="${forumModel.entries}" varStatus="status">
						<li class="one-col">
							<!-- reports -->
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="address-name" ><c:out value="${entry.topic}"></c:out></h2>
								<div id="submit-${status.index}" class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-info clearfix light-bg">
										${entry.description}										
									</div>
									<div class="box-body">
										<p>${entry.text}</p>
									</div>
									<!-- Contentbox Comments -->
									<div>
										<!-- Kommentare für den Foreneintrag laden -->
										<c:set var="comments" value="${entry.comments}"/>
										<div  class="comment-content-box box-borders-top bg clearfix further-toggle-item">
											<!-- Liste auslesen -->
											<h2 class="box-title link further-toggle" id="address-name" >Kommentare: ${fn:length(comments)}</h2>
											<div class="box-link down-raquo toggle-link further-toggle right"></div>
											<div class="further-toggle-content" style="display: none">
												<div class="box-body box-borders-bottom">
													<div class="comments">
														<!-- bisherige Kommentare zum Foreneintrag -->
														<c:forEach var="comment" items="${comments}" varStatus="status">
															<div class="comment">
																<p class="comment-name">${comment.author}AUTHOR</p>
																<p class="comment-content">${comment.text}</p>
																<div class="button-delete online-only"></div>
															</div>
														</c:forEach>
														<!-- Formular für neuen Kommentar -->
														<div class="comment">
															<p class="comment-name">Neuen Kommentar verfassen</p>
															<p class="comment-content">
																<c:set var="newComment" value="${newComment}"/>
																<sf:form action="./neuer-kommentar/${entry.id}" method="POST" modelAttribute="newComment">
																	<!-- Neuer Kommentar -->
																	<sf:textarea 	path="text"
																					id="text"
																					rows="3"
																					cols="80"
																					placeholder="..."
																	/><br>
																	<!-- Fehlermeldung für den neuen Kommentar -->
																	<sf:errors path="text" cssClass="error"/><br>
																	<!-- Buttons -->
																	<input name="commit" type="submit" value="Speichern" />
																	<input name="reset" type="reset" value="Zurücksetzen"/>
																</sf:form>
															</p>
															<div class="button-delete online-only"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
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
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
		
		<!-- javascript, das nach Laden ausgeführt werden soll -->
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>

