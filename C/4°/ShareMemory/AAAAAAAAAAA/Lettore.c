//Mattia Audisio
//il lettore si connette alla memoria e legge le stringhe. Quando legge fine, si disconnette dalla memoria e la distrugge
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
	char *dati;
	
	//connessione alla memoria
	chiave=7786;
	shmid=shmget(chiave,DIM,SHM_RDONLY);
	if(shmid==-1){
		printf("\nErrore nella connessione alla memoria\n");		//non sono ancora sincronizzati, se faccio partire prima il lettore mi darà errore
		exit(-1);
	}
	//inizializzazione al puntatore
	dati=shmat(shmid,NULL,SHM_RDONLY);
	printf("\nLeggo la stringa\n");
	printf("%s \n",dati);
	while(strcmp(dati,"fine")!=0){
		printf("%s \n",dati);
	}
	//disconnessione e distruzione della memoria
	printf("\nHo letto fine, quindi disconnetto e chiudo tutto\n"); 	
	if(shmdt(dati)==-1){
		printf("\nErrore nella disconnessione del lettore\n");
		exit(-2);
	}
	printf("\nDistruggo la memoria\n");
	shmctl(shmid,IPC_RMID,NULL);
	printf("\nMemoria distrutta\n");
return 0;
}
