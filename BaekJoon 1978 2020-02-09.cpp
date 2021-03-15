#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int n[101];

int main() {
    
    int num;
    int count=0;
    int result=0;
    
    scanf("%d", &num);
    
    for(int i=0; i<num; i++)
    {
        scanf("%d", &n[i]);
    }
    
    for(int i=0; i<num; i++)
    {
        if(n[i]==1)
            continue;
            
        for(int j=2; j<n[i]; j++)
        {
            if(n[i]%j==0)
                count++;
        }
        
        if(count==0)
            result++;
            
        count=0;
    }
    
    printf("%d\n", result);
    
    
	return 0;
}

















