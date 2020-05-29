/*Mattia Audisio 4C*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char nome[10],numero[20];
}PERSONA;

void inserisci(PERSONA *,int);
void menu(PERSONA *,int);

int main(){
    PERSONA tizio[20];
    int N;
     do{
        printf("\nQuanti contati devi inserire [max 20] --> ");
        scanf("%d",&N);
     }while(N>20);
    inserisci(tizio,N);
    menu(tizio,N);
return 0;
}

/*INSERISCI*/
void inserisci(PERSONA *tizio,int dim){
     int i;          
     for(i=0; i<dim; i++){
        printf("Inserisci il nome del contatto [max 10 caratteri]--> ");
        scanf("%s",tizio[i].nome);
        printf("Inserisci il numero del contatto --> ");
        scanf("%s",tizio[i].numero);
     }   
}

/*MENU*/
void menu(PERSONA *tizio,int dim){
    int i;
    char scelta,cerca[20];
    printf("\n1. Conoscere il nome a partire da un numero di telefono");    
    printf("\n2. Conoscere il numero di telefono a partire da un nome");
    printf("\n3. uscire dal programma");
    do{
      printf("\nscelta --> ");
      scanf("%s",&scelta);  
      switch(scelta){
            case '1':
                     printf("\nInserisci il nome di cui vuoi sapere il numero-->");   
                     scanf("%s",cerca);   
                     for(i=0; i<dim; i++){
                        if(strcmp(cerca,tizio[i].nome)==0){
                            printf("%s",tizio[i].numero);
                        }
                     }
                     break;      
            case '2':
                     printf("\nInserisci il numero di cui vuoi sapere il nome-->");   
                     scanf("%s",cerca);   
                     for(i=0; i<dim; i++){
                        if(strcmp(cerca,tizio[i].numero)==0){
                            printf("%s",tizio[i].nome);
                        }
                     }
                     break;   
            case '3':
                     printf("\nIl programma e' terminato\n");
                     break;
            default:
                     printf("\nInserimento errato\n");              
        }        
    }while(scelta!=3);
}
