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
	
	/** JDBC Template */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/**
	 * Konstruktorfunktion.
	 */
	public DataAccessForum() {}
	
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessForum(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
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
	
	public void save(ForumEntry newForumEntry) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO forum (date, author, topic, description, text, has_comments) "
				+ "VALUES (CURDATE(), :author, :topic, :description, :text, :has_comments)";
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
								}
							);
	}
		/* TODO Kommentarliste laden */
	
	public ArrayList<ForumEntry> getAll() {
		final String SQL_ALL_FORUM_ENTRIES = "SELECT * FROM forum";
		
		return (ArrayList<ForumEntry>) namedParameterJdbcTemplate.query(
				SQL_ALL_FORUM_ENTRIES,
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
				}
			);
	}
	
}
