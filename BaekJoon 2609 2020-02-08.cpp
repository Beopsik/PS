#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    int n1, n2;
    int m;
    int i;
    int gcd;
    long long lcm;
    
    scanf("%d %d", &n1, &n2);
    m=min(n1, n2);
    
    for(i=m; i>0; i--)
    {
        if(n1%i==0&&n2%i==0)
            break;
    }
    gcd=i;
    lcm=i*(n1/i)*(n2/i);
    
    printf("%d\n", gcd);
    printf("%lld\n", lcm);
    
	return 0;
}









