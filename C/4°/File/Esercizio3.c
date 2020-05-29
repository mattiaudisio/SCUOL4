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
	if(!(fp=fopen(USER_FILE,"a"))){
		printf("Errore: impossibile aprire il file %s in scrittura\n",USER_FILE);
		exit(1);
	}
	printf("\nQuanti numeri voi inserire --> ");
	scanf("%d",dim);
	for(i=0;i<dim;i++){
		printf("=> Inserimento di un nuovo utente <=\n\n");
		printf("Username: ");
		scanf("%s",u.user);	
		printf("Password: ");
		scanf("%s",u.pass);	
		printf("Email: ");
		scanf("%s",u.email);	
		printf("Eta': ");
		scanf("%d",&u.age);	
		//Scrivo i dati sul file
		printf(fp," %s\t%s\t%s\t%d\n",u.user,u.pass,u.email,u.age);
		printf("Dati scritti con successo sul file\n");
		fclose(fp);
	}
return 0;
}
