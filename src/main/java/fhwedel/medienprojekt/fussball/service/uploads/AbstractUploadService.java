package fhwedel.medienprojekt.fussball.service.uploads;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service
 * Abstrakte Klasse für den Upload von Dateien.
 * 
 * @author Ellen Schwartau Minf988
 *
 */
public abstract class AbstractUploadService {
	/* --------------- Validierung ---------------- */
	/**
	 * Prüft eine Datei auf das richtige Format.
	 * @param file	MultipartFile
	 */
	public abstract void validate(MultipartFile file);
	
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
	 * Gibt einen gültigen Dokument-Namen zurück.
	 * 
	 * @param documentName 		Name des Dokuments.
	 * @param ArrayList<String> erlaubte Endungen
	 * @return String 			gültiger Name
	 */
	public String validateFileName(String fileName, ArrayList<String> acceptedEndings) {
		fileName = fileName.toLowerCase();
		String ending = "";
		
		// Dateiendung entfernen
		for(int i=0; i<acceptedEndings.size(); i++) {
			if(fileName.endsWith(acceptedEndings.get(i))) {
				// Endung merken und entfernen
				ending = acceptedEndings.get(i);
				fileName = fileName.replace(ending, "");
			}
		}
		
		// Alle ungültigen Zeichen durch '-' ersetzen
		String regex = "[^a-z0-9-_]+";
		fileName = fileName.replaceAll(regex, "-");
		// Aktuelles Datum vor den Dokumentnamen stellen.
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_kk.mm_"); // Format für 24-Stunden-Anzeige
		String str = dateFormat.format(new Date());
		fileName = str.concat(fileName);
		
		// Endung (wieder) anfügen
		return (ending.equals(new String("")) && acceptedEndings.size() > 0) 
				? fileName.concat(acceptedEndings.get(0)) 
				: fileName.concat(ending);
	}
	
	/* ------------- Speichern ----------------- */
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
	
	/* ---------------- Auslesen ---------------------- */
	/**
	 * Hilfsfunktion
	 * Liest die Namen aller Dateien eines Verzeichnisses aus.
	 * @param 	dirPath		String		Pfad
	 * @return	fileNames	String[]	Dateinamen
	 * @throws	IOException
	 */
	private String[] getFilesInDir(String dirPath) throws IOException {
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
		
		return fileNames;
	}
	
	/**
	 * Liest die Datei-Pfade aus einem Ordner aus.
	 * @param 	request				Request
	 * @param	dirPath				String		Pfad des Ordners
	 * @param	ressourceUrl		String		Url die auf Ressource verweist
	 * @return	ArrayList<String>	Dateipfade
	 * @throws 	IOException
	 */
	public ArrayList<String> getPaths(String dirPath, String ressourceUrl) throws IOException {
		ArrayList<String> paths = new ArrayList<String>();
		String fileNames[] = this.getFilesInDir(dirPath);
		
		if(fileNames != null) {
			for(int i=0; i < fileNames.length; i++){
				// Ressource URL erstellen
				paths.add(ressourceUrl + fileNames[i]);
			}
		}
		
		return paths;
	}
	
	/**
	 * Gibt die Liste der Namen der Dateien eines Verzeichnisses zurück.
	 * 
	 * @return ArrayList<String> Liste der Dateinamen
	 * @throws IOException
	 */
	public ArrayList<String> getFileNames(String dirPath) throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		// Namen auslesen
		String fileNames[] = this.getFilesInDir(dirPath);
		
		if(fileNames != null) {
			for(int i=0; i < fileNames.length; i++){
				// an Liste anfügen
				names.add(fileNames[i]);
			}
		}
		return names;
	}
}
