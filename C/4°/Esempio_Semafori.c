#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/sem.h>		//contiene le caratteristiche delle funzioni dei semafori
#include <sys/ipc.h>		//serve per l'inizializzazione delle chiavi
#include <sys/types.h>		//Serve per la chiave del semaforo
#include <sys/shm.h>		//gestione memoria

#define DIM 1024		//dimensione della memoria

struct sembuf buffer; //Usata in sem_Lock e in sem_Unlock

void sem_Lock(int);
void sem_Unlock(int);
void listaSwitch();
void es1();
void es2();
void es3();
void es4();
void lettore(int);
void scrittore(int);

int main(){
	listaSwitch();
return 0;
}

void listaSwitch(){
	int scelta = 0;
	printf("\n1)Esercizio1\n2)Esercizio 2\n3)Esercizio 3\n4)Esercizio 4");
	scanf("%d",&scelta);
	switch(scelta){
		case(1):
			es1();
			break;
		case(2):
			break;
		case(3):
			break;
		case(4):
			break;
		default:
			printf("\nNumero sbagliato\n");
			break;
	}
}

void es1(){
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
}

void es2(){
	pid_t pid;
	key_t sem_chiave; 
	int sem_stato; 
	int sem_id; 
	int num, stato,nFigli,i;

	sem_chiave=1234;
	sem_id=semget(sem_chiave,1,IPC_CREAT|0666);
	if(sem_id==-1){
		printf("\nErrore\n");
		exit(-1);
	}
	sem_stato=semctl(sem_id,0,SETVAL,1);
	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&nFigli);
	for(i=0; i<nFigli; i++){
		if((pid=fork())<0){
			printf("\nErrore\n");
			exit(-2);
		}	
		if(pid==0){
			sem_Lock(sem_id);
			sem_stato=semctl(sem_id,0,GETVAL);
			printf("\nIl valore del semaforo e'-->%d\n",sem_stato);
			srand(getpid());
			num=rand()%10;
			printf("\nHo estratto il numero %d che sara' il mio valore di uscita\n",num);
			sem_Unlock(sem_id);
			exit(num);
		}
	}	
	for(i=0; i<nFigli; i++){
		pid=wait(&stato);
		printf("\nTerminato il figlio con stato %d\n", stato>>8);
		sem_stato=semctl(sem_id,0,IPC_RMID,0);
		printf("\nSemaforo rimosso\n");
	}
}

void es3(){
	pid_t pid;
	key_t sem_chiave, mem_chiave; 
	int sem_stato, sem_id, cheffaccio, stato, figli, i, shmid;

	sem_chiave=1234;	//chaive del semaforo
	mem_chiave=7786;	//chiave della memoria condivisa

	shmid=shmget(mem_chiave,DIM,IPC_CREAT | 0666);	//creo memoria 
	sem_id=semget(sem_chiave,1,IPC_CREAT | 0666);	//creo semaforo	

	if(sem_id==-1 || shmid==-1){
		printf("\nErrore nella creazione di memoria o semaforo!\n");
		exit(-1);
	}

	sem_stato=semctl(sem_id,0,SETVAL,1);	//setto semaforo
	
	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&figli);
	for(i=0; i<figli; i++){
		if((pid=fork())<0){
			printf("\nErrore\n");
			exit(-2);
		}	
		if(pid==0){
			srand(getpid());
			cheffaccio=rand()%2;			
			if(cheffaccio==0){
				//sono un lettore
				//operazioni da fare:
				//  verificare semaforo,
				//	se libero bloccarlo,
				//	leggere sulla memoria,
				//	sbloccare il semaforo,
				if(semctl(sem_id,0,GETVAL)==1){
					sem_Lock(sem_id);
					printf("\nSono il lettore e' blocco il semaforo\n");
					lettore(shmid);
					sem_Unlock(sem_id);	
				}	
			}else{
				//sono uno scrittore
				//operazioni da fare:
				//  verificare semaforo,
				//	se libero bloccarlo,
				//	scrivere sulla memoria,
				//	sbloccare il semaforo,
				if(semctl(sem_id,0,GETVAL)==1){
					sem_Lock(sem_id);
					printf("\nSono uno scrittore, blocco il semaforo e scrivo\n");
					scrittore(shmid);
					sem_Unlock(sem_id);
				}
			}
		exit(i);	
		}
	}	
	for(i=0; i<figli; i++){
		pid=wait(&stato);
		printf("\nTerminato il figlio con stato %d\n", stato>>8);
	}
	sem_stato=semctl(sem_id,0,IPC_RMID,0);
	printf("\nSemaforo rimosso\n");
	shmctl(shmid,IPC_RMID, NULL);
	printf("\nArea di memoria condivisa distrutta\n");
}

void es4(){
	pid_t pid;
	key_t sem_chiave, mem_chiave;
	int sem_id, sem_stato, chefaccio, stato, i, figli, shmid,flag=1;

	sem_chiave=1234;	
	mem_chiave=7786;	
	
	shmid=shmget(mem_chiave, DIM, IPC_CREAT |0666); 
	sem_id=semget(sem_chiave, 1, IPC_CREAT | 0666); 
	

	if(sem_id==-1 || shmid==-1){
		printf("ERRORE nella creazione di memoria o semaforo!");
		exit(-1);
	}

	sem_stato=semctl(sem_id, 0, SETVAL, 1); 
	
	printf("Inserisci il numero di figli da generare: ");
	scanf("%d", &figli);
	for(i=0; i<figli; i++){
		if((pid=fork())<0){
			printf("ERRORE!");
			exit(-2);
		}
		if(pid==0){
			srand(getpid());
			while(flag!=0){
				//flag=1;			NON SERVE PERCHÈ OGNI FIGLIO HA UNA VARIBILE FLAG SETTATA A 1
				chefaccio=rand()%2;
				if (chefaccio==0){
					if(semctl(sem_id,0,GETVAL)==1){
						sem_Lock(sem_id);
						printf("Sono il lettore ed ho bloccato il semaforo\n");
						lettore(shmid);
						sem_Unlock(sem_id);
						flag==0;
					}
				}else{
					if(semctl(sem_id,0,GETVAL)==1){
						sem_Lock(sem_id);
						printf("Sono uno scrittore, ho bloccato il semaforo e scrivo\n");
						scrittore(shmid);
						sem_Unlock(sem_id);
						flag==0;
					}
				}
			}
		exit(i);			
		} 
	}
	for(i=0;i<figli;i++){
		pid=wait(&stato);
		printf("Terminato il figlio con stato %d!\n",stato>>8);
	}
	sem_stato=semctl(sem_id, 0, IPC_RMID, 0);
	printf("Semaforo rimosso!\n");
	shmctl(shmid,IPC_RMID, NULL);
	printf("Area di memoria condivisa distrutta\n");
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

void lettore(int shm_id){	
	int *p;
	//mi collego alla memoria condivisa e leggo
	p=(int *)shmat(shm_id,NULL,SHM_RDONLY);
	printf("\nHo letto %d\n",p[0]);		 	
}

void scrittore(int shm_id){
	int *p;
	p=(int *)shmat(shm_id,NULL,0);
	p[0]=rand()%101;
	printf("\nHo generato il numero %d, speriamo che il letto lo legga\n",p[0]);			
}
