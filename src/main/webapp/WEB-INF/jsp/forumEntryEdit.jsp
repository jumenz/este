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
		<jsp:param name="title" value="Forum"/>
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
       
			<div id="..." class="content-list">
				<ul>
					<%--Contentbox One-Col --%>
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Foreneintrag</h2>
                             <div class="box-body">
                             	<%-- Formular zum anlegen eines neuen Spielberichts --%>	
								<sf:form method="POST" modelAttribute="forumEntry">
									<fieldset>
										<%-- Titeleingabe --%>
										<sf:textarea 	path="topic"
														id="topic"
														rows="1"
														cols="120"
														value="${forumEntry.topic}"
														placeholder="Titel"
														required="true"
										/><br>
										<%-- Fehlermeldung für den Titel --%>
										<sf:errors path="topic" cssClass="error"/><br>
										<%-- Kurzbeschreibung --%>
										<sf:textarea 	path="description" 
														id="description"
														rows="5"
														cols="120"
														value="${forumEntry.description}"
														placeholder="Kurzbeschreibung"
														required="true"
										/><br>
										<%-- Fehlermeldung für die Kurzbeschreibung --%>
										<sf:errors path="description" cssClass="error"/><br>
										<%-- Text --%>
										<sf:textarea 	path="text" 
														id="text"
														value="${forumEntry.text}"
														placeholder="Tippe hier deinen Text"
														rows="20"
														cols="120"
														required="true"
										/><br>
										<%-- Fehlermeldung für den Text --%>
										<sf:errors path="text" cssClass="error"/><br>
										<%-- Buttons --%>
										<button class="dark-bg" name="commit" type="submit"><div class="forward-raquo menu-link right"></div>Speichern</button>
										<button class="dark-bg" name="reset" type="reset"><div class="forward-raquo menu-link right"></div>Zurücksetzen</button>
									</fieldset>
								</sf:form>
                             </div>
                         </div>
                     </li>
                 	<%-- end Contentbox One-Col --%>
				</ul>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

