#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <time.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>
#include <unistd.h>

struct sembuf buffer;

void sem_lock(int );
void sem_unlock(int );

int main(){
	pid_t pid_fork,pid;
	key_t semChiave=6645,memChiave=1189;
	int shmid,semid,semstato,*litri,M,N,flag=0,num,i,stato;

	shmid=shmget(memChiave,1024, IPC_CREAT | 0666);	
	semid=semget(semChiave,1,IPC_CREAT | 0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore nella creazione\n");
		exit(-1);
	}
	
	while(M<=50 && M>=150){
		printf("\nInserisci la capacita' dell'autopompa:");
		scanf("%d",&M);	
	}
	while(M<=10 && M>=20){
		printf("\nInserisci il numero delle macchine:");
		scanf("%d",&N);	
	}

	semstato=semctl(semid,0,SETVAL,1);
	litri=shmat(shmid,NULL,0);
	litri[0]=M;		//Capacità della pompa
	litri[1]=0;		//serve per stoppare l'autobotte
	litri[2]=0;		//serve per rifornire la pompa
	
	for(i=0; i<N; i++){
		if((pid_fork=fork())==-1){
			printf("\nERRORE\n");			
			exit(-1);
		}
		if(pid_fork==0){
			srand(getpid());
			while(flag!=1){
				if(semctl(semid,0,GETVAL)==1){
					sem_lock(semid);
					printf("\nSono la %d° macchina e sto facendo rifornimento",i);
					num=rand()%12+1;
					litri[0]=litri[0]-num;	
					flag=1;
					sem_unlock(semid);
				}
			}
		}
		exit(i);
	}
	for(i=0; i<N; i++){	
		stato=wait(&pid);	
	}
	litri[1]=1;	
	printf("\nHo finito\n");
	shmctl(shmid,IPC_RMID,NULL);
	semstato=semctl(semid,0,IPC_RMID,0);
return 0;
}

void sem_lock(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(semid, &buffer,1)==-1){
		printf("\nErrore blocco semaforo\n");
	}
}

void sem_unlock(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(semid, &buffer,1)==-1){
		printf("\nErrore sblocco semaforo\n");
	}
}
