<%@include file="./taglibs_variables.jspf" %>
<%-- footer --%>
	<ul class="footer">
	
	<%-- Nur für ausgeloggte User --%>
	<security:authorize access="not isAuthenticated()">
		<%-- Login, bzw. Registrierung --%>
		<li> 
			<form method="get" name="footer-login-register-form" action="${linkLogin}">
				<input class="buttom-invisible footer-space-bottom" type="submit" value="Login"><br>
				<%--  <span class="footer-info">
					<input type="text" name="login-name" placeholder="Username">
				</span><br>
				<span class="footer-info footer-space-bottom">
				<input type="password" name="login-name" placeholder="Passwort"></span><br>--%>
			</form>
			<form method="get" action="${linkRegister}">
				<input class="buttom-invisible" type="submit" value="Registrieren"/>
			</form>
		</li>
	</security:authorize>
	
	<%-- Nur für eingeloggte User --%>
	<security:authorize access="isAuthenticated()">
		<li>
			<%--  <form method="get" action="${linkLogout}">
				<input class="buttom-invisible" type="submit" value="Logout"/>
			</form>  --%>
 			<img class="footer-logo" src="${dataPath}/images/logo-este.png">
		</li>
	</security:authorize>
	
	<%-- Addresse --%>
	<li> 
		<span class="footer-heading footer-space-bottom">Kontakt</span>
		<span class="footer-info">SV Este 06/70 e.V.</span>
		<span class="footer-info">Arp-Schnitger Stieg 37 c</span>
		<span class="footer-info">Tel. 745 80 47</span>
		<span class="footer-info footer-space-bottom">21129 Hamburg</span>
		<span class="footer-info"><a href="mailto:damen-este0670@web.de">damen-este0670@web.de</a></span>
	</li>
	<%-- Shortlinks --%>	
	<li> 
		<span class="footer-heading footer-space-bottom">Nützliches</span>
		<span class="footer-info"><a href="${linkAboutUs}">Über uns</a></span>
		<span class="footer-info"><a href="${linkReports}">Spielberichte</a></span>
		<span class="footer-info"><a href="${linkGalery}">Galerie</a></span>
		<span class="footer-info  footer-space-bottom"><a href="${linkAboutUs}#kontakt">weiterer Kontakt</a></span>
		<span class="footer-info"><a href="${linkImpressum}">Impressum</a></span>
	</li>
</ul>