<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Login"/>
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
					
					<security:authorize access="not isAuthenticated()">
						<!--Contentbox One-Col -->
						<!-- Formular zum Registrieren -->	
	                     <li class="one-col">
	                         <div class="main-content-box box-borders bg clearfix">
	                             <h2 class="box-title">Login</h2>
	                             <div class="box-body">
									<sf:form action="${linkLogin}" method="POST" modelAttribute="loginUser">
										<fieldset>
											<!-- Username -->
											<sf:input 	path="username"
														placeholder="Username"
														value="${loginUser.username}"
														class="full-width"
											/><br>
											<sf:errors path="username" cssClass="error"/><br>
											<!-- Passwort -->
											<sf:input	path="password" 
														type="password"
														placeholder="Passwort"
														value="${loginUser.password}"
														class="full-width"
											/><br>
											<!-- Fehlermeldung für den Login -->
											<sf:errors path="password" cssClass="error"/><br>
											<!-- Buttons -->
											<!-- <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/> Eingeloggt bleiben<br> -->
											<button name="commit" type="submit">Anmelden</button>
											<button name="reset" type="reset">Abbrechen</button>
										</fieldset>
									</sf:form>
	                             </div>
	                         </div>
	                     </li>
	
					</ul>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<p>Du bist bereits angemeldet.</p>
				</security:authorize>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>
