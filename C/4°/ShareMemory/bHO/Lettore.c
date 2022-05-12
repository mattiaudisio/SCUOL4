//Mattia Audisio 4C 
//il processo lettore blocca il semaforo, legge e sblocca il semaforo

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/sem.h>		//Server per la gestione dei semafori
#include <sys/ipc.h>		//inizializzazione delle chiavi
#include <sys/types.h>		//serve per la key_t
#include <sys/shm.h>		//gestione memoria

#define DIM 1024		//dimensione della memoria

void sem_Lock(int);
void sem_Unlock(int);

struct sembuf buffer; 

int main(){
	key_t mem_chiave=7786, sem_chiave=4455;
	int shmid, sem_id, sem_stato;
	char *dati;

	//accesso e connessione a memoria e semaforo
	shmid=shmget(mem_chiave,DIM,SHM_RDONLY);
	sem_id=semget(sem_chiave,1,IPC_EXCL |0666);	
	//inizializzo il puntatore alla memoria condivisa
	dati=shmat(shmid, NULL, 0);
	while(1){		
		//testo il semaforo
		if(semctl(sem_id,0,GETVAL)==1){
			sem_Lock(sem_id);
			printf("\nSono il lettore.\nLeggo: ");
			printf("%s\n",dati);
			sem_Unlock(sem_id);
		}
	}
return 0;
}

void sem_Lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Bloccato\n");
}

void sem_Unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Sbloccato\n");
}
