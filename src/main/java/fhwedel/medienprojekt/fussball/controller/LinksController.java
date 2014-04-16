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
import org.springframework.web.bind.annotation.RequestMethod;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Übernimmt die Anzeige der Seite mit den weiterführenden Links. 
 */
@Controller
public class LinksController {
	
	/**
	 * Lädt die Seite mit verlinkten Links
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkLinks, method=RequestMethod.GET)
	public String displayLinks() {
		return Constants.viewNameLinks;
	}
}
