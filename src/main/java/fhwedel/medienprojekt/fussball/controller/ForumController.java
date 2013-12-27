package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fhwedel.medienprojekt.fussball.model.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.model.forum.ForumView;

@Controller
public class ForumController {
	
	/**
	 * Lädt das Forum
	 * @return string page name
	 */
	@RequestMapping("/forum/")
	public String displayForum(Model model) {
		ForumView view = new ForumView();
		ForumEntry entry = new ForumEntry();
		entry.setTopic("Forum Eintrag");
		view.addEntry(entry);	
		
		model.addAttribute("forumModel", view);
		
		return "forum";
	}
}
