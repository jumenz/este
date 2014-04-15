package fhwedel.medienprojekt.fussball.service.uploads;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service
 * Abstrakte Klasse für den Upload von Dateien.
 * 
 * @author Ellen Schwartau Minf988
 *
 */
abstract class AbstractUploadService {
	/**
	 * Prüft eine Datei auf das richtige Format.
	 * @param file	MultipartFile
	 */
	abstract void validate(MultipartFile file);
	
	/**
	 * Speichert eine Datei im angegebenen Pfad.
	 * @param filename	Name der Datei, unter dem es gespeichert werden soll
	 * @param mpFile		Datei
	 * @throws IOException
	 */
	public void save(String filename, MultipartFile mpFile, String path) throws IOException {
		File file = new File(path + filename);
		FileUtils.writeByteArrayToFile(file, mpFile.getBytes());
	}
	
	/**
	 * Prüft ein File darauf, ob ein Image vorliegt.
	 * Valide Bildendungen sind hier jpg und png.
	 * @param 	f	File	Datei
	 * @param 	s	String	Dateiname
	 * @return	boolean		
	 */
	public boolean isFile(File f, String s) {
		return new File(f,s).isFile();
	}
	
	/**
	 * Liest die Datei-Pfade aus einem Ordner aus.
	 * @param 	request				Request
	 * @param	dirPath				String		Pfad des Ordners
	 * @param	ressourceUrl		String		Url die auf Ressource verweist
	 * @return	ArrayList<String>	Dateipfade
	 * @throws 	IOException
	 */
	public ArrayList<String> getImagPaths(HttpServletRequest request, String dirPath, String ressourceUrl) throws IOException {
		ArrayList<String> paths = new ArrayList<String>();
		String fileNames[] = null;
		File dir = new File(dirPath);
		
		if(dir.isDirectory()) {
			if(!dir.canRead()) {
				// Falls keine Leserechte vorhanden sind, diese setzen
				dir.setReadable(true);
			}
			// Dateinamen auslesen
			fileNames = dir.list();
		}
		
		if(fileNames != null) {
			for(int i=0; i < fileNames.length; i++){
				// Ressource URL erstellen
				paths.add(ressourceUrl + fileNames[i]);
			}
		}
		
		return paths;
	}
}
