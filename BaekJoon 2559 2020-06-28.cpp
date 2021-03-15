#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int n, k;
int arr[100000];
int Max=-10000000;

void Sum()
{
	int sum=0;
	int left=0, right=0;
	while(left<=right&&right<=n){
		if((right-left)==k){
			Max=max(Max,sum);
			sum-=arr[left++];
		}else{
			if(right==n)
				break;
			sum+=arr[right++];
		}
	}
}
int main(){
	
	scanf("%d %d", &n, &k);
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	
	Sum();
	
	printf("%d\n", Max);
	
	return 0;
}














