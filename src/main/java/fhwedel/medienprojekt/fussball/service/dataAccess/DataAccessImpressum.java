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
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.statics.ImpressumContent;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Laden, Bearbeiten und speichern
 * des Impressums.
 */
public class DataAccessImpressum extends AbstractDataAccess<ImpressumContent> {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * Mapper
	 */
	private ParameterizedRowMapper<ImpressumContent> contentMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<ImpressumContent>() {
				/**
				 * Row Mapper
				 */
				public ImpressumContent mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					ImpressumContent content = new ImpressumContent();
					// Spalten des Ergebnisses zuweisen
					content.setText(resultSet.getString(1));
					
					return content;
				}
			};
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessImpressum() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessImpressum(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert den neuen Inhalt des Impressums.
	 * @param content	ImpressumContent	Content
	 */
	public void save(ImpressumContent content) {
		/* SQL Befehl*/
		final String SQL_CLEAR_IMPRESSUM = "TRUNCATE " + Constants.dbImpressum;
		final String SQL_INSERT_IMPRESSUM = 
				"INSERT " + Constants.dbImpressum 
				+ " ("
				+ Constants.dbImpressumText
				+ ") VALUES (:text)";

		// TODO Verschlüsselung
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("text", content.getText());

		/* leeren und neu befüllen */
		this.namedParameterJdbcTemplate.update(SQL_CLEAR_IMPRESSUM, new HashMap<String,Object>());
		this.namedParameterJdbcTemplate.update(SQL_INSERT_IMPRESSUM, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liefert den Inhalt des Impressums
	 * @return ImpressumContent	Inhalt
	 */
	public ImpressumContent getContent() {
		final String SQL_GET_IMPRESSUM_CONTENT = 
				"SELECT * FROM " + Constants.dbImpressum; 
		ArrayList<ImpressumContent> list = (ArrayList<ImpressumContent>)  this.namedParameterJdbcTemplate.query(SQL_GET_IMPRESSUM_CONTENT, new HashMap<String,Object>(), this.contentMapper);
		// Falls die Tabelle leer ist, eine neue Instanz zurück geben
		return (!list.isEmpty()) ? list.get(0) : new ImpressumContent();
	}

}
