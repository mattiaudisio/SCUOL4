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
	key_t memchiave=7881,semchiave=6534;
	pid_t pid,pid_fork;
	int i,M,N,*pompa,shmid,semid,num,semstato,flag=0,stato;

	shmid=shmget(memchiave, 1024, IPC_CREAT | 0666);
	semid=semget(semchiave, 1, IPC_CREAT | 0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore nella creazione della memoria e del semaforo");
		exit(-1);
	}
	while(M<50  || M>150){
		printf("Qual'e' la capacità della pompa [inserisci un numero compreso tra 50 e 150]: ");	
		scanf("%d",&M);
	}
	while(N<10 || N>20){
		printf("Quante macchine deve servire oggi[inserisci un numero compreso tra 10 e 20]");
		scanf("%d",&N);
	}

	semstato=semctl(semid,0,SETVAL,1);
	pompa=(int *)shmat(shmid,NULL,0);
	pompa[0]=M;		//pompa di benzina
	pompa[1]=0;		//serve per l'autobotte
	pompa[2]=M;

	for(i=0; i<N; i++){
		if((pid_fork=fork())==-1){
			printf("\nErrore\n");
			exit(-1);
		}
		if(pid_fork==0){
			srand(getpid());
			while(flag!=1){
				if(semctl(semid,0,GETVAL)==1){
					if(pompa[0]>=15){
						sem_lock(semid);
						printf("\nLa %d° macchina sta facendo rifornimento\n",i);
						num=rand()%12+1;
						pompa[0]=pompa[0]-num;
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
	pompa[1]=1;
	shmctl(shmid,IPC_RMID, NULL);
	semstato=semctl(semid,0,IPC_RMID,0);
return 0;
}

void sem_lock (int semid){
    buffer.sem_num=0; 
    buffer.sem_flg=0;
    buffer.sem_op=-1;
    if(semop(semid, &buffer, 1)==-1)
        printf("Errore blocco semaforo\n");
}
void sem_unlock (int semid){
    buffer.sem_num=0;
    buffer.sem_flg=0;
    buffer.sem_op=1;
    if(semop(semid, &buffer, 1)==-1)
        printf("Errore sblocco semaforo\n");
}
