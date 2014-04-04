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
			<div class="content-list">
				<ul>
					<sf:form method="POST" modelAttribute="content">
					<!-- Der Verein -->
					<li class="one-col">
						<div id="verein" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Der Verein</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="companyText"
													id="companyText"
													rows="1"
													cols="120"
													placeholder="Text über den Verein ..."
													value="${content.companyText}"
													class="full-width"
									/><br>
									<sf:errors path="companyText" cssClass="error"/><br>
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
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="teamText"
													id="teamText"
													rows="1"
													cols="120"
													placeholder="Text über den Verein ..."
													value="${content.teamText}"
													class="full-width"
									/><br>
									<sf:errors path="teamText" cssClass="error"/><br>
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
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="trainerFirstPartText"
													id="trainerFirstPartText"
													rows="1"
													cols="120"
													placeholder="Text Matschi ..."
													value="${content.trainerFirstPartText}"
													class="full-width"
									/><br>
									<sf:errors path="trainerFirstPartText" cssClass="error"/><br>
									<sf:textarea 	path="trainerSecondPartText"
													id="trainerSecondPartText"
													rows="1"
													cols="120"
													placeholder="Text Simon ..."
													value="${content.trainerSecondPartText}"
													class="full-width"
									/><br>
									<sf:errors path="trainerSecondPartText" cssClass="error"/><br>
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
								<div class="toggle-content">
									<div class="box-body">
										<sf:textarea 	path="trainingText"
														id="trainingText"
														rows="1"
														cols="120"
														placeholder="Text zum Training ..."
														value="${content.trainingText}"
														class="full-width"
										/><br>
										<sf:errors path="trainingText" cssClass="error"/><br>
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
								<div class="toggle-content">
									<div class="box-body">
										<p>
										<sf:textarea 	path="approachPlayingFieldTrainingText"
														id="approachPlayingFieldTrainingText"
														rows="1"
														cols="120"
														placeholder="Anfahrt zum Sportplatz Neuenfelde ..."
														value="${content.approachPlayingFieldTrainingText}"
														class="full-width"
										/><br>
										<sf:errors path="approachPlayingFieldTrainingText" cssClass="error"/><br>
										<br>
										<sf:textarea 	path="approachPlayingFieldMatchText"
														id="approachPlayingFieldMatchText"
														rows="1"
														cols="120"
														placeholder="Anfahrt zum Sportplatz in Cranz ..."
														value="${content.approachPlayingFieldMatchText}"
														class="full-width"
										/><br>
										<sf:errors path="approachPlayingFieldMatchText" cssClass="error"/><br>
										<sf:textarea 	path="approachPublicTransportText"
														id="approachPublicTransportText"
														rows="1"
														cols="120"
														placeholder="Anfahrt mit öffentlichen Verkehrsmitteln ..."
														value="${content.approachPublicTransportText}"
														class="full-width"
										/><br>
										<sf:errors path="approachPublicTransportText" cssClass="error"/><br>
									</div>
								</div>
							</div>
						</li>
						<li class="one-col">
							<div id="kontakt" class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle">Kontakt</h2>
								<div class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content">
									<div class="box-body">
										<p>${content.contactText}</p>
										<sf:textarea 	path="contactText"
														id="contactText"
														rows="1"
														cols="120"
														placeholder="Text zum Kontakt ..."
														value="${content.contactText}"
														class="full-width"
										/><br>
										<sf:errors path="contactText" cssClass="error"/><br>
									</div>
								</div>
							</div>
						</li>
					</sf:form>
				</ul>				
				
				<form action="${linkAboutUsEdit}" method="POST">
					<button class="dark-bg" type="submit"><div class="forward-raquo menu-link right"></div>Speichern</button>
				</form>

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

