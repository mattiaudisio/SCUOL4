/*Elenco degli studenti dell’itis suddivisi per attività sportiva*/
SELECT Istituti.denominazione, Studente.nome
FROM Istituti, Studente, Professore, Manifestazione
WHERE Isituti.denominazione = 'Itis'
AND Studente.codiceIstituto = Istituti.codiceIstituto
ORDER BY Studente.nome;

/*Numero degli studenti per ogni scuola che partecipano alla gara dinuoto*/
SELECT Studente.nome, Manifestazione.codiceManifestazione
FROM Studente, Manifestazione
WHERE  Manifestazione.codiceManifestazione = 'Nuoto'
ORDER BY Studente.nome;

/*Elenco anagrafico degli allenatori per ogni attività sportiva*/
SELECT Professore.nome
FROM Professore
ORDER BY Professore.nome;

/*Elenco   delle   scuole   (con   denominazione,   indirizzo,   telefono)   constudenti che partecipano alla gara di salto in lungo*/
SELECT Istituti.denominazione, Istituti.indirizzo, Istituti.telefono, Manifestazione.codiceManifestazione
FROM Istituti, Manifestazione, Professore
WHERE Manifestazione.codiceManifestazione = 'Salto in lungo'
AND Manifestazione.codiceManifestazione = Professore.codiceManifestazione
AND Professore.codiceIstituto = Istituti.codiceIstituto
ORDER BY Istituti.denominazione;

/*Totale   degli   alunni   per   ogni   scuola   che   partecipano   alle   attivitàsportive, ordinati per scuola ed in seguito per attività sportiva*/
SELECT     
