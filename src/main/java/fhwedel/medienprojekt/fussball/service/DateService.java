package fhwedel.medienprojekt.fussball.service;

/** externe Klassen */
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Service für Arbeiten mit Datumsangaben.
 * 
 * @author Ellen Schwartau Minf9888
 */
public class DateService {
	/**
	 * Liefert das aktuelle Datum.
	 * @return Date
	 */
	public Date getCurrentDate() {
		return new Date();
	}
	
	/**
	 * Printet das übergebene Datum
	 * @param date	Datumsangabe
	 */
	public void printSimpleDateFormat(Date date) {
		// Ausgeben
        System.out.println(getDateString(date));       
    }
	
	/**
	 * Liefert den String einer Datumsangabe
	 * @param date	Datum
	 */
	public String getDateString(Date date) {
		// Format festlegen
		SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy.MM.dd - HH:mm:ss ");
        // zum Beispiel: 2012.04.14 - 21:34:07 
        return formatter.format(date);
	}
}
