<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Galerie"/>
		<jsp:param name="description" value="Die Bildergalerie der Frauen des Este 06/70."/>
	</jsp:include>
	<link rel="stylesheet" type="text/css" href="${cssPath}/galery.css"/>
	
	<body>

		
		<div class="galery-outer-wrapper">
			<div class="galery-inner-wrapper">
				<img src="http://t1.ftcdn.net/jpg/00/23/94/04/400_F_23940476_uUA3W05O1R55s2rwINRbGTKYXYvngbCQ.jpg" style="float: left" class="galery-img--complete"/>
	       		<% for(int i=0; i<=3; i++) { %>
					<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" style="float: right" class="galery-img--complete"/>
				<% } %>
				<img src="http://t1.ftcdn.net/jpg/00/23/94/04/400_F_23940476_uUA3W05O1R55s2rwINRbGTKYXYvngbCQ.jpg" style="float: left" class="galery-img--complete"/>
			</div>
			<div class="galery-inner-wrapper">
	       		<% for(int i=0; i<=2; i++) { %>
				<img src="http://www.2012-impulse.de/wp-content/uploads/image/2012/sonne_wolken.jpg" style="float: left" class="galery-img--complete"/>
				<img src="http://diedickefrauaufraedern.files.wordpress.com/2012/02/strand1.jpg" style="float: right" class="galery-img--complete"/>
				<% } %>
			</div>
			<div class="galery-inner-wrapper">
	       		<% for(int i=0; i<=2; i++) { %>
				<img src="http://www.wunderkarten.de/blog/wp-content/uploads/Eis-selber-machen-Collage02.jpg" style="float: left" class="galery-img--complete"/>
				<img src="http://www.streetartutopia.com/wp-content/uploads/2012/04/street_art_yarn_crochet_1.jpeg" style="float: right" class="galery-img--complete"/>
				<% } %>
			</div>
		</div>
		
		<a href="${linkHome}" class="galery-close"></a>
		

	</body>
</html>

