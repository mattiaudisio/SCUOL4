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

void sem_Lock(int);
void sem_Unlock(int);

struct sembuf buffer;

int main(){
	key_t mem_chiave=7786, sem_chiave=4455;
	int shmid, sem_id,stato,sem_stato,fine;
	char *dati,stringa[30];

	shmid=shmget(mem_chiave,DIM,IPC_EXCL |0666);
	sem_id=semget(sem_chiave,1,IPC_EXCL |0666);	
	dati=shmat(shmid,NULL,0);
	while(strcmp(dati,"fine")!=0){		
		if(semctl(sem_id,0,GETVAL)==1){
			sem_Lock(sem_id);
			printf("\nSono lo scrittore.\nScrivi: ");
			scanf("%s",dati);
			if(dati=="fine"){
				fine=1;
			}
			strcpy(dati,stringa);
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
