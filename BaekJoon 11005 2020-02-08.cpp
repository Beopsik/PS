#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    long long int i=0;
    long long int n;
    int b;
    
    char *B=new char;
    
    scanf("%lld %d", &n, &b);
    while(true)
    {
        if(n%b<10)
            B[i]=n%b+48;
        else
            B[i]=n%b+55;
        n=n/b;
        if(n==0)
            break;
        i++;
    }
    
    for(; i>=0; i--)
    {
        printf("%c", B[i]);
    }
    printf("\n");
    
	return 0;
}












