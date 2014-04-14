<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Galerie Upload"/>
		<jsp:param name="description" value="Neuen Bilder hochladen"/>
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
			<div id="galery-upload" class="content-list">
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
								<p>
									Du kannst hier nur JPG oder PNG Dateien hochladen.<br>
									Bitte komprimiere die Bilder vor dem Upload auf eine geringere Auflösung, um lange Ladezeiten zu verhindern.
								</p>
								<form 	action="${linkGaleryUpload}"
										method="POST"
										enctype="multipart/form-data">
									Bild hochladen:
									<input name="image" type="file"/>
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

