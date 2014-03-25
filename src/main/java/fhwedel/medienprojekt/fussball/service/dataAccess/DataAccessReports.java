package fhwedel.medienprojekt.fussball.service.dataAccess;

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





import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.model.post.report.Scores;

public class DataAccessReports extends AbstractDataAccessPost<Report> {
	/* ---------------------- Klassenvariablen ------------------------------ */
	/** Row Mapper */
	private ParameterizedRowMapper<Report> reportRowMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<Report>() {
				public Report mapRow(ResultSet res, int rowNum) throws SQLException {
					// Objekt erzeugen
					Report entry = new Report();
					// Spalten des Ergebnisses zuweisen
					entry.setId(res.getInt(1));
					entry.setDate(res.getDate(2));
					entry.setAuthor(res.getString(3));
					entry.setTopic(res.getString(4));
					entry.setText(res.getString(5));
					entry.setOpponent(res.getString(6));
					entry.setScoreFirstHalfHome(res.getInt(7));
					entry.setScoreFirstHalfGuest(res.getInt(8));
					entry.setScoreSecondHalfHome(res.getInt(9));
					entry.setScoreSecondHalfGuest(res.getInt(10));

					return entry;
				}								
			};
	
	/* --------------------- Konstruktorfunktionen -------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessReports() {}
	
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessReports(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ------------------- Datenbankarbeit ----------------------------- */
	/* ------------------- Speichern ----------------------------------- */
	/**
	 * Speichert einen neuen Spielbericht.
	 * @param newReport	Bericht
	 */
	public void save(Report newReport) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO report (date, author, topic, text, opponent, "
				+ "first_half_home, first_half_guest, second_half_home, second_half_guest) "
				+ "VALUES (:date, :author, :topic, :text, :opponent, "
				+ ":first_half_home, :first_half_guest, :second_half_home, :second_half_guest)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", new Date());
		params.put("author", newReport.getAuthor());
		params.put("topic", newReport.getTopic());
		params.put("text", newReport.getText());
		params.put("opponent", newReport.getOpponent());
		params.put("first_half_home", newReport.getScoreFirstHalfHome());
		params.put("first_half_guest", newReport.getScoreFirstHalfGuest());
		params.put("second_half_home", newReport.getScoreSecondHalfHome());
		params.put("second_half_guest", newReport.getScoreSecondHalfGuest());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
	}
	
	/* ----------------------- Auslesen --------------------------------- */
	/**
	 * Liefert die id eines Spielberichts.
	 * @param entry	Spielbericht, zu dem die id gesucht wird
	 * @return	int
	 */
	public int getId(Report entry) {
		/* SQL Abfrage für Id, ausgehend von Date_Time und Author */
		final String SQL_QUERY_GET_ID =
				"SELECT id FROM report WHERE (date = :date) AND (author = :author)";
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
		final String SQL_SELECT_REPORT_BY_ID = "SELECT * FROM report WHERE (id = :id)";
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (Report) namedParameterJdbcTemplate.queryForObject(
								// SQL Abfrage
								SQL_SELECT_REPORT_BY_ID,
								// Parameter
								namedParameters,
								this.reportRowMapper
							);
	}
	
	/**
	 * Liefert eine Liste aller Reports.
	 * @return ArrayList<Report>
	 */
	public ArrayList<Report> getAll() {
		final String SQL_SELECT_ALL_REPORTS = "SELECT * FROM report";
		return (ArrayList<Report>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_REPORTS,
				this.reportRowMapper
			);
	}
}
