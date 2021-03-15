#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int arr[10000001];

int main() {
    
    int N;
    scanf("%d", &N);
    
    for(int i=2; i<=N; i++)
    {
        arr[i]=i;
    }
        
    for(int i=2; i<=sqrt(N); i++)
    {
        if(arr[i]==0)
            continue;
        
        for(int j=i+i; j<=N; j+=i)
            arr[j]=0;
    }

    for(int j=0, i=2; N!=1; j++)
    {
        int temp=i;
        
        if(N%arr[i]==0)
        {
            printf("%d\n", arr[i]);
            N=N/arr[i];
        }
        else
        {
            while(arr[i]==0||arr[i]==temp)
            {
                i++;
            }
        }
    }
	return 0;
}




















