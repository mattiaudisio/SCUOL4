-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Nov 07, 2019 alle 21:00
-- Versione del server: 10.4.8-MariaDB
-- Versione PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `5C_Ristoranti`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Appartiene`
--

CREATE TABLE `Appartiene` (
  `NomeZona` varchar(30) NOT NULL,
  `IndirizzoRistorante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `CarteCredito`
--

CREATE TABLE `CarteCredito` (
  `NomeCarta` varchar(40) NOT NULL,
  `NumeroVerde` smallint(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Convenzionati`
--

CREATE TABLE `Convenzionati` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `NomeCarta` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Cucina`
--

CREATE TABLE `Cucina` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `Codice` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Raggiunge`
--

CREATE TABLE `Raggiunge` (
  `NomeZona` varchar(30) NOT NULL,
  `LineaTrasporti` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Ristorante`
--

CREATE TABLE `Ristorante` (
  `IndirizzoRistorante` varchar(50) NOT NULL,
  `NomeRistorante` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `TipiCucina`
--

CREATE TABLE `TipiCucina` (
  `Codice` tinyint(3) NOT NULL,
  `Descrizione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `TrasportiPlubbici`
--

CREATE TABLE `TrasportiPlubbici` (
  `LineaTrasporti` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ZonaCitta`
--

CREATE TABLE `ZonaCitta` (
  `NomeZona` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Appartiene`
--
ALTER TABLE `Appartiene`
  ADD PRIMARY KEY (`NomeZona`,`IndirizzoRistorante`),
  ADD KEY `IndirizzoRistorante` (`IndirizzoRistorante`);

--
-- Indici per le tabelle `CarteCredito`
--
ALTER TABLE `CarteCredito`
  ADD PRIMARY KEY (`NomeCarta`);

--
-- Indici per le tabelle `Convenzionati`
--
ALTER TABLE `Convenzionati`
  ADD PRIMARY KEY (`IndirizzoRistorante`,`NomeCarta`),
  ADD KEY `NomeCarta` (`NomeCarta`);

--
-- Indici per le tabelle `Cucina`
--
ALTER TABLE `Cucina`
  ADD PRIMARY KEY (`IndirizzoRistorante`,`Codice`);

--
-- Indici per le tabelle `Raggiunge`
--
ALTER TABLE `Raggiunge`
  ADD PRIMARY KEY (`NomeZona`,`LineaTrasporti`),
  ADD KEY `LineaTrasporti` (`LineaTrasporti`);

--
-- Indici per le tabelle `Ristorante`
--
ALTER TABLE `Ristorante`
  ADD PRIMARY KEY (`IndirizzoRistorante`);

--
-- Indici per le tabelle `TipiCucina`
--
ALTER TABLE `TipiCucina`
  ADD PRIMARY KEY (`Codice`);

--
-- Indici per le tabelle `TrasportiPlubbici`
--
ALTER TABLE `TrasportiPlubbici`
  ADD PRIMARY KEY (`LineaTrasporti`);

--
-- Indici per le tabelle `ZonaCitta`
--
ALTER TABLE `ZonaCitta`
  ADD PRIMARY KEY (`NomeZona`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Appartiene`
--
ALTER TABLE `Appartiene`
  ADD CONSTRAINT `IndirizzoRistorante` FOREIGN KEY (`IndirizzoRistorante`) REFERENCES `Ristorante` (`IndirizzoRistorante`),
  ADD CONSTRAINT `NomeZona` FOREIGN KEY (`NomeZona`) REFERENCES `ZonaCitta` (`NomeZona`);

--
-- Limiti per la tabella `Convenzionati`
--
ALTER TABLE `Convenzionati`
  ADD CONSTRAINT `NomeCarta` FOREIGN KEY (`NomeCarta`) REFERENCES `CarteCredito` (`NomeCarta`);

--
-- Limiti per la tabella `Raggiunge`
--
ALTER TABLE `Raggiunge`
  ADD CONSTRAINT `LineaTrasporti` FOREIGN KEY (`LineaTrasporti`) REFERENCES `TrasportiPlubbici` (`LineaTrasporti`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
