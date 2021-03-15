#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;
	
int main() {
    
	char A[16];
	char B[8];
	char C[16];
	char D[8];
	long long Mer1;
	long long Mer2;
	
	scanf("%s %s %s %s", A, B, C, D);
	strcat(A, B);
	strcat(C, D);
	
	Mer1=atol(A);
	Mer2=atol(C);
	
	Mer1+=Mer2;
	
	printf("%lld\n", Mer1);
	
	return 0;
}









