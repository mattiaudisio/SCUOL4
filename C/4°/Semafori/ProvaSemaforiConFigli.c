#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <sys/types.h>

struct sembuf buffer; 

void sem_Lock(int);
void sem_Unlock(int);

int main(){
	pid_t pid;
	key_t sem_chiave; 
	int sem_stato; 
	int sem_id; 
	int num, stato,nFigli,i;

	sem_chiave=1234;
	sem_id=semget(sem_chiave,1,IPC_CREAT|0666);
	if(sem_id==-1){
		printf("\nErrore\n");
		exit(-1);
	}
	sem_stato=semctl(sem_id,0,SETVAL,1);
	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&nFigli);
	for(i=0; i<nFigli; i++){
		if((pid=fork())<0){
			printf("\nErrore\n");
			exit(-2);
		}	
		if(pid==0){
			sem_Lock(sem_id);
			sem_stato=semctl(sem_id,0,GETVAL);
			printf("\nIl valore del semaforo e'-->%d\n",sem_stato);
			srand(getpid());
			num=rand()%10;
			printf("\nHo estratto il numero %d che sara' il mio valore di uscita\n",num);
			sem_Unlock(sem_id);
			exit(num);
		}
	}	
	for(i=0; i<nFigli; i++){
		pid=wait(&stato);
		printf("\nTerminato il figlio con stato %d\n", stato>>8);
		sem_stato=semctl(sem_id,0,IPC_RMID,0);
		printf("\nSemaforo rimosso\n");
	}
return 0;
}

void sem_Lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Bloccato\n");
}

void sem_Unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Sbloccato\n");
}
