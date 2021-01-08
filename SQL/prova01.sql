-- Per cambiare/aggiornare un determinato valore usiamo l'istruzione UPDATE e il comando
-- SET per identificare il record interessato
-- 
-- UPDATE anagrafe SET indirizzo=
-- 'Via Roma, 22' WHERE indirizzo = 'Corso V. Emanuele,215';

-- ESERCIZIO MANIFESTAZIONI --

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

-- ESERCIZIO ORCHESTRA --

    SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
    SET AUTOCOMMIT = 0;
    START TRANSACTION;
    SET time_zone = "+00:00";

    CREATE TABLE `Autori` (
      `CodiceAutori` tinyint(4) NOT NULL,
      `NomeAutori` varchar(8) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Concerti` (
      `CodiceConcerti` tinyint(4) NOT NULL,
      `DescrizioneConcerti` varchar(250) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Direttori` (
      `CodiceDirettore` tinyint(4) NOT NULL,
      `CognomeDirettore` varchar(10) NOT NULL,
      `NomeDirettore` varchar(10) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Eseguito` (
      `CodiceConcerti` tinyint(4) NOT NULL,
      `NomeOrchestra` varchar(20) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Formato` (
      `NomeOrchestra` varchar(20) NOT NULL,
      `MatricolaOrchestrali` int(10) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Orchestrali` (
      `MatricolaOrchestrali` int(10) NOT NULL,
      `NomeOrchestrali` varchar(8) NOT NULL,
      `CognomeOrchestrali` varchar(8) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Orchestre` (
      `NomeOrchestra` varchar(20) NOT NULL,
      `CodiceDirettore` tinyint(4) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `PezziMusicali` (
      `CodicePezziMusicali` smallint(4) NOT NULL,
      `Titolo` varchar(10) NOT NULL,
      `CodiceConcerti` smallint(4) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Scala` (
      `CodiceScala` tinyint(4) NOT NULL,
      `NomeScala` varchar(20) NOT NULL,
      `CapienzaScala` smallint(4) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Scritto` (
      `CodicePezziMusicali` smallint(4) NOT NULL,
      `CodiceAutori` tinyint(4) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Strumento` (
      `NomeStrumento` varchar(10) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Suona` (
      `MatricolaOrchestrali` int(10) NOT NULL,
      `NomeStrumento` varchar(10) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    CREATE TABLE `Tenuto` (
      `CodiceScala` tinyint(4) NOT NULL,
      `CodiceConcerti` tinyint(4) NOT NULL,
      `Data` varchar(10) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

    ALTER TABLE `Autori`
      ADD PRIMARY KEY (`CodiceAutori`);

    ALTER TABLE `Concerti`
      ADD PRIMARY KEY (`CodiceConcerti`);

    ALTER TABLE `Direttori`
      ADD PRIMARY KEY (`CodiceDirettore`);

    ALTER TABLE `Eseguito`
      ADD PRIMARY KEY (`CodiceConcerti`,`NomeOrchestra`),
      ADD KEY `NomeOrchestra` (`NomeOrchestra`);

    ALTER TABLE `Formato`
      ADD PRIMARY KEY (`NomeOrchestra`,`MatricolaOrchestrali`),
      ADD KEY `MatricolaOrchestrali` (`MatricolaOrchestrali`),
      ADD KEY `NomeOrchestra` (`NomeOrchestra`);

    ALTER TABLE `Orchestrali`
      ADD PRIMARY KEY (`MatricolaOrchestrali`);

    ALTER TABLE `Orchestre`
      ADD PRIMARY KEY (`NomeOrchestra`),
      ADD UNIQUE KEY `CodiceDirettore` (`CodiceDirettore`);

    ALTER TABLE `PezziMusicali`
      ADD PRIMARY KEY (`CodicePezziMusicali`),
      ADD UNIQUE KEY `CodiceConcerti` (`CodiceConcerti`);

    ALTER TABLE `Scala`
      ADD PRIMARY KEY (`CodiceScala`);

    ALTER TABLE `Scritto`
      ADD PRIMARY KEY (`CodicePezziMusicali`,`CodiceAutori`),
      ADD KEY `CodiceAUtori` (`CodiceAutori`);

    ALTER TABLE `Strumento`
      ADD PRIMARY KEY (`NomeStrumento`);

    ALTER TABLE `Suona`
      ADD PRIMARY KEY (`MatricolaOrchestrali`,`NomeStrumento`),
      ADD KEY `NomeStrumento` (`NomeStrumento`);

    ALTER TABLE `Tenuto`
      ADD PRIMARY KEY (`CodiceScala`,`CodiceConcerti`),
      ADD KEY `CodiceConcerti` (`CodiceConcerti`);

    ALTER TABLE `Concerti`
      ADD CONSTRAINT `Concerti_ibfk_1` FOREIGN KEY (`CodiceConcerti`) REFERENCES `Eseguito` (`CodiceConcerti`);

    ALTER TABLE `Eseguito`
      ADD CONSTRAINT `NomeOrchestra` FOREIGN KEY (`NomeOrchestra`) REFERENCES `Orchestre` (`NomeOrchestra`);

    ALTER TABLE `Formato`
      ADD CONSTRAINT `MatricolaOrchestrali` FOREIGN KEY (`MatricolaOrchestrali`) REFERENCES `Orchestrali` (`MatricolaOrchestrali`);

    ALTER TABLE `Orchestre`
      ADD CONSTRAINT ` 	CodiceDirettore` FOREIGN KEY (`CodiceDirettore`) REFERENCES `Direttori` (`CodiceDirettore`);

    ALTER TABLE `Scritto`
      ADD CONSTRAINT `CodiceAUtori` FOREIGN KEY (`CodiceAutori`) REFERENCES `Autori` (`CodiceAutori`),
      ADD CONSTRAINT `CodicePezziMusicali` FOREIGN KEY (`CodicePezziMusicali`) REFERENCES `PezziMusicali` (`CodicePezziMusicali`);

    ALTER TABLE `Suona`
      ADD CONSTRAINT `NomeStrumento` FOREIGN KEY (`NomeStrumento`) REFERENCES `Strumento` (`NomeStrumento`),
      ADD CONSTRAINT `Suona_ibfk_1` FOREIGN KEY (`MatricolaOrchestrali`) REFERENCES `Orchestrali` (`MatricolaOrchestrali`);

    ALTER TABLE `Tenuto`
      ADD CONSTRAINT `CodiceConcerti` FOREIGN KEY (`CodiceConcerti`) REFERENCES `Concerti` (`CodiceConcerti`),
      ADD CONSTRAINT `CodiceScala` FOREIGN KEY (`CodiceScala`) REFERENCES `Scala` (`CodiceScala`);
    COMMIT;

-- ESERCIZIO RISTORANTI --

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `Appartiene` (
  `NomeZona` varchar(30) NOT NULL,
  `IndirizzoRistorante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CarteCredito` (
  `NomeCarta` varchar(40) NOT NULL,
  `NumeroVerde` smallint(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Convenzionati` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `NomeCarta` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Cucina` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `Codice` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Raggiunge` (
  `NomeZona` varchar(30) NOT NULL,
  `LineaTrasporti` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Ristorante` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `NomeRistorante` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `TipiCucina` (
  `Codice` tinyint(3) NOT NULL,
  `Descrizione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `TrasportiPlubbici` (
  `LineaTrasporti` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `ZonaCitta` (
  `NomeZona` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `Appartiene`
  ADD PRIMARY KEY (`NomeZona`,`IndirizzoRistorante`),
  ADD KEY `IndirizzoRistorante` (`IndirizzoRistorante`);

ALTER TABLE `CarteCredito`
  ADD PRIMARY KEY (`NomeCarta`);

ALTER TABLE `Convenzionati`
  ADD PRIMARY KEY (`IndirizzoRistorante`,`NomeCarta`),
  ADD KEY `NomeCarta` (`NomeCarta`);

ALTER TABLE `Cucina`
  ADD PRIMARY KEY (`IndirizzoRistorante`,`Codice`);

ALTER TABLE `Raggiunge`
  ADD PRIMARY KEY (`NomeZona`,`LineaTrasporti`),
  ADD KEY `LineaTrasporti` (`LineaTrasporti`);

ALTER TABLE `Ristorante`
  ADD PRIMARY KEY (`IndirizzoRistorante`);

ALTER TABLE `TipiCucina`
  ADD PRIMARY KEY (`Codice`);

ALTER TABLE `TrasportiPlubbici`
  ADD PRIMARY KEY (`LineaTrasporti`);

ALTER TABLE `ZonaCitta`
  ADD PRIMARY KEY (`NomeZona`);

ALTER TABLE `Appartiene`
  ADD CONSTRAINT `IndirizzoRistorante` FOREIGN KEY (`IndirizzoRistorante`) REFERENCES `Ristorante` (`IndirizzoRistorante`),
  ADD CONSTRAINT `NomeZona` FOREIGN KEY (`NomeZona`) REFERENCES `ZonaCitta` (`NomeZona`);

ALTER TABLE `Convenzionati`
  ADD CONSTRAINT `NomeCarta` FOREIGN KEY (`NomeCarta`) REFERENCES `CarteCredito` (`NomeCarta`);

ALTER TABLE `Raggiunge`
  ADD CONSTRAINT `LineaTrasporti` FOREIGN KEY (`LineaTrasporti`) REFERENCES `TrasportiPlubbici` (`LineaTrasporti`);
COMMIT;

-- ESERCIZIO MOSTRA CANI --

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `cani` (
  `CodC` varchar(4) NOT NULL,
  `NomeC` varchar(20) NOT NULL,
  `DataNC` date NOT NULL,
  `NomePC` varchar(30) NOT NULL,
  `TelPC` varchar(14) DEFAULT NULL,
  `AltC` tinyint(4) NOT NULL,
  `PesoC` mediumint(9) NOT NULL,
  `NomeR` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `giudica` (
  `CodG` tinyint(4) NOT NULL,
  `CodC` varchar(4) NOT NULL,
  `Voto` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `giudici` (
  `codG` tinyint(4) NOT NULL,
  `NomeG` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `razze` (
  `NomeR` varchar(20) NOT NULL,
  `AltR` tinyint(4) DEFAULT NULL,
  `PesoR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `cani`
  ADD PRIMARY KEY (`CodC`),
  ADD KEY `CollegamentoRazza` (`NomeR`);

ALTER TABLE `giudica`
  ADD PRIMARY KEY (`CodG`,`CodC`),
  ADD KEY `CodC` (`CodC`);

ALTER TABLE `giudici`
  ADD PRIMARY KEY (`codG`);

ALTER TABLE `razze`
  ADD PRIMARY KEY (`NomeR`);

ALTER TABLE `giudici`
  MODIFY `codG` tinyint(4) NOT NULL AUTO_INCREMENT;

ALTER TABLE `cani`
  ADD CONSTRAINT `CollegamentoRazza` FOREIGN KEY (`NomeR`) REFERENCES `razze` (`NomeR`);


ALTER TABLE `giudica`
  ADD CONSTRAINT `giudica_ibfk_2` FOREIGN KEY (`CodC`) REFERENCES `cani` (`CodC`),
  ADD CONSTRAINT `giudica_ibfk_3` FOREIGN KEY (`CodG`) REFERENCES `giudici` (`codG`);
COMMIT;

-- ESERCIZIO PROVA --

CREATE TABLE esercizioProva (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Prova_1` VARCHAR(45) NULL,
  `Prova_2` VARCHAR(45) NULL);

ALTER TABLE esercizioProva ADD PRIMARY KEY (`id`);

-- ESERCIZIO INTRODUZIONE --

CREATE TABLE IF NOT EXISTS Persone (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(45) NULL,
	`cognome` VARCHAR(45) NULL,
	`dataDiNascita` DATE NULL,
	`sesso` ENUM('M','F') NULL,
	PRIMARY KEY (`id`));

CREATE DATABASE 5C_Biblioteca;

USE 5c_Biblioteca;

CREATE TABLE Libri (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Titolo` VARCHAR(45) NULL,
  `Autore` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

SHOW TABLES -- mostra le tabelle presenti nel DB in uso --

DESCRIBE Libri; -- struttura della tabella Libri --

ALTER TABLE Libri RENAME Opere; -- Rinomina il database --
ALTER TABLE Opere RENAME Libri;
ALTER TABLE Libri CHANGE Titolo Titolo varchar(100);
ALTER TABLE Libri CHANGE Titolo Opera varchar(100);
ALTER TABLE Libri ADD NumeroPagine INT; -- Aggiungere una nuova variabile di tipo int chiamato NumeroPagine --
ALTER TABLE Libri DROP NumeroPagine;		-- elimina la variabile NumeroPagine --
DROP DATABASE 5C_Biblioteca; -- elimina l'intero database --
ALTER TABLE Persone ADD eta INT NOT NULL
DROP PRIMARY KEY ON Persone;
CREATE PRIMARY KEY ON Persone (eta);

ALTER TABLE Persone CHANGE id id INT NOT NULL;
ALTER TABLE Persone DROP PRIMARY KEY;
ALTER TABLE Persone ADD PRIMARY KEY (eta);
ALTER TABLE Persone CHANGE id id INT NOT NULL AUTO_INCREMENT;
CREATE INDEX eta_ind ON Persone(`eta`);
DROP INDEX eta_ind ON Persone;

/*Inserimento dei dati nelle tabelle*/
INSERT INTO nomeTabella (pk_specializzazione,descrizione) VALUES	-- pk_specializzazione e descrizione sono la variabili della Tabella--
	(1,'NomeVariabile1'),	-- Record --
	(2,'NomeVariabile2'),
	(3,'NomeVariabile3'),
	(4,'NomeVariabile4');		-- Il comando INSERT si chiude con il ';' --

INSERT INTO nomeTabella2 (pk_istruttore,descrizione) VALUES	-- pk_specializzazione e descrizione sono la variabili della Tabella--
	(1,'NV1'),	-- Record --
	(2,'NV2'),
	(3,'NV3'),
	(4,'NV4');		-- Il comando INSERT si chiude con il ';' --

-- In Valli''' ci darà Vallì; ''' serve per l'accento --
INSERT INTO istruttori_specializzazioni (fk_istruttore, fk_specializzazione);
	(3,1),
	(4,1),
	(1,2),
	(4,3),
	(1,4);
-- In questo modo NV1 è collegato a NomeVariabile3 e NomeVariabile4, NV2 a NomeVariabile1, NV3 a NomeVariabile4, NV4 a NomeVariabile1
