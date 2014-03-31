<%@include file="./includes/taglibs_variables.jspf" %>
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

<!--  ${method} Variable setzen       
<c:choose>
	<c:when test="${adress['new']}"><c:set var="method" value="post"/></c:when>
	<c:otherwise><c:set var="method" value="put"/></c:otherwise>
</c:choose>
 --> 

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
                               href="mailto:${user.email}"> <!-- TODO an alle mailto:ABSENDER?bcc=EMAIL,%20EMAIL&amp;subject=Este%2006/70%20-%20Frauen -->
                            	<span>E-Mail</span>
                            </a>
							<div id="submit-${status.index}" class="box-link forward-raquo menu-link right toggle"></div>
                        </div>
                    </li>
					<!-- Edit address form -->
					<c:set var="updateAddress" value="${updateAddress}"/>
					<sf:form action="${linkAddressesEdit}${address.id}/" method="POST" modelAttribute="updateAddress">
					<!-- all entries -->
						<c:forEach var="address" items="${addressModel.entries}" varStatus="status">
							<li class="one-col">
								<div  class="main-content-box box-borders-top bg clearfix toggle-item">
									<h2 class="box-title link toggle" id="full-name-${address.id}" >${address.name}, ${address.prename}</h2>
									<a class="right box-link" href="mailto:MAIL"><!-- TOD0 MAIL -->
	                                    <span>E-Mail</span>
	                                </a>
									<div id="submit-${status.index}" class="box-link forward-raquo menu-link right toggle"></div>
								</div>
								<!-- TOD0 if admin or id==id -->
								<div class="toggle-content box-borders-bottom box-body" style="display: none">
								    <ul>
								        <li class="first two-col">
								            <fieldset class="first">
								                <div class="form-item">
								                    <p class="input">
														<sf:input 	path="prename"
																	data-default="Vorname *"
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
																	data-default="Name *"
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
																	data-default="Straße"
																	value="${address.street}"
																	class="input input-text"
														/><br>
														<sf:errors path="street" cssClass="error"/>
														<sf:input 	path="nr"
																	id="nr"
																	data-default="Nr."
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
																	data-default="PLZ"
																	value="${address.zipcode}"
																	class="input input-text"
														/><br>
														<sf:errors path="zipcode" cssClass="error"/>
														<sf:input 	path="city"
																	id="city"
																	data-default="Ort"
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
								                <div class="form-item required">
								                    <p class="input">
														<sf:input 	path="email"
																	id="email"
																	data-default="E-Mail *"
																	value="${address.email}"
																	class="input input-text required-entry"
														/><br>
														<sf:errors path="email" cssClass="error"/>
								                    </p>
								                </div>
								                <div class="form-item">
								                    <p class="input">
														<sf:input 	path="phone"
																	id="phone"
																	data-default="Festnetznummer (040-123456)"
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
																	data-default="Handynummer (0160-123456)"
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
																	data-default="Geburtsdatum"
																	value="${address.birthday}"
																	class="input input-text"
														/><br>
														<sf:errors path="birthday" cssClass="error"/>
								                    </p>
								                </div>
								            </fieldset>
								        </li>
								    </ul>
								    <hr />
								    <fieldset id="buttons">
								        <div class="form-submit">
								            <p id="required">* Pflichtfelder</p>
								            <p>
								                <sf:input 	path="id"
															id="id"
															value="${address.id}"
															class="input input-text hidden"
															cssStyle="display:none"
												/>
							                    <button class="dark-bg" type="reset" name="reset" value="reset"><div class="forward-raquo menu-link right"></div>Zurücksetzen</button>
							                    <button class="dark-bg" type="submit" name="commit" value="delete"><div class="forward-raquo menu-link right"></div>Eintrag Löschen</button>
							                    <button class="dark-bg" type="submit" name="commit" value="update"><div class="forward-raquo menu-link right"></div>Aktualisieren</button>
							                </p>
							            </div>
							        </fieldset>
								</div>
								<!-- TOD0 else 
								<div class="box-body toggle-content box-borders-bottom" style="display: none;">
									<p>
									    ${address.prename}&nbsp;${address.name}<br />
									    ${address.street}&nbsp;<c:if test="${address.nr}!=0">${address.nr}</c:if><br />
									    <c:if test="${address.zipcode}!=0">${address.zipcode}&nbsp;</c:if>${address.city}<br />
									    <a href="mailto:${user.email}">${user.email}</a><br />
									    ${address.mobile}<br />
									    ${address.phone}<br /><br />
									    ${address.birthday}
								    </p>
								</div>
								-->
								<!-- TOD0 endif -->
							</li>
						</c:forEach>
						<!-- end all entries -->
				    </sf:form>
					<!-- end edit address form -->
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
