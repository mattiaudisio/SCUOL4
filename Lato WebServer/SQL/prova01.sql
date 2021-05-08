-- Per cambiare/aggiornare un determinato valore usiamo l'istruzione UPDATE e il comando
-- SET per identificare il record interessato
-- 
-- UPDATE anagrafe SET indirizzo=
-- 'Via Roma, 22' WHERE indirizzo = 'Corso V. Emanuele,215';

-- ###############################################################################################################################
-- ESERCIZIO MANIFESTAZIONI --
-- Le informazioni relative alle attività sportive studentesche devono essere organizzate in una base di dati.
-- Gli studenti, dei quali si conservano le informazioni anagrafiche frequentano gli Istituti superiori, e possono partecipare a una o 
-- più manifestazioni sportive (specialità sportive diverse, giornate diverse, campionati durano per mesi o gare di un giorno).
-- Per ogni attività sportiva le scuole indicano un professore che svolge la funzione di riferimento e di allenatore: ogni professore segue una sola manifestazione 
-- ma una stessa manifestazione può essere seguita da professori diversi di scuole diverse.
-- Definire un modello del database (con relativi schemi ER e Logico) e successiva implementazione fisica in SQL 
-- considerando che possano essere poi svolte le seguenti interrogazioni (anche se ora non è ancora possibile per lo studente tradurle nei relativi comandi QL):
-- 1. Numero degli studenti che partecipano a una determinata manifestazione sportiva.
-- 2. Elenco anagrafico degli allenatori di un'attività sportiva.
-- 3. Elenco delle scuole (denominazione) con il numero di studenti che partecipano alle attività sportive.
-- 4. Elenco delle scuole (con denominazione, indirizzo, telefono) con studenti che partecipano a una determinata manifestazione sportiva.
-- 5. Elenco degli allenatori (cognome e nome) e scuole (denominazione) di appartenenza in ordine alfabetico.
-- 6. Numero degli studenti partecipanti di una determinata scuola per ciascuna delle manifestazioni sportive.
-- Naturalmente anche le relazioni tra le tabelle devono essere esplicitate in SQL in modo da poter essere in grado di dare risposta alle interrogazioni di cui sopra.

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

-- ###############################################################################################################################
-- ESERCIZIO ORCHESTRA --
-- La stagione concertistica di Orvieto prevede una serie di concerti ognuno dei quali ha un codice, un titolo e una descrizione, ed è composto da un insieme di pezzi musicali.
-- Ogni pezzo ha un codice, un titolo e uno o più autori (ciascuno con codice e nome); uno stesso pezzo può essere rappresentato in diversi concerti.
-- Ogni concerto è eseguito da un’orchestra; ogni orchestra ha un nome, un direttore (del quale interessano solo nome e cognome) e un insieme di orchestrali. 
-- Ogni orchestrale ha una matricola (univoca nell’ambito della base di dati), nome e cognome, suona uno o più strumenti e può partecipare a più orchestre. 
-- Ogni concerto è tenuto in una sala, in una certa data. Ogni sala ha un codice, un nome e una capienza.

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

-- ###############################################################################################################################
-- ESERCIZIO RISTORANTI --
-- Diversi ristoranti adottano diversi tipi di cucina (cinese, tailandese, italiana, ...). --
-- Ad ogni tipo di cucina si vuole associare un codice ed una breve descrizione ad uso dei turisti. --
-- I ristoranti sono siti in zone diverse della città, ognuna delle quali è raggiunta da almeno una linea urbana di autobus. --  
-- I ristoranti, di cui si fornisce anche nome e indirizzo, accettano esclusivamente le carte di credito con cui sono convenzionati. --
-- Per ogni tipo di carta di credito è disponibile un numero verde in caso sia necessaria una consulenza telefonica. --

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

-- ###############################################################################################################################
-- ESERCIZIO MOSTRA CANI --
-- Progettare una base di dati per la gestione di una mostra canina.
-- Di ogni cane, identificato da un codice, interessano il nome, la data di nascita, l'altezza, il peso, la razza di appartenenza, e i dati del proprietario. 
-- Le razze si distinguono dal nome, e possiedono un'altezza e un peso standard. Ogni giudice, identificato da un codice, esprime un voto su ciascun cane.

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

-- ###############################################################################################################################
-- ESERCIZIO PROVA --

CREATE TABLE esercizioProva (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Prova_1` VARCHAR(45) NULL,
  `Prova_2` VARCHAR(45) NULL);

ALTER TABLE esercizioProva ADD PRIMARY KEY (`id`);

-- ###############################################################################################################################
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

-- ###############################################################################################################################	      
-- VERIFICA --
-- Un’agenzia artistica conserva nei propri archivi informazioni riguardanti gruppi musicali.
-- Di ciascun gruppo, identificato da un codice, interessa il nome e l’anno di fondazione.
-- Un gruppo ha pubblicato degli album, dei quali interessa il titolo e l’anno di uscita; ogni album è identificato da un codice, ed è realizzato da un solo gruppo.
-- Un gruppo ha partecipato a concerti, anch’essi identificati da un codice, e dei quali interessa ilnome, il luogo, la data; ad un concerto possono partecipare più gruppi, 
-- e per ciascun concertointeressa quante canzoni ha cantato ciascun gruppo.Anche i componenti di un gruppo sono identificati da un codice;
-- di essi interessa la nazionalità,lo stipendio annuale e l’anno di nascita. Alcuni componenti hanno il ruolo di strumentisti, altri di cantante. Gli strumentisti sono 
-- identificati dal cognome, dal nome e dall’eventuale pseudonimo. Di loro si conoscono lo strumento o gli strumenti suonati, i quali sonoidentificati da un codice e dal
-- tipo di strumento. Il cantante è uno solo per ogni gruppo e non suonaalcuno strumento, è identificato dal cognome, dal nome e dall’eventuale pseudonimo.
-- Di lui sisanno le canzoni cantate, identificate dal codice e dal titolo.Si richiede:
-- •Schema E/R (con le cardinalità espresse in entrambe le modalità)  
-- •Schema logico•Risoluzione delle seguenti query:
-- 1.Elenco dei componenti (cognome, nome, nazionalità) del gruppo AC/DC
--  2.Il nome ed il cognome del cantante del gruppo Pinguini Tattici Nucleari nell’album“Faber Nostrum”
-- 3.Nome e cognome dei cantanti italiani ed il numero di canzoni interpretate da ognuno diessi
-- 4.Il guadagno annuale totale di ogni gruppo
-- 5.Elenco dei componenti (cognome, nome) dei gruppi che hanno suonato al Concertonedel 1 Maggio 2019 a Roma
-- 6.Numero di album usciti nell’anno 2001, suddividi per ogni gruppo 
-- 7.Cognome e nome del batterista dei gruppi con anno di fondazione successivo al 1977	       
	       
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

/*Gruppo*/
INSERT INTO `Gruppo` VALUES(`ACDC`,`ACDC`,`1975`);
INSERT INTO `Gruppo` VALUES(`PTN`,`Pinguini Tattici Nucleari`,`2012`);
INSERT INTO `Gruppo` VALUES(`LP`,`Linkin Park`,`1998`);

/*Album*/
INSERT INTO `Album` VALUES(`AFN2019`,`PTN`,`Faber Nostrum`,`2019`);
INSERT INTO `Album` VALUES(`AHT2001`,`LP`,`Hybrid THeory`,`2001`);

/*Concerti*/
INSERT INTO `Concerti` VALUES(`C1M19`,`Concertone`,`Roma` `01052019`);

/*Partecipa*/
INSERT INTO `Partecipa` VALUES(`ACDC`,`C1M19`,`01052019`);
INSERT INTO `Partecipa` VALUES(`LP`,`C1M19`,`01052019`);

/*Componenti*/
INSERT INTO `Componenti` VALUES(`CG101`,`Italia`,`30000`,`10811950`,`EGSTRUM`,`FNCANT`,`ACDC`);
INSERT INTO `Componenti` VALUES(`CG201`,`Italia`,`20000`,`11011992`,`ABSTRUM`,`RZCANT`,`PTN`);
INSERT INTO `Componenti` VALUES(`CG301`,`Italia`,`10000`,`11111976`,`CFSTRUM`,`CDCANT`,`LP`);

/*Strumentista*/
INSERT INTO `Strumentista` VALUES(`RFSTRUM`,`Facchinetti`,`Roby`);
INSERT INTO `Strumentista` VALUES(`ABSTRUM`,`Aa`,`Bb`);
INSERT INTO `Strumentista` VALUES(`CFSTRUM`,`Cc`,`Ff`);

/*Strumenti*/
INSERT INTO `Strumenti` VALUES(`TSTRUM`,`RFSTRUM`,`Tastiera`);
INSERT INTO `Strumenti` VALUES(`BTSTRUM`,`ABSTRUM`,`Batteria`);

/*Cantante*/
INSERT INTO `Cantante` VALUES(`RZCANT`,`CG101`,`Riccardo`,`Zanotti`);
INSERT INTO `Cantante` VALUES(`FNCANT`,`CG201`,`Ff`,`Nn`);
INSERT INTO `Cantante` VALUES(`CDCANT`,`CG301`,`Cc`,`Dd`);

/*Canzoni*/
INSERT INTO `Canzoni` VALUES(`C01`,`RZCANT`,`Verdura`);
INSERT INTO `Canzoni` VALUES(`C02`,`FNCANT`,`canzone1`);
INSERT INTO `Canzoni` VALUES(`C03`,`CDCANT`,`canzone2`);

/*Elenco dei componenti del gruppo AC/DC*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum, Cantante.nomeCant, Cantante.cognCant, Componenti.nazComp
FROM Strumentista, Componenti, Gruppo, Cantante
WHERE Gruppo.codGruppo = 'ACDC'
AND Componenti.codGruppo = Gruppo.codGruppo
AND Strumentista.psedStrum = Componenti.psedStrum
AND Cantante.psedCant = Componenti.psedCant;

/*Nome e cognome del cantante del gruppo Pinguini Tattici Nucleari nell'album Faber Nostrum*/
SELECT Cantante.nomeCant, Cantante.cognCant
FROM Cantante, Album, Componenti, Gruppo
WHERE Album.titAlbum = 'Faber Nostrum'
AND Album.codGruppo = Gruppo.codGruppo
AND Componenti.codGruppo = Gruppo.codGruppo
AND Componenti.psedCant = Cantante.psedCant;

/*Nome e cognome dei cantanti italiani ed il numero di canzoni interpretate da ognuno di essi*/
SELECT Cantanti.nomeCant, Cantanti.cognCant, COUNT(Canzoni.codCanz) AS nCanzoni
FROM Cantanti, Canzoni, Componenti
WHERE Componenti.nazComp = 'Italia'
AND Componenti.psedCant = Cantante.psedCant
AND Canzoni.psedCant = Cantante.psedCant
GROUP BY Canzoni.codCanz
ORDER BY Cantanti.cognCant;

/*il guadagno annuale di ogni gruppo*/
SELECT Componenti.stipAnn, Gruppo.nomeGruppo
FROM Componenti, Gruppo
WHERE Componenti.codGruppo = Gruppo.codGruppo
ORDER BY Gruppo.nomeGruppo;

/*Elenco dei componenti che hanno suonato al Conertone del 1 Maggio 2019 a Roma*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum, Cantante.nomeCant, Cantante.cognCant, Gruppo.nomeGruppo
FROM Strumentista, Cantante, Gruppo, Componenti, Concerti, Partecipa
WHERE  Concerti.dataConcerti = '01052019'
AND Concerti.luogoConcerti = 'Roma'
AND Concerti.nomeConcerti = 'Concertone'
AND Partecipa.codConcerti = Concerti.codConcerti
AND Partecipa.codGruppo = Gruppo.codGruppo
AND Componenti.codGruppo = Gruppo.codGruppo
AND Componenti.psedCant = Cantante.psedCant
AND Componenti.psedStrum = Strumentista.psedStrum
ORDER BY Gruppo.nomeGruppo;

/*Numero degli album usciti nell'anno 2001, suddivisi per ogni gruppo*/
SELECT Gruppo.codGruppo, COUNT(Gruppo.codGruppo) AS nAlbum
FROM Album, Gruppo
WHERE Album.annoUscita = '2001'
GROUP BY Gruppo.codGruppo
ORDER BY Gruppo.codGruppo;

/*Cognome e nome del batterista dei gruppi con anno di fondazione successivo al 1997*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum
FROM Gruppo, Componenti, Strumentista, Strumenti
WHERE Gruppo.annoGruppo > '1997'
AND Gruppo.codGruppo = Componenti.codGruppo
AND Componenti.psedStrum = Strumentista.psedStrum
AND Strumentista.psedStrum = Strumenti.psedStrum
AND Strumenti.tipoStrument = 'Batteria'
ORDER BY Strumentista.cognStrum;

-- ###############################################################################################################################	      			    
-- ComandiSQL_x_db_palestra --

/*Creazione del database*/
create database 5C_db_palestra;
USE 5C_db_palestra;
/*Creazione della tabella specializzazioni*/
create table specializzazioni(pk_specializzazione int auto_increment, descrizione varchar(50), primary key(pk_specializzazione)) engine=innodb;
/*Creazione della tabella istruttori*/
create table istruttori(pk_istruttore int auto_increment, nome varchar(50) not null, cognome varchar(50) not null, tel varchar(20), primary key(pk_istruttore)) engine=innodb;
/*Creazione della tabella istruttori_specializzazioni*/
create table istruttori_specializzazioni(fk_istruttore int, fk_specializzazione int, primary key(fk_istruttore,fk_specializzazione), foreign key(fk_istruttore) references istruttori(pk_istruttore), foreign key(fk_specializzazione) references specializzazioni(pk_specializzazione)) engine=innodb;
/*Creazione della tabella corsi*/
create table corsi(pk_corso int auto_increment, descrizione varchar(50) not null,num_posti int,anno year(4), primary key(pk_corso)) engine=innodb;
/*Creazione della tabella istruttori_corsi*/
create table istruttori_corsi(fk_istruttore int, fk_corso int, primary key(fk_istruttore,fk_corso), foreign key(fk_istruttore) references istruttori(pk_istruttore), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;
/*Creazione della tabella clienti*/
create table clienti(pk_cliente int auto_increment, nome varchar(50) not null, cognome varchar(50) not null, tel varchar(20), email varchar(40), primary key(pk_cliente)) engine=innodb;
/*Creazione della tabella clienti_corsi*/
create table clienti_corsi(fk_cliente int, fk_corso int, primary key(fk_cliente, fk_corso), foreign key(fk_cliente) references clienti(pk_cliente), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;
/*Creazione della tabella certificati*/
create table certificati(pk_certificato int auto_increment, data_certificato date not null, fk_cliente int, primary key(pk_certificato), foreign key(fk_cliente) references clienti(pk_cliente)) engine=innodb;
/*Creazione della tabella orari*/
create table orari(giorno_settimana varchar(10), ora_inizio time, ora_fine time, fk_corso int, primary key(giorno_settimana,ora_inizio,fk_corso), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;

USE 5C_db_palestra;
/*Inserimento dei dati nelle tabelle*/
INSERT INTO specializzazioni (pk_specializzazione, descrizione) VALUES
  	(1, 'aerobica'),
  	(2, 'step'),
  	(3, 'yoga'),
  	(4, 'pesi'),
  	(5, 'fitness');

INSERT INTO istruttori (pk_istruttore, nome, cognome, tel) VALUES
  	(1, 'Francesco', 'Vaschetto', '34567898'),
  	(2, 'Barbara', 'Demo', '333234433'),
  	(3, 'Sophia', 'Danesino', '347868797'),
  	(4, 'Barbara', 'Carando', '324756456'),
  	(5, 'Luisa', 'Dal Paos', '345743456');

INSERT INTO istruttori_specializzazioni (fk_istruttore, fk_specializzazione) VALUES
  	(3, 1),
  	(4, 1),
  	(1, 2),
  	(5, 2),
  	(1, 3),
  	(2, 3),
  	(3, 4),
  	(5, 5);

INSERT INTO corsi (pk_corso, descrizione, num_posti, anno) VALUES
  	(1, 'aerobica', 5, '2013'),
  	(2, 'pesi', 6, '2013'),
  	(3, 'step', 4, '2013'),
  	(4, 'yogaA', 6, '2013'),
  	(5, 'yogaB', 5, '2013');

INSERT INTO istruttori_corsi (fk_istruttore, fk_corso) VALUES
  	(3, 1),
  	(4, 1),
  	(1, 2),
  	(5, 2),
  	(1, 3),
  	(2, 3),
  	(3, 4),
  	(5, 5);

INSERT INTO clienti (pk_cliente, nome, cognome, tel, email) VALUES
  	(1, 'Claudio', 'Borgogno', '333456789', 'claudio.borgogno@gmail.com'),
  	(2, 'Flaviano', 'Monge', '334543213', 'flaviano.monge@libero.it'),
  	(3, 'Maria Grazia', 'Maffucci', ' ', 'mgm.mgm@gmail.com'),
  	(4, 'Paola', 'Longobardi', '', 'p_longobardi@yahoo.it'),
  	(5, 'Marco', 'Bracco', '324987456', 'marco.bracco@hotmail.com'),
  	(6, 'Jessica', 'Paschini', '344456456', 'jessica_p@libero.it'),
  	(7, 'Nunzio', 'Ferrigno', '347898767', 'n_ferrigno@hotmail.com'),
  	(8, 'Federico', 'Sarzotti', '324567234', 'sarzfed@yahoo.it');

INSERT INTO clienti_corsi (fk_cliente, fk_corso) VALUES
  	(1, 1),
  	(3, 1),
  	(2, 2),
  	(6, 2),
  	(1, 3),
  	(4, 3),
  	(8, 3),
  	(3, 4),
  	(5, 4),
  	(8, 4),
  	(4, 5),
  	(6, 5),
  	(7, 5);

INSERT INTO certificati (pk_certificato, data_certificato, fk_cliente) VALUES
  	(1, '2013-01-11', 6),
  	(2, '2012-02-10', 1),
  	(3, '2013-03-02', 4),
  	(4, '2012-01-11', 3),
  	(5, '2013-04-03', 2),
  	(6, '2012-12-05', 8),
  	(7, '2012-10-16', 7),
  	(8, '2012-02-13', 5);

INSERT INTO orari (giorno_settimana, ora_inizio, ora_fine, fk_corso) VALUES
  	('giovedi''', '18:00:00', '19:00:00', 2),
  	('giovedi''', '19:00:00', '20:00:00', 5),
  	('lunedi''', '15:00:00', '16:00:00', 1),
  	('lunedi''', '18:00:00', '19:00:00', 3),
  	('lunedi''', '19:00:00', '20:00:00', 3),
  	('martedi''', '18:00:00', '19:00:00', 2),
  	('martedi''', '19:00:00', '20:00:00', 5),
  	('mercoledi''', '16:00:00', '17:00:00', 1),
  	('mercoledi''', '18:00:00', '19:00:00', 2),
  	('venerdi''', '20:00:00', '21:00:00', 4);

-- ###############################################################################################################################
-- Esercizio_Carnevale --
-- Un piccolo comune deve gestire mediante database le multe per violazione del codice della strada. 
-- Gli addetti a fare multe sono gli agenti, i quali sono descritti da matricola e nominativo.
-- Le infrazioni   sanzionabili   sono   descritte   dal   codice   infrazione,   data,   agente   che   l’ha   scritta,denominazione dell’infrazione 
-- (es. “divieto di sosta”, “Eccesso di velocità”, ...), importo e targa delveicolo multato. Dei veicoli interessano la targa, la marca (es. “Fiat”, “Citroen”, ...), 
-- il modello edil proprietario. Ogni automobilista è infine descritto dal codice fiscale, dal cognome, nome,indirizzo, città e CAP.
-- Query:
-- 1)Cognome e nome degli automobilisti multati per divieto di sosta suddivisi per città
-- 2)Marca e modello dei veicoli multati dall’agente Rossi il 14/02/2020, raggruppati permarca
-- 3)Numeri di targa e nomi dei proprietari multati dall’agente Verdi per eccesso divelocità
-- 4)Elenco delle date e del tipo di infrazioni commesse dall’automobilista Va Lentino
-- 5)Numero di infrazioni sanzionate dall’agente Severo6)Importo totale delle multe del veicolo FD 444 XX 

CREATE DATABASE 5C_Multe;
USE 5C_Multe;

-- CREAZIONE AGENTI --
CREATE TABLE IF NOT EXISTS Agenti(
    matricolaAgente VARCHAR(10) NOT NULL,
    nominativoAgente VARCHAR(20) NULL,
    nomeAgente VARCHAR(10) NULL,
    cognomeAgente VARCHAR(10) NULL,
    PRIMARY KEY(matricolaAgente)
);

-- CREAZIONE MULTA --
CREATE TABLE IF NOT EXISTS Multa(
    matricolaAgente VARCHAR(10) NOT NULL,
    targaVeicolo VARCHAR(7) NOT NULL,
    codiceInfrazione VARCHAR(10) NULL,
    dataInfrazione VARCHAR(10) NULL,
    denominazioneInfrazione VARCHAR(50) NULL,
    importoInfrazione INT(200) NULL,
    PRIMARY KEY(matricolaAgente,targaVeicolo)
);

-- CREAZIONE VEICOLI--
CREATE TABLE IF NOT EXISTS Veicoli(
    targaVeicolo VARCHAR(7) NOT NULL,
    marcaVeicolo VARCHAR(20) NULL,
    modelloVeicolo VARCHAR(20) NULL,
    codiceFiscale VARCHAR(11) NOT NULL,
    PRIMARY KEY(targaVeicolo)
);

-- CREAZIONE AUTOMOBILISTA --
CREATE TABLE IF NOT EXISTS Automobilista(
    codiceFiscale VARCHAR(11) NOT NULL,
    cognomeAutomobilista VARCHAR(10) NULL,
    nomeAutomobilista VARCHAR(10) NULL,
    indirizzo VARCHAR(50) NULL,
    citta VARCHAR(30) NULL,
    CAP VARCHAR(5) NULL,
    PRIMARY KEY(codiceFiscale)
);

ALTER TABLE Multa ADD FOREIGN KEY (matricolaAgente) REFERENCES Agenti (matricolaAgente);
ALTER TABLE Multa ADD FOREIGN KEY (targaVeicolo) REFERENCES Veicoli (targaVeicolo);
ALTER TABLE Veicoli ADD FOREIGN KEY (codiceFiscale) REFERENCES Automobilista (codiceFiscale);

USE 5C_Multe;

INSERT INTO Agenti VALUES('AMT01','Agente Rossi','Matteo','Rossi');
INSERT INTO Agenti VALUES('AGV02','Agente Verdi','Giovanni','Verdi');
INSERT INTO Agenti VALUES('ALS03','Agente severo','Lorenzo','Severo');

INSERT INTO Multa VALUES('AGV02','CRI0106','I01','27/02/2020','eccesso di velocità',150);
INSERT INTO Multa VALUES('AMT01','FD444XX','I02','14/02/2020','divieto di sosta',100);
INSERT INTO Multa VALUES('ALS03','FD444XX','I03','14/02/2020','deccesso di velocità',150);

INSERT INTO Veicoli VALUES('FD444XX','Fiat','Panda','VALNTZ71L2Y');
INSERT INTO Veicoli VALUES('CRI0106','Citroen','C3','RYSLPO33B6C');

INSERT INTO Automobilista VALUES('VALNTZ71L2Y','Lentino','Va','Via Piasco 24','Cuneo','12100');
INSERT INTO Automobilista VALUES('RYSLPO33B6C','Eugenio','Federici','Corso Lombardia 3','Fossano','12045');

USE 5C_Multe;

/*Cognome e nome degli automobilisti multati per divieto di sosta suddivisi per città*/
SELECT Automobilista.cognomeAutomobilista, Automobilista.nomeAutomobilista, Automobilista.citta,
FROM Automobilista, Veicoli, Multa
WHERE Multa.denominazioneInfrazione = 'divieto di sosta'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
ORDER BY Automobilista.cognomeAutomobilista;

/*Marca e modello dei veicoli multati dall’agente Rossi il 14/02/2020, raggruppati per marca*/
SELECT Veicoli.marcaVeicoli, Veicoli.modelloVeicolo
FROM Veicoli, Multa, Agenti
WHERE Multa.dataInfrazione = '14/02/2020'
AND Multa.matricolaAgente = Agenti.matricolaAgente
AND Agenti.cognomeAgente = 'Rossi'
ORDER BY Veicoli.marcaVeicoli;

/*Numeri di targa e nomi dei proprietari multati dall’agente Verdi per eccesso divelocità*/
SELECT Veicoli.targaVeicolo, Automobilista.nomeAutomobilista
FROM *
WHERE Agenti.cognomeAgente = 'Verdi'
AND Multa.matricolaAgente = Agenti.matricolaAgente
AND Multa.denominazioneInfrazione = 'eccesso di velocità'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
ORDER BY Veicoli.targaVeicolo;

/*Elenco delle date e del tipo di infrazioni commesse dall’automobilista Va Lentino*/
SELECT Multa.dataInfrazione, Multa.denominazioneInfrazione
FROM Multa, Veicoli, Automobilista
WHERE Automobilista.nomeAutomobilista = 'Va'
AND Automobilista.cognomeAutomobilista = 'Lentino'
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
AND Multa.targaVeicolo = Veicoli.targaVeicolo
ORDER BY Multa.dataInfrazione;

/*Numero di infrazioni sanzionate dall’agente Severo*/
SELECT count(Multa.codiceInfrazione) as Numero
FROM Multa, Agenti
WHERE Agenti.cognomeAgente = 'Severo'
AND Agenti.matricolaAgente = Multa.matricolaAgente
GROUP BY Multa.codiceInfrazione
ORDER BY Multa.codiceInfrazione;

/*Importo totale delle multe del veicolo FD 444 XX*/
SELECT SUM(Multa.importoInfrazione) as Importo
FROM Multa, Veicolo
WHERE Veicolo.targaVeicolo = 'FD444XX'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
GROUP BY Multa.importoInfrazione;

-- ###############################################################################################################################
-- PREPARAZIONE VERIFICA --
-- Le informazioni relative alle attività sportive studentesche devono essere organizzate in una base di dati.
-- Gli studenti, dei quali si conservano le informazioni anagrafiche frequentano gli Istituti superiori, e possono partecipare a una o 
-- più manifestazioni sportive (specialità sportive diverse, giornate diverse, campionati durano per mesi o gare di un giorno).
-- Per ogni attività sportiva le scuole indicano un professore che svolge la funzione di riferimento e di allenatore: ogni professore segue una sola manifestazione 
-- ma una stessa manifestazione può essere seguita da professori diversi di scuole diverse.
-- Definire un modello del database (con relativi schemi ER e Logico) e successiva implementazione fisica in SQL 
-- considerando che possano essere poi svolte le seguenti interrogazioni (anche se ora non è ancora possibile per lo studente tradurle nei relativi comandi QL):
-- 1. Numero degli studenti che partecipano a una determinata manifestazione sportiva.
-- 2. Elenco anagrafico degli allenatori di un'attività sportiva.
-- 3. Elenco delle scuole (denominazione) con il numero di studenti che partecipano alle attività sportive.
-- 4. Elenco delle scuole (con denominazione, indirizzo, telefono) con studenti che partecipano a una determinata manifestazione sportiva.
-- 5. Elenco degli allenatori (cognome e nome) e scuole (denominazione) di appartenenza in ordine alfabetico.
-- 6. Numero degli studenti partecipanti di una determinata scuola per ciascuna delle manifestazioni sportive.
-- Naturalmente anche le relazioni tra le tabelle devono essere esplicitate in SQL in modo da poter essere in grado di dare risposta alle interrogazioni di cui sopra.

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

INSERT INTO Studente VALUES('s01','aaa','aaa','02022020','1C','i01');
INSERT INTO Studente VALUES('s02','bbb','bbb','03032019','2C','i01');
INSERT INTO Studente VALUES('s03','ccc','ccc','04062018','3C','i01');
INSERT INTO Studente VALUES('s04','ddd','ddd','05052017','4C','i02');
INSERT INTO Studente VALUES('s05','eee','eee','06032016','5C','i02');

INSERT INTO Istituti VALUES('i01','den01','ind01','06032016');
INSERT INTO Istituti VALUES('i02','den02','ind02','06032016');
INSERT INTO Istituti VALUES('i03','den03','ind03','06032016');
INSERT INTO Istituti VALUES('i04','den04','ind04','06032016');
INSERT INTO Istituti VALUES('i05','den05','ind05','06032016');

INSERT INTO Professore VALUES()

/*Elenco degli studenti dell’itis suddivisi per attività sportiva*/
SELECT Istituti.denominazione, Studente.nome
FROM Istituti, Studente, Professore, Manifestazione
WHERE Isituti.denominazione = 'Itis'
AND Studente.codiceIstituto = Istituti.codiceIstituto
ORDER BY Studente.nome;

/*Numero degli studenti per ogni scuola che partecipano alla gara dinuoto*/
SELECT Studente.nome, Manifestazione.codiceManifestazione
FROM Studente, Manifestazione
WHERE  Manifestazione.codiceManifestazione = 'Nuoto'
ORDER BY Studente.nome;

/*Elenco anagrafico degli allenatori per ogni attività sportiva*/
SELECT Professore.nome
FROM Professore
ORDER BY Professore.nome;

/*Elenco   delle   scuole   (con   denominazione,   indirizzo,   telefono)   constudenti che partecipano alla gara di salto in lungo*/
SELECT Istituti.denominazione, Istituti.indirizzo, Istituti.telefono, Manifestazione.codiceManifestazione
FROM Istituti, Manifestazione, Professore
WHERE Manifestazione.codiceManifestazione = 'Salto in lungo'
AND Manifestazione.codiceManifestazione = Professore.codiceManifestazione
AND Professore.codiceIstituto = Istituti.codiceIstituto
ORDER BY Istituti.denominazione;

/*Totale   degli   alunni   per   ogni   scuola   che   partecipano   alle   attivitàsportive, ordinati per scuola ed in seguito per attività sportiva*/
SELECT     

-- ###############################################################################################################################
-- ESERCIZI MERENDE --
-- Interrogazioni
-- 1. Elenco delle merendine della scuola con codice 34 ordinate per prezzo
-- 2. Elenco con nome della merenda, tipo della macchinetta, quantità merendine e nome della scuola in cui si trova la macchinetta; elencare solo le macchinette che hanno 
-- almeno una merendina; l’elenco deve essere ordinato alfabeticamente per nome scuola e in subordine per numero di merendine decrescente presenti nelle macchinette.
-- 3. Elenco con i nomi delle scuole e numero delle macchinette presenti
-- 4. Prezzo medio delle macchinette nella scuola 12
-- 5. Elenco delle macchinette che non hanno più merendine
-- 6. Elenco dei tipi di macchinetta con il numero totale di merendine in esse caricato; escludere dall’elenco i tipi di macchinetta con meno di 40 merendine.		

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

INSERT INTO Merende VALUES('aaa','Kinder Bueno', 1.7);
INSERT INTO Merende VALUES('bbb','Oreo', 1.9);
INSERT INTO Merende VALUES('ccc','Ringo', 1.9);
INSERT INTO Merende VALUES('ddd','Rodeo', 1);
INSERT INTO Merende VALUES('eee','Focaccia', 2.5);
INSERT INTO Merende VALUES('fff','Kinder Delice', 0.70);
INSERT INTO Merende VALUES('ggg','PopCorn', 1.2);
INSERT INTO Merende VALUES('hhh','Coca Cola', 2);
INSERT INTO Merende VALUES('iii','Acqua Naturale', 0.35);
INSERT INTO Merende VALUES('jjj','Acqua Frizzante', 0.35);


INSERT INTO Scuole VALUES('scA','artistico');
INSERT INTO Scuole VALUES('scB','scientifico');
INSERT INTO Scuole VALUES('scC','linguistico');
INSERT INTO Scuole VALUES('scD','classico');
INSERT INTO Scuole VALUES('scE','scienze umane');
INSERT INTO Scuole VALUES('34','ITIS');
INSERT INTO Scuole VALUES('12','afp');


INSERT INTO Macchinette VALUES('mcA','bibite','scA');
INSERT INTO Macchinette VALUES('mcB','snack1','scA');
INSERT INTO Macchinette VALUES('mcC','snack2','scA');
INSERT INTO Macchinette VALUES('mcD','bibite','scB');
INSERT INTO Macchinette VALUES('mcE','snack','scB');
INSERT INTO Macchinette VALUES('mcF','snack','scC');
INSERT INTO Macchinette VALUES('mcG','bibite','scD');
INSERT INTO Macchinette VALUES('mcH','snack','scE');
INSERT INTO Macchinette VALUES('mcI','bibite','scE');
INSERT INTO Macchinette VALUES('mcJ','snack','scD');
INSERT INTO Macchinette VALUES('mcK','snack','34');
INSERT INTO Macchinette VALUES('mcL','snack','12');


INSERT INTO Posizioni VALUES('po1',4,'aaa','mcB');
INSERT INTO Posizioni VALUES('po2',12,'bbb','mcB');
INSERT INTO Posizioni VALUES('po3',8,'ccc','mcB');
INSERT INTO Posizioni VALUES('po4',7,'jjj','mcA');
INSERT INTO Posizioni VALUES('po5',9,'iii','mcA');
INSERT INTO Posizioni VALUES('po6',15,'hhh','mcA');
INSERT INTO Posizioni VALUES('po7',11,'ggg','mcC');
INSERT INTO Posizioni VALUES('po8',5,'fff','mcC');
INSERT INTO Posizioni VALUES('po9',14,'jjj','mcD');
INSERT INTO Posizioni VALUES('po10',2,'hhh','mcD');
INSERT INTO Posizioni VALUES('po11',0,'aaa','mcE');
INSERT INTO Posizioni VALUES('po12',21,'bbb','mcF');
INSERT INTO Posizioni VALUES('po13',10,'ccc','mcF');
INSERT INTO Posizioni VALUES('po14',4,'ddd','mcF');
INSERT INTO Posizioni VALUES('po15',19,'eee','mcF');
INSERT INTO Posizioni VALUES('po16',14,'jjj','mcG');
INSERT INTO Posizioni VALUES('po17',2,'iii','mcG');
INSERT INTO Posizioni VALUES('po18',13,'fff','mcH');
INSERT INTO Posizioni VALUES('po19',1,'ggg','mcH');
INSERT INTO Posizioni VALUES('po20',18,'aaa','mcH');
INSERT INTO Posizioni VALUES('po21',2,'jjj','mcI');
INSERT INTO Posizioni VALUES('po22',5,'iii','mcI');
INSERT INTO Posizioni VALUES('po23',0,'eee','mcJ');
INSERT INTO Posizioni VALUES('po24',0,'aaa','mcJ');
INSERT INTO Posizioni VALUES('po25',3,'eee','mcK');
INSERT INTO Posizioni VALUES('po26',16,'aaa','mcK');
INSERT INTO Posizioni VALUES('po27',11,'bbb','mcK');
INSERT INTO Posizioni VALUES('po28',5,'ccc','mcL');

/*IL WHERE VA A FILTRARE SUI SINGOLI RECORD*/
/*Elenco delle merendine della scuola con codice 34 JOIN IMPLICITO ordinato per prezzo*/
SELECT Merende.NomeMerenda, Merende.Prezzo
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Scuole.codScuola = '34'
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
ORDER BY Merende.Prezzo; /*Ordina in ordine crescente*/			
/*ORDER BY Merende.Prezzo DESC;			per ordinare in ordine decrescente aggiungo DESC alla fine*/

/*Elenco con nome della merenda, tipo della macchinetta, quantità merendine e nome della scuola in cui si trova la macchinetta; elencare solo le macchinette che hanno
  almeno una merendina; l'elenco deve essere ordinato alfabeticamente per nome scuola e in subordine per numero di merendine decrescente presenti nelle macchinette*/
SELECT Merende.NomeMerenda, Macchinette.TipoMacchinetta, Posizioni.QtaMerendine, Scuole.NomeScuola
FROM Merende, Macchinette, Posizioni, Scuole
WHERE Posizioni.QtaMerendine > 0
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
ORDER BY Scuole.NomeScuola ASC, Posizioni.QtaMerendine DESC;

/*Elenco con i nomi delle scuole e numero delle macchinette presenti*/
SELECT Scuole.NomeScuola, COUNT(Scuole.NomeScuola) AS Conta
FROM Scuole, Macchinette
WHERE Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Scuole.NomeScuola
ORDER BY Scuole.NomeScuola;

/*Prezzo medi delle macchinette della scuola 12*/
SELECT Macchinette.CodMacchinetta, AVG(Merende.Prezzo) AS Media
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Scuole.codScuola = '12'
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Macchinette.CodMacchinetta;

/*Elenco delle macchinette che hanno almeno una merendina di quantità 0*/
SELECT Macchinette.CodMacchinetta, Macchinette.CodScuola
FROM Posizioni, Macchinette
WHERE Posizioni.QtaMerendine = 0
AND Macchinette.CodMacchinetta = Posizioni.CodMacchinetta
GROUP BY Macchinette.codMacchinetta;

/*Analoga alla query precedente con il modificatore DISTINCT*/
SELECT DISTINCT Macchinette.CodMacchinetta, Macchinette.CodScuola
FROM Posizioni, Macchinette
WHERE Posizioni.QtaMerendine = 0
AND Macchinette.CodMacchinetta = Posizioni.CodMacchinetta
GROUP BY Macchinette.codMacchinetta;

/*Elenco delle macchinette che non hanno più merendine*/
SELECT Macchinette.CodMacchinetta, Macchinette.CodScuola, SUM(Posizioni.QtaMerendine) AS TotMerendine
FROM Posizioni, Macchinette
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta 
GROUP BY Macchinette.CodMacchinetta
HAVING  TotMerendine = 0;

/*Elenco dei tipi di macchinetta con il numero totale di merendine in esse caricato; escludere dall’elenco i tipi di macchinetta con meno di 40 merendine*/
SELECT Macchinette.TipoMacchinetta, SUM(Posizioni.QtaMerendine) AS totMerendine 
FROM Posizioni, Macchinette
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta
GROUP BY Macchinette.TipoMacchinetta
HAVING  totMerendine >= 40;

/*Totale dei pezzi di tutte le merendine per ogni macchinetta in ogni scuola*/
SELECT Macchinette.TipoMacchinetta, SUM(Posizioni.QtaMerendine) AS totMerendine, Scuole.NomeScuola 
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta
AND Merende.codMerenda = Posizioni.codMerenda
AND Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Macchinette.TipoMacchinetta;			    

-- ###############################################################################################################################
-- ComandiSQL_x_db_palestra_QL --

/* Interrogazioni al DB Palestra */

/* Elenco dei dati degli istruttori */
Select *
From istruttori;

/* Dati completi di tutti gli istruttori che si chiamano "Barbara" */
Select *
From istruttori
Where istruttori.nome='Barbara';

/* Cognome e telefono di tutti gli istruttori che si chiamano "Barbara" */
/* QUESTA E' UNA PROIEZIONE */
Select istruttori.cognome, istruttori.tel
From istruttori
Where istruttori.nome='Barbara';

/* Numero di posti del corso di pesi */
Select corsi.num_posti
From corsi
Where corsi.descrizione='pesi';

/* Elenco iscritti (nome e cognome) al corso aerobica con inner join */
Select clienti.nome,clienti.cognome, corsi.num_posti
From clienti
Inner join clienti_corsi On clienti.pk_cliente=clienti_corsi.fk_cliente
Inner join corsi On corsi.pk_corso=clienti_corsi.fk_corso
Where corsi.descrizione='aerobica';

/* Elenco iscritti (nome e cognome) al corso di aerobica con join implicito*/
Select clienti.nome,clienti.cognome
From clienti, clienti_corsi,corsi
Where (corsi.descrizione='aerobica'
OR corsi.descrizione='pesi')
AND clienti.pk_cliente=clienti_corsi.fk_cliente
AND corsi.pk_corso=clienti_corsi.fk_corso;

/* Elenco dei dati degli istruttori */
Select *
From istruttori
ORDER BY istruttori.cognome, istruttori.nome;

-- ###############################################################################################################################			    
-- 5C_Palestra --

CREATE DATABASE 5C_Palestra;
USE 5C_PALESTRA;

CREATE TABLE `Specializzazioni`(
	`pk_specializzazione` INT(11) NULL,
	`descrizione` VARCHAR(50) NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

CREATE TABLE `Istruttori_specializzazioni`(
	`fk_istruttore` INT(11) NULL,
	`fk_specializzazione` INT(11) NULL;
);

CREATE TABLE `Istruttori`(
	`pk_istruttore` INT(11) NULL,
	`nome` VARCHAR(50) NULL,
	`cognome` VARCHAR(50) NULL,
	`tel` VARCHAR(20) NULL;
	PRIMARY KEY(`pk_istruttore`);
);

CREATE TABLE `Istruttori_corsi`(
	`fk_istruttore` INT(11) NULL,
	`fk_corso` INT(11) NULL;
);

CREATE TABLE `Corsi`(
	`pk_corso` INT(11) NULL,
	`descrizione` VARCHAR(50) NULL,
	`num_posti` INT(11) NULL,
	`anno` YEAR NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

CREATE TABLE `Orari`(
	`giorno_settimana` VARCHAR(9) NULL,
	`ora_inizio` TIME NULL,
	`ora_fine` TIME NULL,
	`fk_corso` INT(11) NULL;
	PRIMARY KEY(`fk_corso`);
);

CREATE TABLE `Clienti_corsi`(
	`fk_cliente` INT(11) NULL,
	`fk_corso` INT(11) NULL;
	PRIMARY KEY(`pk_corso`);
);

CREATE TABLE `Certificati`(
	`pk_certificato` INT(11) NULL,
	`data_certificato` DATE NULL,
	`fk_cliente` INT(11)
	PRIMARY KEY(`fk_cliente`);
);

CREATE TABLE `Clienti`(
	`pk_cliente` INT(11) NULL,
	`nome` VARCHAR(50) NULL,
	`cognome` VARCHAR(50) NULL,
	`tel` VARCHAR(20) NULL,
	`email` VARCHAR(20) NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

ALTER TABLE `istruttori_specializzazioni`
    ADD KEY `fk_specializzazione` (`pk_specializzazione`),
    ADD KEY `fk_istruttore` (`pk_istruttore`),
	ADD PRIMARY KEY(`fk_specializzazione`);

ALTER TABLE `istruttori_corsi`
    ADD KEY `fk_corso` (`pk_corso`),
    ADD KEY `fk_istruttore` (`pk_istruttore`),
	ADD PRIMARY KEY(`fk_corso`);

ALTER TABLE `clienti_corsi`
    ADD KEY `fk_cliente` (`pk_corso`),
    ADD KEY `fk_corso` (`pk_corso`),
	ADD PRIMARY KEY(`fk_corso`);

-- ###############################################################################################################################			    
-- esercizio_Filiale_Audisio --
-- Una banca deve gestire i dati relativi alle filiali. Per ogni filiale si devono registrare i seguenti dati:
-- codice, nome, città e patrimonio totale in euro. Ogni filiale gestisce un certo insieme di conticorrenti. Ogni conto corrente è descritto dal numero del conto e dal suo 
-- saldo in euro (positivo onegativo). Ogni conto corrente può avere uno o più intestatari (clienti), ognuno dei quali può essereintestatario di più di un conto, anche in
-- filiali diverse. Per ogni cliente si registrano i seguenti dati:codice fiscale, nominativo, indirizzo, città e numero di telefono. Ogni filiale, inoltre, concede 
-- dei prestiti ai clienti (un prestito, come un conto corrente, può essere intestato a più di un cliente): unprestito è descritto da un codice identificativo, dal codice
-- del cliente a cui è stato concesso, dal suoammontare in euro, dal codice dell’ufficio che lo ha concesso, dalla matricola dell’impiegato che loha stipulato, dalla data 
-- di apertura e dalla data entro il quale dovrà essere estinto.Impostare:
-- •Schema E/R (comprensivo di cardinalità)
-- •Schema logico•Schema fisico
-- •DDL
-- •DML Interrogazioni:
-- 1.Visualizzare, per ogni prestito, il valore del prestito ed i dati identificativi dei clienti che lohanno stipulato (ordinato per cognome del cliente);
-- 2.visualizzare l’elenco di tutti i clienti che hanno almeno un deposito ed un prestito;
-- 3.visualizzare l’elenco di tutti i clienti titolari di almeno un deposito, ma non di un prestito;
-- 4.visualizzare, per ogni filiale, il numero dei titolari di conti;
-- 5.visualizzare per ogni filiale ed saldo medio dei conti depositati;
-- 6.visualizzare l’elenco di tutti i clienti che hanno un deposito presso tutte le filiali di Torino;
-- 7.visualizzare il saldo medio dei clienti che vivono a Novara ed hanno almeno due depositi;
-- 8.Visualizzare il numero dei titolari di deposito per ogni filiale, dove il saldo medio deidepositi sia superiore a 6.500 euro;
-- 9.Elenco dei clienti che hanno un deposito presso la filiale “agenzia2” di Cuneo;10.Elenco dei clienti che hanno più di 3 conti correnti intestati.
			    
CREATE DATABASE 5C_Filiale;
USE 5C_Filiale;

-- CREAZIONE TABELLA CLIENTE --
CREATE TABLE IF NOT EXISTS Cliente(
    cfCliente VARCHAR(16) NOT NULL,
    nominativoCliente VARCHAR(20) NULL,
    telefonoCliente VARCHAR(10) NULL,
    cittaCliente VARCHAR(20) NULL,
    indirizzoCliente VARCHAR(30) NULL,
    PRIMARY KEY(cfCliente)
);

-- CREAZIONE TABELLA CONTRO CORRENTE --
CREATE TABLE IF NOT EXISTS ContoCorrente(
    numeroConto INT NOT NULL,
    saldoConto  INT NULL,
    codiceFiliale VARCHAR(20) NOT NULL,
    PRIMARY KEY(numeroConto)    
);

-- CREAZIONE TABELLA FILIALE --
CREATE TABLE IF NOT EXISTS Filiale(
    codiceFiliale VARCHAR(20) NOT NULL,
    nomeFil VARCHAR(10) NULL,
    cittaFil VARCHAR(20) NULL,
    PRIMARY KEY(codiceFiliale)
);

-- CREAZIONE TABELLA PRESTITO--
CREATE TABLE IF NOT EXISTS Prestito(
    cIdentificativoPrestito VARCHAR(20) NOT NULL,
    ammontarePrestito INT NULL,
    matricolaPrestito VARCHAR(10) NULL,
    dataApertura VARCHAR(10) NULL,
    dataEstinzione VARCHAR(10) NULL,
    codiceFiliale VARCHAR(20) NOT NULL,
    PRIMARY KEY(cIdentificativoPrestito)
);

-- CREAZIONE TABELLA POSSIEDE (COLLEGAMENTO TRA CONTROCORRENTE E CLIENTE)--
CREATE TABLE IF NOT EXISTS Possiede(
    numeroConto INT NOT NULL,
    cfCliente VARCHAR(16) NOT NULL,        
    PRIMARY KEY(numeroConto,cfCliente)       
);

-- CREAZIONE TABELLA RICHIEDE (COLLEGAMENTO TRA PRESTITO E CLIENTE)--
CREATE TABLE IF NOT EXISTS Richiede(
    cIdentificativoPrestito VARCHAR(20) NOT NULL,
    cfCliente VARCHAR(16) NOT NULL,        
    PRIMARY KEY(cIdentificativoPrestito,cfCliente)       
);

ALTER TABLE ContoCorrente ADD FOREIGN KEY (codiceFiliale) REFERENCES  Filiale (codiceFiliale);
ALTER TABLE Prestito ADD FOREIGN KEY (codiceFiliale) REFERENCES  Filiale (codiceFiliale);
ALTER TABLE Possiede ADD FOREIGN KEY (numeroonto) REFERENCES  ContoCorrente (numeroConto);
ALTER TABLE Possiede ADD FOREIGN KEY (cfCliente) REFERENCES  Cliente (cfCliente);
ALTER TABLE Richiede ADD FOREIGN KEY (cIdentificativoPrestito) REFERENCES  Prestito (cIdentificativoPrestito);
ALTER TABLE Richiede ADD FOREIGN KEY (cfCliente) REFERENCES  Cliente (cfCliente);

USE 5C_Filiale;

INSERT INTO Cliente(cfCliente,nominativoCliente,telefonoCliente,cittaCliente,indirizzoCliente) VALUES 
    ('CNIFZH65L71B405','Rossi','7456913289','Novara','via Saluzzo 21'),
    ('BCWVCV56L68B165','Russo','1463289103','Novara','Corso Roma 7'),
    ('ZVPLTJ59P30D072','Ferrari','3485712960','Torino','Via Marco Polo 1'),
    ('NBDTZH38D04F667','Bianchi','9645871245','Torino','Piazza Torino 3'),
    ('LKFPJB50P59L230','Colombo','9317562487','Cuneo','Corso Roma 25');

INSERT INTO Filiale(codiceFiliale,nomeFil,cittaFil) VALUES
    ('Fil01','FTorino','Torino'),
    ('Fil02','FNovara','Novara'),
    ('Fil03','Agenzia2','Cuneo'),
    ('Fil04','FAsti','Asti'),
    ('Fil05','FGenova','Genova'); 

INSERT INTO ContoCorrente(numeroConto,saldoConto,codiceFiliale) VALUES
    (01,2500,'Fil01'),
    (02,7100,'Fil02'),
    (03,9400,'Fil03'),
    (10,6500,'Fil04'),
    (50,1000,'Fil05');  
   
INSERT INTO Prestito(cIdentificativoPrestito,ammontarePrestito,matricolaPrestito,dataApertura,dataEstinzione,codiceFiliale) VALUES
    ('Prest01',1000,'lmp01','02/02/2020','02/02/2024','Fil01'),
    ('Prest02',1000,'lmp02','08/04/2019','08/04/2023','Fil02'),
    ('Prest03',1000,'lmp03','11/08/2018','11/08/2022','Fil03'),
    ('Prest04',1000,'lmp04','09/02/2020','09/02/2024','Fil04'),
    ('Prest05',1000,'lmp05','02/12/2019','02/12/2023','Fil05');
    
INSERT INTO Possiede(numeroConto,cfCliente) VALUES
    (01,'CNIFZH65L71B405'),
    (02,'BCWVCV56L68B165'),
    (03,'ZVPLTJ59P30D072'),
    (10,'NBDTZH38D04F667'),
    (50,'LKFPJB50P59L230');   
    
INSERT INTO Richiede(cIdentificativoPrestito,cfCliente) VALUES
    ('Prest01','CNIFZH65L71B405'),
    ('Prest02','BCWVCV56L68B165'),
    ('Prest03','ZVPLTJ59P30D072'),
    ('Prest04','NBDTZH38D04F667'),
    ('Prest05','LKFPJB50P59L230');    

    USE 5C_Filiale;
    
    /*Visualizzare, per ogni prestito, il valore del prestito ed i dati identificativi dei clienti che lo hanno stipulato (ordinato per cognome del cliente)*/
    SELECT Cliente.cfCliente, Cliente.nominativoCliente, Prestito.cIdentificativoPrestito
    FROM Prestito, Cliente, Richiede
    WHERE Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare l’elenco di tutti i clienti che hanno almeno un deposito ed un prestito*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
    WHERE Cliente.cfCliente = Richiede.cfCliente
    AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    AND Cliente.cfCliente = Possiede.cfCliente
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare l’elenco di tutti i clienti titolari di almeno un deposito, ma non di un prestito*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
    WHERE Cliente.cfCliente = Richiede.cfCliente
    AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare, per ogni filiale, il numero dei titolari di conti*/
    SELECT COUNT(Cliente.nominativoCliente) as nTitolari, Filiale.nomeFil
    FROM Filiale, Cliente, ContoCorrente, Possiede
    WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND ContoCorrente.numeroConto = Possiede.numeroConto
    AND Possiede.cfCliente = Cliente.cfCliente
    GROUP BY Filiale.nomeFil;
    
    /*visualizzare per ogni filiale ed saldo medio dei conti depositati*/
    SELECT Filiale.nomeFil, AVG(ContoCorrente.numeroConto) as nConti
    FROM Filiale, ContoCorrente
    WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    GROUP BY ContoCorrente.numeroConto;
    
    /*visualizzare l’elenco di tutti i clienti che hanno un deposito presso tutte le filiali di Torino*/
    SELECT Cliente.nominativoCliente
    FROM Filiale, Cliente, ContoCorrente, Possiede
    WHERE Filiale.cittaFil = 'Torino'
    AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND ContoCorrente.numeroConto = Possiede.numeroConto
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare il saldo medio dei clienti che vivono a Novara ed hanno almeno due depositi*/
    SELECT Filiale.nomeFil, AVG(ContoCorrente.saldoConto)
    FROM Filiale, ContoCorrente, Possiede
    WHERE Filiale.codiceFiliale = .ContoCorrente.codiceFiliale
    AND Possiede.cfCliente = Cliente.cfCliente
    AND Cliente.cittaCliente = 'Novara'
    AND COUNT(Possiede.cfCliente) > 1
    GROUP BY Filiale.codiceFiliale;
    
    /*Visualizzare il numero dei titolari di deposito per ogni filiale, dove il saldo medio dei depositi sia superiore a 6.500 euro*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Possiede, ContoCorrente
    WHERE Cliente.cfCliente = Possiede.cfCliente
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    AND ContoCorrente.saldoConto > 6500
    ORDER BY Cliente.nominativoCliente;
    
    /*Elenco dei clienti che hanno un deposito presso la filiale “agenzia2” di Cuneo*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Possiede, ContoCorrente,Filiale
    WHERE Filiale.nomeFil = 'Agenzia2'
    AND Filiale.cittaFil = 'Cuneo'
    AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    AND Cliente.cfCliente = Possiede.cfCliente
    ORDER BY Cliente.nominativoCliente;
    
    /*Elenco dei clienti che hanno più di 3 conti correnti intestati*/
    SELECT Filiale.nomeFil, Cliente.nominativoCliente
    FROM Cliente, Richiede, Possiede
    WHERE Cliente.cfCliente = Possiede.cfCliente
    AND Cliente.cfCliente = Richiede.cfCliente
    AND COUNT(Possiede.cfCliente) > 3
    GROUP BY Cliente.cfCliente;
