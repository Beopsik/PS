#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int k=1;
int arr[49];
int ans[49];
void dfs(int position, int ans[], int arr[], int len)
{
	for(int i=position; i<k; i++){
		ans[len]=arr[i];
		len++;
		dfs(i+1, ans, arr, len);
		len--;
	}
	if(len==6){
		for(int i=0; i<len; i++)
			printf("%d ",ans[i]);
		printf("\n");
		return;
	}
}
int main(){
	
	while(k!=0){
		scanf("%d", &k);
		for(int i=0; i<k; i++)
			scanf("%d", &arr[i]);
		
		dfs(0,ans, arr, 0);
		printf("\n");
	}
	
	return 0;
}














