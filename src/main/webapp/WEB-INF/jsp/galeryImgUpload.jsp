<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Spielberichte"/>
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
			<div id="..." class="content-list">
				<ul>
					 <%--Contentbox One-Col --%>
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Bilder zur Galerie hinzufügen</h2>
                             <div class="box-body">
                             	
                             	<%-- Formular zum hochladen eines neuen Bildes 
                             		 modelAttribute: Referenz auf Variable, die durch Kontroller zugreifbar gemacht wurde
                             		 ectype mutipart/form-data:	Jedes Feld wird als einzelner Teil des POST Request behandelt,
                             		 							nicht nur als Name-Wert-Paar
                             	--%>
								<form 	action="${linkGaleryUpload}"
										method="POST"
										enctype="multipart/form-data">
									Bild hochladen:
									<input name="image" type="file"/><br>
									<input type="submit" value="Hochladen"/>
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

