USE 5C_Convention;

-- TABELLA RELATORE --
INSERT INTO Relatore(idRel,cognomeRel,nomeRel,idAzienda) VALUES
    ('Relatore01','Marco','Rossi','Azienda01'),
    ('Relatore02','Matteo','Verdi','Azienda02'),
    ('Relatore03','Luca','Manzoni','Azienda03'),
    ('Relatore04','Lucrezia','Viola','Azienda04'),
    ('Relatore05','Giovanni','Longo','Azienda05');    
    
-- TABELLA AZIENDA --
INSERT INTO Azienda(idAzienda,indirizzoAzienda,telefonoAzienda) VALUES  
    ('Azienda01','Via Azienda 1','1111111111'),
    ('Azienda02','Via Azienda 2','2222222222'),
    ('Azienda03','Via Azienda 3','3333333333'),
    ('Azienda04','Via Azienda 4','4444444444'),
    ('Azienda05','Via Azienda 5','5555555555');
    
-- TABELLA PROGRAMMA --
INSERT INTO Programma(idProgramma,fasciaOraria,idSpeech,idSala) VALUES
    ('Programma01','A','Speech01','Sala01'),
    ('Programma02','B','Speech02','Sala02'),
    ('Programma03','C','Speech03','Sala03'),
    ('Programma04','D','Speech04','Sala04'),
    ('Programma05','E','Speech05','Sala05');
    
-- TABELLA SPEECH --    
INSERT INTO Speech(idSpeech,titolo,argomento) VALUES
    ('Speech01','Titolo01','Argomento01'),
    ('Speech02','Titolo02','Argomento02'),
    ('Speech03','Titolo03','Argomento03'),
    ('Speech04','Titolo04','Argomento04'),
    ('Speech05','Titolo05','Argomento05');

-- TABELLA PARTECIPANTE --    
INSERT INTO Partecipante(idPart,cognomePart,nomePart,mailPart,tipologiaPart) VALUES
    ('Partecipante01','Ferrari','Leonardo','par01@gmail.com','insegnanti'),
    ('Partecipante02','Russo','Francesco','par02@gmail.com','studenti'),
    ('Partecipante03','Romano','Anna','par03@gmail.com','lavoratoriProfessionisti'),
    ('Partecipante04','Gallo','Andrea','par04@gmail.com','studenti'),
    ('Partecipante05','Costa','Gabriele','par05@gmail.com','lavoratoriProfessionisti');
    
-- TABELLA SALA --
INSERT INTO Sala(idSala,nPostiSala,nPiano) VALUES
    ('Sala01',100,'Piano01'),
    ('Sala02',100,'Piano02'),
    ('Sala03',100,'Piano01'),
    ('Sala04',100,'Piano02'),
    ('Sala05',100,'Piano03');
    
-- TABELLA PIANO --
INSERT INTO Piano(nPiano,nSale,descrizione) VALUES
    ('Piano01',2,'descrizione01'),
    ('Piano02',2,'descrizione02'),
    ('Piano03',1,'descrizione03');
    
-- TABELLA RELAZIONA --
INSERT INTO Relaziona(idRel,idProgramma) VALUES
    ('Relatore01','Programma01'),
    ('Relatore01','Programma02'),
    ('Relatore01','Programma03'),
    ('Relatore01','Programma04'),
    ('Relatore01','Programma05');
    
-- TABELLA COMPOSTO --
INSERT INTO Composto(idPart,idProgramma,nPartecipanti) VALUES
    ('Partecipante01','Programma01',10),
    ('Partecipante02','Programma02',20),
    ('Partecipante03','Programma03',30),
    ('Partecipante04','Programma04',40),
    ('Partecipante05','Programma05',50);             
