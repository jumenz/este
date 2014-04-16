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
import fhwedel.medienprojekt.fussball.model.user.Permission;
import fhwedel.medienprojekt.fussball.model.user.User;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Usern.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende User.
 */
public class DataAccessPermissions extends AbstractDataAccess<Permission> {
	/* ----------------------- Klassenvariablen --------------------------------- */
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
					permission.setAdminStatus(resultSet.getBoolean(3));
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
		final String SQL_INSERT_NEW_PERMISSION = 
				"INSERT INTO " + Constants.dbPermissions 
				+ " ("
				+ Constants.dbPermissionsEmail + ", "
				+ Constants.dbPermissionsAdminState
				+ ") VALUES (:email, :admin_state)";

		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", permission.getEmail());
		params.put("admin_state", permission.getAdminStatus());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_NEW_PERMISSION, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Hilfsfunktion.
	 * Liest die zu einem User zugehörigen Daten aus der Permissiontabelle
	 * @param 	user		User		User, zu dem die Permission ausgelesen werden soll
	 * @return	ArrayList<Permission>	Registrierungszulassung
	 */
	private ArrayList<Permission> getPermissionData(User user) {
		// Die Email-Adresse des Users muss in der Permission-Tabelle eingetragen sein
		final String SQL_GET_PERMISSION = 
				"SELECT * FROM " + Constants.dbPermissions 
				+ " WHERE ("
				+ Constants.dbPermissionsEmail
				+ " = :email)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", user.getEmail());
		
		// Permission Data auslesen
		return (ArrayList<Permission>) this.namedParameterJdbcTemplate.query(SQL_GET_PERMISSION, params, this.permissionMapper);
	}
	
	/**
	 * Prüft, ob ein User zur Registrierung zugelassen ist.
	 * @param 	user	User	zu überprüfender User
	 * @return	boolean	true:	User ist zugelassen
	 * 					false:	User ist nicht zugelassen
	 */
	public boolean hasPermission(User user) {
		// Die Email-Adresse des Users muss in der Permission-Tabelle eingetragen sein
		return !this.getPermissionData(user).isEmpty();
	}
	
	/**
	 * Liefert die Inforation, ob ein User als Admin angelegt wurde.
	 * @param 	user	User	Userinformationen
	 * @return	boolean	true:	User hat Adminstatus
	 * 					false:	User hat keinen Adminstatus
	 */
	public boolean isAdmin(User user) {
		// Permissondaten auslesen
		ArrayList<Permission> permissions = this.getPermissionData(user);
		assert (!permissions.isEmpty()) : "Fehler beim Auslesen der Userdaten";
		assert (permissions.size() == 1) : "Mehrere Permissiondatensätze zu diesem User gefunden.";
		// Status zurückgeben
		return permissions.get(0).getAdminStatus();
	}
	
	/**
	 * Liefert die Id einer Permission.
	 * @param 	user	User
	 * @return	int		ID
	 */
	public int getPermissionId(User user) {
		// Permissondaten auslesen
		ArrayList<Permission> permissions = this.getPermissionData(user);
		assert (!permissions.isEmpty()) : "Fehler beim Auslesen der Userdaten";
		assert (permissions.size() == 1) : "Mehrere Permissiondatensätze zu diesem User gefunden.";
		// Status zurückgeben
		return permissions.get(0).getId();
	}
	
	/**
	 * Liefert eine Permission ausgehend von der ID.
	 * @param 	id	int	ID der Permission
	 * @return	Permission
	 */
	public Permission getPermissionById(int id) {
		return this.getById(id, Constants.dbPermissions, this.permissionMapper);
	}
	
	/**
	 * Liest alle Permissions aus der Datenbank aus.
	 * @return ArrayList<Permission>	Liste aller Permissions
	 */
	public ArrayList<Permission> getAll() {
		return this.getAll(Constants.dbPermissions, this.permissionMapper);
	}
	
	/* ---------------- Bearbeiten ------------------------ */
	/**
	 * Ändert den Admin Status eines Users in der Permissiontabelle.
	 * @param 	id	int	ID des Users, dessen Admin-Status geändert werden soll.
	 */
	public void changeUserStatus(int id) {
		final String SQL_UPDATE_USER_STATUS = 
				"UPDATE " + Constants.dbPermissions 
				+ " SET "
				+ Constants.dbPermissionsAdminState
				+ " = :admin_state WHERE ("
				+ Constants.dbPermissionsId
				+ " = :id)";
		
		Permission res = this.getPermissionById(id);
		if (res != null) {
			/* Name-Wert Paare für Abfrage festlegen */
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", id);
			params.put("admin_state", !res.getAdminStatus());
			
			/* Datensatz updaten und Nummer an betroffenen Reihen auf 1 überprüfen */
			this.namedParameterJdbcTemplate.update(SQL_UPDATE_USER_STATUS, params);
		}
	}
	
	/**
	 * Ändert die E-Mail-Adresse eines Users in der Permissiontabelle.
	 * @param 	id		int		ID des Users, dessen E-Mail-Adresse geändert werden soll.
	 * @param 	email	String 	neue E-Mail-Adresse.
	 */
	public void updateEmail(int id, String email) {
		final String SQL_UPDATE_USER_EMAIL = 
				"UPDATE " + Constants.dbPermissions + " SET "
				+ Constants.dbPermissionsEmail + " = :email WHERE ("
				+ Constants.dbPermissionsId + " = :id)";
		
		Permission res = this.getPermissionById(id);
		if (res != null) {
			/* Name-Wert Paare für Abfrage festlegen */
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", id);
			params.put("email", email);
			
			/* Datensatz updaten  */
			this.namedParameterJdbcTemplate.update(SQL_UPDATE_USER_EMAIL, params);
		}
	}

	/* ----------------- Löschen -------------------------- */
	/**
	 * Löscht eine Registrierungs-Erlaubnis.
	 * @param 	id	id der Erlaubnis, die gelöscht werden soll
	 */
	public void remove(int id) {
		this.deleteById(id, Constants.dbPermissions);
	}
}
