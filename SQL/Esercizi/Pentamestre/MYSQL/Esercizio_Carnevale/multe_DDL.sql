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
