package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.util.ArrayList;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/**
 * Abstralte Service Klasse
 * Implementiert gemeinsame Methoden für die erbenden Klassen
 * 
 * @author Ellen
 *
 */
public abstract class AbstractDataAccessPost<E extends Post> extends AbstractDataAccess {
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Foreneinträge aus der Datenbank aus.
	 * 
	 * @return ArrayList<ForumEntry>	Liste aller Foreneinträge
	 */
	public abstract ArrayList<E> getAll();
	
	/**
	 * Liefert alle Foreneinträge, die mit einem bestimmten Buchstaben
	 * beginnen.
	 * Groß- und Kleinschreibung wird hierbei nicht beachtet.
	 * @aram 	char					gesuchter Buchstabe
	 * @return 	ArrayList<ForumEntry>	Liste von Einträgen
	 */
	public ArrayList<E> getAllStartingWith(String sub) {
		ArrayList<E> res = new ArrayList<E>();
		// Alle auslesen
		ArrayList<E> all = this.getAll();
		
		// Alle finden, die mit gesuchtem String beginnen
		for(int i=0; i < all.size(); i++) {
			if(all.get(i).getTopic().toLowerCase().startsWith(sub, 0)) {
				res.add(all.get(i));
			}
		}
		
		return res;
	}
	
	/**
	 * Hilfsfunktion
	 * Liefert als Ergebnis, ob ein String einen Substring enthält.
	 * @param	string	String in dem gesucht wird
	 * @param	sub		String, dessen Enthalten geprüft werden soll
	 * @return	boolean
	 */
	private boolean stringContainsSub(String string, String sub) {
		return string.toLowerCase().indexOf(sub.toLowerCase()) != -1;
	}
	
	/**
	 * Liefert alle Foreneinträge, die einen Substring beinhaltet.
	 * Groß- und Kleinschreibung wird hierbei nicht beachtet.
	 * beginnen.
	 * @aram 	char					gesuchter Buchstabe
	 * @return 	ArrayList<ForumEntry>	Liste von Einträgen
	 */
	public ArrayList<E> getAllIncluding(String sub) {
		ArrayList<E> res = new ArrayList<E>();
		// Alle auslesen
		ArrayList<E> all = this.getAll();
		
		// Alle finden, die einen gesuchten String enthalten
		for(int i=0; i < all.size(); i++) {
			if(stringContainsSub(all.get(i).getTopic(), sub)) {
				res.add(all.get(i));
			}
		}
		
		return res;
	}
	
}
