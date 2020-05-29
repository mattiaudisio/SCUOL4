/* Aggiungere controllo finale 
chiedere da linea di comando 
- il numero dei figli
- il range
- il valore di uscita per i vincitori
- il valore di uscita per i perdenti
*/

#include<sys/wait.h>
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<time.h>

int main(int argc, char **argv){
	pid_t pid_fork;
	int nFigli=0, min=0, max=0,temp,num;
	if(argc!=4){
		printf("\nERRORE!\n");
	}else{	
		nFigli=atoi(argv[1]);	
		min=atoi(argv[2]);	
		max=atoi(argv[3]);
		if(min>max){
			temp=max;
			max=min;
			min=temp;
		}	
		for(i=0;i<nFigli;i++){
			if((pid_fork=fork())<0){
				printf("\nErrore nella fork...");
				exit(-1);
			}
			if(pid_fork==0){
				srand(getpid());
				printf("\nProcesso figlio\n,il mio pid --> %d",getpid());
				num=rand()%((max-min)+1)+min;
				printf("Ho generato il numero --> %d",numrand);
				exit(i)	
				}
		}
		printf("***Sono il processo padre pid: %d***",getpid());
		for(i=0;i<nFigli;i++){
			pid_fork=wait(&stato);
		}
	}		
return 0;
}
