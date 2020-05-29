/*Mattia Audisio*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct{
    char nome[20];
    int  punteggi,puntmax;
}PARTECIPANTI;

int inserisci();
void caratteristiche(PARTECIPANTI *, int );
void prova(PARTECIPANTI *,int );
void stampavit(PARTECIPANTI *, int);
void stampa(PARTECIPANTI *, int);
void vincitore(PARTECIPANTI *, int);


int main(){
    PARTECIPANTI quiz[20];
    int npart,num,i;
    srand(time(NULL));
    npart=inserisci(num);
    caratteristiche(quiz,npart);
    for(i=0; i<10; i++){
        printf("\n**%d PROVA**\n",i+1);
        prova(quiz,npart);
        printf("\n");
        stampa(quiz,npart);
        stampavit(quiz,npart);
        vincitore(quiz,npart);
    }
return 0;
}


//CHIEDO IL NUMERO DEI PARTECIPANTI
int inserisci(){
    int Np;
    do{
        printf("\nInserisci il numero dei partecipanti --> ");
        scanf("%d",&Np);    
    }while(Np>20 && Np<=0);
return Np;
}

//CHIEDO IL NOME DEL PARTECIPANTE E CREO IL PUNTEGGIO
void caratteristiche(PARTECIPANTI *quiz, int dim){
    int i;
    for(i=0; i<dim; i++){
        do{
            printf("\nInserisci il nome del %d° partecipante --> ",i+1);
            scanf("%s",quiz[i].nome);
        }while(strlen(quiz[i].nome)>30);
    }
}

//PROVE
void prova(PARTECIPANTI *quiz, int dim){
     int i;
     for(i=0; i<dim; i++){       
        quiz[i].punteggi=rand()%11;    
     }
}

//STAMPO PUNTEGGI
void stampa(PARTECIPANTI *quiz, int dim){
    int i,max=0;
    for(i=0; i<dim; i++){   
        printf("%s\t %d\n",quiz[i].nome,quiz[i].punteggi);
    }
}

//STAMPO IL VINCITORE DELLE PROVE
void stampavit(PARTECIPANTI *quiz, int dim){
    char nomemax[100];
    int i,max=0;
    for(i=0; i<dim; i++){
        if(quiz[i].punteggi>max){
           max=quiz[i].punteggi;
           strcpy(nomemax,quiz[i].nome);  
        }
    }
    printf("\nVincitore prova\n");
    printf("%s\t %d\n",nomemax,max);
}

//SCOPRO IL VINCITORE
void vincitore(PARTECIPANTI *quiz, int dim){
     char nomemax[100];
     int i,max;
     quiz[i].puntmax=0;   
     for(i=0; i<dim; i++){
        quiz[i].puntmax+=quiz[i].punteggi;
     }       
     for(i=0; i<dim; i++){
        if(quiz[i].puntmax>max){
           max=quiz[i].puntmax;
           strcpy(nomemax,quiz[i].nome);  
        }
     }       
     printf("\nIl vincitore e' %s con %d voti\n",nomemax,max);      
}
