#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <stdbool.h>

void randomize();
int random(int a, int b);
int numTast();
void som(int *somma, int a);
void med(float *media, int somma, int a);

int main()
{
    int num1, num2, num3, num4, i, somma=0, somma2=0;
    float media;
    randomize();
    num1=random(0,30);
    num2=random(4,50);
    printf("num1: %d num2:%d\n", num1, num2);
    som(&somma,num1);
    printf("La somma vale: %d\n",somma);
    som(&somma,num2);
    printf("La somma vale: %d\n",somma);
    num3=numTast();
    for(i=0;i<num3;i++){
        num4=random(0,10);
        som(&somma2, num4);
    }
    printf("La somma2 vale: %d\n", somma2);
    med(&media,somma2,num3);
    printf("La media vale: %.2f\n",media);

    return 0;
}

void randomize(){
    srand(time(NULL));
}

int random(int a, int b){
    int c;
    c=rand()%a+(b-a);
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
