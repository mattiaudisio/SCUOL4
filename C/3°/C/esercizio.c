#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int  maggiorenni(int *,int );

#define N 30
#define D 20 

int main(){
    char nomi[N][D],nomax[D], nomecerca[D]; 
    int eta[N],s,i,etamax=0,magg,flag=0,conta;
    srand(time(NULL));
    printf("\nQuanti nomi vuoi inserire (massimo 30) ");
    scanf("%d",&s);
    //inserire nome e età
    for(i=0; i<s; i++){
        printf("\nInserisci un nome ");
        scanf("%s",nomi[i]);
        eta[i]=rand()%21+10;
        printf("%d\n",eta[i]);
    }
    //trovare il più grande
    for(i=0; i<s; i++){
        if(eta[i]>etamax){
            etamax=eta[i];
            strcpy(nomax,nomi[i]);
        }
    }
    printf("\nIl più grande %s eta %d",nomax,etamax);
    magg=maggiorenni(eta,s);
    printf("\nmaggiorenni --> %d",magg);
    printf("\nInserisci un nome per cercare l'eta'  ");
    scanf("%s",nomecerca);
    conta=0;
    while(flag==0 && conta<s-1){
        if(strcmp(nomecerca,nomi[conta])==0){
            printf("eta --> %d\n",eta[conta]);
            flag=1;
        }
        conta++;
    }
    if(flag==0){   
        printf("\nnome non trovato\n");
    }
return 0;
}


int maggiorenni(int *eta,int dim){
    int i,mag=0;
    for(i=0; i<dim; i++){
        if(eta[i]>=18){
           mag+=1; 
        }
    }
return mag;
}
