package fhwedel.medienprojekt.fussball.service.uploads.image;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

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
		if(!file.getContentType().equals("image/jpeg") || !file.getContentType().equals("image/png")){
			// Bei anderem Format Exception werden
			throw new ImageUploadException("OnlyJPGimagesaccepted");
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
			File file = new File("C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/galery/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e){
			throw new ImageUploadException("Unabletosaveimage",e);
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
		return new File(f,s).isFile() 
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
		ArrayList<String> imgPaths = new ArrayList<String>();
		String galeryPath = "C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/galery/";
		String galeryUrl = request.getContextPath() + "/resources/data/galery/";
		String imageNames[] = null;
		File dir = new File(galeryPath);
		
		if(dir.isDirectory()) {
			if(!dir.canRead()) {
				// Falls keine Leserechte vorhanden sind, diese setzen
				dir.setReadable(true);
			}
			// Dateinamen auslesen
			imageNames = dir.list();
		}
		
		if(imageNames != null) {
			for(int i=0; i < imageNames.length; i++){
				// Ressource URL erstellen
				imgPaths.add(galeryUrl + imageNames[i]);
			}
		}
		
		return imgPaths;
	}
}
