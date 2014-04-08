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
  text				VARCHAR(1500),
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

CREATE TABLE IF NOT EXISTS addresses (
  id 		INT 			NOT NULL,
  name 		VARCHAR(100) 	NOT NULL,
  prename 	VARCHAR(100) 	NOT NULL,
  birthday 	VARCHAR(10)		DEFAULT NULL,
  phone 	VARCHAR(100) 	DEFAULT NULL,
  mobile 	VARCHAR(100) 	DEFAULT NULL,
  street 	VARCHAR(100) 	DEFAULT NULL,
  nr		VARCHAR(8) 		DEFAULT NULL,
  zipcode 	VARCHAR(12) 	DEFAULT NULL,
  city 		VARCHAR(100) 	DEFAULT NULL,
  FOREIGN KEY (id) REFERENCES permissions(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS aboutus (
  company				TEXT(5000)	NOT NULL,
  team					TEXT(5000)	NOT NULL,
  trainer_first_text	TEXT(5000)	NOT NULL,
  trainer_first_name 	VARCHAR(50) NOT NULL,
  trainer_second_text	TEXT(5000)	NOT NULL,
  trainer_second_name	VARCHAR(50) NOT NULL,
  training				TEXT(5000)	NOT NULL,
  approach_nfd			TEXT(5000)	NOT NULL,
  approach_c			TEXT(5000)	NOT NULL,
  approach_pt			TEXT(5000)	NOT NULL,
  contact				TEXT(5000)	NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS impressum (
  text				TEXT(5000)	NOT NULL
) ENGINE=InnoDB;