CREATE DATABSE 5C_Manifestazioni;
USE 5C_MANIFESTAZIONI;

CREATE TABLE `Studenti`(
    `NomeStudente` VARCHAR(20) NULL,
    `CognomeStudente` VARCHAR(20) NULL,
    `DataNascitaStudente` VARCHAR(9) NULL,
    `NomeIstituto` VARCHAR(45) NULL,
    `NomeManifestazione` VARCHAR(45) NULL;	
    PRIMARY KEY(`NomeStudente`);
);

CREATE TABLE `Istituti`(
    `NomeIstituto` VARCHAR(45) NULL,
    PRIMARY KEY(`NomeIstituto`);
);
    
CREATE TABLE `Manifestazioni` ( 
    `NomeManifestazione` VARCHAR(45) NULL,
    PRIMARY KEY(`NomeManifestazione`);
);

CREATE TABLE `Partecipano`(
    `Professore_Coach` VARCHAR(45) NULL;
    `NomeIstituto` VARCHAR(45) NULL,
    `NomeManifestazione` VARCHAR(45) NULL;	
);

CREATE TABLE `Fanno`(
    `NomeIstituto` VARCHAR(45) NULL,
    `NomeManifestazione` VARCHAR(45) NULL;	
);

ALTER TABLE `Studenti`
    ADD Key `NomeIstituto` (`NomeIstituto`),
    ADD Key `NomeManifestazione` (`NomeManifestazione`);
		FOREIGN KEY(`NomeIstituto`,`NomeManifestazione`);
	
ALTER TABLE `Partecipano`
    ADD Key `NomeIstituto` (`NomeIstituto`),
    ADD Key `NomeManifestazione` (`NomeManifestazione`);
		FOREIGN KEY(`NomeIstituto`,`NomeManifestazione`);
	
ALTER TABLE `Fanno`
    ADD Key `NomeIstituto` (`NomeIstituto`),
    ADD Key `NomeManifestazione` (`NomeManifestazione`),
    PRIMARY KEY(`NomeIstituto`,`NomeManifestazione`);		
