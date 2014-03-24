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
import fhwedel.medienprojekt.fussball.model.user.Permission;
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.model.user.UserGroup;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Usern.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende User.
 * 
 * @author Ellen
 *
 */
public class DataAccessPermissions extends AbstractDataAccess {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/** Name der Datenbank tabelle */
	private final String tablePermissions = "permissions";
	/**
	 * Permission Mapper
	 */
	private ParameterizedRowMapper<Permission> permissionMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<Permission>() {
				/**
				 * Row Mapper
				 */
				public Permission mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					Permission permission = new Permission();
					// Spalten des Ergebnisses zuweisen
					permission.setId(resultSet.getInt(1));
					permission.setEmail(resultSet.getString(2));
					
					return permission;
				}
			};
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessPermissions() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessPermissions(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert einen neuen ForenEintrag.
	 * @param newForumEntry Eintrag
	 */
	public void save(Permission permission) {
		/* SQL Befehl*/
		final String SQL_INSERT_NEW_PERMISSION = "INSERT INTO " + this.tablePermissions + " (email) VALUES (:email)";

		// TODO Verschlüsselung
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", permission.getEmail());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_NEW_PERMISSION, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Prüft, ob ein User zur Registrierung zugelassen ist.
	 * @param 	user	User	zu überprüfender User
	 * @return	boolean	true:	User ist zugelassen
	 * 					false:	User ist nicht zugelassen
	 */
	public boolean hasPermission(User user) {
		// Die Email-Adresse des Users muss in der Permission-Tabelle eingetragen sein
		final String SQL_GET_PERMISSION = "SELECT * FROM " + this.tablePermissions + " WHERE (email = :email)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", user.getEmail());
		return !this.namedParameterJdbcTemplate.query(SQL_GET_PERMISSION, params, this.permissionMapper).isEmpty();
	}
	
	/**
	 * Liest alle Permissions aus der Datenbank aus.
	 * @return ArrayList<Permission>	Liste aller Permissions
	 */
	public ArrayList<Permission> getAll() {
		// Alle Foren-Einträge aus Datenbank auslesen
		final String SQL_SELECT_ALL_PERMISSIONS = "SELECT * FROM " + this.tablePermissions;
		
		return (ArrayList<Permission>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_PERMISSIONS,
				this.permissionMapper
			);
	}

	/* ----------------- Löschen -------------------------- */
	/**
	 * Löscht eine Registrierungs-Erlaubnis.
	 * @param 	id	id der Erlaubnis, die gelöscht werden soll
	 */
	public void remove(int id) {
		final String SQL_DELETE_PERMISSION = "DELETE FROM " + this.tablePermissions + " WHERE (id = :id)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		namedParameterJdbcTemplate.update(SQL_DELETE_PERMISSION, params);
	}
}
