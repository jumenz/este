package fhwedel.medienprojekt.fussball.controller;

/**
 * Enthält die Links und ViewNames.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class Constants {
	/** Links */
	static final String linkClassPath = "/";
	static final String linkHome = "/home/";
	static final String linkWelcome = "/willkommen/";
	static final String linkAddresses = "/adressbuch/";
	static final String linkAddressEdit = "/adressbuch/bearbeiten/{id}";
	static final String linkAddressDelete = "/adressbuch/loeschen/{id}/";
	static final String linkAboutUs = "/ueber-uns/";
	static final String linkAboutUsEdit = "/ueber-uns/bearbeiten/";
	static final String linkReports = "/berichte/";
	static final String linkReportsSearch ="/berichte/suche";
	static final String linkReportsStartingWith ="/berichte/#{sub}";
	static final String linkReportsContaining ="/berichte/~{sub}";
	static final String linkReportsPage = "/berichte/seite-{page}/";
	static final String linkReportsNew = "/berichte/verfassen/";
	static final String linkReportsEdit = "/berichte/bearbeiten/{id}/";
	static final String linkReportsDelete = "/berichte/loeschen/{id}/";
	static final String linkRegister = "/registrieren/";
	static final String linkRegisterSaveUser = "/registrieren/user-speichern/";
	static final String linkRegisterNewPermission = "/registrieren/email-zulassen/";
	static final String linkRegisterRemovePermission = "/registrieren/loeschen-";
	static final String linkRegisterChangeUserStatus = "/registrieren/status-";
	static final String linkLogin = "/login/";
	static final String linkLogout = "/logout/";
	static final String linkImpressum = "/impressum/";
	static final String linkImpressumEdit = "/impressum/bearbeiten/";
	static final String linkLinks = "/links/";
	static final String linkGalery = "/galerie/";
	static final String linkGaleryUploadForm = "/galerie/upload/";
	static final String linkGaleryUpload = "/galerie/load/";
	static final String linkForum = "/forum/";
	static final String linkForumSearch = "/forum/suche";
	static final String linkForumPage = "/forum/seite-{page}/";
	static final String linkForumNewEntry = "/forum/neuer-eintrag/";
	static final String linkForumEntryEdit = "/forum/bearbeiten/{id}/";
	static final String linkForumEntryDelete = "/forum/loeschen/{id}/";
	static final String linkForumStartingWith = "/forum/#{sub}";
	static final String linkForumContaining = "/forum/~{sub}";
	static final String linkForumNewComment = "/forum/neuer-kommentar/{id}/{author}/";
	static final String linkForumDeleteComment = "/forum/kommentar-entfernen/{id}/";

	/** Redirects */
	static final String redirectHome = "redirect:/home/";
	static final String redirectWelcome = "redirect:/willkommen/";
	static final String redirectAddresses = "redirect:/adressbuch/";
	static final String redirectAboutUs = "redirect:/ueber-uns/";
	static final String redirectReports = "redirect:/berichte/";
	static final String redirectReportsNext = "redirect:/berichte/weitere/";
	static final String redirectReportsPrev = "redirect:/berichte/vorherige/";
	static final String redirectReportsNew = "redirect:/berichte/verfassen/";
	static final String redirectRegister = "redirect:/registrieren/";
	static final String redirectLogin = "redirect:/login/";
	static final String redirectImpressum = "redirect:/impressum/";
	static final String redirectLinks = "redirect:/links/";
	static final String redirectGalery = "redirect:/galerie/";
	static final String redirectGaleryUpload = "redirect:/galerie/upload/";
	static final String redirectForum = "redirect:/forum/";
	static final String redirectForumNext = "redirect:/forum/weiteres/";
	static final String redirectForumPrev = "redirect:/forum/vorheriges/";
	static final String redirectForumNewEntry = "redirect:/forum/neuer-eintrag/";
	
	/** View Names zum mappen der JSPs */
	static final String viewNameHome = "home";
	static final String viewNameWelcome = "welcome";
	static final String viewNameAddresses = "addresses";
	static final String viewNameAddressEdit = "addressEdit";
	static final String viewNameForum = "forum";
	static final String viewNameForumEdit = "forumEntryEdit";
	static final String viewNameReports = "reports";
	static final String viewNameReportsEdit = "reportEdit";
	static final String viewNameRegister = "register";
	static final String viewNameAboutUs = "aboutUs";
	static final String viewNameAboutUsEdit = "aboutUsEdit";
	static final String viewNameLogin = "login";
	static final String viewNameImpressum = "impressum";
	static final String viewNameImpressumEdit = "impressumEdit";
	static final String viewNameLinks = "links";
	static final String viewNameGalery = "galery";
	static final String viewNameGaleryUpload = "galeryImgUpload";
	
	/** Cookienames */
	static final String cookieUser = "user";
	static final String cookieUserState = "user_state";
}
