#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int N, M;
int arr[8];
int s[8];
bool check[8];

int equ()
{
	int sum=0;
	
	for(int i=0; i<N-1; i++)
	{
		sum+=abs(s[i]-s[i+1]);
	}
	
	return sum;
}
int main(void)
{
	int res, Max=0;
	int cnt=1;
	scanf("%d", &N);
	for(int i=N; i>0; i--)
	{
		cnt*=i;
	}
	for(int i=0; i<N; i++)
	{
		scanf("%d", &arr[i]);
	}
	
	int r=0;
	srand(time(NULL));
	for(int i=0; i<cnt; i++)
	{
		fill_n(check, 8, false);
		for(int t=0; t<N;)
		{
			r=rand()%N;
			if(check[r]==false){
				s[t]=arr[r];
				t++;
				check[r]=true;
			}
		}
		res=equ();
		Max=max(Max, res);
	} 
	
	printf("%d\n", Max);
	
    return 0;
}







