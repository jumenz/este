package fhwedel.medienprojekt.fussball.service.dataAccess;

/**
 * Enthält Konstanten für die Datenbankarbeit.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class Constants {

	static final String dbColId = "id";
	static final String dbColEmail = "email";
	
	static final String dbReports = "report";
	static final String dbForum = "forum";
	static final String dbComments = "comments";
	static final String dbPermissions = "permissions";
	static final String dbUsers = "users";
	static final String dbUsersId = dbColId;
	static final String dbUsersEmail = dbColEmail;
	static final String dbUsersUsername = "username";
	static final String dbUsersPassword = "password";
	static final String dbUsersUserGroup = "user_group";
	
	// Adressen
	static final String dbAddresses = "addresses";
	static final String dbAddressesId = dbColId;
	static final String dbAddressesName = "name";
	static final String dbAddressesPrename = "prename";
	static final String dbAddressesBirthday = "birthday";
	static final String dbAddressesMobile = "mobile";
	static final String dbAddressesPhone = "phone";
	static final String dbAddressesStreet = "street";
	static final String dbAddressesNr = "nr";
	static final String dbAddressesZipcode = "zipcode";
	static final String dbAddressesCity = "city";
}
