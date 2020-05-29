#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int Menu();
void Esci();
int  creaRandom();
int perimetro();
int creaRandom();
int maggiore(); 
float calcolamedia(float float);
float quanti()

int main(){
	int menumainsrand; 

	srand=(time(NULL));
	menumain=Menu();

return 0;
}

int Menu(){
	int m,operatore,casi;
	printf("con A richiami il perimetro, B il maggiore, C quanti, D esci \n");
	scanf("%d",&operatore);
	switch(operatore){
		case 'A':
					casi=perimetro();
					break;
		case 'B':
					casi=maggiore();
					break;
		case 'C':
					casi=quanti();
					break;
		case 'D':
					casi=Esci();
					break;									
		default:
				printf("Inserimento errato \n");
				break;
	}
}

int perimetro(){
	int numlati,misura,perimetro;
	
	printf("Inserisci il numero dei lati \n");
	scanf("%d",numlati);
	misura=creaRandom();
	if(numlati>2){
		perimetro=misura*numlati;
		printf("Il perimetro vale %d\n",perimetro);
	}else{
		printf("Poligono non previsto \n");
	}
return perimetro;	
}

int creaRandom(){
	int misura;
	misura=rand()%2+30;
return misura;
}

int maggiore(){
	int numeri,i,mag;
	float pari=0,dispari=0,totpari=0,totdispari=0;
	printf("numeri da inserire \n");
	scanf("%d",&numeri);
	for(i=0;i<numeri;i++){
		if(numeri%2=0){
		   pari++;
		   totpari+=pari;
		}else{	
		   dispari++;
		   totdispari+=dispari;
		}		
	}
	pari=calcolamedia(pari,totpari);
	dispari=calcolamedia(dispari,totdispari);
	if(pari>dispari){
		mag='pari';
	}else{
		mag='dispari';
	}
	printf("Ci sono piu' numeri %d\n",mag);
return 	mag;
}

float calcolamedia(float pari , float totpari){
		int mediapari
		mediapari=(int)pari/totpari;
}

float calcolamedia(float dispari , float totdispari){
		int mediadispari
		mediapari=(int)dispari/totdispari;
}

float quanti(){
	int altezza,altezzapiu,altezzapiumaschi,altezzapiufemmine;
	float permaschi,perfemmine;
	char sesso;
	printf("Inserisci l'altezza di uno studente \n");
	scanf("%d",&altezza)
	while(altezza!=0){
		if(altezza>170){
			altezzapiu++;
		}	
		printf("Maschio o Femmina \n");
		sesso=getchar();
		if(sesso=='M'){
			maschi++;
		}else{
			femmine++;
		}
		if(altezza>170 && sesso=='M'){
			altezzapiumaschi++;
		}else{
			altezzapiufemmine++;
		totstudenti++;				
	}
	permaschi=calcolaPerc(int maschi, int altezzapiumaschi);
	perfemmine=calcolaPerc(int femmine, int altezzapiufemmine)
	printf("Totale alunni %d, %d alunni superano i 1.70m, studentesse %c, studenti %c, perc studentesse altezza , perc studenti altezza  ")		
}

float calcolaPerc(int maschi, int altezzapiumaschi){
		float permaschi;
		percmaschi=((int)altezzapiumaschi/maschi)*100;
}

float calcolaPerc(int femmine, int altezzapiufemmine){
		float perfemmine;
		percfemmine=((int)altezzapiufemmine/femmine)*100;
}
