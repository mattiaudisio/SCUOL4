#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char **argv){
	int primonum,secondonum,ris,operazione;
	float ris2;
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
			}	
		}
	}	
return 0;
}
