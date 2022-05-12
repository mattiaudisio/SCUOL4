//Mattia Audisio 4C
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <sys/types.h>
#include <sys/shm.h>

#define DIM 1024

void sem_lock(int);
void sem_unlock(int);

struct sembuf buffer;

int main(){
	key_t mem_chiave=7786, sem_chiave=4455;
	int shmid, sem_id,sem_stato,fine;
	char *dati;
	
	shmid=shmget(mem_chiave,DIM,0666 | IPC_CREAT);
	sem_id=semget(sem_chiave,1, IPC_CREAT | 0666 );
	if(shmid==-1 || sem_id==-1){
		printf("\nErrore nella creazione della memoria o del semaforo\n");
		exit(-2);
	}
	sem_stato=semctl(sem_id,0,SETVAL,1);
	dati=shmat(shmid,NULL,0);
	while(strcmp(dati,"fine")!=0){		
		if(semctl(sem_id,0,GETVAL)==1){
			sem_lock(sem_id);
			printf("\nSono il lettore.\nLeggo: ");
			printf("%s",dati);
			sem_unlock(sem_id);
		}
	}	
	shmctl(shmid,IPC_RMID,NULL);			
	sem_stato=semctl(sem_id,0,IPC_RMID,0);	
return 0;
}

void sem_lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Bloccato\n");
}

void sem_unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Sbloccato\n");
}
