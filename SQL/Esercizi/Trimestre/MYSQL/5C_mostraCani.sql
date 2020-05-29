-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Nov 06, 2019 alle 13:18
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
-- Database: `5C_mostraCani`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `cani`
--

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

-- --------------------------------------------------------

--
-- Struttura della tabella `giudica`
--

CREATE TABLE `giudica` (
  `CodG` tinyint(4) NOT NULL,
  `CodC` varchar(4) NOT NULL,
  `Voto` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `giudici`
--

CREATE TABLE `giudici` (
  `codG` tinyint(4) NOT NULL,
  `NomeG` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `razze`
--

CREATE TABLE `razze` (
  `NomeR` varchar(20) NOT NULL,
  `AltR` tinyint(4) DEFAULT NULL,
  `PesoR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cani`
--
ALTER TABLE `cani`
  ADD PRIMARY KEY (`CodC`),
  ADD KEY `CollegamentoRazza` (`NomeR`);

--
-- Indici per le tabelle `giudica`
--
ALTER TABLE `giudica`
  ADD PRIMARY KEY (`CodG`,`CodC`),
  ADD KEY `CodC` (`CodC`);

--
-- Indici per le tabelle `giudici`
--
ALTER TABLE `giudici`
  ADD PRIMARY KEY (`codG`);

--
-- Indici per le tabelle `razze`
--
ALTER TABLE `razze`
  ADD PRIMARY KEY (`NomeR`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `giudici`
--
ALTER TABLE `giudici`
  MODIFY `codG` tinyint(4) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `cani`
--
ALTER TABLE `cani`
  ADD CONSTRAINT `CollegamentoRazza` FOREIGN KEY (`NomeR`) REFERENCES `razze` (`NomeR`);

--
-- Limiti per la tabella `giudica`
--
ALTER TABLE `giudica`
  ADD CONSTRAINT `giudica_ibfk_2` FOREIGN KEY (`CodC`) REFERENCES `cani` (`CodC`),
  ADD CONSTRAINT `giudica_ibfk_3` FOREIGN KEY (`CodG`) REFERENCES `giudici` (`codG`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
