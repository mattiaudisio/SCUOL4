# Audisio Mattia 5C

__*ESAME DI STATO DI ISTITUTO TECNICO INDUSTRIALE*__ <br />
CORSO DI ORDINAMENTO <br />
__Indirizzo__: INFORMATICA <br />
__Tema di__: INFORMATICA GENERALE, SISTEMI E RETI <br />

Il Ministero dell'Ambiente commissiona lo sviluppo di un nuovo Sistema Informativo per censire la
fauna e la flora presenti nei vari parchi naturali di ciascuna regione. Le informazioni della fauna da
raccogliere riguardano l'ordine di appartenenza (mammiferi, rettili, uccelli, etc...), la specie
(scoiattolo, volpe, orso, vipera, falco, aquila, etc...), il numero di esemplari adulti e cuccioli (con
distinzione maschio, femmina). La flora viene distinta in alberi (quercia, faggio, acacia, etc...),
arbusti (lavanda, rosmarino, rododendro, etc...) e piante erbacee (fragola di bosco, margherita,
primula, etc...) ed è necessario catalogarle.<br />
In ciascun parco, un responsabile (guardia parco) raccoglie le informazioni attraverso
un’interfaccia web tramite il dispositivo mobile in dotazione e, dopo avere acquisito i dati dalle
maschere di immissione, li invia al sistema centrale della Regione per la memorizzazione nel
database regionale.<br />
Il candidato, formulate le opportune ipotesi aggiuntive, realizzi:<br />
 • Un’analisi della realtà di riferimento, completa dello schema funzionale dell'architettura
 proposta (a livello locale e regionale), evidenziandone le principali componenti, le
 caratteristiche hardware e software, i protocolli necessari, la tecnologia utilizzata per la
 trasmissione delle informazioni e le tecniche per garantire la sicurezza perimetrale dei dati.<br />
 • Un piano opportuno di indirizzamento locale e per la comunicazione tra le sedi.<br />
 • Uno schema concettuale ed uno schema logico del database.<br />
 • La definizione delle relazioni e le seguenti interrogazioni espresse in linguaggio SQL,
 opportunamente commentate in ogni loro parte:<br />
 1. Visualizzare l'elenco di tutti gli esemplari di fauna, ordinati per specie, presenti nei
 vari parchi.<br />
 2. Visualizzare quante specie diverse di pino sono presenti in ciascun parco.<br />
 3. Visualizzare il nome della specie di animale con il più alto numero di esemplari
 censiti nei vari parchi della regione.<br /><br />
La codifica in PHP (HTML-CSS-JS) di:<br />
 • form di autenticazione (login) del guardia parco all’interfaccia web;<br />
 • una pagina per la visualizzazione del risultato di una query a scelta tra quelle proposte.<br />
 
 # Sviluppo della rete
Ipotizzando la difficoltà di una connessione di rete permanente nelle aree dei parchi naturali si
ipotizza che nel dispositivo mobile sia presente un applicazione Android, scritta in java, dove ogni
guardia, tramite due form, uno per l’inserimento di un nuovo animale ed uno per l'inserimento di
una nuova pianta, produca un file XML locale.<br />
Visto che il dispositivo mobile in dotazione serve principalmente per acquisire i dati, si può
ipotizzare che sia un dispositivo Android di vecchia generazione, per questo motivo può avere un
sistema operativo Android 7.00 o inferiori con una memoria da 16 GB.<br />
Oltre ad un dispositivo mobile, la guardia potrebbe avere un notebook su cui inviare, tramite il
protocollo Bluetooth, il file XML, per poi inviarlo al sistema centrale della Regione, dove le
informazioni verranno salvate all’interno del database.<br />
Come portatile si può pensare ad un computer di fascia medio-bassa con 4GB di RAM, 500GB di
Hard Disk e come processore un Intel Core i7 di 8th generazione con sopra Ubuntu e si può
ipotizzare l’utilizzo di FileZilla per il trasferimento dei file, utilizzando così il protocollo FTP.
Un altro sistema per inoltrare il file al sistema centrale può essere via mail, proteggendo la mail con
una firma digitale, in modo da verificare l’autenticità del mittente e impedendo così un’eventuale
alterazione del database da parte di utenti non autorizzati.<br />
Per la costruzione di questo schema di rete si è deciso di prendere in considerazione la prima
soluzione.<br />
All’interno dei parchi, vista la presenza di un unico computer, si può pensare all’installazione di uno
switch Cisco a 8 porte collegato ad un router Cisco con funzionalità di NAT, in modo che
all’indirizzo IP privato del computer (192.168.20.2) sia associato un indirizzo IP pubblico
(75.122.49.16), e Firewall, in modo che tutti i pacchetti in entrata ed uscita siano controllati, ed
all’occorrenza, filtrati.<br />
All’interno del parco, l’indirizzo di rete è il 192.168.20.0, il broadcast è il 192.168.20.255
mentre il gateway è il 192.168.20.254.<br />
All’interno del sistema centrale della Regione, lo schema di rete, si può suddividere in 2 gruppi, il
primo dov’è presente una LAN con le postazioni degli operatori, ed il secondo dove è collocata la
DMZ, al cui interno sono presenti i server HTTP, FTP ed il server a cui è collegato il database.
La LAN è collegata al router tramite uno switch Cisco a 24 porte, visto anche il maggior numero di
computer, mentre il router è un router Cisco con funzionalità di NAT e Firewall.<br />
Per i computer si può pensare a dei PC desktop con una CPU Intel Core i7 di 9th generazione con
4G di RAM e 500GB di Hard Disk con sopra Ubuntu.<br />
Per i server, si può optare di utilizzare 3 server con 2 Hard Disk da un 1TB l’uno mentre, per gli
indirizzi IP, si è scelto di dare l’indirizzo 202.168.30.1 al server che ospita il database, l’indirizzo
202.168.30.100 al server FTP, mentre invece l’indirizzo 202.168.30.200 è stato assegnato al server
HTTP che permette ai vari utenti di raggiungere l’interfaccia web tramite un qualsiasi motore di
ricerca.<br />
All’interno del sistema centrale della Regione, l’indirizzo di rete è il 202.168.30.0, il
broadcast è il 202.168.30.255 mentre il gateway è il 202.168.30.254.<br />
Si è scelto di inserire anche il database all’interno della DMZ perché, al suo interno, vengono
salvate anche le mail e le password delle guardie e, nonostante la cifratura in hash che viene fatta
alle password prima di caricarle sul database, si è optato, per evitare eventuali furti di mail
password, di inserirlo all’interno della DMZ.<br />
