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
	int shmid,semid,semstato,*litri,M,N,flag=0,num,i;

	shmid=shmget(memChiave,1024, IPC_EXCL | 0666);	
	semid=semget(semChiave,1,IPC_EXCL | 0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore nella creazione\n");
		exit(-1);
	}

	printf("\nSono l'autopompa");
	litri[1]=0;	

	while(litri[0]!=1){
		if(litri[1]>=15){
			sem_lock(semid);
			printf("\nSto facendo rifornimento\n");
			litri[1]=litri[2];
			sleep(5);
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
