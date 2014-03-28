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
				<c:forEach var="imgPath" items="${firstImageCol}" varStatus="status">
					<img src="${imgPath}" class="galery-img--complete"/>
				</c:forEach>
			</div>
			<div class="galery-inner-wrapper">
	       		<c:forEach var="imgPath" items="${secondImageCol}" varStatus="status">
					<img src="${imgPath}" class="galery-img--complete"/>
				</c:forEach>
			</div>
			<div class="galery-inner-wrapper">
	       		<c:forEach var="imgPath" items="${thirdImageCol}" varStatus="status">
					<img src="${imgPath}" class="galery-img--complete"/>
				</c:forEach>
			</div>
		</div>
		
		<a href="${linkHome}" class="galery-close"></a>
		
	</body>
</html>

