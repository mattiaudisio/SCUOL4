#include <stdio.h>
#include <string.h>

typedef struct{
    char squadre[20],g1,g2;
    int punti; 
}INFORMAZIONI;

int main(){ 
    INFORMAZIONI  sq[30];
    int i,N=20,D=30,x,c=0,n=0,tmp,fanalini,cont,d=0,trov=0,j,N;

	for(i=0; i<N; i++){
		do{
			printf("\nInserire la %d° squadra [ massimo %d ]: ",i+1,D);
			scanf("%s",sq[i].str);
		}while(strlen(sq[i].str)>D);
		strcpy(sq[i].squadre[i],sq[i].str);
	    do{
		    while(getchar()!='\n');
		    printf("Risultato nella 1° giornata [V=vinto, P=pareggio, S=sconfitta]: ");
		    x=getchar();
	    }while(x!='V' && x!='P' && x!='S' && x!='v' && x!='p' && x!='s');
	    sq[i].str[n]=x;
	    if(sq[i].giornata1=='V' || sq[i].giornata1=='v') c+=3;
	    else if(sq[i].giornata1=='P' || sq[i].giornata1=='p') c+=1;
	    do{
		    while(getchar()!='\n');
		    printf("Risultato nella 2° giornata [V=vinto, P=pareggio, S=sconfitta]: ");
		    x=getchar();
	    }while(x!='V' && x!='P' && x!='S' && x!='v' && x!='p' && x!='s');
	    sq[i].str[n]=x;        
	    if(sq[i].giornata2=='V' || sq[i].giornata2=='v') c+=3;
	    else if(sq[i].giornata2=='P' || sq[i].giornata2=='p') c+=1;
    }
	printf("\nClassifica:\n");
	for(i=0; i<N; i++){
		printf("%s\t%d\n",sq[i].squadre,sq[i].punteggi);
	}
	for(i=0; i<5; i++){
		if(sq[i].str1[i]=='p' && sq[i].str2[i]=='p' || sq[i].str1[i]=='P' && sq[i].str2[i]=='P') c++;
	}
	printf("\nLe squadre che hanno pareggiato tutte le partite sono %d\n",cont);

	//FANALINI
	for(i=0; i<5; i++){1
		if(sq[i].punteggi[i]==0){
			strcpy(sq[d].fanalini,sq[i].squadre);
			d++;
		}
	}
	if(d>0){
		printf("\nLe squadre con 0 punti sono:\n");
		for(i=0; i<d; i++){
			printf("%s\n",sq[i].fanalini);
		}
	}else printf("\nNon ci sono squadre con 0 punti\n");
	
	printf("\nInserire la squadra da cercare: ");
	scanf("%s",sq[i].str);
	i=0;
	do{
		if(strcmp(sq[i].str,sq[i].squadre)==0) trov=1;
		i++;
	}while(trov==0 && i<5);
	if(trov==1) printf("La squadra %s ha punteggio %d\n",sq[i].str,sq[i-1].punteggi);
	else printf("Squadra non esistente\n");
	
	j=5;
	trov=0;
	do{
		trov=1;
		for(i=0; i<(j-1); i++){
			if(sq[i].punteggi<sq[i+1].punteggi){
				tmp=sq[i].punteggi;
				sq[i].punteggi=sq[i+1].punteggi;
				sq[i+1].punteggi=tmp;
				strcpy(sq[i].str,sq[i].squadre);
				strcpy(sq[i].squadre,sq[i].squadre);
				strcpy(sq[i+1].squadre,sq[i].str);
				trov=0;
			}
		}
		j=j-1;
	}while(trov==0);
	
	i=0;
	printf("\nPrime in Classifica:\n");
	printf("%s\t%d\n",sq[i].squadre,sq[i].punteggi);
	i++;
	while(i<N && (sq[i].punteggi==sq[i-1].punteggi)){
		printf("%s\t%d\n",sq[i].squadre,sq[i].punteggi);
		i++;
	}
}
