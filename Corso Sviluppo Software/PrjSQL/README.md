# Teoria SQL

Il dato fondamentale è PK (__Primary Key__). Generalmente viene definito NN (__Not NULL__), ovvero che non può contenere valori nulli, e AI (__Auto Increment__).

Per le query devo inserire per prima *SELECT*, poi le variabili interessate, poi *FROM* e la tabella interessata.

Con l'istruzione *LIMIT* possiamo prendere solo un determinato numero di informazioni.

Una Query è formata da:
```
SELECT
FROM
WHERE
ORDER BY
```
Il metodo *LIKE* serve per trovare tutti gli elementi della tabella che hanno il valore che ci interessa (es. cercare tutte le persone che iniziano con "G" ):
```
SELECT last_name, first_name
FROM customer
WHERE Last_name LIKE "G%" 
ORDER BY last_name, first_name;
```
il comando *INNER JOIN* unisce i valori di tabelle differenti


# Corso MYSQL

I database servono ad organizzare in maniera strutturata dei dati.

```
Un decimale occupa sempre 15 byte
Se trattiamo con valori decimali tengo sempre 4 decimali
```

*SQL sintassi*
- Il testo in maiuscolo deve comparire così com'è
- il linguaggio SQL non è case-sensitive
- Non ci possono essere due chiavi primarie
- Primary è la chiave più veloce che c'è
- *LONGTEXT*/*MEDIUMTEXT*/*TINYTEXT* non possono avere degli indici perché non vengono salvati su tabella ma su un file a parte
- *DISTINCT* serve ad estrarre una sola volta ogni diversa occorenza di un valore all'interno di un dato campo (uguale a *GROUP BY*)
- *LIKE* serve per fare delle interrogazioni sulle stringhe


__*esempio distinct*__

```
SELECT distinct(first_name) FROM sakila.actor;
```

*Acronimi*
- *AI* significa AUto-Increment (ovvero che incrementa il valore di uno)
- *PK* significa Primary Key (è unica per ogni tabella ed è sempre NotNull)
- *UQ* significa Unique (è parte di una chiave unica)


