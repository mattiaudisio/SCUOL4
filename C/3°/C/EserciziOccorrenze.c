/*Mattia Audisio
Conta le occorrenze del numero "X" in un vettore di 20 elementi interi
*/

#include <stdio.h>
#include <string.h>

#define  N 20
#define  D 3

int main(){
    char elenco [N] [D];
    int  dim=20,i,cerca,flag=0,occorrenze=0;   
    //inserisco i 20 elementi e li metto nel vettore
    for(i=0; i<dim; i++){
        printf("\nInserisci un numero di massimo 2 caratteri --> ");
        scanf("%3s",elenco[i]);
    }
    printf("\nvettore\n");
    //stampo il vettore 
    for(i=0; i<dim; i++){
        printf("%s |  ",elenco[i]);
    }
    printf("\n");
    printf("\nInserisci l'elemento di cui vuoi sapere il numero di occorrenze --> ");
    scanf("%d",&cerca);
    //conto il numero delle occorrenze
    for(i=0; i<dim; i++){
        flag=0;
        while(flag=0){
            if(cerca==dim){
              occorrenze+=1;
              flag=1;    
            }
        }
        if(flag=0){
           printf("\nNumero non trovato");
        }
    }
    printf("\nIl numero %d è stato ripetuto %d volte\n",cerca,occorrenze);
}
