CREATE DATABASE 5C_Convention;
USE 5C_Convention;

-- CREAZIONE TABELLA RELATORE --
CREATE TABLE IF NOT EXIST `Relatore`(
    `idRel` VARCHAR(50) NOT NULL,
    `cognomeRel` VARCHAR(50) NULL,
    `nomeRel` VARCHAR(50) NULL,
    `idAzienda` VARCHAR(50) NULL,
    PRIMARY KEY(`idRel`)
);

-- CREAZIONE TABELLA AZIENDA --
CREATE TABLE IF NOT EXIST  `Azienda`(
    `idAzienda` VARCHAR(50) NULL,
    `indirizzoAzienda` VARCHAR(50) NULL,
    `telefonoAzienda` VARCHAR(20) NULL,
    PRIMARY KEY(`idAzienda`);
);

-- CREAZIONE TABELLA PROGRAMMA --
CREATE TABLE IF NOT EXIST  `Programma`(
	`idProgramma` VARCHAR(50) NOT NULL,
    `fasciaOraria` TIME,
    `idSpeech` VARCHAR(50) NOT NULL,
    `nomeSala` VARCHAR(50) NULL,
    PRIMARY KEY('idProgramma')
);

-- CREAZIONE TABELLA SPEECH --
CREATE TABLE IF NOT EXIST  `Speech`(
    `idSpeech` VARCHAR(50) NOT NULL,
    `titolo` VARCHAR(50) NULL,
    `argomento` VARHCAR(100) NULL,
    PRIMARY KEY(`idSpeech`)
);

-- CREAZIONE TABELLA PARTECIPANTE --
CREATE TABLE IF NOT EXIST  `Partecipante`(
    `idPart` VARCHAR(50) NULL,
    `cognomePart` VARCHAR(50) NULL,
    `nomePart` VARCHAR(50) NULL,
    `mailPart` VARCHAR(50) NULL,
    `tipologiaPart` VARCHAR(50) NULL,
    PRIMARY KEY(`idPart`)
);

-- CREAZIONE TABELLA SALA --
CREATE TABLE IF NOT EXIST  `Sala`(
    `idSala` VARCHAR(50) NULL,
    `nPostiSala` INT(200) NULL,
    `nPiano` INT(50) NULL,
    PRIMARY KEY(`idSala`)
);

-- CREAZIONE TABELLA PIANO --
CREATE TABLE IF NOT EXIST  `Piano`(
    `nPiano` INT(50) NULL,
    `nSale` INT(20) NULL,
    `descrizione`INT(200) NULL,
    PRIMARY KEY(`nPiano`)
);

-- CREAZIONE TABELLA RELAZIONA (collegamento tra RELATORE E PROGRAMMA)--
CREATE TABLE IF NOT EXIST  `Relaziona`(
    `idRel` VARCHAR(50) NOT NULL,
    `idProgramma` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`idRel`,`idProgramma`)
);

-- CREAZIONE TABELLA SCEGLIE (colegamento tra PROGRAMMA e PARTECIPANTE)--
CREATE TABLE IF NOT EXIST  `Composto`(
    `idPart` VARCHAR(50) NULL,
    `idProgramma` VARCHAR(50) NOT NULL,
    `nPartecipanti` INT(200) NULL,
     PRIMARY KEY(`idPart`,`idProgramma`)
);

-- SETTO LE CHIAVI ESTERNE --
ALTER TABLE Relatore ADD FOREIGN KEY(`idAzienda`) REFERENCES Azienda(`idAzienda`);
ALTER TABLE Programma ADD FOREIGN KEY(`idSpeech`) REFERENCES Speech(`idSpeech`);
ALTER TABLE Programma ADD FOREIGN KEY(`nomeSala`) REFERENCES Sala(`nomeSala`);
ALTER TABLE Sala ADD FOREIGN KEY(`nPiano`) REFERENCES Piano(`nPiano`);
ALTER TABLE Relaziona ADD FOREIGN KEY(`idRel`) REFERENCES Relatore(`idRel`);
ALTER TABLE Sceglie ADD FOREIGN KEY(`idPart`) REFERENCES Partecipante(`idPart`);
