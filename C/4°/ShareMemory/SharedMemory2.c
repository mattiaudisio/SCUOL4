#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>				//gestire chiave e mod accesso per memoria condivisa
#include <sys/shm.h>				//gestione memoria condivisa
#include <sys/types.h>				//gestire la chiave (key_t)

int main(){
	pid_t pid_fork;
	int shmid, stato, i, numero, *punt,quant;
	key_t chiave;	

	chiave=2011;
	//il padre crea la memoria condivisa
	shmid=shmget(chiave, 1024, IPC_CREAT | 0666);						//1024 VALORE IN BYTE;		i 3 permessi sono lettura,scrittura,esecuzione
	if(shmid==-1){
		printf("Errore nella creazione della memoria condivisa\n");
		exit (-1);
	}
	printf("\nQuanti figli vuoi creare: ");
	scanf("%d",&quant);
	for(i=0; i<quant; i++){
		if((pid_fork=fork())<0){
			printf("Errore nella fork\n");
			exit(-1);
		}	
		if(pid_fork==0){ 
			printf("Sono il %d°figlio\n",i+1);
			punt=(int *)shmat(shmid, NULL, 0);
			for(i=0;i<5;i++){
				printf("Inserisci un numero: ");
				scanf("%d",&numero);
				punt[i]=numero;
				printf("\n");
			}
			exit(1);
		}
	}
	printf("\n**SONO IL PADRE**\n");
	for(i=0;i<quant;i++){
		pid_fork=wait(&stato);			
	}
	for(i=0;i<quant;i++){
		printf("%d \t",punt[i]);		
	}		
	//il padre effettua la disconnessione dalla memoria condivisa
	if(shmdt(punt)==-1){
		printf("Errore nella disconnessione\n");
	}	
	//il padre distrugge la memoria condivisa
	shmctl(shmid, IPC_RMID, NULL);	
return 0;
}
