#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main(void){
	
	int N, M;
	
	scanf("%d %d", &N, &M);
	int *re=new int[N+M];
	
	for(int i=0; i<N+M; i++)
	{
		scanf("%d", &re[i]);
	}
	sort(re,re+N+M);
	
	for(int i=0; i<N+M; i++)
	{
		printf("%d ", re[i]);
	}
	
    return 0;
}

