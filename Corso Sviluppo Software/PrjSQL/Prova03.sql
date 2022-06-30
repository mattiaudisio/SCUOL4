#Quali attori hanno il nome Johnny
SELECT * FROM sakila.actor WHERE first_name = "JOHNNY";

#Elenca gli attori per nome distinto
SELECT distinct(first_name) FROM sakila.actor;

#Elenca gli attori che si chiamano GRACE o PENELOPE
SELECT * FROM sakila.actor WHERE first_name = "GRACE" OR first_name = "PENELOPE";

#Elenca gli attori che si chiamano DAN ma non HARRIS
SELECT * FROM sakila.actor WHERE first_name = "DAN" AND last_name != "HARRIS";

#Elenca gli attori con id fra 10 e 30
SELECT * FROM sakila.actor WHERE actor_id BETWEEN 10 AND 30;

#Elenca gli attori il cui cognome inizia per B
SELECT * FROM sakila.actor WHERE last_name LIKE 'B%'; 

#Elenca gli attori il cui cognome ha la seconda lettera = A
SELECT * FROM sakila.actor WHERE last_name LIKE '_A%'; 

#Quanti attori hanno il nome JOHNNY
SELECT COUNT(sakila.actor.first_name) AS NUM_JOHNNY FROM sakila.actor WHERE first_name = "JOHNNY";
