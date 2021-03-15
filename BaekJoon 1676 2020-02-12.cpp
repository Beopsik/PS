#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
    
    int N;
    int two=0;
    int five=0;
    
    scanf("%d", &N);
    
    for(int i=2; i<=N; i*=2)
    {
        two+=N/i;
    }
    for(int i=5; i<=N; i*=5)
    {
        five+=N/i;
    }
        
    printf("%d\n", min(two, five));
    
	return 0;
}





















