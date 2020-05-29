/*Inserire da tastiera una serie di numeri interi con 0 come tappo.
Per ogni numero inserito valutare mediante una funzione se sia il massimo o il minimo della serie
immessa e stampare al termine del ciclo di immissione i 2 valori e la loro posizione nella serie.

5  8  4  7  9  2 
1° 2° 3° 4° 5° 6°
*/

#include <stdio.h>
#include <stdlib.h>

void massimoMinimo(int*, int*, int);

int main(){
	int num,max=0,min=999;
	do{
		printf("\nInserisci un numero \n");
		scanf("%d",&num);
		if(num!=0){
		  massimoMinimo(&max,&min, num);
		}
	}while(num!=0);
	printf("\nIl numero piu' grande e' %d, mentre il piu' piccolo %d\n",max,min);
return 0;
}

void massimoMinimo(int*max, int*min, int n){
	if(n>*max){
		*max=n;
	}else if(n<*min){
		*min=n;
	}
}
