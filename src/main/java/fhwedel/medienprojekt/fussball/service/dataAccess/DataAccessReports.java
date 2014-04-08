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






import fhwedel.medienprojekt.fussball.model.pagination.Page;
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
	 * Ordnet die Werte eines Reports eine Parameterliste zu.
	 * @param report	Report
	 * @param params	Map<String,Object>
	 */
	private void mapParams(Report report, Map<String,Object> params, boolean updateDate) {
		// Name-Wert-Paare zuordnen
		Date date = (updateDate) ? new Date() : report.getDate();
		params.put("date", date);
		params.put("author", report.getAuthor());
		params.put("topic", report.getTopic());
		params.put("text", report.getText());
		params.put("opponent", report.getOpponent());
		params.put("first_half_home", report.getScoreFirstHalfHome());
		params.put("first_half_guest", report.getScoreFirstHalfGuest());
		params.put("second_half_home", report.getScoreSecondHalfHome());
		params.put("second_half_guest", report.getScoreSecondHalfGuest());
	}
	
	/**
	 * Speichert einen neuen Spielbericht.
	 * @param newReport	Bericht
	 */
	public void save(Report newReport) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO " + Constants.dbReports 
				+ " ("
				+ Constants.dbReportsDate + ", "
				+ Constants.dbReportsAuthor + ", "
				+ Constants.dbReportsTopic + ", "
				+ Constants.dbReportsText + ", "
				+ Constants.dbReportsOpponent + ", "
				+ Constants.dbReportsScoreFirstHalfHome + ", "
				+ Constants.dbReportsScoreFirstHalfGuest + ", "
				+ Constants.dbReportsScoreSecondHalfHome + ", "
				+ Constants.dbReportsScoreSecondHalfGuest
				+ ") VALUES (:date, :author, :topic, :text, :opponent, "
				+ ":first_half_home, :first_half_guest, :second_half_home, :second_half_guest)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		this.mapParams(newReport, params, true);
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
	}
	
	/* ------------------ Bearbeiten ------------------------- */
	
	/**
	 * Updated einen bearbeiteten Spielbericht ausgehend von seiner ID.
	 * @param id		int		ID des Spielberichts
	 * @param report	Report	berarbeiteter Spielbericht
	 */
	public void update(int id, Report report) {
		/* SQL Befehl*/
		final String SQL_UPDATE_REPORT = 
				"UPDATE " + Constants.dbReports
				+ " SET "
				+ Constants.dbReportsAuthor + " = :author, "
				+ Constants.dbReportsTopic + " = :topic, "
				+ Constants.dbReportsText + " = :text, "
				+ Constants.dbReportsOpponent + " = :opponent, "
				+ Constants.dbReportsScoreFirstHalfHome + " = :first_half_home, "
				+ Constants.dbReportsScoreFirstHalfGuest + " = :first_half_guest, "
				+ Constants.dbReportsScoreSecondHalfHome + " = :second_half_home, "
				+ Constants.dbReportsScoreSecondHalfGuest + " = :second_half_guest "
				+ "WHERE " + Constants.dbReportsId + " = :id";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		this.mapParams(report, params, false);
		// zusätzlich auch id setzen
		params.put("id", id);
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_UPDATE_REPORT, params);
	}
	
	/**
	 * Löscht einen Spielbericht ausgehend von seiner id.
	 * @param 	id	int		ID des Spielberichts
	 */
	public void deleteById(int id) {
		final String SQL_DELETE_REPORT_BY_ID = 
				"DELETE FROM " + Constants.dbReports + " WHERE " + Constants.dbReportsId + " = :id";
		
		// ID setzen
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		// löschen
		this.namedParameterJdbcTemplate.update(SQL_DELETE_REPORT_BY_ID, params);
	}
	
	/* ----------------------- Auslesen --------------------------------- */
	/**
	 * Liefert einen Spielbericht ausgehend von seiner id.
	 * @param  id	id des gesuchten Eintrags
	 * @return ForumEntry
	 */
	public Report getById(int id) {
		final String SQL_SELECT_REPORT_BY_ID = 
				"SELECT * FROM " + Constants.dbReports + " WHERE " + Constants.dbReportsId + " = :id";
		
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
		final String SQL_SELECT_ALL_REPORTS = 
				"SELECT * FROM " + Constants.dbReports + " ORDER BY date DESC";
		
		// Alle Einträge auslesen
		return (ArrayList<Report>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_REPORTS,
				this.reportRowMapper
			);
	}
	
	/**
	 * Liefert die Seitenansicht der Spielberichte.
	 * @param 	currPage	int		anzuzeigende Seite
	 * @param 	pageSize	int		Anzahl der Einträge pro Seite		
	 * @return	Page<Report>	Seite mit Einträgen
	 */
	public Page<Report> getPage(int currPage, int pageSize) {
		return this.fetchPage(Constants.dbReports, currPage, pageSize, this.reportRowMapper);
	}
	
}