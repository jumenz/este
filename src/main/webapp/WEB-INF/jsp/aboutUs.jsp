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
        	<!-- sidebar -->
			<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="Über uns"/>
				<jsp:param name="timer" value="false"/>
				<jsp:param name="abc" value="false"/>
				<jsp:param name="nav" value="Der Verein"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#verein" />
				<jsp:param name="nav" value="Die Mannschaft"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#mannschaft" />
				<jsp:param name="nav" value="Die Trainer"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#trainer" />
				<jsp:param name="nav" value="Das Training"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#training" />
				<jsp:param name="nav" value="Anfahrt"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#anfahrt" />
				<jsp:param name="nav" value="Kontakt"/>
				<jsp:param name="ref" value="./ueber-uns.jsp#kontakt" />
			</jsp:include>
        
			<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<ul>
					<!-- Der Verein -->
					<li class="one-col">
						<div id="verein" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Der Verein</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content" style="display: none">
								<div class="box-body">
									<p>
									<img class="about-us-img-logo" src="${dataPath}/logo.jpg">
									Der SV Este 06/70 ist ein hamburger Verein, der sowohl im Fussball, Tennis und Tischtennis, als auch 
									Fitness Volleyball und Turnen aktiv ist.<br><br>
									Erfahre näheres über den SV Este 06/70
									auf der <a class="show-link"  href="http://www.este0670.de">Vereins-Website</a>,<br> 
									oder verfolge die aktuellen News auf der 
									<a class="show-link" href="https://www.facebook.com/pages/SV-Este-0670/112846398725953">Facebook-Seite des Vereins</a>
									.<br>
									</p>
								</div>
							</div>
						</div>
					</li>
					<!-- Die Mannschaft -->
					<li class="one-col">
						<div id="mannschaft" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Die Mannschaft</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content" style="display: none">
								<div class="box-body">
									<p>Nach der Neugründung der Fußball-Frauenabteilung im SV Este 06/70 zur Saison 2009/10, 
									in der wir in der 7er-Staffel gestartet waren, legten wir einen regelrechten Durchmarsch 
									bis in die Bezirksliga hin, der seinen sportlichen Höhepunkt in unserer Aufstiegssaison 
									2010/11 fand. Als weiterer Höhepunkt ist das Herzschlagfinale der vergangenen Saison 
									auszumachen, in der wir erst am allerletzten Spieltag den Nichtabstieg perfekt machen 
									konnten. Mit der Saison 2013/14 starten wir nun folglich das dritte Jahr in Serie in die 
									Bezirksliga West und unser Saisonziel ist mit dem erneuten Nichtabstieg klar definiert.
									</p> 
									<p>Bedingt durch die geographische Isolation fiel es uns in den letzen Jahren traditionell 
									schwierig, einen Zahlenmäßig gut gefüllten Kader auf die Beine zu stellen, weshalb wir 
									Punktspiele teilweise nicht mit 11 Spielerinnen bestreiten konnten. Doch nun hoffen wir, 
									dass sich dieses Problem erledigt hat, denn zur aktuellen Saison bekamen wir einen ganzen 
									Schwung neue Spielerinnen, als sich die weibliche B-Jugend des TuS Finkenwerder geschlossen 
									zu einem Wechsel in unser Team entschlossen hat.
									</p> 
									<p>Bei uns wird vor allem das Miteinander groß geschrieben. Neben Mannschaftsabenden und 
									gemeinsamen Geburtstags-, Saisonabschluss- oder Weihnachtsfeiern steht alljährlich um den 
									Jahreswechsel herum unsere Dänemark-Tour auf dem Plan, auf die sich Spielerinnen wie Trainer 
									gleichermaßen freuen. Und auch sonst sind wir für gemeinsame Aktionen immer gerne zu 
									begeistern!</p> 
									<p>Für die Zukunft erhofft sich das Trainerteam, einen Platz im oberen Drittel der Liga zu 
									festigen, neue Spielerinnen nahtlos in den bestehenden Kader einzufügen sowie die eigenen 
									fußballerischen Ideen weiter auf dem Platz umgesetzt sehen zu können.
									</p>
									<img class="about-us-img-team" src="${dataPath}/galery/picture24.jpg">
								</div>
							</div>
						</div>
					</li>
					<!-- Trainer -->
					<li class="one-col">
						<div id="trainer" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Die Trainer</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content" style="display: none">
								<div class="box-body">
									<div class="profile">
										<h3>Mathias Schwarzer</h3><br>
										<div class="profile-description">
											<img class="about-us-img-trainer" src="${dataPath}/images/trainer-m.jpg" />
											<p>" - Beschreibung - "</p>
										</div>
									</div>
									<div class="profile">
										<h3>Simon Elmers</h3><br>
										<div class="profile-description">
											<img class="about-us-img-trainer" src="${dataPath}/images/trainer-s.jpg" />
											<p>"Ich bin selbst noch als Torwart aktiv im Hamburger Amateurfußball unterwegs, 
											weshalb ich derzeit eine eurer Trainingseinheiten und leider auch das eine oder 
											andere Spiel verpasse.
											</p>
											<p>Seit 2005/06 trainiere ich Fußball-Mannschaften, 
											angefangen bei einer D- und C-Jugend, bevor ich 2008/09 ein Jahr Pause vom Training 
											geben einlegte, um Zwischenprüfung und Trainerschein abzuleisten.</p>
											<p>Als Mathias zum Ende eben dieser Saison mit der Idee, eine Frauenmannschaft im 
											SV Este 06/70 zu gründen, bei mir anfragte, war ich sofort begeistert und habe 
											zugestimmt.
											</p>
											<p>Seit nunmehr 4 Jahren bin ich als Trainer bei euch aktiv und hoffe, dass mein 
											Studium zum Bewegungswissenschaftler auch euch in Form von Trainingsgestaltung und 
											sonstigem Nebenwissen zu Gute kommt.
											Seit dem 25.04.2009 bin ich im Besitz der C-Lizenz als Trainer im Breitensport.</p>
											<p>In der Rückrunde 2010/11 habe ich zudem zeitgleich eine B-Jugend trainiert."</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						</li>
						<!-- Training -->
						<li class="one-col">
							<div id="training" class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle">Das Training</h2>
								<div class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-body">
									<p>Anders als die Spiele, welche wir in Cranz am Estebogen auf einem Rasenplatz austragen, 
									findet unser Training 2x wöchentlich in Neuenfelde im Arp-Schnittger-Stieg im "Käfig" auf 
									einem Hartplatz statt. 
									<p>Immer montags ab 19.15 und donnerstags ab (?) versammelt sich die 
									sportbegeisterte Horde um den Trainingsanweisungen unseres Trainergespanns um Mathias 
									Schwarzer und Simon Elmers zu folgen. </p>
									<p>Im Winter weichen  wir selbstverständlich einmal 
									wöchentlich in die Sporthalle Cranz aus, um einen einigermaßen geregelten Trainingsbetrieb 
									gewährleisten zu können.</p>
									<p>Um eine angenehme Trainingsatmosphäre sind unsere Trainer stets bemüht und so darf in der ein 
									oder anderen Trainingseinheit ein Wettbewerb wie etwa Lattenschießen, Armwegzieh-
									Championsleague oder ein Fußball-Biathlon nicht fehlen.
									</p>
									<p><br>
									<b>Aktuelle Trainingszeiten:</b><br><br>
									Montag, 19:15<br>
									Donnerstag, 18:30<br>
									</p>
								</div>
								</div>
							</div>
						</li>
						<!--  -->
						<li class="one-col">							
							<div id="anfahrt" class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle">Anfahrt</h2>
								<div class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-body">
									<p>
									<b>Anfahrt mit dem Auto</b><br><br>
									Den Sportplatz am Arp-Schnitger-Stieg zum Training erreichst du wie folgt:
									<div class="google-maps-wrapper">
										<iframe class="google-maps-map" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.de/maps?f=d&amp;source=s_d&amp;saddr=A7&amp;daddr=Arp-Schnitger-Stieg&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFTGaMAMdmrWVAA&amp;aq=&amp;sll=53.523982,9.861946&amp;sspn=0.185119,0.445976&amp;mra=dme&amp;mrsp=0&amp;sz=12&amp;ie=UTF8&amp;ll=53.523982,9.861946&amp;spn=0.185119,0.445976&amp;t=m&amp;output=embed"></iframe>
										<a class="show-link" href="https://maps.google.de/maps?f=d&amp;source=embed&amp;saddr=A7&amp;daddr=Arp-Schnitger-Stieg&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFTGaMAMdmrWVAA&amp;aq=&amp;sll=53.523982,9.861946&amp;sspn=0.185119,0.445976&amp;mra=dme&amp;mrsp=0&amp;sz=12&amp;ie=UTF8&amp;ll=53.523982,9.861946&amp;spn=0.185119,0.445976&amp;t=m">Kartenansicht</a><br>
									</div>
									<br>
									Anfahrt zum Rasenplatz in Cranz, auf dem die Spiele stattfinden:
									<div class="google-maps-wrapper">
										<iframe class="google-maps-map" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.de/maps?f=d&amp;source=s_d&amp;saddr=A7&amp;daddr=Cranz+Estebogen&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFULLMAMdoh2VACnlBCA3PIOxRzHAlIur7Lu0YA&amp;aq=&amp;sll=53.539199,9.83673&amp;sspn=0.092526,0.222988&amp;mra=ltm&amp;ie=UTF8&amp;ll=53.539185,9.836712&amp;spn=0.038143,0.161628&amp;t=m&amp;output=embed"></iframe>
										<a class="show-link" href="https://maps.google.de/maps?f=d&amp;source=embed&amp;saddr=A7&amp;daddr=Cranz+Estebogen&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFULLMAMdoh2VACnlBCA3PIOxRzHAlIur7Lu0YA&amp;aq=&amp;sll=53.539199,9.83673&amp;sspn=0.092526,0.222988&amp;mra=ltm&amp;ie=UTF8&amp;ll=53.539185,9.836712&amp;spn=0.038143,0.161628&amp;t=m">Kartenansicht</a><br>
									</div>
									</p>
									<p>
									<b>Anfahrt mit öffentlichen Verkehrsmitteln</b><br><br>
									Der Platz in Cranz kann mit dem Bus Nr. 150 über die Haltestelle "Cranz Estebogen" erreicht werden.<br>
									Um am Training teilzunehmen fährt ebenfalls die Linie 150 zur Haltestelle "Neuenfelde Kirche".
									Von hier aus sind es noch ca. 850m bis zum Sportplatz.
									</p>
									</div>
								</div>
							</div>
						</li>
						<li class="one-col">
							<div id="kontakt" class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle">Kontakt</h2>
								<div class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-body">
										<p><b>Du hast noch Fragen?</b><br><br>
										Dann kontaktiere und per Mail, Telefon oder Facebook!</p>
										<p>
										<b>Kontaktinformationen</b><br><br>
										SV Este 06/70<br>
										Arp-Schnitger Stieg 37c<br>
										Tel. (040) 7458047<br>
										21129 Hamburg<br>
										<br>
										<a class="show-link" href="mailto:damen-este0670@web.de">damen-este0670@web.de</a>
										</p>
										<p>
										<b>Facebook</b><br><br>
										Besuche unsere Facebook-Seite: <a class="show-link" href="https://www.facebook.com/pages/SV-Este-0670/112846398725953">SV Este 06/70</a>.<br>
										Dort findest du auch aktuelle Informationen zu allen Vereinsaktivitäten.
										</p>
									</div>
								</div>
							</div>
						</li>
				</ul>				
			</div>
			</div>
			</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

