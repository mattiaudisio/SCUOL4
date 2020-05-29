#include "libreria.h"

int main(){
	int N, i, isc, vot, bianche, nulle, totVot=0, totIsc=0, totBianche=0, donne=0, totDonne=0, totNulle=0, totUomini=0, uomini=0;
	float percVot=0, percB=0, percN=0, percDonne=0, percUomini=0;
	N=Nseggi();
	srand(time(NULL));
	for(i=0;i<N;i++){
		isc=caricaIscritti();
		vot=caricaVotanti(isc);
		donne=creaD(vot);
		printf("Donne che hanno votato: %d\n",donne);
		totDonne+=donne;
		uomini=vot-donne;
		printf("Uomini che hanno votato: %d\n",uomini);
		totUomini+=uomini;
		bianche=crea(10);
		totBianche+=bianche;
		printf("Bianche: %d\n", bianche);
		nulle=crea(20);
		totNulle+=nulle;
		printf("Nulle: %d\n", nulle);
		totVot+=vot;
		totIsc+=isc;
	}
	percVot=calcPerc(totVot,totIsc);
	printf("\n **** Risultati delle elezioni ***\n");
	printf("Percentuale votanti: %.2f\n",percVot);
	percB=calcPerc(totBianche,totVot); 			//Percentuale bianche
	percN=calcPerc(totNulle,totVot);			//Percentuale nulle
	printf("Percentuale bianche: %.2f, nulle: %.2f\n",percB, percN);
	percDonne=calcPerc(totDonne,totVot);
	printf("Percentuale donne: %.2f\n",percDonne);
return 0;
}
