//Padre crea N figli che scrivno o leggono sulla memoria condivisa

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>		//Server per la gestione dei semafori
#include <sys/ipc.h>		//inizializzazione delle chiavi
#include <sys/types.h>		//serve per la key_t
#include <sys/shm.h>		//gestione memoria

#define DIM 1024		//dimensione della memoria

void sem_Lock(int);
void sem_Unlock(int);

void lettore(int);
void scrittore(int);

struct sembuf buffer; 

int main(){
	pid_t pid;
	key_t sem_chiave, mem_chiave; 
	int sem_stato, sem_id, cheffaccio, stato, figli, i, shmid;

	sem_chiave=1234;	//chaive del semaforo
	mem_chiave=7786;	//chiave della memoria condivisa

	shmid=shmget(mem_chiave,DIM,IPC_CREAT | 0666);	//creo memoria 
	sem_id=semget(sem_chiave,1,IPC_CREAT | 0666);	//creo semaforo	

	if(sem_id==-1 || shmid==-1){
		printf("\nErrore nella creazione di memoria o semaforo!\n");
		exit(-1);
	}

	sem_stato=semctl(sem_id,0,SETVAL,1);	//setto semaforo
	
	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&figli);
	for(i=0; i<figli; i++){
		if((pid=fork())<0){
			printf("\nErrore\n");
			exit(-2);
		}	
		if(pid==0){
			srand(getpid());
			cheffaccio=rand()%2;			
			if(cheffaccio==0){
				//sono un lettore
				//operazioni da fare:
				//  verificare semaforo,
				//	se libero bloccarlo,
				//	leggere sulla memoria,
				//	sbloccare il semaforo,
				if(semctl(sem_id,0,GETVAL)==1){
					sem_Lock(sem_id);
					printf("\nSono il lettore e' blocco il semaforo\n");
					lettore(shmid);
					sem_Unlock(sem_id);	
				}	
			}else{
				//sono uno scrittore
				//operazioni da fare:
				//  verificare semaforo,
				//	se libero bloccarlo,
				//	scrivere sulla memoria,
				//	sbloccare il semaforo,
				if(semctl(sem_id,0,GETVAL)==1){
					sem_Lock(sem_id);
					printf("\nSono uno scrittore, blocco il semaforo e scrivo\n");
					scrittore(shmid);
					sem_Unlock(sem_id);
				}
			}
		exit(i);	
		}
	}	
	for(i=0; i<figli; i++){
		pid=wait(&stato);
		printf("\nTerminato il figlio con stato %d\n", stato>>8);
	}
	sem_stato=semctl(sem_id,0,IPC_RMID,0);
	printf("\nSemaforo rimosso\n");
	shmctl(shmid,IPC_RMID, NULL);
	printf("\nArea di memoria condivisa distrutta\n");
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

void lettore(int shm_id){	
	int *p;
	//mi collego alla memoria condivisa e leggo
	p=(int *)shmat(shm_id,NULL,SHM_RDONLY);
	printf("\nHo letto %d\n",p[0]);		 	
}

void scrittore(int shm_id){
	int *p;
	p=(int *)shmat(shm_id,NULL,0);
	p[0]=rand()%101;
	printf("\nHo generato il numero %d, speriamo che il letto lo legga\n",p[0]);			
}
