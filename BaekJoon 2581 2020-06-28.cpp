#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int arr[10001];

int main() {
    
    int m, n;
	int sum=0, Min=0;
	
    scanf("%d %d", &m, &n);
    
	for(int i=2; i<=n; i++){
		arr[i]=i;
	}
	for(int i=2; i<sqrt(n); i++){
		
		if(arr[i]==0)
			continue;
		
		for(int j=i+i; j<=n; j+=i){
			arr[j]=0;
		}
	}
	for(int i=m; i<=n; i++){
		if(arr[i]!=0){
			if(Min==0)
				Min=i;
			sum+=arr[i];
		}
		
	}
	if(sum==0)
		printf("-1\n");
	else{
		printf("%d\n", sum);
		printf("%d\n", Min);
	}
	
	return 0;
}


















