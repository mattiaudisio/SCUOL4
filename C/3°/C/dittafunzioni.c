#include <stdio.h>

char menu(){
	char scelta
	while(getchar()!='\n');	
	printf("menu' \n");
	printf("a. stampare il costo di servizio minore tra tutte le ditte \n");
	printf("b. stampare il costo minore tra le ditte con reperibilità notturna = 'S' \n");
	printf("c. stampare il costo medio \n");
	printf("d. uscire dal programma  \n");
	printf("insersci un operatore \n");
	
	do{
		scanf("%c",&scelta);
		if(scelta!='a' && scelta!='b' && scelta!='c' && scelta!='d'){
			printf("Hai inserito una lettera non ammissibile!\n");
		}	
	}while(scelta!='a' && scelta!='b' && scelta!='c' && scelta!='d');	
	return scelta;
}	

int main(){
	int orelav=1,orecosto,costofisso,notte,S=0,prezzoconnotte=0,prezzoconnottemin=0,costotot,ditte=0,costomedio=0,costototmin=0;
	char operatore,;
	while(orelav!=0){
		ditte=ditte+1;
		printf("numero di ore previste \n");
		scanf("%d",&orelav);
		while(getchar()!='\n');
		if(orelav!=0){
			printf("il costo orario \n");
			scanf("%d",&orecosto);
			printf("il costo fisso relativo ai carburanti usati/sale/sabbia \n");
			scanf("%d",&costofisso);
			printf("la ditta e' reperibile di notte, S per si N per no \n");
			scanf("%d",&notte);
			costotot=(orecosto*orelav)+costofisso;
			printf(" il costo totale per questa ditta e' di %d euro \n",costotot);
			if(costotot<costototmin){
				costototmin=costotot;
			}else{
				costototmin=costototmin;
			}	
			costomedio=costomedio+costotot;		
			if(notte=='S'){
				S=S+1;
				prezzoconnotte=prezzoconnotte+costotot;
			}			
			if(prezzoconnotte<prezzoconnottemin){
				prezzoconnottemin=prezzoconnotte;
			}else{
				prezzoconnottemin=prezzoconnottemin;
			}
		}else{
		printf("\nil numero di ore previste non è valido\n");
		}	
	while(getchar()!='\n');
	}	
	costomedio=costomedio/ditte;
	printf("menu' \n");
	printf("A. stampare il costo di servizio minore tra tutte le ditte \n");
	printf("B. stampare il costo minore tra le ditte con reperibilità notturna = 'S' \n");
	printf("C. stampare il costo medio \n");
	printf("D. uscire dal programma  \n");
	printf("insersci un operatore \n");
	while(operatore!='D'){
		scanf("%c",&operatore);
		while(getchar()!='\n');	
		x=menu();
		switch (operatore){			
			case 'A':	
					printf("il costo di servizione minore tra tutte le ditte vale %d euro \n",costototmin);
					break;				
			case 'B':		
					printf("il costo minore tra le ditte con reperibilità notturna vale %d euro \n",prezzoconnottemin);
					break;
			case 'C':		
					printf("il costo medio vale %d euro \n",costomedio);
					break;
			case 'D':
					printf("\nil programma e' finito\n");
					break;
			default:
					printf("hai inserito una lettera non valida");
					break;		
		}	
	}
return 0;
}
