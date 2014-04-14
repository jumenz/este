<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Dokumente"/>
		<jsp:param name="description" value="Neuen Spielbericht verfassen"/>
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
			<div id="documents-upload" class="content-list">
				<ul>
					 <%--Contentbox One-Col --%>
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Dokumente</h2>
                             <div class="box-body">
                             	<%-- Formular zum hochladen eines neuen Dokuments 
                             		 modelAttribute: Referenz auf Variable, die durch Controller zugreifbar gemacht wurde
                             		 ectype mutipart/form-data:	Jedes Feld wird als einzelner Teil des POST Request behandelt,
                             		 							nicht nur als Name-Wert-Paar --%>
								<form action="${linkDocumentsUpload}" method="POST" enctype="multipart/form-data">
									Dokument ausw�hlen:
									<input name="newDocument" type="file"/>
									<br><br>
									<button type="submit" value="Hochladen" class="dark-bg"><div class="forward-raquo menu-link right"></div>Hochladen</button>
								</form>
								<%-- Ende Formular --%>
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
