/*Elenco dei componenti del gruppo AC/DC*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum, Cantante.nomeCant, Cantante.cognCant, Componenti.nazComp
FROM Strumentista, Componenti, Gruppo, Cantante
WHERE Gruppo.codGruppo = 'ACDC'
AND Componenti.codGruppo = Gruppo.codGruppo
AND Strumentista.psedStrum = Componenti.psedStrum
AND Cantante.psedCant = Componenti.psedCant;

/*Nome e cognome del cantante del gruppo Pinguini Tattici Nucleari nell'album Faber Nostrum*/
SELECT Cantante.nomeCant, Cantante.cognCant
FROM Cantante, Album, Componenti, Gruppo
WHERE Album.titAlbum = 'Faber Nostrum'
AND Album.codGruppo = Gruppo.codGruppo
AND Componenti.codGruppo = Gruppo.codGruppo
AND Componenti.psedCant = Cantante.psedCant;

/*Nome e cognome dei cantanti italiani ed il numero di canzoni interpretate da ognuno di essi*/
SELECT Cantanti.nomeCant, Cantanti.cognCant, COUNT(Canzoni.codCanz) AS nCanzoni
FROM Cantanti, Canzoni, Componenti
WHERE Componenti.nazComp = 'Italia'
AND Componenti.psedCant = Cantante.psedCant
AND Canzoni.psedCant = Cantante.psedCant
GROUP BY Canzoni.codCanz
ORDER BY Cantanti.cognCant;

/*il guadagno annuale di ogni gruppo*/
SELECT Componenti.stipAnn, Gruppo.nomeGruppo
FROM Componenti, Gruppo
WHERE Componenti.codGruppo = Gruppo.codGruppo
ORDER BY Gruppo.nomeGruppo;

/*Elenco dei componenti che hanno suonato al Conertone del 1 Maggio 2019 a Roma*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum, Cantante.nomeCant, Cantante.cognCant, Gruppo.nomeGruppo
FROM Strumentista, Cantante, Gruppo, Componenti, Concerti, Partecipa
WHERE  Concerti.dataConcerti = '01052019'
AND Concerti.luogoConcerti = 'Roma'
AND Concerti.nomeConcerti = 'Concertone'
AND Partecipa.codConcerti = Concerti.codConcerti
AND Partecipa.codGruppo = Gruppo.codGruppo
AND Componenti.codGruppo = Gruppo.codGruppo 
AND Componenti.psedCant = Cantante.psedCant
AND Componenti.psedStrum = Strumentista.psedStrum
ORDER BY Gruppo.nomeGruppo;

/*Numero degli album usciti nell'anno 2001, suddivisi per ogni gruppo*/
SELECT Gruppo.codGruppo, COUNT(Gruppo.codGruppo) AS nAlbum
FROM Album, Gruppo
WHERE Album.annoUscita = '2001'
GROUP BY Gruppo.codGruppo
ORDER BY Gruppo.codGruppo;

/*Cognome e nome del batterista dei gruppi con anno di fondazione successivo al 1997*/
SELECT Strumentista.cognStrum, Strumentista.nomeStrum
FROM Gruppo, Componenti, Strumentista, Strumenti
WHERE Gruppo.annoGruppo > '1997'
AND Gruppo.codGruppo = Componenti.codGruppo
AND Componenti.psedStrum = Strumentista.psedStrum
AND Strumentista.psedStrum = Strumenti.psedStrum
AND Strumenti.tipoStrument = 'Batteria'
ORDER BY Strumentista.cognStrum;
