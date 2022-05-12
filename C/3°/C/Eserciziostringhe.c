/*
Chiedere all'utente una prima stringa di lunghezza 20 quindi una seconda di lunghezza 3. 
Andare a cercare la seconda stringa nella prima e restituire il numero di occorrenze trovato.
*/
#include <stdio.h>
#include <string.h>

void cercaSeconda (char *,char *);

int main(){
    char str1[20],str2[3];
    int lunghezza;
    do{
        printf("Inserisci una stringa  ");
        scanf("%20s", str1);
        lunghezza= strlen(str1);
    }while(lunghezza>20);    
    do{
        printf("\nInserisci un'altra stringa  ");
        scanf("%3s", str2);
        lunghezza= strlen(str2);
    }while(lunghezza>3);
    cercaSeconda(str1,str2);
}

void cercaSeconda (char *str1,char *str2){
    int i=0,j=0,f=0,l,cont=0;
    f=strlen(str1);
    for(i=0; i<f; i++){
        l=0;
        if(str1[i]==str2[l] && str1[i+1]==str2[l+1] && str1[i+2]==str2[l+2]){ 
            cont++;
        }
    }
    printf("\nnumero occorrenze trovaro --> %d\n",cont);
}
