/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.service.date;

/** externe Klassen */
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Service für Arbeiten mit Datumsangaben.
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
	 * Printet das übergebene Datum.
	 * @param date	Datumsangabe
	 */
	public void printSimpleDateFormat(Date date) {
		// Ausgeben
        System.out.println(getDateString(date));       
    }
	
	/**
	 * Liefert den String einer Datumsangabe. (yyyy.MM.dd - HH:mm:ss)
	 * @param date	Datum
	 */
	public String getDateString(Date date) {
		// Format festlegen
		SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy.MM.dd - HH:mm:ss ");
        // zum Beispiel: 2012.04.14 - 21:34:07 
        return formatter.format(date);
	}
	
	/**
	 * Liefert den String einer Datumsangabe. (yyyy.MM.dd)
	 * @param date	Datum
	 */
	public String getSimpleDateString(Date date) {
		// Format festlegen
		SimpleDateFormat formatter = new SimpleDateFormat(
                "dd.MM.yyyy");
        // zum Beispiel: 2012.04.14
        return formatter.format(date);
	}
	
	/**
	 * Liefert die Datumsangabe eines String, sonst null. (yyyy.MM.dd)
	 * @param Date Datum oder null
	 */
	public Date getSimpleDate(String date) {
		// SimpleDateFormat mit Locale.US erstellen
		SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy", 
				new DateFormatSymbols(Locale.US));
		// Format einlesen wenn möglich
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
