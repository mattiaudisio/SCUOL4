#include "libreria.h"

int rando(int a, int b){
    int c;
    c=rand()%a+(b+1-a);
    return c;
}

int numTast(){
    int a;
    printf("Inserisci un numero intero: ");
    scanf("%d", &a);
    return a;
}

void som(int *somma, int a){
    *somma+=a;
}

void med(float *media, int somma, int a){
    *media=(float)somma/a;
}

int Nseggi(){
	int n;
	printf("Quanti seggi?");
	scanf("%d",&n);
return n;
}

int caricaIscritti(){
	int iscr=0;int random(int,int);
	int numTast();
	void som(int *somma, int a);
	void med(float *media, int somma, int a);
	iscr=rand()%500+1;
return iscr;
}

int caricaVotanti(int a){
	int vot;
	do{
		vot=rand()%a+30;	//perchè schede bianche+nulle=30
	}while(vot>a);
	printf("Votanti nel seggio: %d\n",vot);
return vot;
}

int creaD(int a){
	int d;
	do{
		d=rand()%a;
	}while(d>a);
return d;
}

float calcPerc(int a, int b){
	float perc;
	perc=(float)a/b*100;
return perc;
}

int crea(int a){
	int n;
	n=rand()%a;
return n;
}
