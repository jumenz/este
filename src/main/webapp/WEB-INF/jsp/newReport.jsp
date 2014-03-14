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
												<th><label for="topic">Titel:</label></th>
												<td>
													<sf:input path="topic" size="15" id="topic"/><br>
													<sf:errors path="topic" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<th><label for="opponent">Gegner:</label></th>
												<td>
													<sf:input path="opponent" size="15" id="opponent"/><br>
													<sf:errors path="opponent" cssClass="error"/>
												</td>
											</tr>	
											<tr>
												<th><label for="datetime">Datum:</label></th>
												<td>
													<sf:input path="dateTime" size="15" id="datetime"/><br>
													<sf:errors path="dateTime" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<th><label for="scoreHalftime">Halbzeit:</label></th>
												<td>
													<sf:input path="scores[0]" size="5" id="scoreHalftime"/>:<sf:input path="scores[1]" size="5" id="scoreHalftimeGuest"/><br>
													<sf:errors path="scores[0]" cssClass="error"/><br>
													<sf:errors path="scores[1]" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<th><label for="finalScore">Endstand:</label></th>
												<td>
													<sf:input path="scores[2]" size="5" id="finalScore"/>:<sf:input path="scores[3]" size="5" id="finalScoreGuest"/><br>
													<sf:errors path="scores[2]" cssClass="error"/><br>
													<sf:errors path="scores[3]" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<th><label for="text">Text:</label></th>
												<td>
													<sf:input path="text" size="100" id="text"/><br>
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

