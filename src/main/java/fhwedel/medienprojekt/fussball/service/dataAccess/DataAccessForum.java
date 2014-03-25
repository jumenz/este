package fhwedel.medienprojekt.fussball.service.dataAccess;

/** externe Klassen */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;





import fhwedel.medienprojekt.fussball.model.post.comment.Comment;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Foreneinträgen.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende Foreneinträge.
 * 
 * @author Ellen
 *
 */
public class DataAccessForum extends AbstractDataAccessPost<ForumEntry> {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * ForumEntryMapper
	 */
	private ParameterizedRowMapper<ForumEntry> forumEntryMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<ForumEntry>() {
				public ForumEntry mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					ForumEntry entry = new ForumEntry();
					// Spalten des Ergebnisses zuweisen
					entry.setId(resultSet.getInt(1));
					entry.setDate(resultSet.getDate(2));
					entry.setAuthor(resultSet.getString(3));
					entry.setTopic(resultSet.getString(4));
					entry.setDescription(resultSet.getString(5));
					entry.setText(resultSet.getString(6));
					
					return entry;
				}
			};
			
	/**
	 * Comment Mapper
	 */
	private ParameterizedRowMapper<Comment> commentMapper = 
			// RowMapper, der den Spalten des Ergebnisses Variablen des ForenEntry zuweist
			new ParameterizedRowMapper<Comment>() {
				public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					Comment comment = new Comment();
					// Spalten des Ergebnisses zuweisen
					comment.setId(resultSet.getInt(1));
					comment.setDate(resultSet.getDate(2));
					comment.setAuthor(resultSet.getString(3));
					comment.setText(resultSet.getString(4));
					comment.setRef(resultSet.getInt(5));
					
					return comment;
				}
			};
	
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessForum() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessForum(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	/* ---------------------------- Speichern ----------------------------------------- */
	/**
	 * Speichert einen neuen ForenEintrag.
	 * @param newForumEntry Eintrag
	 */
	public void save(ForumEntry newForumEntry) {
		/* SQL Befehl */
		final String SQL_INSERT_FORUM_ENTRY = 
				"INSERT INTO forum (date, author, topic, description, text, has_comments) "
				+ "VALUES (:date, :author, :topic, :description, :text, :has_comments)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", new Date());
		params.put("author", newForumEntry.getAuthor());
		params.put("topic", newForumEntry.getTopic());
		params.put("text", newForumEntry.getText());
		params.put("description", newForumEntry.getDescription());
		params.put("has_comments", !newForumEntry.getComments().isEmpty());
		
		/* Speichern */
		this.namedParameterJdbcTemplate.update(SQL_INSERT_FORUM_ENTRY, params);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Foreneinträge aus der Datenbank aus.
	 * 
	 * @return ArrayList<ForumEntry>	Liste aller Foreneinträge
	 */
	public ArrayList<ForumEntry> getAll() {
		// Alle Foren-Einträge nach Datum sortiert auslesen (neueste zuerst)
		final String SQL_ALL_FORUM_ENTRIES = "SELECT * FROM forum ORDER BY date DESC";
		// Foreneinträge laden
		ArrayList<ForumEntry> list = 
				(ArrayList<ForumEntry>) namedParameterJdbcTemplate.query(
					SQL_ALL_FORUM_ENTRIES,
					this.forumEntryMapper
				);
		// Kommentare laden
		this.getAllComments(list);
		return list;
	}
	
	/**
	 * Liest zu einer Liste von Foreneinträgen die Kommentare aus 
	 * und fügt die den Foreneinträgen an.
	 * @param 	list	Liste an Foreneinträgen
	 */
	public void getAllComments(ArrayList<ForumEntry> list) {
		// Kommentarliste laden
		for (int j=0; j<list.size(); j++) {
			Integer id = list.get(j).getId();
			ArrayList<Comment> comments = this.getComments(id);
			list.get(j).setComments(comments);
		}
	}
	
	/**
	 * Liefert die Kommentarliste zu einem Foreneintrag.
	 * @param 	Integer				id des Foreneintrags
	 * @return	ArrayList<Comment>	Liste an Kommentaren
	 */
	public ArrayList<Comment> getComments(Integer id) {
		final String SQL_SELECT_COMMENTS_OF_FORUM_ENTRY = "SELECT * FROM comments WHERE (ref = :ref) ORDER BY date ASC";
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("ref", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (ArrayList<Comment>) namedParameterJdbcTemplate.query(
								// SQL Abfrage
								SQL_SELECT_COMMENTS_OF_FORUM_ENTRY,
								namedParameters,
								this.commentMapper
							);
	}
	
	/**
	 * Liefert die ID eines Foreneintrags
	 * @param entry
	 * @return
	 */
	public int getId(ForumEntry entry) {
		/* SQL Abfrage für Id, ausgehend von Date_Time und Author */
		final String SQL_QUERY_GET_ID =
				"SELECT id FROM forum WHERE (date = :date) AND (author = :author)";
		/* Name-Wert Paare für Abfrage festlegen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("author", entry.getAuthor());
		params.put("date", entry.getDate());
		/* id auslesen */
		return this.namedParameterJdbcTemplate.queryForInt(SQL_QUERY_GET_ID, params);
	}
	
	/**
	 * Liefert einen ForenEintrag ausgehend von seiner id.
	 * @param  id	id des gesuchten Eintrags
	 * @return ForumEntry
	 */
	public ForumEntry getById(int id) {
		// SQL
		final String SQL_SELECT_FORUM_ENTRY_BY_ID = "SELECT * FROM forum WHERE (id = :id)";
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (ForumEntry) namedParameterJdbcTemplate.queryForObject(
								// SQL Abfrage
								SQL_SELECT_FORUM_ENTRY_BY_ID,
								// Parameter
								namedParameters,
								this.forumEntryMapper
							);
	}
	
	/* ------------------- Kommentare ---------------------------------- */
	/* ------------------- speichern ----------------------------------- */
	/**
	 * Speichert einen neuen Kommentar mit referenz auf den entsprechenden Foreneintrag.
	 * @param newComment	neuer Kommentar
	 * @param idForumEntry	Referenz auf Foreneintrag
	 */
	public void saveComment(Comment newComment, int idForumEntry) {
		final String SQL_SAVE_COMMENT = "INSERT INTO comments (date, author, text, ref) "
				+ "VALUES (:date, :author, :text, :ref)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("date", new Date());
		params.put("author", newComment.getAuthor());
		params.put("text", newComment.getText());
		params.put("ref", idForumEntry);
		
		/* Kommentar speichern */
		this.namedParameterJdbcTemplate.update(SQL_SAVE_COMMENT, params);
	}
}
