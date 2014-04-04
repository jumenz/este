package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import fhwedel.medienprojekt.fussball.model.statics.AboutUsContent;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.Permission;
import fhwedel.medienprojekt.fussball.model.user.User;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Laden, Bearbeiten und Speichern
 * des Contents der Über Uns-Seite
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataAccessAboutUs extends AbstractDataAccess {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * Mapper
	 */
	private ParameterizedRowMapper<AboutUsContent> contentMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<AboutUsContent>() {
				/**
				 * Row Mapper
				 */
				public AboutUsContent mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					AboutUsContent content = new AboutUsContent();
					// Spalten des Ergebnisses zuweisen
					content.setCompanyText(resultSet.getString(1));
					content.setTeamText(resultSet.getString(2));
					content.setTrainerFirstPartText(resultSet.getString(3));
					content.setTrainerSecondtPartText(resultSet.getString(4));
					content.setTrainingText(resultSet.getString(5));
					content.setApproachPlayingFieldTrainingText(resultSet.getString(6));
					content.setApproachPlayingFieldMatchText(resultSet.getString(7));
					content.setApproachPublicTransportText(resultSet.getString(8));
					content.setContactText(resultSet.getString(9));
					return content;
				}
			};
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessAboutUs() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessAboutUs(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert den neuen Inhalt der ÜberUns-Seite.
	 * @param content	AboutUsContent	Content
	 */
	public void save(AboutUsContent content) {
		/* SQL Befehl*/
		final String SQL_CLEAR_ABOUT_US = "TRUNCATE " + Constants.dbAboutUs;
		final String SQL_INSERT_ABOUT_US_CONTENT = 
				"INSERT " + Constants.dbAboutUs 
				+ " ("
				+ Constants.dbAboutUsCompany + ", "
				+ Constants.dbAboutUsTeam + ", "
				+ Constants.dbAboutUsTrainerFirst + ", "
				+ Constants.dbAboutUsTrainerSecond + ", "
				+ Constants.dbAboutUsTraining + ", "
				+ Constants.dbAboutUsApproachNfd + ", "
				+ Constants.dbAboutUsApproachC + ", "
				+ Constants.dbAboutUsApproachPt + ", "
				+ Constants.dbAboutUsContact
				+ ") VALUES (:company, :team, :trainerFirst, :trainerSecond, :training, :approachNfd, :approachC, :approachPt, :contact)";

		// TODO Verschlüsselung
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("company", content.getCompanyText());
		params.put("team", content.getTeamText());
		params.put("trainerFirst", content.getTrainerFirstPartText());
		params.put("trainerSecond", content.getTrainerSecondPartText());
		params.put("training", content.getTrainingText());
		params.put("approachNfd", content.getApproachPlayingFieldTrainingText());
		params.put("approachC", content.getApproachPlayingFieldMatchText());
		params.put("approachPt", content.getApproachPublicTransportText());
		params.put("contact", content.getContactText());
		
		/* leeren und neu befüllen */
		this.namedParameterJdbcTemplate.update(SQL_CLEAR_ABOUT_US, new HashMap<String,Object>());
		this.namedParameterJdbcTemplate.update(SQL_INSERT_ABOUT_US_CONTENT, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liefert die Inhalte für die Über-Uns-Seite.
	 * @return AboutUsContent	Inhalte
	 */
	public AboutUsContent getAboutUsContent() {
		final String SQL_GET_ABOUT_US_CONTENT = 
				"SELECT * FROM " + Constants.dbAboutUs; 
		ArrayList<AboutUsContent> list = (ArrayList<AboutUsContent>)  this.namedParameterJdbcTemplate.query(SQL_GET_ABOUT_US_CONTENT, new HashMap<String,Object>(), this.contentMapper);
		// Falls die Tabelle leer ist, eine neue Instanz zurück geben
		return (!list.isEmpty()) ? list.get(0) : new AboutUsContent();
	}

}
