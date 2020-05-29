#include "libreria.h"

int rando(int a, int b){
    int c;
    c=rand()%a+(b+1-a);
    return c;
}

int numTast(){
    int a;
    printf("Inserisci un numero intero: ");
    scanf("%d", &a);
    return a;
}

void som(int *somma, int a){
    *somma+=a;
}

void med(float *media, int somma, int a){
    *media=(float)somma/a;
}
