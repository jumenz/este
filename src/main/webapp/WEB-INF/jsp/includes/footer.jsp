<!-- footer -->
		<ul class="footer">
	<li> <!-- Login, bzw. Registrierung -->
		<form action="post" name="footer-login-register-form" action="${linkRegister}">
			<input class="buttom-invisible footer-space-bottom" type="submit" value="Login"><br>
			<span class="footer-info"><input class="input-with-default" type="text" name="login-name" data-default="Name" ></span><br>
			<span class="footer-info footer-space-bottom"><input type="password" name="login-name" data-default="Passwort"></span><br>
			<input class="buttom-invisible" type="submit" value="Registrieren">
		</form>
	</li>
	<li> <!-- Addresse -->
		<span class="footer-heading footer-space-bottom">Kontakt</span>
		<span class="footer-info">SV Este 06/70 e.V.</span>
		<span class="footer-info">Arp-Schnitger Stieg 37 c</span>
		<span class="footer-info">Tel. 745 80 47</span>
		<span class="footer-info footer-space-bottom">21129 Hamburg</span>
		<span class="footer-info"><a href="mailto:damen-este0670@web.de">damen-este0670@web.de</a></span>
	</li>	
	<li> <!-- Shortlinks -->
		<span class="footer-heading footer-space-bottom">N�tzliches</span>
		<span class="footer-info"><a href="${linkAboutUs}">�ber uns</a></span>
		<span class="footer-info"><a href="${linkReports}">Spielberichte</a></span>
		<span class="footer-info"><a href="${linkGalery}">Galerie</a></span>
		<span class="footer-info  footer-space-bottom"><a href="${linkAboutUs}#kontakt">weiterer Kontakt</a></span>
		<span class="footer-info"><a href="${linkImpressum}">Impressum</a></span>
	</li>
</ul>