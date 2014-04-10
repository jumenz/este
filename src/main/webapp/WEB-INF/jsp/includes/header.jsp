<%@include file="../includes/taglibs_variables.jspf" %>
<div class="header">
	<%-------------- banner --------------%>
	<img class="banner" src="${dataPath}/images/img-header.jpg" alt="banner-este-damen"/>
	<%-------------- main navigation -------%>
	<ul class="nav">
		<li class="nav-wide">
			<a href="${linkAboutUs}">
				Über uns
			</a>
		</li>
		<li class="nav-wide">
			<a href="${linkReports}">
				Spielberichte
			</a>
		</li>
		<li class="nav-wide">
			<a href="${linkGalery}">
				Galerie
			</a>
			<ul class="submenue">
				<security:authorize access="isAuthenticated() and hasRole('USER_GROUP_ADMIN')">
					<li><a href="${linkGaleryUpload}">Bilder hochladen</a></li>
				</security:authorize>
			</ul>
		</li>
		<li class="nav-wide">
			<a href="${linkLinks}">
				Links
			</a>
			<ul class="submenue">
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/tabelle/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Tabelle</a></li>
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/staffelspielplan/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Spielplan</a></li>
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/begegnungen/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Begegnungen</a></li>
			</ul>
		</li>
		<security:authorize access="not isAuthenticated()">
			<li class="nav-wide">
				<a href="${linkLogin}">
					<span class="nav-wide">Login</span>
				</a>
			</li>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<li class="nav-wide">
				<a href="${linkHome}">
					Home
				</a>
	            <ul class="submenue">
	                <%--<li><form name="add_list" action="../Controller/AddressesController.php" method="get" ><button class="submenu-link" type="submit" name="action" value="list">Adressbuch</button></form></li>--%>
	                <li><a href="${linkAddresses}">Adressbuch</a></li>
	                <li><a href="#">Termine</a></li>
	                <li><a href="${linkForum}">Forum</a></li>
	                <security:authorize access="isAuthenticated() and hasRole('USER_GROUP_ADMIN')">
						<li><a href="${linkRegister}">User bearbeiten</a></li>
					</security:authorize>
	                <li><a href="${linkLogout}">Logout</a></li>
	            </ul>
			</li>
		</security:authorize>
		<%-- for smaller displays --%>
		<li class="nav-reduced">
			<img src="${dataPath}/icons/icon-menue.png"/>
			<ul class="submenue">
				<li><a href="${linkAboutUs}">Über uns</a></li>
				<li><a href="${linkReports}">Spielberichte</a></li>
				<li><a href="${linkLinks}">Links</a></li>
				<li><a href="${linkGalery}">Galerie</a></li>
				<security:authorize access="isAuthenticated() and hasRole('USER_GROUP_ADMIN')">
					<li><a href="${linkRegister}">User bearbeiten</a></li>
					<li><a href="${linkGaleryUpload}">Bilder hochladen</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="${linkHome}">Home</a></li>
					<li><a href="${linkLogout}">Logout</a></li>
				</security:authorize>
				<security:authorize access="not isAuthenticated()">
					<li><a href="${linkLogin}">Login</a></li>
				</security:authorize>
			</ul>
		</li>
	</ul>
	
	<%----------- Breadcrub -----------------%>
	<div class="breadcrumb">
		<%-- Begrüßung für eingeloggte User --%>
		<security:authorize access="isAuthenticated()">
			Hallo <security:authentication property="principal.username"/>!
		</security:authorize>
	</div>
</div>

