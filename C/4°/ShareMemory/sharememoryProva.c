//Mattia Audisio 4C prova

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/types.h>

int main(){
	pid_t pid;
	key_t chiave;
	int lettore,i,shmid,numero,*punt,stato;

	chiave=3314;
	shmid=shmget(chiave, 1024, IPC_CREAT | 0666);	
	if(shmid==-1){
		printf("\nErrore nella creazione della memoria");
		exit(-1);
	}
	
	if((pid=fork())<0){
		printf("\nErrore nella creazione della memoria\n");
		exit(-1);
	}
	if(pid==0){
		punt=(int*) shmat(shmid, NULL, 0);
		printf("\nSono lo scrittore\nScrvi un numero: ");
		for(i=0; i<5; i++){
			scanf("%d",&numero);
		}
	}
	if((pid=fork())<0){
		printf("\nErrore nella creazione della memoria\n");
		exit(-1);
	}
	if(pid==0){
		printf("\nSono lo scrittore\nScrvi un numero: ");
		punt=(int*) shmat(shmid, NULL, SHM_RDONLY);
		for(i=0; i<5; i++){
			printf("%d \t",numero);
			punt[i]=numero;
		}
		printf("\n");
		exit(1);
	}

	for(i=0; i<2; i++){
		pid=wait(&stato);	
	}
	if(shmdt(punt)==-1){
		printf("\nErrore nella disconnessione della memoria\n");
		exit(-1);		
	}
	shmctl(shmid,IPC_RMID,NULL);
return 0;
}
