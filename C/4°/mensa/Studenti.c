#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <sys/sem.h>
#include <sys/wait.h>

#define SHM_SIZE 1024  /* dimensione della shared memory = 1K */
struct sembuf buffer;

void sem_Lock (int sem_id, int id);
void sem_Unlock (int sem_id, int id);


int main(){
  key_t sem_chiave, shm_chiave;
  int shm_id, sem_id, sem_stato[3];
  int j,*carrelli;
  int ncarrello,pid, homangiato=0;
  int pidstato, status;
  
  sem_chiave=1234;
  shm_chiave=7786;
  shm_id = shmget(shm_chiave, SHM_SIZE, IPC_EXCL|0666);
  sem_id = semget(sem_chiave, 3, IPC_EXCL|0666);         
 
  
  if (shm_id == -1 || sem_id == -1){
    printf("Errore nella gestione della memoria o del semaforo");
    exit(-1);
  }
 
    /* inizializzazione del puntatore alla shared memory */
    carrelli = (int*) shmat(shm_id, NULL, 0);
	
	for(j=0;j<20;j++){
	    if((pid=fork())<0){
	        printf("Errore creazione fork()\n");
	        exit(-2);
	    }
	    if(pid==0){
	        srand(getpid());
	        ncarrello=rand()%3;
	        while(homangiato != 1){
	            if(semctl(sem_id, ncarrello, GETVAL)==1){
			            sem_Lock(sem_id,ncarrello);  
			            if(carrelli[ncarrello] > 0){
			                printf("Studente %d: ho mangiato e poso il vassoio nel carrello n.%d\n",j, ncarrello);   
                            carrelli[ncarrello]--;  //poso il vassoio
                            homangiato=1;
                        }
                        sem_Unlock(sem_id,ncarrello);	                
	            }
	        }
	        exit(j);
	    }
	}
	for(j=0;j<20;j++){
	   pidstato=wait(&status);
	}
	printf("Tutti gli studenti hanno consumato il loro pasto. Ambrogio, puoi chiudere la mensa!\n");
	carrelli[3]=0;
	
  return 0;
}

void sem_Lock (int sem_id, int id){
    buffer.sem_num=id; //semaforo su cui voglio agire
    buffer.sem_flg=0;
    buffer.sem_op=-1;
    if(semop(sem_id,&buffer,1)==-1)
        printf("Errore blocco semaforo\n");
}

void sem_Unlock (int sem_id, int id){
    buffer.sem_num=id;
    buffer.sem_flg=0;
    buffer.sem_op=1;
    if(semop(sem_id, &buffer, 1)==-1)
        printf("Errore sblocco semaforo\n");
}
