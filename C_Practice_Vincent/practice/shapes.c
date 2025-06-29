/*shapes.c
 *
 *We want to write a program that takes two comman line arguments, one for type one for size.
 *The type will tell us what kind of shape to make. and the size will give it a dimension.
 * expects shape, a size of shape
 * output : shape or error (1)
 * 
 * Vincent Welbourne
 * 041161454
 * CST8234
 * 
 */

/*
 * TODO: breaking down in component parts
 *1 Input validation (return not 0)
 *
 *3 Define sizes:
 * big = 14
 *
 *2 command line arguments <- parse (size, type)
 *
 *4 define the types <- (Triangle, Square, dia)
 *
 *5 print triangle (dia?)
 *6 print square (dia?)
 *7 print diamond (dia?)
 * 
 * 
 * 
 * 
 */

#include <studio.h>
#include <string.h>
/* argc = argument count */

#define number of shapes

int main(int argc,char *argv[]){

	char error = 0;
	int i;
	char shapes[3][10];
	char shapeFound = 0;
	strcpy(shapes[0], "triangle");
	strcpy(shapes[1], "square");
	strcpy(shapes[2], "diamond");

	
	/*
	   debugging
	   printf( "%s\n", shapes[2]);
	*/

	if (argc > 3 ) error = 1;

	else {
		for (i = 1; i < argc; 1++) {
			
			for (ii = 0; ii < 3; ii++ ){
				if (!strcmp(argv[i], shapes()))
				shapeFound = 1;
			}
			if (shapeFound == 0) error = 1;
			
			
		}



/*




	for (i = 0; i < argc; i++) printf ("%s ", argv[i]);
	printf("\n");

	return 0;


	printf("%s %s\n", argv[1], argv[2]);


*/






