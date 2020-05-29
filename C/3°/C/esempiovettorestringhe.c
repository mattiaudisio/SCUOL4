#include <stdio.h>
#include <string.h>

#define N 30 //numero di celle del vettore delle stringhe
#define D 20 //dimensione delle stringhe

int main(){
    char nomi[N] [D], nomedacercare[N], appoggio[100]; //definisco un vettore nomi di 30 elementi ognuno lungo max 20
    int i, elem,trov=0;
    do{
        printf("Quanti nomi vuoi inserire? ");
        scanf("%d",&elem); //elem sostituisce la dimensione N
    }while(elem>30);    
    for(i=0; i<elem; i++){
       do{ 
        printf("Inserisci il nome (lunghezza max 20) --> ");
        scanf("%20s",appoggio);
       }while(strlen(appoggio[i])>20);
       strcpy(nomi[i],appoggio); //destinazione,origine
    }
    for(i=0; i<elem; i++){
        printf("%s | ", nomi[i]);           
    }
    printf("\nChe nome vuoi cercare? ");
    scanf("%s",nomedacercare);
    for(i=0; i<elem; i++){
        if(strcmp(nomi[i],nomedacercare)==0){                                                        
            printf("\nHo trovato l'elemento in posizione %d\n",i);
            trov=1;
        }
    }
    if(trov==0){
        printf("\nelemento non trovato\n");
    }
return 0;
}
