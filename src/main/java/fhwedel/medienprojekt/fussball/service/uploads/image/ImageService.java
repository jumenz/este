package fhwedel.medienprojekt.fussball.service.uploads.image;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.service.exception.ImageUploadException;
import fhwedel.medienprojekt.fussball.service.uploads.AbstractUploadService;

/**
 * ImageService
 * Dient dem Validieren und Speichern von Images.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class ImageService extends AbstractUploadService {	
	/**
	 * Prüft ein Image auf das richtige Format.
	 * @param image
	 */
	@Override
	public void validate(MultipartFile file) {
		/* Als valides Bildformat vorerst nur jpeg und png erlaubt, damit keine
		 * zips, exe-Dateien oder Ähnliches hochgeladen werden können. */
		if(!(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png"))){
			// Bei anderem Format Exception werden
			throw new ImageUploadException("Es sind nur JPGs oder PNGs erlaubt.");
		}
	}
	
	/**
	 * Bild speichern
	 * @param filename	Name des Bildes, unter dem es gespeichert werden soll
	 * @param image		Datei
	 * @throws ImageUploadException
	 */
	public void saveImage(String filename, MultipartFile image) throws ImageUploadException{
		try {
			this.save(filename, image, "C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/galery/");
		} catch(IOException e){
			throw new ImageUploadException("Unable to save image",e);
		}		
	}
	
	/**
	 * Prüft ein File darauf, ob ein Image vorliegt.
	 * Valide Bildendungen sind hier jpg und png.
	 * @param 	f	File	Datei
	 * @param 	s	String	Dateiname
	 * @return	boolean		
	 */
	public boolean isImage(File f, String s) {
		return this.isFile(f, s) 
					&& (s.toLowerCase().endsWith(".jpg") 
					|| (s.toLowerCase().endsWith(".png")));
	}
	
	/**
	 * Liest die Image-Pfade aus dem Galery-Ordner aus.
	 * @param 	request				Request
	 * @return	ArrayList<String>	Bildpfade
	 * @throws 	IOException
	 */
	public ArrayList<String> getImagPaths(HttpServletRequest request) throws IOException {
		String galeryPath = "C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/galery/";
		String galeryUrl = request.getContextPath() + "/resources/data/galery/";
		
		return this.getPaths(galeryPath, galeryUrl);
	}
}
