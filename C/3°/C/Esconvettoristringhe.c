//Mattia Audisio

#include <stdio.h>
#include <string.h>

#define P 20
#define N 20

int main(){
    char piloti1 [P] [N], piloti2 [P] [N], soloprima [P] [N], soloseconda [P] [N], tutti [P] [N];
    int num,i,contutti=0,contprima=0,contseconda=0,trov=0,q=0,b=0,p=0;
    //inserisci piloti
    do{
        printf("\nInserisci il numero di piloti presenti nelle gare --> ");
        scanf("%d",&num);
    }while(num>20 || num<0);

    printf("\n1° gara\n");    
    for(i=0; i<num; i++){
        printf("\nInserisci il nome del pilota --> ");
        scanf("%19s",piloti1[i]);
    }
    printf("\n");
    for(i=0; i<num; i++){
        printf(" %s | ",piloti1[i]);
    }
    printf("\n");   

    printf("\n2° gara\n");    
    for(i=0; i<num; i++){
        printf("\nInserisci il nome del pilota --> ");
        scanf("%19s",piloti2[i]);
    }
    printf("\n");
    for(i=0; i<num; i++){
        printf(" %s | ",piloti2[i]);
    }
    printf("\n"); 

    //partecipano a tutte o solo alla prima    
    for(i=0; i<num; i++){
        trov=0;
        b=0;
        while(flag=0 || b<num){
            if(strcmp(piloti1[i],piloti2[i])==0){ 
                strcpy(tutti[n],piloti1[i]);
                trov=1;
                n++;
            }
            b++;
        }
        if(trov=0){
            strcpy(soloprima[q],piloti1[i]);
            q++;   
        }
    }
    //a questo punto i vettori di output tutti e soloprima sono pieni
    printf("\nnumero piloti che hanno partecipato a tutte le gare   ",tutti);
    for{
        printf(" %s | ",tutti[i]);
    }
    printf("\n");
    printf("\nnumero piloti che hanno partecipato solo alla prima gara --> %s\n",soloprima);
    for{
        printf(" %s | ",soloprima[i]);
    }
    printf("\n");
    //partecipano solo alla seconda    
    for(i=0; i<num; i++){
        trov=0;
        p=0;
        while(flag=0 || p<num){
            if(strcmp(piloti1[i],tutti[p])==0){ 
                //se entro qui il pilota preso dalla tutti è anche presente nel vettore di tutte e 2 le gare fatte quindi 
                //sicuramente NON lo metto nel vettore di quelli che hanno fatto SOLO la gara2
                trov=1;
                n++;
            }
            p++;
        }
        //qui fare una if sul flag
        if(trov=0){
            strcpy(tutti[q],piloti1[i]);
            q++;   
        }
    }
    printf("\nnumero piloti che hanno partecipato solo alla seconda gara--> %s\n",soloseconda);
    if(trov==0){
        printf("\npilota non trovato\n");
    }
return 0;
}
