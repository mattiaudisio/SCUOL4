#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int consecUguali(int,int);
int numeroDivisore(int,int);
int presenteMaggiore(int,int);

int main(){
    int num1,num2contaug=0,contadiv=0,num,nmenu;
    printf("\nInserisci un numero \n");
    scanf("%d",&num);
    num2=num;
    do{
        num1=num2;
        printf("\nInserisci un numero \n");
        scanf("%d",&num);
        num2=num;        
        if(num!=0){
            cuguali=consecUguali(num1,num2);
            contaug=contaug+cuguali;
            cdivis=numeroDivisore(num1,num2);
            contadiv=contadiv+cdivis;
        }
    }while(num!=0);
    do{
        printf("\n1.calcolo numero di coppie consecutivi uguali \n");
        printf("\n2.calcolo nemero di coppie in cui il secondo numero e' divisore del primo \n");
        printf("\n3.dire quale tipo di coppie e' presente in numero maggiore \n");
        scanf("%d",&nmenu);
        switch(nmenu){
            case 0:
                    printf("\nProgramma terminato \n");
                    break;
            case 1:
                    printf("\nnumero coppie consecutive uguali %d",contaug);           
                    break;
            case 2:
                    printf("\nil numero di coppie dove il secondo numero e' divisore del primo %d\n",contadiv);
                    break;
            case 3:
                    presenteMaggiore(contaug,contadiv);
                    break;
            default:
                    printf("\nNumero errato \n");
                    break;                    
        }
    }while(nmenu!=0);               
return 0;
}

int consecUguali(n1,n2){
      if(n1==N2){
        cuguali++;
      }
return cuguali++;
}
    
int numeroDivisore(numer1,numr2){
    if(numer1!=numer2 && numer2%numer1==0){    
        cdivis++;
    }
return cdivis;
}

int presenteMaggiore(uguali,divisi){
    if(uguali>divisi){
        printf("\nGli uguali sono maggiori \n");
    }else{
        printf("\nI divisi sono maggiori \n");        
    }
}

