CREATE DATABASE 5C_Audisio_Gruppi;
USE 5C_Audisio_Gruppi;

CREATE TABLE IF NOT EXISTS `Gruppo`(
		`codGruppo` VARCHAR(10) NOT NULL,
		`nomeGruppo` VARCHAR(30) NULL,
		`annoGruppo` VARCHAR(10) NULL,
		PRIMARY KEY(`codGruppo`));
		
CREATE TABLE IF NOT EXISTS `Album`(
		`codAlbum` VARCHAR(10) NOT NULL,
		`CodGruppo` VARCHAR(10) NOT NULL,
		`titAlbum` VARCHAR(50) NULL,
		`annoUscita` VARCHAR(10) NULL,
		PRIMARY KEY(`codAlbum`));
		
CREATE TABLE IF NOT EXISTS `Concerti`(
		`codConcerti` VARCHAR(10) NOT NULL,
		`nomeConcerti` VARCHAR(30) NULL,
		`luogoConcerti` VARCHAR(40) NULL,
		`dataConcerti` VARCHAR(10) NULL,
		PRIMARY KEY(`codConcerti`));
		
CREATE TABLE IF NOT EXISTS `Partecipa`(
		`codGruppo` VARCHAR(10) NOT NULL,
		`codConcerti` VARCHAR(10) NOT NULL,
		`Canzoni` INT(30) NULL,
		PRIMARY KEY(`codGruppo`,`codConcerti`));
		
CREATE TABLE IF NOT EXISTS `Componenti`(
		`codComp` VARCHAR(10) NOT NULL,
		`nazComp` VARCHAR(20) NULL,
		`stipAnn` INT(7) NULL,
		`annN` VARCHAR(10) NULL,
		`psedStrum` VARCHAR(10) NOT NULL,
		`psedCant` VARCHAR(10) NOT NULL,
		`codGruppo` VARCHAR(10) NOT NULL,
		PRIMARY KEY(`codComp`));	

CREATE TABLE IF NOT EXISTS `Strumentista`(
		`psedStrum` VARCHAR(5) NOT NULL,
		`cognStrum` VARCHAR(10) NULL,
		`nomeStrum` VARCHAR(10) NULL,
		PRIMARY KEY(`psedStrum`));
		
CREATE TABLE IF NOT EXISTS `Strumenti`(
		`codStrument` VARCHAR(10) NOT NULL,
		`psedStrum` VARCHAR(5) NOT NULL,
		`tipoStrument` VARCHAR(30) NULL,
		PRIMARY KEY(`codStrument`));
		
CREATE TABLE IF NOT EXISTS `Cantante`(
		`psedCant` VARCHAR(10) NOT NULL,
		`codComp` VARCHAR(10) NOT NULL,
		`nomeCant` VARCHAR(10) NULL,
		`cognCant` VARCHAR(10) NULL,
		PRIMARY KEY(`psedCant`));
		
CREATE TABLE IF NOT EXISTS `Canzoni`(
		`codCanz` VARCHAR(10) NOT NULL,
		`psedCant` VARCHAR(10) NOT NULL,
		`titCanz` VARCHAR(30) NULL,
		PRIMARY KEY(`codCanz`));

ALTER TABLE Canzoni FOREIGN KEY(codGruppo) REFERENCES TO Gruppo(codGruppo);		
ALTER TABLE Canzoni FOREIGN KEY(psedStrum) REFERENCES TO Strumentista(psedStrum);
ALTER TABLE Canzoni FOREIGN KEY(psedCant) REFERENCES TO Cantante(psedCant);
ALTER TABLE Canzoni FOREIGN KEY(codGruppo) REFERENCES TO Gruppo(codGruppo);
ALTER TABLE Canzoni FOREIGN KEY(psedStrum) REFERENCES TO Strumentista(psedStrum); 						
ALTER TABLE Canzoni FOREIGN KEY(codComp) REFERENCES TO Componenti(codComp); 				
ALTER TABLE Canzoni FOREIGN KEY(psedCant) REFERENCES TO Cantante(psedCant); 		
