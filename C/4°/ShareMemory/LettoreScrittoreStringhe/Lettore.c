// Il lettore si connette alla memoria e legge le stringhe. 
// Quando legge fine, si disconnette dalla memoria e la distrugge.

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
	char *dati;
	
	//connessione alla memoria
	chiave=7786;
	shmid=shmget(chiave,DIM,SHM_RDONLY);
	if(shmid==-1){
		printf("Errore nella connessione alla memoria\n");
		exit(-1);
	}
	//inizializzazione del puntatore
	dati=shmat(shmid,NULL,SHM_RDONLY);
	printf("Leggo la stringa\n");
	printf("%s \n",dati);
	while(strcmp(dati,"fine")!=0){
		printf("%s \n",dati);
	}
	printf("Ho letto fine, quindi disconnetto e chiudo tutto\n");
	if(shmdt(dati)==-1){
		printf("Errore nella disconnessione del lettore\n");
		exit(-2);
	}
	printf("Distruggo la memoria\n");
	shmctl(shmid,IPC_RMID,NULL);
	printf("Memoria distrutta\n");
	

return 0;
}
