//Mattia Audisio 4C
/*Programma che permette di scrivere a video gli argomenti passati da linea di comando, compreso il nome del programma*/

#include <stdio.h>

int main(int argc, char **argv){							// ARGC vale n mentre ARGCV[0]= ./a.out		ES. ./a.out 5   ./a.out è argv[0] e 5 è argv[1] 
	int i;
	printf("Valore di argc = %d\n", argc);																		
	for(i=0; i<argc; i++){
		printf("Parametro argv[%d]= %s\n",i,argv[i]);
	}

return 0;
}
