import mysql.connector
import datetime


def ApriConnessione():
    try:
        return mysql.connector.connect(
            user='root',
            password='qwerty.1',
            host='localhost',
            database='palestra'
        )
    except:
        print('Errore apertura connessione!')


def ElencoUtenti():
    dictionaryUtenti.clear()

    sqlQuery = "select * from utenti"

    mycursor.execute(sqlQuery)
    listaUtenti = mycursor.fetchall()

    for utente in listaUtenti:
        dictionaryUtenti[utente[0]] = [utente[1], utente[2], utente[3], utente[5], utente[9]]
    return


def InserisciUtente(numeroTessera, cognome, nome):
    sqlQuery = "insert into utenti( numeroTessera, cognome, nome) values (%s, %s, %s)"
    # sqlQuery = "insert into utenti( numeroTessera, cognome, nome) values ({0}, %s, %s)".format(numeroTessera)
    utente = (numeroTessera, cognome, nome)

    mycursor.execute(sqlQuery, utente)
    mysql.commit()
    return


def InserisciUtenteEstesa(numeroTessera, cognome, nome, dataNascita, dataIscrizione):
    sqlQuery = "insert into utenti( numeroTessera, cognome, nome, dataNascita, dataIscrizione) values (%s, %s, %s, %s, %s)"
    utente = (numeroTessera, cognome, nome, dataNascita, dataIscrizione)

    mycursor.execute(sqlQuery, utente)
    mysql.commit()
    return


def InserisciUtenti(utenti):
    sqlQuery = "insert into utenti( numeroTessera, cognome, nome) values (%s, %s, %s)"
    mycursor.executemany(sqlQuery, utenti)
    mysql.commit()

    return


def AggiornaDataUltimoVersamento(numeroTessera, dataUltimoVersamento):
    sqlQuery = "UPDATE utenti SET dataUltimoVersamento = %s WHERE numeroTessera = %s"
    tessera = (dataUltimoVersamento, numeroTessera)
    mycursor.execute(sqlQuery, tessera)
    mysql.commit()
    return


def UtentiConTesseraScaduta():
    dictionaryUtentiConTesseraScaduta.clear()

    dataOggi = datetime.date.today()
    # per tutte le chiavi del dizionario
    for utente in dictionaryUtenti:
        # utente è key, utente_valori è value (ovvero i 'dati')
        utente_valori = dictionaryUtenti[utente]
        # utente_valori[4] è il campo corrispondente a dataUltimoVersamento
        if utente_valori[4] != None:
            # converto da stringa a datetime
            dt = datetime.datetime.strptime(str(utente_valori[4]), '%Y-%m-%d')
            # converto da datetime a datetime.date
            dataUltimoVersamento = datetime.date(dt.year, dt.month, dt.day)
            delta = dataOggi - dataUltimoVersamento
            if delta.days > 30:
                print("{0} {1}: SCADUTA!".format(utente_valori[0], dataUltimoVersamento))

                dictionaryUtentiConTesseraScaduta[utente] = utente_valori
            else:
                print("{0} {1}: OK".format(utente_valori[0], dataUltimoVersamento))
        else:
            print("{0}: SCADUTA! dataUltimoVersamento nulla!".format(utente_valori[0]))

            dictionaryUtentiConTesseraScaduta[utente] = utente_valori

    return


# apertura connessione
mysql = ApriConnessione()
mycursor = mysql.cursor()

dictionaryUtenti = {}
dictionaryUtentiConTesseraScaduta = {}

while True:
    print('1 - Elenco utenti')
    print('2 - Inserisci utente')
    print('3 - Inserisci utenti')
    print('4 - Inserisci utente estesa')
    print('5 - Aggiorna pagamento')
    print('6 - Utenti con tessera scadute')

    print('0 - Esci')
    scelta = input('Scelta: ')
    if scelta == '1':
        ElencoUtenti()

        for utente in dictionaryUtenti.items():
            print(utente)
    elif scelta == '2':
        numeroTessera = int(input('Numero tessera: '))
        cognome = input('Cognome: ')
        nome = input('Nome: ')

        InserisciUtente(numeroTessera, cognome, nome)
    elif scelta == '3':
        utenti = [(1121, 'a', 'b'), (1122, 'c', 'd')]
        InserisciUtenti(utenti)
    elif scelta == '4':
        numeroTessera = int(input('Numero tessera: '))
        cognome = input('Cognome: ')
        nome = input('Nome: ')
        dataNascita = input('dataNascita: ')
        dataIscrizione = datetime.date.today()

        InserisciUtenteEstesa(numeroTessera, cognome, nome, dataNascita, dataIscrizione)
    elif scelta == '5':
        numeroTessera = int(input('Numero tessera: '))
        AggiornaDataUltimoVersamento(numeroTessera, datetime.date.today())
    elif scelta == '6':
        UtentiConTesseraScaduta()

        for utente in dictionaryUtentiConTesseraScaduta.items():
            print(utente)
    else:
        break
