CREATE TABLE parchi_audisio;
USE parchi_audisio;

-- CREAZIONE TABELLA PARCHI --
CREATE TABLE IF NOT EXISTS Parchi(
  codiceParco VARCHAR(10) NOT NULL,
  nomeParco VARCHAR(100) NULL,
  codFiscaleGuardia VARCHAR(10) NOT NULL,
  PRIMARY KEY(codiceParco)
);

-- CREAZIONE TABELLA GUARDIAPARCO --
CREATE TABLE IF NOT EXISTS GuardiaParco(
  codFiscaleGuardia VARCHAR(10) NOT NULL,
  nomeGuardia VARCHAR(50) NULL,
  cognomeGuardia VARCHAR(50) NULL,
  anniGuardia INT NULL,
  sessoGuardia VARCHAR(10) NULL,
  mailGuardia VARCHAR(50) NULL,
  passwordGuardia VARCHAR(100) NULL,
  PRIMARY KEY(codFiscaleGuardia)
);

-- CREAZIONE TABELLA FAUNA --
CREATE TABLE IF NOT EXISTS Fauna(
  codiceFauna VARCHAR(10) NOT NULL,
  specie VARCHAR(100) NULL,
  eta VARCHAR(10) NULL,
  sesso VARCHAR(10) NULL,
  codiceOrdine VARCHAR(10) NOT NULL,
  PRIMARY KEY(codiceFauna)
);

-- CREAZIONE TABELLA ORDINE --
CREATE TABLE IF NOT EXISTS Ordine(
  codiceOrdine VARCHAR(10) NOT NULL,
  nomeOrdine VARCHAR(100) NULL,
  PRIMARY KEY(codiceOrdine)
);

-- CREAZIONE TABELLA FLORA --
CREATE TABLE IF NOT EXISTS Flora(
  codiceFlora VARCHAR(10) NOT NULL,
  nome VARCHAR(100) NULL,
  categoria VARCHAR(10) NULL,
  stagioneFioritura VARCHAR(100) NULL,
  PRIMARY KEY(codiceFlora)
);

-- CREAZIONE TABELLA VIVONO --
CREATE TABLE IF NOT EXISTS Vivono(
  codiceParco VARCHAR(10) NOT NULL,
  codiceFauna VARCHAR(10) NOT NULL,
  PRIMARY KEY(codiceParco,codiceFauna)
);

-- CREAZIONE TABELLA TROVANO --
CREATE TABLE IF NOT EXISTS Trovano(
  codiceParco VARCHAR(10) NOT NULL,
  codiceFlora VARCHAR(10) NOT NULL,
  PRIMARY KEY(codiceParco,codiceFlora)
);

ALTER TABLE Parchi ADD FOREIGN KEY (codFiscaleGuardia) REFERENCES GuardiaParco(codFiscaleGuardia);
ALTER TABLE Fauna ADD FOREIGN KEY (codiceOrdine) REFERENCES Ordine(codiceOrdine);
ALTER TABLE Vivono ADD FOREIGN KEY (codiceParco) REFERENCES Parchi(codiceParco);
ALTER TABLE Vivono ADD FOREIGN KEY (codiceFauna) REFERENCES Fauna(codiceFauna);
ALTER TABLE Trovano ADD FOREIGN KEY (codiceParco) REFERENCES Parchi(codiceParco);
ALTER TABLE Trovano ADD FOREIGN KEY (codiceFlora) REFERENCES Flora(codiceFlora);
