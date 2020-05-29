
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int casuale(int);
void stampavett(int *);

int main(){
    int vet1[10];
    int vet2[10];
    int  i,a=10;
    srand(time(NULL));
    for(i=0; i<10; i++){
        vet1[i]=rand()%51;
        printf("--%d--",vet1[i]);
    }
    for(i=0; i<10; i++){
        a--;        
        vet2[i]=vet1[a];
    
    }   
    printf("\nVettore1: ");
    stampavett(vet1);
    printf("\nvettore2: ");
    stampavett(vet2);
return 0; 
}

void stampavett(int *vet){
    int i;
    for(i=0; i<10; i++){
    
        printf("|%d",vet[i]);
    }

}
