#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

struct sembuf buffer;

void sem_lock(int);
void sem_unlock(int);

int main(){
	key_t memchiave,semchiave;
	int i,M,N,*pompa,shmid,semid,num,semstato;

	memchiave=7881;
	semchiave=6534;
	shmid=shmget(memchiave,1024,IPC_EXCL|0666);
	semid=semget(semchiave,1,IPC_EXCL|0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore nella connessione\n");
		exit(-1);
	}

	pompa=(int *)shmat(shmid,NULL,0);
	pompa[1]=0;

	while(pompa[1]!=1){
		if(pompa[0]<=15){
			sem_lock(semid);
			printf("\nSto facendo riforniemnto\n");
			pompa[0]=pompa[2];
			sleep(5);
			sem_unlock(semid);
		}
	}	
	printf("\nHo finito\n");	
return 0;
}

void sem_lock (int semid){
    buffer.sem_num=0; 
    buffer.sem_flg=0;
    buffer.sem_op=-1;
    if(semop(semid, &buffer, 1)==-1){
        printf("Errore blocco semaforo\n");
	}
}
void sem_unlock (int semid){
    buffer.sem_num=0;
    buffer.sem_flg=0;
    buffer.sem_op=1;
    if(semop(semid, &buffer, 1)==-1){
        printf("Errore sblocco semaforo\n");
	}
}
