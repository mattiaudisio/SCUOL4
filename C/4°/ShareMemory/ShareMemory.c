#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

#include <sys/ipc.h>				//gestire chiave e mod accesso per memoria condivisa
#include <sys/shm.h>				//gestione memoria condivisa
#include <sys/types.h>				//gestire la chiave (key_t)

int main(){
	pid_t pid_fork;
	int shmid,stato, *punt,i,numero;
	key_t chiave;	

	chiave=2011;	
	shmid=shmget(chiave, 1024, IPC_CREAT | 0666);			//0666 è il permesso di lettura della memoria
	if(shmid=-1){
		printf("\nErrore nella creazione della memoria condivisa\n");
		exit(-1);
	}

	if((pid_fork=fork())<0){
		printf("\nErrore nella fork\n");
		exit(-1);
	}		
	if(pid_fork==0){										//siamo nel figlio che scrive
			printf("\nSono il processo che scrive\n");
			punt=(int *)shmat(shmid, NULL, 0);
			for(i=0; i<5; i++){
				printf("\nInserisci un numero: ");
				scanf("%d",&numero);
				punt[i]=numero;
			}
			exit(1);
	}
	if((pid_fork=fork())<0){
		printf("\nErrore nella fork\n");
		exit(-1);
	}		
	if(pid_fork==0){										//siamo nel figlio che legge
			sleep(10);
			printf("\nSono il processo che legge\n");
			punt=(int *)shmat(shmid, NULL, SHM_RDONLY);
			for(i=0; i<5; i++){
				printf("%d \t",punt[i]);
			}
			printf("\n");
			exit(0);	
	}
	
	for(i=0; i<2; i++){
		pid_fork=wait(&stato);
	}

	//il padre effettua la disconnessione dalla memoria condivisa
	if(shmdt(punt)==-1){
		printf("\nErrore nella disconnessione\n");
		exit(-1);
	}
	//il padre distrugge la memoria condivisa
	shmctl(shmid, IPC_RMID, NULL);
return 0;
}
