#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int decrementa(int);
int decrementaRef(int *);

int main(){
	int n,numero,num;
	printf("Inserisci un numero\n");
	scanf("%d",&n);
	numero=decrementa(n); //parametri ATTUALI
	printf("N da solo vale %d e numero vale %d\n",n,numero);
	num=decrementaRef(&n); //passo l'indirizzo a cui si trova n
	printf("N da solo vale %d e numero vale %d\n",n,num);	
return 0;
}

int decrementa(int a){ //parametri FORMALI
	a--;
	return a;
}

int decrementaRef(int *b){
	(*b)--;
	return *b;
}
