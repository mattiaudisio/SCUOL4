/* padre che genera un figlio*/

#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>		//per porre il padre in wait in attesa dei figli
#include <unistd.h>		//libreria che gestisce i processi


int main(){
	pid_t pid_fork;
	int stato;

	if((pid_fork=fork())<0){		//se la fork ritorna un valore negativo c'è stato un errore e devo terminare il programma
		printf("\nErrore nella fork\n");	
		exit(-1);
	}
	if(pid_fork==0){				//siamo nel figlio	
		printf("\nCiao sono il FIGLIO\n il mio pid e' --> %d\n il pid del padre e' --> %d\n",getpid(),getppid());
		printf("\nSono arrivati al termine delle mie istruzioni\n");
		stato=1;	//Posso fare semplicemente exit(1); ma stato serve al padre quando deve fare la wait
		exit(1);	//se non metto la exit() il processo figlio esegue i comandi del processo padre. LA EXIT() CI DEVE ESSERE SEMPRE PER OGNI FIGLIO
	}else{							//siamo nel padre
		printf("\n ***** Sono il PADRE ***** \nIl mio pid e' ---> %d\n il pid di mio padre e' ---> %d\n",getpid(),getppid());		
		pid_fork=wait(&stato);
		printf("\nIl figlio con pid %d ha terminato la sua esecuzione con stato %d\n",pid_fork,stato>>8);			//devo dividere stato per 256 oppure faccio uno shift
	}																												//con >>8 shifto di 8 bit			
	
return 0;
}
