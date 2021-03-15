#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;

int A[1001];
int B[1001];
long long int lcm[1001];
    
int main() {
    
    int TC;
    
    scanf("%d", &TC);
    
    for(int i=1; i<=TC; i++)
    {
        scanf("%d", &A[i]);
        scanf("%d", &B[i]);
    }
    
    for(int i=1; i<=TC; i++)
    {
        int t=min(A[i], B[i]);
        for(; t>0; t--)
        {
            if(A[i]%t==0&&B[i]%t==0)
                break;
        }
        lcm[i]=t*(A[i]/t)*(B[i]/t);
    }
    
    for(int i=1; i<=TC; i++)
    {
        printf("%lld\n", lcm[i]);
    }
	return 0;
}









