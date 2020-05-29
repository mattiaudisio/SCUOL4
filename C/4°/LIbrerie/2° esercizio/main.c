#include "libreria.h"

int main(){
    int num1, num2, num3, num4, i, somma=0, somma2=0;
    float media;
    srand(time(NULL));
    num1=rando(0,30);
    num2=rando(4,50);
    printf("num1: %d num2:%d\n", num1, num2);
    som(&somma,num1);
    printf("La somma vale: %d\n",somma);
    som(&somma,num2);
    printf("La somma vale: %d\n",somma);
    num3=numTast();
    for(i=0;i<num3;i++){
        num4=rando(0,10);
        som(&somma2, num4);
    }
    printf("La somma2 vale: %d\n", somma2);
    med(&media,somma2,num3);
    printf("La media vale: %.2f\n",media);

    return 0;
}

