CREATE database 5C_merendine;
USE 5C_merendine;

/*CREAZIONE TABELLA MERENDE*/
CREATE TABLE IF NOT EXISTS `Merende` (
		`CodMerenda` VARCHAR(5) NOT NULL,
		`NomeMerenda`	VARCHAR(10) NULL,
		`Prezzo` FLOAT NOT NULL,
		PRIMARY KEY(`CodMerenda`));
		
/*CREAZIONE TABELLA SCUOLE*/
CREATE TABLE IF NOT EXISTS  `Scuole`(
		`CodScuola` VARCHAR(5) NULL,
		`NomeScuola`	VARCHAR(20) NOT NULL,
		PRIMARY KEY(`CodScuola`));		
		
/*CREAZIONE TABELLA MACCHINETTE*/
CREATE TABLE IF NOT EXISTS  `Macchinette`(
		`CodMacchinetta` VARCHAR(5) NULL,
		`TipoMacchinetta`	VARCHAR(20) NOT NULL,
		`CodScuola` VARCHAR(5) NULL,
		PRIMARY KEY(`CodMacchinetta`));

/*CREAZIONE TABELLA POSIZIONI*/
CREATE TABLE IF NOT EXISTS  `Posizioni`(
		`CodPos` VARCHAR(5),
		`QtaMerendine`	VARCHAR(6) NOT NULL,
		`CodMerenda`	VARCHAR(5),
		`CodMacchinetta` VARCHAR(5),
		PRIMARY KEY(`CodPos`));


ALTER TABLE Macchinette	ADD CONSTRAINT `CodScuola` FOREIGN KEY (`CodScuola`) REFERENCES `Scuole` (`CodScuola`);
ALTER TABLE Posizioni	ADD CONSTRAINT `CodMerenda` FOREIGN KEY (`CodMerenda`) REFERENCES `Merende` (`CodMerenda`);
ALTER TABLE Posizioni	ADD CONSTRAINT `CodMacchinetta` FOREIGN KEY (`CodMacchinetta`) REFERENCES `Macchinette` (`CodMacchinetta`);	
