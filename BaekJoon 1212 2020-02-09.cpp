#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

char B[1000005];
char O[333335];
    
int main() {
    
    int i=0;
    int n=0;
    int len;
    
    scanf("%s", O);
    n=strlen(O);
    if(O[0]-'0'>=4)
        len=n*3;
    else if(O[0]-'0'<4&&O[0]-'0'>=2)
        len=n*3-1;
    else
        len=n*3-2;
    n-=1;
    for(i=len-1; i>=0;)
    {
        for(int t=2; t>=0; t--)
        {
            B[i]=(O[n])%2;
            O[n]=(O[n])/2;
            i--;
        }
        n--;
    }
    for(i=0; i<len; i++)
        printf("%d", B[i]);
    
	return 0;
}














