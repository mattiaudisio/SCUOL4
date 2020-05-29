#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char cognome[30], nome[25], indirizzo[30] , CF[16],nomemax[30];
    int  eta, stipendio;
}   INFORMAZIONI;


int main(){
    INFORMAZIONI pers[5];    
    int i,max=0,nstip=0,nomecerca,indirizzocerca,flag,cerca,x=1;
    float stipmedio=0;
    for(i=0; i<2; i++){
        printf("Inserisci cognome: ");
        scanf("%s",pers[i].cognome);
        printf("Inserisci nome: ");
        scanf("%s",pers[i].nome);
        printf("Inserisci indirizzo: ");
        scanf("%s",pers[i].indirizzo);
        printf("Inserisci codice fiscale: ");
        scanf("%s",pers[i].CF);
        printf("Inserisci eta': ");
        scanf("%d",&pers[i].eta);
        printf("Inserisci stipendio: ");
        scanf("%d",&pers[i].stipendio);
    }
    printf("\nInformazioni\n");
    for(i=0; i<2; i++){
        printf("%s\t   %s\t   %s\t   %s\t   %d\t   %d\n", pers[i].cognome, pers[i].nome, pers[i].indirizzo, pers[i].CF, pers[i].eta, pers[i].stipendio);
    }

    //età maggiore
    printf("\nEta' maggiore\n");
    for(i=0; i<2; i++){
        if(pers[i].eta>max){
           max= pers[i].eta;
           strcpy(pers[i].nomemax,pers[i].nome);      
        }
    }
    printf("%s\t %d\n", pers[i].nomemax, max);

    //stipendio maggiore
    printf("\nstipendio maggiore\n");
    for(i=0; i<2; i++){
        stipmedio+=pers[i].stipendio;    
        nstip+=1;
        stipmedio=((float)stipmedio/nstip);
    }
    printf("%s\t %.2f\n", pers[i].nomemax, stipmedio);

    //dato un nome sapere l'indirizzo
    printf("\nInserisci il nome di cui vuoi sapere l'indirizzo: ");
    scanf("%d",&nomecerca);
    for(i=0; i<2; i++){
        flag=0;
        if(strcmp(nomecerca,pers[i].nome)==0){   
          strcpy(indirizzocerca,pers[i].indirizzo);
          flag=1;  
        }
    }
    if(flag==0){
        printf("\nNome non presente nella lista\n");
    }
    printf("%s\t %s\n", pers[i].nome, pers[i].indirizzo);    

return 0;
}
