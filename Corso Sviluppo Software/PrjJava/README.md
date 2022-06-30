# Appunti Java

In OOP ci possono essere dei puntatori ad una lista. La chiave di una lista è generalmente un numero e  questo numero prende come nome __*nomeclasseID*__. 

In un diagramma se è pubblico viene indicato con " + " e se privato con " - " ; i metodi privati iniziano con la minuscola.

I primitivi di Java sono int, float e String, il resto sono stati implementati per facilitare il lavoro al programmatore.

La classe è un'astrazione della realtà, mentre un oggetto è la concretizzazione della classe.

Una stringa è inizializzata __*null*__, un int __*0*__ ed un boolean __*False*__.

None significa __“nessun elemento selezionato”__.

Un integer è sempre 4 byte di default, un double è sempre 8 byte, un float è sempre 4 bit, string è null di default perché non so quanto può essere lunga.

In *UML*  se non ritorna niente metto __void__.

Istanzio una classe ( o istanzio un oggetto) significa che creo una classe (o un oggetto).

```
Alunno alunno1 = new Alunno();
Alunno1.inizializza();
```

se inserisco una variabile, inserisco un punto, e mi appare una lista di opzioni, vuol dire che è un oggetto.

Le classi possono avere delle variabili di classe, ovvero delle variabili che possono vedere solo le funzioni di quella classe.

il *package* è una cartella che contiene delle classi.

Le classi figlie ereditano i metodi *public*, *protected* e *package*.

Tutto quello che riguarda l’assegnazione di un variabile di classe ha un funzione che inizia o con *GET* o con *SET*

Una variabile all’interno del metodo di chiama *locale* ed ha visibilità solo all’interno di quel metodo.

L’insieme delle variabili di classe e dei metodi SET e GET, costituisce la proprietà dell’oggetto o della classe.

*" "* lo utilizzo con gli String, *' '* con i char.

__***ES***__<br />
__*FUNZIONE CLASSE ETICHETTA*__<br />

```
+ void Stampa (Alunno pAlunno){
	System.out.println(pAlunno.GetNomeCognome());
}
```

1 a 0..* significa 1 a molti nell’UML.

__*costructor*__: metodo che viene chiamato in automatico ogni volta che creo l’oggetto.  Prende il nome della classe in cui lo definisco ed è sempre VOID.

I tipi dato sono byte, int, short, long, float, double, byte, boolean e String:
- I byte sono 8 bit<br />
- L'intero classico 4 byte (32 bit)<br />
- Short sono 2 byte (16 bit)<br />
- Il long sono 8 byte (64 bit)<br />
- Il float è composto da 4 byte (32 bit) con 6/7 decimali significativi
- Il double è composto da 8 byte con 15 decimali significativi
- Il char è sempre 2 byte
- Il boolean che è sempre 1 bit 
- Lo String ha un dimensione indeterminata, quindi il suo default è *NULL*

Una funzione *static* può richiamare solo una funzione *static*.

Un metodo a distanza (metodo senza static) è richiamabile solo quando creo un ogetto, mentre un metodo di classe (metodo con static) non necessita la creazione di una classe; però un metodo a distanza può richiamare un metodo di classe mentre un metodo di classe non può richiamare un metodo a distanza. Questo discrorso vale anche per gli attributi.

__*Abstract*__ mi definisce una classe astratta, ovvero non posso più creare oggetti da questa classe ma posso estendere i suoi valori alle classi figlie (ovvero può essere il padre di altre classi).

__*Enum*__ è una keyword che mi permette di fare una scelta solo su 2 valori. Enum è una classe particolare (gestita da Java) che può contenere una lista di valori costanti. Essendo una lista di valori costanti, i programmatori gli scrivono in *MAIUSCOLO*. Ad ogni valore che possiede in realtà lui associa una costante numerica che è *0,1,2,3....*. In __enum__ il metodo *.ordinal()* consente di passare da un valore enumerato al suo indice di posizione.

__*Polimorfismo*__: é una capacità della classe e consiste nel poter definire con lo stesso nome più metodi. Quello che differenzia i metodi sono o il tipo dati o il numeri di parametri.

__*ArrayList*__: è una lista dinamica che inizia con 0 elementi. Con *.add(object)* aggiungo elementi, con *.set(index,object)* modifico un determinato elemento, con *.remove()* rimuovo un elemento, con *.size()* scopro quanti elementi contiene la lista, con *.get()* mi legge il valore contenuto nella posizione e con *clean* pulisco la lista

In Java per gli input utilizzzo la classe Scanner, importandola tramite il comando *import java.util.Scanner;*. Se devo ricevere una Stringa scrivo *nextline()*, se devo ricevere un intero scrivo *nextInt*.

```
String: objScanner.nextLine();
int: objScanner.nextInt();
```

__*Package*__ significa che tutti i metodi e le variabili presenti sono visibili all'interno del package (cartella che contiene un insieme di classi).

Il *costruttore* è un metodo che viene richiamato ogni volta che creo l'oggetto.

L'*ArrayList* è una classe che ha come __interffacia__ *List* che mi permette di crescere dinamicamente.

L'*Interfaccia* mi permette di __definire__ ( definire/dichiarare un metodo senza nessun codice dentro, ovvero termino con "__;__" *es. String getNome(); __oppure__ setNome(StringNome);*) una struttura simile a una classe, ma può contenere __*SOLO*__ metodi d'istanza astratti e costanti (quindi non può contenere costruttori, variabili statiche, variabili di istanza e metodi statici). Mi serve perché mi può permettere che delle classi che non hanno parenti in comune abbiano dei metodi scritti allo stesso modo e che si possono scambiare fra di loro.

__*Override*__ ridefinisce il metodo di un'antenato

I *pattern* sono delle soluzioni a delle problematiche che sono già risolte da qualcuno. Nella programmazione ad oggetti, il singleton è uno dei pattern fondamentali. Il singleton è un design pattern creazionale che ha lo scopo di garantire che di una determinata classe venga creata una e una sola istanza, e di fornire un punto di accesso globale a tale istanza.

Una __*classe anonima*__ è una classe “*locale*” senza un nome assegnato, si tratta di una classe definita e instanziata un’unica volta attraverso una singola espressione caratterizzata da una versione estesa della sintassi dell’operatore *new*.

```
public abstract class ClasseAstratta {
	public abstract void print();
	
	public static void main(String[] args) {
		ClasseAstratta abc = new ClasseAstratta() {
			@Override
			public void print() {
				System.out.println("print implementazione classe anonima [Non c'è sto a capì er senso]");
			}
		};
	}
}
```

Se ho una stringa al cui interno sono presenti degli spazi e usando il *.trim* gli tolgo tutti gli spazi non significativi a destra ed a sinistra

```
String frase = "    Ciao     ";
System.out.println(frase.trim);		// Stampa 'Ciao' senza gli spazi
```
__Wrapper class__

I tipi dati primitivi sono *byte*, *short*, *int*, *long*, *float*, *double*, *boolean*, *char*. Ad ogni dato primitivo corrisponde una *Wrapper Class* e, tolto *Integer* per int, tutte le altro hanno il nome del tipo dato ma con la iniziale maiuscola (perché in Java le classi si dichiarano con la prima lettera maiuscola).

```
private static void castInt() {
	String s = "101";
	String s2 = "1000";
	
	// ** "somma" le due stringhe ovvero le unisce
	System.out.println(s+s2);
	
	// ** conversione stringhe in intero e somma
	// ** si deve usare la wrapper class Integer perché non è possibile
	// ** fare il casting da stringa a intero (ma neppure a qualunque altro tipo
	// ** dato numerico)
	// ** int in1 = (int)n1; non è possibile
	int i1 = Integer.parseInt(s);
	int i2 = Integer.parseInt(s2);
	int iTotale = i1+i2;

	// *****************************************
	
	int ii = Integer.parseInt(s);
	long ll = Long.parseLong(s);
	short ss = Short.parseShort(s);
	double dd = Double.parseDouble(s); 
	float ff = Float.parseFloat(s);
	byte bb = Byte.parseByte(s);
		
	System.out.println(ii);
	System.out.println(ll);
	System.out.println(ss);
	System.out.println(dd);
	System.out.println(ff);
	System.out.println(bb);
}
```

# Java con MySQL

per utilizzare classi che comunicano con mysql uso 

```
java.sql.*
```
dove l'asterisco sta per tutte le classi presenti.

JDBC è la classe di Java per accedere ai database. É scritta in Java. Per farlo i JBC driver devono essere corretti. Hanno l'estensione .jar.
Bisogna collegare quello che ci serve (mysql.jar) al progetto che dovremmo sviluppare.

Per programmare con SQL in Java sono indispensabili 3 cose:

1) una connessione ad DB __*(class Connection)*__
2) una tipologia di oggetti che ci permetta di inviare comandi alDB  __*(class Statement)*__
2) una tipologia di oggetti che ci permetta di ottenere il risultato/la selezione/una lista di record (Recordset - ResultSet) per poter essere poi elaborata  __*(class ResulSet)*__

Java, quando lavoriamo con l'SQL, ci obbliga ad utilizzare il costrutto

```
try {
	Creare gli oggetto del DB e utilizzo
} catch {
	Intercettuare vari errori
} 
finaly {
	ResulSet Close() [oggetto lista tornato da una SELECT]
	Statement close() [oggetto per inviare i comandi]
	Connection close() [aprire/gestire una connessione al db]
}
```

"jdbc:mysql:" registra il drive ed indica a Java quale drive utilizzare

```
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nomeDatabase?serverTimezone=UTC", "root", "qwerty.1");
```

L'inidirizzo di __localhost__ è 127.0.0.1.

Per aggiungere un file __.jar__ clicco col tasto destro sulla cartella del progetto -> properties -> Java Build Path (<ona *Libraries*) -> clicco su ModulePath -> Add exteral Jars -> __*C:\Program Files (x86)\MySQL\Connector J 8.0*__

Gli execute che ci possono servire sono:

- ExecuteQuery(String) { serve per eseguire le query *SELECT* e ritorna oggetti ResultSer }
- ExecuteUpdate(String) { serve per eseguire le query *INSERT*/*UPDATE*/*DELETE* e ritorna un int che corrisponde al numero dei record modificati }
- Execute(String) {  serve per eseguire le query *CREATE*/*ALTER*/*DROP* e ritorna un boolean }

__*Glossario*__

```
/*1 CONNESSIONE AL DATABASE*/
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nomeDatabase?serverTimezone=UTC", "root", "qwerty.1");
System.out.println("Connessione eseguita");

/*2 CREAZIONE DELLO STATEMENT*/
Statement stmt = conn.createStatement();
System.out.println("Statement creato");
			
/*3 INVIO DELLA QUERY*/
String query = "SELECT customer_id,first_name,last_name FROM customer";
ResultSet rows = stmt.executeQuery(query);
System.out.println("Query eseguita");
	
/*4 lETTURA ResultSet*/
System.out.println("\n**ELENCO TRATTO DA CUSTOMER**");
while(rows.next()) {
	System.out.println("id:"+rows.getInt(customer_id)+" Nome:"+rows.getString(first_name)+" Cognome:"+rows.getString(last_name));
}
```

# Grafica in Java

In questo caso stiamo parlando di __*Librerie Java*__. All'inizio si utilizzava il package __AWT__ (*Abstract Window Toolkit*), surclassato poi dalla libreria __Swing__ che, a differenza di AWT, è totalmente scritto in Java; Tuttavia Swing è più un estensione di AWR che un sostituto, infatti al suo interno ha implementato anche dei pacchetti di AWT.<br />
Noi utlizziamo le Classi __*JFrame*__ (utilizzata per costruire la finestra principale perché è l'unica che può decidere che quando chiudo la finestra mi termina anche l'applicazione), __*JDialog*__ (utilizzata per gestire i form e non può chiudermi l'apllicazione quando chiudo la finestra) e __*JInternalFrame*__ (utilizzata nella gestione delle finestre che non possono uscire da determinato contesto che di solito è gestito da JFrame).<br />
Le costanti che mi servono sono:
- EXIT_ON_CLOSE (Exit the apllication)
- HIDE_ON_CLOSE (Hde the frame, but kepp the application running)
- DISPOSE_ON_CLOSE (la usa di default; dispose of the frame object, but keep the application running)
- DO_NOTHING_ON_CLOSE (ignore the click)

Un __*interfaccia*__ è un insieme di definizioni di metodi. Questi metodi sono tutti pubblici.

É possibile che in determinate situazioni debba dichiarare una classe all'interno di un'altra classe. quella __principale__ deve essere o *public* o *package*, mentre le __classi interne__ possono essere *public*, *private*, *protected* e *package*.

Se utilizzi Eclipse è consigliato utilizzae il plugin [WindowBuilder](https://www.eclipse.org/windowbuilder/). Per installarlo andare su Eclipse e premere *Help*>*Install New Software* ed incollare in Work with il [questo link](http://http://download.eclipse.org/windowbuilder/latest/), selezionare __WindowBuilder__ e poi premere su Next.

Con la parte grafica si parla anche della __*[Programmazione ad Eventi](https://it.wikipedia.org/wiki/Programmazione_a_eventi)*__.

__*sintassi*__:

- txt (*Text*)
- btn (*Button*)
- chb (*CheckButton*)
- chk (*CheckBox*)
- rbt (*RadioButton*)
- lbl (*Label*)
- pan (*Pannel*)

con *JOptionPane* se l'utente schiaccia *sì* ritorna __0__, se schiaccia *annulla* gli ritorna __1__ mentre se chiude la finestra dalla *X* gli torna __-1__

Se voglio riempire lo scrollPane con la table devo andare nella funzione FramteTable e, dove creo la table, inserisco:

```
this.table.setFillsViewportHeight(true);
```

# Gestione della data in Java

- java.util.date (quella più datata - cercheremo di non usarla, oggi la meno usata)
- java.sql.date (è utilizzata da JDBC - librerie java utilizzate con il database)
- java.time.LocalDate (è la classe più recente per la gestione delle date, ed è quella che cercheremo di utlizzare sempre)

Questo significa che quand avremo bisogno di un attributo data nelle classi utilizzeremo LocalDate, tipo:

```
private LocalDate data;
```
in Java una data di default è tipo *"yyyy-MM-dd"* mentre in Italia e in generale nell'EU le date sono espresse come *"dd/MM/yyyy"*

Se voglio avere la data attuale:
```
LocalDate oggi = LocalDate.now();
```
Se voglio creare un oggetto che ha una determinata data:
```
LocalDate dt = LocalDate.of(yyyy, MM, dd);
```
La classe DateTimeFormatter permettete di modificare il formato in cui vedere le date
```
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
```

*isLeapYear()* ci permette di sapere se l'hanno è bisestile, *lengthOfMonth()* ci torna i giorni per mese.


Costruttori e metodi
```
Costruttori
JFormattedTextField()
JFormattedTextField(JFormattedTextField.AbstractFormatter formatter)
JFormattedTextField(JFormattedTextField.AbstractFormatterFactory factory)
JFormattedTextField(JFormattedTextField.AbstractFormatterFactory factory, int currentValue)

protected void processFocusEvent (final FocusEvent e)
permette di intercettare la perdita e il "guadagno"/"ottenimento" del focus (Un controllo ottiene il focus quando diventa un controllo attivo o quando avviene la attivazione o deattivazione di una finestra)


Metodi
Object getValue()
setFocusLostBehavior(int behavior)
setValue (Object value)
```
