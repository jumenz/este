<%-- 
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Ellen Schwartau
	@author Julia Menzel
 --%>
<%@include file="./taglibs_variables.jspf" %>
<head>
	<%-- common settings --%>
	<%-- common settings for the head-element --%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Content-language" content="de" />
	
	<%-- Info hierzu auf: http://seo.module23.com/seo.html --%>
	<meta name="base" content="http://www.damen-este0670.de" />
	<meta name="keywords" content="Fußball, Frauen, Damen, Frauenmannschaft, Este, 06/70, Hamburg, Sport, Verein" />
	<meta name="copyright" content="Este 06/70 Frauen" />
	<meta name="city" content="Hamburg" />
	<meta name="state" content="Hamburg" />
	<meta name="zipcode" content="21129" />
	<meta name="geo.region" content="DE-HH" />
	<meta name="geo.placename" content="Hamburg" />
	<meta name="geo.position" content="53.5162;9.80963" />
	<meta name="ICBM" content="53.5162, 9.80963" />
	
	<%-- stylesheets --%>
	<link rel="stylesheet" type="text/css" href="${cssPath}/content.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/header.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/footer.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/addresses.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/post.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/login-register.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/sidebar.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/calendar.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/documents.css"/>
	<link rel="stylesheet" type="text/css" href="${cssPath}/about-us.css"/>
	
	<%-- script --%>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${jsPath}/common.js"></script>
	<script type="text/javascript" src="${jsPath}/display.js"></script>
	<script type="text/javascript" src="${jsPath}/FormController.js"></script>

	<%-- others --%>
	<link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />
	
	<%-- page specific settings --%>
	<title>Este Frauen | ${param.title}</title>
	<meta name="description" content="
		${param.description}
	">
</head>