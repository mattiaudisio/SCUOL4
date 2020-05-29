/*Mattia Audisio*/
#include <stdio.h>
#include <string.h>

int main(){
    int i,d=0;
    char nome[20],novocali[20];
    printf("\nInserisci un nome --> ");
    scanf("%s",nome);
    for(i=0; i<strlen(nome); i++){
        if(nome[i]!='a' && nome[i]!='e' && nome[i]!='i' && nome[i]!='o' && nome[i]!='u'){
            novocali[d++]=nome[i];
        }
    }
    printf("\n %s \n",novocali);
return 0;
}
