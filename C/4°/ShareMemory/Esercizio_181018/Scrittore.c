//Mattia Audisio

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <string.h>
#include <time.h>

#define DIM 1024

int main(){
	key_t chiave;
	int shmid,i,N,t,num,*punt;
	
	//creazione della memoria
	chiave=7786;															
	shmid=shmget(chiave,DIM,0666|IPC_CREAT);
	if(shmid==-1){
		printf("\nErrore nella creazione della memoria\n");
		exit(-1);
	}	
	//connessione alla memoria
	punt=(int*)shmat(shmid,NULL,0);
	printf("\nQuanti numeri devo creare: ");
	scanf("%d",&N);
	punt[0]=N;												//lo metto nella prima cella per poi fare il ciclo					 							
	srand(time(NULL));
	for(t=0;t<N;t++){
		punt[i]=rand()%20;
	}
	printf("\nHai scelto di smettere\n");	
	//disconnessione
	if(shmdt(punt)==-1){
		printf("\nErrore nella disconnessione");
		exit(-2);
	}
return 0;
}
