/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Julia Menzel Minf9950
 */
package fhwedel.medienprojekt.fussball.service.files.documents;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.service.exception.DocumentUploadException;
import fhwedel.medienprojekt.fussball.service.files.AbstractFilesService;

/**
 * DocumentService
 * Dient dem Validieren und Speichern von PDF-Dokumenten.
 */
public class DocumentService extends AbstractFilesService {	
	/* -------------- Klassenvariablen -------------------- */
	/** Pfad zum Ordner der Dokumente */
	//private String documentPath = "C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/documents/";
	 private String documentPath = "/var/www/este/src/main/webapp/resources/data/documents/";
	
	/**
	 * Prüft ein Dokument auf das richtige Format.
	 * @param document
	 */
	@Override
	public void validate(MultipartFile document){
		/** Als valides Format vorerst nur pdf erlaubt, damit keine
		 * zips, exe-Dateien oder Ähnliches hochgeladen werden können. */
		if(!document.getContentType().equals("application/pdf")){
			// Bei anderem Format Exception werden
			throw new DocumentUploadException("Es sind nur PDFs erlaubt.");
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
			this.save(name, document, this.documentPath);
		} catch(IOException e){
			throw new DocumentUploadException("Es war nicht möglich das Dokument zu speichern",e);
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
	 * Gibt die Liste der Pfade der Dokumente zurück.
	 * 
	 * @param request HttpServletRequest
	 * @return ArrayList<String> Liste derPfade
	 * @throws IOException
	 */
	public ArrayList<String> getDocumentPaths(HttpServletRequest request) throws IOException {
		String documentUrl = request.getContextPath() + "/resources/data/documents/";
		return this.getPaths(this.documentPath, documentUrl);
	}
	
	/**
	 * Gibt die Liste der Namen der Dokumente zurück.
	 * 
	 * @param request HttpServletRequest
	 * @return ArrayList<String> Liste der Dateinamen
	 * @throws IOException
	 */
	public ArrayList<String> getDocumentNames(HttpServletRequest request) throws IOException {
		return this.getFileNames(this.documentPath);
	}
}
