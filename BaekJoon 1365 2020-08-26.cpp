#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n;
int p[100000];
int ans[100000];
int len=1;

int lowerbound(int a[], int l, int target)
{
	int start, end, mid;
	
	start=0;
	end=l-1;
	
	while(end>start){
		mid=(start+end)/2;
		if(a[mid]>=target)
			end=mid;
		else
			start=mid+1;
	}
	return end;
}
int main (){
	
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		scanf("%d", &p[i]);
	}
	
	ans[0]=p[0];
	for(int i=1; i<n; i++){
		if(ans[len-1]<p[i]){
			ans[len++]=p[i];
		}else{
			int index=lowerbound(ans, len, p[i]);
			ans[index]=p[i];
		}
	}
	
	printf("%d\n", n-len);
	return 0;
}


