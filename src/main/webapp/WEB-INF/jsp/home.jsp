<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Home"/>
		<jsp:param name="description" value="Startseite der Frauen des Este 06/70"/>
	</jsp:include>
	
	<body>		
		<!-- include head with title and description of this page -->
		<jsp:include page="./includes/header.jsp"/>
		<!-- content der Seite -->
        <div class="main-container">
        <!-- Content -->
        <div class="container">
        <div class="main">
        <div class="main-inner">      
			<div id="..." class="content-list">
				<!-- three col view -->
				<ul>
					<li class="three-col ">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Adressbuch</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Adressen aller Spielerinnen und Trainer.</p>
								<p>Finde hier die Übersicht über alle Kontaktdaten.</p>
							</div>
							<a href="./adressbuch.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Terminplaner</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Terminplaner der Mannschaft.</p>
								<p>Hier kannst du aktuelle Termine einsehen und Angaben zu deiner Teilnahme vornehmen.</p>
							</div>
							<a href="./termine.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Forum</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Hier geht es zum Forum.</p>
								<p>Es dient als Austauschplattform über aktuelle Themen.</p>
							</div>
							<a href="./forum.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col ">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Dokumente</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Download wichtiger Dateien.</p>
								<p>Hier findest die Übersicht der Mannschaftskasse und Ähnliches.</p>
							</div>
							<a href="./dokumente.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col ">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Spielberichte</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Texte zu den vergangenen Spielen.</p>
								<p>Lies hier den Bericht zum letzten Spiel.</p>
							</div>
							<a href="./berichte.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Links</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Shortcuts zu den wichtigsten, für alle sichtbaren Seiten.</p>
							</div>
							<a href="./willkommen.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
				</ul>
				<!-- end three col view -->
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

