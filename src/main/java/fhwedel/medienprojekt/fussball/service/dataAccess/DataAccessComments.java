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

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Foreneinträgen.
 * Ermöglich beispielsweise das Updaten bestehender, einfügen neuer
 * oder auslesen von Informationen über bestehende Foreneinträge.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataAccessComments extends AbstractDataAccessPost<Comment> {
	/* ----------------------- Klassenvariablen --------------------------------- */
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
	public DataAccessComments() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessComments(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ---------------------------- Datenbankarbeit ----------------------------------- */
	public void mapParams(Comment comment, int ref, Map<String,Object> params, boolean updateDate) {
		/* Werte Namen zuweisen */
		Date date = (updateDate) ? new Date() : comment.getDate();
		params.put(Constants.dbCommentsDate, date);
		params.put(Constants.dbCommentsAuthor, comment.getAuthor());
		params.put(Constants.dbCommentsText, comment.getText());
		params.put(Constants.dbCommentsRef, ref);
	}
	
	/* ----------------------- Speichern -------------------------------------- */
	/**
	 * Speichert einen neuen Kommentar mit referenz auf den entsprechenden Foreneintrag.
	 * @param newComment	neuer Kommentar
	 * @param idForumEntry	Referenz auf Foreneintrag
	 */
	public void saveComment(Comment newComment, int idForumEntry) {
		final String SQL_SAVE_COMMENT = 
				"INSERT INTO " + Constants.dbComments 
				+ " ("
				+ Constants.dbCommentsDate 		+ ","
				+ Constants.dbCommentsAuthor 	+ ","
				+ Constants.dbCommentsText		+ ","
				+ Constants.dbCommentsRef
				+ ") VALUES (:date, :author, :text, :ref)";
		/* Werte Namen zuweisen */
		Map<String,Object> params = new HashMap<String,Object>();
		mapParams(newComment, idForumEntry, params, true);
		
		/* Kommentar speichern */
		this.namedParameterJdbcTemplate.update(SQL_SAVE_COMMENT, params);
	}
	
	/* ------------------------ Löschen --------------------------------------- */
	/**
	 * Löscht einen Kommentare ausgehend von seiner ID.
	 * @param 	id	 int	Id des Kommentars
	 */
	public void deleteComment(int id) {
		this.deleteById(id, Constants.dbComments);
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	public ArrayList<Comment> getAll() {
		return this.getAll(Constants.dbComments, this.commentMapper, false);
	}
	
	/**
	 * Liest zu einer Liste von Foreneinträgen die Kommentare aus 
	 * und fügt die den Foreneinträgen an.
	 * @param 	list	Liste an Foreneinträgen
	 */
	public void getAllCommentsForForumEntries(ArrayList<ForumEntry> list) {
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
		final String SQL_SELECT_COMMENTS_OF_FORUM_ENTRY = 
				"SELECT * FROM " + Constants.dbComments + " WHERE ("
				+ Constants.dbCommentsRef
				+ "= :ref) ORDER BY date ASC";
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
	
}
