/* Eseguire una fork e generare un figlio, stampando il PID del padre e del figlio */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //gestisce i processi

int main(){
	pid_t pid; //pid_t --> tipo del dato, permette la gestione del PID;		dichiarazione della variabile pid di tipo pid_t
	
	if((pid=fork())<0){
		printf("\nErrore nella chiamata della fork\n");
		exit(-1);				//metto '-1' perchè '0' significa che non da errore
	}	
	//Ora il processo padre e il processo figlio diventano 2 processi separati
	if(pid_fork==0){		//sono nel processo figlio; prima bisogna chiudere il processo figlio, poi il processo padre
		printf("\n**** Sono il processo FIGLIO ****\n");
		printf("Questo e' il mio PID ---> %d\n",getpid());		//getpid() mi da il PID del processo; se al posto di getpid scrivo pid mi da 0
		printf("Padre, questo e' il tuo pid --> %d\n",getppid()); 	//getppid() mi da il PID del processo padre
		exit(0);
	}else{ 	//sono nel padre		
		printf("\n**** Sono tuo padre ****\n");
		printf("Io che sono il padre ho questo pid --> %d\n e sono stato generato da questo pid--> %d\n",getpid(),getppid());
	} //QUESTO PROGRAMMA E' SBAGLIATO PERCHE' IL PADRE SI CHIUDE PRIMA DEL FIGLIO
	printf("\n****** Il programma e' finito ******\n");
	
return 0;
}
