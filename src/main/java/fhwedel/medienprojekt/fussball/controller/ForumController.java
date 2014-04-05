package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;






/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessComments;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessForum;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsForum;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller zur Anzeige des Forums.
 * @author Ellen Schwartau Minf9888
 *
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
	
	/* ------------------ Methoden --------------------------- */
	/* ------------------ Anzeige ---------------------------- */
	/**
	 * Hilfsfunktion.
	 * Fügt die Liste an einträgen dem Model an und stellt ein neues
	 * Comment Object bereit.
	 * @param 	list	ArrayList<ForumEntry>	Liste mit Foreneinträgen
	 * @param	model	Model
	 */
	public String prepareForumView(ArrayList<ForumEntry> list, Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// Kommentare laden
		this.dataAccessComments.getAllComments(list);
		
		for(int i=0; i<list.size(); i++) {
			// Einträge hinzufügen
			view.addEntry(list.get(i));
		}
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		// Neuen Kommentar anfügen, um Speichern zu ermöglichen
		model.addAttribute("newComment", new Comment());
		
		return Constants.viewNameForum;
	}
	
	/**
	 * Lädt das Forum
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value=Constants.linkForum, method=RequestMethod.GET)
	public String displayForum(Model model) {
		// Foreneinträge und Kommentare laden
		return this.prepareForumView(this.dataAccessForum.getAll(), model);
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * @param	sub		String		gesuchter Anfangsstring
	 * @param	model	Model
	 */
	@RequestMapping(value=Constants.linkForum + "{sub}", method=RequestMethod.GET)
	public String getForumEntriesStartingWith(@PathVariable String sub, Model model) {
		// Einträge aus der Datenbank auslesen, die mit Substring beginnen
		return this.prepareForumView(this.dataAccessForum.getAllStartingWith(sub), model);
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * @param	sub		String		gesuchter Substring
	 * @param	model	Model
	 */
	@RequestMapping(value=Constants.linkForum + "~{sub}", method=RequestMethod.GET)
	public String getForumEntriesIncluding(@PathVariable String sub, Model model) {
		return this.prepareForumView(this.dataAccessForum.getAllIncluding(sub), model);
	}
	
	/**
	 * Ermöglicht die Suche über das Suchfeld der Sidebar und leitet auf die 
	 * URL der Form "/forum/~<Sucheingabe>" weiter
	 * @param 	src		String nach dem gesucht wird
	 * @return	String	url auf die Redirect ausgeführt wird
	 */
	@RequestMapping(value=Constants.linkForum + "?search={src}", method=RequestMethod.GET)
	public String searchEntries(@PathVariable String src) {
		// Auf entsprechenden Pfad weiterleiten
		return Constants.redirectForum +"~" + src;
		// TODO geht noch nicht
	}
	
	/* ------------------ Neue Einträge -------------------------------- */
	/**
	 * Lädt das Formular zum Erstellen eines neuen Foreneintrags.
	 * @param 	model	Model
	 * @return	String	viewname
	 */
	@RequestMapping(value=Constants.linkForumNewEntry, method=RequestMethod.GET)
	public String displayNewForumEntryForm(Model model) {
		// Neues ForumEntry Objekt in jsp zugreifbar machen
		model.addAttribute(new ForumEntry());
		// Formular laden
		return Constants.viewNameForumEdit;
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
		// Report auslesen
		model.addAttribute("forumEntry", this.dataAccessForum.getById(id));
		return Constants.viewNameForumEdit;
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
		
		// jsp zum Erstellen eines neuen Berichts laden
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
		// TODO nicht über PathVariable
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
	public String saveNewForumComment(@PathVariable int id, Comment newComment, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
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
	public String deleteNewComment(@PathVariable int id) {
		this.dataAccessComments.deleteComment(id);
		return Constants.redirectForum;
	}

}
