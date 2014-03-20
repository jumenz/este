package fhwedel.medienprojekt.fussball.service;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import org.junit.runner.Request;
import org.springframework.web.multipart.MultipartFile;
import com.github.dandelion.datatables.core.util.FileUtils;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.service.ImageUploadException;

/**
 * ImageService
 * Dient dem Validieren und Speichern von Images.
 * 
 * @author Ellen
 */
public class ImageService {
	/**
	 * Prüft ein Image auf das richtige Format.
	 * @param image
	 */
	public void validateImage(MultipartFile image){
		/* Als valides Bildformat vorerst nur jpeg erlaubt, damit keine
		 * zips, exe-Dateien oder Ähnliches hochgeladen werden können. */
		if(!image.getContentType().equals("image/jpeg")){
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
			File file = new File("C:/Users/Ellen/workspace/medienprojekt/este/fussball/src/main/webapp/resources/data/galery/" + filename);
			// FileUtils.writeByteArrayToFile(file, image.getBytes());
		} //catch(IOException e){
			//throw new ImageUploadException("Unabletosaveimage",e);
		//}
		finally {}
		
		// TODO FileUtils von Apache Common IO einbinden
	}
}
