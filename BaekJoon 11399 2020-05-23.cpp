#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int N;
int P[1001];
int T[1001];

int main(void)
{
	int sum=0;	
	int result=0;
	
	scanf("%d", &N);
	
	for(int i=0; i<N; i++){
		scanf("%d", &P[i]);
	}
	sort(P, P+N);
	
	for(int i=0; i<N; i++){
		sum+=P[i];
		T[i]=sum;
	}
	for(int i=0; i<N; i++){
		result+=T[i];
	}
	
	printf("%d\n", result);

    return 0;
}

