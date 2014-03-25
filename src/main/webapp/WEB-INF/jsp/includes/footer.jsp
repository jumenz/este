<%@include file="./taglibs_variables.jspf" %>
<!-- footer -->
	<ul class="footer">
	<% 	Cookie cookies[] = request.getCookies();
		Cookie cookie = null;
		boolean loggedIn = false;
		if( cookies != null ){
	      for (int i = 0; i < cookies.length; i++){
	         cookie = cookies[i];
	         if((cookie.getName( )).compareTo("user") == 0 ){
	        	 loggedIn = true;
	         }
	      }
		}
		if(!loggedIn) { %>
	<li> <!-- Login, bzw. Registrierung -->
		<form method="post" name="footer-login-register-form" action="${linkLogin}">
			<input class="buttom-invisible footer-space-bottom" type="submit" value="Login"><br>
			<span class="footer-info"><input class="input-with-default" type="text" name="login-name" data-default="Name" value="Name"></span><br>
			<span class="footer-info footer-space-bottom"><input type="password" name="login-name" data-default="Passwort" value="Passwort"></span><br>
		</form>
		<form method="get" action="${linkRegister}">
			<input class="buttom-invisible" type="submit" value="Registrieren"/>
		</form>
	</li>
	<% } else { %>
	<li>
		<form method="get" action="${linkLogout}">
			<input class="buttom-invisible" type="submit" value="Logout"/>
		</form>
	</li>
	<% } %>
	<li> <!-- Addresse -->
		<span class="footer-heading footer-space-bottom">Kontakt</span>
		<span class="footer-info">SV Este 06/70 e.V.</span>
		<span class="footer-info">Arp-Schnitger Stieg 37 c</span>
		<span class="footer-info">Tel. 745 80 47</span>
		<span class="footer-info footer-space-bottom">21129 Hamburg</span>
		<span class="footer-info"><a href="mailto:damen-este0670@web.de">damen-este0670@web.de</a></span>
	</li>	
	<li> <!-- Shortlinks -->
		<span class="footer-heading footer-space-bottom">Nützliches</span>
		<span class="footer-info"><a href="${linkAboutUs}">Über uns</a></span>
		<span class="footer-info"><a href="${linkReports}">Spielberichte</a></span>
		<span class="footer-info"><a href="${linkGalery}">Galerie</a></span>
		<span class="footer-info  footer-space-bottom"><a href="${linkAboutUs}#kontakt">weiterer Kontakt</a></span>
		<span class="footer-info"><a href="${linkImpressum}">Impressum</a></span>
	</li>
</ul>