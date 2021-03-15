#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n;
int p[1000];
int lis[1000];
vector <int> ans;
int record[1000];
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
	
	lis[0]=p[0];
	record[0]=1;
	for(int i=1; i<n; i++){
		if(lis[len-1]<p[i]){
			lis[len++]=p[i];
			record[i]=len;
		}else{
			int index=lowerbound(lis, len, p[i]);
			lis[index]=p[i];
			record[i]=index+1;
		}
	}
	
	printf("%d\n", len);
	for(int i=n-1; i>=0; i--){
		if(record[i]==len){
			ans.push_back(p[i]);
			len--;
		}
	}
	sort(ans.begin(), ans.end());
	for(int i=0; i<ans.size(); i++)
		printf("%d ", ans[i]);
	printf("\n");
	
	return 0;
}



