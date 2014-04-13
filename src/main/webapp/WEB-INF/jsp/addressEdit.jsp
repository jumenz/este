<%@include file="./includes/taglibs_variables.jspf" %>
<%-- Admin --%>
<security:authorize access="hasRole('USER_GROUP_ADMIN')">
    <c:set var="isAdmin" value="1"/>
</security:authorize>
<%-- User --%>
<security:authentication property="principal.username" var="username" scope="request"/>
<html>
	<jsp:include page="./includes/head.jsp">
		<jsp:param name="title" value="Forum"/>
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
       
			<div id="edit-address" class="content-list">
				<ul>
					<%--Contentbox One-Col --%>
                    <li class="one-col">
                    	<div class="main-content-box box-borders bg clearfix">
                        	<h2 class="box-title">
                        		${addressEditModel.prename}
                        		<c:if test="${addressEditModel.name.compareTo('') != 0 && addressEditModel.prename.compareTo('') != 0}">,&nbsp;</c:if>
                        		${addressEditModel.name}
							</h2>
                            <div class="box-body">
                             	<%-- Address edit form --%>	
								<sf:form method="POST" modelAttribute="addressEditModel">
									<ul>
								        <li class="first two-col">
								            <fieldset class="first">
								                <div class="form-item">
								                    <p class="input">
														<sf:input 	path="prename"
																	placeholder="Vorname"
																	id="prename"
																	value="${addressEditModel.prename}"
																	class="input input-text"
														/><br>
														<sf:errors path="prename" cssClass="error"/>
								                    </p>
								                </div>
								                <div class="form-item">
								                    <p class="input">
														<sf:input 	path="name"
																	id="name"
																	placeholder="Name"
																	value="${addressEditModel.name}"
																	class="input input-text"
														/><br>
														<sf:errors path="name" cssClass="error"/>
								                    </p>
								                </div>
								                <div class="form-item">
								                    <p class="input">
														<sf:input 	path="street"
																	id="street"
																	placeholder="Straße"
																	value="${addressEditModel.street}"
																	class="input input-text"
														/><br>
														<sf:errors path="street" cssClass="error"/>
														<sf:input 	path="nr"
																	id="nr"
																	placeholder="Nr."
																	value="${addressEditModel.nr}"
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
																	value="${addressEditModel.zipcode}"
																	class="input input-text"
														/><br>
														<sf:errors path="zipcode" cssClass="error"/>
														<sf:input 	path="city"
																	id="city"
																	placeholder="Ort"
																	value="${addressEditModel.city}"
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
																	value="${addressEditModel.phone}"
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
																	value="${addressEditModel.mobile}"
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
																	value="${addressEditModel.birthday}"
																	class="input input-text"
														/><br>
														<sf:errors path="birthday" cssClass="error"/>
								                    </p>
								                </div>
								                <sf:input 	path="id"
															id="id"
															value="${addressEditModel.id}"
															class="hidden"
												/><br>
								            </fieldset>
								        </li>
								    </ul>
								    <p id="required">alle Felder sind Pflichtfelder</p>
								    <button class="dark-bg" type="submit" name="commit">
								    	<div class="forward-raquo menu-link right"></div>Aktualisieren
								    </button>
							        <button class="dark-bg" type="reset" name="reset">
							        	<div class="forward-raquo menu-link right"></div>Zurücksetzen
							        </button>
								</sf:form>
								<%-- end edit address form --%>
								<form action="${linkAddressDelete}${addressEditModel.id}/" method="GET" style="display: inline-block">
									<button type="submit" class="dark-bg"><div class="forward-raquo menu-link right"></div>Account Löschen</button>
								</form>
							</div>
						</div>
					</li>
				</ul>
            	<%-- end Contentbox One-Col Dropdown --%>
            </div>
        </div>
    </div>
</div>
<%-- end main Content small--%>
</div>
		
		<%-- footer --%>
		<jsp:include page="./includes/footer.jsp"/>	
		<%-- javascript, das nach Laden ausgeführt werden soll --%>
		<script type="text/javascript" src="${jsPath}/onLoad.js"></script>
	</body>
</html>
