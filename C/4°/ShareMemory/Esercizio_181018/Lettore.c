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
	int shmid,i,max=0,min=999,*num;
	char *dati;
	
	//connessione alla memoria
	chiave=7786;
	shmid=shmget(chiave,DIM,0666|IPC_CREAT);
	if(shmid==-1){
		printf("\nErrore nella connessione alla memoria\n");		
		exit(-1);
	}
	//inizializzazione al puntatore
	dati=shmat(shmid,NULL,SHM_RDONLY);
	printf("\nLeggo la stringa\n");
	printf("%s \n",num);
	if(num>max){
		max=num;
	}
	if(num<min){
		min=num;
	}
	while(strcmp(num,"fine")!=0){
		printf("%d \n",num);
		if(*num>max){
			max=num;
		}
		if(*num<min){
			min=num;
		}
	}
	//disconnessione e distruzione della memoria
	printf("\nHo letto fine, quindi disconnetto e chiudo tutto\n"); 	
	print("max: %d\nmin:%d\n",max,min);
	if(shmdt(num)==-1){
		printf("\nErrore nella disconnessione del lettore\n");
		exit(-2);
	}
	printf("\nDistruggo la memoria\n");
	shmctl(shmid,IPC_RMID,NULL);
	printf("\nMemoria distrutta\n");
return 0;
}
