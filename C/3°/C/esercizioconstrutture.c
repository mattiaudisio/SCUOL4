#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Dimensione(int);
void Giornate(char *, int, int );
int Pareggio(int ,char *, char *);
int Punti(int, char );

typedef struct{
    char nomisquadre[30], giornata1[30], giornata2[30] , fanalini[30];
    int  punteggi[30];
}   INFORMAZIONI;

int main() {
    INFORMAZIONI squadre[5];
    int i=0, N=20, D=30, cont=0, c=0, d=0, trov=0, j, tmp;    
	for(i=0; i<5; i++){
		do{
			printf("\nInserire la %d° squadra [ massimo 30 ]: ",i+1);
			scanf("%s",str);
		}while(strlen(str)>D);
		strcpy(squadre[i].nomisquadre,str);
		Giornate(squadre[i].giornata1, 1, i);
		Giornate(squadre[i].giornata2, 2, i);
		c=Punti(c,giornata1[i]);
		c=Punti(c,giornata2[i]);
		punteggi[i]=c;
		c=0;
	}
	printf("\nClassifica:\n");
	for(i=0; i<5; i++){
		printf("%s\t %s\n",squadre[i].squadre[i],squadre[i].punteggi[i]);
	}
	cont=Pareggio(N,giornata1,giornata2);
	printf("\nLe squadre che hanno pareggiato tutte le partite sono %d\n",cont);
	
	for(i=0; i<5; i++){
		if(punteggi[i]==0){
			strcpy(squadre[i].fanalini,squadre[i].nomisquadre);
			d++;
		}
	}
	if(d>0){
		printf("\nLe squadre con 0 punti sono:\n");
		for(i=0; i<d; i++){
			printf("%s\n",fanalini[i]);
		}
	}else printf("\nNon ci sono squadre con 0 punti\n");
	
	printf("\nInserire la squadra da cercare: ");
	scanf("%s",str);
	i=0;
	do{
		if(strcmp(str,squadre[i].nomisquadre)==0) trov=1;
		i++;
	}while(trov==0 && i<N);
	if(trov==1) printf("La squadra %s ha punteggio %d\n",str,punteggi[i-1]);
	else printf("Squadra non esistente\n");
	
	j=N;
	trov=0;
	do{
		trov=1;
		for(i=0; i<(j-1); i++){
			if(punteggi[i]<punteggi[i+1]){
				tmp=punteggi[i];
				punteggi[i]=punteggi[i+1];
				punteggi[i+1]=tmp;
				strcpy(str,squadre[i].squadre);
				strcpy(squadre[i].nomisquadre[i],squadre[i].nomisquadre[i+1]);
				strcpy(squadre[i].squadre[i+1],str);
				trov=0;
			}
		}
		j=j-1;
	}while(trov==0);
	
	i=0;
	printf("\nPrime in Classifica:\n");
	printf("%s\t%d\n",squadre[i].nomisquadre,squadre[i].punteggi);
	i++;
	while(i<N && (punteggi[i]==punteggi[i-1])){
		printf("%s\t %s\n",squadre[i].squadre,squadre[i].punteggi);
		i++;
	}
	
return 0;
}




int Dimensione(int x){

	int num;
	if(x==1){
		do{
			printf("Inserire il numero di squadre [ massimo 20 ]: ");
			scanf("%d",&num);
		}while(num>20 || num<1);
	}else{
		do{
			printf("Inserire il numero massimo di caratteri per squadra [ massimo 30 ]: ");
			scanf("%d",&num);
		}while(num>30 || num<1);
	}
	
return num;	
}

void Giornate(char *str, int giornata, int n){
	
	char x, a;
	do{
		while(getchar()!='\n');
		printf("Risultato nella %d° giornata [V=vinto, P=pareggio, S=sconfitta]: ",giornata);
		x=getchar();
	}while(x!='V' && x!='P' && x!='S' && x!='v' && x!='p' && x!='s');
	str[n]=x;

}

int Pareggio(int n, char *str1, char *str2){
	
	int c=0, i;
	for(i=0; i<n; i++){
		if(str1[i]=='p' && str2[i]=='p' || str1[i]=='P' && str2[i]=='P') c++;
	}

return c;
}

int Punti(int c, char giornata){

	if(giornata=='V' || giornata=='v') c+=3;
	else if(giornata=='P' || giornata=='p') c+=1;

return c;
}
