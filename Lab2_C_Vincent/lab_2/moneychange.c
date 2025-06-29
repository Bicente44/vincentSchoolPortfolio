/*
 * Vincent Welbourne
 * 041161454
 * Lab 1
 * C-Programming
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FALSE 0
#define TRUE 1

int i = 1;
char *usrSymbol = "";
int longList = FALSE;

int symbolCheck(char * symbol){
	/* strlen() to make sure its 3 characters */	
	if (strlen(symbol) != 3) {
		printf("moneychange: invalid currency symbol\n");
		return FALSE;
	}
	usrSymbol = symbol;
	return TRUE;
}

/*
 *shortFunction
 */
int shortFunc(char * argv[]){	
	if (strcmp(argv[i], "-s") == 0) {	
		return symbolCheck(argv[++i]);
	}
	if (strcmp(argv[i], "-l") == 0) {
		longList = TRUE;
		return TRUE;
	}

	return FALSE;
}
/*
 *Long Function
 */	
int longFunc(char * argv[]){	
	if (strcmp(argv[i], "--help") == 0) {
	printf("Usage: moneychange [OPTION]... AMOUNT EXCHANGE [EXCHANGE]\n");
	printf("Convert from one currency to another (by default convert the AMOUNT into USD.\n");
	printf("Options:\n");
	printf("-l --long\t\tshow detailed conversion amount.\n");
	printf("-s --symbol\t\tadd three letter currency code to output.\n");
	printf("Exit Status:\n");
	printf("\t0\tif ok,\n");
	printf("\t1\tif problem encountered.\n");
	printf("moneychange by Vincent Welbourne.\n");
	return TRUE;
	}
	if (strcmp(argv[i], "--long") == 0) {
		longList = TRUE;
		return TRUE;
	}

	if (strcmp(argv[i], "--symbol") == 0) {
		return symbolCheck(argv[++i]);
	}

	
	return FALSE;
}

int conversionFunc(char *argv[], int i, int argc){
	double userAmount = 0.0;
	double sourceRate = 0.0;
	double converted = 0.0;
	double divideVal = 0.0;	
	userAmount = atof(argv[i++]);
	sourceRate = atof(argv[i++]);
	
	if (userAmount == 0.0 || sourceRate == 0.0){
	return FALSE;
	}
	converted = userAmount * sourceRate;
	if (argc > i){	
		divideVal = atof(argv[i]);
		if (divideVal == 0.0){
			return FALSE;
		}
		converted /= divideVal;
	}
	if (longList) {
	printf("%.2f turns into %.2f%s\n",userAmount, converted, usrSymbol);
	}else{
		printf("%.2f%s\n",converted, usrSymbol);
	}
	return TRUE;	
}


/*
 * Main function
 */
int main(int argc, char *argv[]) {
	/* Declarations */

	if (argc == 1) {
		printf("Not enough arguments!\n");
		printf("Try 'moneychange --help' for more information.\n");
		return 1;
	}

	/* All logic for options goes inside for */
   	for(i = 1; i < argc; ++i) {
		if (argv[i][0] == '-') {
			/* If long then do this */
			if (argv[i][1] == '-') {
				if (longFunc(argv) == FALSE) {
					printf("Try 'moneychange --help' for more information.\n");
					return EXIT_FAILURE;
				}
				
				continue;
			}
			
			if (shortFunc(argv) == FALSE) {
				printf("Try 'moneychange --help' for more information.\n");
				return EXIT_FAILURE;
			}
		}
		else break;
			/* breakk out of loop if you cant find an option */
	}
	if ( (argc - i) > 1 && (argc - i) < 4){
	conversionFunc(argv, i, argc);
	} else {
	printf("Try 'moneychange --help' for more information.\n");	
	return EXIT_FAILURE;
	}
	return EXIT_SUCCESS;
}
