int main(int argc; char *argv[]){
	int i = 0;
	int count = 0;
	int max;
	int FALSE = -1;
	int TRUE = 2;

	if (sizeof(argc) != 1){
		return FALSE;
	}
	string = argv[1];
	max = strlen(string);

	for (i; i <= max; i++){
		if (string[i] == " "){
			count++;
		}
	}
	printf("you have %d spaces",count);
	return TRUE;
}

/*

   SHAVITS SOLUTION:

#include <stdio.h>
#include <stdlib.h>

int sapceCounter(char *s) {

	int len, i, count = 0;
	
	if (s == NULL) {
	return -1;
	}
	len = strlen(s);
	for (i = 0; i < len; ++i) {
		if (s[i] == ' ')
			++count;
	}
	return count;
}

or after the check you can do

	while (*s != '\0') {
		if (*s == ' '){
			++count;
			}
		++s;
	}
return count
}

