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

INSERT INTO student(student_id, student_name, age, gender)
VALUES (1001, '张三', 18, '男'),
       (1002, '李四', 18, '女'),
       (1003, '王五', 19, '男');

INSERT INTO subject(subject_id, subject_name, teacher_id)
VALUES (101, '数学', 11),
       (102, '语文', 12),
       (103, '英语', 12);

INSERT INTO teacher(teacher_id, teacher_name)
VALUES (11, '赵老师'),
       (12, '韩老师');

INSERT INTO grade(grade_id, subject_id, student_id, score)
VALUES (1, 101, 1001, 90),
       (2, 101, 1002, 80),
       (3, 101, 1003, 85),
       (4, 102, 1001, 80),
       (5, 102, 1002, 70),
       (6, 103, 1003, 60);