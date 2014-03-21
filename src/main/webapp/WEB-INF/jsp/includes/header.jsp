<%@include file="../includes/taglibs_variables.jspf" %>
<div class="header">
	<!-------------- banner -------------->
	<img class="banner" src="${dataPath}/images/img-header.jpg"/>
	<!-------------- main navigation ------->
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
			<ul class="submenue">
				<li class="online-only">
					<a href="#">verfassen</a> 
				</li>
			</ul>
		</li>
		<li class="nav-wide">
			<a href="${linkGalery}">
				Galerie
			</a>
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
		<li class="offline-only nav-wide">
			<a href="${linkLogin}">
				<span class="nav-wide">Login</span>
				<img class="nav-reduced icon" src="../../data/icons/icon-login.png"/>
			</a>
		</li>
		<li class="online-only nav-wide">
			<a href="${linkHome}">
				Home
			</a>
            <ul class="submenue">
                <!--<li><form name="add_list" action="../Controller/AddressesController.php" method="get" ><button class="submenu-link" type="submit" name="action" value="list">Adressbuch</button></form></li>-->
                <li><a href="">Adressbuch</a></li>
                <li><a href="#">Termine</a></li>
                <li><a href="${linkForum}">Forum</a></li>
                <li><a>Logout</a></li>
            </ul>
		</li>
		<!-- for smaller displays -->
		<li class="nav-reduced">
			<img src="../../data/icons/icon-menue.png"/>
			<ul class="submenue">
				<li><a href="${linkAboutUs}">Über uns</a></li>
				<li><a href="${linkReports}">Spielberichte</a></li>
				<li><a href="${linkGalery}">Galerie</a></li>
				<li><a href="${linkLinks}">Links</a></li>
				<li class="online-only"><a href="${linkHome}">Home</a></li>
				<li class="online-only"><a href="#">Logout</a></li>
				<li class="offline-only"><a href="${linkLogin}">Login</a></li>
			</ul>
		</li>
	</ul>
	
	<!----------- Breadcrub ----------------->
	<div class="breadcrumb">
		<span class="breadcrumb--step"><a>Pfad1</a> - </span>
		<span class="breadcrumb--step"><a>Pfad2</a> - </span>
		<span class="breadcrumb--current">Hier</span>
	</div>
</div>

