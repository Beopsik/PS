#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n;
vector<pair<int, int>> pole;
int lis[500001];
vector<int> ans;
int record[500001];
int len=1;

int lowerbound(int lis[], int l, int target)
{
	int start, end, mid;
	
	start=0;
	end=l-1;
	
	while(end>start){
		mid=(start+end)/2;
		if(lis[mid]>=target)
			end=mid;
		else
			start=mid+1;
	}
	return end;
}
int main (){
	
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		int a, b;
		scanf("%d %d", &a, &b);
		pole.push_back(make_pair(b, a));
	}
	sort(pole.begin(), pole.end());

	lis[0]=pole[0].second;
	record[0]=1;
	for(int i=1; i<n; i++){
		if(lis[len-1]<pole[i].second){
			lis[len++]=pole[i].second;
			record[i]=len;
		}else{
			int index=lowerbound(lis, len, pole[i].second);
			lis[index]=pole[i].second;
			record[i]=index+1;
		}
	}
	for(int i=n-1; i>=0; i--){
		if(record[i]==len){
			len--;
		}else{
			ans.push_back(pole[i].second);
		}
	}
	sort(ans.begin(), ans.end());
	printf("%ld\n",ans.size());
	for(int i=0; i<ans.size(); i++)
		printf("%d\n",ans[i]);

	return 0;
}


