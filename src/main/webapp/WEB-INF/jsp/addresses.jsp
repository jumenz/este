<%@include file="./includes/taglibs_variables.jspf" %>
<c:set var="isAdmin" value="1"/>
<c:set var="userMail" value="ellen@example.com"/>
<c:set var="userId" value="1"/>
<html>
<jsp:include page="./includes/head.jsp">
	<jsp:param name="title" value="Adressbuch"/>
	<jsp:param name="description" value="Adressbuch"/>
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
		<jsp:param name="sidebarTitle" value="Adressbuch"/>
		<jsp:param name="abc" value="include" />
		<jsp:param name="nav" value="Liste"/>
		<jsp:param name="ref" value="#" />
		</jsp:include>
		<!-- end Sidebar -->

<!-- main Content small-->
<div id="main-content-small" class="content-layout-cell main-content main-content-small">
    <div class="outer">
        <div class="inner">
            <div id="addressbook" class="content-list">
                <!--Contentbox One-Col Dropdown -->
                <ul>
				<!-- <li class="one-col">
					<!-- mail @all -->
                	<li class="one-col">
                        <div class="main-content-box box-borders-top bg clearfix">
                            <h2 class="box-title link" >Alle</h2>
                            <a class="right box-link"
                               href="mailto:${userMail}"> <!-- ?bcc=EMAIL,%20EMAIL&amp;subject=Este%2006/70%20-%20Frauen"> -->
                            	<span>E-Mail</span>
                            	<span id="submit-all" class="forward-raquo menu-link right"></span>
                            </a>
							<div id="submit-${status.index}" class="box-link forward-raquo menu-link right toggle"></div>
                        </div>
                    </li>
					<c:choose>
						<c:when test="${!addressModel.entries.isEmpty() && addressModel.entries.get(0).name.compareTo('') != 0}"><c:set var="abc" value="${addressModel.entries.get(0).name.charAt(0)}"/></c:when>
						<c:otherwise><c:set var="abc" value=""/></c:otherwise>
					</c:choose>
					<c:forEach var="address" items="${addressModel.entries}" varStatus="status">
						<c:set var="firstLetter" value="${address.name.compareTo('') != 0 ? address.name.charAt(0) : ''}"/>
                        <c:choose>
							<c:when test="${status.index != 0 && abc == firstLetter}"><c:set var="anchor" value=""/></c:when>
							<c:otherwise><c:set var="anchor" value="${firstLetter}"/></c:otherwise>
						</c:choose>			
						<li class="one-col" id="${anchor}">
							<div  class="main-content-box box-borders-top bg clearfix toggle-item">
								<h2 class="box-title link toggle" id="full-name-${address.id}" >
									${address.name}<c:if test="${address.name.compareTo('') != 0 && address.prename.compareTo('') != 0}">,&nbsp;</c:if>${address.prename}
								</h2>
								<a class="right box-link" href="mailto:MAIL"><!-- TOD0 MAIL -->
                                    <span>E-Mail</span>
                                    <span id="submit-${status.index}" class="forward-raquo menu-link right"></span>
                                </a>
								<!-- TOD0 if admin or id==id for each address -->
								<c:choose>
								<c:when test="${isAdmin == 1 || address.id == userId}">
									<div class="toggle-content box-borders-bottom box-body" style="display: none">
										<form action="${linkAddressesDelete}${address.id}/" method="GET">
											<button class="dark-bg"><div class="forward-raquo menu-link right"></div>Eintrag Löschen</button>
										</form>
										<!-- Edit address form-->
										<c:set var="updateAddressModel" value="${updateAddressModel}"/>
										<sf:form action="${linkAddresses}${address.id}" method="POST" modelAttribute="updateAddressModel">
									    	<ul>
										        <li class="first two-col">
										            <fieldset class="first">
										                <div class="form-item">
										                    <p class="input">
																<sf:input 	path="prename"
																			placeholder="Vorname *"
																			id="prename"
																			value="${address.prename}"
																			class="input input-text required-entry"
																/><br>
																<sf:errors path="prename" cssClass="error"/>
										                    </p>
										                </div>
										                <div class="form-item">
										                    <p class="input">
																<sf:input 	path="name"
																			id="name"
																			placeholder="Name *"
																			value="${address.name}"
																			class="input input-text required-entry"
																/><br>
																<sf:errors path="name" cssClass="error"/>
										                    </p>
										                </div>
										                <div class="form-item">
										                    <p class="input">
																<sf:input 	path="street"
																			id="street"
																			placeholder="Straße"
																			value="${address.street}"
																			class="input input-text"
																/><br>
																<sf:errors path="street" cssClass="error"/>
																<sf:input 	path="nr"
																			id="nr"
																			placeholder="Nr."
																			value="${address.nr}"
																			class="input input-text"
																/><br>
																<sf:errors path="nr" cssClass="error"/>
										                    </p>
										                </div>
										                <div class="form-item">
										                    <p class="input">
																<sf:input 	path="zipcode"
																			id="zipcode"
																			placeholder="PLZ"
																			value="${address.zipcode}"
																			class="input input-text"
																/><br>
																<sf:errors path="zipcode" cssClass="error"/>
																<sf:input 	path="city"
																			id="city"
																			placeholder="Ort"
																			value="${address.city}"
																			class="input input-text"
																/><br>
																<sf:errors path="city" cssClass="error"/>
										                    </p>
										                </div>
										            </fieldset>
										        </li>
										        <li class="last two-col">
										            <fieldset class="last clearfix">
										                <div class="form-item">
										                    <p class="input">
																<sf:input 	path="phone"
																			id="phone"
																			placeholder="Festnetznummer (040-123456)"
																			value="${address.phone}"
																			class="input input-text"
																/><br>
																<sf:errors path="phone" cssClass="error"/>
										                    </p>
										                </div>
										                <div class="form-item">
										                     <p class="input">
																<sf:input 	path="mobile"
																			id="mobile"
																			placeholder="Handynummer (0160-123456)"
																			value="${address.mobile}"
																			class="input input-text"
																/><br>
																<sf:errors path="mobile" cssClass="error"/>
										                    </p>
										                </div>
										                <div class="form-item">
										                     <p class="input">
																<sf:input 	path="birthday"
																			id="birthday"
																			placeholder="Geburtsdatum"
																			value="${address.birthday}"
																			class="input input-text"
																/><br>
																<sf:errors path="birthday" cssClass="error"/>
										                    </p>
										                </div>
										            </fieldset>
										        </li>
										    </ul>
										    <p id="required">* Pflichtfelder</p>
											<sf:input 	path="id"
														value="${address.id}"
														class="hidden"
											/><br>
										    <button class="dark-bg" type="submit" name="commit" value="update"><div class="forward-raquo menu-link right"></div>Aktualisieren</button>
									        <button class="dark-bg" type="reset" name="reset" value="reset"><div class="forward-raquo menu-link right"></div>Zurücksetzen</button>
										</sf:form>
									</div>
								<!-- end edit address form -->
								</c:when>
								<c:otherwise>
									<div class="box-body toggle-content box-borders-bottom" style="display: none;">
										<p>
										    ${address.prename}&nbsp;${address.name}<br />
										    ${address.street}&nbsp;<c:if test="${address.nr != 0}">${address.nr}</c:if><br />
										    <c:if test="${address.zipcode != 0}">${address.zipcode}&nbsp;</c:if>${address.city}<br />
										    <a href="mailto:${user.email}">${user.email}</a><br />
										    ${address.mobile}<br />
										    ${address.phone}<br /><br />
										    ${address.birthday}
										    <c:if test="${isAdmin == 1 || address.id == userId}">
												<form action="${linkAddressesDelete}${address.id}/" method="GET">
													<button class="dark-bg"><div class="forward-raquo menu-link right"></div>Eintrag Löschen</button>
												</form>
												<form action="${linkAddressEdit}${address.id}/" method="GET">
													<button class="dark-bg"><div class="forward-raquo menu-link right"></div>Eintrag Bearbeiten</button>
												</form>
											</c:if>
									    </p>
									</div>
								</c:otherwise>
								</c:choose>
							</div>
						</li>
						<c:choose>
							<c:when test="${abc != firstLetter}"><c:set var="abc" value="${firstLetter}"/></c:when>
							<c:otherwise><c:set var="abc" value="${abc}"/></c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- end all entries -->
				</ul>
                <!-- end Contentbox One-Col Dropdown -->
            </div>
        </div>
    </div>
</div>
<!-- end main Content small-->
		</div>
		</div>
		</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="./includes/footer.jsp"/>	
		<!-- javascript, das nach Laden ausgeführt werden soll -->
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>
