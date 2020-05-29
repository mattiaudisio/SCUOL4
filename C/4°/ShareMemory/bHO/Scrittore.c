//Mattia Audisio 4C 
//il processo scrittore crea l'area di memoria, crea il semaforo, blocca il semaforo, scrive, sblocca il semaforo, disconnette e distrugge

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
	char *dati, stringa[30];
	
	//creazione ed accesso a semaforo e memoria
	shmid=shmget(mem_chiave, DIM, 0666 | IPC_CREAT);		//memoria
	sem_id=semget(sem_chiave,1,IPC_CREAT | 0666);			//semaforo
	if(shmid==-1 || sem_id==-1){
		printf("\nErrore nella creazione della memoria o del semaforo\n");
		exit(-2);
	}
	//setto il semaforo
	sem_stato=semctl(sem_id,0,SETVAL,1);
	//inizializzo il puntatore alla memoria condivisa
	dati=shmat(shmid, NULL, 0);
	while(1){		//significa che cicla per sempre
		//testo il semaforo
		if(semctl(sem_id,0,GETVAL)==1){
			sem_Lock(sem_id);
			printf("\nSono lo scrittore.\nScrivi: ");
			scanf("%s",stringa);
			strcpy(dati,stringa);
			sem_Unlock(sem_id);
		}
	}
	shmctl(shmid,IPC_RMID,NULL);			//distruggo la memoria
	sem_stato=semctl(sem_id,0,IPC_RMID,0);	//distruggo il semaforo

return 0;
}

void sem_Lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(id,&buffer,1)==-1) printf("\nErrore\n");
	else printf("\nSemaforo Bloccato\n");
}

void sem_Unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(id,&buffer,1)==-1) printf("\nErrore\n");
	else printf("\nSemaforo Sbloccato\n");
}
