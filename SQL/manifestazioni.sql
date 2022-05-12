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

ALTER TABLE `Fanno` ADD Key `NomeIstituto` (`NomeIstituto`),
    ADD Key `NomeManifestazione` (`NomeManifestazione`),
    PRIMARY KEY(`NomeIstituto`,`NomeManifestazione`);
