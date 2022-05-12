/*Audisio mattia*/

#include <stdio.h>
#include <stdlib.h>
#include "mialibreria.h"

int somma(int *,int);
void sceltaSwitch();
void esNumeri();
void esSommaMedia();
void esSeggi();

int main(){
sceltaSwitch();
return 0;
}

int somma(int *vet1,int lunghezza){
	int i,som=0;
	for(i=0;i<lunghezza;i++){
		som=som+vet1[i];
	}
return som;
}

void sceltaSwitch(){
	int scelta = 0;
	printf("\n1) esercizio dei numeri\n2) esercizio somma/media\n3) esercizio seggi");
	scanf("%d",&scelta);
	switch(scelta){
		case(1):
			esNumeri();
			break:
		case(2):
			esSommaMedia();
			break:
		case(3):
			esSeggi();
			break:
		default:
			printf("\nInserisci un numero che va da 1 a 3");
			break:
	}
}

void esNumeri(){
	int vet[5],lung = 0,tot;
	printf("Quanti numeri vuoi inserire? ");
	scanf("%d",&lung);
	for(i=0;i<lung;i++){
		printf("Inserisci il %d numero: ",i+1);
		scanf("%d",&vet[i]);
	}
	tot=somma(vet,lung);
	printf("Il totale e' %d\n",tot);
}

void esSommaMedia(){	
	int i,num1, num2, num3, num4, somma=0, somma2=0;
	float media;
        srand(time(NULL));
	num1=rando(0,30);
	num2=rando(4,50);
	printf("num1: %d num2:%d\n", num1, num2);
	som(&somma,num1);
	printf("La somma vale: %d\n",somma);
	som(&somma,num2);
	printf("La somma vale: %d\n",somma);
	num3=numTast();
	for(i=0;i<num3;i++){
		num4=rando(0,10);
		som(&somma2, num4);
	}
	printf("La somma2 vale: %d\n", somma2);
	med(&media,somma2,num3);
	printf("La media vale: %.2f\n",media);
}

void esSeggi(){
	int N, isc, vot, bianche, nulle, totVot=0, totIsc=0, totBianche=0, donne=0, totDonne=0, totNulle=0, totUomini=0, uomini=0;
	float percVot=0, percB=0, percN=0, percDonne=0, percUomini=0;
	N=Nseggi();
	srand(time(NULL));
	for(i=0;i<N;i++){
		isc=caricaIscritti();
		vot=caricaVotanti(isc);
		donne=creaD(vot);
		printf("Donne che hanno votato: %d\n",donne);
		totDonne+=donne;
		uomini=vot-donne;
		printf("Uomini che hanno votato: %d\n",uomini);
		totUomini+=uomini;
		bianche=crea(10);
		totBianche+=bianche;
		printf("Bianche: %d\n", bianche);
		nulle=crea(20);
		totNulle+=nulle;
		printf("Nulle: %d\n", nulle);
		totVot+=vot;
		totIsc+=isc;
	}
	percVot=calcPerc(totVot,totIsc);
	printf("\n **** Risultati delle elezioni ***\n");
	printf("Percentuale votanti: %.2f\n",percVot);
	percB=calcPerc(totBianche,totVot); 			//Percentuale bianche
	percN=calcPerc(totNulle,totVot);			//Percentuale nulle
	printf("Percentuale bianche: %.2f, nulle: %.2f\n",percB, percN);
	percDonne=calcPerc(totDonne,totVot);
	printf("Percentuale donne: %.2f\n",percDonne);
}
