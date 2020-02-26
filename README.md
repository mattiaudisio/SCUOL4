# ProgettoSQL_Convention

<b>Realtà</b><br />
<p>Organizzazione Convention, 1 giorno più relatori  (appartiene ad una determinata azienda) che presentano degli speach (presentazione 20 minuti) che possono essere replicate.
Ogni speach può essere rappresentato in sale differenti (1° in sala Verde alle 10.00am 2° Sala Gialla 3:00am). 
Possono essere più relatori che presentano insieme. In contemporanea, in tutte le sale (3 piani, sale con nomi univoci).
i partecipanti possono prenotarsi agli speach e possono avere 3 tipologie fisse: lavoratori professionisti, insegnanti, studenti.
Alla fine della giornata c'è un unico speach speciale, speach premiazione, che non ha nessuno speach in contemporanea ed è l'ultimo, possono partecipare solo i professionisti e gli insegnanti, vienne fatta all'auditorium (dove si fa solo questo speach).</p>

<b>Schema E/R</b><br />
![Schema E/R](https://raw.githubusercontent.com/mattiaudisio/ProgettoSQL_Convention/master/Schemi/Schema_ER.png)

<b>Schema Logico</b><br />
Relatore(__idRel__,mailRel,cognomeRel,nomeRel,~~idAzienda~~);<br />
Azienda(__idAzienda__,indirizzoAzienda,telefonoAzienda);<br />
Programma(__idProgramma__,fasciaOraria,~~idSpeech,nomeSala~~);<br />
Speech(__idSpeech__,titolo,argomento);<br />
Partecipante(__idPart__,cognomePart,nomePart,mailPart,tipologiaPart);<br />
Sala(__idSala__,nPostiSala,~~Numero~~);<br />
Piano(__nPiano__,nSale,descrizione);<br />
Relaziona(__idRel,idProgramma__);<br />
Sceglie(__idPart,idProgramma__);<br />

<b>Schema Fisico</b><br />
![Schema Fisico](https://raw.githubusercontent.com/mattiaudisio/ProgettoSQL_Convention/master/Schemi/Schema_Fisico.png)
