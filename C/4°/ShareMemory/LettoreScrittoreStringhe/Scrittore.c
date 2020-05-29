// Lo scrittore crea la memoria, si connette e scrive stringhe. 
// Per terminare digita fine e si disconnette dalla memoria

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
	int shmid, i;
	char *dati,stringa[20];
	
	//creazione della memoria
	chiave=7786;
	shmid=shmget(chiave,DIM,0666|IPC_CREAT);
	if(shmid==-1){
		printf("Errore nella creazione della memoria\n");
		exit(-1);
	}
	//connessione alla memoria
	dati=shmat(shmid,NULL,0);
	printf("Scrivi una stringa, oppure fine per terminare\n");
	scanf("%s",stringa);
	strcpy(dati,stringa);
	while(strcmp(stringa,"fine")!=0){
		printf("Scrivi una stringa, oppure fine per terminare\n");
		scanf("%s",stringa);
		strcpy(dati,stringa);
	}
	printf("Hai scritto fine, esco\n");
	
	if(shmdt(dati)==-1){
		printf("Errore nella disconnessione scrittore\n");
		exit(-2);
	}
	
return 0;
}


