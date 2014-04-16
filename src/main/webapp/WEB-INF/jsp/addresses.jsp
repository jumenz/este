<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Julia Menzel
 --%>
<%@include file="./includes/taglibs_variables.jspf" %>
<%-- Admin --%>
<c:set var="isAdmin" value="0"/>
<security:authorize access="hasRole('USER_GROUP_ADMIN')">
    <c:set var="isAdmin" value="1"/>
</security:authorize>
<%-- User --%>
<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.username" var="username" scope="request"/>
</security:authorize>
<html>
<jsp:include page="./includes/head.jsp">
	<jsp:param name="title" value="Adressbuch"/>
	<jsp:param name="description" value="Adressbuch"/>
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
    	<%-- Sidebar --%>
    	<jsp:include page="./includes/sidebar.jsp">
		<jsp:param name="sidebarTitle" value="Adressbuch"/>
		<jsp:param name="abc" value="include" />
		<jsp:param name="nav" value="Startseite"/>
		<jsp:param name="ref" value="${linkWelcome}" />
		</jsp:include>
		<%-- end Sidebar --%>

<%-- main Content small--%>
<div id="main-content-small" class="content-layout-cell main-content main-content-small">
    <div class="outer">
        <div class="inner">
            <div id="addressbook" class="content-list">
                <%--Contentbox One-Col Dropdown --%>
                <ul>
					<%-- mail @all --%>
                	<li class="one-col">
                        <div class="main-content-box box-borders-top bg clearfix">
                            <h2 class="box-title link" >Alle</h2>
                            <c:set var="emailCount" value="${addressModel.entries.size()}"/>
                            <a class="right box-link" href="mailto:<c:forEach var="address" items="${addressModel.entries}" varStatus="status">${address.email},%20</c:forEach>&amp;subject=Este%2006/70">
                            	<span>E-Mail</span>
                            	<span id="submit-all" class="forward-raquo menu-link right"></span>
                            </a>
							<div id="submit-${status.index}" class="box-link forward-raquo menu-link right toggle"></div>
                        </div>
                    </li>
					<%-- ID Berechnung für die Anker. Immer der erste Eintrag beginnend mit einem neuen Buchstaben bekommt als ID den Buchstabens --%>
					<c:choose>
						<c:when test="${!addressModel.entries.isEmpty() && addressModel.entries.get(0).name.compareTo('') != 0}"><c:set var="abc" value="${addressModel.entries.get(0).name.charAt(0)}"/></c:when>
						<c:otherwise><c:set var="abc" value=""/></c:otherwise>
					</c:choose>
					<%-- für jeden Adressbucheintrag --%>
					<c:forEach var="address" items="${addressModel.entries}" varStatus="status">
						<c:set var="firstLetter" value="${address.name.compareTo('') != 0 ? address.name.charAt(0) : ''}"/>
                        <c:choose>
							<c:when test="${status.index != 0 && abc == firstLetter}"><c:set var="anchor" value=""/></c:when>
							<c:otherwise><c:set var="anchor" value="${firstLetter}"/></c:otherwise>
						</c:choose>			
						<li class="one-col" id="${anchor}">
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="full-name-${address.id}" >
									${address.name}<c:if test="${address.name.compareTo('') != 0 && address.prename.compareTo('') != 0}">,&nbsp;</c:if>${address.prename}&nbsp;&nbsp;(${address.username})
								</h2>
								<a class="right box-link" href="mailto:${address.email}">
                                    <span>E-Mail</span>
                                    <span id="submit-${status.index}" class="forward-raquo menu-link right"></span>
                                </a>
								<div class="box-body toggle-content box-borders-bottom" style="display: none;">
									<ul class="address-list">
								        <li class="first two-col">
								            <fieldset class="first">
								                <div class="address">
								                    ${address.prename}&nbsp;${address.name}
								                </div>
								                <div class="address">
								                    ${address.street}&nbsp;<c:if test="${address.nr != 0}">${address.nr}</c:if>
								                </div>
								                <div class="address">
								                    <c:if test="${address.zipcode != 0}">${address.zipcode}&nbsp;</c:if>${address.city}
								                </div>
								            </fieldset>
								        </li>
								        <li class="last two-col">
								            <fieldset class="last clearfix">
								            	<div class="address">
								                    <a href="mailto:${address.email}">${address.email}</a>
								                </div>
								                <div class="address">
								                    ${address.mobile}
								                </div>
								                <div class="address">
								                     ${address.phone}
								                </div>
								                <div class="address">
								                     ${address.birthday}
								                </div>
								            </fieldset>
								        </li>
								    </ul>
									<%-- wenn Admin oder bei eigener Adresse --%>
								    <c:if test="${isAdmin == 1 || address.username == username}">
									    <sf:form action="${linkAddressEdit}${address.id}/" method="GET" style="display: inline-block">
											<button type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Eintrag Bearbeiten</button>
										</sf:form>
										<form action="${linkAddressDelete}${address.id}/" method="GET" style="display: inline-block">
											<button type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Account Löschen</button>
										</form>
									</c:if>
									<form action="mailto:${address.email}" style="display: inline-block">
										<button type="submit" class="dark-bg email-button"><div class="forward-raquo menu-link right"></div>E-Mail</button>
									</form>
								</div>
							</div>
						</li>
						<c:choose>
							<c:when test="${abc != firstLetter}"><c:set var="abc" value="${firstLetter}"/></c:when>
							<c:otherwise><c:set var="abc" value="${abc}"/></c:otherwise>
						</c:choose>
					</c:forEach>
					<%-- end all entries --%>
				</ul>
                <%-- end Contentbox One-Col Dropdown --%>
            </div>
        </div>
    </div>
</div>
<%-- end main Content small--%>
		</div>
		</div>
		</div>
		</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>	
		<%-- javascript, das nach Laden ausgeführt werden soll --%>
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>
