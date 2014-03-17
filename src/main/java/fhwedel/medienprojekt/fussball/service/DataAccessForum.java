package fhwedel.medienprojekt.fussball.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

public class DataAccessForum {
	/** JDBC Template */
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public DataAccessForum() {}
	
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessForum(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
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
	
	public void save(ForumEntry newForumEntry) {
		/* SQL Befehl*/
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO forum (date_time, author, topic, description, text, has_comments) "
				+ "VALUES (:date_time, :author, :topic, :description, :text, :has_comments)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("author", newForumEntry.getAuthor());
		params.put("topic", newForumEntry.getTopic());
		params.put("text", newForumEntry.getText());
		params.put("date", newForumEntry.getDate());
		params.put("time", newForumEntry.getTime());
		params.put("description", newForumEntry.getDescription());
		params.put("has_comments", !newForumEntry.getCommentList().isEmpty());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
		newForumEntry.setId();
	}
	
	public int getId(ForumEntry entry) {
		/* SQL Abfrage für Id, ausgehend von Date_Time und Author */
		final String SQL_QUERY_GET_ID =
				"SELECT id FROM forum WHERE (date = :date) AND (author = :author) AND (time = :time)";
		/* Name-Wert Paare für Abfrage festlegen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("author", entry.getAuthor());
		params.put("date", entry.getDate());
		params.put("time", entry.getTime());
		/* id auslesen */
		return this.namedParameterJdbcTemplate.queryForInt(SQL_QUERY_GET_ID, params);
	}
	
	public void getById(int id) {
		final String SQL_SELECT_FORUM_ENTRY_BY_ID = "SELECT * FROM forum WHERE (id = :id)";
		/** Mappen der ausgelesenen Inhalte auf ein Objekt  */
	 	return this.namedParameterJdbcTemplate.queryForObject(	 			
	 			SQL_SELECT_FORUM_ENTRY_BY_ID,
	 			new ParameterizedRowMapper<ForumEntry>(){
	 				public ForumEntry mapRow(ResultSet rs,int rowNum) throws SQLException {
	 					ForumEntry entry = new ForumEntry();
	 					entry.setId(rs.getInt(0));
	 					entry.setDate(rs.getDate(1));
	 					entry.setTime(rs.getTime(2));
	 					entry.setAuthor(rs.getString(2));
	 					entry.setTopic(rs.getString(3));
	 					entry.setDescription(rs.getString(4));
	 					entry.setText(rs.getString(5));
	 					return entry;
	 				}
	 			},
	 			id
	 			);
	}
		/* TODO Kommentarliste laden */
	
	public ArrayList<ForumEntry> getAll() {
		/** Beispiel named Parameter */
		/* public void addSpitter(Spitter spitter){
		*	Map<String,Object> params=newHashMap<String,Object>();
		*	params.put("username",spitter.getUsername());
		*	params.put("password",spitter.getPassword());
		*	params.put("fullname",spitter.getFullName());
		*	jdbcTemplate.update(SQL_INSERT_SPITTER,params);
		*	spitter.setId(queryForIdentity());
		*	}*/
		return new ArrayList<ForumEntry>();
	}
	
}
