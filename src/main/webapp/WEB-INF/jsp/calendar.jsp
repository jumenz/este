<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Julia Menzel
 --%>
 <%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Kalender"/>
		<jsp:param name="description" value="Kalender der Frauen des Este 06/70"/>
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
			<div id="calendar" class="content-list">
				<ul>
					<%-- Kalender wird nur angezeigt, wenn der User angemeldet ist --%>
					<security:authorize access="isAuthenticated()">
						<%--Contentbox One-Col --%>
						
						<%-- Kalender --%>	
	                     <li class="one-col">
	                         <div class="main-content-box box-borders bg clearfix">
	                             <h2 class="box-title">Kalender</h2>
	                             <div class="box-body">
	                              <%-- Mehr infos zum Kalender auf https://support.google.com/calendar/answer/41207?hl=de --%>
	                              	<%-- Kalender-Darstellung bei großen Displays --%>
									<iframe src="https://www.google.com/calendar/embed?showTitle=0&amp;showNav=0&amp;showTabs=0&amp;showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=2&amp;hl=de&amp;bgcolor=%23F5F3F5&amp;src=dameneste0670%40gmail.com&amp;color=%232F6309&amp;src=de.german%23holiday%40group.v.calendar.google.com&amp;color=%232F6213&amp;ctz=Europe%2FBerlin" 
										class="display-desktop" style=" border-width:0 " width="976" height="600" frameborder="0" scrolling="no">
									</iframe>
									<%-- Listen-Darstellung bei kleinen Displays --%>
									<iframe src="https://www.google.com/calendar/embed?showTitle=0&amp;showNav=0&amp;showDate=0&amp;showPrint=0&amp;showTabs=0&amp;showCalendars=0&amp;showTz=0&amp;mode=AGENDA&amp;height=600&amp;wkst=2&amp;hl=de&amp;bgcolor=%23F5F5F5&amp;src=dameneste0670%40gmail.com&amp;color=%232F6309&amp;src=de.german%23holiday%40group.v.calendar.google.com&amp;color=%232F6213&amp;ctz=Europe%2FBerlin" 
										 class="hidden-desktop" seamless="seamless" style=" border-width:0 "frameborder="0" scrolling="no" height="600" width="100%" >
									</iframe>
	                             </div>
	                         </div>
	                     </li>
					</security:authorize>
				</ul>
				<%-- Sollte User nicht eingeloggt sein, folgende Meldung anzeigen --%>
				<security:authorize access="not isAuthenticated()">
					<p>Bitte logge dich ein um deinen Kalender zu sehen.</p>
				</security:authorize>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>
