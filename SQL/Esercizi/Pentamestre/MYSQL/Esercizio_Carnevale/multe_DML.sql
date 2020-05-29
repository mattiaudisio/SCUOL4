USE 5C_Multe;

INSERT INTO Agenti VALUES('AMT01','Agente Rossi','Matteo','Rossi');
INSERT INTO Agenti VALUES('AGV02','Agente Verdi','Giovanni','Verdi');
INSERT INTO Agenti VALUES('ALS03','Agente severo','Lorenzo','Severo');

INSERT INTO Multa VALUES('AGV02','CRI0106','I01','27/02/2020','eccesso di velocità',150);  
INSERT INTO Multa VALUES('AMT01','FD444XX','I02','14/02/2020','divieto di sosta',100);
INSERT INTO Multa VALUES('ALS03','FD444XX','I03','14/02/2020','deccesso di velocità',150);

INSERT INTO Veicoli VALUES('FD444XX','Fiat','Panda','VALNTZ71L2Y');
INSERT INTO Veicoli VALUES('CRI0106','Citroen','C3','RYSLPO33B6C');

INSERT INTO Automobilista VALUES('VALNTZ71L2Y','Lentino','Va','Via Piasco 24','Cuneo','12100');
INSERT INTO Automobilista VALUES('RYSLPO33B6C','Eugenio','Federici','Corso Lombardia 3','Fossano','12045');
