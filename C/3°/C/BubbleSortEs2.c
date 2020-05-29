#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void caricaNum(int *, int,int *, float *);
void stampaVetPari(int *, int);
void pariCrescente(int *, int);
void stampaVetDispari(int *, int, int);
void dispariCrescente(int *, int, int);
void scambia(int *, int *);

int main(){
    int v[100];
    int numVettore;
    float media=0;
    char scelta;
    srand(time(NULL));
    printf("Quanti valori possiede il vettore");
    scanf("%d",&numVettore);
    caricaNum(v, numVettore, media);
    do{
        printf("A. stampare i valori pari nell'ordine di inserimento");   
        printf("B. stampare i valori pari ordinati in modo crescente ");
        printf("C. stampare i valori dispari minori della media di tutti i numeri contenuti nel vettore di origine, nell'ordine di inserimento");
        printf("D. stampare i valori dispari minori della media di tutti i numeri contenuti nel vettore di origine, ordinati in modo crescente");
        printf("Z. esci");
        scelta=getchar();
        switch(scelta){
               case 'A': 
                       stampaVetPari(v, numVettore);  
                       break;
               case 'B':
                       pariCrescente(v, numVettore);  
                       break; 
               case 'C':
                       printf("media %.2f\n",media);
                       stampaVetDispari(v, numVettore, media);  
                       break;
               case 'D':
                       printf("media %.2f\n",media);                
                       dispariCrescente(v, numVettore, media);  
                       break; 
               case 'Z': printf("\nIl programma e' finito \n");
                       break;
               default:
                       printf("\nInserimento errato");
                       break;                    
        }
    }while(scelta!='Z');
    scanf("%d",&numVettore);
return 0;
}

void caricaNum(int *vet, int dim, float *med){
    int i;
    for(i=0;i<dim;i++){
        vet[i]=rand()%901+100;
        *med+=vet[i];
    }
    (*med)= ((float)med/dim);
}

void stampaVetPari(int *vet, int dim){
    int i;
        
       for(i=0;i<dim;i++){
            if(vet[i]%2==0){
                printf("%d | ",vet[i]);
            }
        }
        printf("\n");        
}

void pariCrescente(int *vet, int dim){
      int flag,i,j;
      j=dim;
      flag=0; //0=True  1=False  
      while(flag==0){
        if(vet[i]%2==0){
            flag=1;
            for(i=0;i<(j-1);i++){
                if(vet[i]>vet[i+1]){
                    scambia(&vet[i],&vet[i+1]);
                    flag=0;
                }
            }
            j--;

             printf("%d | ",vet[i]);
        }
      }
}

void scambia(int *dato1, int *dato2){
     int tmp;
     tmp=*dato1;   
     *dato1=*dato2;
     *dato2=tmp;     
}

void stampaVetDispari(int *vet, int dim, int med){
    int i;
        
       for(i=0;i<dim;i++){
            if(vet[i]%2!=0 && vet[i]<med){
                printf("%d | ",vet[i]);
            }
        }
        printf("\n");   
}

void dispariCrescente(int *vet, int dim, int med){
      int flag,i,j;
      j=dim;
      flag=0; //0=True  1=False  
      while(flag==0){
       if(vet[i]%2!=0 && vet[i]<med){
            flag=1;
            for(i=0;i<(j-1);i++){
                if(vet[i]>vet[i+1]){
                    scambia(&vet[i],&vet[i+1]);
                    flag=0;
                }
            }
            j--;

             printf("%d | ",vet[i]);
        }
      }
}
