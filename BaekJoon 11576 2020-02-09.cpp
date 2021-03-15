#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int a[2000000];
int b[2000000];

void change_B(int dec, int B)
{
    if(dec==0)
        return;
        
    change_B(dec/B, B);
    if(dec/B!=0)
        printf(" ");
    printf("%d",dec%B);
}
int main() {
    
    int A, B;
    int m;
    int dec=0;
    int i,t=0;
    
    scanf("%d %d", &A, &B);
    scanf("%d", &m);
    
    for(i=0; i<m; i++)
    {
        scanf("%d", &a[i]);
    }
    for(i=m-1; i>=0; i--)
    {
        dec+=a[i]*pow(A,m-i-1);
    }
    change_B(dec, B);
    
	return 0;
}

















