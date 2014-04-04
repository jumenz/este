package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



import org.springframework.validation.BindingResult;

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
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataAccessUsers extends AbstractDataAccess {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * User Mapper
	 */
	private ParameterizedRowMapper<User> userMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<User>() {
				/**
				 * Liefert zu einem String die entsprechende UserGroup.
				 * @param 	groupName	String	Name der Gruppe
				 * @return	UserGroup	entsprechende Gruppe
				 */
				public UserGroup getUserGroupFromString(String groupName) {
					if(groupName.compareTo("USER_GROUP_ADMIN")==0) {
						return UserGroup.USER_GROUP_ADMIN;
					}
					return UserGroup.USER_GROUP_NO_ADMIN;
				}
		
				/**
				 * Row Mapper
				 */
				public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					User entry = new User();
					// Spalten des Ergebnisses zuweisen
					entry.setId(resultSet.getInt(1));
					entry.setUsername(resultSet.getString(2));
					entry.setEmail(resultSet.getString(3));
					entry.setPassword(resultSet.getString(4));
					entry.setUserGroup(getUserGroupFromString(resultSet.getString(5)));
					
					return entry;
				}
			};
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessUsers() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessUsers(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert einen neuen ForenEintrag.
	 * @param newForumEntry Eintrag
	 */
	public void save(User newUser) {
		/* SQL Befehl*/
		final String SQL_INSERT_NEW_USER = 
				"INSERT INTO " + Constants.dbUsers 
				+ " ("
				+ Constants.dbUsersId 		 + ", "
				+ Constants.dbUsersUsername  + ", "
				+ Constants.dbUsersEmail	 + ", "
				+ Constants.dbUsersPassword	 + ", "
				+ Constants.dbUsersUserGroup
				+ ") VALUES (:id, :username, :email, :password, :user_group)";
		
		// TODO Verschlüsselung
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", newUser.getId());
		params.put("username", newUser.getUsername());
		params.put("email", newUser.getEmail());
		params.put("password", newUser.getPassword());
		params.put("user_group", newUser.getUserGroupString());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_NEW_USER, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle User aus der Datenbank aus.
	 * 
	 * @return ArrayList<ForumEntry>	Liste aller Foreneinträge
	 */
	public ArrayList<User> getAll() {
		// Alle Foren-Einträge nach Datum sortiert auslesen (neueste zuerst)
		final String SQL_SELECT_ALL_USERS = 
				"SELECT * FROM " + Constants.dbUsers + " ORDER BY username DESC";

		return (ArrayList<User>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_USERS,
				this.userMapper
			);
	}
	
	/* -------------------- Login --------------------------------------- */
	/**
	 * Liest die Datenbankinformationen ausgehen vom username aus der Datenbank aus.
	 * @param 	username		String		Username
	 * @param	password		String		password
	 * @return	ArrayList<User>	Ergebnisse aus Datenbank
	 */
	public ArrayList<User> getUserData(String username) {
		final String SQL_GET_USER_BY_USERNAME = 
				"SELECT * FROM " + Constants.dbUsers 
				+ " WHERE ("
				+ Constants.dbUsersUsername + " = :username)";
		/* Name-Wert Paare für Abfrage festlegen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("username", username);
		
		return (ArrayList<User>) this.namedParameterJdbcTemplate.query(SQL_GET_USER_BY_USERNAME, params, this.userMapper);
	}
	
	/* ---------------- User Group ----------------------------------------- */
	/**
	 * Liefert die Usergroup zu einem usernamen und dem zugehörigen Passwort.
	 * @param 	username	String	Username
	 * @param 	password	String	Passwort
	 * @return	UserGroup
	 */
	public UserGroup getUserGroup(String username, String password) {
		// TODO nur über Usernamen?
		/* Userdaten auslesen, und sichergehen, dass nur ein Element gefunden */
		ArrayList<User> userData = this.getUserData(username);
		assert (userData.size()==1): "Mehrere User mit diesen Zugangsdaten vorhanden.";
		
		return userData.get(0).getUserGroup();
	}
	
/**
 * Liefert einen User ausgehend von einer id.
 * @param 	id		int		ID des Users
 * @return	User			ausgelesener User
 */
private User getUserById(int id) {
	final String SQL_SELECT_USER_BY_ID = 
			"SELECT * FROM " + Constants.dbUsers 
			+ " WHERE ("
			+ Constants.dbUsersId + " = :id)";
	/* Name-Wert Paare für Abfrage festlegen */
	Map<String,Object> params = new HashMap<String,Object>();
	params.put("id", id);
	/* User auslesen */
	ArrayList<User> res 
		= (ArrayList<User>) this.namedParameterJdbcTemplate.query(
								SQL_SELECT_USER_BY_ID, 
								params, 
								this.userMapper
							);
	return (res.isEmpty()) ? null : res.get(0);
}
	
	/**
	 * Ändert den Admin-Status eines Users.
	 * @param 	id	int	ID des Users, dessen Status geändert werden soll.
	 */
	public void changeUserStatus(int id) {
		final String SQL_UPDATE_USER_STATUS = 
				"UPDATE " + Constants.dbUsers 
				+ " SET "
				+ Constants.dbUsersUserGroup + " = :user_group "
				+ "WHERE ("
				+ Constants.dbUsersId + " = :id)";
		
		/* Neue User Group bestimmen */
		User user = getUserById(id);
		/* Wenn User vorhanden ist */
		if (user != null) {
			UserGroup newUserGroup = (user.getUserGroup() == UserGroup.USER_GROUP_ADMIN) 
									  ? UserGroup.USER_GROUP_NO_ADMIN 
									  : UserGroup.USER_GROUP_ADMIN;
			user.setUserGroup(newUserGroup);
			
			/* Name-Wert Paare für Abfrage festlegen */
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", id);
			params.put("user_group", user.getUserGroupString());
			
			/* Datensatz updaten und Nummer an betroffenen Reihen auf 1 überprüfen */
			this.namedParameterJdbcTemplate.update(SQL_UPDATE_USER_STATUS, params);
		}
	}
}
