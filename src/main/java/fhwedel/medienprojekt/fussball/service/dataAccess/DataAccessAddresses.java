package fhwedel.medienprojekt.fussball.service.dataAccess;

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
import fhwedel.medienprojekt.fussball.model.user.addresses.Address;

/**
 * Service
 * Übernimmt die Datenbankarbeit zum Verarbeiten von Adressen.
 * 
 * @author Julia
 *
 */
public class DataAccessAddresses extends AbstractDataAccess {
	
	/* ----------------------- Klassenvariablen --------------------------------- */
	/**
	 * Address Mapper
	 */
	private ParameterizedRowMapper<Address> addressRowMapper = 
			// RowMapper, der den Spalten der Adresse zuweist
			new ParameterizedRowMapper<Address>() {
		
				/**
				 * Row Mapper
				 */
				public Address mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					// Objekt erzeugen
					Address entry = new Address();
					// Spalten des Ergebnisses zuweisen
					entry.setId(resultSet.getInt(1));
					entry.setName(resultSet.getString(2));
					entry.setPrename(resultSet.getString(3));
					entry.setBirthday(resultSet.getString(4));
					entry.setEmail(resultSet.getString(12));
					entry.setPhone(resultSet.getString(5));
					entry.setMobile(resultSet.getString(6));
					entry.setStreet(resultSet.getString(7));
					entry.setNr(resultSet.getString(8));
					entry.setZipcode(resultSet.getString(9));
					entry.setCity(resultSet.getString(10));
					//entry.setUsername(resultSet.getString(11));
					return entry;
				}
			};
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
	/**
	 * Default-Konstruktor.
	 */
	public DataAccessAddresses() {}
			
	/**
	 * Konstruktor
	 * @param NamedParameterJdbcTemplate namedParameterJdbcTemplate
	 */
	public DataAccessAddresses(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/* ------------------------- Datenbankarbeit ----------------------------------- */
	
	/**
	 * Hilfsfunktion.
	 * Ordnet die Werte des Adresseintrags als Name-Wert-Paare für die Adress-Tabelle
	 * @param address		Address		Adresse
	 * @param params		Map			Name-Wert-Paare
	 * @param updateDate	boolean		true: neues Datum wird gemappt
	 * 									false: altes Datum wird übernommen
	 */
	private void mapParams(Address address, Map<String,Object> params, boolean updateDate) {
		params.put("id", address);
		params.put("name", address.getName());
		params.put("prename", address.getPrename());
		params.put("birthday", address.getBirthday());
		params.put("mobile", address.getMobile());
		params.put("phone", address.getPhone());
		params.put("street", address.getStreet());
		params.put("nr", address.getNr());
		params.put("zipcode", address.getZipcode());
		params.put("city", address.getCity());
	}
	
	/* ------------------------- Auslesen ------------------------------------- */
	/**
	 * Liest alle Addressen aus der Datenbank aus.
	 * 
	 * @return ArrayList<Address>	Liste aller Adressen
	 */
	public ArrayList<Address> getAll() {
		// Alle Adress-Einträge absteigend sortiert auslesen.
		//final String SQL_SELECT_ALL_ADDRESSES = "SELECT * FROM " + Constants.dbAddresses + " ORDER BY name ASC";
		final String SQL_SELECT_ALL_ADDRESSES = "SELECT * FROM " + Constants.dbAddresses + " NATURAL JOIN " + Constants.dbUsers + " ORDER BY name ASC";

		return (ArrayList<Address>) namedParameterJdbcTemplate.query(
				SQL_SELECT_ALL_ADDRESSES, this.addressRowMapper);
	}
	
	/**
	 * Liefert eine Adresse ausgehend von ihrer id.
	 * @param  id	id der Adresse
	 * @return Address
	 */
	public Address getById(int id) {
		final String SQL_SELECT_BY_ID = 
				//"SELECT * FROM " + Constants.dbAddresses + " WHERE (" + Constants.dbAddressesId + "=:id)";
				"SELECT * FROM " + Constants.dbAddresses + " NATURAL JOIN " + Constants.dbUsers + "  WHERE (" + Constants.dbAddressesId + "=:id)";
		
		// Parameter zuweisen
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
		// SQL Abfrage ausführen und Ergebnis auf einen Foren-Eintrag mappen
		return (Address) namedParameterJdbcTemplate.queryForObject(SQL_SELECT_BY_ID, 
				namedParameters, this.addressRowMapper);
	}
	
	/* ------------------------- Editieren ------------------------------------- */
	
	/**
	 * Ändert eine Adresse.
	 * @param 	address Adresse.
	 */
	public void update(int updateId, Address address) {
		final String SQL_UPDATE_ADDRESSES = "UPDATE " + Constants.dbAddresses + " SET "
				+ "id:=id, name=:name, prename=:prename, birthday:=birthday, mobile=:mobile, "
				+ "phone=:phone, street=:street, nr=:nr, zipcode=:zipcode, city=:city WHERE id=:" + updateId;
		final String SQL_UPDATE_EMAIL_USERS = "UPDATE " + Constants.dbUsers + " SET email:=email WHERE id=:" + updateId;
		final String SQL_UPDATE_EMAIL_PERMISSIONS = "UPDATE " + Constants.dbPermissions + " SET email:=email WHERE id=:" + updateId;
		/*final String SQL_UPDATE_ADDRESSES = 
		"UPDATE " + Constants.dbAddresses + " SET ("
		+ Constants.dbAddressesId + ", "
		+ Constants.dbAddressesName + ", "
		+ Constants.dbAddressesPrename + ", "
		+ Constants.dbAddressesBirthday + ", "
		+ Constants.dbAddressesMobile + ", "
		+ Constants.dbAddressesPhone + ", "
		+ Constants.dbAddressesStreet + ", "
		+ Constants.dbAddressesNr + ", "
		+ Constants.dbAddressesZipcode + ", "
		+ Constants.dbAddressesCity
		+ ") VALUES (:id, :name, :prename, :birthday, :mobile, :phone, :street, :nr, :zipcode, :city)";*/
		
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(address);	

		/* Werte Namen zuweisen */
		Map<String,Object> addressParams = new HashMap<String,Object>();
		Map<String,Object> emailParams = new HashMap<String,Object>();
		// Adresse setzen
		this.mapParams(address, addressParams, false);
		// E-Mail setzen
		emailParams.put("id", updateId);
		emailParams.put("email", address.getEmail());
		
		/* Datensätze updaten */
		this.namedParameterJdbcTemplate.update(SQL_UPDATE_ADDRESSES, addressParams);
		this.namedParameterJdbcTemplate.update(SQL_UPDATE_EMAIL_PERMISSIONS, emailParams);
	}
	
/* ------------------------- Löschen ------------------------------------- */
	
	/**
	 * Löscht eine Adresse ausgehend von ihrer id.
	 * @param 	id	int		ID der Adresse
	 */
	public void delete(int id) {
		final String SQL_DELETE_ADDRESS = 
				"DELETE FROM " + Constants.dbAddresses + " WHERE "
				+ Constants.dbAddressesId + "=:id";
		
		// ID setzen
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		// löschen
		this.namedParameterJdbcTemplate.update(SQL_DELETE_ADDRESS, params);
	}
}
