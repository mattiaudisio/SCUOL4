#update utente
#set dataUltimoVersamento = '2021-01-01'
#where
#idUtente < 1000;

#domanda1 : utenti che non si sono ancora iscritti
#SELECT * FROM utente WHERE dataIscrizione is null;

#domanda2 : utenti che hanno la tessera scaduta
#SELECT * FROM utente WHERE (to_days(now()) - to_days(dataUltimoVersamento)) > 30;

#domanda 3 : utenti che compiono gi anni il mese prossimo
SELECT * FROM utente where month(dataNascita) = month(now()) + 1 or month(dataNascita)+12 = month(now()) + 1 ;