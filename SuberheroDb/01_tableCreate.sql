CREATE TABLE Superhero (
	super_id serial PRIMARY KEY,
	super_name varchar(50),
	super_alias varchar (50) NOT NULL,
	super_origin varchar (255)
);

CREATE TABLE Assistant (
	assistant_id serial PRIMARY KEY,
	assistant_name varchar(50) NOT NULL,
);

CREATE TABLE Power (
	power_id serial PRIMARY KEY,
	power_name varchar(50) NOT NULL,
	power_descript varchar (255)
)