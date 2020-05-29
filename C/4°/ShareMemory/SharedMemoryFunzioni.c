#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>

#define DIMENSIONE 1024

void scrittore(int);			//scrive i numeri
void lettore(int);				//legge i numeri e li stampa a video

int main(){
	int shmid,stato;
	pid_t pid_fork;
	key_t chiave;
	chiave=1234;

	shmid=shmget(chiave,DIMENSIONE,IPC_CREAT | 0666);
	if(shmid==-1){
		printf("\nErrore nella creazione della memoria condivisa\n");
		exit(-1);
	}
	if((pid_fork=fork())<0){
		printf("\nErrore nella creazione della fork\n");
		exit(-2);
	}
	if(pid_fork==0){
		scrittore(shmid);	
	}else{
		pid_fork=wait(&stato);			//contiene lo stato del figlio che ha terminato
		printf("\nIl figlio scrittore %d ha terminato il suo lavoro\n",pid_fork);
	}
	if((pid_fork=fork())<0){												//lo rifacciamo perchè dobbiamo creare un altro figlio
		printf("\nErrore nella creazione della fork\n");
		exit(-3);
	}
	if(pid_fork==0){
		lettore(shmid);
		exit(3);
	}
	else{
		pid_fork=wait(&stato);
		printf("\nIl figlio lettore %d ha terminato il suo lavoro\n",pid_fork);
	}
	//il padre  elimina la memoria
	shmctl(shmid, IPC_RMID, NULL);							//shmctl elimina la memoria condivisa
return 0;
}

void scrittore(int idMem){
	int *p;
	int i,numero;
	printf("\nSono il processo scrittore ed adesso scrivero' numeri\n");
	p=(int *)shmat(idMem,NULL,0);
	for(i=0;i<5;i++){
		printf("\nInserisci un numero: ");
		scanf("%d",&numero);
		p[i]=numero;
	}
	if(shmdt(p)==-1){
		printf("\nErrore nella disconnessione\n");
		//gestisci un valore di exit opportuna
	}else{	
		exit(2);
	}
}

void lettore(int idMem){
	int *p;
	int i;
	printf("\nSono il processo lettore ed adesso leggero' numeri\n");
	p=(int *)shmat(idMem,NULL,SHM_RDONLY);									//è impostato per leggere i numeri
	for(i=0;i<5;i++){
		printf("%d \t",p[i]);
	}	
	printf("\n");
	if(shmdt(p)==-1){
		printf("\nErrore nella disconnessione\n");
		//gestisci un valore di exit opportuna
	}else{	
		exit(3);
	}
}
