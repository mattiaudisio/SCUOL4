/*Mattia Audisio 3C*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char cognome[30],nome[30];
    int  voto;
}STUDENTI;

int inserisci();
void caratteristiche(STUDENTI *, int );
float media(STUDENTI *, int );
void stampa(STUDENTI *, int);


int main(){
    STUDENTI str[20];
    char stud[20];
    int i,nstudenti,num;
    nstudenti=inserisci(num);
    caratteristiche(str,nstudenti);
    stampa(str,nstudenti);    
    media(str,nstudenti);
    printf("\nmedia --> %.2f\n\n",media(str,nstudenti));
return 0;
}


//CHIEDO IL NUMERO DI STUDENTI
int inserisci(){
    int Nstud;
    do{
        printf("\nInserisci il numero di studenti --> ");
        scanf("%d",&Nstud);    
    }while(Nstud>20 && Nstud<=0);
return Nstud;
}

//FACCIO INSERIRE NOME,COGNOME E VOTO DELLO STUDENTE
void caratteristiche(STUDENTI *str, int nstud){
    int i;
    for(i=0; i<nstud; i++){
        do{
            printf("\nInserisci il cognome del %d° studente --> ",i+1);
            scanf("%s",str[i].cognome);
        }while(strlen(str[i].cognome)>30);
        do{    
            printf("\nInserisci il nome del %d° studente --> ",i+1);
            scanf("%s",str[i].nome);
        }while(strlen(str[i].nome)>30);
        do{        
            printf("\nInserisci il voto del %d° studente --> ",i+1);
            scanf("%d",&str[i].voto);
        }while(str[i].voto>10);
    }
}

//STAMPO L'ELENCO
void stampa(STUDENTI *str, int nstud){
    int i;
    printf("\nelenco\n");
    for(i=0; i<nstud; i++){
        printf("%s\t %s\t %d\n",str[i].cognome,str[i].nome,str[i].voto);
    }
}

//FACCIO LA MEDIA
float media(STUDENTI *str, int nstud){
    int somma=0,nsomma=0,i;
    float media;
    for(i=0; i<nstud; i++){
        somma+=str[i].voto;
        nsomma+=1;
    }
    media=((float)somma/nsomma);    
}
