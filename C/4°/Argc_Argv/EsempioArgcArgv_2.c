//Mattia Audisio 4C

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char **argv){
	int num1,num2,somma=0;
	if(argc!=3){
		printf("\nERRORE\nUso: nome programma,numero,numero\n");
	}else{
		num1=atoi(argv[1]);							//atoi forza il numero in intero
		num2=atoi(argv[2]);
		somma=num1+num2;
		printf("\nLa somma dei due numeri e' %d\n",somma);
	}
return 0;
}
