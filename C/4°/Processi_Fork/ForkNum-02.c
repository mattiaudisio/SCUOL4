/*Un padre genera n figli e gli aspetta tutti prima di terminare*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>		

int main(){
	pid_t pid_fork;
	int figli,i,stato,num;
	
	printf("\nQuanti figli vuoi creare? ");
	scanf("%d",&figli);
	
	for(i=0; i<figli; i++){
		if((pid_fork=fork())<0){
			printf("\nErrore nella chiamata fork\n");
			exit(-1);
		}
		if(pid_fork==0){															
			num=rand()%20;
			printf("Sono il processo %d.Ho generato il numero %d\n",getpid(),num);			
			sleep(num);
			exit(i);			
		}
	}
	printf("\nSono il padre e aspetto\n");
	for(i=0; i<figli; i++){
		pid_fork=wait(&stato);
		printf("\nProcesso %d terminato con stato %d\n",pid_fork,stato>>8);	
	}
	printf("\nTutte le operazioni sono state concluse\n");
return 0;
}
