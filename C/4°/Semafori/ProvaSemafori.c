#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>		//contiene le caratteristiche delle funzioni dei semafori
#include <sys/ipc.h>		//serve per l'inizializzazione delle chiavi
#include <sys/types.h>		//Serve per la chiave del semaforo	

struct sembuf buffer; //Usata in sem_Lock e in sem_Unlock

void sem_Lock(int);
void sem_Unlock(int);

int main(){
	pid_t pid;
	key_t sem_chiave;		//chiave del semaforo
	int sem_stato;		//stato semafor
	int sem_id;			//identificativo del semaforo
	int num,stato;	

	sem_chiave=1234;
	/*semget(chiave,numero dei semafori,flag)--> restituisce sem_id*/ 
	sem_id=semget(sem_chiave,1,IPC_CREAT|0666);
	if(sem_id==-1){
		printf("\nErrore\n");
		exit(-1);
	}
	/* semctl setta le operazioni per il controllo del semaforo

		semctl(sem_id, numeroSemaforo, operazione, union semun*argomenti)
		 operazione SETVAL setta il semaforo --> ultimo argomento di default è 1
		 operazione GETVAL restituisce il valore del semaforo --> ignorato 
		 operazione IPC_RMID distrugge il semaforo --> ultimo argomento di default è 0
	*/	
	sem_stato=semctl(sem_id,0,SETVAL,1);
	if((pid=fork())<0){
		printf("\nErrore\n");
		exit(-2);
	}
	if(pid==0){
		//all'interno del figlio che blocca il semaforo
		sem_Lock(sem_id);
		sem_stato=semctl(sem_id,0,GETVAL);
		printf("\nIl valore del semaforo e' --> %d\n",sem_stato);
		srand(getpid());
		num=rand()%10;
		printf("\nHo estratto questo numero qua che sarà il mio valore d'uscita %d\n",num);
		sem_Unlock(sem_id);
		exit(num);
	}else{
		pid=wait(&stato);
		printf("\nTerminato il figlio con stato %d\n", stato>>8);
		sem_stato=semctl(sem_id,0,IPC_RMID,0);
		printf("\nSemaforo rimosso\n");
	}
return 0;
}

void sem_Lock(int id){
	/*semop permette di impostare le operazioni che devono essere fatte sul semaforo
 
		semop(id,struct sembuf *operazione,numeriElementi)
		   struttura sembuf costituita da:
			- nSemaforo
			-flag
			-tipoOperazione

		prima di usare la semop devo settare la struttura
	*/
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=-1;		//sem_op=-1 wait logica (semaforo bloccato)
	if(semop(id,&buffer,1)==-1){
		printf("\nErrore\n");
	}else{
		printf("\nSemaforo Bloccato\n");
	}
}

void sem_Unlock(int id){
	buffer.sem_num=0;
	buffer.sem_flg=0;
	buffer.sem_op=1; //semaforo sbloccato
	if(semop(id,&buffer,1)==-1){
		printf("\nErrore\n");
	}else{
		printf("\nSemaforo Sbloccato\n");
	}
}
