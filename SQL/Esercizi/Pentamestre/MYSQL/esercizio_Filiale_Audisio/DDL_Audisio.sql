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
