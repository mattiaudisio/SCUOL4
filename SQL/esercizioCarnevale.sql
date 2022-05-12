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
