package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;





/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.service.exception.DocumentUploadException;
import fhwedel.medienprojekt.fussball.service.files.documents.DocumentService;

@Controller
public class DocumentsController {
		
	/* -------------------- Klassenvariablen ------------------------ */
	/** Document Service */
	@Autowired
	private DocumentService documentService = new DocumentService();
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Lädt die Dokumente
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkDocuments, method=RequestMethod.GET)
	public String displayDocuments(HttpServletRequest request, Model model) {
		ArrayList<String> documentPaths = new ArrayList<String>();
		ArrayList<String> documentNames = new ArrayList<String>();
		try {
			documentPaths = this.documentService.getDocumentPaths(request);
			documentNames = this.documentService.getDocumentNames(request);
		} catch (IOException e) { 
			
		}
		model.addAttribute("documentPaths", documentPaths);
		model.addAttribute("documentNames", documentNames);
		//model.addAttribute("newDocument", new Document());
		
		return Constants.viewNameDocuments;
	}

	/* --------------------- Funktion ------------------------------- */	
	/**
	 * Lädt das Formular zum hinzufügen neuer Dokumente.
	 * 
	 * @return string jsp
	 */
	@RequestMapping(value=Constants.linkDocumentsUploadForm, method=RequestMethod.GET)
	public String displayDocumentsUploadForm(Model model) {
		return Constants.viewNameDocumentsUpload;
	}
	
	/**
	 * Speichert ein neues Dokument.
	 * 
	 * @param	MultipartFile 	documentFile	Datei mit Multipart-Daten
	 * @param	Strinf			nocumentName	Name des Dokuments
	 */
	@RequestMapping(value=Constants.linkDocumentsUpload, method=RequestMethod.POST)
	public String uploadDocument(	@RequestParam(value="userfile", required=true) MultipartFile documentFile, 
									@RequestParam(value="usertext", required=true) String documentName) {

		if(documentFile.isEmpty()){
			return Constants.redirectDocumentsUploadForm;
		}
		// gültigen Dokumente-Namen erstellen
		ArrayList<String> endings = new ArrayList<String>();
		endings.add(".pdf");
		documentName = documentService.validateFileName(documentName, endings);
		try {
			documentService.validate(documentFile);
			documentService.saveDocument(documentName, documentFile);
		} catch(DocumentUploadException e){
			// TODO fehlerausgabe
			return Constants.redirectDocumentsUploadForm;
		}
		return Constants.redirectDocuments;
	}
}
