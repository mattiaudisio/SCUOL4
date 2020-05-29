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
	
	shmid=shmget(mem_chiave,1024, IPC_CREAT | 0666);
	semid=semget(sem_chiave,1, IPC_CREAT | 0666);
	if(shmid<=-1 || semid<=-1){
		printf("\nErrore nella creazione");
	}

	printf("\nQuanti litri può contenere la pompa: ");
	scanf("%d",&M);
	printf("\nQuante macchine devo servire: ");
	scanf("%d",&N);

	semstato=semctl(semid,0,SETVAL,1);
	litri=(int *)shmat(shmid,NULL,0);
	litri[0]=M;
	litri[1]=0;		//se va a 1 l'autopompa si ferma
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
					if(litri[0]>=15){
						sem_lock(semid);
						num=rand()%12+1;
						litri[0]=litri[0]-num;
						flag=1;
						sem_unlock(semid);
					}
				}
			}
			exit(i);
		}
	}
	for(i=0; i<N; i++){
		pid=wait(&stato);
	}
	printf("\nHo terminato\n");
	litri[1]=1;
	shmctl(shmid,IPC_RMID,NULL);
	semstato=semctl(semid,0,IPC_RMID,0);
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
