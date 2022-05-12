#include <stdio.h>
#include <time.h>
#include <stdlib.h>
                                                                                                                                                                          
int main(){
    int N=100,i,somma=0,pari=0,dispari=0,parival=0,disparival=0;
    int dato[N]; //definizione vettore
    float media,mediapari,mediadispari;
    srand(time(NULL));
    printf("numero vettore \n");
    scanf("%d",&N);
    for(i=0; i<N; i++){    
        dato[N]=rand()%21;
        printf("%d\t",dato[N]);
        somma=somma+dato[N];
        if(dato[N]%2==0){
            parival+=1;           
            pari+=dato[N];
        }else{
           disparival+=1; 
           dispari+=dato[N];
        }
    }
    media=(float)somma/N;
    mediapari=(float)pari/N;
    mediadispari=(float)dispari/N;
    printf("\nLa somma vale %d e la media %.2f\n ",somma,media);
    printf("\nci sono %d numeri pari e %d numeri dispari \n",parival,disparival);
    printf("\nLa somma  num pari vale %d e la media %.2f\n ",pari,mediapari);
    printf("\nLa somma num dispari vale %d e la media %.2f\n ",dispari,mediadispari);
    
return 0;
}
