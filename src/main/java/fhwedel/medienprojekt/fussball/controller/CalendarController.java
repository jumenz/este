/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Julia Menzel Minf9950
 */
package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;



/**
 * Controller
 * Übernimmt die Anzeige des Kalenders.
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