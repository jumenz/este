package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.util.ArrayList;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/**
 * Abstralte Service Klasse
 * Implementiert gemeinsame Methoden für die erbenden Klassen
 * 
 * @author Ellen
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
	
}
