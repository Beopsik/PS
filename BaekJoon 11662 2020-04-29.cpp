#include <iostream>
#include <cstdio>
#include <algorithm>


using namespace std;
int carry[500001];
int check[500001];
int cardnum[20000002];

int main(void){
 
	int N=0;
	int M=0;
	
	scanf("%d", &N);
	for(int i=0; i<N; i++)
	{
		scanf("%d", &carry[i]);
		if(carry[i]>=0)
			cardnum[carry[i]]++;
		else
			cardnum[-carry[i]+10000000]++;
	}
	sort(carry, carry+N);
	
	scanf("%d", &M);
	for(int i=0; i<M; i++)
	{
		scanf("%d", &check[i]);
	}
	
	for(int t=0; t<M; t++)
	{
		int d=0;
		int left=0;
		int right=N-1;
		while(left<=right){
			int mid=(left+right)/2;

			d=check[t]-carry[mid];
			if(d==0){
				if(carry[mid]>=0)
					check[t]=cardnum[carry[mid]];
				else
					check[t]=cardnum[-carry[mid]+10000000];
				left=0;
				right=N-1;
				break;
			}
			else if(d>0){
				left=mid+1;
			}
			else{
				right=mid-1;
			}	
		}
		if(left>right)
			check[t]=0;
	}
	
	for(int i=0; i<M; i++)
	{
		printf("%d ", check[i]);
	}
	
    return 0;
}

