#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#define N 20
#define D 20

int main(){
    char persone[N] [D], altezze[20]; 
    int elementi,i=0,tmp,mpt,altezzacerca,pers;
    srand(time(NULL));
    do{
        printf("Quanti nomi vuoi inserire --> ");
        scanf("%d",&elementi);                          //str --> &str[0]
    }while(elementi>20);
    
    //caricamento dei 2 vettori
    for(i=0; i<elementi; i++){
        printf("\nInserisci un nome --> ");
        scanf("%20s",persone);
    }
    for(i=0; i<elementi; i++){
        altezze[i]=rand()%46+150;
    }

    //stampa vettori disordinati
    printf("\npersone:\n");
    for(i=0; i<elementi; i++){
        printf("| %s\t",persone[i]);
    }

    printf("\naltezze:\n");
    for(i=0; i<elementi; i++){
        printf("| %d\t",altezze[i]);
    }

    //ordinamento decrscente
    j=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(j-1); i++){
            if(altezze[i]<altezze[i+1]){
                    tmp=altezze[i+1];
                    altezze[i+1]=altezze[i];        
                    altezze[i]=tmp;
                    strcpy(mpt,persone[i+1]);
                    strcpy(persone[i+1],persone[i]);
                    strcpy(persone[i],mpt);
                    flag=0;
            }
        }
        j--;
    }

    //stampa vettori disordinati
    printf("\npersone:\n");
    for(i=0; i<elementi; i++){
        printf("| %s\t",persone[i]);
    }

    printf("\naltezze:\n");
    for(i=0; i<elementi; i++){
        printf("| %d\t",altezze[i]);
    }

    //cerca l'altezza
    printf("\nInserisci un altezza -->  ");
    scanf("%d",altezzacerca);
    for(i=0; i<elementi; i++){ 
       if(altezzacerca<altezze[i])  
         printf("| %d\t",altezze[i]);
    }

    //cerca il nome
    printf("\nnome da cercare --> ");
    scanf("%20s",pers);
    for(i=0; i<elementi; i++){
        if(strcmp(pers,persone[i])==0){
            printf("\naltezza %s --> %d\n",pers,altezze[i]);
            trov=1;
        }
    }
    if(trov==0){
        printf("altezza non trovata\n");
    }

return 0;
}
