package fhwedel.medienprojekt.fussball.service;

/** Externe Klassen */
import java.sql.ResultSet;  
import java.sql.SQLException;  
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.model.post.report.Scores;

/**
 * Hilfsklasse, um ein Ergebnis aus der Datenbank auf einen Report zuzuweisen.
 * 
 * @author Ellen
 */
public class ReportMapper {
	/**
	 * Konstruktorfunktion
	 */
	public ReportMapper() {}
	
	/**
	 * Weist die Spalten des Ergebnis den Variablen eines Spielberichts zu.
	 * @param res	ResultSet
	 * @param rowNum
	 * 
	 * @return ForumEntry
	 * @throws SQLException
	 */
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
