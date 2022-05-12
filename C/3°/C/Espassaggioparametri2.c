#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void scambia(int* ,int*);

int main(){
	int num1,num2;
	printf("Inserisci il primo numero:  ");
	scanf("%d",&num1);
	printf("Inserisci il secondo numero:  ");
	scanf("%d",&num2);
	printf("\nPrima di SCAMBIA \nNum1 vale %d e num2 vale %d\n",num1,num2);
	scambia(&num1,&num2);
	printf("\nPrima di SCAMBIA \nNum1 vale %d e num2 vale %d\n",num1,num2);
return 0;			
}

void scambia(int *a,int *b){
	int tmp;
	tmp=*a;
	*a=*b;
	*b=tmp;
	printf("\nSono dentro a SCAMBIA \nA vale %d e B vale %d\n",*a,*b);
}
