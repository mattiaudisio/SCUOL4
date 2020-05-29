/*Mattia Audisio 4C*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define USER_FILE "Persone.txt"
#define MY_FILE "Persone2.txt"
#define PERS_FILE "Persone3.txt"


typedef struct{
	char nome[20];
	int altezza,eta;
}PERSONA;

void menu(FILE *,PERSONA *);

int main(){
	PERSONA popolazione[20];
	FILE *fp;
	int f,i;
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
return 0;
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
