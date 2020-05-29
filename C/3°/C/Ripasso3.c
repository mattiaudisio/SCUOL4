//Mattia Audisio 4C
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

typedef struct{
    char nomi[30];
    int voto;
}STUD;

void menu(STUD *);
void  Carica(STUD *,int);
void Eccellenze(STUD *,int);
void Insufficienti(STUD *,int);
void Media(STUD *,int);
void Cerca(STUD *,int);
void Votazione(STUD *,int);

int main(){
     STUD studenti[20];
     srand(time(NULL));
     menu(studenti);
return 0;
}

/*MENU'*/
void menu(STUD *studenti){
     char scelta;
     int N,i,dimensione; 
     printf("\n1. Studenti e voti");
     printf("\n2. Nomi degli alunni con votazione maggiore o uguale a 8");   
     printf("\n3. Insufficenti");   
     printf("\n4. Media");   
     printf("\n5. Dato il cognome sapere il voto");   
     printf("\n6. Votazione migliore e peggiore");
     printf("\n7. Esci");   
     printf("\n");
     do{
        printf("\nscelta --> ");
        scanf("%s",&scelta);
        switch(scelta){
                case '1':
                          do{     
                           printf("\nInserisci il numero di studenti [numsutdenti < 20] --> ");
                           scanf("%d",&N);
                          }while(N>=20);
                          dimensione=N;  
                          Carica(studenti,N);  
                          break;
                case '2':
                          if(dimensione!=0){  
                                Eccellenze(studenti,N);
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;                            
                case '3':
                          if(dimensione!=0){  
                              Insufficienti(studenti,N);
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;
                case '4':
                          if(dimensione!=0){  
                              Media(studenti,N);
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;
                case '5':
                          if(dimensione!=0){  
                              Cerca(studenti,N);
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;
                case '6':
                          if(dimensione!=0){  
                              Votazione(studenti,N);
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;  
                case '7':
                          if(dimensione!=0){  
                              printf("\nIl programma e' finito\n");
                          }else{
                            printf("\nPrima di andare avanti esegui il punto 1\n");
                          }    
                          break;                                                    
                default:                                                      
                          printf("\nInserimento errato\n");  
                          break;         
        }         
     }while(scelta!=7); 
}

/*CARICA*/
void Carica(STUD *studenti,int dim){
     int i;
    for(i=0; i<dim; i++){
        printf(" Inserisci il nome dell' alunno --> ");
        scanf("%s",studenti[i].nomi);
        studenti[i].voto=rand()%9;
    }
}        
/*ECCELLENZE*/
void Eccellenze(STUD *studenti, int dim){
     int i,eccellenze;
    for(i=0; i<dim; i++){
        if(studenti[i].voto>=8){
            eccellenze+=1;
        }
    }
    printf("\nAlunni con votazione maggiore o uguale a 8 --> %d", eccellenze);
}

/*INSUFFICIENTI*/
void Insufficienti(STUD *studenti, int dim){
     int i,insufficienti;
    for(i=0; i<dim; i++){
        if(studenti[i].voto<6){
            insufficienti+=1;
        }
    }
    printf("\nAlunni insufficienti --> %d", insufficienti);
}

/*MEDIA*/
void Media(STUD *studenti, int dim){
     int i,somma;
     float media;
    for(i=0; i<dim; i++){
        somma+=studenti[i].voto;
    }
    media=(int)somma/dim;
    printf("\nMedia --> %f", media);
}

/*CERCA*/
void Cerca(STUD *studenti, int dim){
     int i;
     char cercare [20];
     printf("\nInserire il nome di cui si vuole sapere il voto --> ");
     scanf("%s",cercare);   
     for(i=0; i<dim; i++){
        if(strcmp(cercare,studenti[i].nomi)==0){
            printf(" %f ",studenti[i].voto);
        }
    }
}

/*VOTAZIONE*/
void Votazione(STUD *studenti, int dim){
     int i,max=0,min=999;
    for(i=0; i<dim; i++){
        if(studenti[i].voto>max || studenti[i].voto<min){
            max=studenti[i].voto;
            min=studenti[i].voto;            
        }
    }
    printf("\nMax--> %d \n Min --> %d",max,min);
}
