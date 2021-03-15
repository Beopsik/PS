#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>

using namespace std;

long long int K[10000];
long long int sum=0;
long long int l;
long long int r;

long long int bianry(long long int left, long long int right, long long int k, long long int N)
{
	long long int mid;
	long long int answer;
	long long int result = 0;
	
	srand((long long int)time(NULL));
	
	while (left <= right){
 		
		sum=0;
		
		if(left + right>=2)
        	mid = left + rand() % (right - left + 1);
		else
			mid = right;
		for(int i=0; i<k; i++)
		{
			sum+=K[i]/mid;
		}
		
        if (sum > N){
			answer=mid;
            left = mid + 1;
		}
        else if (sum < N){
			right = mid - 1;
		}
        else
        {
            result = mid;
            break;
        }
    }
	if(left>right){
		l=left;
		r=right;
		result=answer;
	}
	else{
		result = mid;
	}
	
	return result;
}

int main(void){
 
	long long int k=0;
	long long int N=0;
	long long int Max=0;
	long long int left=1, right=0;
    long long int result = 0;
	long long int temp=1;
	
	scanf("%lld %lld", &k, &N);
	
	for(long long int i=0; i<k; i++)
	{
		scanf("%lld", &K[i]);
		if(i==0)
			Max=K[0];
		else
			Max=max(Max, K[i]);
	}
    right=Max;
	
	while(true)
	{
		temp=left;
		left=bianry(left, right, k, N);
		if(left==temp){
			result=left;	
			break;
		}
	}
	
	if(l>r){
		printf("%lld\n", result);
	}
	else{
			for(; sum==N; result++)
		{
			sum=0;

			for(int i=0; i<k; i++)
			{
				sum+=K[i]/result;
			}
		}
		printf("%lld\n", result-2);
	}
	
	
    return 0;
}

