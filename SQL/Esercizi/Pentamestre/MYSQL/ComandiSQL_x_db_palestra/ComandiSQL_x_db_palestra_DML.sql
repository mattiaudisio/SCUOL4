USE 5C_db_palestra;

/*Inserimento dei dati nelle tabelle*/

INSERT INTO specializzazioni (pk_specializzazione, descrizione) VALUES
	(1, 'aerobica'),
	(2, 'step'),
	(3, 'yoga'),
	(4, 'pesi'),
	(5, 'fitness');
	
INSERT INTO istruttori (pk_istruttore, nome, cognome, tel) VALUES
	(1, 'Francesco', 'Vaschetto', '34567898'),
	(2, 'Barbara', 'Demo', '333234433'),
	(3, 'Sophia', 'Danesino', '347868797'),
	(4, 'Barbara', 'Carando', '324756456'),
	(5, 'Luisa', 'Dal Paos', '345743456');
	
INSERT INTO istruttori_specializzazioni (fk_istruttore, fk_specializzazione) VALUES
	(3, 1),
	(4, 1),
	(1, 2),
	(5, 2),
	(1, 3),
	(2, 3),
	(3, 4),
	(5, 5);
	
INSERT INTO corsi (pk_corso, descrizione, num_posti, anno) VALUES
	(1, 'aerobica', 5, '2013'),
	(2, 'pesi', 6, '2013'),
	(3, 'step', 4, '2013'),
	(4, 'yogaA', 6, '2013'),
	(5, 'yogaB', 5, '2013');
	
INSERT INTO istruttori_corsi (fk_istruttore, fk_corso) VALUES
	(3, 1),
	(4, 1),
	(1, 2),
	(5, 2),
	(1, 3),
	(2, 3),
	(3, 4),
	(5, 5);

INSERT INTO clienti (pk_cliente, nome, cognome, tel, email) VALUES
	(1, 'Claudio', 'Borgogno', '333456789', 'claudio.borgogno@gmail.com'),
	(2, 'Flaviano', 'Monge', '334543213', 'flaviano.monge@libero.it'),
	(3, 'Maria Grazia', 'Maffucci', ' ', 'mgm.mgm@gmail.com'),
	(4, 'Paola', 'Longobardi', '', 'p_longobardi@yahoo.it'),
	(5, 'Marco', 'Bracco', '324987456', 'marco.bracco@hotmail.com'),
	(6, 'Jessica', 'Paschini', '344456456', 'jessica_p@libero.it'),
	(7, 'Nunzio', 'Ferrigno', '347898767', 'n_ferrigno@hotmail.com'),
	(8, 'Federico', 'Sarzotti', '324567234', 'sarzfed@yahoo.it');
	
INSERT INTO clienti_corsi (fk_cliente, fk_corso) VALUES
	(1, 1),
	(3, 1),
	(2, 2),
	(6, 2),
	(1, 3),
	(4, 3),
	(8, 3),
	(3, 4),
	(5, 4),
	(8, 4),
	(4, 5),
	(6, 5),
	(7, 5);
	
INSERT INTO certificati (pk_certificato, data_certificato, fk_cliente) VALUES
	(1, '2013-01-11', 6),
	(2, '2012-02-10', 1),
	(3, '2013-03-02', 4),
	(4, '2012-01-11', 3),
	(5, '2013-04-03', 2),
	(6, '2012-12-05', 8),
	(7, '2012-10-16', 7),
	(8, '2012-02-13', 5);
	
INSERT INTO orari (giorno_settimana, ora_inizio, ora_fine, fk_corso) VALUES
	('giovedi''', '18:00:00', '19:00:00', 2),
	('giovedi''', '19:00:00', '20:00:00', 5),
	('lunedi''', '15:00:00', '16:00:00', 1),
	('lunedi''', '18:00:00', '19:00:00', 3),
	('lunedi''', '19:00:00', '20:00:00', 3),
	('martedi''', '18:00:00', '19:00:00', 2),
	('martedi''', '19:00:00', '20:00:00', 5),
	('mercoledi''', '16:00:00', '17:00:00', 1),
	('mercoledi''', '18:00:00', '19:00:00', 2),
	('venerdi''', '20:00:00', '21:00:00', 4);

