#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int arr[1000001];

int main() {
    
    int t=0;
    int br=1;
    int n[1000001];
    int Max=0;
    
    while(true)
    {
        scanf("%d", &n[t]);
        Max=max(Max,n[t]);
        if(n[t]==0)
            break;
        
        t++;
    }
    for(int i=2; i<=Max; i++)
    {
        arr[i]=i;
    }
        
    for(int i=2; i<=sqrt(Max); i++)
    {
        if(arr[i]==0)
            continue;
        
        for(int j=i+i; j<=Max; j+=i)
            arr[j]=0;
    }
    for(t=0; n[t]!=0; t++)   
    {
        br=1;
        
        for(int i=2; i<=n[t]; i++)
        {
            if(arr[i]==0)
                continue;
            if(int j=n[t]-i)
            {
                if(n[t]==arr[i]+arr[j])
                {
                    printf("%d = %d + %d\n", n[t], arr[i], arr[j]);
                    br--;
                }
            }
            if(br==0)
                break;
        }
        if(br==1)
            printf("Goldbach's conjecture is wrong.\n");
    }
	return 0;
}



















