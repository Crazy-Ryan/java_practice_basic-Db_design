CREATE DATABASE tw_db_design CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

USE tw_db_design;

CREATE TABLE student
(
    student_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(20) NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

ALTER TABLE student
    ADD COLUMN age INT;
ALTER TABLE student
    ADD COLUMN gender VARCHAR(5);

CREATE TABLE grade
(
    grade_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score      INT NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE subject
(
    subject_id   INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    teacher_id   INT         NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE teacher
(
    teacher_id   INT PRIMARY KEY AUTO_INCREMENT,
    teacher_name VARCHAR(20) NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;
CREATE DATABASE tw_db_design CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

USE tw_db_design;

CREATE TABLE student
(
    student_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(20) NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

ALTER TABLE student
    ADD COLUMN age INT;
ALTER TABLE student
    ADD COLUMN gender VARCHAR(5);

CREATE TABLE grade
(
    grade_id   INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score      INT NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE subject
(
    subject_id   INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    teacher_id   INT         NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE teacher
(
    teacher_id   INT PRIMARY KEY AUTO_INCREMENT,
    teacher_name VARCHAR(20) NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

CREATE TABLE user_info
(
    username VARCHAR(40) NOT NULL,
    password VARCHAR(50) NOT NULL
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4;

INSERT INTO user_info(username, password)
VALUES ('admin', 'admin');