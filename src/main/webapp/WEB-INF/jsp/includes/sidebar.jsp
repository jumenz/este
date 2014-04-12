<%@include file="../includes/taglibs_variables.jspf" %>

<%-- 
	Sidebar der Seite 
	Beim Includieren der Sidebar können folgende Parameter übergeben werden:
	
	sidebarTitle	-	Titel der Sidebar
	nav				-	zur Angabe des Screennames für die Links 
	ref				- 	zur Angabe des Links auf den verlinkt werden soll
						WICHTIG: nav und ref müssen in richtiger Reihenfolge angegeben werden
						-> das erste nav gehört zum ersten ref usw.
	abc				- 	auf "include" setzen, um die Alphabetfläche in der Sidebar anzuzeigen
	search			-	auf "include" setzen
--%>
<div id="sidebar" class="content-layout-cell sidebar">
    <div class="outer">
        <div class="inner">
            <div class="content-list dark-bg toggle-item">
            	<%-- Titel breites Display --%>
                <h2 class="sidebar-title display-desktop">${param.sidebarTitle }</h2>
                <%-- Titel schmales Display --%>
                <div id="menu-div" class="menublock-sidebar hidden-desktop toggle">
                    <h2 class="menu-title link" id="menu-sidebar" >${param.sidebarTitle }</h2>
                </div>
                           
               <%-- Sidebar Menu --%>
               <c:set var="navList" scope="request" value="${param.nav}"/>
               <c:set var="navRefs" scope="request" value="${param.ref}"/>
				<div id="box-menu-sidebar" class="menublock-sidebar menu-sidebar light-bg">
					<ul class="menu">
						<%-- links in sidebar navigation --%>
						<c:forEach var="linkName" items="${navList}" varStatus="status">
							<li>
								<c:set var="index" value="status.index"/>
								<a href='<c:out value="${navRefs[num].index}"/>'>
									<span>${linkName}</span>
									<span class="forward-raquo menu-link right"></span>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<%-- Ende Sidebar Menu --%>
				
				<%--  Search Field  --%>
				<c:set var="searchSetting" scope="request" value="${param.search}"/>
				<c:if test="${searchSetting == 'include'}">
				<c:set var="searchLink" scope="request" value="${param.searchLink}"/>
				<div class="menublock-sidebar">
					<form method="GET" action="${searchLink}">
						<input name="search" placeholder="Suchen ..."/>
						<button type="submit" style="display: none"></button>
					</form>
				</div>
				</c:if>
				<%-- Ende Suchfelde --%>
				
				<%-- Alphabet --%>
				<c:set var="abcSetting" scope="request" value="${param.abc}"/>
				<c:if test="${abcSetting == 'include'}">
	                <%-- ABC --%>
	                <div class="menublock-sidebar timer">
	                    <div class="timer-inner">
	                        <ul class="timer-content">
	                        	<%-- ABC durchlaufen und jeden Buchstaben als Link bereitstellen --%>
	                        	<%  for(int c = 65; c <= 90; c++) { 
	                        		String str = "" + (char) c;
	                        	%>
	                                <li>
	                                    <a href=<%= "#" + str %> id=<%= "item-" + str %> class="timer-link">
	                                        <div class="list-item bg">
	                                            <span><%= str %></span>
	                                        </div>
	                                    </a>
	                                </li>
	                            <% } %>
	                        </ul>
	                    </div>
	                </div>
	            </c:if>
	            <c:remove var="abcSetting"/>
				<%-- Ende Alphabet --%>

            </div>
        </div>
    </div>
</div>
