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
		<jsp:param name="title" value="Spielberichte"/>
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
			<div id="..." class="content-list">
				<ul>
					 <%--Contentbox One-Col --%>
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Neuen Spielbericht anlegen</h2>
                             <div class="box-body">
                             	<%-- Formular zum anlegen eines neuen Spielberichts --%>	
								<sf:form method="POST" modelAttribute="report">
									<fieldset>
											<%-- Titeleingabe --%>
											<sf:textarea 	path="topic"
															rows="1"
															cols="120"
															placeholder="Titel"
															value="${report.topic}"
															class="full-width"
															required="true"
											/><br>
											<%-- Fehlermeldung für den Titel --%>
											<sf:errors path="topic" cssClass="error"/>
											<%-- Titeleingabe --%>
											<sf:textarea 	path="opponent"
															rows="1"
															cols="120"
															placeholder="Name des Gegners"
															value="${report.opponent}"
															class="full-width"
															required="true"
											/><br>
											<%-- Fehlermeldung für den Titel --%>
											<sf:errors path="topic" cssClass="error"/><br>
											<%-- Punktestände --%>
											Halbzeit (Heim:Gast)
											<sf:input 	path="scoreFirstHalfHome" 
														type="number"
														min="0"
														placeholder="0" 
														value="${report.scoreFirstHalfHome}"
														required="true"
														/> :
											<sf:input 	path="scoreFirstHalfGuest" 
														type="number"
														min="0"
														placeholder="0"
														value="${report.scoreFirstHalfGuest}"
														required="true"
														/><br>
											<br>Endstand (Heim:Gast)
											<sf:input 	path="scoreSecondHalfHome" 
														type="number"
														min="0"
														placholder="0"
														value="${report.scoreSecondHalfHome}"
														required="true"
														/> :
											<sf:input 	path="scoreSecondHalfGuest" 
														type="number"
														min="0"
														placeholder="0" 
														value="${report.scoreSecondHalfGuest}"
														required="true"
														/><br>
											<%-- Fehlermeldung --%>
											<sf:errors path="score*" cssClass="error"/><br>
											<%-- Heimspielangabe --%>
											<c:if test="${report.homeMatch}">
												<sf:checkbox path="homeMatch" label="Heimspiel" checked="checked"/><br>
											</c:if>
											<c:if test="${!report.homeMatch}">
												<sf:checkbox path="homeMatch" label="Heimspiel"/><br>
											</c:if>
											<%-- Fehlermeldung --%>
											<sf:errors path="homeMatch" cssClass="error"/><br>
											<%-- Text --%>
											<sf:textarea 	path="text" 
															placeholder="Tippe hier deinen Text ..."
															value="report.text"
															rows="20"
															cols="120"
															class="full-width"
															required="true"
											/><br>
											<%-- Fehlermeldung für den Text --%>
											<sf:errors path="text" cssClass="error"/><br>
											<%-- Buttons --%>
											<button class="dark-bg" name="commit" type="submit"><div class="forward-raquo menu-link right"></div>Speichern</button>
											<button class="dark-bg" name="reset" type="reset"><div class="forward-raquo menu-link right"></div>Zurücksetzen</button>
									</fieldset>
								</sf:form>
                             </div>
                         </div>
                     </li>
                 	 <%-- end Contentbox One-Col --%>
				</ul>
				
				<%-- end Contentbox One-Col --%>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

