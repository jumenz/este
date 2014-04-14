<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Willkommen"/>
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
			<div id="welcome" class="content-list">
				<%-- three col view --%>
				<ul>
				
					<%-- Über uns --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Über Uns</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-aboutus.jpg" alt="ueber-uns-este"/>
							</div>
							<div class="box-body">
								<p>Erfahre mehr über Este 06/70.</p>
								<p>Hier findest du Informationen zum Verein, der Mannschaft, den Trainern und den Trainingszeiten.</p>
							</div>
							<a href="${linkAboutUs}">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					
					<%-- Bildergalerie --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Galerie</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-galery.jpg" alt="este-damen-bildergalerie"/>
							</div>
							<div class="box-body">
								<p>Weitere Impressionen.</p>
								<p>Erlebe unsere Spielerinnen in Aktion und durchstöbere unsere Galerie!</p>
							</div>
							<a href="${linkGalery}">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					
					<%-- Kontakt --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Kontakt</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-contact.jpg" alt="este-damen-kontakt"/>
							</div>
							<div class="box-body">
								<p>Du hast noch Fragen oder Anliegen?</p>
								<p>Hier kannst du uns erreichen.</p>
							</div>
							<a href="${linkAboutUs}#kontakt">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					
					<%-- Links --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Links</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-links.jpg" alt="este-damen-links"/>
							</div>
							<div class="box-body">
								<p>Weitere Informationen findest du hier!</p>
								<p>Wirf einen Blick auf die aktuelle Tabelle oder den Staffelspielplan.</p>
							</div>
							<a href="${linkLinks}">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					
					<%-- Spielberichte --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Spielberichte</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-reports.jpg" alt="este-damen-spielberichte"/>
							</div>
							<div class="box-body">
								<p>Texte zu den vergangenen Spielen.</p>
								<p>Lies hier den Bericht zum letzten Spiel.</p>
							</div>
							<a href="${linkReports}">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					
					<%-- Registrierung --%>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Registrierung</h2>
							<div class="box-head">
								<img src="${dataPath}/images/img-register.jpg" alt="este-damen-registrierung"/>
							</div>
							<div class="box-body">
								<p>Melde dich hier an.</p>
								<p>Diese Option ist den Spielerinnen und Trainern des Este 06/70 vorbehalten.</p>
							</div>
							<a href="${linkRegister}">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
				</ul>
				<%-- end three col view --%>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
		
	</body>
</html>

