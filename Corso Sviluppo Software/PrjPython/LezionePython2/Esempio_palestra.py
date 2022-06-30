# compaia un meno che mi scriva scegli la funzione:
#   1) elenco utenti
#   2) inserisci utenti
#   0) esci

import mysql.connector
import datetime


def ApriConnessione():
    try:
        return mysql.connector.connect(
            user='root',
            password='qwerty.1',
            host='localhost',
            database='schemapalestra'
        )
    except:
        print('Errore apertura connessione')


def elencoUtenti():
    mycursor.execute("SELECT * FROM utente")
    listaUtenti = mycursor.fetchall()
    for utente in listaUtenti:
        dictionaryUtenti[utente[0]] = [utente[1], utente[2], utente[3], utente[5], utente[9]]
    return


def inserisciUtenti(numeroTessera, nome, cognome, dataNascita, dataIscrizione, luogoNascita, indirizzoResidenza):
    sql = 'INSERT IGNORE INTO utente(numeroTessera,nome,cognome,luogoNascita,dataNascita,indirizzoResidenza,dataIscrizione)' \
          'VALUES (%s,%s,%s,%s,%s,%s,%s)'
    val = (numeroTessera, nome, cognome, luogoNascita, dataNascita, indirizzoResidenza, dataIscrizione)
    mycursor.execute(sql, val)
    mysql.commit()
    print(mycursor.rowcount, "record inserito")


def AggiornaUltimoversamento(numeroTessera, dataUltimoVersamento):
    sql = 'UPDATE utente SET dataUltimoVersamento = %s WHERE numeroTessera = %s'
    val = (dataUltimoVersamento, numeroTessera)
    mycursor.execute(sql, val)
    mysql.commit()
    print(mycursor.rowcount, "record modificato")


def ElencoTessereScadute():
    # per tutte le chiavi del dizionario
    elencoUtenti()
    dataOggi = datetime.date.today()
    for utente in dictionaryUtenti:
        row = dictionaryUtenti[utente]
        dataUltimoVersamento = row[4]
        if dataUltimoVersamento != None:
            delta = dataOggi - dataUltimoVersamento
            if delta.days > 30:
                print("Tessera {0} non attivata!".format(row[0]))
            else:
                print("Tessera {0} ok!".format(row[0]))
    return


def UtentiCompleannoMeseProssimo():
    elencoUtenti()
    dataOggi = datetime.date.today().month
    for utente in dictionaryUtenti:
        dataCompleanno = dictionaryUtenti[utente][3]
        if dataCompleanno != None:
            dataNascita = datetime.datetime.strptime(str(dataCompleanno), '%Y-%m-%d')
            delta = dataNascita.month - dataOggi
            if delta == 1 or dataOggi == 12 and dataNascita.month == 1:
                print("\nAugura un Buon compleanno a {0} {1} perchè il prossimo mese è il suo compleanno\n".format(
                    dictionaryUtenti[utente][1], dictionaryUtenti[utente][2]))
    return


def menu():
    while True:
        scelta = int(input(
            "\n******* MENÙ *******\n\n0) esci\n1) elenco utenti\n2) inserisci utenti\n3) Aggiorna pagamento\n4) Utenti con tessera scaduta\n5) Utenti che compiono gli anni il mese prossimo\n\nInserisci un opzione: "))
        if scelta == 0:
            print("\nProgramma Terminato")
            break;
        elif scelta == 1:
            elencoUtenti()
            for utente in dictionaryUtenti.items():
                print(utente)
        elif scelta == 2:
            numeroTessera = int(input("Numero Tessera: "))
            nome = str(input("Nome: "))
            cognome = str(input("Cognome: "))
            dataNascita = str(input("Data Nascita: "))
            luogoNascita = (str(input("Luogo Nascita: ")))
            indirizzoResidenza = (str(input("Indirizzo Residenza: ")))
            dataIscrizione = datetime.date.today()
            inserisciUtenti(numeroTessera, nome, cognome, dataNascita, dataIscrizione, luogoNascita, indirizzoResidenza)
        elif scelta == 3:
            numeroTessera = int(input("Numero Tessera: "))
            dataUltimoVersamento = datetime.date.today()
            AggiornaUltimoversamento(numeroTessera, dataUltimoVersamento)
        elif scelta == 4:
            ElencoTessereScadute()
        elif scelta == 5:
            UtentiCompleannoMeseProssimo()
        else:
            print("\nErrore: inserisci un numero corretto\n")


mysql = ApriConnessione()
mycursor = mysql.cursor()

dictionaryUtenti = {}
dictionaryUtentiConTesseraScaduta = {}

menu()
