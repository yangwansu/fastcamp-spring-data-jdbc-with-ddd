CREATE TABLE IF NOT EXISTS LECTURE (id bigint identity primary key, version bigint, name varchar(100), term_id bigint)
CREATE TABLE IF NOT EXISTS TERM (id bigint identity primary key, version bigint, name varchar(100), LIMIT_OF_LECTURE integer )
CREATE TABLE IF NOT EXISTS TERM_LECTURES (term bigint, lecture bigint)

CREATE TABLE IF NOT EXISTS REGISTRATION (lecture bigint, student bigint)

CREATE TABLE IF NOT EXISTS STUDENT (id bigint identity primary key, name varchar(100))