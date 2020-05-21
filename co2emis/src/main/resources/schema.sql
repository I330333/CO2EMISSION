CREATE TABLE co2emission
(id integer not null,
 vehicletype varchar(255) not null,
 unitofmeasure varchar(255) not null,
 traveldistance integer not null,
 co2emissionperingram integer not null,
 primary key (id)
);

INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (1,'small-diesel-car','Km',1,142);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (2,'small-petrol-car','Km',1,154);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (3,'small-plugin-hybrid-car','Km',1,73);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (4,'small-small-electric-car','Km',1,50);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (5,'medium-diesel-car','Km',1,171);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (6,'medium-petrol-car','Km',1,192);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (7,'medium-plugin-hybrid-car','Km',1,110);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (8,'medium-electric-car','Km',1,58);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (9,'large-diesel-car','Km',1,209);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram) VALUES (10,'large-petrol-car','Km',1,282);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (11,'large-plugin-hybrid-car','Km',1,126);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (12,'large-electric-car','Km',1,73);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (13,'Bus','Km',1,27);
INSERT into co2emission(id,vehicletype,unitofmeasure,traveldistance,co2emissionperingram ) VALUES (14,'Train','Km',1,6);