#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int arr[246912];

int main() {
    
    int n, nn;
	
	while(true){
		int count=0;
		
		scanf("%d", &n);
		if(n==0)
			break;
		
		nn=2*n;
		for(int i=2; i<=nn; i++){
			arr[i]=i;
		}
		
		for(int i=2; i<=sqrt(nn); i++){
			if(arr[i]==0)
				continue;
			for(int j=i+i; j<=nn; j+=i){
				arr[j]=0;
			}
		}
		for(int i=n+1; i<=nn; i++){
			if(arr[i]!=0)
				count++;
		}
		printf("%d\n", count);
	}
	
	return 0;
}


















