/*Creazione del database*/
create database 5C_db_palestra;

USE 5C_db_palestra;

/*Creazione della tabella specializzazioni*/
create table specializzazioni(pk_specializzazione int auto_increment, descrizione varchar(50), primary key(pk_specializzazione)) engine=innodb;

/*Creazione della tabella istruttori*/
create table istruttori(pk_istruttore int auto_increment, nome varchar(50) not null, cognome varchar(50) not null, tel varchar(20), primary key(pk_istruttore)) engine=innodb;

/*Creazione della tabella istruttori_specializzazioni*/
create table istruttori_specializzazioni(fk_istruttore int, fk_specializzazione int, primary key(fk_istruttore,fk_specializzazione), foreign key(fk_istruttore) references istruttori(pk_istruttore), foreign key(fk_specializzazione) references specializzazioni(pk_specializzazione)) engine=innodb;

/*Creazione della tabella corsi*/
create table corsi(pk_corso int auto_increment, descrizione varchar(50) not null,num_posti int,anno year(4), primary key(pk_corso)) engine=innodb;

/*Creazione della tabella istruttori_corsi*/
create table istruttori_corsi(fk_istruttore int, fk_corso int, primary key(fk_istruttore,fk_corso), foreign key(fk_istruttore) references istruttori(pk_istruttore), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;

/*Creazione della tabella clienti*/
create table clienti(pk_cliente int auto_increment, nome varchar(50) not null, cognome varchar(50) not null, tel varchar(20), email varchar(40), primary key(pk_cliente)) engine=innodb;

/*Creazione della tabella clienti_corsi*/
create table clienti_corsi(fk_cliente int, fk_corso int, primary key(fk_cliente, fk_corso), foreign key(fk_cliente) references clienti(pk_cliente), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;

/*Creazione della tabella certificati*/
create table certificati(pk_certificato int auto_increment, data_certificato date not null, fk_cliente int, primary key(pk_certificato), foreign key(fk_cliente) references clienti(pk_cliente)) engine=innodb;

/*Creazione della tabella orari*/
create table orari(giorno_settimana varchar(10), ora_inizio time, ora_fine time, fk_corso int, primary key(giorno_settimana,ora_inizio,fk_corso), foreign key(fk_corso) references corsi(pk_corso)) engine=innodb;
