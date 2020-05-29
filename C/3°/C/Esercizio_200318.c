#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void carica(int *, int );
void stampa(int *, int );
void bubble(int *, int );
void scambia(int *, int *);
void terzovettore(int *, int * , int *, int );
int numeripetuti(int *, int *, int *, int );

int main(){ 
    int A[100],B[100],C[100],D[100],N;  
    srand(time(NULL));
    printf("Quanti numeri vuoi estrarre [100 massimo] ? ");
    scanf("%d",&N);
    carica(A,N);
    carica(B,N);
    printf("\nvettore A\n");
    stampa(A,N);
    printf("\nvettore B\n");
    stampa(B,N);
    bubble(A,N);
    bubble(B,N);
    printf("\nvettore C\n");    
    terzovettore(C,A,B,N);
    stampa(C,N);
    printf("\nvettore D\n");
    numeripetuti(D,A,B,N);
    
return 0;
}

void carica(int *V, int dim){
    int i;
    for(i=0; i<dim; i++){
       V[i]=rand()%41-20; 
    }
}

void stampa(int *V, int dim){
    int i;
    for(i=0; i<dim; i++){
        printf("%d | ",V[i]);
    }
    printf("\n");
}

void bubble(int *V, int dim){
    int i=0,j,flag=0;
    j=dim;
    while(flag==0){
        flag=1;
        for(i=0; i<(j-1); i++){
            if(V[i]>V[i+1]){
                scambia(&V[i],&V[i+1]);
            }
        }
        j--;
    }
}

void scambia(int *a, int *b){
    int tmp;
    tmp=*a;
    *a=*b;
    *b=tmp;
}

void terzovettore(int *C, int *A, int *B, int dim){  //creo un vettore che ha al suo interno abbia sia i valori di A sia i valori di B
   int ia=0,ib=0,ic=0,i;
   do{
       if(A[ia]<B[ib]){
            C[ic]=A[ia];
            ia++;
            ic++;
            if(ia==(dim/2)){
               for(i=ib; i<(dim/2); i++){             
                    C[ic]=B[i];
                    ic++;
               }            
            }
       }else{
            C[ic]=B[ib];
            ib++;
            ic++;
            if(ib==(dim/2)){
               for(i=ia; i<(dim/2); i++){             
                    C[ic]=A[i];
                    ic++;
               }            
            }
       }
       ic++; 
   }while(ic<dim);
}

int numeripetuti(int *D, int *A, int *B, int dim){
    int dato=1,inizio,trovato,fine,x=1,cont=0,i;
    for(i=0; i<dim; i++){
        inizio=0;
        trovato=1;
        fine= dim-1;
        while(trovato==1 && inizio<=fine){    
            x=(inizio+fine)/2;
            if(A[i]==B[x]){
                trovato=0;
                D[cont]=B[x];
                cont++;
            }else if(A[i]<B[x]){
                fine=i-1;
            }else{
                inizio=i+1;
            }
        }
    }
return cont;
}
