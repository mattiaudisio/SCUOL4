//Mattia Audisio
//Lo scrittore crea e si disconnette
//lo scrittore crea la memoria, si connette e scrive stringhe. Per terminare digita fine e si disconnette dalla memoria
//Lettore e scrittore devono partire insieme

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <string.h>

#define DIM 1024

int main(){
	key_t chiave;
	int shmid,i;
	char *dati,stringa[20];

	//creazione della memoria
	chiave=7786;															//posso mettere cosa voglio ma deve essere uguale nel Lettore
	shmid=shmget(chiave,DIM,0666|IPC_CREAT);
	if(shmid==-1){
		printf("\nErrore nella creazione della memoria\n");
		exit(-1);
	}	
	//connessione alla memoria
	dati=shmat(shmid,NULL,0);					 							//se io ho un puntatore di tipo intero o di tipo float devo fare un puntatore per la memoria, se ho una string NO
	printf("\nScrivi una stringa, oppure fine per terminare\n");
	scanf("%s",stringa);													//dati è il nostro puntatore per la memoria
	strcpy(dati,stringa);													//perchè si trattano di 2 stringhe
	while(strcmp(stringa,"fine")!=0){
		printf("\nScrivi una stringa, oppure fine per terminare\n");
		scanf("%s",stringa);													
		strcpy(dati,stringa);													
	}
	printf("\nHai scelto di smettere\n");	
	//disconnessione
	if(shmdt(dati)==-1){
		printf("\nErrore nella disconnessione");
		exit(-2);
	}
return 0;
}
