USE 5C_Convention;

INSERT INTO Relatore(idRel, cognomeRel, nomeRel, idAzienda) VALUES
	('Relatore01','Rossi','Marco','Azienda01'),
	('Relatore02','Rossi','Luca','Azienda02'),
	('Relatore03','Rossi','Andrea','Azienda03'),
	('Relatore04','Rossi','Mattia','Azienda04'),
	('Relatore05','Rossi','Giacomo','Azienda05'),
	('Relatore06','Rossi','Fabio','Azienda01'),
	('Relatore07','Rossi','Alessandro','Azienda07');

INSERT INTO Azienda(idAzienda, indirizzoAzienda, telefonoAzienda) VALUES
	('Azienda01','Via Azienda 1','0175125831'),
	('Azienda02','Via Azienda 2','0175125832'),
	('Azienda03','Via Azienda 3','0175125833'),
	('Azienda04','Via Azienda 4','0175125834'),
	('Azienda05','Via Azienda 5','0175125835'),
	('Azienda06','Via Azienda 6','0175125836'),
	('Azienda07','Via Azienda 7','0175125837');
	
INSERT INTO Programma(idProgramma, fasciaOraria, idSpeech, idSala) VALUES
	('Programma01','A','Speech01','Sala01'),
	('Programma02','B','Speech02','Sala02'),
	('Programma03','C','Speech03','Sala03'),
	('Programma04','C','Speech04','Sala04'),
	('Programma05','B','Speech05','Sala05'),
	('Programma06','A','Speech02','Sala06');

INSERT INTO Speech(idSpeech, titolo, argomento, Durata) VALUES
	('Speech01','Titolo01','Argomento01', 1234),
	('Speech02','Titolo02','Argomento02', 4321),
	('Speech03','Titolo03','Argomento03', 23234),
	('Speech04','Titolo04','Argomento04', 23432),
	('Speech05','Titolo05','Argomento05', 29873);

INSERT INTO Partecipante(idPart, cognomePart, nomePart, mailPart, tipologiaPart) VALUES
	('Part01','Rossi','Marco','part1@gmail.com','Studente'),
	('Part02','Bianchi','Matteo','part2@gmail.com','Docente'),
	('Part03','Verdi','Luca','part3@gmail.com','Libero Professionista'),
	('Part04','Gialli','Mattia','part4@gmail.com','Studente'),
	('Part05','Viola','Francesco','part5@gmail.com','Docente'),
	('Part06','Verde','Nicola','part6@gmail.com','Docente'),
	('Part07','Rossi','Stefano','part7@gmail.com','Libero Professionista'),
	('Part08','Rossi','Andrea','part8@gmail.com','Libero Professionista');

INSERT INTO Sala(idSala, nPostiSala, idPiano) VALUES
	('Sala01','50','Piano01'),
	('Sala02','100','Piano02'),
	('Sala03','50','Piano03'),
	('Sala04','60','Piano02'),
	('Sala05','40','Piano01'),
	('Sala06','150','Piano03');

INSERT INTO Piano(idPiano,nPiano,nSale) VALUES
	('Piano01', 10, 1),
	('Piano02', 5, 2),
	('Piano03', 6, 3);
	
INSERT INTO Relaziona(idRel, idProgramma) VALUES
	('Relatore01','Programma01'),
	('Relatore02','Programma02'),
	('Relatore03','Programma03'),
	('Relatore04','Programma04'),
	('Relatore05','Programma05'),
	('Relatore06','Programma06'),
	('Relatore07','Programma01');    	
	
INSERT INTO Composto(idPart, idProgramma, nPartecipanti) VALUES
 	('Part01', 'Programma01', 10),
	('Part02', 'Programma01', 10),
	('Part03', 'Programma01', 10),
	('Part04', 'Programma01', 10),
	('Part05', 'Programma01', 10),
	('Part06', 'Programma01', 10),
	('Part07', 'Programma01', 10),
	('Part08', 'Programma01', 10);	
