package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import fhwedel.medienprojekt.fussball.model.pagination.Page;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/**
 * Abstralte Service Klasse
 * Implementiert gemeinsame Methoden für die erbenden Klassen
 * 
 * @author Ellen Schwartau Minf9888
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
			String topic = all.get(i).getTopic();
			if(topic.toLowerCase().startsWith(sub.toLowerCase(), 0)) {
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
		// Kopie, damit Original nicht verändert wird
		String lowerCaseString = string.toLowerCase();
		String lowerCaseSub = sub.toLowerCase();
		// Vergleichen
		return lowerCaseString.indexOf(lowerCaseSub) != -1;
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
		ArrayList<E> all = this.getAll();
		E entry;
		
		// Alle finden, die einen gesuchten String enthalten
		for(int i=0; i < all.size(); i++) {
			entry = all.get(i);
			if(stringContainsSub(entry.getTopic(), sub)
			   || stringContainsSub(entry.getText(), sub)) {
				// anfügen wenn der gesuchte String im Titel oder
				// im Text vorkommt
				res.add(all.get(i));
			}
		}
		
		return res;
	}
	
	/**
	 * Selektiert eine Seitenansicht aus Posts.
	 * @param db			String		Name der Datenbank
	 * @param pageNo		int			Nummer der anzuzeigenden Seite
	 * @param pageSize		int			Anzahl an Elementen pro Seite
	 * @param rowMapper		RowMapper	Mappt ein Result auf ein Objekt
	 * @return	page		Page		Seite mit Einträgen
	 */
    public Page<E> fetchPage(final String db, final int pageNo, final int pageSize, final ParameterizedRowMapper<E> rowMapper) {
    	// SQL Anweisungen
    	final String SQL_COUNT_ROWS = "SELECT count(*) FROM " + db;
    	final String SQL_FETCH_ROWS = "SELECT * FROM " + db + " ORDER BY date DESC LIMIT :start, :end";
    	Map<String,Object> params = new HashMap<String, Object>();
    	
        // Anzahl der Einträge herausfinden
        final int rowCount = namedParameterJdbcTemplate.queryForInt(SQL_COUNT_ROWS, params);

        // Seitenzahlen berechnen
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        // Page Object erstellen
        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        // Start- und Endreihe berechnen
        final int startRow = (pageNo - 1) * pageSize;
        final int endRow = startRow + pageSize;
        params.put("start", startRow);
        params.put("end", endRow);
        
        // Liste auslesen und setzen
        ArrayList<E> res = (ArrayList<E>) namedParameterJdbcTemplate.query(SQL_FETCH_ROWS, params, rowMapper);
        page.setPageItems(res);
        
        // vorherige und nächste Seitenzahl berechnen
        page.initPagination();
        
        return page;
    }
	
}
