//Mattia Audisio 4C

#include <stdio.h>
#include <string.h>

typedef struct{
    char persona[20],numero[20];
}PERSONA;

void inserisci(PERSONA *,int );
void menu(PERSONA *, int);

int main(){
        PERSONA qwerty[30];
        int N;
        do{
            printf("\nInserisci il numero di persone --> ");
            scanf("%d",&N);
        }while(N>20);    
        inserisci(qwerty,N);
        menu(qwerty,N);
return 0;
}

/*INSERISCO I DATI*/
void inserisci(PERSONA *qwerty, int dim){
     int i,D=30,B=10;    
        for(i=0; i<dim; i++){
            do{
                printf("\nInserisci il nome della %d° persona --> ",i+1);
                scanf("%s",qwerty[i].persona);
            }while(strlen(qwerty[i].persona)>D);        
            do{
                printf("Inserisci il numero di telefono --> ");
                scanf("%s",qwerty[i].numero);
            }while(strlen(qwerty[i].numero)>B);
        }
}

/*MENU'*/
void menu(PERSONA *qwerty, int dim){
     int a;
     char scelta,cerca[20],numcerca[20];    
        do{
          printf("\nMENU'\n");
          printf("\n1. Conoscere il nome a partire da un numero di telefono\n");        
          printf("\n2. Conoscere il nome di telefono a partire da un nome\n");
          printf("\n3. Uscire dal programma\n");
          printf("\n");
          printf("\nScelta --> ");
          scanf("%s",&scelta);  
          switch(scelta){
                    case '1':           
                            printf("\nInserisci il nome -->");                            
                            scanf("%s", cerca);
                            printf("\n");
                            for(a=0; a<dim; a++){
                                if(strcmp(cerca,qwerty[a].persona)==0){
                                    printf("%s\n",qwerty[a].numero);
                                }
                            }
                            break;
                    case '2':           
                            printf("\nInserisci il numero -->");                            
                            scanf("%s", numcerca);
                            printf("\n");
                            for(a=0; a<dim; a++){
                                if(strcmp(numcerca,qwerty[a].numero)==0){
                                    printf("%s\n",qwerty[a].persona);
                                }
                            }
                            break;
                    case '3':
                            printf("\nIl programma e' terminato\n");               
                            break;
                    default:
                            printf("\nInserimento errato\n");
                            break;          
          }              
        }while(scelta==3);
}
