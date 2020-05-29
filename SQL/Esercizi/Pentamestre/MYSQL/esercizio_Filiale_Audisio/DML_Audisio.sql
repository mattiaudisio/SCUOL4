USE 5C_Filiale;

INSERT INTO Cliente(cfCliente,nominativoCliente,telefonoCliente,cittaCliente,indirizzoCliente) VALUES 
    ('CNIFZH65L71B405','Rossi','7456913289','Novara','via Saluzzo 21'),
    ('BCWVCV56L68B165','Russo','1463289103','Novara','Corso Roma 7'),
    ('ZVPLTJ59P30D072','Ferrari','3485712960','Torino','Via Marco Polo 1'),
    ('NBDTZH38D04F667','Bianchi','9645871245','Torino','Piazza Torino 3'),
    ('LKFPJB50P59L230','Colombo','9317562487','Cuneo','Corso Roma 25');

INSERT INTO Filiale(codiceFiliale,nomeFil,cittaFil) VALUES
    ('Fil01','FTorino','Torino'),
    ('Fil02','FNovara','Novara'),
    ('Fil03','Agenzia2','Cuneo'),
    ('Fil04','FAsti','Asti'),
    ('Fil05','FGenova','Genova'); 

INSERT INTO ContoCorrente(numeroConto,saldoConto,codiceFiliale) VALUES
    (01,2500,'Fil01'),
    (02,7100,'Fil02'),
    (03,9400,'Fil03'),
    (10,6500,'Fil04'),
    (50,1000,'Fil05');  
   
INSERT INTO Prestito(cIdentificativoPrestito,ammontarePrestito,matricolaPrestito,dataApertura,dataEstinzione,codiceFiliale) VALUES
    ('Prest01',1000,'lmp01','02/02/2020','02/02/2024','Fil01'),
    ('Prest02',1000,'lmp02','08/04/2019','08/04/2023','Fil02'),
    ('Prest03',1000,'lmp03','11/08/2018','11/08/2022','Fil03'),
    ('Prest04',1000,'lmp04','09/02/2020','09/02/2024','Fil04'),
    ('Prest05',1000,'lmp05','02/12/2019','02/12/2023','Fil05');
    
INSERT INTO Possiede(numeroConto,cfCliente) VALUES
    (01,'CNIFZH65L71B405'),
    (02,'BCWVCV56L68B165'),
    (03,'ZVPLTJ59P30D072'),
    (10,'NBDTZH38D04F667'),
    (50,'LKFPJB50P59L230');   
    
INSERT INTO Richiede(cIdentificativoPrestito,cfCliente) VALUES
    ('Prest01','CNIFZH65L71B405'),
    ('Prest02','BCWVCV56L68B165'),
    ('Prest03','ZVPLTJ59P30D072'),
    ('Prest04','NBDTZH38D04F667'),
    ('Prest05','LKFPJB50P59L230');    
