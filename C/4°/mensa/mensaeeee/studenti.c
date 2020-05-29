//Mattia Audisio 4C
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/sem.h>
#include <sys/ipc.h>

#define DIM 1024
struct sembef buffer;

void sem_lock(int sem_id,int id);
void sem_unlock(int sem_id,int id);

int main(){
	key_t sem_chiave,mem_chiave;




return 0;
}
