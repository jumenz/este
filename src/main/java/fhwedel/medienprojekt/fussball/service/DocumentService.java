package fhwedel.medienprojekt.fussball.service;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;








/** eigene Klassen */
import fhwedel.medienprojekt.fussball.service.exception.DocumentUploadException;

/**
 * ImageService
 * Dient dem Validieren und Speichern von Images.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class DocumentService {	
	/**
	 * Prüft ein Dokument auf das richtige Format.
	 * @param document
	 */
	public void validateDocument(MultipartFile document){
		/** Als valides Format vorerst nur pdf erlaubt, damit keine
		 * zips, exe-Dateien oder Ähnliches hochgeladen werden können. */
		if(!document.getContentType().equals("application/pdf")){
			// Bei anderem Format Exception werden
			throw new DocumentUploadException("OnlyPDFdocumentsAccepted");
		}
	}
	
	/**
	 * Dokument speichern.
	 * 
	 * @param filename	Name des Dokuments, unter dem es gespeichert werden soll
	 * @param document	Datei
	 * @throws DocumentUploadException
	 */
	public void saveDocument(String name, MultipartFile document) throws DocumentUploadException{
		try {
			File file = new File("/var/www/este/src/main/webapp/resources/data/documents/" + name);
			FileUtils.writeByteArrayToFile(file, document.getBytes());
		} catch(IOException e){
			throw new DocumentUploadException("UnableToSaveDocument",e);
		}		
	}
	
	/**
	 * Prüft ob das Dokument ein PDF ist.
	 * 
	 * @param f
	 * @param s 
	 * @return boolean
	 */
	public boolean isDocument(File f, String s) {
		return new File(f,s).isFile() && (s.toLowerCase().endsWith(".pdf"));
	}

	/**
	 * Gibt einen gültigen Dokument-Namen zurück.
	 * 
	 * @param documentName 		Name des Dokuments.
	 * @return String 			gültiger Name
	 */
	public String validateDocumentName(String documentName) {
		documentName = documentName.toLowerCase();
		// .pdf Dateiendung entfernen
		documentName = documentName.replace(".pdf", "");
		// Alle ungültigen Zeichen durch '-' ersetzen
		String regex = "[^a-z0-9-_]+";
		documentName = documentName.replaceAll(regex, "-");
		// Aktuelles Datum vor den Dokumentnamen stellen.
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_kk.mm_"); // Format für 24-Stunden-Anzeige
		String str = dateFormat.format(new Date());
		documentName = str.concat(documentName);
		return documentName.concat(".pdf");
	}
	
	/**
	 * Gibt die Liste der Pfade der Dokumente zurück.
	 * 
	 * @param request HttpServletRequest
	 * @return ArrayList<String> Liste derPfade
	 * @throws IOException
	 */
	public ArrayList<String> getDocumentPaths(HttpServletRequest request) throws IOException {
		ArrayList<String> documentPaths = new ArrayList<String>();
		String documentPath = "/var/www/este/src/main/webapp/resources/data/documents/";
		String documentUrl = request.getContextPath() + "/resources/data/documents/";
		File dir = new File(documentPath);
		String documentNames[] = null;
		
		if(dir.isDirectory()) {
			if(!dir.canRead()) {
				dir.setReadable(true);
			}
			documentNames = dir.list();
		}
		if(documentNames != null) {
			for(int i=0; i < documentNames.length; i++){
				documentPaths.add(documentUrl + documentNames[i]);
			}
		}
		return documentPaths;
	}
	
	/**
	 * Gibt die Liste der Namen der Dokumente zurück.
	 * 
	 * @param request HttpServletRequest
	 * @return ArrayList<String> Liste der Dateinamen
	 * @throws IOException
	 */
	public ArrayList<String> getDocumentNames(HttpServletRequest request) throws IOException {
		ArrayList<String> documentNameList = new ArrayList<String>();
		String documentPath = "/var/www/este/src/main/webapp/resources/data/documents/";
		File dir = new File(documentPath);
		String documentNames[] = null;
		
		if(dir.isDirectory()) {
			if(!dir.canRead()) {
				dir.setReadable(true);
			}
			documentNames = dir.list();
		}
		if(documentNames != null) {
			for(int i=0; i < documentNames.length; i++){
				documentNameList.add(documentNames[i]);
			}
		}
		return documentNameList;
	}
}
