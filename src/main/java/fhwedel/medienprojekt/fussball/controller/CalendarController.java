package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;



/**
 * CalendarController
 * 
 * @author Julia Menzel minf9950
 **/
@Controller
public class CalendarController {
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Lädt die Kalender Seite
	 * 
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value=Constants.linkCalendar, method=RequestMethod.GET)
	public String displayCalendar(Model model) {
		return  Constants.viewNameCalendar;
	}
}