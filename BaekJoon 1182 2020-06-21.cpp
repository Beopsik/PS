#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int n, s;
int arr[20];
int ans[20];
int caseNum;

void dfs(int position, int ans[], int arr[], int len, int size)
{
	if(len==size){
		int sum=0;
		for(int i=0; i<size; i++){
			sum+=ans[i];
		}
		if(sum==s){
			caseNum++;
		}
		return;
	}
	for(int i=position; i<n; i++){
		ans[len]=arr[i];
		len++;
		dfs(i+1, ans, arr, len, size);
		len--;
	}
}
int main(){
	
	scanf("%d %d", &n, &s);
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	
	for(int i=1; i<=n; i++)
	{
		memset(ans, 1000001,sizeof(ans));
		dfs(0,ans, arr, 0, i);
	}
	
	printf("%d\n", caseNum);
	return 0;
}














