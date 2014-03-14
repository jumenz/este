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
												<th><label for="topic">Thema:</label></th>
												<td>
													<sf:input path="topic" size="15" id="topic"/><br>
													<sf:errors path="topic" cssClass="error"/>
												</td>
											</tr>
											<tr>
												<th><label for="description">Kurzbeschreibung:</label></th>
												<td>
													<sf:input path="description" size="15" id="description"/><br>
													<sf:errors path="description" cssClass="error"/>
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
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

