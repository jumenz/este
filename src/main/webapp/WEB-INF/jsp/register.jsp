<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Registrieren"/>
		<jsp:param name="description" value="Startseite der Frauen des Este 06/70"/>
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
					<%-- Formular zum Registrieren --%>	
                     <security:authorize access="not isAuthenticated()">
	                     <li class="one-col">
	                         <div class="main-content-box box-borders bg clearfix">
	                             <h2 class="box-title">Registrieren</h2>
	                             <div class="box-body">
									<sf:form action="${linkRegisterUser}" method="POST" modelAttribute="newUser">
										<fieldset>
											<%-- Username --%>
											<sf:input 	path="username"
														value="${newUser.username}"
														placeholder="Username"
														class="full-width"
											/><br>
											<%-- Fehlermeldung für den Username --%>
											<sf:errors path="username" cssClass="error"/><br>
											<%-- E-Mail Adresse --%>
											<sf:input 	path="email"
														value="${newUser.email}"
														placeholder="E-Mail Adresse"
														class="full-width"
											/><br>
											<%-- Fehlermeldung für die E-Mail Adresse --%>
											<sf:errors path="email" cssClass="error"/><br>
											<%-- Passwort --%>
											<sf:input	path="password" 
														type="password"
														value="${newUser.password}"
														placeholder="Passwort"
														class="full-width"
											/><br><br>
											<sf:input	path="passwordCompare"
														type="password"
														value="${newUser.passwordCompare}"
														placeholder="Passwort"
														class="full-width"
											/><br>
											<%-- Fehlermeldung für das Passwort --%>
											<sf:errors path="password" cssClass="error"/><br>
											<%-- Buttons --%>
											<button name="commit" type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Registrieren</button>
											<button name="reset" type="reset" class="dark-bg"><div class="forward-raquo menu-link right"></div>Abbrechen</button>
										</fieldset>
									</sf:form>
	                             </div>
	                         </div>
	                     </li>
                     </security:authorize>
                     
                     <security:authorize access="isAuthenticated()">
                     	<p>
                     		Du bist bereits registriert.
                     	</p>
                     </security:authorize>
                     
                     <security:authorize access="hasRole('USER_GROUP_ADMIN')">
	                     <%-- Forumular zum hinzufügen von zugelassenen EMail Adressen --%>
	                     <li class="one-col">
	                         <div class="main-content-box box-borders bg clearfix">
	                             <h2 class="box-title">Neue Email zulassen</h2>
	                             <div class="box-body">
									<sf:form action="${linkRegisterNewPermission}" method="POST" modelAttribute="newPermission">
										<fieldset>
											<%-- E-Mail Adresse --%>
											<sf:input 	path="email"
														placeholder="E-Mail Adresse"
														value="E-Mail Adresse"
														class="full-width"
											/><br>
											<%-- Admin Status --%>
											<sf:checkbox path="adminStatus"/>User soll Admin Status erhalten<br>
											<%-- Fehlermeldung für die E-Mail Adresse --%>
											<sf:errors path="email" cssClass="error"/><br>
											<%-- Buttons --%>
											<button name="commit" type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Zulassen</button>
											<button name="reset" type="reset" class="dark-bg"><div class="forward-raquo menu-link right"></div>Abbrechen</button>
										</fieldset>
									</sf:form>
	                             </div>
	                         </div>
	                     </li>
	                 
                     
	                     <%-- Forumular zum Bearbeiten bestehender Zulassungen --%>
	                     <li class="one-col">
	                         <div class="main-content-box box-borders bg clearfix">
	                             <h2 class="box-title">Bisher zugelassene EMails</h2>
	                             <div class="box-body">
									<c:forEach var="permission" items="${allPermissions}" varStatus="status">
										<sf:form style="display: inline-block" action="${linkRegister}loeschen-${permission.id}/">
											<button name="commit" type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Löschen</button>
										</sf:form>
										<sf:form style="display: inline-block" action="${linkRegister}status-${permission.id}/" method="get">
											<button name="commit" type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Status ändern</button>
										</sf:form>
										${permission.email}     
										Status: 
										<c:if test="${permission.adminStatus}"> Admin</c:if>
										<c:if test="${!permission.adminStatus}"> kein Admin</c:if>
										<br>
									</c:forEach>
	                             </div>
	                         </div>
	                     </li>
	                 </security:authorize>
                 	<%-- end Contentbox One-Col --%>
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

