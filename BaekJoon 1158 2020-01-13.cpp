#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
#include<stack>
using namespace std;

int num[5001];
int result[5001];

int main() {
    
    int n, k=0;
    int count;
	int zero_c=0;
	
	scanf("%d %d", &n, &k);
	
	for(int i=1; i<=n; i++)
	{
	    num[i]=i;
	}
	count=k;
	for(int i=1; i<=n; i++)
	{
	    for(int t=1; t<=n; t++)
	    {
	        count--;
	        zero_c=0;
	        while(num[t]==0)
	        {
	            if(t<=n)
	                t++;
	            else
	                t=1;
	            zero_c++;
	            if(zero_c>n)
	                break;
	        }
	        if(count==0)
	        {
	            result[i]=num[t];
	            num[t]=0;
	            count=k;
	            i++;
	        }
	    }
	    i--;
	}
	
	if(n==1)
	{
	    printf("<%d>\n", result[1]);
	}
	else
	{
    	printf("<%d,", result[1]);
    	for(int i=2; i<n; i++)
    	{
    	    printf(" %d,", result[i]);
    	}
    	printf(" %d>\n", result[n]);
	}
	
	
	return 0;
}






















