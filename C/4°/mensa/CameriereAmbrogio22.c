/* Ambrogio dispone 3 carrelli e apre la mensa. Se un carrello è pieno, provvede a svuotarlo. 
Quando tutti gli studenti hanno consumato il proprio pasto, chiude la mensa e pulisce il locale. */
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <sys/sem.h>

#define SHM_SIZE 1024  /* dimensione della shared memory = 1K */
struct sembuf buffer;

void sem_Lock (int sem_id, int id);
void sem_Unlock (int sem_id, int id);

int main(){
  key_t sem_chiave, shm_chiave;
  int shm_id, sem_id, sem_stato[3];
  int i,*carrelli;

  sem_chiave=1234;
  shm_chiave=7786;
  shm_id = shmget(shm_chiave, SHM_SIZE, 0666 | IPC_CREAT);
  sem_id = semget(sem_chiave, 2, IPC_CREAT|0666);         //creo il relativi semafori
    
  if (shm_id == -1 || sem_id == -1){
  	printf("Errore nella gestione della memoria o dei semafori");
    exit(-1);
  }
        
  for(i=0;i<2;i++){
  	sem_stato[i]=semctl(sem_id, i, SETVAL,1);   //setto i semafori 
  }        
  

  /* inizializzazione del puntatore alla shared memory */
 	carrelli = (int*) shmat(shm_id, NULL, 0);
	carrelli[0]=5; //primo carrello, inizialmente ha 5 ripiani liberi
	carrelli[1]=5; //secondo carrello, inizialmente ha 5 ripiani liberi
	carrelli[2]=1; //mensa aperta. Una volta disposti i carrelli, Ambrogio apre la mensa. 
	               //Quando tutti gli studenti avranno consumato il proprio pasto, la mensa verrà chiusa.
    printf("Ambrogio: La mensa e' aperta\n");
    
	while(carrelli[2] != 0){   
		for(i=0;i<2;i++){
		    if(carrelli[i]==0){
			    if(semctl(sem_id, i, GETVAL)==1){
			        sem_Lock(sem_id,i);  
			        printf("Ambrogio: sto svuotando il carrello n.%d\n",i);   
                    carrelli[i]=5;  //svuoto il carrello
                    sleep(15);      
       			    printf("Ambrogio: ho svuotato il carrello n.%d\n",i);
	                sem_Unlock(sem_id,i);
                }
            }
	    }
	}           
    
    printf("Ambrogio: Tutti gli studenti hanno consumato il loro pasto, devo chiudere la mensa...e sgomberare il locale\n");    
    shmctl(shm_id, IPC_RMID, NULL);
    for(i=0;i<2;i++){
  	    sem_stato[i]=semctl(sem_id, i, IPC_RMID,0);   //distruggo i semafori 
    }  
    printf("Ambrogio: La mensa e' chiusa. A domani.\n");
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
