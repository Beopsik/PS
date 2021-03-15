#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N;

int main(void)
{
	int res=0, Min=10000001;
	
	scanf("%d", &N);
	
	int *arr=new int[N];
	for(int i=0; i<N; i++)
	{
		arr[i]=i;
	}
	int **W=new int*[N];
	for(int i=0; i<N; i++)
	{
		W[i]=new int[N];
	}
	
	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
			scanf("%d", &W[i][j]);
	}
	
	do{
		int i;
		res=0;
		
		for(i=0; i<N-1; i++)
		{
			if(W[arr[i]][arr[i+1]]==0)
				break;
			res+=W[arr[i]][arr[i+1]];
		}
		if(W[arr[i]][arr[i+1]]==0||W[arr[N-1]][arr[0]]==0)
			continue;
		
		res+=W[arr[i]][arr[0]];
		Min=min(res, Min);
	}while(next_permutation(arr, arr+N));
	
	if(Min==10000001)
		Min=0;
	
	printf("%d\n", Min);
	
    return 0;
}







