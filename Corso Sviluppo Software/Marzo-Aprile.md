# Marzo

__requisiti__:

- python installato
- pip installato (__*PACKAGE MANAGER*__ strumento che permette di installare softaere scritto in Python {pacchetti con codice.py} -> Le nostre applicazioni portanno sfruttare codice di altri progetti/librerie esterne di cui possiamo sfruttare le funzionalità: DON'T REPEAT YOUR SELF (NON RIPETERE/RISCRIVERE COSE GIÀ FATTE MEGLIO).. SE POSSIBILE SFRUTTARE QUANTO SCRITTO DA TEAM SVILUPO. NELLA COMUNITÀ OPEN SOURCE CI SONO MOLTI PROGETTI UTILIZZABILI E SCRITTI DA TEAM DI PIÙ PERSONE. IN FUTURO POTRETE GENERARE ANCHE IL VOSTRO PACCHETTO PER IL VOSTRO PROGETTO)
- Windows Powershell
- Bisogna sempre applicare le best practices (bisogna sempre fare le cose al meglio)


La differenza tra backend e frontend è che backend è il codice nascosto che permmette le logiche del programma, ovvero andrà a manipolare i miei dati (es. java è tutto in backend. .jar che è il sorgente (Logica Server)). La manipolazione del database è sicuramente backend. il frontend è, ad esempio, la pagina web. Il frontend è lo strumento utilizzato dall'utente finale.
Sviluppatore che sia backend che frontend viene detto *full-stack developer*.

*backend*:
- Core Feature Developer (sviluppa le funzionalità principali dell'applicazione)
- Security Team

*frontend*:
- Designer (Cura l'aspetto grafico tramite bozzetti (mockup) e loghi, gif, stickers)
- Sviluppatori Frontend (Javascript)
- CSS (Fogli di stile -> strumenti per ancorare e posizionare le parti all'interno della pagina web)
- HTML5 (La pagina web statica)

Il backend partecipa alla creazione della pagina web, il backend manipola, insierisce, o crea da zero la pagina web in .html. Una pagina HTML è statica di per se non permette la manipolazione dell'utente.

*Sorvoliamo*<br />
```
Il software ha continuo sviluppo e rende dondamentale il "file versioning". la storicizzazione dei file e la marcatura delle versioni successive/precendenti.
esempio:

team sviluppo denominato TSS
Paolo (capo)
Giuseppe
Ernesto

- modo per unire il codice
- modo per capire chi fa cosa
  - modo per capire chi ha rotto cosa
  - i progressi di ciascuno
 
 LINUS TORVALDS -> Kernel Linux (CORE dei Sistemi Operativi GNU/LINUX)
 Ha dovuto far entrare persona nel team di sviluppo, zip (.tar) il problema è che bisogna capire dove sono le modifiche, si aiutavano son u software DIFF (Differenze tra due File) Modifiche
 unire il codice (Merging)
 Non siamo sicuri che il frankstein riunito funzioni -> farsi una cartella e provare prima di unire (Ambiente di prova) -> Staging
 
 GIT -> permette di fare tutte le cose di cui sopra
 - Creare utenti (capire chi fa cose)
 - Dare privilegi (se uno è pericoloso gli faccio tocare il meno possibile)
 - Proporre modifiche (commit)
 - Se sei il capo approvare le modifiche
 - Visionare chiaramente le modifiche (una visualizzazione semplificata)
 - Creare delle sotto versioni (Branch) -> si possono fare delle prove -> rami di sviluppo
 - Se le cose vanno bene riunite il ramo di sviluppo a quello principale (Merge) -> Ramo principale viene detto Master Branch
 - Se le cose vanno male buttate via (Dead End)
 
 Avremo il versioning delle release (Versioni del Software):
 TSS X.Y.Z
    -> X Main Release (Se incremento questo numero sto facendo un balzo di sviluppo)
    -> Y Feature Improvements (Inserimento di nuove funzionalità)
    -> Z Bug Fixes (Rimozione di errori nel SW)
    
 2.3.0 -> Major Release 2
       -> Ho fatto 3 sotto versioni di implementazione di funzionalità
       -> 0 per ora nessuna piccola modifica/correzzione di bug
       
 GIT:
 -> Versione locale (repo locale)
 -> versione su server (repo remoto)
 
 Ogni sviluppatore può fare in locale tutto quello che vuole senza farlo vedere al team di sviluppo
 
 es:
 DOOR SPA
 SAM ha un suo computer e vuole sviluppare con JOEY e BRAN, ci sarà un server su GITHUB dove ci sarà il MASTER con tutto il software in produzione (sta girando per dei clienti).
 
SAM farà il PULL (tirare) dal server (ORIGIN), prenderà l'ultima revisione del master, con tutto il codice aggiornato! Quindi il codice sarà in locale sul suo PC. Da adesso in avanti il codice risiede solo sul PC di SAM NON É AUTOMATICAMENTE AGGIOANTO SUL MASTER.
Ogni volta che SAM farà modifiche GIT lo capirà, e git "chiederà" di fare un commit prima o poi (ci sono delle modifiche "pending" in attesa) -> posso anche qui fare il commit solo in locale! Se poi voglio metterlo sul SERVER faccio una richiesta di COMMIT (se non ho privilegi -> sono un SAM qualunque) e se viene approvato verrà unito al master. Devo fare un operazione di PUSH del commit.
FINTANTO che non eseguo un COMMIT posso fare il DISCARD delle modifiche (le butto via per sempre) se invece faccio un COMMIT posso sempre tornare indietro "riscaricando" dal commit precedente (ROLLING). 
```
*ripasso comandi PowerShell*
- cd cartella -> entro nella cartella
- ls -> fammi vedere cosa c'è dentro la cartella
- mkdir cartella -> make directory -> crea cartella

# PIP PYTHON
Voglio creare un nuovo sito con Django e Python:<br /> 
Vado nella cartella dove voglio creare il sito:

- cd C:\
- mkdir C:\TSS
- cd C:\TSS
- py.exe -m django startproject nome_del_sito

es:<br />
Voglio creare l'applicazione ticket<br />py.exe -m django-admin startproject ticket-tss


*Scaffoldin*: mi crea una serie di cartelle, con all'interno codice di base, struttura di una web app di partenza. Mi crea la base per il mio progetto.<br />
*Framework*: Vi aiuta a creare una qualcosa in modo strutturato, vi da gli strumenti per avere una base comune con altri sviluppatori.

il backend è il python mentre il frontend è in HTML5,CSS,JS

- py.exe -m django startproject mysite
- cd mysite
- py.exe manage.py runserver

http://127.0.0.1:8000/


Se vogliamo aggiungere delle parti comuni a più pagine

```
py.exe manage.py startapp polls
```

# Aprile

Nello sviluppo dele apllicazioni web sono presenti parti *frontend* (HTML5+CSS) e *backend* (DJANGO, scritto in PYTHON).<br />

Framework *MVC* (Model View Controller)<br />
- Model -> "Database" la struttura dei nostri dati
- View -> Vista (FRONTEND) quando visualizzato dall'utilizzatore finale
- Controller -> La parte di codice backend che ci porterà la parte "dinamica" dell'apllicazione

HTML -> statico, il programmatore scrive un codice che verrà interpretato dal browser -> l'HTML viene scaricato in chiaro dal browser -> non è nascosto ai nostri occhi<br />
Se vogliamo avere una parte dinamica abbiamo bisogno di un sorgente che generi a piacere parti di HTML (__NON STIAMO PARLANDO DI JAVASCRIPT IN QUESTO MOMENTO__). Parto da una richiesta fatta dall'utente di visualizzare una pagina web; questa richiesta va ad un server web; una parte della pagina sarà già pronta una parte verrà integrata.


quando facciamo *"girare"* la nostra web app in django utilizzando il comando:

```
py.exe manage.py runserver
```

stiamo dicendo a python di generare delle pagine web a partire da codice python! In particolare l'istruzione "runserver" fa partire un mini server web sul nostro computer! (http://127.0.0.1:8000).<br />L'indirizzo 127.0.0.1 è chiamato *localhost (host locale)* ed è l'indirizzo IP del nostro PC.<br />
Normalmente le pagine web le visualizzo con un nome di dominio. Se vado su google.com, il nome viene tradotto/risolto da un server chiamato *DNS
(Domain Name Solver)* che traduce il nome di un indirizzo IP ed è un indirizzo numerico unico a livello mondiale (se parliamo di *IP STATICO*).
Gli *IP dinamici* cambiano alla disconessione da internet, gli *IP statici* sono permanenti e identificano una connessione in maniera univoca (affittati al mese/anno).

Dentro la mia web app ho delle cartelle/directory; quando provo a visualizzare una parte della mia web app che si trova in una sotto-cartella, dovrò evere delle regole che a partire da un percorso (*http://127.0.0.1:8000/polls/*) mi faccia vedere una pagina web!<br />
views.py avrà all'interno le regole per la visualizzazione della parte di "VISTA" della mia app nella sezione POLLS.

il file *urls.py* mi andrà a cercare se esiste la view relativa a *Home_page* nel file views.py, se la trova andrà a visualizzarmi una pagina web!

```
from django.shortcuts import render
from django.http import HttpResponse

def index(request):
  return HttpResponse("CIao a tutti!")
```

![basic-django](https://user-images.githubusercontent.com/57859960/113871416-2b84dd80-97b3-11eb-85db-f6b1f1e6a8f9.png)<br />
Immagine presa [qui](https://developer.mozilla.org/it/docs/Learn/Server-side/Django/Home_page).

Se vogliamo aggiungere delle parti comuni a pagine web possiamo creare dei Template in HTML.
