//Botta Mattia 3^C

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int calcolo(int*,int);


int main(){
    int N=0,i=0,c=0;
    int vettore[10];
    srand(time(NULL));
    for(i=0; i<10; i++){
        vettore[i]=rand()%101;
        printf("\n %d",vettore[i]);
        do{
            printf("Inserisci numero(massimo 100): ");
            scanf("%d",&N);
        }while(N>100);
        if(N>vettore[i]) c++;
    }
    printf("I maggiore sono %d",c); 

}
