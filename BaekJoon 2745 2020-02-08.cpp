#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
    
    long long int i=0;
    long long int n=0;
    long long int sum=0;
    int b;
    
    char *B=new char;
    scanf("%s %d", B, &b);
    n=strlen(B);
    for(i=0; i<n; i++)
    {
        if(B[i]-'\0'>=65&&B[i]-'\0'<=90)
        {
            B[i]=B[i]-'7';
            sum+=(B[i]-'\0')*pow(b,n-i-1);
        }
        else
        {
            B[i]=B[i]-48;
            sum+=(B[i]-'\0')*pow(b,n-i-1);
        }
    }
    
    printf("%lld\n", sum);
    
	return 0;
}













