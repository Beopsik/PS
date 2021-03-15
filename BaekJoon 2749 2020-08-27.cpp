#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int result;

void fibo(long long int n)
{
	int mod=1000000;
	int period=(mod/10)*15;
	int fibo[period];
	fibo[0]=0, fibo[1]=1;
	for(int i=2; i<period; i++){
		fibo[i]=fibo[i-1]+fibo[i-2];
		fibo[i]%=mod;
	}
	result=fibo[n%period];
}
int main (){
	
	long long int n;
	scanf("%lld", &n);
	
	fibo(n);
	
	printf("%d\n", result);
	
	return 0;
}



