package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.model.galery.Image;
import fhwedel.medienprojekt.fussball.service.exception.ImageUploadException;
import fhwedel.medienprojekt.fussball.service.image.ImageService;

@Controller
public class GaleryController {
	
	/** Image Service */
	@Autowired
	private ImageService imageService = new ImageService();
	
	/**
	 * Lädt die Galerie
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkGalery, method=RequestMethod.GET)
	public String displayGalery(HttpServletRequest request, Model model) {
		ArrayList<String> imgPaths = new ArrayList<String>();
		try {
			imgPaths = this.imageService.getImagPaths(request);
		} catch (IOException e) {
			// TODO
		}
		
		// Bildpfade in drei Listen für die drei divs aufteilen 
		ArrayList<ArrayList<String>> threeColsImgPaths = this.getColwiseImagePaths(imgPaths, 3);
		// und zur Verfügung stellen
		model.addAttribute("firstPartThreeCol", threeColsImgPaths.get(0));
		model.addAttribute("secondPartThreeCol", threeColsImgPaths.get(1));
		model.addAttribute("thirdPartThreeCol", threeColsImgPaths.get(2));
		// zweispaltig
		ArrayList<ArrayList<String>> twoColsImgPaths = this.getColwiseImagePaths(imgPaths, 2);
		model.addAttribute("firstPartTwoCol", twoColsImgPaths.get(0));
		model.addAttribute("secondPartTwoCol", twoColsImgPaths.get(1));
		// einspaltig
		model.addAttribute("oneCol", imgPaths);
		
		return Constants.viewNameGalery;
	}
	
	/**
	 * Teilt die Bildpfade zur Anzeige im JSP in Gruppen auf.
	 * @param 	imagePaths	ArrayList<String>	Bildpfade
	 * @param	cols		int					Anzahl an Listen, in die 
	 * 											Bilder aufgeteilt werden sollen
	 * @return	ArrayList<ArrayList<String>>	Liste mit Listen der Bildpfade
	 */
	private ArrayList<ArrayList<String>> getColwiseImagePaths(ArrayList<String> imagePaths, int cols) {
		int col = 0;
		ArrayList<ArrayList<String>> colwiseImagePaths = new ArrayList<ArrayList<String>>();
		/* initialisieren */
		for(int i=0; i < cols; i++) {		
			colwiseImagePaths.add(new ArrayList<String>());
		}
		/* Bilder durchgehen und der Reihe nach verschiedenen Listen anhängen */
		for(int i=0; i<imagePaths.size(); i++) {
			col = i % cols;
			// auf drei Spalten aufteilen
			colwiseImagePaths.get(col).add(imagePaths.get(i));
		}
		
		return colwiseImagePaths;
	}
	
	/**
	 * Lädt das Formular zum hinzufügen neuer Bilder in die Bildergalerie.
	 * @return string jsp
	 */
	@RequestMapping(value=Constants.linkGaleryUploadForm, method=RequestMethod.GET)
	public String displayGaleryImgUploadForm(Model model) {
		model.addAttribute("img", new Image());
		return Constants.viewNameGaleryUpload;
	}
	
	/**
	 * Speichert ein neues Bild in der Bildergalerie.
	 * @param	MultipartFile 	imageFile		Datei mit Multipart-Daten
	 * @param	bindingResult	BindingResult
	 */
	@RequestMapping(value=Constants.linkGaleryUpload, method=RequestMethod.POST)
	public String uploadImage(	@RequestParam(value="image", required=true) MultipartFile imageFile, 
								BindingResult bindingResult) {
		try {
			if(!imageFile.isEmpty()){
				imageService.validateImage(imageFile);
				imageService.saveImage("test.jpg",imageFile);
			}
		} catch(ImageUploadException e){
			bindingResult.reject(e.getMessage());
			return"spitters/edit";
		}
		return Constants.redirectGalery;
	}
	
}
