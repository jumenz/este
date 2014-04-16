/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import fhwedel.medienprojekt.fussball.model.pagination.Page;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Foreneinträgen.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende Foreneinträge.
 */
public class DataAccessForum extends AbstractDataAccessPost<ForumEntry> {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * ForumEntryMapper
	 */
	private ParameterizedRowMapper<ForumEntry> forumEntryMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<ForumEntry>() {
				public ForumEntry mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					ForumEntry entry = new ForumEntry();
					// Spalten des Ergebnisses zuweisen
					entry.setId(resultSet.getInt(1));
					entry.setDate(resultSet.getDate(2));
					entry.setAuthor(resultSet.getString(3));
					entry.setTopic(resultSet.getString(4));
					entry.setDescription(resultSet.getString(5));
					entry.setText(resultSet.getString(6));
					
					return entry;
				}
			};
	
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessForum() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessForum(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/**
	 * Hilfsfunktion.
	 * Ordnet die Werte des Foreneintrags als Name-Wert-Paare.
	 * @param forumEntry	ForumEntry	Foreneintraf
	 * @param params		Map			Name-Wert-Paare
	 * @param updateDate	boolean		true: neues Datum wird gemappt
	 * 									false: altes Datum wird übernommen
	 */
	private void mapParams(ForumEntry forumEntry, Map<String,Object> params, boolean updateDate) {
		Date date = (updateDate) ? new Date() : forumEntry.getDate();
		params.put("date", date);
		params.put("author", forumEntry.getAuthor());
		params.put("topic", forumEntry.getTopic());
		params.put("text", forumEntry.getText());
		params.put("description", forumEntry.getDescription());
		params.put("has_comments", !forumEntry.getComments().isEmpty());
	}
	
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert einen neuen ForenEintrag.
	 * @param newForumEntry Eintrag
	 */
	public void save(ForumEntry newForumEntry) {
		/* SQL Befehl */
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO " + Constants.dbForum 
				+ " ("
				+ Constants.dbForumDate + ", "
				+ Constants.dbForumAuthor + ", "
				+ Constants.dbForumTopic + ", "
				+ Constants.dbForumDescription + ", "
				+ Constants.dbForumText
				+ ") VALUES (:date, :author, :topic, :description, :text)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		mapParams(newForumEntry, params, true);
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
	}
	
	/* ------------------------- Bearbeiten ----------------------------------- */
	/**
	 * Aktualisiert einen bearbeiteten Foreneintrag.
	 * @param id		 	int			ID des bearbeiteten Foreneintrags
	 * @param forumEntry	ForumEntry	neue Daten des Foreneintrags
	 */
	public void update(int id, ForumEntry forumEntry) {
		/* SQL Befehl*/
		final String SQL_UPDATE_FORUM_ENTRY = 
				"UPDATE " + Constants.dbForum
				+ " SET author = :author, topic = :topic, description = :description, text=:text "
				+ "WHERE id=:id";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		this.mapParams(forumEntry, params, false);
		// zusätzlich auch id setzen
		params.put("id", id);
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_UPDATE_FORUM_ENTRY, params);
	}
	
	/* ------------------------ Löschen -------------------------------------- */
	/**
	 * Löscht einen Foreneintrag ausgehend von seiner id.
	 * @param 	id	int		ID des Foreneintrags
	 */
	public void deleteById(int id) {
		// Löschen
		this.deleteById(id, Constants.dbForum);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Foreneinträge aus der Datenbank aus.
	 * 
	 * @return ArrayList<ForumEntry>	Liste aller Foreneinträge
	 */
	public ArrayList<ForumEntry> getAll() {
		return this.getAll(Constants.dbForum, this.forumEntryMapper, true);
	}
	
	/**
	 * Liefert die Seitenansicht von Foreneinträgen.
	 * @param 	currPage	int		anzuzeigende Seite
	 * @param 	pageSize	int		Anzahl der Einträge pro Seite		
	 * @return	Page<ForumEntry>	Seite mit Einträgen
	 */
	public Page<ForumEntry> getPage(int currPage, int pageSize) {
		return this.fetchPage(Constants.dbForum, currPage, pageSize, this.forumEntryMapper, true);
	}
		
	/**
	 * Liefert einen ForenEintrag ausgehend von seiner id.
	 * @param  id	id des gesuchten Eintrags
	 * @return ForumEntry
	 */
	public ForumEntry getById(int id) {
		return this.getById(id, Constants.dbForum, this.forumEntryMapper);
	}
	
}
