//Gianmarco Cerato 4c

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
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
	int shmid,semid,automobili,semstato,*punt,i,benzina,esci,stato,flag=0,j;
	semChiave=1234;
	memChiave=4321;
	shmid=shmget(memChiave,1024,IPC_EXCL | 0666);
	semid=semget(memChiave,1024,IPC_EXCL | 0666);
	if(shmid==-1 || semid==-1){
		printf("\nErrore nel settaggio della memoria o del semaforo");
		exit(-2);
	}
	do{
		printf("Inserisci numero auto che passano nella giornata (min 10 max 20): ");
		scanf("%d",&automobili);
	}while(automobili<10 || automobili>20);
	printf("automobili--> %d\n",automobili);
	semstato=semctl(semid,1,SETVAL,1);
	punt=(int *) shmat(shmid,NULL,0);
	punt[1]=automobili;
	printf("punt 0 %d, punt 1 %d\n",punt[0],punt[1]);
	
	
	for(i=0; i<automobili; i++){
		if((pid_t=fork())<0){
			printf("\nErrore nella fork");
			exit(-1);
		}
		if(pid_t==0){//sono nel figlio cioe passa una macchina
			srand(getpid());
			while(flag!=1){
				benzina=rand()%12+1;
				if((semctl(semid,1,GETVAL))==1 && benzina<=punt[0] && benzina>10){//semaforo libero e c'è abbastanza benzina da fare il pieno
					sem_Blocca(semid);			
					punt[0]=punt[0]-benzina;
					printf("Auto %d ha fatto il pieno di %d. Ora il serbatoio ha %d litri\n",i,benzina,punt[0]);
					punt[1]--;		
					flag=1;	
					sem_Sblocca(semid);
				}
			}
	
			exit(i);
		}
	
	}
	for(j=0; j<automobili; j++){
		pid_t=wait(&esci);
	}



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
}





