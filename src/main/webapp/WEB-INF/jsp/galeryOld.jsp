<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Galerie"/>
		<jsp:param name="description" value="Die Bildergalerie der Frauen des Este 06/70."/>
	</jsp:include>
	<link rel="stylesheet" type="text/css" href="${cssPath}/galery.css"/>
	
	<body>
		<!-- header -->
		<jsp:include page="./includes/header.jsp"/>
		
		<!-- Fullview -->
		<div id="galery-preview--full" class="hidden"> <!-- onclick="hideElement( this.id );" -->
			<div class="button-prev" onclick=""></div>
			<!-- extra div um close button am Bild auszurichten -->
			<div class="galery-preview-img-full-wrapper">
				<div class="button-close" onclick="hideElement('galery-preview--full');"></div>
				<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--full" id="galery-preview-full-img">
			</div>
			<div class="button-next" onclick=""></div>
		</div>

		<!-- content -->
        <div class="main-container">
        <!-- Content -->
        <div class="container">
        <div class="main">
        <div class="main-inner">
        	<!-- sidebar -->
        	<!-- TODO javascript anders ausführen (funktioniert so auch nicht) -->
			<jsp:include page="./includes/sidebar.jsp">
				<jsp:param name="sidebarTitle" value="Galerie"/>
				<jsp:param name="timer" value="include"/>
				<jsp:param name="nav" value="Alle Bilder"/>
				<jsp:param name="ref" value="hideElement('galery-preview--all--wrapper');showElement('galery-preview--multiple--wrapper');" />
				<jsp:param name="nav" value="Galerie"/>
				<jsp:param name="ref" value="hideElement('galery-preview--all--wrapper');showElement('galery-preview--multiple--wrapper');" />
				<jsp:param name="nav" value="Vollbild"/>
				<jsp:param name="ref" value="showElement('galery-preview--full')" />
			</jsp:include>
        
        	<div id="main-content-small" class="content-layout-cell main-content main-content-small">
			<div class="outer">
			<div class="inner">				
			<div class="content-list">
				<!--Contentbox One-Col -->
						<ul>
							<li class="one-col">
								<div id="galery-preview--all--wrapper" class="hidden">
									<div class="main-content-box box-borders bg clearfix">
										<a href="#" class="back">
											<div class="back-raquo menu-link box-title-raquo-left"></div>
										</a>
										<h2 class="box-title box-title-center">Vorschau</h2>
										<a class="forward">
											<div class="forward-raquo menu-link box-title-raquo-right"></div>
										</a>
										<div class="box-body">
											<!-- show all pictures -->
											<div id="galery-preview--all">						<!-- TODO ID RAUS -->
												<div class="galery-preview--all-images">
													<% for(int i=0; i<=50; i++) { %>
													<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--small"
														onclick="fullView( this.src );"
													>
													<% } %>
												</div>
											</div>
											
											<!-- medium view -->
											<div id="galery-preview--multiple" class="round-corners" >
												<div class="button-prev" onclick=""></div>
													<% for(int i=0; i<=4; i++) { %>
														<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--medium"
															onclick="fullView( this.src );"
														>
													<% } %>
												<div class="button-next" onclick=""></div>
											</div>
											<div class="round-corners" id="galery-preview--medium">
												<div class="button-prev" onclick=""></div>
												<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--big"
														onclick="fullView( this.src );"
												>
												<div class="button-next" onclick=""></div>
											</div>
										</div>
									</div>
								</div>
								<div id="galery-preview--multiple--wrapper">
									<div class="main-content-box box-borders bg clearfix">
										<h2 class="box-title">Vorschau</h2>
										<div class="box-body">
											<!-- medium view -->
											<div id="galery-preview--multiple" class="round-corners" >
												<div class="button-prev" onclick=""></div>
												<?php for($i=1; $i<=4; $i++) : ?>
												<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--medium"
													onclick="fullView( this.src );"
												>
												<?php endfor ?>
												<div class="button-next" onclick=""></div>
											</div>
											<div class="round-corners" id="galery-preview--medium">
												<div class="button-prev" onclick=""></div>
												<img src="http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg" class="galery-img--big"
														onclick="fullView( this.src );"
												>
												<div class="button-next" onclick=""></div>
											</div>
										</div>
									</div>
								</div>
							</li>
			</div>
			</div>
			</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

