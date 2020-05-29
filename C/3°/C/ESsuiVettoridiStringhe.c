#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>


void votialunni(char *, int );
float MediaClasse(char *, int );

#define N 20
#define D 30


int main(){
    char cognomi[N] [D], voti[100], eccellenze[N] [D],peggiorenome[N] [D],migliorenome[N] [D];
    int num,i,q=0,insufficienti=0,cerca,peggiore=6,migliore=0,MediaClasse;
    srand(time(NULL));
    do{    
        printf("\nInserisci il numero di studenti --> ");
        scanf("%d",&num);
    }while(num<=0 ||num>=30);
    for(i=0; i<num; i++){
        printf("\nInserisci il nome dello studente --> ");
        scanf("%s",cognomi[i]);
    }
    printf("\n");
    votialunni(voti,num);
    printf("\n");
    MediaClasse=media(voti,num);

    //eccellenze
    for(i=0; i<num; i++){   
          if(voti[i]>=8){
             strcpy(eccellenze[q],cognomi[i]);
             q++;   
          }
    }
    printf("\nAlunni con un voto maggiore o uguale a 8 --> %s\n",eccellenze[q]);

    
    //insufficienti    
    for(i=0; i<num; i++){   
          if(voti[i]<6){
                insufficienti++;
          }
    }
    printf("\ninsufficienti --> %d\n", insufficienti);
 
    //visualizzare peggiore e migliore
    for(i=0; i<num; i++){
        if(voti[i]<peggiore){
            strcpy(peggiorenome[i],cognomi[i])
            peggiore=voti[i];
        }else if(voti[i]>migliore){
            strcpy(migliorenome[i],cognomi[i]) 
            migliorenome=cognomi[i];   
            migliore=voti[i];
        }
    }
    printf("\nLo studente peggiore e' %d, voto --> %d",peggiorenome,peggiore);
    printf("\nLo studente migliore e' %d, voto --> %d",migliorenome,migliore);

return 0;
}

void votialunni(char *voti, int dim){
    int i;
    for(i=0; i<dim; i++){
      voti[i]=rand()%8+2;  
    }
    for(i=0; i<dim; i++){
      printf(" %s | ",&voti[i]);  
    }
}

float MediaClasse(char *voti, int dim){
     int i,n;
     float media;
     for(i=0; i<dim; i++){   
        media+=voti[i];
        n++;
     }
     media=((float)media/n);
     printf("\nMedia --> %.2f\n",media);
return media;
}
