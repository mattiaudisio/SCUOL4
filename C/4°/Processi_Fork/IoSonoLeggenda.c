#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
	pid_t pid;
	int Nfigli,i,Numero;	

	printf("\nQuanti figli vuoi creare --> ");
	scanf("%d",&Nfigli);

	for(i=0; i<Nfigli; i++){
		if((pid=fork())<0){
			printf("\nErrore nella chiamata della fork\n");
			exit(-1);
		}
		if(pid==0){
			srand(time(pid));
			Numero=srand()100;
			if((numero%2)==0){
				printf("\n== HO VINTO ==\n");
				printf(fp,"\nIo %d sono uscito vittorioso da questa guerra grazie al numero %d\n",getpid(),numero);
			}	
		}
		exit(i);
	}
	printf("\n***Sono il padre e aspetto***\n");
	for(i=0; i<figli; i++){
		pid_fork=wait(&stato);
		if((numero%2)!=0){
			printf("\n%d hai combattutto con onore e, anche se non sei riuscito a vincere, il tuo nome verra' ricordato per sempre");
		}	
	}
return 0;
}
