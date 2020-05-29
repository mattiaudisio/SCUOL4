//Gianmarco Cerato 4c

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>

struct sembuf buffer;
void sem_Blocca(int semid);
void sem_Sblocca(int semid);

int main(){
	pid_t pid_t;
	key_t semChiave,memChiave;
	int shmid,semid,capacita,semstato,*punt;
	semChiave=1234;
	memChiave=4321;
	shmid=shmget(memChiave,1024,IPC_CREAT | 0666);
	semid=semget(memChiave,1024,IPC_CREAT | 0666);
	
	semstato=semctl(semid,1,SETVAL,1);
	punt=(int *) shmat(shmid,NULL,0);
	do{
		printf("Inserisci capacita' serbatoio (min 50 max 150): ");
		scanf("%d",&capacita);
	}while(capacita<50 || capacita>150);
	printf("capacita'--> %d\n",capacita);
	punt[0]=capacita;
	
	while(punt[1]!=0){
		printf("capacita'--> %d\n",punt[0]);
		if(punt[0]<=10){
			sem_Blocca(semid);
			printf("Faccio rifornimento\n");
			punt[0]=capacita;
			sleep(5);
			printf("Finito\n");				
			sem_Sblocca(semid);
		}
	}
	
	
	
	printf("Fine giornata. Chiusura\n");
	shmctl(shmid,IPC_RMID,NULL);
	semstato=semctl(semid,1,IPC_RMID,0);
	

return 0;
}

void sem_Blocca(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1;
	if(semop(semid,&buffer,1)==-1){
		printf("Errore blocco semaforo\n");
	}	
}

void sem_Sblocca(int semid){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1;
	if(semop(semid,&buffer,1)==-1){
		printf("Errore sblocco semaforo\n");
	}	
