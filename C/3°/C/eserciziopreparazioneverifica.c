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
#include <string.h>

#define N 10
#define D 10

void carica(char *, int );
void crea(char *, int );
void stampa(char *,  int);
void bubble(char *, char *, int);
void scambia(int *, int *, int *, int *);
void cercaltezza(char *, char *, int);
void altezzamaggiore(char *, int); 


int main(){
    char persone [N] [D], altezze [N] [D];
    int N;
    printf("\nNumero persone ");
    scanf("%d",&N);
    carica(persone,N);
    crea(altezze,N);
    stampa(persone,N);
    printf("\n");
    stampa(altezze,N);
    bubble(altezze,persone,N);
    printf("\n");
    altezzamaggiore(altezze,N);
    cercaltezza(persone,altezze,N);

return 0;
}

void carica(char *persone, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf("\nInserisci l'iniziale del nome ");
        scanf("%20s",&persone[i]);
    }
}

void crea(char *altezze, int dim){
    int i;
    for(i=0; i<dim; i++){
      altezza[i]=rand()%346+150;
    }
}

void stampa(char *V, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf(" %s |  ",V[i]);
    }  
}

void bubble(char *V, char *V2, int dim){
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
    strcpy(tmp,*a);
    strcpy(*a,*b);
    strcpy(*b,tmp);
    strcpy(mpt,*ab);    
    strcpy(*ab,*ba);
    strcpy(*ba,mpt);
}

void cercaltezza(char *V, char *V2, int dim){
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

void altezzamaggiore(char *V, int dim){
    int i,altezza;
    printf("\nInserire l'inizale della persona di cui si vuole sapere le altezza maggiori ");
    scanf("%d",&altezza);
    for(i=0; i<dim; i++){
        if(V[i]>altezza){
            printf(" %d | ",V[i]);
        }
    }
}
