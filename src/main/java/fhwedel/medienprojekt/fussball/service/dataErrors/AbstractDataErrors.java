package fhwedel.medienprojekt.fussball.service.dataErrors;


/** externe Klassen */
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Abstralte Service Klasse
 * Implementiert gemeinsame Methoden für die erbenden Klassen
 * zur Behandlung von Datenerrors, die z.B. bei der Verarbeitung
 * von Formulardaten auftreten können.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public abstract class AbstractDataErrors {
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
	
	/* ------------------- Methoden zum Prüfen der Eingaben -------------------- */
	/**
	 * Prüft, ob ein Eingabewert leer ist.
	 * @param 	value		Eingabewert
	 * @return	boolean		true:	Feld ist leer
	 * 						false:	Feld ist gefüllt
	 */
	public boolean isEmpty(String value) {
		assert(value != null);
		// Das Eingabefeld ist leer, wenn entweder der leere String,
		// oder der Placeholder im Feld enthalten ist.
		return (value.compareTo("")==0);
	}
	
	/**
	 * Prüft, ob der angegebene Wert eine ganze Zahl repräsentiert.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	Wert entspricht einer ganzen Zahl
	 * 					false:	Wert entspricht nicht einer ganzen Zahl oder ist leer
	 */
	public boolean isNumeric(String value) {
		assert(value != null);
		return value.matches("\\d+");
	}
	
	/**
	 * Prüft, ob der angegebene Wert ausschließlich auf Buchstaben aufgebaut ist.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	Wert besteht nur aus Buchstaben
	 * 					false:	Wert ist leer oder enthält weitere Zeichen
	 */
	public boolean onlyLetters(String value) {
		assert(value != null);
		return value.matches("[a-zA-Z]+");
	}
	
	/**
	 * Prüft, ob der Eingabewert alphanumerisch ist.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	Wert ist alphanumerisch
	 * 					false:	Wert ist nicht alphanumerisch oder leer
	 */
	public boolean isAlphanumeric(String value) {
		assert(value != null);
		return value.matches("[0-9a-zA-Z]+");
	}
	
	/**
	 * Prüft, ob der Eingabewert einer Email-Adresse entspricht.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	String entspricht einer Email-Adresse
	 * 					false:	String entspricht nicht einer Email-Adresse
	 */
	public boolean isEmail(String value) {
		assert(value != null);
		return value.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
	}
	
	/**
	 * Prüft, ob der Eingabewert einer Telefonnummer (Vorwahl-Nummer) entspricht.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	String entspricht einer Telefonnummer
	 * 					false:	String entspricht nicht einer Telefonnummer
	 */
	public boolean isPhoneNumber(String value) {
		assert(value != null);
		return value.matches("[0-9]+-[0-9]+");
	}
	
	/**
	 * Prüft, ob der Eingabewert einem Datum (Tag.Monat.Jahr) entspricht.
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	String entspricht einer Telefonnummer
	 * 					false:	String entspricht nicht einer Telefonnummer
	 */
	public boolean isDate(String value) {
		assert(value != null);
		return value.matches("([0-9]{1,2}).([0-9]{1,2}).([0-9]{2,4})");
	}
	
	/**
	 * Prüft zwei Eingabewerte auf Gleichheit.
	 * @param 	one		String	Eingabewert
	 * @param 	other	String	Eingabewert
	 * @return	boolean	true:	Eingabewerte sind gleich
	 * 					false:	Eingabewerte sind nicht gleich
	 */
	public boolean areSame(String one, String other) {
		assert(one != null);
		assert(other != null);
		return one.equals(other);
	}
	
	/**
	 * Prüft ob ein Eingabewert einer geforderten Länge entspricht.
	 * @param 	value	String	Eingabewert
	 * @param 	min		int		Minimallänge
	 * @param 	max		int		Maximallänge
	 * @return	boolean	true:	Eingabewert hat die geforderte Länge
	 * 					false:	Eingabewert hat nicht die geforderte Länge
	 */
	public boolean checkLength(String value, int min, int max) {
		assert(value != null);
		assert (min <= max);
		int length = value.length();
		
		return (length >= min) && (length <= max);
	}

	/**
	 * Prüft, ob ein Eingabewert bereits in einer bestimmten Tabelle unter einer 
	 * bestimmten Spalte vorhanden ist.
	 * @param 	table	String	Tabellenname der DB
	 * @param 	col		String	Spaltenname der DB
	 * @param 	value	String	Eingabewert
	 * @return	boolean	true:	Wert ist bereits enthalten
	 * 					false:	Wert ist noch nicht enthalten
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
