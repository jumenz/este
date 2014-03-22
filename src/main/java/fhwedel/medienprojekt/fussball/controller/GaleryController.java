package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class GaleryController {
	
	/**
	 * Lädt die Galerie
	 * @return string page name
	 */
	@RequestMapping(value="/galerie/", method=RequestMethod.GET)
	public String displayGalery() {
		return "galery";
	}
	
	/**
	 * Lädt das Formular zum hinzufügen neuer Bilder in die Bildergalerie.
	 * @return string jsp
	 */
	@RequestMapping(value="/galerie/upload/", method=RequestMethod.GET)
	public String displayGaleryImgUploadForm() {
		return "galeryImgUpload";
	}
	
	/**
	 * Speichert ein neues Bild in der Bildergalerie.
	 */
	@RequestMapping(value="/galerie/upload/", method=RequestMethod.POST)
	public String uploadImage(@RequestParam(value="image") MultipartFile image) {
		
		return "/galerie/";
	}
	
}
