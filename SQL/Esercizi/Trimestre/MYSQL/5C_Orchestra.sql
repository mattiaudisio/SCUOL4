-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Nov 11, 2019 alle 09:29
-- Versione del server: 10.1.37-MariaDB
-- Versione PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `5C_Orchestra`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Autori`
--

CREATE TABLE `Autori` (
  `CodiceAutori` tinyint(4) NOT NULL,
  `NomeAutori` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Concerti`
--

CREATE TABLE `Concerti` (
  `CodiceConcerti` tinyint(4) NOT NULL,
  `DescrizioneConcerti` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Direttori`
--

CREATE TABLE `Direttori` (
  `CodiceDirettore` tinyint(4) NOT NULL,
  `CognomeDirettore` varchar(10) NOT NULL,
  `NomeDirettore` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Eseguito`
--

CREATE TABLE `Eseguito` (
  `CodiceConcerti` tinyint(4) NOT NULL,
  `NomeOrchestra` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Formato`
--

CREATE TABLE `Formato` (
  `NomeOrchestra` varchar(20) NOT NULL,
  `MatricolaOrchestrali` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Orchestrali`
--

CREATE TABLE `Orchestrali` (
  `MatricolaOrchestrali` int(10) NOT NULL,
  `NomeOrchestrali` varchar(8) NOT NULL,
  `CognomeOrchestrali` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Orchestre`
--

CREATE TABLE `Orchestre` (
  `NomeOrchestra` varchar(20) NOT NULL,
  `CodiceDirettore` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `PezziMusicali`
--

CREATE TABLE `PezziMusicali` (
  `CodicePezziMusicali` smallint(4) NOT NULL,
  `Titolo` varchar(10) NOT NULL,
  `CodiceConcerti` smallint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Scala`
--

CREATE TABLE `Scala` (
  `CodiceScala` tinyint(4) NOT NULL,
  `NomeScala` varchar(20) NOT NULL,
  `CapienzaScala` smallint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Scritto`
--

CREATE TABLE `Scritto` (
  `CodicePezziMusicali` smallint(4) NOT NULL,
  `CodiceAutori` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Strumento`
--

CREATE TABLE `Strumento` (
  `NomeStrumento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Suona`
--

CREATE TABLE `Suona` (
  `MatricolaOrchestrali` int(10) NOT NULL,
  `NomeStrumento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Tenuto`
--

CREATE TABLE `Tenuto` (
  `CodiceScala` tinyint(4) NOT NULL,
  `CodiceConcerti` tinyint(4) NOT NULL,
  `Data` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Autori`
--
ALTER TABLE `Autori`
  ADD PRIMARY KEY (`CodiceAutori`);

--
-- Indici per le tabelle `Concerti`
--
ALTER TABLE `Concerti`
  ADD PRIMARY KEY (`CodiceConcerti`);

--
-- Indici per le tabelle `Direttori`
--
ALTER TABLE `Direttori`
  ADD PRIMARY KEY (`CodiceDirettore`);

--
-- Indici per le tabelle `Eseguito`
--
ALTER TABLE `Eseguito`
  ADD PRIMARY KEY (`CodiceConcerti`,`NomeOrchestra`),
  ADD KEY `NomeOrchestra` (`NomeOrchestra`);

--
-- Indici per le tabelle `Formato`
--
ALTER TABLE `Formato`
  ADD PRIMARY KEY (`NomeOrchestra`,`MatricolaOrchestrali`),
  ADD KEY `MatricolaOrchestrali` (`MatricolaOrchestrali`),
  ADD KEY `NomeOrchestra` (`NomeOrchestra`);

--
-- Indici per le tabelle `Orchestrali`
--
ALTER TABLE `Orchestrali`
  ADD PRIMARY KEY (`MatricolaOrchestrali`);

--
-- Indici per le tabelle `Orchestre`
--
ALTER TABLE `Orchestre`
  ADD PRIMARY KEY (`NomeOrchestra`),
  ADD UNIQUE KEY `CodiceDirettore` (`CodiceDirettore`);

--
-- Indici per le tabelle `PezziMusicali`
--
ALTER TABLE `PezziMusicali`
  ADD PRIMARY KEY (`CodicePezziMusicali`),
  ADD UNIQUE KEY `CodiceConcerti` (`CodiceConcerti`);

--
-- Indici per le tabelle `Scala`
--
ALTER TABLE `Scala`
  ADD PRIMARY KEY (`CodiceScala`);

--
-- Indici per le tabelle `Scritto`
--
ALTER TABLE `Scritto`
  ADD PRIMARY KEY (`CodicePezziMusicali`,`CodiceAutori`),
  ADD KEY `CodiceAUtori` (`CodiceAutori`);

--
-- Indici per le tabelle `Strumento`
--
ALTER TABLE `Strumento`
  ADD PRIMARY KEY (`NomeStrumento`);

--
-- Indici per le tabelle `Suona`
--
ALTER TABLE `Suona`
  ADD PRIMARY KEY (`MatricolaOrchestrali`,`NomeStrumento`),
  ADD KEY `NomeStrumento` (`NomeStrumento`);

--
-- Indici per le tabelle `Tenuto`
--
ALTER TABLE `Tenuto`
  ADD PRIMARY KEY (`CodiceScala`,`CodiceConcerti`),
  ADD KEY `CodiceConcerti` (`CodiceConcerti`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Concerti`
--
ALTER TABLE `Concerti`
  ADD CONSTRAINT `Concerti_ibfk_1` FOREIGN KEY (`CodiceConcerti`) REFERENCES `Eseguito` (`CodiceConcerti`);

--
-- Limiti per la tabella `Eseguito`
--
ALTER TABLE `Eseguito`
  ADD CONSTRAINT `NomeOrchestra` FOREIGN KEY (`NomeOrchestra`) REFERENCES `Orchestre` (`NomeOrchestra`);

--
-- Limiti per la tabella `Formato`
--
ALTER TABLE `Formato`
  ADD CONSTRAINT `MatricolaOrchestrali` FOREIGN KEY (`MatricolaOrchestrali`) REFERENCES `Orchestrali` (`MatricolaOrchestrali`);

--
-- Limiti per la tabella `Orchestre`
--
ALTER TABLE `Orchestre`
  ADD CONSTRAINT ` 	CodiceDirettore` FOREIGN KEY (`CodiceDirettore`) REFERENCES `Direttori` (`CodiceDirettore`);

--
-- Limiti per la tabella `Scritto`
--
ALTER TABLE `Scritto`
  ADD CONSTRAINT `CodiceAUtori` FOREIGN KEY (`CodiceAutori`) REFERENCES `Autori` (`CodiceAutori`),
  ADD CONSTRAINT `CodicePezziMusicali` FOREIGN KEY (`CodicePezziMusicali`) REFERENCES `PezziMusicali` (`CodicePezziMusicali`);

--
-- Limiti per la tabella `Suona`
--
ALTER TABLE `Suona`
  ADD CONSTRAINT `NomeStrumento` FOREIGN KEY (`NomeStrumento`) REFERENCES `Strumento` (`NomeStrumento`),
  ADD CONSTRAINT `Suona_ibfk_1` FOREIGN KEY (`MatricolaOrchestrali`) REFERENCES `Orchestrali` (`MatricolaOrchestrali`);

--
-- Limiti per la tabella `Tenuto`
--
ALTER TABLE `Tenuto`
  ADD CONSTRAINT `CodiceConcerti` FOREIGN KEY (`CodiceConcerti`) REFERENCES `Concerti` (`CodiceConcerti`),
  ADD CONSTRAINT `CodiceScala` FOREIGN KEY (`CodiceScala`) REFERENCES `Scala` (`CodiceScala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
