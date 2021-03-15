#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
    
    long long int N;
    long long int M;
    long long int two=0;
    long long int five=0;
    
    scanf("%lld %lld", &N, &M);
    for(long long int i=2; i<=N; i*=2)
    {
        two+=N/i;
    }
    for(long long int i=5; i<=N; i*=5)
    {
        five+=N/i;
    }

    for(long long int i=2; i<=M; i*=2)
    {
        two-=M/i;
    }
    for(long long int i=5; i<=M; i*=5)
    {
        five-=M/i;
    }
    
    for(long long int i=2; i<=N-M; i*=2)
    {
        two-=(N-M)/i;
    }
    for(long long int i=5; i<=N-M; i*=5)
    {
        five-=(N-M)/i;
    }
        
    printf("%lld\n", min(two, five));
    
	return 0;
}






















