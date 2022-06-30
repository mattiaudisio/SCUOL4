#------------------------------#
#questo è un programma di prova#
#------------------------------#

print ("Aula")
#Print ("qui errore")
print ("Informatica 1")

################################################################################

################################################################################
#                                                                              # 
#                           N1 ^ N" si scrive N1**N2                           #
#                                                                              # 
################################################################################

################################################################################

saldoBanca = 5600
prelievoBancomat = 600

saldoBanca = saldoBanca - prelievoBancomat
print ( saldoBanca , type ( saldoBanca ) )

################################################################################

a = 3
b = 11

print ( a + b )
# print ( c + 3 )
print ( a + 3 )
print ( 3 + b )

################################################################################

SEPA = ":"
VALUTA = "€"

nome = "Andrea"
cognome = "Rossi"
indirizzo = "Via Milano 34"
cap = "12309"
provincia = "(CN)"

print( nome , cognome ) #così posso stampare anche una string accanto ad un int
#print( nome + cognome ) mi fa l'unione delle stringhe il problema è che
#li scive attaccati, quindi mi conviene scrivere print(nome+" "+cognome)

nomeCognome = nome + SEPA + cognome
prezzo = 123.45
sprezzo = str(prezzo) #+ VALUTA
print ( nomeCognome )
print ( indirizzo + SEPA + cap + SEPA + provincia )
print ( "prezzo: " + sprezzo ) #può solo concatenare stringhe con altre stringhe

iprezzo = int( float(sprezzo) )
fprezzo = float (sprezzo)
print (iprezzo) 
print (fprezzo)

################################################################################

iV = 100
fV = 110.0
sV = "giardino"
bV = True

print ( "Tipo dato iV:" , type(iV) )
print ( "Tipo dato fV:" , type(fV) )
print ( "Tipo dato sV:" , type(sV) )
print ( "Tipo dato bV:" , type(bV) )

################################################################################

i = 10
b = 5
c = 4
d = 7.0
e = 8

print ( i / b , type ( i / b ) )
print ( i // b , type ( i // b ) )
print ( i * b * c * d * e , type ( i * b * c * d * e ) ) 

################################################################################

################################################################################                                                                                    
#                                                                              #         
#  PROGRAMMA:                                                                  #         
#      a = 5                                                                   # 
#      b = ? 10                                                                #         
#                                                                              #     
#      se a = b                                                                # 
#          print ("a e b sono uguali")                                         # 
#                                                                              # 
#      =====================================                                   # 
#                                                                              # 
#        date due variabili a e b                                              #
#        IF a = b                                                              #                         
#            allora print (...)                                                #
#                                                                              #         
################################################################################

a = 0
b = 0

#----------------------------

a = 5

while b == 0 or b > 10 :
    b = int( input( "Inserisci un numero tra 1 e 10: " ) )

#----------------------------

if a == b :
    print ( "a = b",a,b)
    print ( str(a) + " = " + str(b) )
else:
    print ( "I valori non sono uguali" )
    
################################################################################

################################################################################
#                                                                              #
#                            \n    \"  \'  \\  \t                              # 
#                                                                              #
################################################################################

################################################################################
#                                                                              #
#                            \" ... "\ prende le                               #
#                         virgolette come carattere                            #  
#                                                                              #
################################################################################

################################################################################
#                                                                              #
#                            >   confronto se maggiore                         # 
#                            >=   confronto se maggiore o uguale               # 
#                            <   confronto se minore                           # 
#                            <=   confronto se minore o uguale                 # 
#                                                                              #
################################################################################

################################################################################

primo = 0
secondo = 0
VALUTA = " € "

#------------------------

primo = float ( input ( "Dammi un valore:" ) )
secondo = float ( input ( "Dammi un valore:" ) )

#------------------------

print ( "Totale: " + str ( primo + secondo) )
print ( "Divisione // :" , int ( primo // secondo ) )
print ( "Moltiplicazione * :" , str( int ( primo * secondo ) ) + VALUTA )

################################################################################

#----------------------------#
#prova confronto tra stringhe#
#----------------------------#

a = ""
b = ""

#----------------

#a = float ( input ( "valore a: " ) )
#b = float ( input ( "valore b: " ) )

a = input ( "valore a: " )
b = input ( "valore b: " )

#Se metto dei numeri come stringhe mi conta solo il primo come carattere

if a == b :
    print ( "a uguale a b" )    
elif a < b:
    print ( "a minore di b" )        
elif a > b:
    print ( "a maggiore di b" )                
else:
    print ( "opzione non considerata" )    

################################################################################

########################################
#                                      #
#            result = input            #
#            if result > 50            #
#               print ...              #
#            if result > 60            #
#	            print ...          #
#	            qualcosa d'altro   #
#            if result > 40            #
#	            print ...          #
#            if result > 90	       #
#	            print ...          #
#                                      #
########################################


result = float ( input ( "Inserisci un valore numerico: " ) )

if result > 90:
    print ( "Valore maggiore di 90\tValore: " + str ( result ) )
elif result > 60:
    print ( "Il dato inserito ", result , " è maggiore di 60" ) 
    print ( input ( "Ciao. Questo comando fa qualcosa, prova a scrivere:" ) , "\nVisto che ha fatto qualcosa ;)" )
elif result > 50:
    print ( "result > 50\tValore: " + str ( result ) )
elif result > 40:
    print ( "Valore di result maggiore di 40\tValore: " + str ( result ) )
else:
    print ( "Condizione non consentita" )

#----------------------------------------------------------------------       

result = float ( input ( "Inserisci un valore numerico: " ) )

if result > 40:
    print ( "Valore di result maggiore di 40\tValore: " + str ( result ) )
    if result > 50:
        print ( "result > 50\tValore: " + str ( result ) )
    if result > 60:
        print ( "Il dato inserito ", result , " è maggiore di 60" ) 
        print ( input ( "Ciao. Questo comando fa qualcosa, prova a scrivere:" ) , "\nVisto che ha fatto qualcosa ;)" )
    if result > 90:
        print ( "Valore maggiore di 90\tValore: " + str ( result ) )
else:
    print ( "Condizione non consentita" )

##################################################################################################

t = True
f = False

apriPorta = t
siediti = f
esisteSedia = f

if ( apriPorta == t and siediti == f ):
    if (esisteSedia):
        siediti = t

if ( apriPorta == t and siediti == t ):
    print ( "Sono in auto" )

##################################################################################################

a = 3
b = 7
c = 5
z = 5

#------------------------

if ( a > 10 and b < 6 ) and ( c == 5 or z < 6 ):
    print ( "condizione verificata" )
else:
    print ( "condizione non verificata" )
    
if ( a > 10 and b < 6 ) or ( c == 5 or z < 6 ):
    print ( "condizione verificata" )
else:
    print ( "condizione non verificata" )

##################################################################################################

flag = False
nClienti = 1

#-------------- PROCEDURA --------------
def stampaBuongiorno ():    
    somma = 10 + 5
    print ( "Buongiorno a tutti" )
    # altro codice
    # if else elif

#-------------- FUNZIONE --------------
def fnStampaBuongiorno ():  
    print ( "Buongiorno a tutti (funzione)" )
    somma = 10 + 5
    return somma    

def stampaScontrino(nClienti):
    if(nClienti == 1 or nClienti == 5):
        v = fnStampaBuongiorno()
        print ( "Sconto per domani " + str ( v ) )
    print ( "Scontrino nr " + str(nClienti))
    print ( "Pane 14,00 €" )
    print ( "Olio 20,00 €" )
    print ( "Totale 34,00 €\n*************************************" )
    scontrinoStampato = True
    return scontrinoStampato

def condizione():
    if ( flag == True ) :
        print ( "scontrino stampato\n" )
    else:    
        print ( "Registratore di cassa rotto\n" )
        
while (nClienti < 6):
    flag = stampaScontrino( nClienti )
    nClienti += 1
    condizione()

stampaBuongiorno()    
v = fnStampaBuongiorno()
v2 = v + 5
print ( v )
print ( v2 )
print ( fnStampaBuongiorno() )

##################################################################################################

#Raddoppiare un numero intero se è minore di 100 (e maggiore di zero), triplicarlo se è maggiore di 100, o farne il quadrato se è 100.

numero = int( input ( "Inserisci un numero:" ) )

if ( numero < 100 and numero > 0 ):
    print ( "Il risultato è:" , str( numero * 2 ) , "\n" )
elif ( numero > 100 ):
    print ( "Il risultato è:" , str( numero * 3 ) , "\n"  )
elif ( numero == 100 ):
    print ( "Il risultato è:" , str( numero * numero ) , "\n"  )
else:
    print ( "Inserisci un numero maggiore di zero\n" )
    
##################################################################################################

print ( "programma terminato" )
