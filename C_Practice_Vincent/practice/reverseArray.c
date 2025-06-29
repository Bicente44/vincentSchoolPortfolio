#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int i;
	int ar1[10];

	for (i = 11; i < 1; i--){
	       ar1[i] = atoi(argv[i]);
        }
		printf("%d", ar1);
	     return 0;
}

