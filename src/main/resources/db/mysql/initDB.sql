CREATE TABLE IF NOT EXISTS team  (
  id		 INT NOT NULL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS forum  (
  id		INT NOT NULL PRIMARY KEY,
  date_time	DATETIME NOT NULL,
  author 	VARCHAR(30),
  topic 	VARCHAR(30),
  text		VARCHAR(500),
  has_comments	BOOLEAN
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS report  (
  id				INT NOT NULL PRIMARY KEY,
  date_time 		DATETIME NOT NULL,
  author 			VARCHAR(30),
  topic 			VARCHAR(30),
  text				VARCHAR(500),
  opponent 			VARCHAR(30),
  first_half_home	INT NOT NULL,
  first_half_guest	INT NOT NULL,
  second_half_home	INT NOT NULL,
  second_half_guest	INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS comments (
  id			INT NOT NULL PRIMARY KEY,
  date_time		DATETIME NOT NULL,
  author		VARCHAR(30),
  text			VARCHAR(30),
  ref			INT NOT NULL,
  FOREIGN KEY (ref) REFERENCES report(id) ON DELETE CASCADE
) ENGINE=InnoDB;