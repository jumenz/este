<%@include file="../includes/taglibs_variables.jspf" %>
<div class="header">
	<!-------------- banner -------------->
	<img class="banner" src="${dataPath}/images/img-header.jpg"/>
	<!-------------- main navigation ------->
	<ul class="nav">
		<li class="nav-wide">
			<a href="./about-us/">
				Über uns
			</a>
		</li>
		<li class="nav-wide">
			<a href="./reports/">
				Spielberichte
			</a>
			<ul class="submenue">
				<li class="online-only">
					<a href="neuer-bericht.php">verfassen</a>
				</li>
			</ul>
		</li>
		<li class="nav-wide">
			<a href="./galery/">
				Galerie
			</a>
		</li>
		<li class="nav-wide">
			<a>
				Links
			</a>
			<ul class="submenue">
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/tabelle/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Tabelle</a></li>
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/staffelspielplan/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Spielplan</a></li>
				<li><a target="_blank" href="http://ergebnisdienst.fussball.de/begegnungen/fbzl-staffel-west/bezirksebene-hamburg/frauen-bezirksliga/frauen/spieljahr1314/hamburg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03">Begegnungen</a></li>
			</ul>
		</li>
		<li class="offline-only nav-wide">
			<a href="login.php">
				<span class="nav-wide">Login</span>
				<img class="nav-reduced icon" src="../../data/icons/icon-login.png"/>
			</a>
		</li>
		<li class="online-only nav-wide">
			<a href="home.php">
				Home
			</a>
            <ul class="submenue">
                <!--<li><form name="add_list" action="../Controller/AddressesController.php" method="get" ><button class="submenu-link" type="submit" name="action" value="list">Adressbuch</button></form></li>-->
                <li><a href="adressbuch.php">Adressbuch</a></li>
                <li><a href="termine.php">Termine</a></li>
                <li><a href="forum.php">Forum</a></li>
                <li><a>Logout</a></li>
            </ul>
		</li>
		<!-- for smaller displays -->
		<li class="nav-reduced">
			<img src="../../data/icons/icon-menue.png"/>
			<ul class="submenue">
				<li><a href="ueber-uns.php">Über uns</a></li>
				<li><a href="bericht.php">Spielberichte</a></li>
				<li><a href="galerie.php">Galerie</a></li>
				<li><a href="...">Links</a></li>
				<li class="online-only"><a href="home.php">Home</a></li>
				<li class="online-only"><a href="#">Logout</a></li>
				<li class="offline-only">Login</li>
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

