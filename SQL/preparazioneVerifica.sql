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
