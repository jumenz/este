<%@include file="../includes/taglibs_variables.jspf" %>

<!-- 
	Sidebar der Seite 
	Beim Includieren der Sidebar können folgende Parameter übergeben werden:
	
	sidebarTitle	-	Titel der Sidebar
	nav				-	zur Angabe des Screennames für die Links 
	ref				- 	zur Angabe des Links auf den verlinkt werden soll
						WICHTIG: nav und ref müssen in richtiger Reihenfolge angegeben werden
						-> das erste nav gehört zum ersten ref usw.
	timer 			- 	auf "include" setzen, um den Kalender in der Sidebar anzuzeigen
	abc				- 	auf "include" setzen, um die Alphabetfläche in der Sidebar anzuzeigen
-->
<div id="sidebar" class="content-layout-cell sidebar">
    <div class="outer">
        <div class="inner">
            <div class="content-list dark-bg toggle-item">
                <h2 class="sidebar-title display-desktop">${param.sidebarTitle }</h2>
                <div id="menu-div" class="menublock-sidebar hidden-desktop toggle">
                    <h2 class="menu-title link" id="menu-sidebar" >${param.title }</h2>
                </div>              
                           
               <!-- Sidebar Menu -->
               <%  
					String[] navList = request.getParameterValues("nav");
               		String[] navRefs = request.getParameterValues("ref");
               		int current = 0;
				%> 
				<div id="box-menu-sidebar" class="menublock-sidebar menu-sidebar light-bg">
					<ul class="menu">
						<!-- links in sidebar navigation -->
						<% for (String item : navList) {  %>
							<li>
								<a href=<%= navRefs[current] %>>
									<span><%= item %></span>
									<span class="forward-raquo menu-link right"></span>
								</a>
							</li>
						<% current++;} %>
					</ul>
				</div>
				<script type="text/javascript">
					var menuVisible = 0;
					$(function() {
						$('#menu-sidebar').click(function(e){
							e.preventDefault();
							if (menuVisible === 0) {
								// Box is currently hidden, show it:
								$('#box-menu-sidebar').slideDown(200);
								menuVisible = 1;
							} else {
								// Box is currently shown, hide it:
								$('#box-menu-sidebar').slideUp(200);
								menuVisible = 0;
							}
						});
					});
				</script>
				<!-- end Sidebar Menu -->
				
				<!-- include Timer if timer is set true -->
				<c:set var="timerSetting" scope="request" value="${param.timer}"/>
				<c:if test="${timerSetting == 'include'}">
				   <!-- Timer -->
					<div class="menublock-sidebar timer">
						<div class="timer-inner">
							<ul class="timer-menu display-desktop">
								<li>
									<a href="#" class="back">
										<div class="back-raquo menu-link left"></div>
									</a>
								</li>
								<li class="center">
									<span>2013</span>
								</li>
								<li>
									<a href="#" class="forward">
										<div class="forward-raquo menu-link right"></div>
									</a>
								</li>
							</ul>
							<ul class="timer-content">
								<li class="hidden-desktop double-width">
									<a href="#" class="timer-link">
										<div class="list-item bg double-width">
											<span>2012</span>
										</div>
									</a>
								</li>
								<% Integer i; for ( i=1; i<=12; i++ ) { %>
									<li>
										<a href="#" id=<%= "item-" + i.toString() %> class="timer-link">
											<div class="list-item bg">
												<span>
													<%= i %>
												</span>
											</div>
										</a>
									</li>
								<% } %>
								<li class="hidden-desktop double-width">
									<a href="#" class="timer-link">
										<div class="list-item bg double-width">
											<span>2014</span>
										</div>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- end Timer -->
				</c:if>
				<c:remove var="timerSetting"/>
				
				<!-- Search Field 
				<div class="menublock-sidebar">
					<form method="GET">
						<input size="25" name="search" data-default="Suchen ..."/>
						<button type="submit" style="display: none"></button>
					</form>
				</div> -->
				
				<!-- include ABC if abc is set true -->
				<c:set var="abcSetting" scope="request" value="${param.abc}"/>
				<c:if test="${abcSetting == 'include'}">
	                <!-- ABC -->
	                <div class="menublock-sidebar timer">
	                    <div class="timer-inner">
	                        <ul class="timer-content">
	                        	<%  for(int c = 65; c <= 90; c++) { 
	                        		String str = "" + (char) c;
	                        	%>
	                                <li>
	                                    <a href=<%= str %> id=<%= "item-" + str %> class="timer-link">
	                                        <div class="list-item bg">
	                                            <span><%= str %></span>
	                                        </div>
	                                    </a>
	                                </li>
	                            <% } %>
	                        </ul>
	                    </div>
	                </div>
	
	                <!-- end ABC -->
	            </c:if>
	            <c:remove var="abcSetting"/>
            </div>
        </div>
    </div>
</div>
