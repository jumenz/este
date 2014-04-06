<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Über uns"/>
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
				<jsp:param name="ref" value="${linkAboutUs}#verein" />
				<jsp:param name="nav" value="Die Mannschaft"/>
				<jsp:param name="ref" value="${linkAboutUs}#mannschaft" />
				<jsp:param name="nav" value="Die Trainer"/>
				<jsp:param name="ref" value="${linkAboutUs}#trainer" />
				<jsp:param name="nav" value="Das Training"/>
				<jsp:param name="ref" value="${linkAboutUs}#training" />
				<jsp:param name="nav" value="Anfahrt"/>
				<jsp:param name="ref" value="${linkAboutUs}#anfahrt" />
				<jsp:param name="nav" value="Kontakt"/>
				<jsp:param name="ref" value="${linkAboutUs}#kontakt" />
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
									<img class="about-us-img-logo" src="${dataPath}/images/logo-este.png">
									${aboutUsContent.companyText}
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
									<p>${aboutUsContent.teamText}</p>
									<img class="about-us-img-team" src="${dataPath}/galery/K640_picture24.JPG">
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
										<h3>${aboutUsContent.trainerFirstName}</h3><br>
										<div class="profile-description">
											<img class="about-us-img-trainer" src="${dataPath}/images/K640_trainer-m.JPG" />
											<p>${aboutUsContent.trainerFirstText}</p>
										</div>
									</div>
									<div class="profile">
										<h3>${aboutUsContent.trainerSecondName}</h3><br>
										<div class="profile-description">
											<img class="about-us-img-trainer" src="${dataPath}/images/K640_trainer-s.JPG" />
											<p>${aboutUsContent.trainerSecondText}</p>
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
									<p>${aboutUsContent.trainingText}</p>
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
									${aboutUsContent.approachPlayingFieldTrainingText}
									<div class="google-maps-wrapper">
										<iframe class="google-maps-map" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.de/maps?f=d&amp;source=s_d&amp;saddr=A7&amp;daddr=Arp-Schnitger-Stieg&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFTGaMAMdmrWVAA&amp;aq=&amp;sll=53.523982,9.861946&amp;sspn=0.185119,0.445976&amp;mra=dme&amp;mrsp=0&amp;sz=12&amp;ie=UTF8&amp;ll=53.523982,9.861946&amp;spn=0.185119,0.445976&amp;t=m&amp;output=embed"></iframe>
										<a class="show-link" href="https://maps.google.de/maps?f=d&amp;source=embed&amp;saddr=A7&amp;daddr=Arp-Schnitger-Stieg&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFTGaMAMdmrWVAA&amp;aq=&amp;sll=53.523982,9.861946&amp;sspn=0.185119,0.445976&amp;mra=dme&amp;mrsp=0&amp;sz=12&amp;ie=UTF8&amp;ll=53.523982,9.861946&amp;spn=0.185119,0.445976&amp;t=m">Kartenansicht</a><br>
									</div>
									<br>
									${aboutUsContent.approachPlayingFieldMatchText}
									<div class="google-maps-wrapper">
										<iframe class="google-maps-map" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.de/maps?f=d&amp;source=s_d&amp;saddr=A7&amp;daddr=Cranz+Estebogen&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFULLMAMdoh2VACnlBCA3PIOxRzHAlIur7Lu0YA&amp;aq=&amp;sll=53.539199,9.83673&amp;sspn=0.092526,0.222988&amp;mra=ltm&amp;ie=UTF8&amp;ll=53.539185,9.836712&amp;spn=0.038143,0.161628&amp;t=m&amp;output=embed"></iframe>
										<a class="show-link" href="https://maps.google.de/maps?f=d&amp;source=embed&amp;saddr=A7&amp;daddr=Cranz+Estebogen&amp;hl=de&amp;geocode=FbsXMQMdzxOXAA%3BFULLMAMdoh2VACnlBCA3PIOxRzHAlIur7Lu0YA&amp;aq=&amp;sll=53.539199,9.83673&amp;sspn=0.092526,0.222988&amp;mra=ltm&amp;ie=UTF8&amp;ll=53.539185,9.836712&amp;spn=0.038143,0.161628&amp;t=m">Kartenansicht</a><br>
									</div>
									</p>
									<p>${aboutUsContent.approachPublicTransportText}</p>
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
										<p>${aboutUsContent.contactText}</p>
									</div>
								</div>
							</div>
						</li>
				</ul>				
				
				<!-- Panel zum Bearbeiten der Seite, wenn Admin -->
				<security:authorize access="hasRole('USER_GROUP_ADMIN')">
					<form action="${linkAboutUsEdit}" method="get">
						<button class="dark-bg" type="submit"><div class="forward-raquo menu-link right"></div>Bearbeiten</button>
					</form>
				</security:authorize>

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
		<!-- javascript, das nach Laden ausgeführt werden soll -->
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>

