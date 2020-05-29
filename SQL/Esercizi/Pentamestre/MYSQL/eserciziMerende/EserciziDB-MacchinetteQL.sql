/*IL WHERE VA A FILTRARE SUI SINGOLI RECORD*/
/*Elenco delle merendine della scuola con codice 34 JOIN IMPLICITO ordinato per prezzo*/
SELECT Merende.NomeMerenda, Merende.Prezzo
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Scuole.codScuola = '34'
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
ORDER BY Merende.Prezzo; /*Ordina in ordine crescente*/			
/*ORDER BY Merende.Prezzo DESC;			per ordinare in ordine decrescente aggiungo DESC alla fine*/

/*Elenco con nome della merenda, tipo della macchinetta, quantità merendine e nome della scuola in cui si trova la macchinetta; elencare solo le macchinette che hanno
  almeno una merendina; l'elenco deve essere ordinato alfabeticamente per nome scuola e in subordine per numero di merendine decrescente presenti nelle macchinette*/
SELECT Merende.NomeMerenda, Macchinette.TipoMacchinetta, Posizioni.QtaMerendine, Scuole.NomeScuola
FROM Merende, Macchinette, Posizioni, Scuole
WHERE Posizioni.QtaMerendine > 0
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
ORDER BY Scuole.NomeScuola ASC, Posizioni.QtaMerendine DESC;

/*Elenco con i nomi delle scuole e numero delle macchinette presenti*/
SELECT Scuole.NomeScuola, COUNT(Scuole.NomeScuola) AS Conta
FROM Scuole, Macchinette
WHERE Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Scuole.NomeScuola
ORDER BY Scuole.NomeScuola;

/*Prezzo medi delle macchinette della scuola 12*/
SELECT Macchinette.CodMacchinetta, AVG(Merende.Prezzo) AS Media
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Scuole.codScuola = '12'
AND Merende.codMerenda = Posizioni.codMerenda
AND Posizioni.codMacchinetta = Macchinette.codMacchinetta
AND Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Macchinette.CodMacchinetta;

/*Elenco delle macchinette che hanno almeno una merendina di quantità 0*/
SELECT Macchinette.CodMacchinetta, Macchinette.CodScuola
FROM Posizioni, Macchinette
WHERE Posizioni.QtaMerendine = 0
AND Macchinette.CodMacchinetta = Posizioni.CodMacchinetta
GROUP BY Macchinette.codMacchinetta;

/*Analoga alla query precedente con il modificatore DISTINCT*/
SELECT DISTINCT Macchinette.CodMacchinetta, Macchinette.CodScuola
FROM Posizioni, Macchinette
WHERE Posizioni.QtaMerendine = 0
AND Macchinette.CodMacchinetta = Posizioni.CodMacchinetta
GROUP BY Macchinette.codMacchinetta;

/*Elenco delle macchinette che non hanno più merendine*/
SELECT Macchinette.CodMacchinetta, Macchinette.CodScuola, SUM(Posizioni.QtaMerendine) AS TotMerendine
FROM Posizioni, Macchinette
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta 
GROUP BY Macchinette.CodMacchinetta
HAVING  TotMerendine = 0;

/*Elenco dei tipi di macchinetta con il numero totale di merendine in esse caricato; escludere dall’elenco i tipi di macchinetta con meno di 40 merendine*/
SELECT Macchinette.TipoMacchinetta, SUM(Posizioni.QtaMerendine) AS totMerendine 
FROM Posizioni, Macchinette
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta
GROUP BY Macchinette.TipoMacchinetta
HAVING  totMerendine >= 40;

/*Totale dei pezzi di tutte le merendine per ogni macchinetta in ogni scuola*/
SELECT Macchinette.TipoMacchinetta, SUM(Posizioni.QtaMerendine) AS totMerendine, Scuole.NomeScuola 
FROM Merende, Posizioni, Macchinette, Scuole
WHERE Posizioni.CodMacchinetta = Macchinette.CodMacchinetta
AND Merende.codMerenda = Posizioni.codMerenda
AND Macchinette.CodScuola = Scuole.CodScuola
GROUP BY Macchinette.TipoMacchinetta;

