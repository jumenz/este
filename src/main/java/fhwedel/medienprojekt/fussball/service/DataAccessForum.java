package fhwedel.medienprojekt.fussball.service;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Foreneinträgen.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende Foreneinträge.
 * 
 * @author Ellen
 *
 */
public class DataAccessForum {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/** JDBC Template */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
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
	
	/* ----------------- Setter / Getter-Methoden ------------------------------- */
	/**
	 * Setzt das Template
	 * @param jdbcTemplate
	 */
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/**
	 * Liefert das jdbcTemplate
	 * @return NamedParameterJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		return this.namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert einen neuen ForenEintrag.
	 * @param newForumEntry Eintrag
	 */
	public void save(ForumEntry newForumEntry) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO forum (date, author, topic, description, text, has_comments) "
				+ "VALUES (:date, :author, :topic, :description, :text, :has_comments)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", new Date());
		params.put("author", newForumEntry.getAuthor());
		params.put("topic", newForumEntry.getTopic());
		params.put("text", newForumEntry.getText());
		params.put("description", newForumEntry.getDescription());
		params.put("has_comments", !newForumEntry.getCommentList().isEmpty());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Foreneinträge aus der Datenbank aus.
	 * 
	 * @return ArrayList<ForumEntry>	Liste aller Foreneinträge
	 */
	public ArrayList<ForumEntry> getAll() {
		// Alle Foren-Einträge nach Datum sortiert auslesen (neueste zuerst)
		final String SQL_ALL_FORUM_ENTRIES = "SELECT * FROM forum ORDER BY date ASC";
		
		/* TODO Kommentarliste laden */
		return (ArrayList<ForumEntry>) namedParameterJdbcTemplate.query(
				SQL_ALL_FORUM_ENTRIES,
				this.forumEntryMapper
			);
	}
	
	/**
	 * Liefert alle Foreneinträge, die mit einem bestimmten Buchstaben
	 * beginnen.
	 * Groß- und Kleinschreibung wird hierbei nicht beachtet.
	 * @aram 	char					gesuchter Buchstabe
	 * @return 	ArrayList<ForumEntry>	Liste von Einträgen
	 */
	public ArrayList<ForumEntry> getAllStartingWith(String sub) {
		ArrayList<ForumEntry> res = new ArrayList<ForumEntry>();
		// Alle auslesen
		ArrayList<ForumEntry> all = this.getAll();
		
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
	public ArrayList<ForumEntry> getAllIncluding(String sub) {
		ArrayList<ForumEntry> res = new ArrayList<ForumEntry>();
		// Alle auslesen
		ArrayList<ForumEntry> all = this.getAll();
		
		// Alle finden, die einen gesuchten String enthalten
		for(int i=0; i < all.size(); i++) {
			if(stringContainsSub(all.get(i).getTopic(), sub)) {
				res.add(all.get(i));
			}
		}
		
		return res;
	}
	
	/**
	 * Liefert die ID eines Foreneintrags
	 * @param entry
	 * @return
	 */
	public int getId(ForumEntry entry) {
		/* SQL Abfrage für Id, ausgehend von Date_Time und Author */
		final String SQL_QUERY_GET_ID =
				"SELECT id FROM forum WHERE (date = :date) AND (author = :author)";
		/* Name-Wert Paare für Abfrage festlegen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("author", entry.getAuthor());
		params.put("date", entry.getDate());
		/* id auslesen */
		return this.namedParameterJdbcTemplate.queryForInt(SQL_QUERY_GET_ID, params);
	}
	
	/**
	 * Liefert einen ForenEintrag ausgehend von seiner id.
	 * @param  id	id des gesuchten Eintrags
	 * @return ForumEntry
	 */
	public ForumEntry getById(int id) {
		// SQL
		final String SQL_SELECT_FORUM_ENTRY_BY_ID = "SELECT * FROM forum WHERE (id = :id)";
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (ForumEntry) namedParameterJdbcTemplate.queryForObject(
								// SQL Abfrage
								SQL_SELECT_FORUM_ENTRY_BY_ID,
								// Parameter
								namedParameters,
								this.forumEntryMapper
							);
	}
	
}
