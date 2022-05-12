#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void fatture(int, int, int, int);
void giornoPaga(int, int, int, int);

int main(){
    int i,numFatture,dataAttualeG,dataAttualeM,dataEmissioneG,dataEmissioneM,dataScadenzaG,dataScadenzaM,dataemissioneCG,dataemissioneCM;
    printf("\nInserisci il numero della fattura \n");
    scanf ("%d",&numFatture);
    printf("\nInserisci la data attuale, giorno-mese \n");
    scanf ("%d-%d",&dataAttualeG, dataAttualeM);
    for(i=0; i<numFatture; i++){
        printf("\nInserisci la data di emissione della fattura, giorno-mese \n");    
        scanf("%d-%d",&dataEmissioneG, dataEmissioneM);
        printf("\nInserisci la data di scadenza della fattura, giorno-mese \n");    
        scanf("%d-%d",&dataScadenzaG, dataScadenzaM);
        printf("\nInserisci la data attuale, giorno-mese \n");
        scanf ("%d-%d",&dataAttualeG, dataAttualeM);
		fatture(dataAttualeG, dataAttualeM, dataEmissioneG, dataEmissioneM);        
    }
    for(i=0; i<10; i++){
        printf("\nInserisci la data di inizio consulenza, giorno-mese \n");    
        scanf("%d-%d",&dataemissioneCG, dataemissioneCM);
		giornoPaga(dataemissioneCG, dataemissioneCM, dataAttualeG, dataAttualeM);
    }
return 0;
}

void fatture(int dataEmissioneG, int dataEmissioneM, int dataScadenzaG, int dataScadenzaM ){
        int mese,scadenza;
        mese=(dataEmissioneM-1)*30;
        dataScadenzaG=(dataScadenzaG-1)*30;
        scadenza=(dataScadenzaG-dataEmissioneG)-(dataScadenzaM-dataEmissioneM);
        printf("mancano %d giorni alla scadenza della fattura\n",scadenza);
}

void giornoPaga(int dataemissioneCG, int dataemissioneCM, int dataAttualeG, int dataAttualeM){
        int paga;
        paga=(dataAttualeG-dataemissioneCG)-(dataAttualeM-dataemissioneCM);
        printf("manca %d giorni al giorno di paga\n",paga);
}



