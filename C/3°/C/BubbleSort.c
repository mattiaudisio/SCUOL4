/*Mattia Audisio 3C*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void caricaVet(int *, int);
void stampaVet(int *, int);
void bubble(int *, int);
void scambia(int *, int *);

int main(){
    srand(time(NULL));
    int v[1000000], N;
    printf("Inserisci la dimensione del vettore: ");
    scanf("%d",&N);
    caricaVet(v, N);
    stampaVet(v, N);
    bubble(v, N);
    stampaVet(v, N);
return 0;
}

void caricaVet(int *vet, int dim){
    int i;
    for(i=0;i<dim;i++){
        vet[i]=rand()%20;
    }
}

void stampaVet(int *vet, int dim){
    int i;
       for(i=0;i<dim;i++){
            printf("%d | ",vet[i]);
        }
        printf("\n");        
}

void bubble(int *vet, int dim){
      int flag,i,j;
      j=dim;
      flag=0; //0=True  1=False  
      while(flag==0){
        flag=1;
        for(i=0;i<(j-1);i++){
            if(vet[i]>vet[i+1]){
                scambia(&vet[i],&vet[i+1]);
                flag=0;
            }
        }
        j--;
      }
}

void scambia(int *dato1, int *dato2){
     int tmp;
     tmp=*dato1;   
     *dato1=*dato2;
     *dato2=tmp;     
}
