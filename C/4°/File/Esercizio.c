#include <stdio.h>
#include <stdlib.h>

#define MY_FILE "mattia.txt"

int main(void){
	FILE *fp;
	fp= fopen(MY_FILE, "w");
	if(!fp){
		printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
		exit(1);
	}
	// Scrivo su file
	fprintf(fp,"Questa è una prova di scrittura sul file %s\n",MY_FILE);
	if(fclose(fp) == -1){
		printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
	}else{
		printf("Dati scritti con successo sul file\n");
	}
return 0;
}
