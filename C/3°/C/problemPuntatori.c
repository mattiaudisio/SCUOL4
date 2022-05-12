#include <stdio.h>
#include <time.h>
#include <stdlib.h>

float tempo(int *, int * );
float oremin(int *);
float costore(int *);
float versoparcheggio(int *, int *,int);
float versocasa();

int main(){
		int orauscitacasa,orarioarrivoparcheggio,orariouscitaparcheggio,oraarrivocasa,operatore,tempotrascorsoparcheggio;
		printf("\nA che ora esci da casa  ");
		scanf("%d",&orauscitacasa);
		printf("\nA che ora arrivi al parcheggio  ");
		scanf("%d",&orarioarrivoparcheggio);
		printf("\nA che ora esci dal parcheggio  ");
		scanf("%d",&orariouscitaparcheggio);
		printf("\nA che ora arrivi a casa  ");
		scanf("%d",&oraarrivocasa);
		do{
			printf("\n0. esci");
			printf("\n1. tempo trascorso");		
			printf("\n2. da minuti a ore e minuti");
			printf("\n3. ore trascorse nel parcheggio e costo");
			printf("\n4. ore tragitto andata");					
			printf("\n5. ore tragitto rientro \n");
			scanf("%d",&operatore);		
			switch(operatore){
					case 0:
							printf("\nIl programma e' finito \n");
							break;
					case 1:
							tempo(&orarioarrivo,&orariouscita);
							break;		
					case 2:
							tempotrascorsoparcheggio=orariouscitaparcheggio+orarioarrivoparcheggio;
                            oremin(&minuti);    							
                            break;
					case 3:
							costore(&orenelparcheggio);
							break;
					case 4:
							versoparcheggio(&partenzadacasa, &arrivoalparcheggio,andata);
							break;		
					case 5:
							versocasa();   							
                            break;
                    default:
                           printf("\nInserimento errato ");							
                           break;
			}
		}while(operatore!=0);
}

float tempo(int *orarioarrivo, int *orariouscita){
    float ora;
	ora=(float)(orarioarrivo+orariouscita)/60;
	printf("\nsono trascorsi %.2f ore ",ora);
}

float oremin(int *minuti){	
    float oreinminuti;
	oreinminuti=(float)minuti/60;
	printf("\ni %d minuti che hai inserito equivalgono  a %.2f ore e minuti",minuti,oreinminuti);
}

float costore(int *orenelparcheggio){
	if(orenelparcheggio<1)
		printf("\nhai pagato 1.50€ ");
	else if(orenelparcheggio>8)
		printf("\nhai pagato 9€ ");
	else
		orenelparcheggio*1.20;
		printf("\nhai pagato %.2f € ",orenelparcheggio);		
}

float versoparcheggio(int *partenzadacasa, int *arrivoalparcheggio,int andata){
		andata=arrivoalparcheggio-partenzadacasa;
		printf("\nhai impiegato %.2f ore a fare il tragitto d'andata",andata);		
}

float versocasa(int *partenzadalparcheggio, int *arrivoacasa,int ritorno){
		ritorno=arrivoacasa-partenzadalparcheggio;
		printf("\nhai impiegato %.2f(ritorno) ore a fare il tragitto di ritorno");		
}
