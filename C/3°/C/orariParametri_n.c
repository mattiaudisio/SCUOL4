#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int differenzaOrari(int,int,int,int,int,int,int,int,int *);
void trasfOM(int *,float *,int *,int *);

int main(){
	int uscitaO,uscitaM,arrPO,arrPM,uscPO,uscPM,arCasO,arCasM,minuti,totmin,totore;
	float prez=0;
	printf("inserisci l'ora in cui sei uscito di casa, prima in ore e poi in minuti\n");
	scanf("%d", &uscitaO);
	scanf("%d", &uscitaM);
	printf("inserisci l'ora in cui sei arrivato al parcheggio, prima in ore e poi in minuti\n");
	scanf("%d", &arrPO);
	scanf("%d", &arrPM);
	printf("inserisci l'ora in cui sei uscito dal parcheggio, prima in ore e poi in minuti\n");
	scanf("%d", &uscPO);
	scanf("%d", &uscPM);
	printf("inserisci l'ora in cui sei arrivato a casa, prima in ore e poi in minuti\n");
	scanf("%d", &arCasO);
	scanf("%d", &arCasM);-
	minuti=differenzaOrari(arrPO,arrPM,uscPO,uscPM,uscitaO,uscitaM,arCasO,arCasM,&totmin);
	trasfOM(&minuti, &prez, &totmin, &totore);
	printf("devi pagare %.2f \n", prez);
	printf("hai viaggiato per %d ore e %d minuti\n", totore,totmin);
return 0;
}

int differenzaOrari(int arrPO,int arrPM,int uscPO,int uscPM, int uscitaO, int uscitaM,int arCasO, int arCasM, int *totmin){
	int minuti,minuti2;
	minuti=((uscPO-arrPO)*60)+(uscPM-arrPM);
	*totmin=-(((uscitaO-arrPO)*60)+(uscitaM-arrPM)+((uscPO-arCasO)*60)+(uscPM-arCasM));
return minuti;	
}


void trasfOM(int *minuti,float *prez, int *totmin, int *totore){
	int ore;
	ore=*minuti/60;
	minuti=minuti-(ore*60);
	if(ore<=1){
		*prez=1.50;
	}
	else if(ore>1 && ore<8){
		*prez=1.50+(ore*1.20);
	}
	else{	
		*prez=8;
	}
	*totore=*totmin/60;
	*totmin=*totmin-(*totore*60);
}
