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
					if(groupName == "USER_GROUP_ADMIN") {
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
				"INSERT INTO users (username, email, password, user_group) "
				+ "VALUES (:username, :email, :password, :user_group)";
		
		// TODO Verschlüsselung
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
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
		final String SQL_SELECT_ALL_USERS = "SELECT * FROM users ORDER BY username DESC";

		return (ArrayList<User>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_USERS,
				this.userMapper
			);
	}
	
	/**
	 * Überprüft die Login Daten auf Richtigkeit.
	 * @param 	user	Userdaten
	 * @return	boolean	true:	Logindaten stimmen
	 * 					false:	Logindaten sind falsch
	 */
	public boolean checkLogin(User user) {
		// final SQL_GET_USERNAME_AND_PASSWORD 
		
		return true;
	}

}
