#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int n, s;
int arr[100000];
int len=100000;

void Sum()
{
	int index=0;
	int sum=0;
	int left=0, right=0;
	while(left<=right&&right<=n){
		if(sum>=s){
			len=min(len,right-left);
			sum-=arr[left++];
		}else{
			if(right==n)
				break;
			sum+=arr[right++];
		}
	}
}
int main(){
	
	scanf("%d %d", &n, &s);
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	
	Sum();
	
	if(len==100000)
		len=0;
	printf("%d\n", len);
	return 0;
}














