#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<time.h>
#include<sys/wait.h>

void listaSwitch();

int main(int argc, char **argv){							// ARGC vale n mentre ARGCV[0]= ./a.out		ES. ./a.out 5   ./a.out è argv[0] e 5 è argv[1] 
	listaSwitch(argc,argv)
return 0;
}

void listaSwitch(int argc, char **argv){
	pid_t pid;
	int scelta = 0,num1,num2,somma=0,i,nFigli,rangemin=0,rangemax=0,num,stato,primonum,secondonum,ris,operazione;
	float ris2;
	printf("\n1) esercizio1\n2) esercizio2\n3) esercizio3\n4) esercizio4");
	scanf("%d",&scelta);
	switch(scelta){
	case(1):
	    printf("Valore di argc = %d\n", argc);																		
	    for(i=0; i<argc; i++){
	      printf("Parametro argv[%d]= %s\n",i,argv[i]);
	    }
	    break;
	case(2):
	  if(argc!=3){
	      printf("\nERRORE\nUso: nome programma,numero,numero\n");
	    }else{
	      num1=atoi(argv[1]);							//atoi forza il numero in intero
	      num2=atoi(argv[2]);
	      somma=num1+num2;
	      printf("\nLa somma dei due numeri e' %d\n",somma);
	    }    
	  break;

	case(3):
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
	  break;

	case(4):
	    if(argc!=4){
	    printf("\nERRORE\nUso: primo numero, secondo numero, operazione(a, s, m, d)\n");
	  }else{	
	    primonum=atoi(argv[1]);
	    secondonum=atoi(argv[3]);
	    //operazione=*argv[2];
	    while((operazione=getopt(argc,argv,"asmd:"))!=-1){		
	      switch(operazione){
		case 'a':
		      ris=primonum+secondonum;
		      printf("\nsomma:%d\n",ris);
		      break;
		case 's':
		      if(primonum>secondonum){
			ris=primonum-secondonum;
			printf("\nsottrazione:%d\n",ris);
		      }else{
			ris=secondonum-primonum;
			printf("\nsottrazione:%d\n",ris);						
		      }
		      break;		
		case 'm':
		      ris=primonum*secondonum;
		      printf("\nprodotto:%d\n",ris);
		      break;
		case 'd':
		      if(primonum>secondonum){
			ris=(int)primonum/secondonum;
		      }else{
			ris=(int)secondonum/primonum;
		      }
		      printf("\ndivisione:%.2f\n",ris2);
		      break;
		default:
		      printf("\nInserimento errato\n");			
	  	      break;    
	      }	
	    }
	  }	
}
