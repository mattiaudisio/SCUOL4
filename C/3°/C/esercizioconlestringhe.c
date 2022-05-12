/*
Date due stringhe di lunghezza N (N minore o uguale di 20), concatenarle in una terza stringa ed implementare un programma che permetta di contare il numero di 
vocali presenti.
*/

#include <stdio.h>
#include <string.h>

void terzastringa(char *, char *);


int main(){
    char str[20],str2[20],str3[20];
    int f;
    printf("\nInserisci la prima stringa ");
    scanf("%20s",str);
    printf("\nInserisci la seconda stringa ");
    scanf("%20s",str2);
    terzastringa(str,str3);
    f=strlen(str3);
    terzastringa(str2,str3);
    f+=strlen(str3);
    printf("\nnumero vocali presenti --> %d\n",f);
return 0;
}

void terzastringa(char *str, char *str3){
    int i=0,j=0,l=0;
    j=strlen(str);
    for(i=0; i<j; i++){
        if(str[i]=='a' && str[i]=='e' && str[i]=='i' && str[i]=='o' && str[i]=='u'){        
            str3[l]=str[i];
            l++;
        }
    }
}
