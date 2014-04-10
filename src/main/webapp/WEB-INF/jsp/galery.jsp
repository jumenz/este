<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Galerie"/>
		<jsp:param name="description" value="Die Bildergalerie der Frauen des Este 06/70."/>
	</jsp:include>
	<link rel="stylesheet" type="text/css" href="${cssPath}/galery.css"/>
	
	<body>
		<%-- Close Button --%>
		<a href="${linkWelcome}" class="galery-close"></a>
		
		<div class="galery-outer-wrapper">
			<%-- Images Three Col View --%>
			<div class="galery-inner-wrapper-three-col">
				<c:forEach var="imgPath" items="${firstPartThreeCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
			<div class="galery-inner-wrapper-three-col">
	       		<c:forEach var="imgPath" items="${secondPartThreeCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
			<div class="galery-inner-wrapper-three-col">
	       		<c:forEach var="imgPath" items="${thirdPartThreeCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
		
			<%-- Images Two Col View --%>
			<div class="galery-inner-wrapper-two-col">
				<c:forEach var="imgPath" items="${firstPartTwoCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
			<div class="galery-inner-wrapper-two-col">
	       		<c:forEach var="imgPath" items="${secondPartTwoCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
			
			<%-- Images One Col View --%>
			<div class="galery-inner-wrapper-one-col">
				<c:forEach var="imgPath" items="${oneCol}" varStatus="status">
					<a href="${imgPath}"><img src="${imgPath}" class="galery-img--complete" alt="este-damen-bildergalerie"/></a>
				</c:forEach>
			</div>
		</div>
		
	</body>
</html>

