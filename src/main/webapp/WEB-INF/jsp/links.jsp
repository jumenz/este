<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Links"/>
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
        	<!-- Sidebar -->
        	<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="..."/>
				<jsp:param name="abc" value="include" />
				<jsp:param name="timer" value="false"/>
				<jsp:param name="nav" value="Tabelle"/>
				<jsp:param name="ref" value="#" />
				<jsp:param name="nav" value="Spielplan"/>
				<jsp:param name="ref" value="#" />
				<jsp:param name="nav" value="Begegnungen"/>
				<jsp:param name="ref" value="#" />
			</jsp:include>
        
			<div id="..." class="content-list">
				
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

