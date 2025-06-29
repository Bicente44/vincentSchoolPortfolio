#include <stdio.h>
int main(){
	int i = 0;
	for ( ; i<256; i++)
		if ( i != 27 ) printf("%d is %c", i, i);

	return 0;
}

