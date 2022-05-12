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
