#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int arr[1001];

int main() {
    
    int n, k;
    int count=0; 
	int primenum=0;
    int answer=0;
    scanf("%d %d", &n, &k);
    
   
	for(int i=2; i<=n; i++){
		arr[i]=i;
	}
	for(int i=2; i<=n; i++){
		
		if(arr[i]==0)
			continue;
		
		for(int j=i; j<=n; j+=i){
			if(arr[j]==0)
				continue;
			
			count++;
			if(count==k){
				answer=arr[j];
				break;
			}
			arr[j]=0;
		}
		if(count==k)
			break;
	}
    printf("%d\n",answer);
	return 0;
}


















