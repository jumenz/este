package fhwedel.medienprojekt.fussball.service;

/** Externe Klassen */
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;


public class ForumEntryMapper {
	/**
	 * Konstruktorfunktion
	 */
	public ForumEntryMapper() {}
	
	/**
	 * Weist die Spalten des Ergebnis den Variablen eines Forum Eintrags zu.
	 * @param res	ResultSet
	 * @param rowNum
	 * 
	 * @return ForumEntry
	 * @throws SQLException
	 */
	public ForumEntry mapRow(ResultSet res, int rowNum) throws SQLException {
		// Objekt erzeugen
		ForumEntry entry = new ForumEntry();
		// Spalten des Ergebnisses zuweisen
		entry.setId(res.getInt(0));
		entry.setDate(res.getDate(1));
		entry.setAuthor(res.getString(2));
		entry.setTopic(res.getString(3));
		entry.setDescription(res.getString(4));
		entry.setText(res.getString(5));
		
		return entry;
	}
}
