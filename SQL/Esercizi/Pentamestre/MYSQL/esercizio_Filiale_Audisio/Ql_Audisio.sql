USE 5C_Filiale;

/*Visualizzare, per ogni prestito, il valore del prestito ed i dati identificativi dei clienti che lo hanno stipulato (ordinato per cognome del cliente)*/
SELECT Cliente.cfCliente, Cliente.nominativoCliente, Prestito.cIdentificativoPrestito
FROM Prestito, Cliente, Richiede
WHERE Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
ORDER BY Cliente.nominativoCliente;

/*visualizzare l’elenco di tutti i clienti che hanno almeno un deposito ed un prestito*/
SELECT Cliente.nominativoCliente
FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
WHERE Cliente.cfCliente = Richiede.cfCliente
AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
AND Cliente.cfCliente = Possiede.cfCliente
AND Possiede.numeroConto = ContoCorrente.numeroConto
ORDER BY Cliente.nominativoCliente;

/*visualizzare l’elenco di tutti i clienti titolari di almeno un deposito, ma non di un prestito*/
SELECT Cliente.nominativoCliente
FROM Cliente, Richiede, Prestito, ContoCorrente, Possiede
WHERE Cliente.cfCliente = Richiede.cfCliente
AND Prestito.cIdentificativoPrestito = Richiede.cIdentificativoPrestito
ORDER BY Cliente.nominativoCliente;

/*visualizzare, per ogni filiale, il numero dei titolari di conti*/
SELECT COUNT(Cliente.nominativoCliente) as nTitolari, Filiale.nomeFil
FROM Filiale, Cliente, ContoCorrente, Possiede
WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
AND ContoCorrente.numeroConto = Possiede.numeroConto
AND Possiede.cfCliente = Cliente.cfCliente
GROUP BY Filiale.nomeFil;

/*visualizzare per ogni filiale ed saldo medio dei conti depositati*/
SELECT Filiale.nomeFil, AVG(ContoCorrente.numeroConto) as nConti
FROM Filiale, ContoCorrente
WHERE Filiale.codiceFiliale = ContoCorrente.codiceFiliale
GROUP BY ContoCorrente.numeroConto;

/*visualizzare l’elenco di tutti i clienti che hanno un deposito presso tutte le filiali di Torino*/
SELECT Cliente.nominativoCliente
FROM Filiale, Cliente, ContoCorrente, Possiede
WHERE Filiale.cittaFil = 'Torino'
AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
AND ContoCorrente.numeroConto = Possiede.numeroConto
ORDER BY Cliente.nominativoCliente;

/*visualizzare il saldo medio dei clienti che vivono a Novara ed hanno almeno due depositi*/
SELECT Filiale.nomeFil, AVG(ContoCorrente.saldoConto)
FROM Filiale, ContoCorrente, Possiede
WHERE Filiale.codiceFiliale = .ContoCorrente.codiceFiliale
AND Possiede.cfCliente = Cliente.cfCliente
AND Cliente.cittaCliente = 'Novara'
AND COUNT(Possiede.cfCliente) > 1
GROUP BY Filiale.codiceFiliale;

/*Visualizzare il numero dei titolari di deposito per ogni filiale, dove il saldo medio dei depositi sia superiore a 6.500 euro*/
SELECT Cliente.nominativoCliente
FROM Cliente, Possiede, ContoCorrente
WHERE Cliente.cfCliente = Possiede.cfCliente
AND Possiede.numeroConto = ContoCorrente.numeroConto
AND ContoCorrente.saldoConto > 6500
ORDER BY Cliente.nominativoCliente;

/*Elenco dei clienti che hanno un deposito presso la filiale “agenzia2” di Cuneo*/
SELECT Cliente.nominativoCliente
FROM Cliente, Possiede, ContoCorrente,Filiale
WHERE Filiale.nomeFil = 'Agenzia2'
AND Filiale.cittaFil = 'Cuneo'
AND Filiale.codiceFiliale = ContoCorrente.codiceFiliale
AND Possiede.numeroConto = ContoCorrente.numeroConto
AND Cliente.cfCliente = Possiede.cfCliente
ORDER BY Cliente.nominativoCliente;

/*Elenco dei clienti che hanno più di 3 conti correnti intestati*/
SELECT Filiale.nomeFil, Cliente.nominativoCliente
FROM Cliente, Richiede, Possiede
WHERE Cliente.cfCliente = Possiede.cfCliente
AND Cliente.cfCliente = Richiede.cfCliente
AND COUNT(Possiede.cfCliente) > 3
GROUP BY Cliente.cfCliente;
