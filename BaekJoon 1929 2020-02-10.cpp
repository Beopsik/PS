#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int arr[1000001];

int main() {
    
    int n1;
    int n2;
    int count=0;
    
    scanf("%d %d", &n1, &n2);
    
    for(int i=2; i<=n2; i++)
    {
        arr[i]=i;
    }
    
    for(int i=2; i<=sqrt(n2); i++)
    {
        if(arr[i]==0)
            continue;
        
        for(int j=i+i; j<=n2; j+=i)
            arr[j]=0;
    }
    
    for(int i=n1; i<=n2; i++)
    {
        if(arr[i]!=0)
            printf("%d\n", arr[i]);
    }
    
	return 0;
}


















