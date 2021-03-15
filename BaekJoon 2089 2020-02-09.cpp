#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

void bi(int T)
{
    if(T==0)
        return;
    
    if(T%-2==0){
            T=T/-2;
            bi(T);
            printf("0");
        }
        else{
            T=(T-1)/-2;
            bi(T);
            printf("1");
        }
}
int main() {
    
    int T;
    
    scanf("%d", &T);
    
    if(T==0)
        printf("0\n");
        
    bi(T);
    
	return 0;
}















