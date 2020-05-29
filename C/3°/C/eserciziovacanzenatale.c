/*Mattia Audisio 3C

*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(){
       int codice,contapersone=0,statura=0,max=0,staturamax,min=999,staturamin,staturapiu,maschi=0,femmine=0,eta,etamax,etac,etamin,etacm,maggiorenni=0;
       float staturamedia,etamedia,permaschi,perfemmine;
       char sesso,operatore;
        
        srand(time(NULL));
        printf("\n Inserisci il codice identificativo ");
        scanf("%d",&codice);
        while(codice!=0){
            contapersone++; 
            printf("\n inserisci la statura in centimetri ");
            scanf("%d",&statura);
            staturamedia+=statura;
            if(statura>max){
                max=codice;
                staturamax=statura;
            }else if(statura<min){
                min=codice;
                staturamin=statura;
            }
            if(statura>175){
                staturapiu=statura;
            }
            printf("\n inserisci il sesso , MoF ");
            sesso=getchar();
            if(sesso=='M'){
                maschi+=1;
            }else{
                femmine+=1;   
            }
            eta=rand()%2+99;
            etamedia+=eta;
            if(eta>etamax){
                etamax=eta;
                etac=codice;
            }else if(eta<etamin){
                etamin=eta;
                etacm=codice;
            }
            if(eta>=18){
                maggiorenni+=1;
            }
            printf("\n Inserisci il codice identificativo ");
            scanf("%d",&codice);
        }
        staturamedia=(float)statura/contapersone;
        etamedia=(float)etamedia/contapersone;
        permaschi=((float)maschi/contapersone)*100;
        perfemmine=((float)femmine/contapersone)*100;
        do{
            printf("\nmenu \n");
            printf("\n1. ottenere il codice identificativo del più alto e la relativa statura \n");
            printf("\n2. ottenere il codice identificativo del più basso con la relativa statura \n");
            printf("\n3. ottenere la statura media \n");
            printf("\n4. ottenere il numero di coloro che sono piu' alti di 1,75 m \n");
            printf("\n5. oottenere il codice identificativo del piu' vecchio e la relativa eta' \n");
            printf("\n6. ottenere il codice identificativo del piu' giovane e la relativa eta' \n");
            printf("\n7. ottenere l’eta' media \n");
            printf("\n8. ottenere il numero di coloro che sono maggiorenni \n");
            printf("\n9. scrivere il numero dei maschi e delle femmine e relative percentuali \n");
            printf("\ninserisci un numero \n");
            operatore=getchar();
            switch(operatore){
                case 0:
                        printf("\n il rpogramma e' finito ");
                        break;
                case 1:
                        printf("\nIl piu' alto misura %d e il suo codice e' il %d ",staturamax,max);
                        break;
                case 2:
                        printf("\nIl piu' basso misura %d e il suo codice e' il %d ",staturamin,min);
                        break;
                case 3:
                        printf("\nLa statura media vale %.2f centimetri ",staturamedia);
                        break;
                case 4:
                        printf("\n %d persone sono piu' alte di 1,75 m ",staturapiu);
                        break;
                case 5:
                        printf("\n il piu' vecchio ha %d anni e ha il codice %d ",etamax,etac);
                        break;
                case 6:
                        printf("\n il piu' giovane ha %d anni e ha il codice %d ",etamin,etacm);
                        break;                    
                case 7:
                        printf("\n l'eta media vale %.2f ",etamedia);
                        break;
                case 8:
                        printf("\n %d persone sono maggiorenni ",maggiorenni);
                        break;
                case 9:
                        printf("\n maschi %d femmine %d percentuale uomini %.2f percentuali femmine %.2f ",maschi,femmine,permaschi,perfemmine);
                        break;
                default:
                        printf("\n numero errato ");
                        break;
             }
        }while(operatore!=0);        
return 0;
}
