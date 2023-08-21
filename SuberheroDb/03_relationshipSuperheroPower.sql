CREATE TABLE superhero_power (
	super_id int REFERENCES superhero,
    	power_id int REFERENCES power,
    	PRIMARY KEY (super_id, power_id)
);