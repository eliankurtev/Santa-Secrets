CREATE TABLE user (
    user_id INT AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(20),
    is_admin BIT,
    PRIMARY KEY (user_id)
) ENGINE=INNODB;