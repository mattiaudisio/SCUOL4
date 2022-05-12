-- esercizio_Filiale_Audisio --
-- Una banca deve gestire i dati relativi alle filiali. Per ogni filiale si devono registrare i seguenti dati:
-- codice, nome, città e patrimonio totale in euro. Ogni filiale gestisce un certo insieme di conticorrenti. Ogni conto corrente è descritto dal numero del conto e dal suo 
-- saldo in euro (positivo onegativo). Ogni conto corrente può avere uno o più intestatari (clienti), ognuno dei quali può essereintestatario di più di un conto, anche in
-- filiali diverse. Per ogni cliente si registrano i seguenti dati:codice fiscale, nominativo, indirizzo, città e numero di telefono. Ogni filiale, inoltre, concede 
-- dei prestiti ai clienti (un prestito, come un conto corrente, può essere intestato a più di un cliente): unprestito è descritto da un codice identificativo, dal codice
-- del cliente a cui è stato concesso, dal suoammontare in euro, dal codice dell’ufficio che lo ha concesso, dalla matricola dell’impiegato che loha stipulato, dalla data 
-- di apertura e dalla data entro il quale dovrà essere estinto.Impostare:
-- •Schema E/R (comprensivo di cardinalità)
-- •Schema logico•Schema fisico
-- •DDL
-- •DML Interrogazioni:
-- 1.Visualizzare, per ogni prestito, il valore del prestito ed i dati identificativi dei clienti che lohanno stipulato (ordinato per cognome del cliente);
-- 2.visualizzare l’elenco di tutti i clienti che hanno almeno un deposito ed un prestito;
-- 3.visualizzare l’elenco di tutti i clienti titolari di almeno un deposito, ma non di un prestito;
-- 4.visualizzare, per ogni filiale, il numero dei titolari di conti;
-- 5.visualizzare per ogni filiale ed saldo medio dei conti depositati;
-- 6.visualizzare l’elenco di tutti i clienti che hanno un deposito presso tutte le filiali di Torino;
-- 7.visualizzare il saldo medio dei clienti che vivono a Novara ed hanno almeno due depositi;
-- 8.Visualizzare il numero dei titolari di deposito per ogni filiale, dove il saldo medio deidepositi sia superiore a 6.500 euro;
-- 9.Elenco dei clienti che hanno un deposito presso la filiale “agenzia2” di Cuneo;10.Elenco dei clienti che hanno più di 3 conti correnti intestati.
			    
CREATE DATABASE 5C_Filiale;
USE 5C_Filiale;

-- CREAZIONE TABELLA CLIENTE --
CREATE TABLE IF NOT EXISTS Cliente(
    cfCliente VARCHAR(16) NOT NULL,
    nominativoCliente VARCHAR(20) NULL,
    telefonoCliente VARCHAR(10) NULL,
    cittaCliente VARCHAR(20) NULL,
    indirizzoCliente VARCHAR(30) NULL,
    PRIMARY KEY(cfCliente)
);

-- CREAZIONE TABELLA CONTRO CORRENTE --
CREATE TABLE IF NOT EXISTS ContoCorrente(
    numeroConto INT NOT NULL,
    saldoConto  INT NULL,
    codiceFiliale VARCHAR(20) NOT NULL,
    PRIMARY KEY(numeroConto)    
);

-- CREAZIONE TABELLA FILIALE --
CREATE TABLE IF NOT EXISTS Filiale(
    codiceFiliale VARCHAR(20) NOT NULL,
    nomeFil VARCHAR(10) NULL,
    cittaFil VARCHAR(20) NULL,
    PRIMARY KEY(codiceFiliale)
);

-- CREAZIONE TABELLA PRESTITO--
CREATE TABLE IF NOT EXISTS Prestito(
    cIdentificativoPrestito VARCHAR(20) NOT NULL,
    ammontarePrestito INT NULL,
    matricolaPrestito VARCHAR(10) NULL,
    dataApertura VARCHAR(10) NULL,
    dataEstinzione VARCHAR(10) NULL,
    codiceFiliale VARCHAR(20) NOT NULL,
    PRIMARY KEY(cIdentificativoPrestito)
);

-- CREAZIONE TABELLA POSSIEDE (COLLEGAMENTO TRA CONTROCORRENTE E CLIENTE)--
CREATE TABLE IF NOT EXISTS Possiede(
    numeroConto INT NOT NULL,
    cfCliente VARCHAR(16) NOT NULL,        
    PRIMARY KEY(numeroConto,cfCliente)       
);

-- CREAZIONE TABELLA RICHIEDE (COLLEGAMENTO TRA PRESTITO E CLIENTE)--
CREATE TABLE IF NOT EXISTS Richiede(
    cIdentificativoPrestito VARCHAR(20) NOT NULL,
    cfCliente VARCHAR(16) NOT NULL,        
    PRIMARY KEY(cIdentificativoPrestito,cfCliente)       
);

ALTER TABLE ContoCorrente ADD FOREIGN KEY (codiceFiliale) REFERENCES  Filiale (codiceFiliale);
ALTER TABLE Prestito ADD FOREIGN KEY (codiceFiliale) REFERENCES  Filiale (codiceFiliale);
ALTER TABLE Possiede ADD FOREIGN KEY (numeroonto) REFERENCES  ContoCorrente (numeroConto);
ALTER TABLE Possiede ADD FOREIGN KEY (cfCliente) REFERENCES  Cliente (cfCliente);
ALTER TABLE Richiede ADD FOREIGN KEY (cIdentificativoPrestito) REFERENCES  Prestito (cIdentificativoPrestito);
ALTER TABLE Richiede ADD FOREIGN KEY (cfCliente) REFERENCES  Cliente (cfCliente);

USE 5C_Filiale;

INSERT INTO Cliente(cfCliente,nominativoCliente,telefonoCliente,cittaCliente,indirizzoCliente) VALUES 
    ('CNIFZH65L71B405','Rossi','7456913289','Novara','via Saluzzo 21'),
    ('BCWVCV56L68B165','Russo','1463289103','Novara','Corso Roma 7'),
    ('ZVPLTJ59P30D072','Ferrari','3485712960','Torino','Via Marco Polo 1'),
    ('NBDTZH38D04F667','Bianchi','9645871245','Torino','Piazza Torino 3'),
    ('LKFPJB50P59L230','Colombo','9317562487','Cuneo','Corso Roma 25');

INSERT INTO Filiale(codiceFiliale,nomeFil,cittaFil) VALUES
    ('Fil01','FTorino','Torino'),
    ('Fil02','FNovara','Novara'),
    ('Fil03','Agenzia2','Cuneo'),
    ('Fil04','FAsti','Asti'),
    ('Fil05','FGenova','Genova'); 

INSERT INTO ContoCorrente(numeroConto,saldoConto,codiceFiliale) VALUES
    (01,2500,'Fil01'),
    (02,7100,'Fil02'),
    (03,9400,'Fil03'),
    (10,6500,'Fil04'),
    (50,1000,'Fil05');  
   
INSERT INTO Prestito(cIdentificativoPrestito,ammontarePrestito,matricolaPrestito,dataApertura,dataEstinzione,codiceFiliale) VALUES
    ('Prest01',1000,'lmp01','02/02/2020','02/02/2024','Fil01'),
    ('Prest02',1000,'lmp02','08/04/2019','08/04/2023','Fil02'),
    ('Prest03',1000,'lmp03','11/08/2018','11/08/2022','Fil03'),
    ('Prest04',1000,'lmp04','09/02/2020','09/02/2024','Fil04'),
    ('Prest05',1000,'lmp05','02/12/2019','02/12/2023','Fil05');
    
INSERT INTO Possiede(numeroConto,cfCliente) VALUES
    (01,'CNIFZH65L71B405'),
    (02,'BCWVCV56L68B165'),
    (03,'ZVPLTJ59P30D072'),
    (10,'NBDTZH38D04F667'),
    (50,'LKFPJB50P59L230');   
    
INSERT INTO Richiede(cIdentificativoPrestito,cfCliente) VALUES
    ('Prest01','CNIFZH65L71B405'),
    ('Prest02','BCWVCV56L68B165'),
    ('Prest03','ZVPLTJ59P30D072'),
    ('Prest04','NBDTZH38D04F667'),
    ('Prest05','LKFPJB50P59L230');    

    USE 5C_Filiale;
    
    /*Visualizzare, per ogni prestito, il valore del prestito ed i dati identificativi dei clienti che lo hanno stipulato (ordinato per cognome del cliente)*/
    SELECT Cliente.cfCliente, Cliente.nominativoCliente, Prestito.cIdentificativoPrestito
    FROM Prestito, Cliente, Richiede
    WHERE Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare l’elenco di tutti i clienti che hanno almeno un deposito ed un prestito*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
    WHERE Cliente.cfCliente = Richiede.cfCliente
    AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    AND Cliente.cfCliente = Possiede.cfCliente
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare l’elenco di tutti i clienti titolari di almeno un deposito, ma non di un prestito*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
    WHERE Cliente.cfCliente = Richiede.cfCliente
    AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare, per ogni filiale, il numero dei titolari di conti*/
    SELECT COUNT(Cliente.nominativoCliente) as nTitolari, Filiale.nomeFil
    FROM Filiale, Cliente, ContoCorrente, Possiede
    WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND ContoCorrente.numeroConto = Possiede.numeroConto
    AND Possiede.cfCliente = Cliente.cfCliente
    GROUP BY Filiale.nomeFil;
    
    /*visualizzare per ogni filiale ed saldo medio dei conti depositati*/
    SELECT Filiale.nomeFil, AVG(ContoCorrente.numeroConto) as nConti
    FROM Filiale, ContoCorrente
    WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    GROUP BY ContoCorrente.numeroConto;
    
    /*visualizzare l’elenco di tutti i clienti che hanno un deposito presso tutte le filiali di Torino*/
    SELECT Cliente.nominativoCliente
    FROM Filiale, Cliente, ContoCorrente, Possiede
    WHERE Filiale.cittaFil = 'Torino'
    AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND ContoCorrente.numeroConto = Possiede.numeroConto
    ORDER BY Cliente.nominativoCliente;
    
    /*visualizzare il saldo medio dei clienti che vivono a Novara ed hanno almeno due depositi*/
    SELECT Filiale.nomeFil, AVG(ContoCorrente.saldoConto)
    FROM Filiale, ContoCorrente, Possiede
    WHERE Filiale.codiceFiliale = .ContoCorrente.codiceFiliale
    AND Possiede.cfCliente = Cliente.cfCliente
    AND Cliente.cittaCliente = 'Novara'
    AND COUNT(Possiede.cfCliente) > 1
    GROUP BY Filiale.codiceFiliale;
    
    /*Visualizzare il numero dei titolari di deposito per ogni filiale, dove il saldo medio dei depositi sia superiore a 6.500 euro*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Possiede, ContoCorrente
    WHERE Cliente.cfCliente = Possiede.cfCliente
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    AND ContoCorrente.saldoConto > 6500
    ORDER BY Cliente.nominativoCliente;
    
    /*Elenco dei clienti che hanno un deposito presso la filiale “agenzia2” di Cuneo*/
    SELECT Cliente.nominativoCliente
    FROM Cliente, Possiede, ContoCorrente,Filiale
    WHERE Filiale.nomeFil = 'Agenzia2'
    AND Filiale.cittaFil = 'Cuneo'
    AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
    AND Possiede.numeroConto = ContoCorrente.numeroConto
    AND Cliente.cfCliente = Possiede.cfCliente
    ORDER BY Cliente.nominativoCliente;
    
    /*Elenco dei clienti che hanno più di 3 conti correnti intestati*/
    SELECT Filiale.nomeFil, Cliente.nominativoCliente
    FROM Cliente, Richiede, Possiede
    WHERE Cliente.cfCliente = Possiede.cfCliente
    AND Cliente.cfCliente = Richiede.cfCliente
    AND COUNT(Possiede.cfCliente) > 3
    GROUP BY Cliente.cfCliente;
