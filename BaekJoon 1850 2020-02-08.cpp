#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;
    
int main() {
    
    long long int A, B;
    long long int n1, n2;
    long long int t;
    long long int gcd=0;
    
    scanf("%lld", &n1);
    scanf("%lld", &n2);
    
    A=max(n1, n2);
    B=min(n1, n2);
    
    while(B!=0)
    {
        t=A%B;
        A=B;
        B=t;
    }
    
    for(long long int i=0; i<A; i++)
    {
        printf("1");
    }
    printf("\n");
    
	return 0;
}











