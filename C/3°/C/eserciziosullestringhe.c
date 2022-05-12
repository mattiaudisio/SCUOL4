/*Data una stringa di lunghezza n, creare il seguente menu in grado di:

a. creare una nuova stringa contenente la stringa invertita; (ciao --> oaic)
b. creare una nuova stringa contenente la stringa con le vocali raddoppiate (es. ciao --> ciiaaoo)
c. creare una stringa senza le vocali (ciao --> c)
d. converta la stringa in caratteri maiuscoli
e. converta la stringa in caratteri minuscoli
f. esca 
*/

#include <stdio.h>
#include <string.h>

void stringaInvertita (char *,char *);
void doppieVocali (char *, char *);
void noVocali (char *,char *);
void maiuscolo(char *);
void minuscolo(char *);

int main(){
    char str[50],str2[50],str3[50],str4[100];
    char scelta;
    int i;
    printf("Inserisci una stringa ");    
    scanf("%50s",str);
    printf("\nMenu\n");
    printf("\na. crea una nuova stringa contenente la stringa invertita");
    printf("\nb. crea una nuova stringa contenente la stringa con le vocali raddoppiate ");
    printf("\nc. crea una stringa senza le vocali");
    printf("\nd. converti la stringa in caratteri maiuscoli");
    printf("\ne. converti la stringa in caratteri minuscoli");
    printf("\nf. esci \n");
    do{
        while(getchar()!='\n');
        scelta=getchar();
        switch(scelta){
            case 'a':
                      stringaInvertita(str,str2);
                      printf("stringa invertita -->  %s\n",str2);  
                      break;
            case 'b':
                      doppieVocali(str,str3);
                      printf("stringa con vocali doppie --> %s\n",str3);  
                      break;              
            case 'c':
                      noVocali(str,str4);
                      printf("stringa senza vocali --> %s\n",str4);                            
                      break;
            case 'd':
                      maiuscolo(str);
                      printf("stringa tutta in maiuscolo --> %s\n",str);          
                      break;       
            case 'e':
                      minuscolo(str);      
                      printf("stringa tutta in minuscolo --> %s\n",str);    
                      break;   
            case 'f':
                      printf("\nIl programma e' finito \n");          
                      break;         
            default:
                      printf("\nInserimento errato \n");                                  
                      break;

        }
    }while(scelta!='f');
return 0;
}
/*----------------------*/
void stringaInvertita (char *str, char *str2){
    int i,j,l;
    j=strlen(str);
    l=j-1
    for(i=0; i<(j-1); i++){
       str2[i]=str[j];
       j--;                
    }  
}
/*----------------------*/
void doppieVocali (char *str,char *str3){
       int i=0,j=0;
       for(i=0; i<strlen(str); i++){
            if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
                str3[j]=str[i];
                j++;
                str3[j]=str[i];
                j++;  
            }else{
                str3[j]=str[i];
                j++;                
            }
        }
}
/*----------------------*/
void noVocali (char *str, char *str4){ 
       int i=0,j=0,l=0;
       j=strlen(str);
       for(i<0; i<j; i++){
          if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){  
            str4[l]=str[i];
            l++;
          }
       }
}
/*----------------------*/
void maiuscolo(char *str){
    int i;
    for(i=0; i<strlen(str); i++){
        if(str[i]>=65 && str[i]<=90){               
            str[i]= str[i];        
        }else{
            str[i]= str[i]-32;                
        }
    }
}
/*----------------------*/
void minuscolo(char *str){
    int i;
    for(i=0; i<strlen(str); i++){
        if(str[i]>=97 && str[i]<=122){               
           str[i]=str[i];
        }else{
            str[i]=str[i]+32;
        }
    }
}
