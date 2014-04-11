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
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Abstralte Service Klasse
 * Implementiert gemeinsame Methoden für die erbenden Klassen
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public abstract class AbstractDataAccessPost<E extends Post> extends AbstractDataAccess {
	
	/* ---------------------------- Datenbankarbeit --------------------------- */
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
	
	/* ---------------- Seitenansicht --------------------------------- */
	
	/**
	 * Manuelle Erstellung einer Seite.
	 * @param 	pageNumber	int				Aktuell angezeigte Seite
	 * @param 	prevPage	int				vorherige Seite
	 * @param 	nextPage	int				folgende Seite
	 * @param 	items		ArrayList<E>	Einträge
	 * @return	page		Page			Erstellte Seite
	 */
	public Page<E> setPage(int pageNumber, int prevPage, int nextPage, ArrayList<E> items) {
		Page<E> page = new Page<E>();
		page.setPageItems(items);
		page.setPageNumber(1);
		page.setPagesAvailable(1);
		
		return page;
	}
	
	/**
	 * Initialisiert eine Page.
	 * Berechnet die benötigten Seitenzahlen.
	 * @param 	db			String	Name der Datenbank
	 * @param 	pageNo		int		Nummer der Seite
	 * @param 	pageSize	int		Anzahl an Einträgen pro Seite
	 * @return	page		Page	initialisierte Seite
	 */
	private Page<E> initPage(String db, final int pageNo, final int pageSize) {
		final Page<E> page = new Page<E>();
		final String SQL_COUNT_ROWS = "SELECT count(*) FROM " + db;
		
		// Anzahl der Einträge berechnen
        final int rowCount = namedParameterJdbcTemplate.queryForInt(SQL_COUNT_ROWS, new HashMap<String, Object>());
        
		// Seitenzahlen berechnen
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        // initialisieren
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        // vorherige und nächste Seitenzahl berechnen
        page.initPagination();
        
        return page;
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
    	final String SQL_FETCH_ROWS = "SELECT * FROM " + db + " ORDER BY date DESC LIMIT :start, :end";
        Map<String,Object> params = new HashMap<String, Object>();

        // Seitenzahlen initialisieren
        Page<E> page = this.initPage(db, pageNo, pageSize);
        // Start- und Endreihe berechnen
        final int startRow = (pageNo - 1) * pageSize;
        final int endRow = startRow + pageSize;
        params.put("start", startRow);
        params.put("end", endRow);
        
        // Liste auslesen und setzen
        page.setPageItems(
        		(ArrayList<E>) namedParameterJdbcTemplate.query(SQL_FETCH_ROWS, params, rowMapper)
        	);
        
        return page;
    }
	
}
