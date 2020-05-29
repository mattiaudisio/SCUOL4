/*Mattia Audisio*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char descrizione[20];
    int  quantita,scadenza;
}MAGAZZINO;

typedef struct{
    char scaduto[20];
}SCADUTO;

int inserisci();
void caratteristiche(MAGAZZINO *, int );
void stampa(MAGAZZINO *, int);
void bubble(MAGAZZINO *, SCADUTO *,int);
void stampascaduti(SCADUTO*, int);

int main(){
    MAGAZZINO negozio[30];
    SCADUTO   prodscaduti[30];
    int nprodotti,num;
    nprodotti=inserisci(num);
    caratteristiche(negozio,nprodotti);
    stampa(negozio,nprodotti);
    bubble(negozio,prodscaduti,nprodotti);
    stampascaduti(prodscaduti,nprodotti);
return 0;
}

//CHIEDO IL NUMERO DEI PRODOTTI
int inserisci(){
    int Nprod;
    do{
        printf("\nInserisci il numero di prodotti --> ");
        scanf("%d",&Nprod);    
    }while(Nprod>20 && Nprod<=0);
return Nprod;
}

//CHIEDO LE CARATTERISTICHE DEI PRODOTTI
void caratteristiche(MAGAZZINO *negozio, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf("\nInserisci la descrizione del %d°prodotto [max 19 caratteri] --> ",i+1);            
        scanf("%s",negozio[i].descrizione);
        printf("\nInserisci la quantità disponibile in magazzino del %d°prodotto --> ",i+1);            
        scanf("%d",&negozio[i].quantita);
        printf("\nInserisci l'anno di scadenza del %d°prodotto --> ",i+1);            
        scanf("%d",&negozio[i].scadenza);        
    }
}

//STAMPO L'ELENCO
void stampa(MAGAZZINO *negozio, int dim){
    int i;
    printf("\nelenco\n");
    for(i=0; i<dim; i++){
        printf("%s\t %d\t %d\n",negozio[i].descrizione,negozio[i].quantita,negozio[i].scadenza);
    }
}

//INSERISCO IN UN ALTRO STRUCT I PRODOTTI SCADUTI
void bubble(MAGAZZINO *negozio, SCADUTO *prodscaduti,int dim){
      int flag,i,j;
      j=dim;
      flag=0; //0=True  1=False  
      while(flag==0){
        flag=1;
        for(i=0;i<(j-1);i++){
            if( negozio[i].scadenza<2018){
              strcpy(prodscaduti[i].scaduto,negozio[i].descrizione);  
              flag=0;
            }
        }
        j--;
      }
}

//STAMPO I PRODOTTI SCADUTI
void stampascaduti(SCADUTO* prodscaduti, int dim){
    int i;
    printf("\nProdotti Scaduti\n");
    for(i=0; i<dim; i++){
        printf("%s\t ",prodscaduti[i].scaduto);
    }
    printf("\n");
}
