<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Spielberichte"/>
		<jsp:param name="description" value="Neuen Spielbericht verfassen"/>
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
						<form action="${linkReports}" method="POST">
							<!-- Erstellformular für einen Spielbericht -->
							<div  class="main-content-box box-borders-top bg clearfix">
								<h2 class="box-title link" id="address-name" >
									<input type="text" name="topic" value="Überschrift"></input>
								</h2>
								<div class="box-info clearfix light-bg">
									<div class="left half-width">
										<table class="first">
											<tbody>
											<tr class="first">
												<th class="first">Name des Gegners:</th>
												<td class="last">
													<input type="text" name="opponent"/>
												</td>
											</tr>
											<tr>
												<th class="first">Halbzeit:</th>
												<td class="last">
													<input type="text" name="scoreFirstHalfHome" value="Heim"/>:
													<input type="text" name="scoreFirstHalfGuest" value="Gast"/>
												</td>
											</tr>
											</tbody>
										</table>
									</div>
									<div class="left half-width">
										<table class="last">
											<tbody>
											<tr>
												<th class="first">Datum:</th>
												<td class="last">
													<input type="text" name="stringDateTime" value="tt-mm-jj hh-mm"/>
												</td>
											</tr>
											<tr>
												<th class="first">Endstand:</th>
												<td class="last">
													<input type="text" name="scoreSecondHalfHome" value="Heim"/>:
													<input type="text" name="scoreSecondHalfGuest" value="Gast"/>
												</td>
											</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="box-body">
									<input type="text" name="text" value="Gib hier den Spielbericht ein."/>
								</div>
							</div>
							
							<button type="submit">Speichern</button>
						<!-- Ende des Formulars -->
						</form>
					</li>
				</ul>
				
				<!-- end Contentbox One-Col -->
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

