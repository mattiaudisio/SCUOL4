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
	('Azienda1','Via Azienda 1','0175125831'),
	('Azienda2','Via Azienda 2','0175125832'),
	('Azienda3','Via Azienda 3','0175125833'),
	('Azienda4','Via Azienda 4','0175125834'),
	('Azienda5','Via Azienda 5','0175125835'),
	('Azienda6','Via Azienda 6','0175125836'),
	('Azienda7','Via Azienda 7','0175125837');

INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	('par1','Rossi','Marco','par1@gmail.com','Studente'),
	('par2','Bianchi','Matteo','par2@gmail.com','Docente'),
	('par3','Verdi','Luca','par3@gmail.com','Libero Professionista'),
	('par4','Gialli','Mattia','par4@gmail.com','Studente'),
	('par5','Viola','Francesco','par5@gmail.com','Docente'),
	('par6','Verde','Nicola','par6@gmail.com','Docente'),
	('par7','Rossi','Stefano','par7@gmail.com','Libero Professionista'),
	('par8','Rossi','Andrea','par8@gmail.com','Libero Professionista');

INSERT INTO Speech(idSpeech, titolo, argomento, Durata) VALUES
	('Speech1','Manjaro','Rilasciato Manjaro 19.0 Kyria', 1234),
	('Speech2','Kernel','Nuova gestione dei processi', 4321),
	('Speech3','Raspberry','Raspberry Pi 4', 23234),
	('Speech4','Java','Nuova release jdk', 23432),
	('Speech5','Gnome','Rilasciato Gnome 3.36', 29873);

INSERT INTO Programma(idProgramma, fasciaOraria, idSpeech, idSala) VALUES
	('Programma1','A','Speech1','Sala1'),
	('Programma2','B','Speech2','Sala2'),
	('Programma3','C','Speech3','Sala3'),
	('Programma4','C','Speech4','Sala4'),
	('Programma5','B','Speech5','Sala5'),
	('Programma6','A','Speech2','Sala6');

INSERT INTO Relatore(idRel, cognomeRel, nomeRel, idAzienda) VALUES
	('Relatore1','Rossi','Marco','Azienda1'),
	('Relatore2','Otta','Luca','Azienda2'),
	('Relatore3','Verdi','Andrea','Azienda3'),
	('Relatore4','Musso','Mattia','Azienda4'),
	('Relatore5','Cattaneo','Giacomo','Azienda5'),
	('Relatore6','Ferrero','Fabio','Azienda6'),
	('Relatore7','Russo','Alessandro','Azienda7');

INSERT INTO Relaziona(idRel, idProgramma) VALUES
	('Relatore1','Programma1'),
	('Relatore2','Programma2'),
	('Relatore3','Programma3'),
	('Relatore4','Programma4'),
	('Relatore5','Programma5'),
	('Relatore6','Programma6'),
	('Relatore7','Programma1');

INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES
 	('par1', 'Programma1', 10),
	('par2', 'Programma1', 10),
	('par3', 'Programma1', 10),
	('par4', 'Programma1', 10),
	('par5', 'Programma1', 10),
	('par6', 'Programma1', 10),
	('par7', 'Programma1', 10),
	('par8', 'Programma1', 10);
