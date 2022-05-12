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
