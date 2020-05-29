#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int MENU();
void ESCI();
int MAIN();
void PERIMETRO();
void MAGGIORE();
void QUANTI();
float calcolaPerc(int, int);
float calcolaMedia(int,int);
int creaRandom();  


int MENU(){
    char operatore;

    printf("\nMenu \n");
    printf("\nA per il perimetro \n");
    printf("\nB per il maggiore \n");
    printf("\nC per funzione quanti \n");
    operatore=getchar();

return operatore;    
}

int MAIN(){
    int scelta,azione;
	srand(time(NULL));
    do{
        printf("\n1: Menu 2:Uscire \n");
        scanf("%d",&scelta);
        if(scelta=1){
            azione=MENU();		//azione può essere A, B, C
            switch(azione){
                    case 'A':
                           PERIMETRO();
                           break;
                    case 'B':
                            MAGGIORE();
                            break;
                    case 'C':
                            QUANTI();
                            break;
                    default:
                            printf("\nscelta dell'azione non consentita \n");
                            break;
            }
        }else if(scelta=2){
			ESCI();
        }else{
            printf("\nHai immesso una scelta non consentita \n");                   
    }while(scelta!=2);
return 0;
}

void ESCI(){
    printf("\nIl programma e' finito \n");
}

void PERIMETRO(){
    int nlati,llato,perimetro;

    printf("\nInserisci il numero dei lati \n");
    scanf("%d",&nlati)
    if(nlati<3){
        printf("\nPoligono non previsto \n");
    }else{
        llato=creaRandom();
		perimetro=llato*nlati;
        printf("Il perimetro vale %d\n",perimetro);
    }
}

float creaRandom(){
		int random
		random=srand()%100
    	return random;
}

void MAGGIORE(){
    int N,i,numR,cpari=0,totPari=0,cdisp=0,totDisp=0;
    float mediaPari,mediaDisp;
    
    printf("\nInserisci il numero di elementi \n");
    scanf("%d",&N);
    for(i=0; i<N; i++){
        numR=creaRandom();
        if(numR%2==0){
            cpari++;
			totPari+=numR;
        }else{
			cdisp++;
			totDisp+=numR;
    }        
	medPari=calcolaMedia(cpari,totPari);
	medDisp=calcolamMedia(cdisp,totDisp);            
    if(medPari>medDisp){
        printf("La media maggiore e' %d\n",medPari);
    }else{
        printf("La media maggiore e' %d\n",medDisp);  
    }
}

float calcolaMedia(int conta,int accumula){        
    	float media;
    	media=(float)accumula/conta
    	return media;
}

void QUANTI(){
    int altezza,contaM=0,contaF=0,contaAlti=0,contaALF=0,contaALM=0,totstudenti;
    char sesso;
    
    printf("\nInserisci altezza studenti \n");
    scanf("%d",&altezza);
    while(altezza!=0){
       do{
            printf("\nInserisci il sesso \n");
            char sesso;
       }while(sesso!='F' && sesso!='M')
       if(sesso='F'){
		  contaF++;            
          }if(altezza>170){
			contaALF++;          
          }
       }else{  
		  contaM++;            
          }if(altezza>170){
			contaALM++;          
          }                
       printf("\nInserisci altezza studenti \n");
       scanf("%d",&altezza);          
    }do
    totstudenti=contaF+contaM;
    if(totstudenti>0){
	    percAlti= calcolaPerc(contaAlti, contaStud);
		percALF= calcolaPerc(contaALF, contaF);
		percALM= calcolaPerc(contaALM, contaM);        
        printf("femmine %c maschi %c femmine più alte di 1.70 %d maschi più alti di 1.70 %d percentuali alti %d totstudenti %d perc femmine più alte di 1.70 %d perc maschi più alti di 1.70 %d\n", contaF,contaM,contaALF,contaALM,percAlti,totstudenti,percALF,percALM);
    }else{
        printf("Non esistono studenti ");
}

float calcolaPerc(int maschi, int femmine){
       int perc;   
 	   perc=(float)(maschi/femmine)*100;
	   return (int)perc;       
}
