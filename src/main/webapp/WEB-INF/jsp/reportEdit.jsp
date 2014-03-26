<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Spielberichte"/>
		<jsp:param name="description" value="Neuen Spielbericht verfassen"/>
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
			<div id="..." class="content-list">
				<ul>
					 <!--Contentbox One-Col -->
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Neuen Spielbericht anlegen</h2>
                             <div class="box-body">
                             	<!-- Formular zum anlegen eines neuen Spielberichts -->	
								<sf:form method="POST" modelAttribute="report">
									<fieldset>
											<!-- Titeleingabe -->
											<sf:textarea 	path="topic"
															id="topic"
															rows="1"
															cols="120"
															value="${report.topic}"
															class="full-width"
											/><br>
											<!-- Fehlermeldung für den Titel -->
											<sf:errors path="topic" cssClass="error"/>
											<!-- Titeleingabe -->
											<sf:textarea 	path="opponent"
															id="opponent"
															rows="1"
															cols="120"
															value="${report.opponent}"
															class="full-width"
											/><br>
											<!-- Fehlermeldung für den Titel -->
											<sf:errors path="topic" cssClass="error"/>
											<!-- Datumsangabe 
												<sf:textarea 	path="date"
																id="date"
																rows="1" 
																cols="30"
																placeholder="Datum der Form: Sat Mar 22 19:53:56 CET 2014"
																class="full-width"
																/><br>
												<sf:errors path="date" cssClass="error"/>
											-->
											<!-- Punktestände -->
											Halbzeit (Heim:Gast)
											<sf:input path="scoreFirstHalfHome" size="2" id="scoreHalftime" value="${report.scoreFirstHalfHome}"/> :
											<sf:input path="scoreFirstHalfGuest" size="2" id="scoreHalftimeGuest" value="${report.scoreFirstHalfGuest}"/><br>
											<!-- Fehlermeldung -->
											<sf:errors path="scoreFirstHalfHome" cssClass="error"/><br>
											<sf:errors path="scoreFirstHalfGuest" cssClass="error"/>
											Endstand (Heim:Gast)
											<sf:input path="scoreSecondHalfHome" size="2" id="finalScore" value="${report.scoreSecondHalfHome}"/> :
											<sf:input path="scoreSecondHalfGuest" size="2" id="scoreHalftimeGuest" value="${report.scoreSecondHalfGuest}"/><br>
											<!-- Fehlermeldung -->
											<sf:errors path="scoreSecondHalfHome" cssClass="error"/><br>
											<sf:errors path="scoreSecondHalfGuest" cssClass="error"/>
											<!-- Heimspielangabe -->
											<c:if test="${report.homeMatch}">
												<sf:checkbox path="homeMatch" label="Heimspiel" checked="checked"/><br>
											</c:if>
											<c:if test="${!report.homeMatch}">
												<sf:checkbox path="homeMatch" label="Heimspiel"/><br>
											</c:if>
											<!-- Fehlermeldung -->
											<sf:errors path="homeMatch" cssClass="error"/>
											<!-- Text -->
											<sf:textarea 	path="text" 
															id="text" 
															value="report.text"
															rows="20"
															cols="120"
															class="full-width"
											/><br>
											<!-- Fehlermeldung für den Text -->
											<sf:errors path="text" cssClass="error"/>
											<!-- Buttons -->
											<button name="commit" type="submit">Speichern</button>
											<button name="reset" type="reset">Zurücksetzen</button>
									</fieldset>
								</sf:form>
                             </div>
                         </div>
                     </li>
                 	 <!-- end Contentbox One-Col -->
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

