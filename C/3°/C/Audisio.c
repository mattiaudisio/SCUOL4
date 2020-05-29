#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void caricaVet(int *, int );
void stampaVet(int *, int );
void ordinaVet(int *, int );
void scambia(int *, int * );
void mediaVet(int *, int *, int );
void magmin(int *, int *, int *, int *, int  );
void stampamagmin(int *, int );
void contaVet(int *, int *, int );
void eliminaVet(int *, int );

int main(){
    int P[100],Minori[100],Maggiori[100],N,media;
    srand(time(NULL));
    printf("\nInserisci la dimensione del vettore [minore-uguale a 20] ");
    scanf("%d",&N);
    if(N>20){
        caricaVet(P,N);
        stampaVet(P,N);
        ordinaVet(P,N);
        stampaVet(P,N);    
        mediaVet(P,media,N);
        magmin(P,Minori,Maggiori,N,media);
        printf("\nminori\n");
        stampamagmin(Minori,N);
        printf("\nmaggiori\n");
        stampamagmin(Maggiori,N);
        printf("\nuguali alla media\n");
        contaVet(P,media,N);
        printf("\n");
        eliminaVet(P,N);
    }else{
        printf("\nnumero inserito non valido \n");
return 0;
}

void caricaVet(int *V, int dim){
    int i;
    for(i=0; i<dim; i++){
        V[i]=rand()%51-1;
    }
}

void stampaVet(int *V, int dim){
    int i;
    printf("\n");
    for(i=0; i<dim; i++){
        printf("%d | ",V[i]);
    }    
}

void ordinaVet(int *V, int dim){
    int i,j,flag=0;                  
    j=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(j-1); i++){
            if(V[i]>V[i+1]){
                scambia(&V[i],&V[i+1]);
                flag=0;
            }
        }
        j--;
    }
}

void scambia(int *a, int *b){
    int tmp;
    tmp=*a;
    *a=*b;
    *b=tmp;
}

void mediaVet(int *V, int *media, int dim){
    int i,somma=0;
    float m;
    for(i=0; i<dim; i++){
        somma+=V[i];
    }
    m=(float)somma/dim;
    printf("\nmedia     %.2f    \n",m);
    *media=m;
}

void magmin(int *V, int *mag, int *min, int dim, int *med){
    int i,imag,imin;
    for(i=0; i<dim; i++){
        if(V[i]>*med){
            mag[imag]=V[i];
        }else{
            min[imin]=V[i];            
        }    
    }
}

void stampamagmin(int *V, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf("%d |",V[i]);
    }
}

void contaVet(int *V, int *med, int dim){
    int i,uguali=0;
    for(i=0; i<dim; i++){
        if(V[i]==*med){
           uguali+=1; 
        }
    }
    printf(" %d ",uguali);
}

void eliminaVet(int *V, int dim){
    int i,posizione;
    printf("\nInserisci una posizione ");
    scanf("%d",&posizione);
    for(i=0; i<dim; i++){
        if(posizione==V[i]){
            
        }
    }
}
