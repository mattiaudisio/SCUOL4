#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void secondovoto(float *);

int main(){
	int i,nvoti=5;
	float voto;
	for(i=0; i<nvoti; i++){
		printf("\nInserisci il voto \n");	
		scanf("%f",&voto);
		secondovoto(&voto);	
		printf("\nIl voto finale vale %.2f\n",voto);			
	}
return 0;
}

void secondovoto(float *a){
	int voto2;
	float media;
	if(*a<6){
		printf("\nHai preso un'insufficenza e ti ha rinterrogato \nInserisci il voto \n");
		scanf("%d",&voto2);
		*a=(*a+voto2)/2;
	}	
}
