package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * Abstralte Service Klasse
 * Implementiert enthält das JDBC Template für die Datenbankarbeit.
 * 
 * @author Ellen Schwartau Minf 9888
 *
 */
public abstract class AbstractDataAccess<E> {
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
	
	/* ---------------- Methoden ----------------------------------- */
	/**
	 * Löscht einen Post ausgehend von seiner id.
	 * @param 	id	int		ID des Eintrags
	 */
	public void deleteById(int id, String db) {
		final String SQL_DELETE_BY_ID = "DELETE FROM " + db + " WHERE id=:id";
		// ID setzen
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		// löschen
		this.namedParameterJdbcTemplate.update(SQL_DELETE_BY_ID, params);
	}
	
	/**
	 * Liefert einen Post ausgehend von seiner id.
	 * @param  id	id des gesuchten Eintrags
	 * @return Post
	 */
	public E getById(int id, String db, ParameterizedRowMapper<E> rowMapper) {
		final String SQL_SELECT_BY_ID = 
				"SELECT * FROM " + db + " WHERE " + Constants.dbReportsId + " = :id";
		
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Post-Eintrag mappen
		try {
			return (E) namedParameterJdbcTemplate.queryForObject(
									// SQL Abfrage
									SQL_SELECT_BY_ID,
									// Parameter
									namedParameters,
									rowMapper
								);
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	/**
	 * Liest alle Einträge aus einer Datenbank aus.
	 * @param	db			String						Datenbankname
	 * @param	rowMapper	ParameterizedRowMapper<E>	Mapper
	 * @return 	ArrayList<ForumEntry>		Liste aller Foreneinträge
	 */
	public ArrayList<E> getAll(String db, ParameterizedRowMapper<E> rowMapper) {
		final String SQL_SELECT_ALL = 
				"SELECT * FROM " + db;
		
		// Alle Einträge auslesen
		return (ArrayList<E>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL,
				rowMapper
			);
	}
	
}
