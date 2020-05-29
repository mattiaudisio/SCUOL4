//Mattia Audisio

#include <stdio.h>
#include <string.h>

void main() {
       char  carica[30],senzavocali[30];
    int i,s=0;

    printf("\nInserisci la stringa -->");
    ("%30s",carica);
    while(carica[i]!='\0'){
        if(carica[i]!='a' && carica[i]!='e' && carica[i]!='i' && carica[i]!='o' && carica[i]!='u'){
            senzavocali[s++]=carica[i];
        }
    }
    senzavocali[s]='\0';
    printf("")
}
