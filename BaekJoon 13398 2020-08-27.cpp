#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

long long arr[100001];
long long dp1[100001];
long long dp2[100001];

int main(void)
{
    int k;
    int n;
	int cnt=0;
    long long sum;
	long long Max=0;
	
	scanf("%d", &n);
	
	for(int i=1; i<=n; i++){
        scanf("%lld", &arr[i]);
    }
    
    dp1[1]=arr[1];
    for(int i=2; i<=n; i++){
        dp1[i]=arr[i];
        dp1[i]=max(dp1[i-1]+arr[i],arr[i]);
    }
    Max=dp1[1];
    for(int i=1; i<=n; i++){
        Max=max(Max, dp1[i]);
    }
	
	dp2[n]=arr[n];
	for(int i=n-1; i>=1; i--){
        dp2[i]=arr[i];
        dp2[i]=max(dp2[i+1]+arr[i], arr[i]);
    }
	
	for(int i=2; i<=n; i++){
        Max=max(Max, dp1[i-1]+dp2[i+1]);
    }
	
	printf("%lld\n", Max);
	
    return 0;
    
}

















