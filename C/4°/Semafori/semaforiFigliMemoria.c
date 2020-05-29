//Mattia Audisio 4C

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>	
#include <sys/ipc.h>	
#include <sys/types.h>	
#include <sys/shm.h>	

#define DIM 1024	

void sem_Lock(int);
void sem_Unlock(int);

void lettore(int);
void scrittore(int);

struct sembuf buffer;

int main(){
	pid_t pid;
	key_t sem_chiave, mem_chiave;
	int sem_id, sem_stato, chefaccio, stato, i, figli, shmid,flag=1;

	sem_chiave=1234;	
	mem_chiave=7786;	
	
	shmid=shmget(mem_chiave, DIM, IPC_CREAT |0666); 
	sem_id=semget(sem_chiave, 1, IPC_CREAT | 0666); 
	

	if(sem_id==-1 || shmid==-1){
		printf("ERRORE nella creazione di memoria o semaforo!");
		exit(-1);
	}

	sem_stato=semctl(sem_id, 0, SETVAL, 1); 
	
	printf("Inserisci il numero di figli da generare: ");
	scanf("%d", &figli);
	for(i=0; i<figli; i++){
		if((pid=fork())<0){
			printf("ERRORE!");
			exit(-2);
		}
		if(pid==0){
			srand(getpid());
			while(flag!=0){
				//flag=1;			NON SERVE PERCHÈ OGNI FIGLIO HA UNA VARIBILE FLAG SETTATA A 1
				chefaccio=rand()%2;
				if (chefaccio==0){
					if(semctl(sem_id,0,GETVAL)==1){
						sem_Lock(sem_id);
						printf("Sono il lettore ed ho bloccato il semaforo\n");
						lettore(shmid);
						sem_Unlock(sem_id);
						flag==0;
					}
				}else{
					if(semctl(sem_id,0,GETVAL)==1){
						sem_Lock(sem_id);
						printf("Sono uno scrittore, ho bloccato il semaforo e scrivo\n");
						scrittore(shmid);
						sem_Unlock(sem_id);
						flag==0;
					}
				}
			}
		exit(i);			
		} 
	}
	for(i=0;i<figli;i++){
		pid=wait(&stato);
		printf("Terminato il figlio con stato %d!\n",stato>>8);
	}
	sem_stato=semctl(sem_id, 0, IPC_RMID, 0);
	printf("Semaforo rimosso!\n");
	shmctl(shmid,IPC_RMID, NULL);
	printf("Area di memoria condivisa distrutta\n");
return 0;
}

void sem_Lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if((semop(id, &buffer, 1))==-1) printf("ERRORE!\n");
	else printf("Semaforo bloccato!\n");
}

void sem_Unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1;
	if((semop(id, &buffer, 1))==-1) printf("ERRORE!\n");
	else printf("Semaforo sbloccato!\n");
}

void lettore(int shm_id){
	int *p;
	//mi collego alla memoria condivisa e leggo
	p=(int *)shmat(shm_id,NULL,SHM_RDONLY);
	printf("Ho letto %d\n",p[0]);
}

void scrittore(int shm_id){
	int *p;
	p=(int *)shmat(shm_id,NULL,0);
	p[0]=rand()%101;
	printf("Ho generato il numero %d, speriamo che il lettore lo legga\n",p[0]);
}
