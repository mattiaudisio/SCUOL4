#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//PROTOTIPI
int dammiNumero();
void stampaFine();
int creaCasuale(int);
int esponenziale(int, int);

int main(){
	int num,numero,caso,calcolo,srand;
	srand=(time(NULL));
	//Uso funzione senza parametri che ritorna intero
	num=dammiNumero();
	
	printf("Estremo superiore dei numeri casuali estraibili ");
	scanf("%d",&numero);
	//Uso funzione senza parametri che ritorna intero
	caso=creaCasuale(numero); //Scrivo questo perchè creaCasuale da un intero
	printf("Ho generato il numero --> %d\n",caso);
	
	//Uso funzione senza parametri che ritorna intero
	calcolo=esponenziale(2,3);
	printf("Esponenziale --> %d\n",calcolo);
	
	//Uso funzione senza parametri che ritorna intero
	stampaFine();


return 0;
}

int dammiNumero(){
	int n;
	printf("Inserisci un numero: ");
	scanf("%d",&n);
	return n;
}

void stampaFine(){
	printf("\n*******************\n");
	printf("**	F I N I T O  **\n");
	printf("*******************\n");	
}

int creaCasuale(int max){
	int casuale;
	casuale=rand()%(max+1);
	return casuale;	
}

int esponenziale(int base, int espon){
	int ris,i;
	for(i=0;i<espon;i++){
		ris*=base;
	}
	return ris;
}
