#include<stdio.h>
#include<string.h>

typedef struct{
    char str[100],
    int  eta, stipendio;
}   INFORMAZIONI;



int main(){
    INFORMAZIONI pers[5];
    int i=0, N=20, D=30, punteggi[N], cont=0, c=0, d=0, trov=0, j, tmp,num,x=1,n;
    char squadre[N][D], ="", giornata1[N], giornata2[N], fanalini[N][D];
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
	for(i=0; i<N; i++){
		do{
			printf("\nInserire la %d° squadra [ massimo %d ]: ",i+1,D);
			scanf("%s",str);
		}while(strlen(str)>D);
		strcpy(squadre[i],str);
	    do{
		    while(getchar()!='\n');
		    printf("Risultato nella 1° giornata [V=vinto, P=pareggio, S=sconfitta]: ");
		    x=getchar();
	    }while(x!='V' && x!='P' && x!='S' && x!='v' && x!='p' && x!='s');
	    str[n]=x;
	    do{
		    while(getchar()!='\n');
		    printf("Risultato nella 2° giornata [V=vinto, P=pareggio, S=sconfitta]: ");
		    x=getchar();
	    }while(x!='V' && x!='P' && x!='S' && x!='v' && x!='p' && x!='s');
	    str[n]=x;
	    if(giornata[i]=='V' || giornata[i]=='v') c+=3;
	    else if(giornata=='P' || giornata[i]=='p') c+=1;		
	    if(giornata2[i]=='V' || giornata2[i]=='v') c+=3;
	    else if(giornata2[i]=='P' || giornata2[i]=='p') c+=1;		
		punteggi[i]=c;
		c=0;
	}
	printf("\nClassifica:\n");
	for(i=0; i<N; i++){
		printf("%s\t%d\n",squadre[i],punteggi[i]);
	}
	for(i=0; i<n; i++){
		if(str1[i]=='p' && str2[i]=='p' || str1[i]=='P' && str2[i]=='P') cont++;
	}
	printf("\nLe squadre che hanno pareggiato tutte le partite sono %d\n",cont);
	
	for(i=0; i<N; i++){
		if(punteggi[i]==0){
			strcpy(fanalini[d],squadre[i]);
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
		if(strcmp(str,squadre[i])==0) trov=1;
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
				strcpy(str,squadre[i]);
				strcpy(squadre[i],squadre[i+1]);
				strcpy(squadre[i+1],str);
				trov=0;
			}
		}
		j=j-1;
	}while(trov==0);
	
	i=0;
	printf("\nPrime in Classifica:\n");
	printf("%s\t%d\n",squadre[i],punteggi[i]);
	i++;
	while(i<N && (punteggi[i]==punteggi[i-1])){
		printf("%s\t%d\n",squadre[i],punteggi[i]);
		i++;
	}
	
return 0;
}
