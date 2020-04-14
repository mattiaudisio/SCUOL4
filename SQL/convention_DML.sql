USE 5C_Convention;

INSERT INTO Piano(idPiano,nPiano,nSale) VALUES
	('Piano1', 10, 1),
	('Piano2', 5, 2),
	('Piano3', 6, 3);

INSERT INTO Sala(idSala, nPostiSala, idPiano) VALUES
	('Sala1','50','Piano1'),
	('Sala2','100','Piano2'),
	('Sala3','50','Piano3'),
	('Sala4','60','Piano2'),
	('Sala5','40','Piano1'),
	('Sala6','150','Piano3');

INSERT INTO Azienda(idAzienda, indirizzoAzienda, telefonoAzienda) VALUES
	('Intel','Via Azienda 1','0175125831'),
	('NVIDIA','Via Azienda 2','0175125832'),
	('Dell','Via Azienda 3','0175125833'),
	('Facebook','Via Azienda 4','0175125834'),
	('Valve','Via Azienda 5','0175125835'),
	('Realtek','Via Azienda 6','0175125836'),
	('Apple','Via Azienda 7','0175125837');

INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	('01','Rossi','Marco','par1@gmail.com','Studente'),
	('02','Bianchi','Matteo','par2@gmail.com','Docente'),
	('03','Verdi','Luca','par3@gmail.com','Libero Professionista'),
	('04','Gialli','Mattia','par4@gmail.com','Studente'),
	('05','Viola','Francesco','par5@gmail.com','Docente'),
	('06','Verde','Nicola','par6@gmail.com','Docente'),
	('07','Rossi','Stefano','par7@gmail.com','Libero Professionista'),
	('08','Rossi','Andrea','par8@gmail.com','Libero Professionista'),
	('09','Longo','Lucio','par9@gmail.com','Docente');

INSERT INTO Speech(idSpeech, titolo, argomento, Durata) VALUES
	('Speech1','Manjaro','Rilasciato Manjaro 19.0 Kyria', 1234),
	('Speech2','Kernel','Nuova gestione dei processi', 4321),
	('Speech3','Raspberry','Raspberry Pi 4', 23234),
	('Speech4','Java','Nuova release jdk', 23432),
	('Speech5','Gnome','Rilasciato Gnome 3.36', 29873);

INSERT INTO Programma(idProgramma, fasciaOraria, idSpeech, idSala) VALUES
	('Programma1','10.00 - 11.00','Speech1','Sala1'),
	('Programma2','11.00 - 12.00','Speech2','Sala2'),
	('Programma3','13.00 - 14.00','Speech3','Sala3'),
	('Programma4','13.00 - 14.00','Speech4','Sala4'),
	('Programma5','11.00 - 12.00','Speech5','Sala5');

INSERT INTO Relatore(idRel, cognomeRel, nomeRel, idAzienda) VALUES
	('Relatore1','Rossi','Marco','Intel'),
	('Relatore2','Otta','Luca','NVIDIA'),
	('Relatore3','Verdi','Andrea','Dell'),
	('Relatore4','Musso','Mattia','Facebook'),
	('Relatore5','Cattaneo','Giacomo','Valve'),
	('Relatore6','Ferrero','Fabio','Realtek'),
	('Relatore7','Russo','Alessandro','Apple');

INSERT INTO Relaziona(idRel, idProgramma) VALUES
	('Relatore1','Programma1'),
	('Relatore2','Programma2'),
	('Relatore3','Programma3'),
	('Relatore4','Programma4'),
	('Relatore5','Programma5'),
	('Relatore6','Programma6'),
	('Relatore7','Programma1');

INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES
 	('01', 'Programma1', 10),
	('02', 'Programma2', 10),
	('03', 'Programma3', 10),
	('04', 'Programma4', 10),
	('05', 'Programma5', 10),
	('06', 'Programma6', 10),
	('07', 'Programma7', 10),
	('08', 'Programma8', 10);
