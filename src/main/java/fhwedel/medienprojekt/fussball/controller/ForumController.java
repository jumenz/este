/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fhwedel.medienprojekt.fussball.model.pagination.Page;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessComments;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessForum;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsComments;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsForum;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Übernimmt die Anzeige und Verarbeitung des Forums.
 */
@Controller
public class ForumController {
	/* ------------------ Klassenvariablen ------------------- */
	/** Services für die Datenbankarbeit */
	@Autowired
	private DataAccessForum dataAccessForum;
	
	@Autowired 
	private DataAccessComments dataAccessComments;
	
	/** Service für die Fehlerbehandlung */
	@Autowired
	private DataErrorsForum dataErrorsForum;
	
	@Autowired
	private DataErrorsComments dataErrorsComments;
	
	/** Anzahl der Einträge pro Seite */
	final int forumEntriesPerPage = 10;
	
	/* ------------------ Methoden --------------------------- */
	/* ------------------ Hilfsfunktionen ------------------- */
	/**
	 * Hilfsfunktion.
	 * Fügt die Liste an einträgen dem Model an und stellt ein neues
	 * Comment Object bereit.
	 * @param 	list	ArrayList<ForumEntry>	Liste mit Foreneinträgen
	 * @param	model	Model
	 */
	private String prepareForumView(Page<ForumEntry> page, Model model) {
		// Kommentare laden, mit Foreneintrag zugreifbar machen und anzeigen
		this.dataAccessComments.getAllCommentsForForumEntries(page.getPageItems());
		model.addAttribute("forumEntryPage", page);
		model.addAttribute("newComment", new Comment());
		
		return Constants.viewNameForum;
	}
	
	/**
	 * Hilfsfunktion.
	 * Lädt die Bearbeitungsseite eines Foreneintrags.
	 * @param 	entry	ForumEntry	Foreneintrag
	 * @param 	model	Model
	 * @return	String	ViewName des Bearbeitungsformulars
	 */
	private String prepareForumEdit(ForumEntry entry, Model model) {
		// Eintrag anfügen und Formular anzeigen
		model.addAttribute("forumEntry", entry);
		return Constants.viewNameForumEdit;
	}
	
	/* ------------------ Anzeige ---------------------------- */
	/**
	 * Lädt die erste Seite des Forums.
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value=Constants.linkForum, method=RequestMethod.GET)
	public String displayForum(Model model) {
		// erste Seite laden
		return this.displayForum(1, model);
	}
	
	/**
	 * Lädt eine bestimmte Seite des Forums.
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value=Constants.linkForumPage, method=RequestMethod.GET)
	public String displayForum(@PathVariable("page") int showPage, Model model) {
		// Erste Seite laden und anzeigen
		return this.prepareForumView(this.dataAccessForum.getPage(showPage, this.forumEntriesPerPage), model);
	}
	
	/**
	 * Liefert Foreneinträge, die einen bestimmten String beinhalten.
	 * @param	sub		String		gesuchter Substring
	 * @param	model	Model
	 */
	@RequestMapping(value=Constants.linkForumContaining, method=RequestMethod.GET)
	public String getForumEntriesIncluding(@PathVariable String sub, Model model) {
		// Suchergebnisse auf einer Seite anzeigen
		ArrayList<ForumEntry> res = this.dataAccessForum.getAllIncluding(sub);
		Page<ForumEntry> page = this.dataAccessForum.setPage(1, 1, 1, res);
		return this.prepareForumView(page, model);
	}
	
	/**
	 * Ermöglicht die Suche über das Suchfeld der Sidebar und leitet auf die 
	 * URL der Form "/forum/~<Sucheingabe>" weiter
	 * @param 	src		String nach dem gesucht wird
	 * @return	String	url auf die Redirect ausgeführt wird
	 */
	@RequestMapping(value=Constants.linkForumSearch, method=RequestMethod.GET)
	public String searchEntries(@RequestParam(value="search") String sub) {
		// Auf entsprechenden Pfad weiterleiten
		return Constants.redirectForum +"~" + sub;
	}
	
	/* ------------------ Neue Einträge -------------------------------- */
	/**
	 * Lädt das Formular zum Erstellen eines neuen Foreneintrags.
	 * @param 	model	Model
	 * @return	String	viewname
	 */
	@RequestMapping(value=Constants.linkForumNewEntry, method=RequestMethod.GET)
	public String displayNewForumEntryForm(Model model) {
		// Neues ForumEntry Objekt in jsp zugreifbar machen und Formular laden
		return this.prepareForumEdit(new ForumEntry(), model);
	}
	
	/**
	 * Speichert einen neuen Foreneintrag.
	 * @param	entry			ForumEntry		Eintrag der gespeichert werden soll
	 * @param	bindingResult	BindingResult
	 */
	@RequestMapping(value=Constants.linkForumNewEntry, method=RequestMethod.POST)
	public String saveNewForumEntry(@ModelAttribute("forumEntry") ForumEntry newEntry, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrorsForum.hasErrors(newEntry, bindingResult)) {
			return Constants.viewNameForumEdit;
		}
		
		// sonst speichern und Forum laden
		this.dataAccessForum.save(newEntry);
		
		return Constants.redirectForum;
	}
	
	/* --------------------- Bearbeiten ---------------------------- */
	/**
	 * Lädt das Formular zum editieren eines Foreneintrags.
	 * @param 	id		int		ID des Eintrags, der bearbeitet werden soll
	 * @param 	model	Model	
	 * @return	String	Viewname des Formulars
	 */
	@RequestMapping(value=Constants.linkForumEntryEdit, method=RequestMethod.GET)
	public String loadEditForm(@PathVariable int id, Model model) {
		// Foreneintrag auslesen und zu Bearbeitung anzeigen
		ForumEntry entry = this.dataAccessForum.getById(id);
		if (entry != null) {
			return this.prepareForumEdit(entry, model);
		}
		// Fall kein Foreneintrag unter der ID ausgelesen werden konnte 
		// wird das Forum angezeigt
		return Constants.redirectForum;
	}
	
	/**
	 * Updatet einen bearbeiteten Foreneintrag.
	 * @param 	id				int				Id des bearbeiteten Foreneintrags
	 * @param	forumEntry		ForumEntry		bearbeiteter Foreneintrag
	 * @param 	bindingResult	BindingResult	
	 * @return
	 */
	@RequestMapping(value=Constants.linkForumEntryEdit, method=RequestMethod.POST)
	public String edit(@PathVariable int id, @ModelAttribute("forumEntry") ForumEntry forumEntry, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors() || this.dataErrorsForum.hasErrors(forumEntry, bindingResult)) {
			return Constants.viewNameForumEdit;
		}
		
		// Speichern und Spielberichte laden
		this.dataAccessForum.update(id, forumEntry);
		
		return Constants.redirectForum;
	}
	
	/* --------------------- Löschen ------------------------------- */
	/**
	 * Löscht einen Foreneintrag aufgehend von seiner ID.
	 * @param 	id		int		ID des Foreneintrags
	 * @return	String	Redirect auf das Forum
	 */
	@RequestMapping(value=Constants.linkForumEntryDelete, method=RequestMethod.POST) 
	public String delete(@PathVariable int id) {
		// Löschen und Forum anzeigen
		this.dataAccessForum.deleteById(id);
		return Constants.redirectForum;
	}
	
	/* --------------------- Kommentare ---------------------------- */
	/**
	 * Speichert einen neuen Kommentar
	 * @param 	id				int				id des zugehörigen Foreneintrags
	 * @param 	newComment		Comment			zu speichernder Kommentar
	 * @param 	bindingResult	BindingResult
	 */
	@RequestMapping(value=Constants.linkForumNewComment, method=RequestMethod.POST)
	public String saveNewForumComment(@PathVariable("id") int id, @PathVariable("author") String author, Comment newComment, BindingResult bindingResult) {
		newComment.setAuthor(author);
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrorsComments.hasErrors(newComment, bindingResult)) {
			return Constants.viewNameForum;
		}
		
		// sonst speichern und Forum laden
		this.dataAccessComments.saveComment(newComment, id);
		
		return Constants.redirectForum;
	}
	
	/**
	 * Löscht einen Kommentar mit bestimmter Id.
	 * @param 	id	int		ID des Kommentars
	 * @return	String		Redirect auf Forenseite
	 */
	@RequestMapping(value=Constants.linkForumDeleteComment, method=RequestMethod.GET)
	public String deleteComment(@PathVariable int id) {
		// Löschen und Forum anzeigen
		this.dataAccessComments.deleteComment(id);
		return Constants.redirectForum;
	}

}
