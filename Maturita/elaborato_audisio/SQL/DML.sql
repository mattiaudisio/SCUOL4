USE parchi_audisio;

INSERT INTO GuardiaParco (codFiscaleGuardia,nomeGuardia,cognomeGuardia,anniGuardia,sessoGuardia,mailGuardia,passwordGuardia) VALUES
            ('Guardia1','Marco','Longo',30,'M','guardia1@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f'),
            ('Guardia2','Luca','Rossi',29,'M','guardia2@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f'),
            ('Guardia3','Stefano','Verdi',49,'M','guardia3@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f'),
            ('Guardia4','Lorenzo','Giolitti',41,'M','guardia4@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f'),
            ('Guardia5','Giacomo','Saba',56,'M','guardia5@mail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f');

INSERT INTO Parchi (codiceParco,nomeParco,codFiscaleGuardia) VALUES
            ('Parcho1','Gran Paradiso','Guardia1'),
            ('Parcho2','Val Grande','Guardia2'),
            ('Parcho3','Val Troncea','Guardia3'),
            ('Parcho4','Lanca di San Michele','Guardia4'),
            ('Parcho5','Monviso','Guardia5');

INSERT INTO Ordine (codiceOrdine,nomeOrdine) VALUES
            ('ordine1','mammiferi'),
            ('ordine2','rettili'),
            ('ordine3','uccelli');

INSERT INTO Fauna (codiceFauna,specie,eta,sesso,codiceOrdine) VALUES
            ('Fauna1','scoiattolo','A','M','ordine1'),
            ('Fauna2','volpe','C','F','ordine1'),
            ('Fauna3','orso','A','M','ordine1'),
            ('Fauna4','vipera','C','F','ordine2'),
            ('Fauna5','falco','A','M','ordine3');

INSERT INTO Flora (codiceFlora,nome,categoria,stagioneFioritura) VALUES
            ('Flora1','fragola di bosco','piante','primavera'),
            ('Flora2','margherita','piante','autunno'),
            ('Flora3','primula','piante','estate'),
            ('Flora4','acacio','alberi','inverno'),
            ('Flora5','rosmarino','arbusti','autunno'),
            ('Flora6','pino','piante','primavera');


INSERT INTO Vivono (codiceParco,codiceFauna) VALUES
            ('Parcho1','Fauna1'),
            ('Parcho2','Fauna2'),
            ('Parcho3','Fauna3'),
            ('Parcho4','Fauna4'),
            ('Parcho5','Fauna5');

INSERT INTO Trovano (codiceParco,codiceFlora) VALUES
            ('Parcho1','Flora1'),
            ('Parcho2','Flora2'),
            ('Parcho3','Flora3'),
            ('Parcho4','Flora4'),
            ('Parcho5','Flora5'),
            ('Parcho1','Flora6'),
            ('Parcho2','Flora6'),
            ('Parcho3','Flora6'),
            ('Parcho4','Flora6'),
            ('Parcho5','Flora6');
