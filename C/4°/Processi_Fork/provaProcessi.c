//Mattia Audiso 4C PROVA
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>

int main(){
	pid_t	pid;
	int i,nFigli,num,stato;

	srand(time(NULL));
	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&nFigli);
	for(i=0; i<nFigli; i++){
		if((pid=fork())<0){
			printf("\nErrore nella creazione della memoria\n");
			exit(-1);			
		 }
		if(pid==0){
			num=rand()%100;
			printf("\nSono il %d° figlio e ho generato il numero %d\n",getpid(),num);
			exit(i);
		}
	}
	printf("\nSono il padre e aspetto\n");
	for(i=0; i<nFigli; i++){
		pid=wait(&stato);
		printf("\nTerminato figlio %d con stato %d\n",pid,stato>>8);
	}
return 0;
}
