CREATE DATABASE 5C_Palestra;
USE 5C_PALESTRA;

CREATE TABLE `Specializzazioni`(
	`pk_specializzazione` INT(11) NULL,
	`descrizione` VARCHAR(50) NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

CREATE TABLE `Istruttori_specializzazioni`(
	`fk_istruttore` INT(11) NULL,
	`fk_specializzazione` INT(11) NULL;
);

CREATE TABLE `Istruttori`(
	`pk_istruttore` INT(11) NULL,
	`nome` VARCHAR(50) NULL,
	`cognome` VARCHAR(50) NULL,
	`tel` VARCHAR(20) NULL;
	PRIMARY KEY(`pk_istruttore`);
);

CREATE TABLE `Istruttori_corsi`(
	`fk_istruttore` INT(11) NULL,
	`fk_corso` INT(11) NULL;
);

CREATE TABLE `Corsi`(
	`pk_corso` INT(11) NULL,
	`descrizione` VARCHAR(50) NULL,
	`num_posti` INT(11) NULL,
	`anno` YEAR NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

CREATE TABLE `Orari`(
	`giorno_settimana` VARCHAR(9) NULL,
	`ora_inizio` TIME NULL,
	`ora_fine` TIME NULL,
	`fk_corso` INT(11) NULL;
	PRIMARY KEY(`fk_corso`);
);

CREATE TABLE `Clienti_corsi`(
	`fk_cliente` INT(11) NULL,
	`fk_corso` INT(11) NULL;
	PRIMARY KEY(`pk_corso`);
);

CREATE TABLE `Certificati`(
	`pk_certificato` INT(11) NULL,
	`data_certificato` DATE NULL,
	`fk_cliente` INT(11)
	PRIMARY KEY(`fk_cliente`);
);

CREATE TABLE `Clienti`(
	`pk_cliente` INT(11) NULL,
	`nome` VARCHAR(50) NULL,
	`cognome` VARCHAR(50) NULL,
	`tel` VARCHAR(20) NULL,
	`email` VARCHAR(20) NULL;
	PRIMARY KEY(`pk_specializzazione`);
);

ALTER TABLE `istruttori_specializzazioni`
    ADD KEY `fk_specializzazione` (`pk_specializzazione`),
    ADD KEY `fk_istruttore` (`pk_istruttore`),
	ADD PRIMARY KEY(`fk_specializzazione`);

ALTER TABLE `istruttori_corsi`
    ADD KEY `fk_corso` (`pk_corso`),
    ADD KEY `fk_istruttore` (`pk_istruttore`),
	ADD PRIMARY KEY(`fk_corso`);

ALTER TABLE `clienti_corsi`
    ADD KEY `fk_cliente` (`pk_corso`),
    ADD KEY `fk_corso` (`pk_corso`),
	ADD PRIMARY KEY(`fk_corso`);
