#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
    
    int N;
    int result=1;
    
    scanf("%d", &N);
    
    for(int i=1; i<=N; i++)
    {
        result*=i;
    }
    
    printf("%d\n", result);
    
	return 0;
}





















