#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
	pid_t pid_fork;
	int stato;
	
	if((pid_fork=fork())<0){
		printf("\nErrore\n");
		exit(-1);
	}	
	if(pid_fork==0){
		printf("\nSono il figlio\nIl mio pid e' -->%d\n Quello di mio padre e' -->%d",getpid(),getppid());
		stato=1;
		exit(1);
	}else{
		printf("\nSono il padre\nIl mio pid e' -->%d\n Quello di mio padre e' -->%d",getpid(),getppid());
		wait(&stato);
		printf("\n--Ho terminato il mio compito--\n");
	}	
return 0;
}
