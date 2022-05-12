/*Ricerca cotomica o ricerca binaria*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void creaVet(int *,int );
void caricaVet(int *,int );
void stampa(int *,int );
void ordina(int *,int );
void scambia(int *, int *);
void cerca(int *, int , int );

int main(){
    int v[100],N,dato;
    srand(time(NULL));
    printf("\nInserisci grandezza vettore ");
    scanf("%d",&N);
    creaVet(v,N);
    stampa(v,N);
    printf("\n");
    ordina(v,N);
    stampa(v,N);
    printf("\n");
    printf("\nInserisci il dato da cercare ");
    scanf("%d",&dato);
    cerca(v,N);
return 0;
}

void creaVet(int *v, int dim){
        int i;
        for(i=0; i<dim; i++){
            v[i]=rand()%21;
        }
}

void stampa(int *v, int dim){
     int i;   
     for(i=0; i<dim; i++){
           printf("%d | ",v[i]); 
     }
     printf("\n");
}

void ordina(int *v, int dim){
    int i,flag=0,j;
    j=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<j; i++){
             if(v[i]>v[i+1]){
                scambia(&v[i],&v[i+1]);
                flag=0;
             }       
        }
        j--;
    }
}

void scambia(int *A, int *B){
    int tmp;
    tmp=*A;
    *A=*B;
    *B=tmp;
}

void cerca(int *v, int dim, int N){
        int i=1, inizio=1, trov=1, fine=(dim-1);           // 0=TRUE -- 1=FALSE   
            while(trov=1 && inizio<= fine){
                i=(inizio+fine)/2;
                if(dato=v[i]){
                    trov=0;
                }else if(dato<v[i]){
                    fine=i-1;
                }else{
                    inizio=i+1;
                }
            } 
            if(trov=0){
               printf("\nDato trovato, posizione %d  \n",i);     
            }else{
                printf("\nDato non trovato \n");
            }           
}
