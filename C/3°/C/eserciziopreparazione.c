#include <stdio.h>
#include <string.h>


#define  P  10
#define  N  20

int main(){
    char piloti1 [P] [N], piloti2 [P] [N], tutte [P] [N], prima [P] [N], seconda [P] [N];
    int  num,i,trov,b,q=0,n=0,w=0;
    //inserisco i piloti
    printf("\nInserisci il numero di piloti presenti alle gare --> ");
    scanf("%d",&num);
    //prima gara
    printf("\n1°gara\n");
    for(i=0; i<num; i++){
        printf("\nInserisci il nome del pilota --> ");
        scanf("%19s",piloti1[i]);
    }
    printf("\n");
    for(i=0; i<num; i++){
        scanf("%s | ",piloti1[i]);
    }
    printf("\n");
    //seconda gara
    printf("\n2°gara\n");
    for(i=0; i<num; i++){
        printf("\nInserisci il nome del pilota --> ");
        scanf("%19s",piloti2[i]);
    }
    printf("\n");
    for(i=0; i<num; i++){
        scanf("%s | ",piloti2[i]);
    }
    printf("\n");
    //partecipano a tutte e 2 e solo alla prima
    for(i=0; i<num; i++){
        trov=0;
        b=0;
        while(trov=0 || b<num){
            if(strcmp(piloti1[i],piloti2[i])==0){
                  strcpy(tutte[N],piloti1[i]);
                  trov=1;  
                  n++;                 
            }
            b++;
        }
        if(trov==0 ){
            strcpy(prima[q],piloti1[i]);
            q++;
        }    
    }
    //partecipano a tutte e 2 e solo alla prima
    for(i=0; i<num; i++){
        trov=0;
        b=0;
        while(trov=0 || b<num){
            if(strcmp(piloti1[i],piloti2[i])==0){
                  trov=1;  
                  n++;                 
            }
            w++;
        }
        if(trov=0){
            strcpy(seconda[w],piloti1[i]);
            w++;
        }  
    }
    printf("\nPartecipanti seconda gara : \n");
    for(i=0; i<num; i++){
        printf("%s | ",seconda[i]);
    }
    printf("\nPartecipanti prima gara : \n");
    for(i=0; i<num; i++){
        printf("%s | ",prima[i]);
    }
    printf("\nPartecipanti a tutte e 2 le gare : \n");
    for(i=0; i<num; i++){
        printf("%s | ",tutte[i]);
    }
return 0;
}
