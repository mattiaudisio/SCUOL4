//Mattia Audisio 4C
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>		//serve per la key_t
#include <sys/ipc.h>		//inizializzazione delle chiavi
#include <sys/shm.h>		//gestione memoria
#include <unistd.h>			//gestisce i processi
#include <string.h>
#include <sys/sem.h>		//Serve per la gestione dei semafori
#include <sys/wait.h>
#include <time.h>

#define SHM_SIZE 1024
struct sembuf buffer;


void sem_lock(int sem_id,int id);
void sem_unlock(int sem_id,int id);


int main(){
	key_t shm_chiave, sem_chiave;
	int shm_id,sem_id,sem_stato[3],i,*vassoi;
	

	sem_chiave=5581;
	shm_chiave=3376;
  	shm_id = shmget(shm_chiave, SHM_SIZE, 0666 | IPC_CREAT);
	sem_id = semget(sem_chiave, 3, IPC_CREAT | 0666);

	if(shm_id==-1 || sem_id==-1){
		printf("\nErrore nella creazione\n");
		exit(-1);
	}
	for(i=0;i<3;i++){
	  	sem_stato[i]=semctl(sem_id, i, SETVAL,1);   //setto i semafori 
	}   

	vassoi=(int*)shmat(shm_id,NULL,0);
	vassoi[0]=5;		//1°vassoio
	vassoi[1]=5;		//2°vassoio			
	vassoi[2]=5;		//3°vassoio
	vassoi[3]=0;		//stato


	printf("\nLa mensa e' aperta\n");	
	while(vassoi[3]!=1){
		for(i=0; i<3; i++){
			if(vassoi[i]==0){
				if(semctl(sem_id, i, GETVAL)==1){
						sem_lock(sem_id,i);
						printf("\nSvuoto il %d° contenitore",vassoi[i]);
						vassoi[i]=5;
						sleep(15);
						sem_unlock(sem_id,i);
				}
			}
		}
	}
	for(i=0; i<3; i++){			
		sem_stato[i]=semctl(sem_id,0,IPC_RMID,0);	
	}
	printf("\nTutti gli studenti hanno mangiato\nAdesso chiudo.");
	shmctl(shm_id,IPC_RMID,NULL);
return 0;
}

void sem_lock(int sem_id,int id){
	buffer.sem_num=id;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(sem_id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Bloccato\n");
}

void sem_unlock(int sem_id,int id){
	buffer.sem_num=id;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(sem_id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Sbloccato\n");
}
