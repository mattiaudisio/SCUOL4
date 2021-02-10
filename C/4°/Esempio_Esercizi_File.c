#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define MY_FILE "mattia.txt"
#define USER_FILE "user.txt"
#define USER_FILE "Persone.txt"
#define MY_FILE "Persone2.txt"
#define PERS_FILE "Persone3.txt"

typedef struct{
	char user[30];
	char pass[30];
	char email[30];
	int  age;	
}user;

typedef struct{
	char nome[20];
	int altezza,eta;
}PERSONA;

void listaSwitch();
void menu(FILE *,PERSONA *);
int lettura(char *, PERSONA *);
void stampa(FILE *,PERSONA *);
void qcoetanei(FILE *,PERSONA *);
void inserisci(FILE *,PERSONA *);

int main(void){
	FILE *fp;
	fp= fopen(MY_FILE, "w");
	if(!fp){
		printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
		exit(1);
	}
	// Scrivo su file
	fprintf(fp,"Questa è una prova di scrittura sul file %s\n",MY_FILE);
	if(fclose(fp) == -1){
		printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
	}else{
		printf("Dati scritti con successo sul file\n");
	}
return 0;
}

void listaSwitch(){
	PERSONA popolazione[20], u[20],elenco[20];
  FILE *fp;
  int scelta = 0,f,i,j;
  user u;
  printf("\n1) Esercizio1\n2) Esercizio2\n3) Esercizio3\n4) Esercizio4\n5) Esercizio5\n6) Esercizio6");
	scanf("%d",&scelta);
  switch(scelta){
    case(1):
        fp= fopen(MY_FILE, "w");
        if(!fp){
          printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
          exit(1);
        }
        // Scrivo su file
        fprintf(fp,"Questa è una prova di scrittura sul file %s\n",MY_FILE);
        if(fclose(fp) == -1){
          printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
        }else{
          printf("Dati scritti con successo sul file\n");
        }
        break;
    case(2):
        if(!(fp=fopen(USER_FILE,"a"))){
          printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
          exit(1);
        }
        printf("=> Inserimento di un nuovo utente <=\n\n");
        printf("Username: ");
        scanf("%s",u.user);	
        printf("Password: ");
        scanf("%s",u.pass);	
        printf("Email: ");
        scanf("%s",u.email);	
        printf("Eta': ");
        scanf("%s",&u.age);	
        //Scrivo i dati sul file
        printf("fp, %s\t%s\t%s\t%d\n",u.user,u.pass,u.email,u.age);
        printf("Dati scritti con successo sul file\n");
        fclose(fp);
        break;
    case(3):
    	if(!(fp=fopen(USER_FILE,"a"))){
          printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
          exit(1);
        }
        printf("\nQuanti numeri voi inserire --> ");
        scanf("%d",dim);
        for(i=0;i<dim;i++){
          printf("=> Inserimento di un nuovo utente <=\n\n");
          printf("Username: ");
          scanf("%s",u.user);	
          printf("Password: ");
          scanf("%s",u.pass);	
          printf("Email: ");
          scanf("%s",u.email);	
          printf("Eta': ");
          scanf("%d",&u.age);	
          //Scrivo i dati sul file
          printf(fp," %s\t%s\t%s\t%d\n",u.user,u.pass,u.email,u.age);
          printf("Dati scritti con successo sul file\n");
          fclose(fp);
        }
        break;
    case(4):
        if(!(fp=fopen(USER_FILE,"r"))){
          printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
          exit(1);
        }
        while(fscanf(fp," %s\t%s\t%s\t%d\n",u.user,u.pass,u.email,u.age)>0){
          printf("Utente: %s\n",u.user);
          printf("Password: %s\n",u.pass);
          printf("Email: %s\n",u.email);
          printf("Eta': %d\n",u.age);
          i++;	
        }
        printf("\nUtenti letti nel file: %d\n",&i);
        printf("-----------------------------------------------\n");
        for(j=0; j<i; j++){
          printf("Utente: %s\n",u[j].user);
          printf("Password: %s\n",u[j].pass);
          printf("Email: %s\n",u[j].email);
          printf("Eta': %d\n",u[j].age);
        }
        break;
          case(5):
          if(!fp){
          printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
          exit(1);
        }
        fp= fopen(MY_FILE, "w");
        if(!fp){
          printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
          exit(1);
        }
        while(fscanf(fp,"%s\t%s\t%d\t%s\n",u[i].cognome,u[i].nome,&u[i].annoNascita,&u[i].sesso)>0){
          i++;
        }
        for(f=0; f<i; f++){
          strcopy(USER_FILE[i].nome,MY_FILE[i].nome);	
          printf("\nInserisci l'altezza --> ");
          scanf("%d",&MY_FILE[i].nome);
          MY_FILE[i].eta=2018-USER_FILE[i].annoNascita;	
        }	
        menu(MY_FILE,popolazione);
        break; 
     case(6):
        if(!(fp=fopen(USER_FILE,"r"))){
          printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
          exit(1);
        }
        i=lettura(USER_FILE,elenco);

        stampa(fp,elenco);
        qcoetanei(fp,elenco);
        inserisci(fp,u);
        break;       
  }
}

//MENU'
void menu(char *file,PESONA *poplazione){
	int j,i,X;
	char scelta;
	float totaltezza,toteta;
	printf("\nMENU'\n");
	printf("0 – esci\n");
	printf("1 – visualizza file esistente con l’attuale contenuto\n");
	printf("2 – carica il contenuto del file dentro l’apposito vettore di struct popolazione in memoria\n");
	printf("3 – aggiungi un record a popolazione (chiedendo nome altezza età all’utente)\n");
	printf("4 – calcola e visualizza media delle età e delle altezze presenti in popolazione\n");
	printf("5 – aumenta l’altezza di ogni elemento di popolazione del valore X chiesto in input e memorizza il nuovo popolazione dentro 			altezze.txt\n");
	printf("6 – incrementa l’età di tutti gli elementi di popolazione di un anno\n");
	printf("7 – elimina il record di popolazione con nome X chiesto all’utente\n");
	printf("8 – ordina in ordine alfabetico i record di popolazione secondo il campo nome memorizzando il risultato in un file 				   				Persone3.txt\n");
	do{
		printf("\nscelta --> ");
		scanf("%s",scelta);
		switch(scelta){
			case '0':
					printf("\nSei uscito dal programma\n");			
					break;
			case '1':
					fp= fopen(MY_FILE, "a");
					if(!fp){
						printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
						exit(1);
					}
					while(fscanf(fp,"%s\t%s\t%d\t%s\n",u[i].cognome,u[i].nome,&u[i].annoNascita,&u[i].sesso)>0){
						i++;
					}
					if(fclose(fp) == -1){
						printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
					}else{
						printf("Dati scritti con successo sul file\n");
					}		
					break;
			case '2':
					fp= fopen(MY_FILE, "w");
					if(!fp){
						printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
						exit(1);
					}
					for(j=0;j<i;j++){
						strcopy(u[i].nome,*popolazione[j].nome);
						*popolazione[j].altezza=u[i].altezza;
						*popolazione[j].eta=u[i].eta;
					}			
					break;		
			case '3':
					if(!(fp=fopen(USER_FILE,"a"))){
						printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
						exit(1);
					}
					printf("=> Inserimento di un nuovo utente <=\n\n");
					printf("Nome: ");
					scanf("%s",u.nome);	
					printf("Altezza: ");
					scanf("%d",u.altezza);	
					printf("Eta': ");
					scanf("%d",u.eta);	
					printf("fp, %s\t%s\t%s\t%d\n",u.nome,u.altezza,u.eta);
					printf("Dati scritti con successo sul file\n");
					fclose(fp);
					break;	
			case '4':
					for(j=0; j<i; j++){
						totaltezza+=u[i].altezza;	
						toteta+=u[i].eta;
					}
					totaltezza=totaltezza/i;
					toteta=toteta/i;
					printf("\nMedia delle eta': %.2f\tMedia delle altezza: %.2f\n",toteta,totaltezza);
					break;	
			case '5':
					printf("\nDi quanto bisogna aumentare l'altezza --> ");
					scanf("%d",&X);
					for(j=0; j<i; j++){
						*popolazione[i].altezza+=X;
					}
					fp= fopen(MY_FILE, "w");
					if(!fp){
						printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
						exit(1);
					}
					for(j=0; i<j; j++){
						fprintf(fp,"%d\t",*popolazione[i].altezza);
					}
					if(fclose(fp) == -1){
						printf("Errore: impossibile aprire il file %s in scrittura\n",MY_FILE);	
					}else{
						printf("Dati scritti con successo sul file\n");
					}
					break;
			case '6':
					for(j=0; i<j; j++){
						*popolazione[i].eta+=1;
					}
					break;	
			case '7':

					break;
			case '8':

					break;		
		}	
	}while(scelta!=1);
}

/*SPOSTO Persone.txt IN UN VETTORE DI TIPO PERSONA CHIAMATO ELENCO*/
int lettura(char *file, PERSONA *elenco){
	FILE *fp;
	int i=0,j=0;
	if(!(fp=fopen(USER_FILE,"r"))){
		printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
		exit(-1);
	}
	while(fscanf(fp,"%s\t%s\t%d\t%s\n",u[i].cognome,u[i].nome,&u[i].annoNascita,&u[i].sesso)>0){
		i++;
	}
	for(j=0;j<i;j++){
		printf("Cognome: %s\n",u[j].cognome);
		printf("Nome: %s\n",u[j].nome);
		printf("Anno di nascita: %d\n",u[j].annoNascita);
		printf("Sesso: %d\n",u[j].sesso);
	}
	fclose(fp);
return i;
}

/*STAMPO IL VETTORE*/
void stampa(FILE *fp,PERSONA *elenco){
	int i=0;
	for(i=0;i<strlen(elenco);i++){
		printf("Cognome: %s\n",elenco.cognome);
		printf("Nome: %s\n",elenco.nome);
		printf("Anno di nascita: %d\n",elenco.annoNascita);
		printf("Sesso: %s\n",elenco.sesso);
	}
}

/*COETANEI*/
void qcoetanei(FILE *fp,PERSONA *elenco){
	int anno1,anno2,i,anno;
	char nome1[20],nome2[20];
	printf("\nDate 2 persone, sapere se sono quasi coetanee:\n");
	printf("\nMario\tMarta\tGaetaneo\tBianca\n");			
	printf("\nInserisci il primo nome -->");
	for(i=0;i<strlen(elenco);i++){
		if(strcmp(nome1,elenco[i].nome)==0){
			anno1=elenco[i].annoNascita;	
		}
	}	
	for(i=0;i<strlen(elenco);i++){
		if(strcmp(nome2,elenco[i].nome)==0){
			anno2=elenco[i].annoNascita;	
		}
	}	
	if(anno1>anno2){
		anno=anno1-anno2;
		if(anno>5){
			printf("\n%s e %s sono quasi coetanei\n",nome1,nome2);
		}	
	}else{
		anno=anno2-anno1;
		if(anno>5){
			printf("\n%s e %s sono quasi coetanei\n",nome1,nome2);
		}	
	}
}

/*INSERISCI I DATI DELL'UTENTE*/
void inserisci(FILE *fp,PERSONA *u){
	if(!(*fp=fopen(USER_FILE,"a"))){
		printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
		exit(1);
	}
	printf("\n=>INSERIMENTO NUOVO UTENTE<=\n");
	printf("Cognome: ");
	scanf("%s",u.cognome);	
	printf("Nome: ");
	scanf("%s",u.nome);	
	printf("Anno di nascita: ");
	scanf("%d",&u.annoNascita);	
	printf("Sesso: ");
	scanf("%d",u.sesso);		
	fclose(fp);
}
