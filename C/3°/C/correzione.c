#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int inserisci();
int creacaso(int );
int crea(int, int, int );
void vota(int, int, int );

int main(){
    int N,i,iscritti,votanti,donne,uomini,sb,sn,vota,totA=0,totB=0,totC=0,totD=0;
    srand(time(NULL));    
    N=inserisci();
    for(i=0; i<N; i++){
        iscritti=inserisci();
        votanti=creacaso(iscritti);
        donne=creacaso(votanti);
        uomini=votanti-donne;
        sb=crea(max,votanti);
        max=sb;
        sn=crea(min,max,votanti);
        vota(votanti,sb,sn)
        totA+=A;
        totB+=B;
        totC+=C;
        totD+=D;
        
    }
    if(totA>totB&&totA>totC&&totA>totD){
        printf("\nHa vinto il partito A ");
    } else if(totB>totA&&totB>totC&&totB>totD){
        printf("\nHa vinto il partito B ");
    } else if(totC>totA&&totC>totB&&totC>totD){
        printf("\nHa vinto il partito C ");
    } else{
        printf("\nHa vinto il partito D ");
    }
return 0;
}

int inserisci(){
    int seggi;
    do{
       printf("\nInserisci il numero di seggi ");
       scanf("%d",&seggi);
    }while(dato>0);
return seggi;
}

int creacaso(int is){
    int dato;    
    dato=rand()%is;
return dato;
}

int crea(int, int max, int v);
    int schede ;
    if(v>=max){
      schede=rand()%max;    
    }else{
      schede=rand()%v;
    }    
return schede;

void vota(int votanti, int sb, int sn, int *A, int *B, int *C, int *D){
    int i,n,A=0,B=0,C=0,D=0;
    votanti=votanti-sb-sn;
    for(i=0; i<votanti; i++){
       n=rand()%4;
       if(n=1){                                         
          *A+=1;  
       }else if(n=2){
          *B+=1;
       }else if(n=3){
           *C+=1; 
       }else{
            *D+=1;
       }
    }
}        
