package fhwedel.medienprojekt.fussball.service.dataAccess;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class dataAccessTest {
	/** JDBC Template */
	private SimpleJdbcTemplate jdbcTemplate;
	
	public dataAccessTest() {}
	
	/**
	 * Konstruktor
	 * @param jdbcTemplate
	 */
	public dataAccessTest(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Setzt das Template
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save() {
		/* jdbcTemplate.update(sql, args) */
		/* Example:
		 * jdbcTemplate.update(SQL_INSERT_SPITTER,
		 *	spitter.getUsername(),
		 *	spitter.getPassword(),
		 *	spitter.getFullName(),
		 *	spitter.getEmail(),
		 *	spitter.isUpdateByEmail());
		 *	spitter.setId(queryForIdentity());
		 *	}
		 */
	}
	
	public void get() {
		/** Mappen der ausgelesenen Inhalte auf ein Objekt  */
		/* public SpittergetSpitterById(longid){
		 *	return jdbcTemplate.queryForObject(
		 *	SQL_SELECT_SPITTER_BY_ID,
		 *	newParameterizedRowMapper<Spitter>(){
		 *	public SpittermapRow(ResultSet rs,int rowNum)
		 *	throws SQLException{
		 *	Spitter spitter=newSpitter();
		 *	spitter.setId(rs.getLong(1));
		 *	spitter.setUsername(rs.getString(2));
		 *	spitter.setPassword(rs.getString(3));
		 *	spitter.setFullName(rs.getString(4));
		 *	return spitter;
		 *	}
		 *	},
		 *	id
		 *	);
		 *	}
		 */
	}
	
	/** Beispiel named Parameter */
	/* public void addSpitter(Spitter spitter){
	*	Map<String,Object> params=newHashMap<String,Object>();
	*	params.put("username",spitter.getUsername());
	*	params.put("password",spitter.getPassword());
	*	params.put("fullname",spitter.getFullName());
	*	jdbcTemplate.update(SQL_INSERT_SPITTER,params);
	*	spitter.setId(queryForIdentity());
	*	}*/
}
