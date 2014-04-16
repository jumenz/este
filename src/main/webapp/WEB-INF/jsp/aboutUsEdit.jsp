<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Ellen Schwartau
 --%>
 <%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Bearbeiten"/>
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
			<div class="content-list">
				<ul>
					<sf:form method="POST" modelAttribute="aboutUsContent">
					<%-- Der Verein --%>
					<li class="one-col">
						<div id="verein" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Der Verein</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="companyText"
													id="companyText"
													rows="10"
													cols="120"
													placeholder="Text über den Verein ..."
													value="${aboutUsContent.companyText}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="companyText" cssClass="error"/><br>
								</div>
							</div>
						</div>
					</li>
					<%-- Die Mannschaft --%>
					<li class="one-col">
						<div id="mannschaft" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Die Mannschaft</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="teamText"
													id="teamText"
													rows="10"
													cols="120"
													placeholder="Text über den Verein ..."
													value="${aboutUsContent.teamText}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="teamText" cssClass="error"/><br>
								</div>
							</div>
						</div>
					</li>
					<%-- Trainer --%>
					<li class="one-col">
						<div id="trainer" class="main-content-box box-borders-top bg clearfix toggle-item">
							<h2 class="box-title link toggle">Die Trainer</h2>
							<div class="box-link down-raquo toggle-link right toggle">
							</div>
							<div class="toggle-content">
								<div class="box-body">
									<sf:textarea 	path="trainerFirstName"
													id="trainerFirstName"
													rows="1"
													cols="120"
													placeholder="Name Trainer ..."
													value="${aboutUsContent.trainerFirstName}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="trainerFirstName" cssClass="error"/><br>
									<sf:textarea 	path="trainerFirstText"
													id="trainerFirstText"
													rows="10"
													cols="120"
													placeholder="Text Matschi ..."
													value="${aboutUsContent.trainerFirstText}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="trainerFirstText" cssClass="error"/><br>
									<sf:textarea 	path="trainerSecondName"
													id="trainerSecondName"
													rows="1"
													cols="120"
													placeholder="Name Trainer ..."
													value="${aboutUsContent.trainerSecondName}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="trainerSecondName" cssClass="error"/><br>
									<sf:textarea 	path="trainerSecondText"
													id="trainerSecondText"
													rows="10"
													cols="120"
													placeholder="Text Simon ..."
													value="${aboutUsContent.trainerSecondText}"
													class="full-width"
													required="true"
									/><br>
									<sf:errors path="trainerSecondText" cssClass="error"/><br>
								</div>
							</div>
						</div>
						</li>
						<%-- Training --%>
						<li class="one-col">
							<div id="training" class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle">Das Training</h2>
								<div class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content">
									<div class="box-body">
										<sf:textarea 	path="trainingText"
														id="trainingText"
														rows="10"
														cols="120"
														placeholder="Text zum Training ..."
														value="${aboutUsContent.trainingText}"
														class="full-width"
														required="true"
										/><br>
										<sf:errors path="trainingText" cssClass="error"/><br>
									</div>
								</div>
							</div>
						</li>
						<%--  --%>
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
														rows="10"
														cols="120"
														placeholder="Anfahrt zum Sportplatz Neuenfelde ..."
														value="${aboutUsContent.approachPlayingFieldTrainingText}"
														class="full-width"
														required="true"
										/><br>
										<sf:errors path="approachPlayingFieldTrainingText" cssClass="error"/><br>
										<br>
										<sf:textarea 	path="approachPlayingFieldMatchText"
														id="approachPlayingFieldMatchText"
														rows="10"
														cols="120"
														placeholder="Anfahrt zum Sportplatz in Cranz ..."
														value="${aboutUsContent.approachPlayingFieldMatchText}"
														class="full-width"
														required="true"
										/><br>
										<sf:errors path="approachPlayingFieldMatchText" cssClass="error"/><br>
										<sf:textarea 	path="approachPublicTransportText"
														id="approachPublicTransportText"
														rows="10"
														cols="120"
														placeholder="Anfahrt mit öffentlichen Verkehrsmitteln ..."
														value="${aboutUsContent.approachPublicTransportText}"
														class="full-width"
														required="true"
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
										<sf:textarea 	path="contactText"
														id="contactText"
														rows="10"
														cols="120"
														placeholder="Text zum Kontakt ..."
														value="${aboutUsContent.contactText}"
														class="full-width"
														required="true"
										/><br>
										<sf:errors path="contactText" cssClass="error"/><br>
									</div>
								</div>
							</div>
						</li>
						
						<button class="dark-bg" type="submit"><div class="forward-raquo menu-link right"></div>Speichern</button>
						
					</sf:form>
				</ul>				

			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
		<%-- javascript, das nach Laden ausgeführt werden soll --%>
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>

