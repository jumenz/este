package fhwedel.medienprojekt.fussball.service.dataErrors;


/** externe Klassen */
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Abstralte Service Klasse
 * Beinhaltet Datenbankabfragen zur Fehlerbehandlung.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public abstract class AbstractDataErrorsDBHelper extends AbstractDataErrors {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/** JDBC Template */
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
	
	/* --------------------- Datenbank ----------------------------- */
	/**
	 * Prüft, ob ein Eingabewert bereits in einer bestimmten Tabelle unter einer 
	 * bestimmten Spalte vorhanden ist.
	 * @param 	table		String						Tabellenname der DB
	 * @param 	col			String						Spaltenname der DB
	 * @param 	value		String						Eingabewert
	 * @return	boolean		true:						Wert ist bereits enthalten
	 * 						false:						Wert ist noch nicht enthalten
	 */
	public boolean inDb(String table, String col, String value) {
		final String SQL_SELECT_STRING =
				"SELECT * FROM " + table + " WHERE " + col + " = :value";
		// Parameter zuweisen
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("value", value);
		SqlRowSet res = this.namedParameterJdbcTemplate.queryForRowSet(SQL_SELECT_STRING, params);
		
		return res.first();
	}
}
