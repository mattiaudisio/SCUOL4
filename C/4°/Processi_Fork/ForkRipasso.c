#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
	pid_t pid_fork;
	int stato,i,figli,num;

	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&figli);

	for(i=0; i<figli; i++){
		if((pid_fork=fork())<0){
				printf("**ERRORE**");			
				exit(-1);
		}
		if(pid_fork==0){
			srand(getpid());			
			printf("\nSono il figlio\nIl mio pid e' --> %d\nIl pid di mio padre e' --> %d\n",getpid(),getppid());
			num=rand()%20;
			printf("Numero estratto: %d\n",num);
			exit(i);
		}
	}
	printf("\n***SONO IL PADRE***\n");
	printf("\n***IL MIO PID E' --> %d ***",getpid());
	for(i=0; i<figli; i++){
		pid_fork=wait(&stato);
		printf("\nProcesso %d terminato con stato %d",pid_fork,stato>>8);	
	}
	printf("\nHo finito le mie istruzioni\n");
return 0;
}
