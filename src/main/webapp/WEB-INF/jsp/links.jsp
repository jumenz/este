<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Links"/>
		<jsp:param name="description" value="Weiterführende Links zu wichtigen Fussballseiten."/>
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
			<div id="..." class="content-list">
				<%-- three col view --%>
				<ul>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Tabelle</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Hier findest du die aktuelle Tabellenplätze und Torverhältnisse der Bezirksklasse West.</p>
							</div>
							<a href="http://ergebnisdienst.fussball.de/tabelle/fbzl-staffel-west/…burg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03" target="_blank">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col first">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Spielplan</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Wirf hier einen genaueren Blick auf den Spielplan.</p>
							</div>
							<a href="http://ergebnisdienst.fussball.de/staffelspielplan/fbzl-staf…burg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03" target="_blank">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
					<li class="three-col">
						<div class="main-content-box box-borders bg clearfix">
							<h2 class="box-title">Begegnungen</h2>
							<div class="box-head">
								<img src="${dataPath}/images/demo.jpg" />
							</div>
							<div class="box-body">
								<p>Hier erfährst du genaueres über die Begegnungen.</p>
							</div>
							<a href="http://ergebnisdienst.fussball.de/begegnungen/fbzl-staffel-w…burg/-/staffel/01HHUTJVTS000000VV0AG812VU0P4H9C-G/mandant/03" target="_blank">
								<div class="forward-raquo content-link right"></div>
							</a>
						</div>
					</li>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

