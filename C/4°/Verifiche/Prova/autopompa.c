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

void sem_lock(int semid);
void sem_unlock(int semid);

int main(){
	pid_t pid,pid_fork;
	key_t sem_chiave=7742,mem_chiave=1156;
	int semstato,M,N,*litri,i,flag=0,num,shmid,semid,stato;

	shmid=shmget(mem_chiave,1024, IPC_EXCL | 0666);
	semid=semget(sem_chiave,1, IPC_EXCL | 0666);
	if(shmid<=-1 || semid<=-1){
		printf("\nErrore nella connessione");
	}

	litri=(int *)shmat(shmid,NULL,0);
	litri[1]=0;

	while(litri[1]!=1){
		if(litri[0]<=15){
			sem_lock(semid);
			printf("\nSto facendo rifornimento\n");
			litri[0]=litri[2];
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
	if(semop(semid, &buffer, 1)==-1)
		printf("\nErrore blocco semaforo\n");
}

void sem_unlock(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1;
	if(semop(semid, &buffer, 1)==-1)
		printf("\nErrore sblocco semaforo\n");
}
