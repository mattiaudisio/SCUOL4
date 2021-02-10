#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //gestisce i processi
#include<time.h>
#include<sys/wait.h>

void elencoSwitch();

int main(int argc, char **argv){
	elencoSwitch(argc,argv);
return 0;
}

void elencoSwitch(int argc, char **argv){
	pid_t pid_fork,pid; //pid_t --> tipo del dato, permette la gestione del PID;		dichiarazione della variabile pid di tipo pid_t
  int scelta = 0,nFigli=0, min=0, max=0,temp,num,stato_figli, stato_padre,figli,i,stato,num;
  printf("\n1)Esercizio 1\n2)Esercizio 2\n3)Esercizio 3\n4)Esercizio 4\n5)Esercizio 5\n6)Esercizio 6\n7)Esercizio 7\n8)Esercizio 8\n9)Esercizio 9\n10)Esercizio 10");
	scanf("%d",&scelta);
  switch(scelta){
    case(1):
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
        break;
    case(2):
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
        break;
    case(3):
        if((pid_fork=fork())<0){
          printf("\n***ERRORE***\n");	
          exit(-1);
        }
        if(pid_fork==0){	//siamo nel processo figlio
          printf("\n***Sono il processo figlio, il mio pid e' --> %d",getpid());	
          printf("\n***Mio padre ha pid %d\n",getppid());
          printf("\n***Ho terminato le mie azioni***\n");
          stato_figli=1;
          exit(stato_figli);	
        }else{			//siamo nel processo padre
          printf("\n * * * Sono il padre * * *");
          printf("\n * * * Il mio pid di padre e' --> %d\n",getpid());
          pid_fork=wait(&stato_padre);
          printf("Terminato il figlio con stato %d e stato %d\n",pid_fork,stato_padre/256);
          printf("Ho finito\n");
        }
        break;
        case(4):
          printf("\nQuanti figli vuoi creare? ");
          scanf("%d",&figli);
          for(i=0; i<figli; i++){
            if((pid_fork=fork())<0){
              printf("\nErrore nella chiamata fork\n");
              exit(-1);
            }
            if(pid_fork==0){												//Sono nei figli
              printf("\nSono il figlio\nIl mio pid e' --> %d\n",getpid());
              exit(i);			
            }
          }
          printf("\nSono il padre e aspetto\n");
          for(i=0; i<figli; i++){
            pid_fork=wait(&stato);
            printf("\nProcesso %d terminato con stato%d\n",pid_fork,stato>>8);	
          }
          printf("\nTutte le operazioni sono state concluse\n");
        break;
    case(5):
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
      break;
    case(6):
        srand(time(NULL));
        printf("\nQuanti figli vuoi creare? ");
        scanf("%d",&figli);

        for(i=0; i<figli; i++){
          if((pid_fork=fork())<0){
            printf("\nErrore nella chiamata fork\n");
            exit(-1);
          }
          if(pid_fork==0){												//Sono nei figli
            printf("\nSono il figlio\nIl mio pid e' --> %d\n",getpid());
            num=rand()%20;
            printf("Numero estratto: %d",num);			
            exit(i);			
          }
        }
        printf("\nSono il padre e aspetto\n");
        for(i=0; i<figli; i++){
          pid_fork=wait(&stato);
          printf("\nProcesso %d terminato con stato%d\n",pid_fork,stato>>8);	
        }
        printf("\nTutte le operazioni sono state concluse\n");
        break;
    case(7):
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
        break;
    case(8):
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
        break;
    case(9):
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
        break;
    case(10):
         srand(time(NULL));
        printf("\nQuanti figli vuoi creare --> ");
        scanf("%d",&nFigli);
        for(i=0; i<nFigli; i++){
          if((pid=fork())<0){
            printf("\nErrore nella creazione della memoria\n");
            exit(-1);			
           }
          if(pid==0){
            num=rand()%100;
            printf("\nSono il %d° figlio e ho generato il numero %d\n",getpid(),num);
            exit(i);
          }
        }
        printf("\nSono il padre e aspetto\n");
        for(i=0; i<nFigli; i++){
          pid=wait(&stato);
          printf("\nTerminato figlio %d con stato %d\n",pid,stato>>8);
        }
        break;
    default:
        printf("\nInserisci un numero tra 1 e 10");
        break;
  }
}
