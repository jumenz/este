package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GaleryController {
	
	/**
	 * Lädt die Galerie
	 * @return string page name
	 */
	@RequestMapping("/galerie/")
	public String displayGalery() {
		return "galery";
	}
	
	/**
	 * Lädt das Formular zum hinzufügen neuer Bilder in die Bildergalerie.
	 * @return string jsp
	 */
	@RequestMapping("/galerie/upload/")
	public String displayGaleryImgUploadForm() {
		
		return "galeryImgUpload";
	}
}
