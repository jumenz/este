<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Home"/>
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
				<!-- three col view -->
				<ul>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Über Uns</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Erfahre mehr über Este 06/70.</p>
								<p>Hier findest du Informationen zum Verein, der Mannschaft, den Trainern und den Trainingszeiten.</p>
							</div>
							<a href="./ueber-uns.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Spielberichte</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Texte zu den vergangenen Spielen.</p>
								<p>Lies hier den Bericht zum letzten Spiel.</p>
							</div>
							<a href="./termine.jsp">
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
								<p>Weitere Informationen findest du hier!</p>
								<p>Wirf einen Blick auf die aktuelle Tabelle oder den Staffelspielplan.</p>
							</div>
							<a href="./links.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Galerie</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Weitere Impressionen.</p>
								<p>Erlebe unsere Spielerinnen in Aktion und durchstöbere unsere Galerie!</p>
							</div>
							<a href="./dokumente.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Kontakt</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />s
							</div>
							<div class="box-body">
								<p>Du hast noch Fragen oder Anliegen?</p>
								<p>Hier kannst du uns erreichen.</p>
							</div>
							<a href="./ueber-uns.jsp">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Registrierung</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Melde dich hier an.</p>
								<p>Diese Option ist den Spielerinnen und Trainern des Este 06/70 vorbehalten.</p>
							</div>
							<a href="./berichte.jsp">
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
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

