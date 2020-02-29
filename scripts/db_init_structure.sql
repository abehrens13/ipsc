-- Drop table

-- DROP TABLE address;

CREATE TABLE address (
    id serial NOT NULL,
    "name" varchar(50) NULL,
    street varchar(200) NULL,
    country_id numeric NULL,
    city varchar(200) NULL
);

-- Drop table

-- DROP TABLE competition_type;

CREATE TABLE competition_type (
    id serial NOT NULL,
    "name" varchar(50) NOT NULL,
    description varchar(200) NULL,
    CONSTRAINT competition_type_name_key UNIQUE (name)
);

-- Drop table

-- DROP TABLE competitions;

CREATE TABLE competitions (
    id serial NOT NULL,
    devision_type_id numeric NOT NULL,
    country_id numeric NOT NULL,
    date_start date NOT NULL,
    date_end timestamp NOT NULL,
    "level" numeric NULL,
    stages numeric NULL,
    bullet_counts numeric NULL,
    organiser_id numeric NULL,
    title varchar(100) NULL,
    eventlocation_id numeric NULL,
    status_id numeric NULL,
    reg_open timestamp NULL,
    reg_close timestamp NULL,
    load_factor numeric NULL,
    competition_type_id numeric NULL
);

-- Drop table

-- DROP TABLE countries;

CREATE TABLE countries (
    id serial NOT NULL,
    code bpchar(3) NOT NULL,
    name_en varchar(50) NOT NULL,
    name_de varchar(50) NULL,
    name_fr varchar(50) NULL,
    CONSTRAINT countries_code_key UNIQUE (code),
    CONSTRAINT countries_name_en_key UNIQUE (name_en)
);

-- Drop table

-- DROP TABLE devision_type;

CREATE TABLE devision_type (
    id serial NOT NULL,
    "name" varchar(50) NULL,
    description varchar(200) NULL
);

-- Drop table

-- DROP TABLE eventlocation;

CREATE TABLE eventlocation (
    id serial NOT NULL,
    "name" varchar(50) NULL,
    description varchar(50) NULL,
    address_id numeric NULL,
    notes text NULL
);

-- Drop table

-- DROP TABLE organiser;

CREATE TABLE organiser (
    id serial NOT NULL,
    "name" varchar(50) NULL,
    address_id numeric NULL
);

-- Drop table

-- DROP TABLE pageadmin;

CREATE TABLE pageadmin (
    id serial NOT NULL,
    "name" varchar(50) NOT NULL,
    description varchar(200) NULL,
    CONSTRAINT pageadmin_name_key UNIQUE (name)
);

-- Drop table

-- DROP TABLE registrations;

CREATE TABLE registrations (
    id serial NOT NULL,
    competition_id numeric NOT NULL,
    shooter_id numeric NOT NULL,
    registration_date timestamp NULL
);

-- Drop table

-- DROP TABLE shooters;

CREATE TABLE shooters (
    id serial NOT NULL,
    username varchar(20) NOT NULL,
    passwordstr varchar(50) NOT NULL,
    firstname varchar(40) NOT NULL,
    lastname varchar(40) NOT NULL,
    email varchar(50) NOT NULL,
    country_id numeric NOT NULL,
    ipsc_licence varchar(20) NULL,
    CONSTRAINT shooters_username_key UNIQUE (username)
);

-- Drop table

-- DROP TABLE status;

CREATE TABLE status (
    id serial NOT NULL,
    name_en varchar(50) NULL,
    name_de varchar(50) NULL,
    name_fr varchar(50) NULL
);