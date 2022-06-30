USE sakila;

SELECT *
FROM actor 
ORDER BY actor_id DESC, last_name
LIMIT 10;

SELECT last_name, first_name
FROM customer
#WHERE Last_name > "G" AND Last_name < "H"
WHERE Last_name LIKE "G%" 
ORDER BY last_name, first_name;

SELECT customer.last_name AS "Cognome", customer.first_name AS "Nome", address.address AS "Indirizzo", address.phone AS "Telefono"
FROM customer
INNER JOIN address ON customer.address_id = address.address_id

###########################################################################

USE scuola;

SELECT scuola.docenti.nomeDocente, scuola.docenti.cognomeDocente, corso.nome
FROM scuola.docenti as docenti, scuola.docenticorso as docenticorso, scuola.corso as corso
WHERE docenti.idDocenti = docenticorso.idDocenti
AND corso.idCorso = docenticorso.idCorso;


SELECT scuola.docenti.nomeDocente, scuola.docenti.cognomeDocente, corso.nome
FROM scuola.docenti as docenti, scuola.docenticorso as docenticorso, scuola.corso as corso
WHERE docenti.idDocenti = docenticorso.idDocenti
AND corso.idCorso = docenticorso.idCorso;

SELECT nome, cognome FROM scuola.studente;

SELECT * FROM scuola.studente

USE scuola;
SELECT docenti.nomeDocente, docenti.cognomeDocente, corso.idCorso
FROM docenti inner join docenticorso on docenti.idDocenti =  docenticorso.idDocenti
inner join corso on corso.idCorso = docenticorso.idCorso;
where
nome = "Mattia";

SELECT * FROM scuola.studente
where
idStudente = 1 or idStudente = 2;

SELECT * FROM scuola.studente
where
nome = "Kevin" and idCorso = 1;

SELECT * FROM scuola.studente
where idStudente <> 1;

SELECT scuola.studente.nome,scuola.studente.cognome, scuola.corso.nome
FROM scuola.studente, scuola.corso
where
scuola.studente.idCorso = scuola.corso.idCorso;

SELECT studenti.nome,studenti.cognome,
corsi.nome
FROM 
scuola.studente studenti inner join scuola.corso corsi
on studenti.idCorso = corsi.idCorso; 

SELECT scuola.studente.nome,scuola.studente.cognome,scuola.studente.dataNascita
FROM scuola.studente
WHERE scuola.studente.dataNascita > "2000-01-01";

###########################################################################
INSERT INTO utente(idUtente,numeroTessera,nome,cognome,luogoNascita,dataNascita,indirizzoResidenza,dataIscrizione,dataPrimoVersamento,dataUltimoVersamento)
VALUES (10,10,10,10,10,"1984-07-08", null,"2020-10-11","2020-10-12","2020-12-14");  

###########################################################################
update utente
set dataUltimoVersamento = '2021-01-01'
where
idUtente < 1000;

#domanda1 : utenti che non si sono ancora iscritti
SELECT * FROM utente WHERE dataIscrizione is null;

#domanda2 : utenti che hanno la tessera scaduta
SELECT * FROM utente WHERE (to_days(now()) - to_days(dataUltimoVersamento)) > 30;
                                                     
#domanda3 : utenti che compiono gi anni il mese prossimo
SELECT * FROM utente where month(dataNascita) = month(now()) + 1 or month(dataNascita)+12 = month(now()) + 1 ;
