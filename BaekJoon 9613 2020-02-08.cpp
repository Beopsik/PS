#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;

int n[101];
long long int gcd[101];

int GCD(int n1, int n2)
{
    int t;
    int A, B;
    
    A=max(n1, n2);
    B=min(n1, n2);
    
    while(B!=0)
    {
        t=A%B;
        A=B;
        B=t;
    }
    
    return A;
}

int main() {
    
    int n1, n2;
    int TC;
    int TC_num;
    
    scanf("%d", &TC);
    for(int i=0; i<TC; i++)
    {
        scanf("%d", &TC_num);
        for(int t=0; t<TC_num; t++)
        {
            scanf("%d", &n[t]);
        }
        for(int t=0; t<TC_num; t++)
        {
            for(int j=t+1; j<TC_num; j++)
            {
                gcd[i]+=GCD(n[t],n[j]);
            }
        }
    }
    
    for(int i=0; i<TC; i++)
    {
        printf("%lld\n", gcd[i]);
    }
    
	return 0;
}












