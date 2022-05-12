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
