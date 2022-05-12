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
