#include <stdio.h>
#include <string.h>

int main(){
    char str1[30],str2[30],str3[30],str4[150];
    int lunghezza;
    do{
        printf("Inserisci una stringa  ");
        scanf("%30s", str1); //e' una stringa quindi non ci vuole la &
        lunghezza= strlen(str1);
    }while(lunghezza>20);
    printf(" la stringa 1 è formata da %d caratteri\n",lunghezza);
    do{
        printf("Inserisci un'altra stringa  ");
        scanf("%30s", str2);
        lunghezza= strlen(str2);
    }while(lunghezza>20);
    printf(" la stringa 2 è formata da %d caratteri\n",lunghezza);
    if(strcmp(str1, str2)== 0){
        printf("Le 2 stringhe sono uguali \n");
    }else if(strcmp(str1, str2)> 0){
        printf("%s minore di %s \n", str1, str2);
    }else{
        printf("%s maggiore di %s \n", str1, str2);        
    }
    strcpy(str3, str1); //copia
    strcpy(str1, str2);
    printf("stringa 1 = %s \n",str1);
    strcpy(str4, str2);
    strcat(str4, "-"); //concatena
    strcat(str4, str3);
    strcat(str4, "-");
    strcat(str4, str1);
    printf("stringa 4 = %s \n",str4);

return 0;
}
