#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;

int check[3000000];
int dp[3000000];

int main (){

	int a, p, i, j, t;
    
    scanf("%d %d", &a, &p);
    check[a]++;
    dp[1]=a;
	for(i=2; i<=3000000; i++){
	    
	    int temp=dp[i-1];
	    
		for(t=10; dp[i-1]%t!=dp[i-1]; t*=10)
		{
		}
		for(t/=10; t!=0; t/=10)
		{
		    dp[i]+=pow(temp/t, p);
		    temp%=t;
		}
		check[dp[i]]++;
		
		if(check[dp[i]]==2)
		break;
	}
    
    for(j=1; dp[j]!=dp[i]; j++)
    {
    }
    printf("%d\n", j-1);

	return 0;
}

















