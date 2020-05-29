#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

struct sembuf buffer;

void sem_lock(int);
void sem_unlock(int);

int main(){
	key_t sem_chiave=6641,mem_chiave=4417;
	pid_t pid,pid_fork;
	int M,N,semstato,*litri,flag=0,num,stato,shmid,semid,i;

	shmid=shmget(mem_chiave,1024,IPC_CREAT | 0666);
	semid=semget(sem_chiave,1,IPC_CREAT | 0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore\n");
		exit(-1);
	}

	while(M<50 && M>150){
		printf("\nInserisci la capacità della pompa:");
		scanf("%d",&M);
	}
	while(N<10 && N>20){
		printf("\nInserisci il numero di macchine:");
		scanf("%d",&N);
	}
	
	semstato=(int*)semctl(semid,0,GETVAL);
	litri[0]=M;
	litri[1]=0;
	litri[2]=M;
	
	for(i=0; i<N; i++){
		if((pid_fork=fork())==-1){
			printf("\nErrore\n");
			exit(-1);
		}
		if(pid_fork==0){
			srand(getpid());
			while(flag!=1){
				if(semctl(semid,0,GETVAL)==1){
					sem_lock(semid);				
					num=rand()%12+1;
					litri[0]=litri[0]-num;
					sem_unlock(semid);				
				}
			}
			exit(i);
		}
	}

	for(i=0; i<N; i++){
		pid=wait(&stato);
	}
	printf("\nHo finito\n");
	litri[1]=1;
	shmctl(shmid,IPC_RMID,NULL);
	semstato=semctl(semid,0,IPC_RMID,0);
return 0;
}

void sem_lock(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(semid,&buffer)==-1){
		printf("\nErrore blocco semaforo\n");	
	}
}
void sem_unlock(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(semid,&buffer)==-1){
		printf("\nErrore sblocco semaforo\n");	
	}
}
