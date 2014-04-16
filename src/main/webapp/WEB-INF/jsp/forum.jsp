<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Ellen Schwartau
 --%>
 <%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Forum"/>
		<jsp:param name="description" value="Hier kannst du Spielberichte zu den Spielen der Frauen des Este 06/70 verfolgen."/>
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
        	<%-- sidebar --%>
        	<%-- Admin-Sidebar --%>
        	<security:authorize access="hasRole('USER_GROUP_ADMIN')">
				<jsp:include page="./includes/sidebar.jsp">
					<jsp:param name="sidebarTitle" value="Forum"/>
					<jsp:param name="search" value="include" />
					<jsp:param name="searchLink" value="${linkForumSearch}"/>
					<jsp:param name="nav" value="Startseite"/>
					<jsp:param name="ref" value="${linkWelcome}"/>
					<jsp:param name="nav" value="Eintrag verfassen"/>
					<jsp:param name="ref" value="${linkForumNewEntry}"/>
				</jsp:include>
			</security:authorize>
			<%-- Sidebar No-Admin --%>
			<security:authorize access="hasRole('USER_GROUP_NO_ADMIN')">
			<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="Forum"/>
				<jsp:param name="nav" value="Startseite"/>
				<jsp:param name="ref" value="${linkWelcome}"/>
				<jsp:param name="search" value="include" />
			</jsp:include>
			</security:authorize>
			
			
			<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<ul>
					<c:forEach var="entry" items="${forumEntryPage.pageItems}" varStatus="status">
						<li class="one-col">
							<%-- reports --%>
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
										
										<%-- Bearbeiten und löschen, wenn ein Admin angemeldet ist --%>
										<security:authorize access="hasRole('USER_GROUP_ADMIN')">
											<sf:form style="display: inline-block" action="${linkForumEntryEdit}${entry.id}/" method="get">
												<button type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Bearbeiten</button>
											</sf:form>
											<sf:form style="display: inline-block" action="${linkForumEntryDelete}${entry.id}/" method="post">
												<button type="submit"  class="dark-bg"><div class="forward-raquo menu-link right"></div>Löschen</button>
											</sf:form>
										</security:authorize>
									</div>
									<%-- Contentbox Comments --%>
									<div>
										<%-- Kommentare für den Foreneintrag laden --%>
										<c:set var="comments" value="${entry.comments}"/>
										<div  class="comment-content-box box-borders-top bg clearfix further-toggle-item">
											<%-- Liste auslesen --%>
											<h2 class="box-title link further-toggle" id="address-name" >Kommentare: ${fn:length(comments)}</h2>
											<div class="box-link down-raquo toggle-link further-toggle right"></div>
											<div class="further-toggle-content" style="display: none">
												<div class="box-body box-borders-bottom">
													<div class="comments">
														<%-- bisherige Kommentare zum Foreneintrag --%>
														<c:forEach var="comment" items="${comments}" varStatus="status">
															<div class="comment">
																<p class="comment-name">${comment.author}</p>
																<p class="comment-content">${comment.text}</p>
																
																<%-- Bei eigenen Kommentaren löschen Button anzeigen --%>
																<security:authentication property="principal.username" var="author" scope="request"/>
																<c:if test="${author == comment.author}">
																	<form method="get" action="${linkForumDeleteComment}${comment.id}/">
																		<button class="button-delete"></button>
																	</form>
																</c:if>
															</div>
														</c:forEach>
														<%-- Formular für neuen Kommentar --%>
														<div class="comment">
															<p class="comment-name">Neuen Kommentar verfassen</p>
															<p class="comment-content">
																<c:set var="newComment" value="${newComment}"/>
																<sf:form action="${linkForumNewComment}${entry.id}/${author}/" method="POST" modelAttribute="newComment">
																	<%-- Neuer Kommentar --%>
																	<sf:textarea 	path="text"
																					id="text"
																					rows="3"
																					cols="80"
																					placeholder="..."
																					required="true"
																	/><br>
																	<%-- Fehlermeldung für den neuen Kommentar --%>
																	<sf:errors path="text" cssClass="error"/><br>
																	<%-- Buttons --%>
																	<button name="commit" type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Speichern</button>
																	<button name="commit" type="reset" class="dark-bg"><div class="forward-raquo menu-link right"></div>Abbrechen</button>
																</sf:form>
															</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- end Comment Box --%>
								</div>
							</div>
							<%-- Foreneinträge --%>
						</li>
						
						</c:forEach>
					</ul>
					<%-- Seitenanzeige --%>
					<table class="pagination">
						<tr>
							<td class="pagination-previous">
								<c:if test="${forumEntryPage.pageNumber > 1}">
									<a href="${linkForumPage}${forumEntryPage.prevPage}/">vorherige</a>
								</c:if>
							</td>
							<td class="pagination-info">
								Seite <c:out value="${forumEntryPage.pageNumber}"></c:out> von <c:out value="${forumEntryPage.pagesAvailable}"></c:out>
							</td>
							<td class="pagination-next">
								<c:if test="${forumEntryPage.pageNumber < forumEntryPage.pagesAvailable}">
									<a href="${linkForumPage}${forumEntryPage.nextPage}/">weitere</a>
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

