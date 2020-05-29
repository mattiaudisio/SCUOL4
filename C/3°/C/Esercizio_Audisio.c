#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void creaValore(int *, int *);
void stampa(int *, int );
void ordina(int *,int );
void scambia(int *,int *);
void cerca(int *,int , int );

int main(){
    int v[1000],nvolte=0,dato;
    creaValore(v, &nvolte);
    stampa(v,nvolte);
    ordina(v,nvolte);
    stampa(v,nvolte);
    printf("\nInserisci il dato da cercare ");
    scanf("%d",&dato);
    cerca(v,nvolte,dato);
return 0;
}

void creaValore(int *v, int *nvolte){
     int valore=0;
     while(valore!=-1){
        printf("\nInserisci un valore, -1 per terminare ");
        scanf("%d", &valore);
        if(valore!=-1){
            v[*nvolte]=valore;
            (*nvolte)++;
        }
     }
}

void stampa(int *v, int nvolte){
    int i;
    for(i=0; i<nvolte; i++){
        printf("%d | ",v[i]);
    }
    printf("\n");
}

void ordina(int *v,int nvolte){
    int i,j,flag=0;
    j=nvolte;
    while(flag==0){
        flag=1;
        for(i=0; i<(j-1); i++){
            if(v[i]<v[i+1]){
                scambia(&v[i],&v[i+1]);
                flag=0;
            }
        }
        j--;
    }
}

void scambia(int *a,int *b){
    int tmp;
    tmp=*a;
    *a=*b;
    *b=tmp;
}

void cerca(int *v, int nvolte, int N){
     int i=1, inizio=0 ,trov=1, fine=(nvolte-1); 
        while(trov=1 && inizio<=fine){       
            i=(inizio+fine)/2;
            if(N==v[i]){
                trov=0;
            }else if(N<v[i]){
                inizio=i+1;
            }else{
                fine=i-1;
            }
        }
        if(trov=0){
          printf("\nDato trovato, posizione %d \n",i);
        }else{
          printf("\nDato non trovato \n");
        }
}   
