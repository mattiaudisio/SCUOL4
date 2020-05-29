USE 5C_Multe;

/*Cognome e nome degli automobilisti multati per divieto di sosta suddivisi per città*/
SELECT Automobilista.cognomeAutomobilista, Automobilista.nomeAutomobilista, Automobilista.citta,
FROM Automobilista, Veicoli, Multa
WHERE Multa.denominazioneInfrazione = 'divieto di sosta'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
ORDER BY Automobilista.cognomeAutomobilista;

/*Marca e modello dei veicoli multati dall’agente Rossi il 14/02/2020, raggruppati per marca*/
SELECT Veicoli.marcaVeicoli, Veicoli.modelloVeicolo
FROM Veicoli, Multa, Agenti
WHERE Multa.dataInfrazione = '14/02/2020'
AND Multa.matricolaAgente = Agenti.matricolaAgente
AND Agenti.cognomeAgente = 'Rossi'
ORDER BY Veicoli.marcaVeicoli;

/*Numeri di targa e nomi dei proprietari multati dall’agente Verdi per eccesso divelocità*/
SELECT Veicoli.targaVeicolo, Automobilista.nomeAutomobilista
FROM *
WHERE Agenti.cognomeAgente = 'Verdi'
AND Multa.matricolaAgente = Agenti.matricolaAgente
AND Multa.denominazioneInfrazione = 'eccesso di velocità'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
ORDER BY Veicoli.targaVeicolo;

/*Elenco delle date e del tipo di infrazioni commesse dall’automobilista Va Lentino*/
SELECT Multa.dataInfrazione, Multa.denominazioneInfrazione
FROM Multa, Veicoli, Automobilista
WHERE Automobilista.nomeAutomobilista = 'Va'
AND Automobilista.cognomeAutomobilista = 'Lentino'
AND Veicoli.codiceFiscale = Automobilista.codiceFiscale
AND Multa.targaVeicolo = Veicoli.targaVeicolo
ORDER BY Multa.dataInfrazione;

/*Numero di infrazioni sanzionate dall’agente Severo*/
SELECT count(Multa.codiceInfrazione) as Numero
FROM Multa, Agenti
WHERE Agenti.cognomeAgente = 'Severo'
AND Agenti.matricolaAgente = Multa.matricolaAgente
GROUP BY Multa.codiceInfrazione
ORDER BY Multa.codiceInfrazione;

/*Importo totale delle multe del veicolo FD 444 XX*/
SELECT SUM(Multa.importoInfrazione) as Importo
FROM Multa, Veicolo
WHERE Veicolo.targaVeicolo = 'FD444XX'
AND Multa.targaVeicolo = Veicoli.targaVeicolo
GROUP BY Multa.importoInfrazione;
