<%@include file="./includes/taglibs_variables.jspf" %>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Impressum"/>
		<jsp:param name="description" value="Startseite der Frauen des Este 06/70"/>
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
				<%--Contentbox One-Col --%>
                 <ul>
                     <li class="one-col">
                         <div class="main-content-box box-borders bg clearfix">
                             <h2 class="box-title">Impressum</h2>
                             <div class="box-body">	
								<p>${impressumContent.text}</p>
								<%-- Button zum bearbeiten --%>
	                             <security:authorize access="hasRole('USER_GROUP_ADMIN')">
				                     <form action="${linkImpressumEdit}" method="GET">
				                     	<button class="dark-bg" type="submit"><div class="forward-raquo menu-link right"></div>Bearbeiten</button>
				                     </form>
			                     </security:authorize>
                             </div>
                         </div>
                     </li>
                     
                 </ul>
                 <%-- end Contentbox One-Col --%>
			</div>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>
	</body>
</html>

