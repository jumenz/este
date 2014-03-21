package fhwedel.medienprojekt.fussball.service;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.model.post.report.Scores;

public class DataAccessReports {
	/** JDBC Template */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public DataAccessReports() {}
	
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessReports(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
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
	
	/**
	 * Speichert einen neuen Spielbericht.
	 * @param newReport	Bericht
	 */
	public void save(Report newReport) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO forum (:date, :time, author, topic, text, opponent"
				+ "first_half_home, first_half_guest, second_half_home, second_half_guest) "
				+ "VALUES (CURDATE(), CURTIME(), :author, :topic, :text, :opponent, "
				+ ":first_half_home, :first_half_guest, :second_half_home, :second_half_guest)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("author", newReport.getAuthor());
		params.put("topic", newReport.getTopic());
		params.put("text", newReport.getText());
		params.put("opponent", newReport.getOpponent());
		params.put("first_half_home", newReport.getScore(Scores.FIRST_HALF_HOME));
		params.put("first_half_guest", newReport.getScore(Scores.FIRST_HALF_GUEST));
		params.put("second_half_home", newReport.getScore(Scores.SECOND_HALF_HOME));
		params.put("second_half_guest", newReport.getScore(Scores.SECOND_HALF_GUEST));
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
		newReport.setId();
	}
	
	/**
	 * Liefert die id eines Spielberichts.
	 * @param entry	Spielbericht, zu dem die id gesucht wird
	 * @return	int
	 */
	public int getId(Report entry) {
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
	public Report getById(int id) {
		// SQL
		final String SQL_SELECT_FORUM_ENTRY_BY_ID = "SELECT * FROM forum WHERE (id = :id)";
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (Report) namedParameterJdbcTemplate.queryForObject(
								// SQL Abfrage
								SQL_SELECT_FORUM_ENTRY_BY_ID,
								// Parameter
								namedParameters,
								// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
								new ParameterizedRowMapper<Report>() {
									public Report mapRow(ResultSet res, int rowNum) throws SQLException {
										// Objekt erzeugen
										Report entry = new Report();
										// Spalten des Ergebnisses zuweisen
										entry.setId(res.getInt(0));
										entry.setDate(res.getDate(1));
										entry.setAuthor(res.getString(2));
										entry.setTopic(res.getString(3));
										entry.setText(res.getString(4));
										entry.setOpponent(res.getString(5));
										entry.setScore(Scores.FIRST_HALF_HOME, res.getInt(6));
										entry.setScore(Scores.FIRST_HALF_GUEST, res.getInt(7));
										entry.setScore(Scores.SECOND_HALF_HOME, res.getInt(8));
										entry.setScore(Scores.SECOND_HALF_GUEST, res.getInt(9));
										
										return entry;
									}								
								}
							); /* TODO Report Row Mapper verwenden */
	}
	
	/**
	 * Liefert eine Liste aller Reports.
	 * @return ArrayList<Report>
	 */
	public ArrayList<Report> getAll() {
		/** Beispiel named Parameter */
		/* public void addSpitter(Spitter spitter){
		*	Map<String,Object> params=newHashMap<String,Object>();
		*	params.put("username",spitter.getUsername());
		*	params.put("password",spitter.getPassword());
		*	params.put("fullname",spitter.getFullName());
		*	jdbcTemplate.update(SQL_INSERT_SPITTER,params);
		*	spitter.setId(queryForIdentity());
		*	}*/
		return new ArrayList<Report>();
	}
	
}
