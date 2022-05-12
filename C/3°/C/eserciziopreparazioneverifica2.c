/*Creare un programma che permetta di:
- caricare due vettori paralleli (uno con l'iniziale del nome della persona [tutte diverse], il secondo vettore con la sua altezza [casualmente da 150 a 195])  FATTO
- stampare entrambi i vettori   FATTO
- ordinare i vettori in modo parallelo basandosi sulle altezze (dal più alto al più basso)  FATTO
- data una altezza specificata dall'utente cercare e visualizzare l'iniziale delle persone con altezza maggiore di quella   FATTO
- Data una iniziale, ricercare l'altezza relativa   FATTO
*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void carica(int *, int );
void crea(int *, int );
void stampa(int *,  int);
void bubble(int *, int *, int);
void scambia(int *, int *, int *, int *);
void cercaltezza(int *, int *, int);
void altezzamaggiore(int *, int); 


int main(){
    int persona[100],altezza[1000],N;
    printf("\nNumero persone ");
    scanf("%d",&N);
    carica(persona,N);
    crea(altezza,N);
    stampa(persona,N);
    printf("\n");
    stampa(altezza,N);
    bubble(altezza,persona,N);
    printf("\n");
    altezzamaggiore(altezza,N);
    cercaltezza(persona,altezza,N);

return 0;
}

void carica(int *persona, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf("\nInserisci l'iniziale del nome ");
        scanf("%d",&persona[i]);
    }
}

void crea(int *altezza, int dim){
    int i;
    for(i=0; i<dim; i++){
      altezza[i]=rand()%346+150;
    }
}

void stampa(int *V, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf(" %d |  ",V[i]);
    }  
}

void bubble(int *V, int *V2, int dim){
    int i=0,j,flag=0;
    j=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(j-1); i++){
            if(V[i]<V[i+1]){
                scambia(&V[i],&V[i+1],&V2[i],&V2[i+1]);
            }
        }
        j--;
    }
}

void scambia(int *a, int *b, int *ab, int *ba){
    int tmp,mpt;
    tmp=*a;
    *a=*b;
    *b=tmp;
    mpt=*ab;    
    *ab=*ba;
    *ba=mpt;
}

void cercaltezza(int *V, int *V2, int dim){
    int i,inizialepersona,altezzapersona=0;
    printf("\nInserire l'inizale della persona di cui si vuole sapere l'altezza ");
    scanf("%d",&inizialepersona);
    for(i=0; i<dim; i++){
        if(inizialepersona==V[i]){
            altezzapersona=V2[i];
        }
    }
    printf(" %d \n",altezzapersona);
}

void altezzamaggiore(int *V, int dim){
    int i,altezza;
    printf("\nInserire l'inizale della persona di cui si vuole sapere le altezza maggiori ");
    scanf("%d",&altezza);
    for(i=0; i<dim; i++){
        if(V[i]>altezza){
            printf(" %d | ",V[i]);
        }
    }
}
