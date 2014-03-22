<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Forum"/>
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
       
			<div id="..." class="content-list">
				<ul>
					<!--Contentbox One-Col -->
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Neuen Foreneintrag anlegen</h2>
                             <div class="box-body">
                             	<!-- Formular zum anlegen eines neuen Spielberichts -->	
								<sf:form method="POST" modelAttribute="forumEntry">
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
													<!-- Kurzbeschreibung -->
													<sf:textarea 	path="description" 
																	id="description"
																	rows="5"
																	cols="120"
																	placeholder="Kurzbeschreibung"
													/><br>
													<!-- Fehlermeldung für die Kurzbeschreibung -->
													<sf:errors path="description" cssClass="error"/>
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
												<!-- Buttons -->
												<td>
													<input name="commit" type="submit" value="Speichern"/>
													<input name="reset" type="reset" value="Zurücksetzen"/>
												</td>
											</tr>
										</table>
									</fieldset>
								</sf:form>
                             </div>
                         </div>
                     </li>
                 	<!-- end Contentbox One-Col -->
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

