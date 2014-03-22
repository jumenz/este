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
										<table>
											<tr>
												<td>
													<!-- Titeleingabe -->
													<sf:textarea 	path="topic"
																	id="topic"
																	rows="1"
																	cols="120"
																	placeholder="Titel"
													/><br>
													<!-- Fehlermeldung für den Titel -->
													<sf:errors path="topic" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<td>
													<!-- Titeleingabe -->
													<sf:textarea 	path="opponent"
																	id="opponent"
																	rows="1"
																	cols="120"
																	placeholder="Gegner"
													/><br>
													<!-- Fehlermeldung für den Titel -->
													<sf:errors path="topic" cssClass="error"/>
												</td>
											</tr>	
											<tr>
												<!-- Datumsangabe 
												<td>
													<sf:textarea 	path="date"
																	id="date"
																	rows="1" 
																	cols="30"
																	placeholder="Datum der Form: Sat Mar 22 19:53:56 CET 2014"
																	/><br>
													<sf:errors path="date" cssClass="error"/>
												</td> -->
											</tr>
											<tr>
												<!-- Punktestände -->
												<td>Halbzeit (Heim:Gast)
													<sf:input path="scoreFirstHalfHome" size="2" id="scoreHalftime"/> :
													<sf:input path="scoreFirstHalfGuest" size="2" id="scoreHalftimeGuest"/><br>
													<!-- Fehlermeldung -->
													<sf:errors path="scoreFirstHalfHome" cssClass="error"/><br>
													<sf:errors path="scoreFirstHalfGuest" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<td>Endstand (Heim:Gast)
													<sf:input path="scoreSecondHalfHome" size="2" id="finalScore"/> :
													<sf:input path="scoreSecondHalfGuest" size="2" id="scoreHalftimeGuest"/><br>
													<!-- Fehlermeldung -->
													<sf:errors path="scoreSecondHalfHome" cssClass="error"/><br>
													<sf:errors path="scoreSecondHalfGuest" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<!-- Heimspielangabe -->
												<td>
													<sf:checkbox path="homeMatch" label="Heimspiel"/><br>
													<!-- Fehlermeldung -->
													<sf:errors path="homeMatch" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<td>
													<!-- Text -->
													<sf:textarea 	path="text" 
																	id="text" 
																	placeholder="Tippe hier deinen Text"
																	rows="20"
																	cols="120"
													/><br>
													<!-- Fehlermeldung für den Text -->
													<sf:errors path="text" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<td><input name="commit" type="submit" value="Speichern"/></td>
											</tr>
										</table>
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

