//Mattia Audisio
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>

int main(){
	FILE *fp;
	pid_t pid_fork;
	int nFigli,stato,i;
	char stringa[30];
	
	printf("\nQuanti figli vuoi creare:");
	scanf("%d",&nFigli);
	for(i=0;i<nFigli;i++){
		if((pid_fork=fork())<0){
			printf("\nErrore nella fork...");
			exit(-1);
		}
		if(pid_fork==0){														//Sono nei figli
			printf("\nInserisci una stringa:");
			scanf("%s",stringa);
			fp=fopen("File.txt","a");
			fprintf(fp,"PID %d\tStringa:%s",getpid(),stringa);
			fclose(fp);
			exit(0);
			}else{
				exit(1);
			}
		}
	printf("***Sono il processo padre***");
	for(i=0;i<nFigli;i++){
		pid_fork=wait(&stato);		
	}
	fp=fopen("File.txt","r");		
return 0;
}
