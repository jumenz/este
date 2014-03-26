CREATE TABLE IF NOT EXISTS team  (
  id		 INT NOT NULL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS forum  (
  id			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date			DATE NOT NULL,
  author 		VARCHAR(30),
  topic 		VARCHAR(30),
  description 	VARCHAR(150),
  text			VARCHAR(500),
  has_comments	BOOLEAN
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS report  (
  id				INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date		 		DATE NOT NULL,
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
  id			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date			DATE NOT NULL,
  author		VARCHAR(30),
  text			VARCHAR(30),
  ref			INT NOT NULL,
  FOREIGN KEY (ref) REFERENCES forum(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS permissions (
  id			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email			VARCHAR(50) NOT NULL UNIQUE,
  admin_state	boolean NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS users (
  id			INT NOT NULL PRIMARY KEY,
  username		VARCHAR(50) NOT NULL UNIQUE,
  email			VARCHAR(50) NOT NULL,
  password		VARCHAR(50) NOT NULL,
  user_group	VARCHAR(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES permissions(email) ON DELETE CASCADE,
  FOREIGN KEY (id) REFERENCES permissions(id) ON DELETE CASCADE
) ENGINE=InnoDB;