<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Forum"/>
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
       
			<div id="..." class="content-list">
				<ul>
					<li class="one-col">
						<form action="${linkForum}" method="post">
							<!-- reports -->
							<div  class="main-content-box box-borders-top bg clearfix">
								<h2 class="box-title link toggle" id="address-name" ><c:out value="${entry.topic }"></c:out></h2>
								<div id="submit-${status.index}" class="box-link down-raquo toggle-link right toggle">
								</div>
								<div class="toggle-content" style="display: none">
									<div class="box-info clearfix light-bg">
										<input type="text" value="Kurztext" name="description"/>										
									</div>
									<div class="box-body">
										<input type="text" value="text" name="Tippe hier den Text des Foreneintrages ein."/>
									</div>
								</div>
							</div>
							<!-- reports -->
						</form>		
					</li>
				</ul>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

