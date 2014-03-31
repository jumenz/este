package fhwedel.medienprojekt.fussball.service.dataAccess;

/**
 * Enthält Konstanten für die Datenbankarbeit.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class Constants {
	// Mehrfach vorkommende Spaltennamen
	private static final String dbColId = "id";
	private static final String dbColDate = "date";
	private static final String dbColAuthor = "author";
	private static final String dbColText = "text";
	private static final String dbColTopic = "topic";
	private static final String dbColEmail = "email";
	
	// Spielberichtetabelle
	static final String dbReports = "report";
	static final String dbReportsId = dbColId;
	static final String dbReportsDate = dbColDate;
	static final String dbReportsAuthor = dbColAuthor;
	static final String dbReportsTopic = dbColTopic;
	static final String dbReportsText = dbColText;
	static final String dbReportsOpponent = "opponent";
	static final String dbReportsScoreFirstHalfHome = "first_half_home";
	static final String dbReportsScoreFirstHalfGuest = "first_half_guest";
	static final String dbReportsScoreSecondHalfHome = "second_half_home";
	static final String dbReportsScoreSecondHalfGuest = "second_half_guest";
	
	// Forumstabelle
	static final String dbForum = "forum";
	static final String dbForumId = dbColId;
	static final String dbForumDate = dbColDate;
	static final String dbForumAuthor = dbColAuthor;
	static final String dbForumTopic = dbColTopic;
	static final String dbForumText = dbColText;
	static final String dbForumDescription = "description";
	
	// Kommentare
	static final String dbComments = "comments";
	static final String dbCommentsId = dbColId;
	static final String dbCommentsDate = dbColDate;
	static final String dbCommentsAuthor = dbColAuthor;
	static final String dbCommentsText = dbColText;
	static final String dbCommentsRef = "ref";
	
	// Registrierungserlaubnisse
	static final String dbPermissions = "permissions";
	static final String dbPermissionsId = dbColId;
	static final String dbPermissionsEmail = dbColEmail;
	
	// Users
	static final String dbUsers = "users";
	static final String dbUsersId = dbColId;
	static final String dbUsersEmail = dbColEmail;
	static final String dbUsersUsername = "username";
	static final String dbUsersPassword = "password";
	static final String dbUsersUserGroup = "user_group";
}
