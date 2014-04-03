package fhwedel.medienprojekt.fussball.service.image;

/** externe Klassen */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

/** eigene Klassen */

import org.apache.commons.io.FilenameUtils;

import fhwedel.medienprojekt.fussball.service.exception.ImageUploadException;

/**
 * ImageService
 * Dient dem Validieren und Speichern von Images.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class ImageService {	
	/**
	 * Prüft ein Image auf das richtige Format.
	 * @param image
	 */
	public void validateImage(MultipartFile image){
		/* Als valides Bildformat vorerst nur jpeg und png erlaubt, damit keine
		 * zips, exe-Dateien oder Ähnliches hochgeladen werden können. */
		if(!image.getContentType().equals("image/jpeg") || !image.getContentType().equals("image/png")){
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
	
	private boolean isImage(File f, String s) {
		return new File(f,s).isFile() && (s.toLowerCase().endsWith(".jpg") || (s.toLowerCase().endsWith(".jpg")));
	}
	
	public ArrayList<String> getImagPaths(HttpServletRequest request) throws IOException {
		ArrayList<String> imgPaths = new ArrayList<String>();
		String galeryPath = "C:/Users/Ellen/workspace/medienprojekt/este/src/main/webapp/resources/data/galery/";
		String galeryUrl = request.getContextPath() + "/resources/data/galery/";
		File dir = new File(galeryPath);
		String imageNames[] = null;
		
		if(dir.isDirectory()) {
			if(!dir.canRead()) {
				dir.setReadable(true);
				
			}
			imageNames = dir.list();
		}
		
		if(imageNames != null) {
			for(int i=0; i < imageNames.length; i++){
				imgPaths.add(galeryUrl + imageNames[i]);
			}
		}
		
		return imgPaths;
	}
}
