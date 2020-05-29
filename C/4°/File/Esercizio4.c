#include <stdio.h>
#include <stdlib.h>

#define USER_FILE "user.txt"

typedef struct{
	char user[30];
	char pass[30];
	char email[30];
	int  age;	
}user;

int main(void){
	FILE *fp;
	user u;
	if(!(fp=fopen(USER_FILE,"r"))){
		printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
		exit(1);
	}
	while(fscanf(fp," %s\t%s\t%s\t%d\n",u.user,u.pass,u.email,u.age)>0){
		printf("Utente: %s\n",u.user);
		printf("Password: %s\n",u.pass);
		printf("Email: %s\n",u.email);
		printf("Eta': %d\n",u.age);
		i++;	
	}
	printf("\nUtenti letti nel file: %d\n",&i);
	printf("-----------------------------------------------\n");
	for(j=0; j<i; j++){
		printf("Utente: %s\n",u[j].user);
		printf("Password: %s\n",u[j].pass);
		printf("Email: %s\n",u[j].email);
		printf("Eta': %d\n",u[j].age);
	}
return 0;
}
