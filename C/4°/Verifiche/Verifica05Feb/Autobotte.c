#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

void sem_blocca(int);
void sem_sblocca(int);
#define DIM 1024
struct sembuf buffer;
int main(){
	int *litri;
	int shmid,semid,semstato;
	key_t chiave_sem,chiave_shm;
	chiave_sem=7777;
	chiave_shm=4242;
	shmid= shmget(chiave_shm,DIM,IPC_EXCL|0666);
	semid= semget(chiave_sem,1,IPC_EXCL|0666);
	litri=(int*)shmat(shmid,NULL,0);
	
	litri[2]=0;
	
	if(semid==-1||shmid==-1){
		printf("Errore nell'accesso del semaforo o della memoria\n");
		exit(-1);
	}
	while(litri[2]!=1){
		if(litri[0]<21){
			sem_blocca(semid);
			printf("Sono l'auto pompa e faccio rifornimento!\n");
			litri[0]=litri[1];
			sleep(7);
			sem_sblocca(semid);
		}
	}
	printf("Tutte le auto sono rifornite il mio compito è finito!\n");
	
	
return 0;
}
void sem_blocca (int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(semid,&buffer,1)==-1)
		printf("Errore nel blocco del semaforo\n");
}
void sem_sblocca (int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1;
	if(semop(semid,&buffer,1)==-1){
		printf("Errore nello sblocco del semaforo\n");
	}
}

