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

	semstato=(int*)semctl(semid,0,GETVAL);
	litri[0]=M;
	
	while(litri[1]!=1){
		if(litri[0<=15]){
			sem_lock(semid);
			printf("\nSto facendo rifornimento");
			litri[0]=litri[2];
			sem_unlock(semid);	
		}	
	}
	printf("\nHo finito\n");
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
