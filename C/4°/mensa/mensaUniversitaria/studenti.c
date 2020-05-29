//Mattia Audisio 4C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <sys/times.h>
#include <sys/shm.h>

#define DIM 1024

void sem_lock(int);
void sem_unlock(int);

struct sembuf buffer;

int main(){
	pid_t pid_fork;
	key_t shm_chiave, sem_chiave;
	int shmid,sem_id,sem_stato,i,nFigli,num,esci=0,stato,*vassoi;

	sem_chiave=5581;
	shm_chiave=3376;
  	shmid = shmget(shm_chiave, SHM_SIZE, IPC_EXCL|0666);
    sem_id = semget(sem_chiave, 3, IPC_EXCL|0666);         

	if(shmid==-1 || sem_id==-1){
		printf("\nErrore nella creazione\n");
		exit(-1);
	}
	printf("\nQuanti figli vuoi creare: ");	
	scanf("%d",&nFigli);	
	
   /* inizializzazione del puntatore alla shared memory */
    vassoi = (int*) shmat(shmid, NULL, 0);	
	for(i=0; i<nFigli; i++){
		if((pid_fork=fork())<0){
			printf("\nErrore nella chiamata fork\n");
			exit(-1);
		}
		if(pid_fork==0){
			srand(getpid());
			num=rand()%3;
			while(esci!=1){
				if(vassoi[num]==0){
					sem_lock(sem_id);
					printf("\nStudente %d: ho posato il vassoio\n",getpid());					
					sem_unlock(sem_id);
					vassoi[num]--;	
					esci=1;
				}else{
					if(num!=2){
						num=num-2;
					}else{
						num=num+1;
					}
				}

			}	
		}
	}
	for(i=0; i<nFigli; i++){
		pid_fork=wait(&stato);
	}
	printf("\nTutti gli studenti hanno finito di magiare\n");
	vassoi[3]=1;
return 0;
}

void sem_lock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Bloccato\n");
}

void sem_unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; 
	if(semop(id,&buffer,1)==-1)
		printf("\nErrore\n");
	else
		printf("\nSemaforo Sbloccato\n");
}
