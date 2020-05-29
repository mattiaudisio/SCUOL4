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
	
	pid_t pid_fork, pid;
	key_t chiave_sem,chiave_shm;
	int stato=0,M=0,automobili=0,flag=1,num=0,i=0;
	int *litri;
	int shmid,semid,semstato;
	
	chiave_sem=7777;
	chiave_shm=4242;
	shmid= shmget(chiave_shm,DIM,IPC_CREAT|0666);
	semid= semget(chiave_sem,1,IPC_CREAT|0666);
	if(semid==-1||shmid==-1){
		printf("Errore nella creazione del semaforo o della memoria\n");
		exit(-1);
	}
	semstato=semctl(semid,0,SETVAL,1);			//METTO ZERO PERCHÈ C'È UN SOLO SEMAFORO
	litri=(int *)shmat(shmid,NULL,0);
	do{
		printf("Inserisci i litri della pompa di benzina (tra 50 e 150)");
		scanf("%d",&M);
	}while(M<50 || M>150);
	litri[0]=M;							//LITRI È IL NOSTRO VETTORE
	litri[1]=M;					
	litri[2]=0;							//PUNTATORE DELLA NOSTRA MEMORIA
	do{
		printf("Inserisci il numero di automobili");
		scanf("%d",&automobili);
	}while(automobili<10 || automobili>20);
	for(i=0;i<automobili;i++){
		if((pid_fork=fork())==-1){
			printf("Errore nella fork()");
			exit(-2);
		}
		if(pid_fork==0){
			srand(getpid());
			while(flag!=0){								//FLAG IMPOSTATO SUL PIENO
				if(semctl(semid,0,GETVAL)==1){
					if(litri[0]>20){
						sem_blocca(semid);
						printf("Sono l'auto numero %d e sto facendo rifornimento!\n",i);
						num=rand()%12+1;
						litri[0]=litri[0]-num;
						flag=0;
						printf("\nLitri rimasti---->%d\n",litri[0]);
						sem_sblocca(semid);
					}
				}								
			}
			exit(i);
		}
	}
	for(i=0;i<automobili;i++){
		pid=wait(&stato);
	}
	
	printf("Tutte le auto sono state rifornite!\n");
	litri[2]=1;
	shmctl(shmid,IPC_RMID,NULL);
	semstato=semctl(semid,0,IPC_RMID,0);
	


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

