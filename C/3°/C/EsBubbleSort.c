#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void altezze(int *, int);
void bubble(int *, int);
void scambia(int *, int *);



int main(){
    int v,altezza;
    printf("Inserisci il numero di vettori ");
    scanf("%d",&v);    
    printf("\nInserisci un altezza, inserimento termina con 0");
    do{
        scanf("%d",&altezza);
        bubble(v,altezza);
        printf("\nInserisci un altezza, inserimento termina con 0");
    }while(altezza!=0);
return 0;
}
void bubble(int *vet, int dim){
      int flag,i,j;
      j=dim;
      flag=0;   
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
