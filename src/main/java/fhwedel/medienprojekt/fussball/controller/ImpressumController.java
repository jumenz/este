package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * ImpressumController
 * 
 * @author Ellen
 *
 */
@Controller
public class ImpressumController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkImpressum, method=RequestMethod.GET)
	public String displayImpressum() {
		return Constants.viewNameImpressum;
	}
}
