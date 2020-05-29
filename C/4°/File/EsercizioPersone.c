/*Mattia Audisio 4C*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define USER_FILE "Persone.txt"

typedef struct{
	char cognome[30];
	char nome[30];
	char sesso;
	int annoNascita;
}PERSONA;

int lettura(char *, PERSONA *);
void stampa(FILE *,PERSONA *);
void qcoetanei(FILE *,PERSONA *);
void inserisci(FILE *,PERSONA *);

int main(){
	FILE *fp;
	PERSONA u[20],elenco[20];
	int j,i=0;	
	if(!(fp=fopen(USER_FILE,"r"))){
		printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
		exit(1);
	}
	i=lettura(USER_FILE,elenco);
		
	stampa(fp,elenco);
	qcoetanei(fp,elenco);
	inserisci(fp,u);
return 0;
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
