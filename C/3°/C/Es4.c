/*Scrivere un programma che riempa di valori interi casuali compresi tra 100 e 
1000 un vettore di dimensione specificata dall'utente e presenti un menù per:
A) stampare i valori pari nell'ordine di inserimento
B) stampare i valori pari ordinati in modo crescente
C) stampare i valori dispari minori della media di tutti i numeri contenuti nel 
   vettore di origine, nell'ordine di inserimento
D) stampare i valori dispari minori della media di tutti i numeri contenuti nel 
   vettore di origine, ordinati in modo crescente
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void crea(int *, int );
void menu(int *, int );
void A(int *, int );
void B(int *, int );
void C(int *, int );
void D(int *, int );
int media(int *, int , int * );
void scambia(int *, int * );

int main(){
    int v[1000];
    int dimensione;
    srand(time(NULL));
    printf("\nInserisci la dimensione del vettore ");    
    scanf("%d",&dimensione);
    crea(v,dimensione);
    menu(v,dimensione);
return 0;
}

void crea(int *v, int dim){
    int i;
    for(i=0; i<dim; i++){
        v[i]=rand()%1001+100;
    }
}

void menu(int *v, int dim){
     char scelta;         
     do{
         printf("A) stampare i valori pari nell'ordine di inserimento \n");       
         printf("B) stampare i valori pari ordinati in modo crescente \n");       
         printf("C) stampare i valori dispari minori della media di tutti i numeri contenuti nel vettore di origine, nell'ordine di inserimento \n");   
         printf("D) stampare i valori dispari minori della media di tutti i numeri contenuti nel vettore di origine, ordinati in modo crescente \n");       
         printf("Z) esci dal programma \n");           
         scelta=getchar();
         switch(scelta){   
                case 'A':   
                          A(v,dim);  
                          break;  
                case 'B':
                          B(v,dim);  
                          break;  
                case 'C':   
                          C(v,dim);  
                          break;  
                case 'D':
                          D(v,dim);  
                          break;
                case 'Z': 
                          printf("\nIl programma è finito \n");  
                          break;
                default:
                          printf("\nInserimento errato \n");
                          break;      
        }
     }while(scelta!='Z');          
}

void A(int *v, int dim){
     int i;   
     for(i=0; i<dim; i++){
        if(v[i]%2==0){
            printf("%d | ",v[i]);
        }
     }
     printf("\n");      
}

void B(int *v, int dim){
    int i,flag=0,J;
    J=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(J-1); i++ ){
            if(v[i]%2==0){
                if(v[i]>v[i+1]){
                    scambia(&v[i],&v[i+1]);
                }
            }    
        }
        J--;
    }   
}

void C(int *v, int dim){
     int i,tot;
     media(v,dim,&tot);      
     for(i=0; i<dim; i++){
        if(v[i]%2!=0){
            if(v[i]<tot){
                printf("%d | ",v[i]);
            }
        }
     }
     printf("\n");      
}

void D(int *v, int dim){
    int i,flag=0,J,tot;
    media(v,dim,&tot);
    J=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(J-1); i++ ){
            if(v[i]%2!=0){
                if(v[i]<tot){                
                    if(v[i]>v[i+1]){
                        scambia(&v[i],&v[i+1]);
                    }
                }
            }    
        }
        J--;
    }   
}

int media(int *v, int dim, int *tot ){
    int i,media=0;
    for(i=0; i<dim; i++){
        media+=v[i];
    }
    media=media/dim;
    *tot=media;
return *tot;
}

void scambia(int *a, int *b){
    int tmp;
    tmp=*a;
    *a=*b;
    *b=tmp;
}
