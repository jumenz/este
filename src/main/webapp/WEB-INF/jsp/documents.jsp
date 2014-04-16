<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Julia Menzel
 --%>
 <%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Dokumente"/>
		<jsp:param name="description" value="Neuen Spielbericht verfassen"/>
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
			<div id="documents" class="content-list">
				<ul>
                    <li class="one-col">
                    	<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Dokumente</h2>
							<div class="box-body">
								<%-- Liste vorhandener Dokumente --%>
                             	<ul class="document-list">
                             		<c:set var="documentNames" value="${documentNames}"/>
									<c:forEach var="documentPath" items="${documentPaths}" varStatus="status">
											<li class="one-col">
												<a href="${documentPath}">${documentNames.get(status.index)}</a>
											</li>
									</c:forEach>
								</ul>
							</div>
						</div>
 					</li>
					<li class="one-col">
     					<div class="main-content-box box-borders-top bg clearfix">
         					<h2 class="box-title link" >
	         					<a href="${linkDocumentsUploadForm}">Dokumente hochladen</a>
							</h2>
							<a class="right box-link" href="${linkDocumentsUploadForm}">
		                     	<span id="submit-all" class="forward-raquo menu-link right"></span>
							</a>
					    </div>
					</li>
				</ul>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

