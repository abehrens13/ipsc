CREATE TABLE pageadmin ( id SERIAL,
name VARCHAR(50) NOT NULL UNIQUE,
description VARCHAR(200) );

CREATE TABLE countries ( id SERIAL,
code CHAR(3) NOT NULL UNIQUE,
name_en VARCHAR(50) NOT NULL UNIQUE,
name_fr VARCHAR(50) ) ;

CREATE TABLE shooter ( id SERIAL,
username VARCHAR(20) NOT NULL UNIQUE,
firstname VARCHAR(40),
lastname VARCHAR(40),
email VARCHAR(50),
country_id NUMERIC NOT NULL,
description VARCHAR(200),
ipsc_licence VARCHAR(20),
ipsc_state VARCHAR(2) );

CREATE TABLE competition_type ( id SERIAL,
name VARCHAR(50) NOT NULL unique,
description VARCHAR(200) );

CREATE TABLE devision_type ( id SERIAL,
name VARCHAR(50),
description VARCHAR(200) );

/*needs to be revisited*/
CREATE TABLE competitions ( id SERIAL,
competition_type_id NUMERIC NOT NULL,
devision_type_id NUMERIC NOT NULL,
country_id NUMERIC NOT NULL,
date_start TIMESTAMP NOT NULL,
date_end TIMESTAMP NOT NULL,
LEVEL NUMERIC NOT NULL,
stages NUMERIC NOT NULL,
bullet_counts NUMERIC NOT NULL );

CREATE TABLE registrations ( id SERIAL,
competition_id NUMERIC NOT NULL,
shooter_id NUMERIC NOT NULL );

COMMIT;
