-- ComandiSQL_x_db_palestra_QL --

/* Interrogazioni al DB Palestra */

/* Elenco dei dati degli istruttori */
Select *
From istruttori;

/* Dati completi di tutti gli istruttori che si chiamano "Barbara" */
Select *
From istruttori
Where istruttori.nome='Barbara';

/* Cognome e telefono di tutti gli istruttori che si chiamano "Barbara" */
/* QUESTA E' UNA PROIEZIONE */
Select istruttori.cognome, istruttori.tel
From istruttori
Where istruttori.nome='Barbara';

/* Numero di posti del corso di pesi */
Select corsi.num_posti
From corsi
Where corsi.descrizione='pesi';

/* Elenco iscritti (nome e cognome) al corso aerobica con inner join */
Select clienti.nome,clienti.cognome, corsi.num_posti
From clienti
Inner join clienti_corsi On clienti.pk_cliente=clienti_corsi.fk_cliente
Inner join corsi On corsi.pk_corso=clienti_corsi.fk_corso
Where corsi.descrizione='aerobica';

/* Elenco iscritti (nome e cognome) al corso di aerobica con join implicito*/
Select clienti.nome,clienti.cognome
From clienti, clienti_corsi,corsi
Where (corsi.descrizione='aerobica'
OR corsi.descrizione='pesi')
AND clienti.pk_cliente=clienti_corsi.fk_cliente
AND corsi.pk_corso=clienti_corsi.fk_corso;

/* Elenco dei dati degli istruttori */
Select *
From istruttori
ORDER BY istruttori.cognome, istruttori.nome;
