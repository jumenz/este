package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import fhwedel.medienprojekt.fussball.controller.Constants;

@Controller
public class GaleryController {
	
	/**
	 * Lädt die Galerie
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkGalerie, method=RequestMethod.GET)
	public String displayGalery() {
		return Constants.viewNameGalerie;
	}
	
	/**
	 * Lädt das Formular zum hinzufügen neuer Bilder in die Bildergalerie.
	 * @return string jsp
	 */
	@RequestMapping(value=Constants.linkGalerieUpload, method=RequestMethod.GET)
	public String displayGaleryImgUploadForm() {
		return Constants.viewNameGalerieUpload;
	}
	
	/**
	 * Speichert ein neues Bild in der Bildergalerie.
	 */
	@RequestMapping(value=Constants.linkGalerieUpload, method=RequestMethod.POST)
	public String uploadImage(@RequestParam(value="image") MultipartFile image) {
		
		return Constants.viewNameGalerie;
	}
	
}
