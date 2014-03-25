package fhwedel.medienprojekt.fussball.controller;

/**
 * Enthält die Links und ViewNames.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class Constants {
	/** Links */
	static final String linkHome = "/home/";
	static final String linkWelcome = "/willkommen/";
	static final String linkAdresses = "/adressbuch/";
	static final String linkAboutUs = "/ueber-uns/";
	static final String linkReports = "/berichte/";
	static final String linkReportsNext = "/berichte/weitere/";
	static final String linkReportsPrev = "/berichte/vorherige/";
	static final String linkReportsNew = "/berichte/verfassen/";
	static final String linkRegister = "/registrieren/";
	static final String linkRegisterSaveUser = "/registrieren/user-speichern/";
	static final String linkRegisterNewPermission = "/registrieren/email-zulassen/";
	static final String linkRegisterRemovePermission = "/registrieren/loeschen-";
	static final String linkLogin = "/login/";
	static final String linkLogout = "/logout/";
	static final String linkImpressum = "/impressum/";
	static final String linkLinks = "/links/";
	static final String linkGalerie = "/galerie/";
	static final String linkGalerieUpload = "/galerie/upload/";
	static final String linkForum = "/forum/";
	static final String linkForumNext = "/forum/weiteres/";
	static final String linkForumPrev = "/forum/vorheriges/";
	static final String linkForumNewEntry = "/forum/neuer-eintrag/";
	static final String linkForumNewComment = "/forum/neuer-kommentar/";

	/** Redirects */
	static final String redirectHome = "redirect:/home/";
	static final String redirectWelcome = "redirect:/willkommen/";
	static final String redirectAdresses = "redirect:/adressbuch/";
	static final String redirectAboutUs = "redirect:/ueber-uns/";
	static final String redirectReports = "redirect:/berichte/";
	static final String redirectReportsNext = "redirect:/berichte/weitere/";
	static final String redirectReportsPrev = "redirect:/berichte/vorherige/";
	static final String redirectReportsNew = "redirect:/berichte/verfassen/";
	static final String redirectRegister = "redirect:/registrieren/";
	static final String redirectLogin = "redirect:/login/";
	static final String redirectImpressum = "redirect:/impressum/";
	static final String redirectLinks = "redirect:/links/";
	static final String redirectGalerie = "redirect:/galerie/";
	static final String redirectGalerieUpload = "redirect:/galerie/upload/";
	static final String redirectForum = "redirect:/forum/";
	static final String redirectForumNext = "redirect:/forum/weiteres/";
	static final String redirectForumPrev = "redirect:/forum/vorheriges/";
	static final String redirectForumNewEntry = "redirect:/forum/neuer-eintrag/";
	
	/** View Names zum mappen der JSPs */
	static final String viewNameHome = "home";
	static final String viewNameWelcome = "welcome";
	static final String viewNameAdresses = "adresses";
	static final String viewNameForum = "forum";
	static final String viewNameForumNewEntry = "forumNewEntry";
	static final String viewNameReports = "reports";
	static final String viewNameReportsNew = "reportsNewEntry";
	static final String viewNameRegister = "register";
	static final String viewNameAboutUs = "aboutUs";
	static final String viewNameLogin = "login";
	static final String viewNameImpressum = "impressum";
	static final String viewNameLinks = "links";
	static final String viewNameGalerie = "galery";
	static final String viewNameGalerieUpload = "galeryImgUpload";
	
	/** Cookienames */
	static final String cookieUser = "user";
	static final String cookieUserState = "user_state";
}
