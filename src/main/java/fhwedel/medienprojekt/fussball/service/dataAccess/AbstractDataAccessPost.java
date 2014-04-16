package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
public abstract class AbstractDataAccessPost<E extends Post> extends AbstractDataAccess<E> {
	
	/* ---------------------------- Datenbankarbeit --------------------------- */
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Posts aus der Datenbank aus.
	 * @return 	ArrayList<ForumEntry>		Liste aller Foreneinträge
	 */
	public abstract ArrayList<E> getAll();
	
	/**
	 * Liest alle Einträge aus einer Datenbank aus.
	 * @param	db			String						Datenbankname
	 * @param	rowMapper	ParameterizedRowMapper<E>	Mapper
	 * @param	orderById	voolean						Angabe, ob auch nach Id sortiert werden soll
	 * @return 	ArrayList<E>							Liste aller Einträge
	 */
	public ArrayList<E> getAll(String db, ParameterizedRowMapper<E> rowMapper, boolean orderById) {
		final String SQL_SELECT_ALL = orderById 
				? "SELECT * FROM " + db + " ORDER BY date DESC, id DESC"
				: "SELECT * FROM " + db + " ORDER BY date DESC";
		
		// Alle Einträge auslesen
		return (ArrayList<E>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL,
				rowMapper
			);
	}
	
	/**
	 * Liefert alle Einträge, die mit einem bestimmten String
	 * beginnen.
	 * Groß- und Kleinschreibung wird hierbei nicht beachtet.
	 * @param 	sub		String			gesuchter String
	 * @param	all		ArrayList<E>	Liste aller Einträge
	 * @return 	res		ArrayList<E>	Ergebnisliste
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
	 * Liefert alle Posts, die einen Substring beinhaltet.
	 * Groß- und Kleinschreibung wird hierbei nicht beachtet.
	 * beginnen.
	 * @param 	sub		String			gesuchter String
	 * @param	all		ArrayList<E>	Liste aller Einträge
	 * @return 	res		ArrayList<E>	Ergebnisliste
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
		
        final int rowCount = namedParameterJdbcTemplate.queryForInt(SQL_COUNT_ROWS, new HashMap<String, Object>());
        
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
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
    public Page<E> fetchPage(	final String db, final int pageNo, final int pageSize, 
    							final ParameterizedRowMapper<E> rowMapper, boolean orderById) {
    	final String SQL_FETCH_ROWS = orderById 
    			? "SELECT * FROM " + db + " ORDER BY date DESC, id DESC LIMIT :start, :end"
    			: "SELECT * FROM " + db + " ORDER BY date DESC LIMIT :start, :end";
        Map<String,Object> params = new HashMap<String, Object>();

        Page<E> page = this.initPage(db, pageNo, pageSize);
        final int startRow = (pageNo - 1) * pageSize;
        final int endRow = startRow + pageSize;
        params.put("start", startRow);
        params.put("end", endRow);
        
        page.setPageItems(
        		(ArrayList<E>) namedParameterJdbcTemplate.query(SQL_FETCH_ROWS, params, rowMapper)
        	);
        
        return page;
    }
	
}
