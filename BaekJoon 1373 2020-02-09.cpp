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
    int sum=0;
    int b;
    int len;
    
    char B[1000001];
    char O[1000001];
    
    scanf("%s", B);
    
    n=strlen(B);
    if(n%3==0)
        len=n/3;
    else
        len=n/3+1;
        
    for(i=n-1; i>=0;)
    {
        for(int t=2; t>=0; t--)
        {
            if(i<0)
                break;
            sum+=(B[i]-'0')*pow(2,3-t-1);
            i--;
        }
        O[len-1]=sum+'0';
        sum=0;
        len--;
    }
    
    printf("%s\n", O);
    
	return 0;
}













