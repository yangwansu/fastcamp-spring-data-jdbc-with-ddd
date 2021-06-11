CREATE TABLE IF NOT EXISTS TERM (id bigint primary key identity, version bigint, name varchar(100),LIMIT_OF_LECTURES integer )
CREATE TABLE IF NOT EXISTS TERM_LECTURE (term bigint, lecture bigint)
CREATE TABLE IF NOT EXISTS LECTURE (id bigint primary key identity, version bigint, term_id bigint, name varchar(100))