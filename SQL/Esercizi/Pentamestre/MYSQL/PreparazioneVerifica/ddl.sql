CREATE 5C_MANIFESTAZIONI
USE 5C_MANIFESTAZIONI

CREATE TABLE IF NOT EXISTS `Studente`(
    `codiceStudente` VARCHAR(20) NOT NULL,
    `cognome` VARCHAR(20) NOT NULL,
    `nome` VARCHAR(20) NOT NULL,
    `dataNascita` VARCHAR(10) NOT NULL,
    `classe` VARCHAR(2) NOT NULL,
    `codiceIstituto` VARCHAR(20) NOT NULL,    
    PRIMARY KEY(codiceStudente));
    
CREATE TABLE IF NOT EXISTS `Istituti`(
    `codiceIstituto` VARCHAR(20) NOT NULL,
    `denominazione` VARCHAR(50) NOT NULL,
    `indirizzo` VARCHAR(60) NOT NULL,
    `telefono` VARCHAR(10) NOT NULL,
    PRIMARY KEY(codiceIstituto));
        
CREATE TABLE IF NOT EXISTS `Professore`(
    `codiceProfessore` VARCHAR(20) NOT NULL,
    `cognome` VARCHAR(20) NOT NULL,
    `nome` VARCHAR(20) NOT NULL,
    `codiceManifestazione` VARCHAR(20) NOT NULL,  
    `codiceIstituto` VARCHAR(20) NOT NULL,      
    PRIMARY KEY(codiceProfessore));
        
CREATE TABLE IF NOT EXISTS `Manifestazione`(
    `codiceManifestazione` VARCHAR(20) NOT NULL,
    `descrizione` VARCHAR(100) NOT NULL,
    `luogo` VARCHAR(60) NOT NULL,
    `dataInizio` VARCHAR(10) NOT NULL,
    `svolgimento` VARCHAR(10) NOT NULL,
    PRIMARY KEY(codicemManifestazione)); 
    
CREATE TABLE IF NOT EXISTS `Partecipa`(
    `codiceManifestazione` VARCHAR(20) NOT NULL,
    `codiceStudente` VARCHAR(20) NOT NULL);    
    
ALTER TABLE Studente ADD CONSTRAINT `Istituti` FOREIGN KEY(`codiceIstituto`) REFERENCES `Istituti`(`codiceIstituto`);  
ALTER TABLE Professore ADD CONSTRAINT `Manifestazione` FOREIGN KEY(`codiceManifestazione`) REFERENCES `Manifestazione`(`codiceManifestazione`);  
ALTER TABLE Professore ADD CONSTRAINT `Istituti` FOREIGN KEY(`codiceIstituto`) REFERENCES `Istituti`(`codiceIstituto`);
ALTER TABLE Partecipa ADD CONSTRAINT `Studente` FOREIGN KEY(`codiceStudente`) REFERENCES `codiceStudente`(`codiceStudente`);  
ALTER TABLE Partecipa ADD CONSTRAINT `Manifestazione` FOREIGN KEY(`codiceManifestazione`) REFERENCES `Manifestazione`(`codiceManifestazione`);    
