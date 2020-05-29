#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(){
	pid_t pid_fork;
	int stato_figli, stato_padre,tot,i; 
	printf("\nQuanti processi figli vuoi creare --> ");	
	scanf("%d",&tot);	
	for(i=0; i<tot; i++){
		if((pid_fork=fork())<0){
			printf("\n***ERRORE***\n");	
			exit(-1);
		}
		if(pid_fork==0){
			printf("\n***Sono il processo figlio, il mio pid e' --> %d",getpid());	
			printf("\n***Mio padre ha pid %d\n",getppid());
			printf("\n***Ho terminato le mie azioni***\n");
			stato_figli=1;
			exit(stato_figli);	
			printf("\n");
		}
	}
	if(pid_fork!=0){
		printf("\n * * * Sono il padre * * *");
		printf("\n * * * Il mio pid di padre e' --> %d\n",getpid());
		pid_fork=wait(&stato_padre);
		printf("Terminato il figlio con stato %d e stato %d\n",pid_fork,stato_padre/256);
		printf("Ho finito\n");
	}	
return 0;
}
