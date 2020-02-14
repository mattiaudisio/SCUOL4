USE 5C_Convention;

-- INSERIMENTO DEI DATI NELLE TABELLE --
INSERT INTO Relatore(idRel,cognomeRel,nomeRel,idAzienda) VALUES
    (`Rel01`,'Rossi',`Leonardo`,`Beintoo`),
    (`Rel02`,`Ferrari`,`Francesco`,`Marketing Arena`),
    (`Rel03`,`Russo`,`Alessandro`,`Afinna One`),
    (`Rel04`,`Bianchi`,`Andrea`,`Sardex`),
    (`Rel05`,`Romano`,`Riccardo`,`Eis`);

INSERT INTO Azienda(idAzienda,indirizzoAzieda,telefonoAzienda) VALUES
    (`Beintoo`,'Corso Lombardia 31',4292638106),
    (`Marketing Arena`,`Via Leonardo 11`,5957068157),
    (`Afinna One`,`Piazza Magellano 22`,869273093),
    (`Sardex`,`Via Antica 42`,958985395),
    (`Eis`,`Corso Italia 1`,918031098);

INSERT INTO Programma(idProgramma,fasciaOraria,idSpeech,nomeSala) VALUES
    (`PR01`,`A`,`SP01`,`Sala Verde`),
    (`PR02`,`B`,`SP02`,`Sala Rossa`),
    (`PR03`,`C`,`SP03`,`Sala Gialla`),
    (`PR04`,`D`,`SP04`,`Sala Verde`),
    (`PR05`,`E`,`SP05`,`Sala Rossa`);

INSERT INTO Speech(idSpeech,titolo,argomento) VALUES
    (`SP01`,`Intelligenza Artificiale`,`Intelligenza Artificiale`),
    (`SP02`,`Nuovo Telefono`,`Nuovo Telefono`),
    (`SP03`,`Nuovo Computer`,`Nuovo Computer`),
    (`SP04`,`Nuovo Sistema Operativo`,`Nuovo Sistema Operativo`),
    (`SP05`,`Chatbot`,`Chatbot`);

INSERT INTO Partecipante(idPart,cognomePart,nomePart,mailPart,tipologiaPart) VALUES
    (`Part01`,'Rinaldi',`Edoardo`,`edoardorinaldi@gmail.com`,`Professore`),
    (`Part02`,'Colombo',`Tommaso`,`tommasocolombo@gmail.com`,`Alunno`),
    (`Part03`,'Mancini',`Riccardo`,`riccardomancini@gmail.com`,`Professore`),
    (`Part04`,'Longo',`Sofia`,`sofialongo@gmail.com`,`Professionista`),
    (`Part05`,'Leone',`Aurora`,`auroraleone@gmail.com`,`Professionista`);

INSERT INTO Sala(idSala,nPostiSala,Numero) VALUES
    (`Sala Verde`,200,2),
    (`Sala Rossa`,200,3),
    (`Sala Gialla`,200,3),
    (`Sala Azzurra`,200,2),
    (`Sala Bianca`,200,1);
    
INSERT INTO Piano(nPiano,nSale,descrizione) VALUES
    (1,10,`descrizioneSala1`),
    (2,10,`descrizioneSala1`),
    (3,10,`descrizioneSala1`),
    (4,10,`descrizioneSala1`),
    (5,10,`descrizioneSala1`);

INSERT INTO Relaziona(idRel,idProgramma) VALUES
    (`Rel01`,`PR01`),
    (`Rel02`,`PR02`),
    (`Rel03`,`PR03`),
    (`Rel04`,`PR04`),
    (`Rel05`,`PR05`);

INSERT INTO Composto(idRel,idProgramma) VALUES
    (`Part01`,`PR01`,`180`),
    (`Part02`,`PR02`,`180`),
    (`Part03`,`PR03`,`180`),
    (`Part04`,`PR04`,`180`),
    (`Part05`,`PR05`,`180`);
