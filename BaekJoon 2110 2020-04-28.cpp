#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>
#include <cstdlib>

using namespace std;

int coordi[200001];

int bianry(int N, int C)
{
	int left=1, right=1, mid=0;
	int answer;
	int result = 1;
	int Max=1;
	
	for(int i=1; i<N; i++)
	{
		mid=coordi[i];
		left=0, right=0;
		
		//printf("i:%d-------------------\n", i);
		for(int j=0; j<N; j++)
		{
			if(coordi[i]-coordi[j]<0){
				left=max(left, abs(coordi[i]-coordi[j]));
				//printf("left:%d\n", left);
			}
			else{
				right=max(right, abs(coordi[j]-coordi[i]));
				//printf("right:%d\n", right);
			}
		}
		if(N==2)
			Max=max(left, right);
		else{
			result=min(left, right);
			//printf("result:%d\n", result);
			Max=max(Max, result);
			//printf("Max:%d\n", Max);
		}
    }
	
	return Max;
}

int main(void){
 
	int N=0;
	int C=0;
    int result = 0;
	
	scanf("%d %d", &N, &C);
	
	for(int i=0; i<N; i++)
	{
		scanf("%d", &coordi[i]);
	}
	result=bianry(N, C);
	
	printf("%d\n", result);
	
    return 0;
}

