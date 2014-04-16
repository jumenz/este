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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
import org.springframework.beans.factory.annotation.Autowired;
import fhwedel.medienprojekt.fussball.service.TopPlayerService;
import org.springframework.ui.Model;
*/
import org.springframework.web.bind.annotation.RequestMethod;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Übernimmt die Anzeige der Home-Seite.
 */
@Controller
public class HomeController {
	/**
	 * Lädt die Home Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkHome, method=RequestMethod.GET)
	public String displayHome() {
		return Constants.viewNameHome;
	}
}
