//Mattia Audisio
/*Creare un programma che richieda da linea di comando:
  - il numero di figli da creare	
  - il range entro il quale ogni figlio dovrà creare i numeri random	

  ogni figlio deve stampare il numero creato
  il padre deve aspettare il termine corretto di ogni figlio	
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>

int main(int argc, char **argv){
	pid_t pid;
	int i,nFigli,rangemin=0,rangemax=0,num,stato;
	if(argc!=4){
		printf("\nERRORE\nUso: nome programma,nfigli,numero range minimo, numero range massimo\n");
	}else{
		nFigli=atoi(argv[1]);
		rangemin=atoi(argv[2]);
		rangemax=atoi(argv[3]);
		for(i=0; i<nFigli; i++){
			if((pid=fork())<0){
					printf("\n**ERRORE**\n");
					exit(-1);	
			}
			if(pid==0){
			    srand(getpid());			
				num=rand()%rangemax+rangemin;
				printf("\nCiao sono %d, il %d° figlio, e ho generato il numero %d\n",getpid(),i+1,num);	
				exit(i);
			}					
		}
//		printf("\n***SONO IL PADRE E ASPETTO***");	
		for(i=0; i<nFigli; i++){
			pid=wait(&stato);	
		}
		printf("\nHo terminato le mie istruzioni\n");	
	}					
return 0;
}
